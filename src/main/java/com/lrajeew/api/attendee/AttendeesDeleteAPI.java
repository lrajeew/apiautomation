package com.lrajeew.api.attendee;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.lrajeew.api.Authenticator;
import com.lrajeew.api.BaseAttendeesAPI;
import com.lrajeew.model.AttendeeRequestVO;
import com.lrajeew.model.AuthenticationResponseVO;
import com.lrajeew.model.AuthenticationVO;
import com.lrajeew.model.Info;
import com.lrajeew.model.ResponseType;
import com.lrajeew.util.ApiConsatants;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class AttendeesDeleteAPI extends BaseAttendeesAPI{
	
	private static Logger LOGGER = Logger.getLogger(AttendeesDeleteAPI.class);
	private static AttendeesDeleteAPI apiCall;
	
	private AttendeesDeleteAPI(){		
	}
	
	public static AttendeesDeleteAPI getInstance() {
		if (apiCall == null) {
			apiCall = new AttendeesDeleteAPI();
		}
		return apiCall;
	}

	@Info(url="/events/<eventKey>/attendees/<userId>")
	@Override
	public ClientResponse query(AuthenticationVO authData,
			AttendeeRequestVO requestVO, ResponseType responseType)
			throws IOException {
		AuthenticationResponseVO authResponse = Authenticator.userAuthenticate(authData);
		String attendeeAPIEndPoint = ApiConsatants.VIVA_API + ApiConsatants.ATTENDEE_DELETE_API + "rep="+responseType.getType();
		attendeeAPIEndPoint = attendeeAPIEndPoint.replace(ApiConsatants.EVENT_KEY, requestVO.getEventId())
												 .replace(ApiConsatants.USER_ID, requestVO.getUserId()+"");
		Client client = Client.create();
		WebResource webResource = client.resource(attendeeAPIEndPoint);
		ClientResponse response = webResource.accept(
				MediaType.APPLICATION_JSON)
				.header("Authorization", authResponse.getTokenType() + " " + authResponse.getAccessToken())
				.delete(ClientResponse.class);
		
		return response;
	}

}
