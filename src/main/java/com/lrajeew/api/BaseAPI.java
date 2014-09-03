package com.lrajeew.api;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.lrajeew.model.AttendeeRequestVO;
import com.lrajeew.model.AuthenticationVO;
import com.lrajeew.model.ResponseType;
import com.sun.jersey.api.client.ClientResponse;

public abstract class BaseAPI {
	
	private static Logger LOGGER = Logger.getLogger(BaseAPI.class);
	
	public abstract ClientResponse query(AuthenticationVO authData, AttendeeRequestVO requestVO, ResponseType responseType) throws IOException;
	
	public ClientResponse queryDefaultResponse(AuthenticationVO authData, AttendeeRequestVO requestVO) throws IOException{
		ClientResponse response = query(authData, requestVO, ResponseType.DEFAULT);
		return response;
	}
	
	public ClientResponse queryLiteResponse(AuthenticationVO authData, AttendeeRequestVO requestVO) throws IOException{
		ClientResponse response = query(authData, requestVO, ResponseType.LITE);
		return response;
	}
	
	public ClientResponse queryFullResponse(AuthenticationVO authData, AttendeeRequestVO requestVO) throws IOException{
		ClientResponse response = query(authData, requestVO, ResponseType.FULL);
		return response;
	}
	
	
}
