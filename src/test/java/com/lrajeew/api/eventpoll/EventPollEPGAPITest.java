package com.lrajeew.api.eventpoll;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.lrajeew.api.event.EventEGAPI;
import com.lrajeew.api.event.EventEGCAPI;
import com.lrajeew.rest.regression.all.APITest;
import com.lrajeew.util.APIAuthenticatorDataCreator;

public class EventPollEPGAPITest extends APITest{

	private static Logger LOGGER = Logger.getLogger(EventPollEPGAPITest.class);
	
	private static String FILE_NAME_PREFIX = "EventPollEPGAPI";

	@Override
	public void loadDataFromFile() throws IOException {
		super.loadDataFromFile();
		instance = EventPollEPGAPI.getInstance();
		this.filePath += getClass().getSimpleName();	
		authData = APIAuthenticatorDataCreator.createUserAuthenticationVO();
	}
	
}
