package com.lrajeew.util;

import java.io.IOException;
import java.util.Properties;

import com.lrajeew.model.AuthenticationVO;
import com.lrajeew.model.ClientAuthenticationVO;

public class APIAuthenticatorDataCreator {

	private static String DATA_FILE = "C:\\DWork\\Data\\AttendeesAPIData.txt";

	public static AuthenticationVO createSuperUserAuthenticationVO()
			throws IOException {
		AuthenticationVO authData = new AuthenticationVO();
		Properties properties = FileHandler.readPropertyFile(DATA_FILE);
		authData = new AuthenticationVO();
		authData.setClientId(properties
				.getProperty(ClientAuthenticationVO.CLIENT_ID));
		authData.setClientSecret(properties
				.getProperty(ClientAuthenticationVO.CLIENT_SECRET));
		authData.setGrantType(properties
				.getProperty(AuthenticationVO.GRANT_TYPE));

		return authData;
	}

	public static AuthenticationVO createUserAuthenticationVO()
			throws IOException {
		AuthenticationVO authData = new AuthenticationVO();
		Properties properties = FileHandler.readPropertyFile(DATA_FILE);
		authData = new AuthenticationVO();
		authData.setClientId(properties.getProperty(AuthenticationVO.CLIENT_ID));
		authData.setClientSecret(properties
				.getProperty(AuthenticationVO.CLIENT_SECRET));
		authData.setGrantType(properties
				.getProperty(AuthenticationVO.GRANT_TYPE));

		return authData;
	}

	public static AuthenticationVO createClientAuthenticationVO()
			throws IOException {
		AuthenticationVO authData = new AuthenticationVO();
		Properties properties = FileHandler.readPropertyFile(DATA_FILE);
		authData = new AuthenticationVO();
		authData.setClientId(properties
				.getProperty(ClientAuthenticationVO.CLIENT_ID));
		authData.setClientSecret(properties
				.getProperty(ClientAuthenticationVO.CLIENT_SECRET));
		authData.setGrantType(properties
				.getProperty(ClientAuthenticationVO.GRANT_TYPE));
		authData.setUsername(properties
				.getProperty(ClientAuthenticationVO.USERNAME));
		authData.setPassword(properties
				.getProperty(ClientAuthenticationVO.PASSWORD));

		return authData;
	}

}
