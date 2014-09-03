package com.lrajeew.rest.regression.all;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.lrajeew.api.BaseAPI;
import com.lrajeew.json.util.JsonUtil;
import com.lrajeew.model.AttendeeRequestVO;
import com.lrajeew.model.AuthenticationVO;
import com.lrajeew.model.RegressionVO;
import com.lrajeew.util.ApiConsatants;
import com.lrajeew.util.FileHandler;
import com.sun.jersey.api.client.ClientResponse;

public class APITest {

	private static Logger LOGGER = Logger.getLogger(APITest.class);
	public BaseAPI instance ;
	
	public AuthenticationVO authData;
	public AttendeeRequestVO requestData;

	public static String DATA_FILE = "C:\\DWork\\Data\\AttendeesAPIData.txt";
	
	public String filePath = "";
	
	public void loadDataFromFile() throws IOException {
		RegressionVO regression = RegressionVO.getInstance();
		filePath = regression.getRegressionResultsPath();
	}

	@Before
	public void init() throws IOException {
		try {
			loadDataFromFile();
		} catch (IOException e) {
			throw e;
		}
	}

	@Test
	public void testDefultResponse() throws IOException {
		ClientResponse response =  instance.queryDefaultResponse(authData,
				requestData);
		String responseBody = response.getEntity(String.class);
		LOGGER.info(responseBody);
		filePath+= ApiConsatants.DEFAULT_FILE;
		FileHandler.writeToFile(filePath, JsonUtil.getJsonPrettyString(responseBody));
	}

	@Test
	public void testLiteResponse() throws IOException {
		ClientResponse response = instance.queryLiteResponse(authData, requestData);
		String responseBody = response.getEntity(String.class);
		LOGGER.info(responseBody);
		filePath+= ApiConsatants.LITE_FILE;
		FileHandler.writeToFile(filePath, JsonUtil.getJsonPrettyString(responseBody));
	}

	@Test
	public void testFullResponse() throws IOException {
		ClientResponse response = instance.queryFullResponse(authData, requestData);
		String responseBody = response.getEntity(String.class);
		LOGGER.info(responseBody);
		filePath+= ApiConsatants.FULL_FILE;
		FileHandler.writeToFile(filePath, JsonUtil.getJsonPrettyString(responseBody));
	}


}
