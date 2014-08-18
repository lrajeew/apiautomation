package com.lrajeew.model;

public enum ResponseType {
	LITE("lite"),
	FULL("full"),
	DEFAULT("");

	private String type;
	
	private ResponseType(String type){
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
