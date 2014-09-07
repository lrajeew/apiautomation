package com.lrajeew.api.sessionpoll;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.lrajeew.api.Authenticator;
import com.lrajeew.api.BaseAPI;
import com.lrajeew.api.attendee.AttendeeByEmailAPI;
import com.lrajeew.model.AttendeeRequestVO;
import com.lrajeew.model.AuthenticationResponseVO;
import com.lrajeew.model.AuthenticationVO;
import com.lrajeew.model.Info;
import com.lrajeew.model.ResponseType;
import com.lrajeew.util.ApiConsatants;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class SessionPollSPPOAPI extends BaseAPI {
	private static SessionPollSPPOAPI apiCall;

	private SessionPollSPPOAPI() {
	}

	public static SessionPollSPPOAPI getInstance() {
		if (apiCall == null) {
			apiCall = new SessionPollSPPOAPI();
		}
		return apiCall;
	}

	private static Logger LOGGER = Logger.getLogger(SessionPollSPPOAPI.class);
	
	@Info(url="/events/<eventKey>/session/<sessionKey>/polls")
	public ClientResponse query(AuthenticationVO authData,
			AttendeeRequestVO requestVO, ResponseType responseType)
			throws IOException {
			String body ="{\"question\":\"How was the Breakfast ?\",\"options\":[\"OK\",\"Good\",\"Bad\"]}";
		AuthenticationResponseVO authResponse = Authenticator
				.authenticate(authData);
		String apiEndpoint = ApiConsatants.VIVA_API + "events/vivacon/session/breakfast/polls?"+ "rep="+responseType.getType();
		Client client = Client.create();
		WebResource webResource = client.resource(apiEndpoint);
		ClientResponse response = webResource
				.accept(MediaType.APPLICATION_JSON)
				.header("Authorization",
						authResponse.getTokenType() + " "
								+ authResponse.getAccessToken())
				.header("Content-Type", "application/json")
				.post(ClientResponse.class, body);
		return response;
	}

}
