package com.lrajeew.api.all;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.lrajeew.api.Authenticator;
import com.lrajeew.api.BaseAPI;
import com.lrajeew.api.attendee.AttendeeByEmailAPI;
import com.lrajeew.model.AttendeeRequestVO;
import com.lrajeew.model.AuthenticationResponseVO;
import com.lrajeew.model.AuthenticationVO;
import com.lrajeew.model.ResponseType;
import com.lrajeew.util.ApiConsatants;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class AttendeeTopicDeleteAPI extends BaseAPI {
	private static AttendeeTopicDeleteAPI apiCall;

	private AttendeeTopicDeleteAPI() {
	}

	public static AttendeeTopicDeleteAPI getInstance() {
		if (apiCall == null) {
			apiCall = new AttendeeTopicDeleteAPI();
		}
		return apiCall;
	}

	private static Logger LOGGER = Logger.getLogger(AttendeeByEmailAPI.class);

	public ClientResponse query(AuthenticationVO authData,
			AttendeeRequestVO requestVO, ResponseType responseType)
			throws IOException {
		AuthenticationResponseVO authResponse = Authenticator
				.userAuthenticate(authData);
		
		String apiEndpoint = "http://dev.mob.vivastream.com/v2/events/vivacon/attendees/47593/topics/beer?for=topic&"+ "rep="+responseType.getType();
		Client client = Client.create();
		WebResource webResource = client.resource(apiEndpoint);
		ClientResponse response = webResource
				.accept(MediaType.APPLICATION_JSON)
				.header("Authorization",
						authResponse.getTokenType() + " "
								+ authResponse.getAccessToken())
				.delete(ClientResponse.class);
		return response;
	}

}
