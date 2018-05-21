package de.madana.common.restclient;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.oauth2.OAuth2ClientSupport;

import de.madana.common.datastructures.MDN_UserCredentials;

public class MDN_AuthenticationEndpointHandler
{

	public static String logon(MDN_UserCredentials oCredentials)
	{
		Response oResponse = App.client.target(App.REST_URI).path("authentication").request(MediaType.APPLICATION_JSON).post(Entity.entity(oCredentials, MediaType.APPLICATION_JSON));
		String strToken = oResponse.readEntity(String.class);
		Feature feature = OAuth2ClientSupport.feature(strToken);
		App.client.register(feature);
		
		return strToken;
	}
}
