package com.lrajeew.rest.regression.event;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.lrajeew.api.event.EventEGLAPI;
import com.lrajeew.rest.regression.all.APITest;
import com.lrajeew.util.APIAuthenticatorDataCreator;

public class EventEGLAPITest extends APITest{

	private static Logger LOGGER = Logger.getLogger(EventEGLAPITest.class);
	
	private static String FILE_NAME_PREFIX = "EventEGLAPI";

	@Override
	public void loadDataFromFile() throws IOException {
		super.loadDataFromFile();
		instance = EventEGLAPI.getInstance();
		this.filePath += FILE_NAME_PREFIX;	
		authData = APIAuthenticatorDataCreator.crateSuperUserAuthenticationVO();
	}
	
}
