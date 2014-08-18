package com.lrajeew.api.attendee;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.lrajeew.api.Authenticator;
import com.lrajeew.model.AttendeeRequestVO;
import com.lrajeew.model.AuthenticationResponseVO;
import com.lrajeew.model.AuthenticationVO;
import com.lrajeew.model.ResponseType;
import com.lrajeew.util.ApiConsatants;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class AttendeesByIdAPI {

	private static Logger LOGGER = Logger.getLogger(AttendeesByIdAPI.class);
	private static AttendeesByIdAPI apiCall;
	
	private AttendeesByIdAPI(){		
	}
	
	public static AttendeesByIdAPI getInstance() {
		if (apiCall == null) {
			apiCall = new AttendeesByIdAPI();
		}
		return apiCall;
	}
	
	public void queryDefaultResponse(AuthenticationVO authData, AttendeeRequestVO requestVO) throws IOException{
		ClientResponse response = query(authData, requestVO, ResponseType.DEFAULT);
		LOGGER.info("queryDefaultResponse" + response.getEntity(String.class));
	}
	
	public void queryLiteResponse(AuthenticationVO authData, AttendeeRequestVO requestVO) throws IOException{
		ClientResponse response = query(authData, requestVO, ResponseType.LITE);
		LOGGER.info("queryLiteResponse" + response.getEntity(String.class));
	}
	
	public void queryFullResponse(AuthenticationVO authData, AttendeeRequestVO requestVO) throws IOException{
		ClientResponse response = query(authData, requestVO, ResponseType.FULL);
		LOGGER.info("queryFullResponse" + response.getEntity(String.class));
	}
	
	public ClientResponse query(AuthenticationVO authData, AttendeeRequestVO requestVO, ResponseType responseType) throws IOException{
		AuthenticationResponseVO authResponse = Authenticator.authenticate(authData);
		String attendeeAPIEndPoint = ApiConsatants.VIVA_API + ApiConsatants.ATTENDEE_BY_ID_API + "rep="+responseType.getType();
		attendeeAPIEndPoint = attendeeAPIEndPoint.replace("<event_id>", requestVO.getEventId())
												 .replace("<user_id>", requestVO.getUserId()+"");
		Client client = Client.create();
		WebResource webResource = client.resource(attendeeAPIEndPoint);
		ClientResponse response = webResource.accept(
				MediaType.APPLICATION_JSON)
				.header("Authorization", authResponse.getTokenType() + " " + authResponse.getAccessToken())
				.get(ClientResponse.class);
		//LOGGER.info("queryDefaultResponse" + response.getEntity(String.class));
		return response;
	}
		
	
}
