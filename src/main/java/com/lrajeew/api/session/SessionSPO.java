package com.lrajeew.api.session;

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

public class SessionSPO extends BaseAPI {
	private static SessionSPO apiCall;

	private SessionSPO() {
	}

	public static SessionSPO getInstance() {
		if (apiCall == null) {
			apiCall = new SessionSPO();
		}
		return apiCall;
	}

	private static Logger LOGGER = Logger.getLogger(SessionSPO.class);
	
	@Info(url="/events/<eventKey>/sessions")
	public ClientResponse query(AuthenticationVO authData,
			AttendeeRequestVO requestVO, ResponseType responseType)
			throws IOException {
			String body ="{\"sessionKey\":\"APISession\",\"sessionProfile\":{\"sessionName\":\"API Session\",\"description\":\"API Session Description\",\"cityName\":\"Colombo\",\"venueName\":\"\",\"roomName\":\"\",\"start\":{\"dateTime\":[null]},\"end\":{\"dateTime\":[null]}}}";
			System.out.println(body);
		AuthenticationResponseVO authResponse = Authenticator
				.authenticate(authData);
		String apiEndpoint = ApiConsatants.VIVA_API + "events/vivacon/sessions?"+ "rep="+responseType.getType();
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
