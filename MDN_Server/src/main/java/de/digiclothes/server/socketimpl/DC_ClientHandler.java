package de.digiclothes.server.socketimpl;



import java.io.ObjectInputStream;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import de.digiclothes.server.DC_ServerSessionManager;
import de.digiclothes.server.ifc.ConnectorCommunicationService;
import de.digiclothes.server.ifc.ConnectorDescription;
import de.digiclothes.server.object.DC_Shop;
import de.madana.common.utils.DC_A_SocketCommunication;


/**
 * Handler Klasse für einzelne Client Verbindungen
 * @author Jean
 *
 */
public class DC_ClientHandler
{

// extends DC_A_SocketCommunication 
//
//	protected String strUser;
//	protected DC_Shop oShop;
//
//	/**
//	 * Handler für einzelne Client Verbindungen
//	 * @param oDestSocket - Socket auf dem die Verbindung hergestellt wurde
//	 * @throws Exception - falls Benutzer nicht authentifiziert werden kann
//	 * @author Jean
//	 */
//	public DC_ClientHandler(Socket oDestSocket) throws Exception
//	{
//		super(oDestSocket);
//		if(! initClient(in.readLine()))
//			throw new Exception ("Benutzer konnte nicht angemeldet werden");
//	}
//	/*
//	 * (non-Javadoc)
//	 * @see de.madana.common.DC_A_SocketCommunication#setSessionCancelled()
//	 */
//	protected  void setSessionCancelled() 
//	{
//		super.setSessionCancelled();
//		DC_ServerSessionManager.deregisterSession(this);
//	}
//	/*
//	 * (non-Javadoc)
//	 * @see de.madana.common.DC_A_SocketCommunication#getAction(java.lang.String)
//	 */
//	protected  String getAction(String strInput)
//	{
//
//		try
//		{
//			if(getCommand(strInput).equals("REGISTERSHOP"))	
//				return registerShop(getCommandText(strInput));
//			else if(getCommand(strInput).equals("VERIFYSHOP"))	
//				return verifyShop(getCommandText(strInput));
//			else if(getCommand(strInput).equals("REGISTERINTERFACES"))	
//				return registerInterfaces(getCommandText(strInput));
//		}
//		catch(Exception e)
//		{
//			return "NACK|"+e.toString();
//		}
//
//		return super.getAction(strInput);
//	}
//	/**
//	 * 
//	 * @param strCommandText
//	 * @return
//	 * @throws NoSuchAlgorithmException
//	 */
//	private String registerInterfaces(String strCommandText) throws NoSuchAlgorithmException 
//	{
//		String[] aInterfaceSequence = strCommandText.split("\\|");
//		List <ConnectorDescription> oInterfaces =oShop.registerInterfaces(aInterfaceSequence);
//		StringBuilder oStringBuilder = new StringBuilder();
//		oStringBuilder.append("ACK");
//		for(int i=0; i< oInterfaces.size(); i++)
//		{
//			oStringBuilder.append("|");
//			oStringBuilder.append(oInterfaces.get(i).getId());
//		}
//		return oStringBuilder.toString();
//	}
//	/**
//	 * Registriert einen neuen Shop / Connector und legt ihn damit in der Datenbank an
//	 * @param strCommandText
//	 * @return
//	 * @throws NoSuchAlgorithmException
//	 * @throws SQLException
//	 * @author Jean
//	 */
//	private String registerShop(String strCommandText) throws NoSuchAlgorithmException, SQLException 
//	{
//		String[] aShopSequence = strCommandText.split("\\|");
//		if(aShopSequence.length<6)
//			return "NACK|Register Fehlgeschlagen, unvollstaendiger Datensatz" ;
//		DC_Shop oShop = new DC_Shop(aShopSequence[0], aShopSequence[1], aShopSequence[2], aShopSequence[3], aShopSequence[4], aShopSequence[5]);
//		return "ACK|"+DC_Shop.commitShop(oShop);
//	}
//
//
//	/**
//	 * Initiert eine neue Clientverbindung und verifiziert dabei die Nutzerdaten
//	 * @param strMessage
//	 * @return
//	 * @author Jean
//	 */
//	private synchronized boolean initClient(String strMessage) 
//	{
//		if(!getCommand(strMessage).equals("VERIFY"))
//			return false;
//		try
//		{
//			String strCommandParams = getCommandText(strMessage);
//
//			if(verifyUser(getCommand(strCommandParams),getCommandText(strCommandParams)))
//			{
//				out.println("ACK");
//				out.flush();
//			}
//			else
//			{
//				out.println("NACK");
//				out.flush();
//			}
//
//		}
//		catch(Exception e)
//		{
//			out.println("NACK");
//			out.flush();
//			return false;
//		}
//
//		return true;
//	}
//	/**
//	 * Überprüft ob es sich bei den Übergebenen Daten um einen gültigen Benutzer handelt
//	 * @param strUserName
//	 * @param strUserPassword
//	 * @return
//	 */
//	private synchronized boolean verifyUser(String strUserName, String strUserPassword) 
//	{
//		strUser= strUserName;
//		Thread.currentThread().setName(strUserName+oSocket.getRemoteSocketAddress().toString());
//		return true;
//		//		//resourceManager = new ResourceManager(User);
//		//		System.out.println(User + " checking password..");
//		//		if (verifyPassword())
//		//		{
//		//			System.out.println(User + " eingeloggt!");
//		//			return  true;	
//		//		}
//		//		return false;
//
//	}
//
//	/**
//	 * Überprüft ob es sich bei der übergebenen Shop Lizenz um einen in der Datenbank befindlichen Shop handelt
//	 * @param strCommandText
//	 * @return
//	 * @throws Exception
//	 */
//	private String verifyShop(String strCommandText) throws Exception 
//	{
//		oShop = new DC_Shop(strCommandText);
//		Thread.currentThread().setName("["+strUser+"@"+oShop.getName()+"]"+oSocket.getRemoteSocketAddress().toString());
//		DC_ServerSessionManager.registerSession(this);
//		oShop.setSession(this);
//		return "ACK|"+ oShop.getName();
//	}
//
//	@Override
//	/*
//	 * (non-Javadoc)
//	 * @see de.digiclothes.servercomlib.api.ConnectorCommunicationService#getActiveConnectors()
//	 */
//	public List<ConnectorDescription> getActiveConnectors() {
//		// TODO Auto-generated method stub
//		return oShop.getInterfaces();
//	}
//
//	@Override
//	/*
//	 * (non-Javadoc)
//	 * @see de.digiclothes.servercomlib.api.ConnectorCommunicationService#askForShoppingCart(java.lang.String)
//	 */
//	public CompletableFuture<Optional<ShoppingCart>> askForShoppingCart(
//			String connectorId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	/*
//	 * (non-Javadoc)
//	 * @see de.digiclothes.servercomlib.api.ConnectorCommunicationService#notifyConnectorAboutSuccessfulPayment(java.lang.String, de.madana.common.datastructures.ShoppingCart)
//	 */
//	public CompletableFuture<Void> notifyConnectorAboutSuccessfulPayment(
//			String connectorId, ShoppingCart shoppingCart) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	/**
//	 * Gibt den authentifizierten Shop für diese Session zurück
//	 * @return
//	 */
//	public DC_Shop getShop() 
//	{
//		return oShop;
//	}
//	/*
//	 * (non-Javadoc)
//	 * @see java.lang.Object#toString()
//	 */
//	public String toString()
//	{
//		return Thread.currentThread().getName();
//	}
//	@Override
//	/*
//	 * (non-Javadoc)
//	 * @see de.digiclothes.servercomlib.api.ConnectorCommunicationService#getShoppingCart(java.lang.String)
//	 */
//	public DC_ShoppingCart getShoppingCart(String strConnectorId) throws Exception 
//	{
//		synchronized(in)
//		{
//			out.println("GETSHOPPINGCART|"+strConnectorId);
//			out.flush();
//		
//
//			ObjectInputStream ois = new ObjectInputStream(oSocket.getInputStream());
//			DC_ShoppingCart oShoppingcart;
//			while(!in.ready())
//				Thread.sleep(100);
//			oShoppingcart = (DC_ShoppingCart) ois.readObject();
//
//
//			return oShoppingcart;
//
//		}
//
//	}

}
