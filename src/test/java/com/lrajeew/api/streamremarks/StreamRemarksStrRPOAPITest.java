﻿package com.lrajeew.api.streamremarks;

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
import com.lrajeew.json.util.JsonUtil;
import com.lrajeew.model.AttendeeRequestVO;
import com.lrajeew.model.AuthenticationVO;
import com.lrajeew.model.ClientAuthenticationVO;
import com.lrajeew.rest.regression.all.APITest;
import com.lrajeew.util.APIAuthenticatorDataCreator;
import com.lrajeew.util.ApiConsatants;
import com.lrajeew.util.FileHandler;
import com.sun.jersey.api.client.ClientResponse;

public class StreamRemarksStrRPOAPITest extends APITest{

	private static Logger LOGGER = Logger.getLogger(StreamRemarksStrRPOAPITest.class);
	
	private static String FILE_NAME_PREFIX = "StreamRemarksStrRPOAPI";

	@Override
	public void loadDataFromFile() throws IOException {
		super.loadDataFromFile();
		instance = StreamRemarksStrRPOAPI.getInstance();
		this.filePath += FILE_NAME_PREFIX;	
		authData = APIAuthenticatorDataCreator.createClientAuthenticationVO();
	}
	
	@Override
	public void testFullResponse() throws IOException {
		// Do nothing
	}
	
	@Override
	public void testLiteResponse() throws IOException {
		// Do nothing
	}
}
