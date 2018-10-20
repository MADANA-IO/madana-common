/*******************************************************************************
 * Copyright (C) 2018 MADANA
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * @organization:MADANA
 * @author:Jean-Fabian Wenisch
 * @contact:dev@madana.io
 ******************************************************************************/
package de.madana.common.restclient;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.oauth2.OAuth2ClientSupport;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.madana.common.datastructures.MDN_ErrorMessage;
import de.madana.common.datastructures.MDN_MailAddress;
import de.madana.common.datastructures.MDN_OAuthToken;
import de.madana.common.datastructures.MDN_PasswordReset;
import de.madana.common.datastructures.MDN_PersonalSocialPost;
import de.madana.common.datastructures.MDN_SimpleUserProfile;
import de.madana.common.datastructures.MDN_SocialPlatform;
import de.madana.common.datastructures.MDN_SocialPost;
import de.madana.common.datastructures.MDN_SystemHealthObject;
import de.madana.common.datastructures.MDN_Token;
import de.madana.common.datastructures.MDN_User;
import de.madana.common.datastructures.MDN_UserCredentials;
import de.madana.common.datastructures.MDN_UserProfile;
import de.madana.common.datastructures.MDN_UserProfileImage;
import de.madana.common.datastructures.MDN_UserSetting;

// TODO: Auto-generated Javadoc
/**
 * The Class MDN_RestClient.
 *
 * @author J.-Fabian Wenisch
 */
public class MDN_RestClient 
{
	
	/** The rest uri. */
	static String REST_URI  = "";
	
	/** The client. */
	Client client;

	/**
	 * Instantiates a new MD N rest client.
	 *
	 * @param strUrl the str url
	 */
	public MDN_RestClient(String strUrl)
	{
		REST_URI= strUrl;
		client = ClientBuilder.newClient();
	}
	
	/**
	 * Instantiates a new MD N rest client.
	 */
	public MDN_RestClient()
	{
		if(System.getProperty("RESTURI")!=null)
		{
			if(System.getProperty("RESTURI").length()>0)
				REST_URI= System.getProperty("RESTURI");
		}
		if(System.getenv("RESTURI")!=null)
		{
			if(System.getenv("RESTURI").length()>0)
				REST_URI= System.getenv("RESTURI");
		}
		client = ClientBuilder.newClient();
	}
	
	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	public List<MDN_UserProfile> getUsers()
	{
		List<MDN_UserProfile> oList = client.target(MDN_RestClient.REST_URI).path("users").request(MediaType.APPLICATION_JSON).get(List.class);

		return oList;
	}
	
	/**
	 * Logon.
	 *
	 * @param strUserName the str user name
	 * @param strPassword the str password
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean logon(String strUserName, String strPassword) throws Exception
	{
		MDN_UserCredentials oCredentials = new MDN_UserCredentials();
		oCredentials.setPassword(strPassword);
		oCredentials.setUsername(strUserName);
		registerToken(oCredentials);
		return true;
	}
	
	/**
	 * Request new password.
	 *
	 * @param oMail the o mail
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean requestNewPassword(MDN_MailAddress oMail) throws Exception
	{

		Response oResponse = client.target(MDN_RestClient.REST_URI).path("password").request(MediaType.APPLICATION_JSON).post(Entity.entity(oMail, MediaType.APPLICATION_JSON));
		if( Response.Status.ACCEPTED.getStatusCode()!=oResponse.getStatus())
			throw new Exception("Mail Address Not found");

		return true;
	}
	
	/**
	 * Sets the new password.
	 *
	 * @param oPasswordReset the o password reset
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean setNewPassword(MDN_PasswordReset oPasswordReset)throws Exception
	{
		Response oResponse = client.target(MDN_RestClient.REST_URI).path("password").request(MediaType.APPLICATION_JSON).put(Entity.entity(oPasswordReset, MediaType.APPLICATION_JSON));
		checkForError( oResponse, Response.Status.ACCEPTED.getStatusCode());

		return true;
	}

	/**
	 * Register token.
	 *
	 * @param oCredentials the o credentials
	 * @return the string
	 * @throws Exception the exception
	 */
	private String registerToken(MDN_UserCredentials oCredentials ) throws Exception
	{
		Response oResponse = client.target(MDN_RestClient.REST_URI).path("authentication").request(MediaType.APPLICATION_JSON).post(Entity.entity(oCredentials, MediaType.APPLICATION_JSON)); 
		checkForError(oResponse, Response.Status.OK.getStatusCode() );
		MDN_Token oToken = oResponse.readEntity(MDN_Token.class);
		Feature feature = OAuth2ClientSupport.feature(oToken.getToken());
		client.register(feature);

		return oToken.getToken();
	}
	
	/**
	 * Gets the user.
	 *
	 * @param strUserName the str user name
	 * @return the user
	 */
	public  MDN_User getUser(String strUserName)
	{
		return client.target(MDN_RestClient.REST_URI).path("users").path(strUserName).request(MediaType.APPLICATION_JSON).get(MDN_User.class);
	}

	/**
	 * Creates the user.
	 *
	 * @param strUserName the str user name
	 * @param strPassword the str password
	 * @param strMail the str mail
	 * @param strToken the str token
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean createUser(String strUserName, String strPassword, String strMail, String strToken) throws Exception
	{
		MDN_User oUser = new MDN_User();
		oUser.setMail(strMail);
		MDN_UserCredentials oCredentials = new MDN_UserCredentials();
		oCredentials.setPassword(strPassword);
		oCredentials.setUsername(strUserName);
		oUser.setCredentials(oCredentials);
		createUser(oUser, strToken);
		return true;
	}
	
	/**
	 * Creates the user.
	 *
	 * @param oUser the o user
	 * @param strToken the str token
	 * @return the MD N user
	 * @throws Exception the exception
	 */
	private  MDN_User createUser(MDN_User oUser, String strToken) throws Exception
	{
		Response response;
		if(strToken!=null)
		{
			response =client.target(MDN_RestClient.REST_URI).path("users").queryParam("referrer", strToken).request(MediaType.APPLICATION_JSON).post(Entity.entity(oUser, MediaType.APPLICATION_JSON));
		}
		else
		{
			response =client.target(MDN_RestClient.REST_URI).path("users").request(MediaType.APPLICATION_JSON).post(Entity.entity(oUser, MediaType.APPLICATION_JSON));
		}
		checkForError(response, Response.Status.OK.getStatusCode() );
		return oUser;
	}
	
	/**
	 * Delete user.
	 *
	 * @param strUserName the str user name
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public  boolean deleteUser(String strUserName) throws Exception
	{

		Response response =client.target(MDN_RestClient.REST_URI).path("users").path(strUserName).request(MediaType.APPLICATION_JSON).delete();
		if(Response.Status.OK.getStatusCode()!=response.getStatus())
			throw new Exception("Deletion failed");
		return true;
	}
	
	/**
	 * Update user.
	 *
	 * @param oUser the o user
	 * @param strUserName the str user name
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean updateUser(MDN_User oUser, String strUserName) throws Exception 
	{
		Response response =client.target(MDN_RestClient.REST_URI).path("users").path(strUserName).request(MediaType.APPLICATION_JSON).put(Entity.entity(oUser, MediaType.APPLICATION_JSON));
		if(Response.Status.OK.getStatusCode()!=response.getStatus())
			throw new Exception("Deletion failed");
		return true;
	}
	
	/**
	 * Gets the social feed.
	 *
	 * @param strPlatform the str platform
	 * @return the social feed
	 */
	public List<MDN_SocialPost>  getSocialFeed(String strPlatform) 
	{
		List<MDN_SocialPost>  oList;

		oList=client.target(MDN_RestClient.REST_URI).path("social").path("feed").path(strPlatform).request(MediaType.APPLICATION_JSON).get(List.class);



		return oList;
	}

	/**
	 * Gets the personalized twitter feed.
	 *
	 * @param strUserName the str user name
	 * @return the personalized twitter feed
	 */
	public List<MDN_PersonalSocialPost> getPersonalizedTwitterFeed(String strUserName) 
	{
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		List<MDN_PersonalSocialPost> oList=null;
		JsonNode oJSON =client.target(MDN_RestClient.REST_URI).path("social").path("feed").path("twitter").request(MediaType.APPLICATION_JSON).get(JsonNode.class);
		try {
			oList = mapper.readValue(mapper.treeAsTokens(oJSON),   new TypeReference<List<MDN_PersonalSocialPost>>(){});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oList;
	}
	
	/**
	 * Gets the facebook auth URL.
	 *
	 * @return the facebook auth URL
	 */
	public String getFacebookAuthURL() 
	{
		String strUrl=client.target(MDN_RestClient.REST_URI).path("social").path("auth").path("facebook").request(MediaType.APPLICATION_JSON).get(String.class);
		return strUrl;
	}
	
	/**
	 * Gets the twitter auth URL.
	 *
	 * @return the twitter auth URL
	 */
	public String getTwitterAuthURL() 
	{
		String strUrl=client.target(MDN_RestClient.REST_URI).path("social").path("auth").path("twitter").request(MediaType.APPLICATION_JSON).get(String.class);
		return strUrl;
	}
	
	/**
	 * Gets the social platforms.
	 *
	 * @return the social platforms
	 */
	public List<MDN_SocialPlatform> getSocialPlatforms()
	{
		ObjectMapper mapper = new ObjectMapper();
		List<MDN_SocialPlatform> oList=null;
		JsonNode oJSON =client.target(MDN_RestClient.REST_URI).path("social").request(MediaType.APPLICATION_JSON).get(JsonNode.class);
		//Jackson's use of generics here are completely unsafe, but that's another issue
		try {
			oList = mapper.readValue(mapper.treeAsTokens(oJSON),   new TypeReference<List<MDN_SocialPlatform>>(){});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oList;
	}
	
	/**
	 * Gets the ranking.
	 *
	 * @return the ranking
	 */
	public List<MDN_SimpleUserProfile> getRanking()
	{
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		List<MDN_SimpleUserProfile>  oRanking = null;

		//Jackson's use of generics here are completely unsafe, but that's another issue
		try {
			JsonNode oJSON =client.target(MDN_RestClient.REST_URI).path("social").path("ranking").request(MediaType.APPLICATION_JSON).get(JsonNode.class);
			oRanking = mapper.readValue(mapper.treeAsTokens(oJSON),   new TypeReference<List<MDN_SimpleUserProfile>>(){});
			Collections.sort(oRanking);

		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return oRanking;
	}

	/**
	 * Sets the facebook UID.
	 *
	 * @param strCode the str code
	 * @return true, if successful
	 */
	public boolean setFacebookUID(String strCode) 
	{
		Response oResponse = client.target(MDN_RestClient.REST_URI).path("social").path("auth").path("facebook").request(MediaType.APPLICATION_JSON).post(Entity.entity(strCode, MediaType.APPLICATION_JSON));
		if( Response.Status.ACCEPTED.getStatusCode()!=oResponse.getStatus())
			return false;

		return true;

	}
	
	/**
	 * Gets the social feed.
	 *
	 * @param oPlatform the o platform
	 * @return the social feed
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unchecked")
	public void getSocialFeed(MDN_SocialPlatform oPlatform) throws Exception 
	{
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		List<MDN_SocialPost>  oFeed = null;

		//Jackson's use of generics here are completely unsafe, but that's another issue

			JsonNode oJSON = client.target(MDN_RestClient.REST_URI).path("social").path("feed").path(oPlatform.getName().toLowerCase()).request(MediaType.APPLICATION_JSON).get(JsonNode.class);
			oFeed = mapper.readValue(mapper.treeAsTokens(oJSON),   new TypeReference<List<MDN_SocialPost>>(){});
			Collections.sort(oFeed);


		oPlatform.setFeed(oFeed);

	}
	
	/**
	 * Sets the fractal UID.
	 *
	 * @param code the code
	 * @return true, if successful
	 */
	public boolean setFractalUID(String code) 
	{
		Response oResponse = client.target(MDN_RestClient.REST_URI).path("social").path("auth").path("fractal").request(MediaType.APPLICATION_JSON).post(Entity.entity(code, MediaType.APPLICATION_JSON));
		if( Response.Status.ACCEPTED.getStatusCode()!=oResponse.getStatus())
			return false;

		return true;

	}

	/**
	 * Sets the twitter UID.
	 *
	 * @param token the token
	 * @param verifier the verifier
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean setTwitterUID(String token, String verifier) throws Exception
	{
		MDN_OAuthToken oToken = new MDN_OAuthToken();
		oToken.setToken(token);
		oToken.setVerifier(verifier);
		Response oResponse = client.target(MDN_RestClient.REST_URI).path("social").path("auth").path("twitter").request(MediaType.APPLICATION_JSON).post(Entity.entity(oToken, MediaType.APPLICATION_JSON));
		checkForError( oResponse, Response.Status.ACCEPTED.getStatusCode());

		return true;

	}
	
	/**
	 * Gets the referred users.
	 *
	 * @param strPlatform the str platform
	 * @param strUsername the str username
	 * @return the referred users
	 */
	public List<MDN_UserProfile> getReferredUsers(String strPlatform, String strUsername)
	{
		List<MDN_UserProfile> oProfiles = client.target(MDN_RestClient.REST_URI).path("social").path("feed").path(strPlatform.toLowerCase()).request(MediaType.APPLICATION_JSON).get(List.class);

		return oProfiles;
	}
	
	/**
	 * Gets the available avatars.
	 *
	 * @param strUsername the str username
	 * @return the available avatars
	 */
	public List<MDN_UserProfileImage> getAvailableAvatars(String strUsername)
	{
		List<MDN_UserProfileImage> oAvatars = client.target(MDN_RestClient.REST_URI).path("users").path(strUsername).path("avatars").request(MediaType.APPLICATION_JSON).get(List.class);

		return oAvatars;
	}
	
	/**
	 * Sets the avatar.
	 *
	 * @param strUsername the str username
	 * @param oImage the o image
	 * @return true, if successful
	 */
	public boolean setAvatar(String strUsername, MDN_UserProfileImage oImage)
	{
		Response oResponse = client.target(MDN_RestClient.REST_URI).path("users").path(strUsername).path("avatars").request(MediaType.APPLICATION_JSON).post(Entity.entity(oImage, MediaType.APPLICATION_JSON));
		if( Response.Status.ACCEPTED.getStatusCode()!=oResponse.getStatus())
			return false;

		return true;
	}
	
	/**
	 * Gets the profile.
	 *
	 * @param strUserName the str user name
	 * @return the profile
	 * @throws Exception the exception
	 */
	public MDN_UserProfile getProfile(String strUserName) throws Exception 
	{
		try
		{
			MDN_UserProfile oProfile = client.target(MDN_RestClient.REST_URI).path("users").path("profiles").path(strUserName).request(MediaType.APPLICATION_JSON).get(MDN_UserProfile.class);
			return oProfile;
		}
		catch(Exception e)
		{
			throw new Exception("Error Requesting profile " +strUserName);
		}

	
	}
	
	/**
	 * Gets the profile.
	 *
	 * @return the profile
	 */
	public MDN_UserProfile getProfile() 
	{
		try
		{
			MDN_UserProfile oProfile = client.target(MDN_RestClient.REST_URI).path("users").path("profiles").path("me").request(MediaType.APPLICATION_JSON).get(MDN_UserProfile.class);
			return oProfile;
		}
		catch(Exception e)
		{
			return null;
		}

	
	}

	/**
	 * Gets the system health.
	 *
	 * @return the system health
	 */
	public MDN_SystemHealthObject getSystemHealth()
	{
		MDN_SystemHealthObject Health = client.target(MDN_RestClient.REST_URI).path("health").request(MediaType.APPLICATION_JSON).get(MDN_SystemHealthObject.class);

		return Health;
	}
	
	/**
	 * Gets the fractal auth URL.
	 *
	 * @return the fractal auth URL
	 */
	public String getFractalAuthURL() 	
	{
		String strUrl=client.target(MDN_RestClient.REST_URI).path("social").path("fractal").path("auth").request(MediaType.APPLICATION_JSON).get(String.class);
		return strUrl;
	}
	
	/**
	 * Validate activation token.
	 *
	 * @param token the token
	 * @return true, if successful
	 */
	public boolean validateActivationToken(String token) 	
	{
		Response oResponse=client.target(MDN_RestClient.REST_URI).path("users").path("activation").path(token).request(MediaType.APPLICATION_JSON).get();
		if( Response.Status.ACCEPTED.getStatusCode()!=oResponse.getStatus())
			return false;

		return true;	
	}

	/**
	 * Gets the fractal auth token.
	 *
	 * @param strClientID the str client ID
	 * @param strClientSecret the str client secret
	 * @param strBaseURL the str base URL
	 * @param strRedirectURL the str redirect URL
	 * @param strCode the str code
	 * @return the fractal auth token
	 */
	public String getFractalAuthToken(String strClientID, String strClientSecret, String strBaseURL, String strRedirectURL, String strCode)
	{

		Response oResponse  =client.target(strBaseURL).path("token")
				.queryParam("client_id", strClientID)
				.queryParam("redirect_uri", strRedirectURL)
				.queryParam("client_secret", strClientSecret)
				.queryParam("code", strCode)
				.queryParam("grant_type", "authorization_code")
				.request(MediaType.APPLICATION_JSON).post(Entity.entity(null, MediaType.APPLICATION_JSON));
		String strResponse =  oResponse.readEntity(String.class);
		//		JsonNode oNode = oResponse.readEntity(JsonNode.class);
		strResponse=strResponse.substring(strResponse.indexOf("access_token")+15, strResponse.indexOf("token_type")-3);
		return strResponse;
	}
	
	/**
	 * Sets the authentication bearer.
	 *
	 * @param strBearer the new authentication bearer
	 */
	public void setAuthenticationBearer(String strBearer) 
	{
		Feature feature = OAuth2ClientSupport.feature(strBearer);
		client.register(feature);	
	}
	
	/**
	 * Gets the fractal information.
	 *
	 * @param strBaseURL the str base URL
	 * @return the fractal information
	 */
	public String getFractalInformation(String strBaseURL) 
	{
		strBaseURL=strBaseURL.substring(0, strBaseURL.lastIndexOf("/"));
		JsonNode oJSON   =client.target(strBaseURL).path("api").path("me").request(MediaType.APPLICATION_JSON).get(JsonNode.class);
		String strResponse = oJSON.get("did").asText();
		return strResponse;
	}
	
	/**
	 * Gets the twitter embedd code.
	 *
	 * @param strFeedLink the str feed link
	 * @return the twitter embedd code
	 */
	public String getTwitterEmbeddCode(String strFeedLink) 
	{
		JsonNode oJSON= null;
		try
		{
			oJSON   =client.target("https://publish.twitter.com").path("oembed").queryParam("url",strFeedLink).request(MediaType.APPLICATION_JSON).get(JsonNode.class);
		}
		catch(Exception ex)
		{
			return null;
		}

		String strResponse = oJSON.get("html").asText();
		return strResponse;
	}
	
	/**
	 * Sets the user setting.
	 *
	 * @param strUsername the str username
	 * @param oSetting the o setting
	 * @return true, if successful
	 */
	public boolean setUserSetting(String strUsername, MDN_UserSetting oSetting)
	{
		Response oResponse = client.target(MDN_RestClient.REST_URI).path("users").path(strUsername).path("settings").request(MediaType.APPLICATION_JSON).post(Entity.entity(oSetting, MediaType.APPLICATION_JSON));
		if( Response.Status.ACCEPTED.getStatusCode()!=oResponse.getStatus())
			return false;

		return true;		
	}



	/**
	 * Check for error.
	 *
	 * @param response the response
	 * @param status the status
	 * @throws Exception the exception
	 */
	private void checkForError( Response response, int status )throws Exception
	{
		if( status!=response.getStatus())
		{
			Exception oEx;
			try
			{
				MDN_ErrorMessage oMessage = getErrorMessage(response);
				oEx = new Exception(oMessage.getErrorMessage());
			}
			catch(Exception ex)
			{
				oEx = new Exception(response.getStatusInfo().toString());
			}
			throw oEx;

		}
	}
	
	/**
	 * Gets the error message.
	 *
	 * @param response the response
	 * @return the error message
	 */
	public MDN_ErrorMessage getErrorMessage( Response response )
	{
		return response.readEntity(MDN_ErrorMessage.class);

	}

}
