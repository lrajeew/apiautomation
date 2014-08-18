package com.lrajeew.api;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

import com.lrajeew.json.util.JsonUtil;
import com.lrajeew.model.AuthenticationResponseVO;
import com.lrajeew.model.AuthenticationVO;
import com.lrajeew.util.ApiConsatants;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

public class Authenticator {
	private static Logger LOGGER = Logger.getLogger(Authenticator.class);

	public static ClientResponse doAuthenticate(AuthenticationVO authData)
			throws UniformInterfaceException {
		LOGGER.info("Start Authentication Process");
		Client client = Client.create();
		String authenticationData;
		try {
			authenticationData = JsonUtil.objectToString(authData);
			String queryParams = JsonUtil.jsonToQueryParams(authenticationData);
			String endPointURL = new StringBuilder()
					.append(ApiConsatants.OAUTH).append(queryParams).toString();
			LOGGER.log(Priority.INFO, endPointURL);
			WebResource webResource = client.resource(endPointURL);
			ClientResponse response = webResource.accept(
					MediaType.APPLICATION_JSON).post(ClientResponse.class,
					authenticationData);

			return response;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static AuthenticationResponseVO authenticate(
			AuthenticationVO authData) throws IOException {
		LOGGER.info("Start Authentication Process");
		Client client = Client.create();
		String authenticationData;
		try {
			authenticationData = JsonUtil.objectToString(authData);
			String queryParams = JsonUtil.jsonToQueryParams(authenticationData);
			String endPointURL = new StringBuilder()
					.append(ApiConsatants.OAUTH).append(queryParams).toString();
			LOGGER.info(endPointURL);
			WebResource webResource = client.resource(endPointURL);
			ClientResponse response = webResource.accept(
					MediaType.APPLICATION_JSON).post(ClientResponse.class,
					authenticationData);
			String output = response.getEntity(String.class);
			AuthenticationResponseVO responseVO = new AuthenticationResponseVO();
			responseVO = (AuthenticationResponseVO) JsonUtil.stringToObject(
					output, responseVO);

			return responseVO;
		} catch (IOException e) {
			LOGGER.error("Exception occured : " + e.getMessage());
			throw new IOException(e.getMessage());
		}
	}
	
	public static AuthenticationResponseVO userAuthenticate(AuthenticationVO authData) throws IOException{
		LOGGER.info("Start Authentication Process");
		Client client = Client.create();
		String authenticationData;
		try {
			authenticationData = JsonUtil.objectToString(authData);
			String queryParams = JsonUtil.jsonToQueryParams(authenticationData);
			String endPointURL = new StringBuilder()
					.append(ApiConsatants.OAUTH)
					.append(queryParams)
					.toString();
			LOGGER.info(endPointURL);
			WebResource webResource = client.resource(endPointURL);
			ClientResponse response = webResource.accept(
					MediaType.APPLICATION_JSON)
					.post(ClientResponse.class,
					queryParams);
			String output = response.getEntity(String.class);
			AuthenticationResponseVO responseVO = new AuthenticationResponseVO();
			responseVO = (AuthenticationResponseVO) JsonUtil.stringToObject(
					output, responseVO);
			return responseVO;
		} catch (IOException e) {
			LOGGER.error("Exception occured : " + e.getMessage());
			throw new IOException(e.getMessage());
		}
	}

}
