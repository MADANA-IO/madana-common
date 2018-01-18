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
	public MDN_User(String strLogin, String strPassword )
	{
		tblUser = new DC_SQLTable("MDN_USER");
		tblDatakey = new DC_SQLTable("MDN_DATAKEY");
		this.strPassword = strPassword;
		this.strLogin= strLogin;
	}

	public void create() throws Exception
	{
		ArrayList <Object> oUserData = new ArrayList<Object> ();
		oUserData.add(strLogin);
		ArrayList <Object> oDatakeyData  = new ArrayList<Object> ();
		oDatakeyData.add(String.valueOf(tblUser.getRowCount()+1));
		String strDataKey = new MDN_RandomString().nextString();

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
		tblUser.addEntry(oUserData);
		tblDatakey.addEntry(oDatakeyData);
	}

	public void load()  throws Exception
	{
		String strUserID = tblUser.getID("LOGIN", strLogin);
		byte[] bDataKeySalt = (byte[]) tblDatakey.getEntryByKey("USER", strUserID, "SALT");
		String strDataKeyEncryptionKey = MDN_Password.hash(strPassword, bDataKeySalt);
		SymmetricCryptography oCrypt =new SymmetricCryptography(strDataKeyEncryptionKey, 16, "AES");
		byte[] bEncryptedDataKey = (byte[]) tblDatakey.getEntryByKey("USER", strUserID, "DATA");; //verschlüsselten datakey aus Datenbank auslesen
		String strDataKey = new String (oCrypt.decrypt(bEncryptedDataKey));

		SymmetricCryptography oCrypt1 =new SymmetricCryptography(strDataKey, 16, "AES");
		byte[] strCryptedUserPassword =(byte[]) tblUser.getEntryByKey("ID", strUserID, "HASH"); //verschlüsselten Passwordhash aus Datenbank lesen
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
