package com.lrajeew.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class AttendeeRequestVO {
	
	public static final String EVENT_ID = "eventId";
	public static final String USER_ID = "id";
	public static final String EMAIL = "email";
	public static final String SEARCH = "search";
	public static final String BLOCK_FROM = "blockFrom";
	public static final String BLOCK_SIZE = "blockSize";
	public static final String PUT_USER_ID = "put_userId";

	private String eventId;
	private long userId;
	private String email;
	private String search;
	private int blockFrom;
	private int blockSize;

	@JsonProperty("eventId")
	public String getEventId() {
		return eventId;
	}

	@JsonProperty("eventId")
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	@JsonProperty("id")
	public long getUserId() {
		return userId;
	}

	@JsonProperty("id")
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public int getBlockFrom() {
		return blockFrom;
	}

	public void setBlockFrom(int blockFrom) {
		this.blockFrom = blockFrom;
	}

	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}

}
