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
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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

import de.madana.common.datastructures.MDN_AccesTokenRequestResponse;
import de.madana.common.datastructures.MDN_MailAddress;
import de.madana.common.datastructures.MDN_OAuthToken;
import de.madana.common.datastructures.MDN_PasswordReset;
import de.madana.common.datastructures.MDN_PersonalSocialPost;
import de.madana.common.datastructures.MDN_SocialPlatform;
import de.madana.common.datastructures.MDN_SocialPost;
import de.madana.common.datastructures.MDN_SystemHealthObject;
import de.madana.common.datastructures.MDN_Token;
import de.madana.common.datastructures.MDN_User;
import de.madana.common.datastructures.MDN_UserCredentials;
import de.madana.common.datastructures.MDN_UserProfile;
import de.madana.common.datastructures.MDN_UserProfileImage;

/**
 * Hello world!
 *
 */
public class MDN_RestClient 
{
	static String REST_URI  = "https://extranet.madana.io/rest";
	Client client;

	public MDN_RestClient(String strUrl)
	{
		REST_URI= strUrl;
		client = ClientBuilder.newClient();
	}
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
				REST_URI= System.getProperty("RESTURI");
		}
		client = ClientBuilder.newClient();
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
			throw new Exception(oResponse.getStatusInfo().toString());
		MDN_Token oToken = oResponse.readEntity(MDN_Token.class);
		Feature feature = OAuth2ClientSupport.feature(oToken.getToken());
		client.register(feature);

		return oToken.getToken();
	}
	public  MDN_User getUser(String strUserName)
	{
		return client.target(MDN_RestClient.REST_URI).path("users").path(strUserName).request(MediaType.APPLICATION_JSON).get(MDN_User.class);
	}

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

		if(Response.Status.OK.getStatusCode()!=response.getStatus())
			throw new Exception("Creation failed");
		return oUser;
	}
	public  boolean deleteUser(String strUserName) throws Exception
	{

		Response response =client.target(MDN_RestClient.REST_URI).path("users").path(strUserName).request(MediaType.APPLICATION_JSON).delete();
		if(Response.Status.OK.getStatusCode()!=response.getStatus())
			throw new Exception("Deletion failed");
		return true;
	}
	public boolean updateUser(MDN_User oUser, String strUserName) throws Exception 
	{
		Response response =client.target(MDN_RestClient.REST_URI).path("users").path(strUserName).request(MediaType.APPLICATION_JSON).put(Entity.entity(oUser, MediaType.APPLICATION_JSON));
		if(Response.Status.OK.getStatusCode()!=response.getStatus())
			throw new Exception("Deletion failed");
		return true;
	}
	public List<MDN_SocialPost>  getFacebookFeed() 
	{
		List<MDN_SocialPost>  oList=client.target(MDN_RestClient.REST_URI).path("social").path("facebook").path("feed").request(MediaType.APPLICATION_JSON).get(List.class);
		return oList;
	}
	public List<MDN_SocialPost> getTwitterFeed() 
	{
		List<MDN_SocialPost>  oList=client.target(MDN_RestClient.REST_URI).path("social").path("twitter").path("feed").request(MediaType.APPLICATION_JSON).get(List.class);
		return oList;
	}
	public List<MDN_PersonalSocialPost> getPersonalizedTwitterFeed(String strUserName) 
	{
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		List<MDN_PersonalSocialPost> oList=null;
		JsonNode oJSON =client.target(MDN_RestClient.REST_URI).path("social").path("twitter").path("feed").path(strUserName).request(MediaType.APPLICATION_JSON).get(JsonNode.class);
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
	public String getFacebookAuthURL() 
	{
		String strUrl=client.target(MDN_RestClient.REST_URI).path("social").path("facebook").path("auth").request(MediaType.APPLICATION_JSON).get(String.class);
		return strUrl;
	}
	public String getTwitterAuthURL() 
	{
		String strUrl=client.target(MDN_RestClient.REST_URI).path("social").path("twitter").path("auth").request(MediaType.APPLICATION_JSON).get(String.class);
		return strUrl;
	}
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
	public Map<String, String> getRanking()
	{
		Map<String, String> oRanking =client.target(MDN_RestClient.REST_URI).path("social").path("ranking").request(MediaType.APPLICATION_JSON).get(Map.class);
		return sortMapByValues(oRanking);
	}
	private static Map<String, String> sortMapByValues(Map<String, String> aMap) {

		Set<Entry<String,String>> mapEntries = aMap.entrySet();



		// used linked list to sort, because insertion of elements in linked list is faster than an array list. 
		List<Entry<String,String>> aList = new LinkedList<Entry<String,String>>(mapEntries);

		// sorting the List
		Collections.sort(aList, new Comparator<Entry<String,String>>() {

			public int compare(Entry<String, String> ele1,
					Entry<String, String> ele2) {

				return Integer.valueOf(ele2.getValue()).compareTo(Integer.valueOf(ele1.getValue()));
			}
		});

		// Storing the list into Linked HashMap to preserve the order of insertion. 
		Map<String,String> aMap2 = new LinkedHashMap<String, String>();
		for(Entry<String,String> entry: aList) {
			aMap2.put(entry.getKey(), entry.getValue());
		}

		return aMap2;

	}
	public boolean setFacebookUID(String strCode) 
	{
		Response oResponse = client.target(MDN_RestClient.REST_URI).path("social").path("facebook").path("auth").request(MediaType.APPLICATION_JSON).post(Entity.entity(strCode, MediaType.APPLICATION_JSON));
		if( Response.Status.ACCEPTED.getStatusCode()!=oResponse.getStatus())
			return false;

		return true;

	}
	@SuppressWarnings("unchecked")
	public void getSocialFeed(MDN_SocialPlatform oPlatform) 
	{
		ObjectMapper mapper = new ObjectMapper();
		List<MDN_SocialPost>  oFeed = null;
		JsonNode oJSON = client.target(MDN_RestClient.REST_URI).path("social").path(oPlatform.getName().toLowerCase()).path("feed").request(MediaType.APPLICATION_JSON).get(JsonNode.class);
		//Jackson's use of generics here are completely unsafe, but that's another issue
		try {
			oFeed = mapper.readValue(mapper.treeAsTokens(oJSON),   new TypeReference<List<MDN_SocialPost>>(){});
			Collections.sort(oFeed);

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

		oPlatform.setFeed(oFeed);

	}
	public boolean setFractalUID(String code) 
	{
		Response oResponse = client.target(MDN_RestClient.REST_URI).path("social").path("fractal").path("auth").request(MediaType.APPLICATION_JSON).post(Entity.entity(code, MediaType.APPLICATION_JSON));
		if( Response.Status.ACCEPTED.getStatusCode()!=oResponse.getStatus())
			return false;

		return true;

	}

	public boolean setTwitterUID(String token, String verifier)
	{
		MDN_OAuthToken oToken = new MDN_OAuthToken();
		oToken.setToken(token);
		oToken.setVerifier(verifier);
		Response oResponse = client.target(MDN_RestClient.REST_URI).path("social").path("twitter").path("auth").request(MediaType.APPLICATION_JSON).post(Entity.entity(oToken, MediaType.APPLICATION_JSON));
		if( Response.Status.ACCEPTED.getStatusCode()!=oResponse.getStatus())
			return false;

		return true;

	}
	public List<MDN_UserProfile> getReferredUsers(String strPlatform, String strUsername)
	{
		List<MDN_UserProfile> oProfiles = client.target(MDN_RestClient.REST_URI).path("social").path(strPlatform.toLowerCase()).path("feed").request(MediaType.APPLICATION_JSON).get(List.class);

		return oProfiles;
	}
	public List<MDN_UserProfileImage> getAvailableAvatars(String strUsername)
	{
		List<MDN_UserProfileImage> oAvatars = client.target(MDN_RestClient.REST_URI).path("users").path(strUsername).path("avatars").request(MediaType.APPLICATION_JSON).get(List.class);

		return oAvatars;
	}
	public boolean setAvatar(String strUsername, MDN_UserProfileImage oImage)
	{
		Response oResponse = client.target(MDN_RestClient.REST_URI).path("users").path(strUsername).path("avatars").request(MediaType.APPLICATION_JSON).post(Entity.entity(oImage, MediaType.APPLICATION_JSON));
		if( Response.Status.ACCEPTED.getStatusCode()!=oResponse.getStatus())
			return false;

		return true;
	}
	public MDN_UserProfile getProfile(String strUserName) 
	{
		MDN_UserProfile oProfile = client.target(MDN_RestClient.REST_URI).path("users").path("profiles").path(strUserName).request(MediaType.APPLICATION_JSON).get(MDN_UserProfile.class);

		return oProfile;
	}

	public MDN_SystemHealthObject getSystemHealth()
	{
		MDN_SystemHealthObject Health = client.target(MDN_RestClient.REST_URI).path("health").request(MediaType.APPLICATION_JSON).get(MDN_SystemHealthObject.class);

		return Health;
	}
	public String getFractalAuthURL() 	
	{
		String strUrl=client.target(MDN_RestClient.REST_URI).path("social").path("fractal").path("auth").request(MediaType.APPLICATION_JSON).get(String.class);
		return strUrl;
	}

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
	public void setAuthenticationBearer(String strBearer) 
	{
		Feature feature = OAuth2ClientSupport.feature(strBearer);
		client.register(feature);	
	}
	public String getFractalInformation(String strBaseURL) 
	{
		strBaseURL=strBaseURL.substring(0, strBaseURL.lastIndexOf("/"));
		JsonNode oJSON   =client.target(strBaseURL).path("api").path("me").request(MediaType.APPLICATION_JSON).get(JsonNode.class);
		String strResponse = oJSON.get("did").asText();
		return strResponse;
	}
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





}
