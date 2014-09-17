package com.lrajeew.api.usertopic;

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

public class UserTopicUTxPOAPI extends BaseAPI {
	private static UserTopicUTxPOAPI apiCall;

	private UserTopicUTxPOAPI() {
	}

	public static UserTopicUTxPOAPI getInstance() {
		if (apiCall == null) {
			apiCall = new UserTopicUTxPOAPI();
		}
		return apiCall;
	}

	private static Logger LOGGER = Logger.getLogger(UserTopicUTxPOAPI.class);
	
	@Info(url="/users/<userId>/topics?ctx=true")
	public ClientResponse query(AuthenticationVO authData,
			AttendeeRequestVO requestVO, ResponseType responseType)
			throws IOException {
			String body ="{\"user\":\"47593\",\"topic\":\"beer\",\"sourceEvent\":\"vivacon\",\"isInterested\":\"true\",\"canHelp\":\"true\",\"wantsHelp\":\"false\"}";
		AuthenticationResponseVO authResponse = Authenticator
				.authenticate(authData);
		String apiEndpoint = ApiConsatants.VIVA_API + "users/47593/topics?ctx=true"+ "rep="+responseType.getType();
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
