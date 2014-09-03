package com.lrajeew.api.upf;

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

public class UserPassworgForgotAPI extends BaseAPI {
	private static UserPassworgForgotAPI apiCall;

	private UserPassworgForgotAPI() {
	}

	public static UserPassworgForgotAPI getInstance() {
		if (apiCall == null) {
			apiCall = new UserPassworgForgotAPI();
		}
		return apiCall;
	}

	private static Logger LOGGER = Logger.getLogger(AttendeeByEmailAPI.class);

	public ClientResponse query(AuthenticationVO authData,
			AttendeeRequestVO requestVO, ResponseType responseType)
			throws IOException {
		String body ="{\"emailAddress\":\"lahirua@live.com\"}";
		AuthenticationResponseVO authResponse = Authenticator
				.authenticate(authData);
		String apiEndpoint = "http://dev.mob.vivastream.com/v2/forgot-password?emailAddress=lahirua@live.com";
		System.out.println(body);
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
