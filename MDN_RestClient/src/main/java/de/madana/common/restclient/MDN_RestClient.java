package de.madana.common.restclient;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.oauth2.OAuth2ClientSupport;

import de.madana.common.datastructures.MDN_MailAddress;
import de.madana.common.datastructures.MDN_PasswordReset;
import de.madana.common.datastructures.MDN_Token;
import de.madana.common.datastructures.MDN_User;
import de.madana.common.datastructures.MDN_UserCredentials;
import de.madana.common.datastructures.MDN_UserProfile;

/**
 * Hello world!
 *
 */
public class MDN_RestClient 
{
	static String REST_URI  = "https://extranet.madana.io/rest/";
	static Client client = ClientBuilder.newClient();

	public MDN_RestClient(String strUrl)
	{
		REST_URI= strUrl;
	}
	public MDN_RestClient()
	{

	}
	public List<MDN_UserProfile> getUsers()
	{
		List<MDN_UserProfile> oList = client.target(MDN_RestClient.REST_URI).path("users").request(MediaType.APPLICATION_JSON).get(List.class);

		return oList;
	}
	public boolean logon(String strUserName, String strPassword) throws Exception
	{
		MDN_UserCredentials oCredentials = new MDN_UserCredentials();
		oCredentials.setPassword(strPassword);
		oCredentials.setUsername(strUserName);
		registerToken(oCredentials);
		return true;
	}
	public boolean requestNewPassword(MDN_MailAddress oMail) throws Exception
	{

		Response oResponse = client.target(MDN_RestClient.REST_URI).path("password").request(MediaType.APPLICATION_JSON).post(Entity.entity(oMail, MediaType.APPLICATION_JSON));
		if( Response.Status.ACCEPTED.getStatusCode()!=oResponse.getStatus())
			throw new Exception("Mail Address Not found");

		return true;
	}
	public boolean setNewPassword(MDN_PasswordReset oPasswordReset)throws Exception
	{
		Response oResponse = client.target(MDN_RestClient.REST_URI).path("password").request(MediaType.APPLICATION_JSON).put(Entity.entity(oPasswordReset, MediaType.APPLICATION_JSON));
		if( Response.Status.ACCEPTED.getStatusCode()!=oResponse.getStatus())
			throw new Exception("Password could not be set");
		return true;
	}

	private String registerToken(MDN_UserCredentials oCredentials ) throws Exception
	{
		Response oResponse = client.target(MDN_RestClient.REST_URI).path("authentication").request(MediaType.APPLICATION_JSON).post(Entity.entity(oCredentials, MediaType.APPLICATION_JSON));
		if( Response.Status.OK.getStatusCode()!=oResponse.getStatus())
			throw new Exception("Wrong username / password");
		MDN_Token oToken = oResponse.readEntity(MDN_Token.class);
		Feature feature = OAuth2ClientSupport.feature(oToken.getToken());
		client.register(feature);

		return oToken.getToken();
	}
	public  MDN_User getUser(String strUserName)
	{
		return client.target(MDN_RestClient.REST_URI).path("users").path(strUserName).request(MediaType.APPLICATION_JSON).get(MDN_User.class);
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
	public  boolean deleteUser(String strUserName) throws Exception
	{

		Response response =MDN_RestClient.client.target(MDN_RestClient.REST_URI).path("users").path(strUserName).request(MediaType.APPLICATION_JSON).delete();
		if(Response.Status.OK.getStatusCode()!=response.getStatus())
			throw new Exception("Deletion failed");
		return true;
	}
	public List<de.madana.common.datastructures.MDN_SocialPost> getFacebookFeed() 
	{
		 List<de.madana.common.datastructures.MDN_SocialPost> oList=MDN_RestClient.client.target(MDN_RestClient.REST_URI).path("social").path("facebook").path("feed").request(MediaType.APPLICATION_JSON).get(List.class);
		return oList;
	}
	public List<de.madana.common.datastructures.MDN_SocialPost> getTwitterFeed() 
	{
		 List<de.madana.common.datastructures.MDN_SocialPost> oList=MDN_RestClient.client.target(MDN_RestClient.REST_URI).path("social").path("twitter").path("feed").request(MediaType.APPLICATION_JSON).get(List.class);
		return oList;
	}
	public String getFacebookAuthURL() 
	{
		 String strUrl=MDN_RestClient.client.target(MDN_RestClient.REST_URI).path("social").path("facebook").path("auth").request(MediaType.APPLICATION_JSON).get(String.class);
		return strUrl;
	}
	public boolean setFacebookUID(String strCode) 
	{
		Response oResponse = client.target(MDN_RestClient.REST_URI).path("social").path("facebook").path("auth").request(MediaType.APPLICATION_JSON).post(Entity.entity(strCode, MediaType.APPLICATION_JSON));
		if( Response.Status.ACCEPTED.getStatusCode()!=oResponse.getStatus())
		return false;

		return true;
		
	}


}
