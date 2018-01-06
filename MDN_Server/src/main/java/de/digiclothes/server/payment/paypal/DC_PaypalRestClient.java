package de.digiclothes.server.payment.paypal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import de.digiclothes.server.web.rest.DC_A_RestClient;

public class DC_PaypalRestClient extends DC_A_RestClient
{
	static String strClientID ="AU7NZ3WEh02I2gTSZ14TECenuI0-j0c6Cd9nnqypZdUqPPgkG0mBFrxUkdbcnBS5utU0YVZi4YWcZmn0";
	static String strClientSecret="EGzfUcrmh3Sq4fkdMi1NAwWxW0YHBlToNtwUfPDQ0peVqqUVkQSzE4pkZTP6FHiG69W1SUwV0mNcKuKz";
	static String strAPPID;
	String strAccessToken;
	public DC_PaypalRestClient(String strDestUrl) 
	{
		super(strDestUrl);
		// TODO Auto-generated constructor stub
	}
	//	public APIContext ApiLogon()
	//	{
	//		APIContext context = new APIContext("AU7NZ3WEh02I2gTSZ14TECenuI0-j0c6Cd9nnqypZdUqPPgkG0mBFrxUkdbcnBS5utU0YVZi4YWcZmn0", "EGzfUcrmh3Sq4fkdMi1NAwWxW0YHBlToNtwUfPDQ0peVqqUVkQSzE4pkZTP6FHiG69W1SUwV0mNcKuKz");
	//		return context;
	//	}
	public void logon()
	{
		//APIContext context = new APIContext("AU7NZ3WEh02I2gTSZ14TECenuI0-j0c6Cd9nnqypZdUqPPgkG0mBFrxUkdbcnBS5utU0YVZi4YWcZmn0", "EGzfUcrmh3Sq4fkdMi1NAwWxW0YHBlToNtwUfPDQ0peVqqUVkQSzE4pkZTP6FHiG69W1SUwV0mNcKuKz");
		Map <String, String> oHeaders = new HashMap <String, String>();
		oHeaders.put("Content-Type", "application/x-www-form-urlencoded");
		oHeaders.put("Accept", "application/json");
		oHeaders.put("Accept-Language", "en_US");
		String strAuth= strClientID +":" +strClientSecret;
		byte[] encodedBytes = Base64.getEncoder().encode(strAuth.getBytes());
		System.out.println("encodedBytes " + new String(encodedBytes));
		oHeaders.put("Authorization",new String( "Basic "+new String(encodedBytes)) );
		List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("grant_type", "client_credentials"));



		try {
			HttpEntity oResultEntity = doHTTPPost(params,oHeaders);
//			printEntity(oResultEntity);

			JSONObject oj =getJSONFromEntity(oResultEntity);

			strAPPID=oj.getString("app_id"); 
			strAccessToken = oj.getString("access_token"); 
			System.out.println("Paypal: Verbindung mit APP "+strAPPID+" erfolgreich hergestellt");
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//	return context;
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//	Public PaypalConnect() {
	//        HttpRequest req = new HttpRequest();
	//        req.setEndpoint("https://api.sandbox.paypal.com/v1/oauth2/token");
	//        req.setMethod("POST");
	//        req.setHeader("Content-Type", "application/x-www-form-urlencoded");
	//        req.setHeader("Accept", "application/json");
	//        req.setHeader("Accept-Language", "en_US");
	//        Blob headerValue = Blob.valueOf("clientId:secret"); //clientId:secret replaced with my paypal org creds
	//        system.debug("***Header:" + headerValue);
	//        String authorizationHeader = "Basic " + EncodingUtil.base64Encode(headerValue);
	//        system.debug("***:" + EncodingUtil.base64Encode(headerValue));
	//        req.setHeader("Authorization", authorizationHeader);
	//        req.setBody("grant_type=client_credentials");
	//        Http http = new Http();
	//        HttpResponse response = http.send(req);
	//        system.debug("***mapBody" + response.getBody());
	//        Map < String, Object > mapBody = (Map < String, Object > ) JSON.deserializeUntyped(response.getBody());
	//        String access_token = (String) mapBody.get("access_token");
	//        Integer expires_in = Integer.valueOF(mapBody.get("expires_in"));
	//        system.debug("***access_token" + access_token);
	//        system.debug("***expires_in" + expires_in);
	//        makePayment(access_token);
	//    }
	//
	//    public void makePayment(String token) {
	//        HttpRequest req = new HttpRequest();
	//        req.setEndpoint("https://api.sandbox.paypal.com/v1/payments/payment");
	//        req.setMethod("POST");
	//        req.setHeader("Content-Type", "application/x-www-form-urlencoded");
	//        req.setHeader("Accept-Language", "en_US");
	//        req.setHeader("Accept", "application/json");
	//        String bToke = "Bearer " + token;
	//        req.setHeader("Authorization", bToke);
	//        String s = createPayment.generateJSONContent();
	//        system.debug("***s:" + s);
	//        req.setBody(s);
	//        Http http = new Http();
	//        HttpResponse response = http.send(req);
	//        system.debug("***mapBody" + response.getBody());
	//    }
	//
	@Override
	public int getHTTPOKCode() {
		// TODO Auto-generated method stub
		return 200;
	}

}
