package com.lrajeew.api.eventpoll;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.lrajeew.api.event.EventEGAPI;
import com.lrajeew.api.event.EventEGCAPI;
import com.lrajeew.rest.regression.all.APITest;
import com.lrajeew.util.APIAuthenticatorDataCreator;

public class EventPollEPGCAPITest extends APITest{

	private static Logger LOGGER = Logger.getLogger(EventPollEPGCAPITest.class);
	
	private static String FILE_NAME_PREFIX = "EventPollEPGCAP";

	@Override
	public void loadDataFromFile() throws IOException {
		super.loadDataFromFile();
		instance = EventPollEPGCAPI.getInstance();
		this.filePath += getClass().getSimpleName();	
		authData = APIAuthenticatorDataCreator.createUserAuthenticationVO();
	}
	
}
