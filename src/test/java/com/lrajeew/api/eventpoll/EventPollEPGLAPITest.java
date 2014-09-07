package com.lrajeew.api.eventpoll;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.lrajeew.api.event.EventEGAPI;
import com.lrajeew.api.event.EventEGCAPI;
import com.lrajeew.rest.regression.all.APITest;
import com.lrajeew.util.APIAuthenticatorDataCreator;

public class EventPollEPGLAPITest extends APITest{

	private static Logger LOGGER = Logger.getLogger(EventPollEPGLAPITest.class);
	
	private static String FILE_NAME_PREFIX = "EventPollEPGLAPI";

	@Override
	public void loadDataFromFile() throws IOException {
		super.loadDataFromFile();
		instance = EventPollEPGLAPI.getInstance();
		this.filePath += getClass().getSimpleName();	
		authData = APIAuthenticatorDataCreator.createUserAuthenticationVO();
	}
	
}
