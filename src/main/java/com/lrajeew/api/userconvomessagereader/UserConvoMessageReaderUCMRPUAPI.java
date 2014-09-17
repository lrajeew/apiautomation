package com.lrajeew.api.userconvomessagereader;

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

public class UserConvoMessageReaderUCMRPUAPI extends BaseAPI {
	private static UserConvoMessageReaderUCMRPUAPI apiCall;

	private UserConvoMessageReaderUCMRPUAPI() {
	}

	public static UserConvoMessageReaderUCMRPUAPI getInstance() {
		if (apiCall == null) {
			apiCall = new UserConvoMessageReaderUCMRPUAPI();
		}
		return apiCall;
	}

	private static Logger LOGGER = Logger.getLogger(UserConvoMessageReaderUCMRPUAPI.class);
	
	@Info(url="/users/<userId>/convos/<userConvoId>/messages/<convoMessageId>/readers/<userId>")
	public ClientResponse query(AuthenticationVO authData,
			AttendeeRequestVO requestVO, ResponseType responseType)
			throws IOException {
		AuthenticationResponseVO authResponse = Authenticator
				.authenticate(authData);
		String apiEndpoint = ApiConsatants.VIVA_API + "users/47593/convos/155/messages/222/readers/47593?"+ "rep="+responseType.getType();
		Client client = Client.create();
		WebResource webResource = client.resource(apiEndpoint);
		ClientResponse response = webResource
				.accept(MediaType.APPLICATION_JSON)
				.header("Authorization",
						authResponse.getTokenType() + " "
								+ authResponse.getAccessToken())
				.header("Content-Type", "application/json")
				.put(ClientResponse.class);
		return response;
	}

}
