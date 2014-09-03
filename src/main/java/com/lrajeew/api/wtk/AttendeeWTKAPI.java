package com.lrajeew.api.wtk;

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

public class AttendeeWTKAPI extends BaseAPI {
	private static AttendeeWTKAPI apiCall;

	private AttendeeWTKAPI() {
	}

	public static AttendeeWTKAPI getInstance() {
		if (apiCall == null) {
			apiCall = new AttendeeWTKAPI();
		}
		return apiCall;
	}

	private static Logger LOGGER = Logger.getLogger(AttendeeWTKAPI.class);

	@Info(url="/events/<eventkey>/attendees/<userId>/wtk-pairings")
	public ClientResponse query(AuthenticationVO authData,
			AttendeeRequestVO requestVO, ResponseType responseType)
			throws IOException {
		AuthenticationResponseVO authResponse = Authenticator
				.authenticate(authData);
		String apiEndpoint = ApiConsatants.VIVA_API + "events/vivacon/attendees/47593/wtk-pairings?"+ "rep="+responseType.getType();
		LOGGER.info(apiEndpoint);
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
