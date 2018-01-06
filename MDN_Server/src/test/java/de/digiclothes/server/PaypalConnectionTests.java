package de.digiclothes.server;

import de.digiclothes.server.payment.paypal.DC_PaypalRestClient;

public class PaypalConnectionTests 
{
	public static void main(String[] args) 
	{
		DC_PaypalRestClient oClient = new DC_PaypalRestClient("https://api.sandbox.paypal.com/v1/oauth2/token");
		oClient.logon();
		System.out.println("");
	}
}
