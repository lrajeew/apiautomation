package com.lrajeew.model;

import java.io.IOException;
import java.util.Properties;

import com.lrajeew.rest.APITestConstants;
import com.lrajeew.util.FileHandler;

public class RegressionVO {
	
	public static final String REGRESSION_NAME = "regression.name";
	public static final String REGRESSION_ENVIRONMENT = "regression.environment";
	public static final String PREVIOUS_REGRESSION_NAME = "previousregression.name";
	public static final String REGRESSION_DATA_PATH = "regression.datapath";
	public static final String REGRESSION_RESULTS_PATH = "regression.resultpath";
	public static final String PREVIOUS_REGRESSION_RESULTS_PATH = "regression.previousresultpath";		
	
	private String regressionName;
	private String previousRegressionName;
	private String regressionEnvironment;
	private String regressionDataPath;
	private String regressionResultsPath;
	private String previousRegressionResultsPath;
	
	private static RegressionVO instance;
	
	private RegressionVO(){
		
	}
	
	public static RegressionVO getInstance() throws IOException{
		if(instance != null){
			return instance;
		}
		else{
			Properties properties = FileHandler.readPropertyFile(APITestConstants.REGRESSION_FILE_PATH);
			instance = new RegressionVO();
			instance.setRegressionResultsPath(properties.getProperty(RegressionVO.REGRESSION_RESULTS_PATH));
			instance.setRegressionName(properties.getProperty(RegressionVO.REGRESSION_NAME));
			return instance;
		}
	}
	
	
	public String getRegressionName() {
		return regressionName;
	}
	public void setRegressionName(String regressionName) {
		this.regressionName = regressionName;
	}
	public String getPreviousRegressionName() {
		return previousRegressionName;
	}
	public void setPreviousRegressionName(String previousRegressionName) {
		this.previousRegressionName = previousRegressionName;
	}
	public String getRegressionEnvironment() {
		return regressionEnvironment;
	}
	public void setRegressionEnvironment(String regressionEnvironment) {
		this.regressionEnvironment = regressionEnvironment;
	}
	public String getRegressionDataPath() {
		return regressionDataPath;
	}
	public void setRegressionDataPath(String regressionDataPath) {
		this.regressionDataPath = regressionDataPath;
	}
	public String getRegressionResultsPath() {
		return regressionResultsPath;
	}
	public void setRegressionResultsPath(String regressionResultsPath) {
		this.regressionResultsPath = regressionResultsPath;
	}
	public String getPreviousRegressionResultsPath() {
		return previousRegressionResultsPath;
	}
	public void setPreviousRegressionResultsPath(
			String previousRegressionResultsPath) {
		this.previousRegressionResultsPath = previousRegressionResultsPath;
	}

}
