﻿package com.lrajeew.api.sessionattendee;

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

public class SessionAttendeeSAPUAPI extends BaseAPI {
	private static SessionAttendeeSAPUAPI apiCall;

	private SessionAttendeeSAPUAPI() {
	}

	public static SessionAttendeeSAPUAPI getInstance() {
		if (apiCall == null) {
			apiCall = new SessionAttendeeSAPUAPI();
		}
		return apiCall;
	}

	private static Logger LOGGER = Logger.getLogger(SessionAttendeeSAPUAPI.class);
	
	@Info(url="/events/<eventKey>/sessions/<sessionKey>/attendees/<userId>")
	public ClientResponse query(AuthenticationVO authData,
			AttendeeRequestVO requestVO, ResponseType responseType)
			throws IOException {
			String body ="{}";
		AuthenticationResponseVO authResponse = Authenticator
				.authenticate(authData);
		String apiEndpoint = ApiConsatants.VIVA_API + "events/vivacon/sessions/breakfast/attendees/47593?for=user&"+ "rep="+responseType.getType();
		Client client = Client.create();
		WebResource webResource = client.resource(apiEndpoint);
		ClientResponse response = webResource
				.accept(MediaType.APPLICATION_JSON)
				.header("Authorization",
						authResponse.getTokenType() + " "
								+ authResponse.getAccessToken())
				.header("Content-Type", "application/json")
				.put(ClientResponse.class, body);
		return response;
	}

}
