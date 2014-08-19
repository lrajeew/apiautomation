package com.lrajeew.rest;

import com.lrajeew.util.ApiConsatants;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Hello world!
 *
 */
public class App 
{
	
	public static void main(String[] args){
		testAttendeeAPI();
	}
	
    public static void main()
    {
        Client client = Client.create();
        WebResource webResource = client
     		   .resource("https://api.github.com/users/lahiruucsc");
      
     		ClientResponse response = webResource.accept("application/json")
                        .get(ClientResponse.class);
     		
     		System.out.println();
    }
    
    
    
    
    public static void testAttendeeAPI(){
    	Client client = Client.create();
        WebResource webResource = client
     		   .resource(ApiConsatants.OAUTH);
        String authenticationData = "{\"client_id\":\"vivacon\",\"client_secret\":\"allezl0m\",\"grant_type\":\"client_credentials\"}";
        ClientResponse response = webResource.accept("application/json").post(ClientResponse.class, authenticationData);
        
    }
    
}
