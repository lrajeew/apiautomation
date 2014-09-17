package com.lrajeew.api.userfollow;

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

public class UserFollowUFwDEAPI extends BaseAPI {
	private static UserFollowUFwDEAPI apiCall;

	private UserFollowUFwDEAPI() {
	}

	public static UserFollowUFwDEAPI getInstance() {
		if (apiCall == null) {
			apiCall = new UserFollowUFwDEAPI();
		}
		return apiCall;
	}

	private static Logger LOGGER = Logger.getLogger(UserFollowUFwDEAPI.class);
	
	@Info(url="/users/<userId>/follows/<userToUnfollowId>?for=user")
	public ClientResponse query(AuthenticationVO authData,
			AttendeeRequestVO requestVO, ResponseType responseType)
			throws IOException {
			
		AuthenticationResponseVO authResponse = Authenticator
				.authenticate(authData);
		String apiEndpoint = ApiConsatants.VIVA_API + "users/47593/follows/1?for=user&"+ "rep="+responseType.getType();
		Client client = Client.create();
		WebResource webResource = client.resource(apiEndpoint);
		ClientResponse response = webResource
				.accept(MediaType.APPLICATION_JSON)
				.header("Authorization",
						authResponse.getTokenType() + " "
								+ authResponse.getAccessToken())
				.header("Content-Type", "application/json")
				.delete(ClientResponse.class);
		return response;
	}

}
