package com.lrajeew.json.util;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.lrajeew.model.AuthenticationResponseVO;

public class JsonUtil {

	public static String objectToString(Object object)
			throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(object);
		return jsonString;
	}
	
	public static String objectToQueryParams(Object object)
			throws JsonGenerationException, JsonMappingException, IOException {		
		String queryParams = JsonUtil.jsonToQueryParams(JsonUtil.objectToString(object));
		return queryParams;
	}

	public static String jsonToQueryParams(String json)
			throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Map<String,String> map = new ObjectMapper().readValue(json, Map.class);
		
		StringBuilder queryString = new StringBuilder().append("?");
		for(Entry<String, String> entry :map.entrySet()){
			queryString.append(entry.getKey())
					   .append("=")
					   .append(entry.getValue())
					   .append("&");
		}
		
		return queryString.toString();
	}
	
	public static <T extends Object> T stringToObject(String jsonString, T t)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(t.getClass());
		t = (T) mapper.readValue(jsonString, t.getClass());	
		return t;
	}
	
	public static String getJsonPrettyString(String input) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		Object json = mapper.readValue(input, Object.class);
		String indented = mapper.defaultPrettyPrintingWriter().writeValueAsString(json);
		return indented;
	}

}
