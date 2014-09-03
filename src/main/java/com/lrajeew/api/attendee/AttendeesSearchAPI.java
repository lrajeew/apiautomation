package com.lrajeew.api.attendee;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.lrajeew.api.Authenticator;
import com.lrajeew.api.BaseAPI;
import com.lrajeew.model.AttendeeRequestVO;
import com.lrajeew.model.AuthenticationResponseVO;
import com.lrajeew.model.AuthenticationVO;
import com.lrajeew.model.Info;
import com.lrajeew.model.ResponseType;
import com.lrajeew.rest.APITest;
import com.lrajeew.util.ApiConsatants;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class AttendeesSearchAPI extends BaseAPI{
	
	private static Logger LOGGER = Logger.getLogger(AttendeesSearchAPI.class);
	private static AttendeesSearchAPI apiCall;
	
	private AttendeesSearchAPI(){		
	}
	
	public static AttendeesSearchAPI getInstance() {
		if (apiCall == null) {
			apiCall = new AttendeesSearchAPI();
		}
		return apiCall;
	}

	@Info(url="/events/<eventKey>/attendees?search=<search>&blockFrom=<blockFrom>&blockSize=<blockSize>")
	@Override
	public ClientResponse query(AuthenticationVO authData,
			AttendeeRequestVO requestVO, ResponseType responseType)
			throws IOException {
		AuthenticationResponseVO authResponse = Authenticator.authenticate(authData);
		String attendeeAPIEndPoint = ApiConsatants.VIVA_API + ApiConsatants.ATTENDEE_SEARCH_API + "rep="+responseType.getType();
		attendeeAPIEndPoint = attendeeAPIEndPoint.replace(ApiConsatants.EVENT_KEY, requestVO.getEventId())
												 .replace(ApiConsatants.SEARCH, requestVO.getSearch())
												 .replace(ApiConsatants.BLOCK_FROM, requestVO.getBlockFrom()+"")
												 .replace(ApiConsatants.BLOCK_SIZE, requestVO.getBlockSize()+"");
		Client client = Client.create();
		WebResource webResource = client.resource(attendeeAPIEndPoint);
		ClientResponse response = webResource.accept(
				MediaType.APPLICATION_JSON)
				.header("Authorization", authResponse.getTokenType() + " " + authResponse.getAccessToken())
				.get(ClientResponse.class);
		return response;
	}

}
