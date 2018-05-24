package de.madana.common.restclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.client.oauth2.OAuth2ClientSupport;

import de.madana.common.datastructures.MDN_User;
import de.madana.common.datastructures.MDN_UserCredentials;

/**
 * Hello world!
 *
 */
public class MDN_RestClient 
{
	static final String REST_URI  = "https://extranet.madana.io/rest/";
	static Client client = ClientBuilder.newClient();


	public boolean logon(String strUserName, String strPassword) throws Exception
	{
		MDN_UserCredentials oCredentials = new MDN_UserCredentials();
		oCredentials.setPassword(strPassword);
		oCredentials.setUsername(strUserName);
		registerToken(oCredentials);
		return true;
	}

	private String registerToken(MDN_UserCredentials oCredentials ) throws Exception
	{
		Response oResponse = client.target(MDN_RestClient.REST_URI).path("authentication").request(MediaType.APPLICATION_JSON).post(Entity.entity(oCredentials, MediaType.APPLICATION_JSON));
		if( Response.Status.OK.getStatusCode()!=oResponse.getStatus())
			throw new Exception("Wrong username / password");
		String strToken = oResponse.readEntity(String.class);
		Feature feature = OAuth2ClientSupport.feature(strToken);
		client.register(feature);

		return strToken;
	}
	public  MDN_User getUser(String strUserName)
	{
		return MDN_RestClient.client.target(MDN_RestClient.REST_URI).path("users").path(strUserName).request(MediaType.APPLICATION_JSON).get(MDN_User.class);
	}

	public boolean createUser(String strUserName, String strPassword, String strMail) throws Exception
	{
		MDN_User oUser = new MDN_User();
				oUser.setMail(strMail);
		MDN_UserCredentials oCredentials = new MDN_UserCredentials();
		oCredentials.setPassword(strPassword);
		oCredentials.setUsername(strUserName);
		oUser.setCredentials(oCredentials);
		createUser(oUser);
		return true;
	}
	private  MDN_User createUser(MDN_User oUser) throws Exception
	{
		Response response =MDN_RestClient.client.target(MDN_RestClient.REST_URI).path("users").request(MediaType.APPLICATION_JSON).post(Entity.entity(oUser, MediaType.APPLICATION_JSON));
		if(Response.Status.OK.getStatusCode()!=response.getStatus())
			throw new Exception("Creation failed");
		return oUser;
	}
	public  void deleteUser(String strUserName)
	{

		Response response =MDN_RestClient.client.target(MDN_RestClient.REST_URI).path("users").path(strUserName).request(MediaType.APPLICATION_JSON).delete();
		if(Response.Status.OK.getStatusCode()!=response.getStatus())
		{
		}
	}


}
