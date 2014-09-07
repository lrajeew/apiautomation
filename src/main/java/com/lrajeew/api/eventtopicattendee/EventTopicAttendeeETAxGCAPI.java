package com.lrajeew.api.eventtopicattendee;

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

public class EventTopicAttendeeETAxGCAPI extends BaseAPI {
	private static EventTopicAttendeeETAxGCAPI apiCall;

	private EventTopicAttendeeETAxGCAPI() {
	}

	public static EventTopicAttendeeETAxGCAPI getInstance() {
		if (apiCall == null) {
			apiCall = new EventTopicAttendeeETAxGCAPI();
		}
		return apiCall;
	}

	private static Logger LOGGER = Logger.getLogger(EventTopicAttendeeETAxGCAPI.class);
	
	@Info(url="/events/<eventKey>/topics/<topicKey>/attendees/<userId>,<userId>,..?ctx=true")
	public ClientResponse query(AuthenticationVO authData,
			AttendeeRequestVO requestVO, ResponseType responseType)
			throws IOException {
		AuthenticationResponseVO authResponse = Authenticator
				.authenticate(authData);
		String apiEndpoint = ApiConsatants.VIVA_API + "events/vivacon/topics/beer/attendees/47593,47535?ctx=true&"+ "rep="+responseType.getType();
		Client client = Client.create();
		WebResource webResource = client.resource(apiEndpoint);
		ClientResponse response = webResource
				.accept(MediaType.APPLICATION_JSON)
				.header("Authorization",
						authResponse.getTokenType() + " "
								+ authResponse.getAccessToken())
				.get(ClientResponse.class);
		return response;
	}

}
