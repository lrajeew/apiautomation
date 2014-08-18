package com.lrajeew.rest.regression.all;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.lrajeew.api.all.AttendeeSessionAPI;
import com.lrajeew.api.attendee.AttendeeByEmailAPI;
import com.lrajeew.api.attendee.AttendeesByIdAPI;
import com.lrajeew.model.AttendeeRequestVO;
import com.lrajeew.model.AuthenticationVO;
import com.lrajeew.util.FileHandler;

public class AttendeeSessionAPITest {

	private static Logger LOGGER = Logger.getLogger(AttendeeSessionAPITest.class);

	private AuthenticationVO authData;
	private AttendeeRequestVO requestData;

	private static String DATA_FILE = "C:\\DWork\\Data\\AttendeesAPIData.txt";
	private static String FILE_NAME_PREFIX = "AttendeesAPI";

	private void loadDataFromFile() throws IOException {

		Properties properties = FileHandler.readPropertyFile(DATA_FILE);
		authData = new AuthenticationVO();
		authData.setClientId(properties.getProperty(AuthenticationVO.CLIENT_ID));
		authData.setClientSecret(properties
				.getProperty(AuthenticationVO.CLIENT_SECRET));
		authData.setGrantType(properties
				.getProperty(AuthenticationVO.GRANT_TYPE));

		requestData = new AttendeeRequestVO();
		requestData.setEventId(properties
				.getProperty(AttendeeRequestVO.EVENT_ID));
		requestData.setUserId(Long.parseLong(properties
				.getProperty(AttendeeRequestVO.USER_ID)));
		requestData.setEmail(properties
				.getProperty(AttendeeRequestVO.EMAIL));

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
		AttendeeSessionAPI.getInstance().queryDefaultResponse(authData,
				requestData);
	}

	@Test
	public void testLiteResponse() throws IOException {
		AttendeeSessionAPI.getInstance().queryLiteResponse(authData, requestData);
	}

	@Test
	public void testFullResponse() throws IOException {
		AttendeeSessionAPI.getInstance().queryFullResponse(authData, requestData);
	}

}
