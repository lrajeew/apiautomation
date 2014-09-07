package com.lrajeew.api.streamitemcomment;

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

public class StreamItemCommentStrICPOAPI extends BaseAPI {
	private static StreamItemCommentStrICPOAPI apiCall;

	private StreamItemCommentStrICPOAPI() {
	}

	public static StreamItemCommentStrICPOAPI getInstance() {
		if (apiCall == null) {
			apiCall = new StreamItemCommentStrICPOAPI();
		}
		return apiCall;
	}

	private static Logger LOGGER = Logger.getLogger(StreamItemCommentStrICPOAPI.class);
	
	@Info(url="/streams/<streamId>/items/<itemUuid>/comments")
	public ClientResponse query(AuthenticationVO authData,
			AttendeeRequestVO requestVO, ResponseType responseType)
			throws IOException {
			String body ="{\"commentTex\":\"API Comment\"}";
		AuthenticationResponseVO authResponse = Authenticator
				.authenticate(authData);
		String apiEndpoint = ApiConsatants.VIVA_API + "streams/8/items/0d211037-813e-4fd0-96c7-4be57bd5690a/comments?"+ "rep="+responseType.getType();
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
