package com.lrajeew.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class AuthenticationResponseVO {

	/*
	 * { "access_token": "34a17838-3167-4139-82c6-531ef48b5e54", "expires_in":
	 * 604799, "token_type": "bearer" }
	 */

	private String accessToken;
	private Long expiresIn;
	private String tokenType;
	
	@JsonProperty("access_token")
	public String getAccessToken() {
		return accessToken;
	}
	
	@JsonProperty("access_token")
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	@JsonProperty("expires_in")
	public Long getExpiresIn() {
		return expiresIn;
	}
	
	@JsonProperty("expires_in")
	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}
	
	@JsonProperty("token_type")
	public String getTokenType() {
		return tokenType;
	}
	
	@JsonProperty("token_type")
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}	
	
}
