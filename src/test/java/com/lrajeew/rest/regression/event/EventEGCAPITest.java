package com.lrajeew.rest.regression.event;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.lrajeew.api.event.EventEGAPI;
import com.lrajeew.api.event.EventEGCAPI;
import com.lrajeew.rest.regression.all.APITest;
import com.lrajeew.util.APIAuthenticatorDataCreator;

public class EventEGCAPITest extends APITest{

	private static Logger LOGGER = Logger.getLogger(EventEGCAPITest.class);
	
	private static String FILE_NAME_PREFIX = "EventEGCAPI";

	@Override
	public void loadDataFromFile() throws IOException {
		super.loadDataFromFile();
		instance = EventEGCAPI.getInstance();
		this.filePath += FILE_NAME_PREFIX;	
		authData = APIAuthenticatorDataCreator.createSuperUserAuthenticationVO();
	}
	
}
