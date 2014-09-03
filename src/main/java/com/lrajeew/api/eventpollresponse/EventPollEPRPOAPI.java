package com.lrajeew.api.eventpollresponse;

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

public class EventPollEPRPOAPI extends BaseAPI {
	private static EventPollEPRPOAPI apiCall;

	private EventPollEPRPOAPI() {
	}

	public static EventPollEPRPOAPI getInstance() {
		if (apiCall == null) {
			apiCall = new EventPollEPRPOAPI();
		}
		return apiCall;
	}

	private static Logger LOGGER = Logger.getLogger(EventPollEPRPOAPI.class);
	
	@Info(url="/events/<eventKey>/polls/<pollId>/responses")
	public ClientResponse query(AuthenticationVO authData,
			AttendeeRequestVO requestVO, ResponseType responseType)
			throws IOException {
		AuthenticationResponseVO authResponse = Authenticator
				.authenticate(authData);
		String body ="{\"selectedOptionIndex\":\"2\"}";
		String apiEndpoint = ApiConsatants.VIVA_API + "/events/vivacon/polls/18/responses?" + "rep="+responseType.getType();
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
