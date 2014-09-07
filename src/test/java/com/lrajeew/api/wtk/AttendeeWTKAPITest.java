package com.lrajeew.api.wtk;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.lrajeew.json.util.JsonUtil;
import com.lrajeew.model.AttendeeRequestVO;
import com.lrajeew.model.AuthenticationVO;
import com.lrajeew.model.RegressionVO;
import com.lrajeew.util.APIAuthenticatorDataCreator;
import com.lrajeew.util.ApiConsatants;
import com.lrajeew.util.FileHandler;
import com.sun.jersey.api.client.ClientResponse;

public class AttendeeWTKAPITest {

	private static Logger LOGGER = Logger.getLogger(AttendeeWTKAPITest.class);
	static AttendeeWTKAPI instance ;
	
	static{
		instance = AttendeeWTKAPI.getInstance();
	}

	private AuthenticationVO authData;
	private AttendeeRequestVO requestData;

	private static String DATA_FILE = "C:\\DWork\\Data\\AttendeesAPIData.txt";
	private static String FILE_NAME_PREFIX = "AttendeeWTKAPI";
	String filePath = "";

	private void loadDataFromFile() throws IOException {

		Properties properties = FileHandler.readPropertyFile(DATA_FILE);

		requestData = new AttendeeRequestVO();
		requestData.setEventId(properties
				.getProperty(AttendeeRequestVO.EVENT_ID));
		requestData.setUserId(Long.parseLong(properties
				.getProperty(AttendeeRequestVO.PUT_USER_ID)));
	}

	@Before
	public void init() throws IOException {
		try {
			loadDataFromFile();
		} catch (IOException e) {
			throw e;
		}
		authData = APIAuthenticatorDataCreator.createClientAuthenticationVO();
		RegressionVO regression = RegressionVO.getInstance();
		filePath = regression.getRegressionResultsPath()+ FILE_NAME_PREFIX;
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
