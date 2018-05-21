package de.madana.common.restclient;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.madana.common.datastructures.MDN_User;

public class MDN_UserEndpointHandler 
{


	public static MDN_User getUser(String strUserName)
	{
		return App.client.target(App.REST_URI).path("users").path(strUserName).request(MediaType.APPLICATION_JSON).get(MDN_User.class);
	}
	public static MDN_User createUser(MDN_User oUser)
	{
		 Response response =App.client.target(App.REST_URI).path("users").request(MediaType.APPLICATION_JSON).post(Entity.entity(oUser, MediaType.APPLICATION_JSON));
		 if(Response.Status.OK.getStatusCode()!=response.getStatus())
		 {
			 
		 }
		return oUser;
	}
	public static void deleteUser(String strUserName)
	{

		 Response response =App.client.target(App.REST_URI).path("users").path(strUserName).request(MediaType.APPLICATION_JSON).delete();
		 if(Response.Status.OK.getStatusCode()!=response.getStatus())
		 {
			 
		 }
	}

}
