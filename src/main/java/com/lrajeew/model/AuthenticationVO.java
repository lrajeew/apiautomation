package com.lrajeew.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class AuthenticationVO implements BaseVO{

	public static final String CLIENT_ID = "client_id";
	public static final String CLIENT_SECRET = "client_secret";
	public static final String GRANT_TYPE = "grant_type";
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	
	private String clientId;
	private String clientSecret;
	private String grantType;
	private String username;
	private String password;

	@JsonProperty("client_id")
	public String getClientId() {
		return clientId;
	}

	@JsonProperty("client_id")
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	@JsonProperty("client_secret")
	public String getClientSecret() {
		return clientSecret;
	}
	
	@JsonProperty("client_secret")
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	@JsonProperty("grant_type")
	public String getGrantType() {
		return grantType;
	}

	@JsonProperty("grant_type")
	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}

	@JsonProperty("username")
	public String getUsername() {
		return username;
	}

	@JsonProperty("username")
	public void setUsername(String username) {
		this.username = username;
	}

	@JsonProperty("password")
	public String getPassword() {
		return password;
	}

	
	@JsonProperty("password")
	public void setPassword(String password) {
		this.password = password;
	}

	
}
