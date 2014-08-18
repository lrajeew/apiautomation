package com.lrajeew.rest;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import com.lrajeew.model.AuthenticationResponseVO;

public class JsonUtilTest {

	@Test
	public void stringToObject() throws JsonParseException, JsonMappingException, IOException{
		String json = "{ \"access_token\": \"34a17838-3167-4139-82c6-531ef48b5e54\", \"expires_in\":604799, \"token_type\": \"bearer\" }";
		ObjectMapper mapper = new ObjectMapper();
		AuthenticationResponseVO response = mapper.readValue(json, AuthenticationResponseVO.class);
		System.out.println();
		
	}
	
}
