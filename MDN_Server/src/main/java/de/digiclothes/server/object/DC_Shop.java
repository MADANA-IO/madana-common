package de.digiclothes.server.object;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import de.digiclothes.server.ifc.ConnectorDescription;
import de.digiclothes.server.socketimpl.DC_ClientHandler;
import de.madana.common.database.DC_SQLTable;
import de.madana.common.security.DC_HashHandler;
/**
 * 
 * @author Jean
 *
 */
public class DC_Shop 
{
	String strID;
	String strName;
	String strURL;
	String strAddress;
	String strPostCode;
	String strPlace;
	String strCountry;
	String strLicense;
	DC_ClientHandler oSession;
	List <ConnectorDescription> oInterfaces = new ArrayList<ConnectorDescription>();
	private static DC_SQLTable oReferencedSQLTable = new DC_SQLTable("Shops");
	static SimpleDateFormat s_simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
	/**
	 * 
	 * @param strName - Name des Shops
	 * @param strURL - Homepage des Shops
	 * @param strAddress - Straße + Hausnummer des Shops
	 * @param strPostCode - PLZ des Shops
	 * @param strPlace - Ort des Shops
	 * @param strCountry - Land des Shops
	 * @throws NoSuchAlgorithmException
	 */
	public DC_Shop(String strName, String strURL, String strAddress, String strPostCode, String strPlace, String strCountry) throws NoSuchAlgorithmException
	{
		this.strName=strName;
		this.strURL=strURL;
		this.strAddress=strAddress;
		this.strPostCode=strPostCode;
		this.strPlace=strPlace;
		this.strCountry=strCountry;
		generateLicense();
	}
	public DC_Shop(String strLicense) throws Exception 
	{
//		try
//		{
//			ResultSet oSet=oReferencedSQLTable.getEntries("SHOP_LICENSE", strLicense);
//			if(oSet.next())
//			{
//				strID = oSet.getString(1);
//				strName= oSet.getString(2);
//				strURL=oSet.getString(3);
//				strAddress=oSet.getString(4);
//				strPostCode=oSet.getString(5);
//				strPlace=oSet.getString(6);
//				strCountry=oSet.getString(7);
//				strLicense=oSet.getString(8);
//			}
//			else
//			{
//				throw new Exception ("Unbekannter Shop");
//			}
//		}
//		catch(Exception e)
//		{
//			throw new Exception ("Unbekannter Shop");
//		}
	}
	public List<ConnectorDescription> registerInterfaces(String[] aInterfaceSequence) throws NoSuchAlgorithmException
	{
		oInterfaces = new ArrayList<ConnectorDescription>();
		for(int i=0; i < aInterfaceSequence.length; i++)
		{
			StringBuilder oBuilder = new StringBuilder();

			oBuilder.append(DC_HashHandler.generateMD5Hash(UUID.randomUUID().toString()));
			oBuilder.append(DC_HashHandler.generateMD5Hash(strID));
			oBuilder.append(DC_HashHandler.generateMD5Hash(aInterfaceSequence[i]));
			ConnectorDescription oCurrentInterface = new ConnectorDescription(oBuilder.toString(), aInterfaceSequence[i]);
			oInterfaces.add(oCurrentInterface);
		}
		return oInterfaces;
	}
	public static String commitShop(DC_Shop oShop) throws SQLException
	{

		ArrayList<String> oValues = new ArrayList<String>();
		oValues.add(oShop.strName);
		oValues.add(oShop.strURL);
		oValues.add(oShop.strAddress);
		oValues.add(oShop.strPostCode);
		oValues.add(oShop.strPlace);
		oValues.add(oShop.strCountry);
		oValues.add(oShop.strLicense);
		oReferencedSQLTable.addEntry(oValues);
		return oShop.strLicense;
	}
	/**
	 * 
	 * @throws NoSuchAlgorithmException
	 */
	private void generateLicense() throws NoSuchAlgorithmException
	{
		StringBuilder oBuilder = new StringBuilder();

		oBuilder.append(DC_HashHandler.generateMD5Hash(UUID.randomUUID().toString()));
		oBuilder.append(DC_HashHandler.generateMD5Hash(strName));
		oBuilder.append(DC_HashHandler.generateMD5Hash(strURL));
		oBuilder.append(DC_HashHandler.generateMD5Hash(strAddress));
		oBuilder.append(DC_HashHandler.generateMD5Hash(strPostCode));
		oBuilder.append(DC_HashHandler.generateMD5Hash(strPlace));
		oBuilder.append(DC_HashHandler.generateMD5Hash(s_simpleDateFormat.format(new Date())));
		strLicense = oBuilder.toString();

	}
	public String getName() 
	{
		return strName;
	}
	public List <ConnectorDescription> getInterfaces()
	{
		return oInterfaces;
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return getName()+" "+getInterfaces().size() +" Interfaces";
	}
//	public void setSession(DC_ClientHandler oClientHandler)
//	{
//		oSession= oClientHandler;
//		
//	}
//	public DC_ClientHandler getSession()
//	{
//		return oSession;
//	}
}

