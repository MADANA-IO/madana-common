package de.madana.common.restclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import de.madana.common.datastructures.MDN_User;
import de.madana.common.datastructures.MDN_UserCredentials;

/**
 * Hello world!
 *
 */
public class App 
{
	static final String REST_URI  = "https://extranet.madana.io/rest/";
	static Client client = ClientBuilder.newClient();
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
		
		MDN_User oUser= new MDN_User();
		MDN_UserCredentials oCredentials = new MDN_UserCredentials();
		oCredentials.setPassword("test");
		oCredentials.setUsername("madana");
		oUser.setMail("test@test.de");
		oUser.setCredentials(oCredentials);
	
		
		
		MDN_UserEndpointHandler.createUser(oUser);
		
		MDN_UserEndpointHandler.getUser("madana");

		MDN_AuthenticationEndpointHandler.logon(oCredentials);
		MDN_UserEndpointHandler.deleteUser("madana");

    }
}
