package de.digiclothes.server.web.rest;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 * @author Jean
 *
 */
public abstract class DC_A_RestClient 
{
	CloseableHttpClient httpClient;
	String strDestUrl;
	protected DC_A_RestClient( String strDestUrl)
	{
		httpClient = HttpClientBuilder.create().build();
		this.strDestUrl=strDestUrl;
	}
	HttpEntity doHTTPGet() throws ClientProtocolException, IOException
	{
		HttpGet httpGetRequest = new HttpGet(strDestUrl);
		HttpResponse httpResponse = httpClient.execute(httpGetRequest);

		System.out.println("----------------------------------------");
		System.out.println(httpResponse.getStatusLine());
		System.out.println("----------------------------------------");

		// Get hold of the response entity
		return httpResponse.getEntity();
	}

	protected HttpEntity doHTTPPost(List<BasicNameValuePair> params, Map<String, String> oHeader) throws ClientProtocolException, IOException
	{	
		HttpPost postRequest = new HttpPost(strDestUrl);
		if(oHeader!=null)
			for (Entry e : oHeader.entrySet())
			{ 
				postRequest.addHeader( e.getKey().toString(),  e.getValue().toString());		    
			}
		//postRequest.addHeader("Authorization", "AU7NZ3WEh02I2gTSZ14TECenuI0-j0c6Cd9nnqypZdUqPPgkG0mBFrxUkdbcnBS5utU0YVZi4YWcZmn0:EGzfUcrmh3Sq4fkdMi1NAwWxW0YHBlToNtwUfPDQ0peVqqUVkQSzE4pkZTP6FHiG69W1SUwV0mNcKuKz");
		postRequest.setEntity(new org.apache.http.client.entity.UrlEncodedFormEntity(params));

		HttpResponse response = httpClient.execute(postRequest);

		if (response.getStatusLine().getStatusCode() != getHTTPOKCode()) 
		{
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatusLine().getStatusCode());
		}
		return response.getEntity();
	}
	public abstract int getHTTPOKCode();
	public JSONObject getJSONFromEntity(HttpEntity oEntity) throws ParseException, IOException, JSONException
	{
		 JSONObject result=null;
	       if (oEntity != null) {
	           String retSrc = EntityUtils.toString(oEntity); 
	           // parsing JSON
	            result = new JSONObject(retSrc); //Convert String to JSON Object

	        }
	       return result;
	}
	protected void printEntity(HttpEntity entity) throws UnsupportedOperationException, IOException
	{
		byte[] buffer = new byte[1024];
		if (entity != null) 
		{
			InputStream inputStream = entity.getContent();
			try {
				int bytesRead = 0;
				BufferedInputStream bis = new BufferedInputStream(inputStream);
				while ((bytesRead = bis.read(buffer)) != -1) {

					String chunk = new String(buffer, 0, bytesRead);
					System.out.println(chunk);
				}
			} catch (IOException ioException) 
			{
				// In case of an IOException the connection will be released
				// back to the connection manager automatically
				ioException.printStackTrace();
			} catch (RuntimeException runtimeException)
			{
				// In case of an unexpected exception you may want to abort
				// the HTTP request in order to shut down the underlying
				// connection immediately.
				//	httpGetRequest.abort();
				runtimeException.printStackTrace();
			} finally 
			{
				// Closing the input stream will trigger connection release
//				try
//				{
//					inputStream.close();
//				} 
//				catch (Exception ignore)
//				{
//				}
			}
		}

	}



}