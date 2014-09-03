package com.lrajeew.rest.regression.all;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Before;

import com.lrajeew.json.util.JsonUtil;
import com.lrajeew.model.RegressionVO;
import com.lrajeew.util.FileHandler;
import com.sun.jersey.api.client.ClientResponse;

public class BaseAPITest {
	
	public String filePath = "";
	public RegressionVO regression ;
	
	private static Logger LOGGER = Logger.getLogger(BaseAPITest.class);
	
	@Before
	public void loadRegressionData() throws IOException{
		regression = RegressionVO.getInstance();
		filePath = regression.getRegressionResultsPath();
	}
		
	public void saveToFile(ClientResponse response, String responseType) throws IOException{
		String responseBody = response.getEntity(String.class);
		LOGGER.info(responseBody);
		filePath+= responseType;
		FileHandler.writeToFile(filePath, JsonUtil.getJsonPrettyString(responseBody));
	}

}
