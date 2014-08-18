package com.lrajeew.rest.regression.attendees;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.lrajeew.api.attendee.AttendeesPutAPI;
import com.lrajeew.model.AttendeeRequestVO;
import com.lrajeew.model.AuthenticationVO;
import com.lrajeew.model.ClientAuthenticationVO;
import com.lrajeew.util.FileHandler;

public class AttendeesPutAPITest {

	private static Logger LOGGER = Logger.getLogger(AttendeesPutAPITest.class);

	private AuthenticationVO authData;
	private AttendeeRequestVO requestData;

	private static String DATA_FILE = "C:\\DWork\\Data\\AttendeesAPIData.txt";
	private static String FILE_NAME_PREFIX = "AttendeesAPI";

	private void loadDataFromFile() throws IOException {

		Properties properties = FileHandler.readPropertyFile(DATA_FILE);
		authData = new AuthenticationVO();
		authData.setClientId(properties.getProperty(ClientAuthenticationVO.CLIENT_ID));
		authData.setClientSecret(properties
				.getProperty(ClientAuthenticationVO.CLIENT_SECRET));
		authData.setGrantType(properties
				.getProperty(ClientAuthenticationVO.GRANT_TYPE));
		authData.setUsername(properties
				.getProperty(ClientAuthenticationVO.USERNAME));
		authData.setPassword(properties
				.getProperty(ClientAuthenticationVO.PASSWORD));

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
	}

	@Test
	public void testDefultResponse() throws IOException {
		AttendeesPutAPI.getInstance().queryDefaultResponse(authData,
				requestData);
	}

	@Test
	public void testLiteResponse() throws IOException {
		AttendeesPutAPI.getInstance().queryLiteResponse(authData, requestData);
	}

	@Test
	public void testFullResponse() throws IOException {
		AttendeesPutAPI.getInstance().queryFullResponse(authData, requestData);
	}

}
