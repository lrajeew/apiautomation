package com.lrajeew.util;

public interface ApiConsatants {

	public static final String OAUTH = "http://dev.mob.vivastream.com/oauth/token";
	public static final String VIVA_API = "http://dev.mob.vivastream.com/v2/";
	public static final String ATTENDEE_BY_ID_API ="events/<eventKey>/attendees/<user_id>?";
	public static final String ATTENDEE_BY_EMAIL_API = "events/<eventKey>/attendees/<email>?disc=email&";
	public static final String ATTENDEE_SEARCH_API = "events/<eventKey>/attendees?search=<search>&blockFrom=<blockFrom>&blockSize=<blockSize>&";
	public static final String ATTENDEE_PUT_API = "events/<eventKey>/attendees/<user_id>?for=user&";
	public static final String ATTENDEE_DELETE_API = "events/<eventKey>/attendees/<user_id>?for=user&";
	
	//All the data is hardcoded after this point
	//$LR : Code clean up
	public static final String ATTENDEE_DELETE_API_HARDCODE = "events/vivacon/attendees/47593?for=user&";
	
	public static final String EVENT_KEY = "<eventKey>";
	public static final String USER_ID = "<user_id>";
	public static final String EMAIL = "<email>";
	public static final String SEARCH = "<search>";
	public static final String BLOCK_FROM = "<blockFrom>";
	public static final String BLOCK_SIZE = "<blockSize>";
	public static final String PUT_USER_ID = "put_userId";	
	
}
