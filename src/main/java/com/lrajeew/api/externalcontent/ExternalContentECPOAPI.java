package com.lrajeew.api.externalcontent;

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

public class ExternalContentECPOAPI extends BaseAPI {
	private static ExternalContentECPOAPI apiCall;

	private ExternalContentECPOAPI() {
	}

	public static ExternalContentECPOAPI getInstance() {
		if (apiCall == null) {
			apiCall = new ExternalContentECPOAPI();
		}
		return apiCall;
	}

	private static Logger LOGGER = Logger.getLogger(ExternalContentECPOAPI.class);
	
	@Info(url="/external-content")
	public ClientResponse query(AuthenticationVO authData,
			AttendeeRequestVO requestVO, ResponseType responseType)
			throws IOException {
			String body ="{\"assetUrl\":\"http://www.slideshare.net/ruturajd/selenium-presentation-740594\",\"caption\":\"API External Content\",\"description\":\"API External Content Desc\"}";
		AuthenticationResponseVO authResponse = Authenticator
				.authenticate(authData);
		String apiEndpoint = ApiConsatants.VIVA_API + "external-content?"+ "rep="+responseType.getType();
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
