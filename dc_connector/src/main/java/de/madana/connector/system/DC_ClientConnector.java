package de.madana.connector.system;

import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

import de.madana.common.DC_A_SocketCommunication;
import de.madana.common.DC_ConfigHandler;


public class DC_ClientConnector extends DC_A_SocketCommunication
{
	private boolean isInitialized=false;
	public DC_ClientConnector(Socket oDestSocket) throws IOException
	{
		super(oDestSocket);
		if(verifyUser())	
		{

			isInitialized=true;
			System.out.println("CLIENT:Verbindung mit "+getRemoteAddress()+" hergestellt");
			if(	verifyShop())
			{
				try {
					registerInterfaces();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	protected  String getAction(String strInput)
	{

//		try
//		{
//			if(getCommand(strInput).equals("GETSHOPPINGCART"))	
//				return getShoppingCart(getCommandText(strInput));
//		}
//		catch(Exception e)
//		{
//			return "NACK|"+e.toString();
//		}

		return super.getAction(strInput);
	}


//	private String getShoppingCart(String strCommandText) throws Exception 
//	{
//		DC_A_RFIDAntenna oAntenna =DC_A_RFIDAntenna.getRegisteredAntenna(strCommandText);
//		if(oAntenna == null)
//			{
//			throw new Exception("Unknown Interface "+strCommandText);
//			}
//		else
//		{
//			ObjectOutputStream oos = new ObjectOutputStream(oSocket.getOutputStream());
//			oos.writeObject(oAntenna.getShoppingCart());
//			oos.flush();
//		}
//		return null;
//	}

	private  synchronized boolean verifyUser() 
	{

		try 
		{
			sendCommand("VERIFY","TESTUSER|TESTPASSWORD");
			System.out.println("Benutzer erfolgreich angemeldet");
			return true;
		} catch (Exception e1) 
		{
			e1.printStackTrace();
			return false;
		}


	}
	private synchronized boolean verifyShop()
	{
		try 
		{
			DC_ConfigHandler oLicenseConfig = new DC_ConfigHandler(new File("./conf/license"));
			String strResponse =sendCommand("VERIFYSHOP",oLicenseConfig.getProperty("LICENSE"));

			if(strResponse.startsWith("ACK"))
			{
				System.out.println("Shop"+getCommandText(strResponse)+" erfolgreich angemeldet");
				return true;
			}
			else
				return false;

		} catch (Exception e1) 
		{
			e1.printStackTrace();
			return false;
		}

	}

	public  boolean isInitialized()
	{
		return isInitialized;
	}


	public  synchronized String registerShop(String strShopSequence) throws Exception 
	{

		String strMessage = sendCommand("REGISTERSHOP",strShopSequence);
		return strMessage.substring(strMessage.indexOf("|")+1, strMessage.length());
	}
	public synchronized void registerInterfaces() throws Exception
	{
		List<String> oPorts = DC_SerialPortHandler.getPortNames();
		StringBuilder oStringBuilder = new StringBuilder();
		String strMessage = null;
		if(oPorts.size()==0)
		{
			strMessage = sendCommand("REGISTERINTERFACES","DUMMY");
		}
		else
		{
			for(int i=0; i < oPorts.size();i++)
			{
				if(i>0)
					oStringBuilder.append("|");
				oStringBuilder.append(oPorts.get(i));
			}
			strMessage = sendCommand("REGISTERINTERFACES",oStringBuilder.toString());
		}


		String[] aInterfaces = getCommandText(strMessage).split("\\|");
//			

	}


}