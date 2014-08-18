package com.lrajeew.api;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.lrajeew.model.AttendeeRequestVO;
import com.lrajeew.model.AuthenticationVO;
import com.lrajeew.model.ResponseType;
import com.sun.jersey.api.client.ClientResponse;

public abstract class BaseAttendeesAPI {
	
	private static Logger LOGGER = Logger.getLogger(BaseAttendeesAPI.class);
	
	public abstract ClientResponse query(AuthenticationVO authData, AttendeeRequestVO requestVO, ResponseType responseType) throws IOException;
	
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
	
	
}
