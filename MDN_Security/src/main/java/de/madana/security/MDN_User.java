package de.madana.security;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import de.madana.common.database.DC_SQLTable;

public class MDN_User 
{
	DC_SQLTable tblUser;
	DC_SQLTable tblDatakey;
	String strPassword; //TODO: Change to char Array;
	String strLogin;
	String strDataKey;
	public MDN_User(String strLogin, String strPassword )
	{
		tblUser = new DC_SQLTable("MDN_CRYPTFILE");
		tblDatakey = new DC_SQLTable("MDN_DATAKEYS");
		this.strPassword = strPassword;
		this.strLogin= strLogin;
	}
	public String getDataKey()
	{
		return strDataKey;
	}
	public void create(String strRandomnizer) throws Exception
	{
		ArrayList <Object> oUserData = new ArrayList<Object> ();
		oUserData.add(strLogin);
		ArrayList <Object> oDatakeyData  = new ArrayList<Object> ();
		oDatakeyData.add(String.valueOf(tblUser.getRowCount()+1));
		strDataKey = strRandomnizer;

		//Salts in DB speichern
		byte[] bUserSalt= MDN_Password.generateSalt();
		oUserData.add(bUserSalt);
		System.out.println("USERSALT:" +bUserSalt );
		byte[] bDataKeySalt = MDN_Password.generateSalt();
		oDatakeyData.add(bDataKeySalt);
		System.out.println("DATASALT:" +bDataKeySalt );

		String strDataKeyEncryptionKey = MDN_Password.hash(strPassword, bDataKeySalt);
		String strHashedUserPassword = MDN_Password.hash(strPassword, bUserSalt);

		SymmetricCryptography oCrypt =new SymmetricCryptography(strDataKey, 16, "AES");
		byte[] strCryptedUserPassword = oCrypt.encrypt(strHashedUserPassword.getBytes());		
		oUserData.add(strCryptedUserPassword);// Encrypted Hashed Password in DB speichern
		System.out.println("USERENCRYPTEDPASSWORDHASH:" +strCryptedUserPassword );

		SymmetricCryptography oCrypt1 =new SymmetricCryptography(strDataKeyEncryptionKey, 16, "AES");
		System.out.println("DATAKEY:" +strDataKey );
		byte[] strCryptedDatakey = oCrypt1.encrypt(strDataKey.getBytes());
		oDatakeyData.add(strCryptedDatakey);
		System.out.println("DATAKEYENCRYPTED:" +strCryptedDatakey );
		oUserData.add("TRUE");
		oUserData.add("1"); //CRYPTMODE
		oUserData.add("TRUE"); // False
		tblUser.addEntry(oUserData);
		tblDatakey.addEntry(oDatakeyData);
	}

	public void load()  throws Exception
	{
		String strUserID = tblUser.getID("IDENT", strLogin);
		byte[] bDataKeySalt = (byte[]) tblDatakey.getEntryByKey("FK", strUserID, "SALT");
		String strDataKeyEncryptionKey = MDN_Password.hash(strPassword, bDataKeySalt);
		SymmetricCryptography oCrypt =new SymmetricCryptography(strDataKeyEncryptionKey, 16, "AES");
		byte[] bEncryptedDataKey = (byte[]) tblDatakey.getEntryByKey("FK", strUserID, "PW");; //verschlüsselten datakey aus Datenbank auslesen
		strDataKey = new String (oCrypt.decrypt(bEncryptedDataKey));

		SymmetricCryptography oCrypt1 =new SymmetricCryptography(strDataKey, 16, "AES");
		byte[] strCryptedUserPassword =(byte[]) tblUser.getEntryByKey("ID", strUserID, "PW"); //verschlüsselten Passwordhash aus Datenbank lesen
		byte [] strUnedcryptedUserPassword = oCrypt1.decrypt(strCryptedUserPassword);
		String strPasswordHash =MDN_Password.hash(strPassword, (byte[]) tblUser.getEntryByKey("ID", strUserID, "SALT"));
		if(strPasswordHash.equals(new String(strUnedcryptedUserPassword)))
		{
			System.out.println(strLogin + "erfolgreich authentifiziert");
		}
		else
		{
			System.out.println(strLogin + "konnte nicht authentifiziert werden");
		}
	}
}
