package com.lrajeew.api.streamitem;

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

public class StreamItemStrIGLAPI extends BaseAPI {
	private static StreamItemStrIGLAPI apiCall;

	private StreamItemStrIGLAPI() {
	}

	public static StreamItemStrIGLAPI getInstance() {
		if (apiCall == null) {
			apiCall = new StreamItemStrIGLAPI();
		}
		return apiCall;
	}

	private static Logger LOGGER = Logger.getLogger(StreamItemStrIGLAPI.class);
	
	@Info(url="/streams/<streamId>/items?[num=<num>][&start=<start>][&dir=<dir>]")
	public ClientResponse query(AuthenticationVO authData,
			AttendeeRequestVO requestVO, ResponseType responseType)
			throws IOException {
		AuthenticationResponseVO authResponse = Authenticator
				.authenticate(authData);
		String apiEndpoint = ApiConsatants.VIVA_API + "streams/8/items?num=&start=&dir=&"+ "rep="+responseType.getType();
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
