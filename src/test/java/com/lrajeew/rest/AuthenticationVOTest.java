package com.lrajeew.rest;

import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import com.lrajeew.api.Authenticator;
import com.lrajeew.json.util.JsonUtil;
import com.lrajeew.model.AuthenticationResponseVO;
import com.lrajeew.model.AuthenticationVO;
import com.sun.jersey.api.client.ClientResponse;

public class AuthenticationVOTest {
	
	private AuthenticationVO authenticationVO;
	private static Logger LOGGER = Logger.getLogger(AuthenticationVOTest.class);
	
	@Before
	public void init(){
		authenticationVO = new AuthenticationVO();
		authenticationVO.setClientId("vs-client");
		authenticationVO.setClientSecret("supersecret");
		authenticationVO.setGrantType("client_credentials");
		authenticationVO.setUsername("lahirua@live.com");
		authenticationVO.setPassword("vivastream");
	}
	
	//@Test
	public void testAuthenticatorVO() throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		ClientResponse response = Authenticator.doAuthenticate(authenticationVO);
		//LOGGER.info(response.getStatus());		
		String output = response.getEntity(String.class);
		AuthenticationResponseVO responseVO = new AuthenticationResponseVO();
		responseVO = (AuthenticationResponseVO)JsonUtil.stringToObject(output, responseVO);
		
	}
	
	@Test
	public void testAuthenticateUser() throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		AuthenticationResponseVO response = Authenticator.userAuthenticate(authenticationVO);		
		System.out.println();
	}
	
	
}
