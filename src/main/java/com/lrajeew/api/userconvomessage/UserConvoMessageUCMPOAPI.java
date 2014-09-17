package com.lrajeew.api.userconvomessage;

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

public class UserConvoMessageUCMPOAPI extends BaseAPI {
	private static UserConvoMessageUCMPOAPI apiCall;

	private UserConvoMessageUCMPOAPI() {
	}

	public static UserConvoMessageUCMPOAPI getInstance() {
		if (apiCall == null) {
			apiCall = new UserConvoMessageUCMPOAPI();
		}
		return apiCall;
	}

	private static Logger LOGGER = Logger.getLogger(UserConvoMessageUCMPOAPI.class);
	
	@Info(url="/users/<userId>/convos/<userConvoId>/messages")
	public ClientResponse query(AuthenticationVO authData,
			AttendeeRequestVO requestVO, ResponseType responseType)
			throws IOException {
			String body ="{\"content\":\"API Convo\"}";
		AuthenticationResponseVO authResponse = Authenticator
				.authenticate(authData);
		String apiEndpoint = ApiConsatants.VIVA_API + "users/47593/convos/155/messages?"+ "rep="+responseType.getType();
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
