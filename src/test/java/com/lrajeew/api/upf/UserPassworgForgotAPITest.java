package com.lrajeew.api.upf;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.lrajeew.api.BaseAPI;
import com.lrajeew.api.all.AttendeeTopicByTopicKeyAPI;
import com.lrajeew.api.all.AttendeeTopicDeleteAPI;
import com.lrajeew.api.atus.AttendeeTopicUserStatsAPI;
import com.lrajeew.api.event.EventEGAPI;
import com.lrajeew.api.event.EventEGCAPI;
import com.lrajeew.model.AttendeeRequestVO;
import com.lrajeew.model.AuthenticationVO;
import com.lrajeew.model.ClientAuthenticationVO;
import com.lrajeew.util.FileHandler;

public class UserPassworgForgotAPITest {

	private static Logger LOGGER = Logger.getLogger(UserPassworgForgotAPITest.class);
	static BaseAPI instance ;
	
	static{
		instance = UserPassworgForgotAPI.getInstance();
	}

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
				.getProperty(AuthenticationVO.GRANT_TYPE));

		requestData = new AttendeeRequestVO();
		requestData.setEventId(AttendeeRequestVO.EVENT_ID);

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
		instance.queryDefaultResponse(authData,
				requestData);
	}

	//@Test
	public void testLiteResponse() throws IOException {
		instance.queryLiteResponse(authData, requestData);
	}

	//@Test
	public void testFullResponse() throws IOException {
		instance.queryFullResponse(authData, requestData);
	}

}
