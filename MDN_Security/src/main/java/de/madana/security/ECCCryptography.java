/*******************************************************************************
 * Copyright (C) 2018 MADANA
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * @organization:MADANA
 * @author:Jean-Fabian Wenisch
 * @contact:dev@madana.io
 ******************************************************************************/
package de.madana.security;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.ECGenParameterSpec;

import javax.crypto.KeyAgreement;

public class ECCCryptography 
{

	 public static void generateKey() throws Exception 
	 {
		    KeyPairGenerator kpg;
		    kpg = KeyPairGenerator.getInstance("EC","SunEC");
		    ECGenParameterSpec ecsp;
		    ecsp = new ECGenParameterSpec("secp192r1");
		    kpg.initialize(ecsp);

		    KeyPair kp = kpg.genKeyPair();
		    PrivateKey privKey = kp.getPrivate();
		    PublicKey pubKey = kp.getPublic();

		    System.out.println(privKey.toString());
		    System.out.println(pubKey.toString());
		  }
	 
	 public static void keyAgreement() throws Exception 
	 {
		    KeyPairGenerator kpg;
		    kpg = KeyPairGenerator.getInstance("EC","SunEC");
		    ECGenParameterSpec ecsp;

		    ecsp = new ECGenParameterSpec("secp192k1");
		    kpg.initialize(ecsp);

		    KeyPair kpU = kpg.genKeyPair();
		    PrivateKey privKeyU = kpU.getPrivate();
		    PublicKey pubKeyU = kpU.getPublic();
		    System.out.println("User U: " + privKeyU.toString());
		    System.out.println("User U: " + pubKeyU.toString());

		    KeyPair kpV = kpg.genKeyPair();
		    PrivateKey privKeyV = kpV.getPrivate();
		    PublicKey pubKeyV = kpV.getPublic();
		    System.out.println("User V: " + privKeyV.toString());
		    System.out.println("User V: " + pubKeyV.toString());

		    KeyAgreement ecdhU = KeyAgreement.getInstance("ECDH");
		    ecdhU.init(privKeyU);
		    ecdhU.doPhase(pubKeyV,true);

		    KeyAgreement ecdhV = KeyAgreement.getInstance("ECDH");
		    ecdhV.init(privKeyV);
		    ecdhV.doPhase(pubKeyU,true);

		    System.out.println("Secret computed by U: 0x" + 
		                       (new BigInteger(1, ecdhU.generateSecret()).toString(16)).toUpperCase());
		    System.out.println("Secret computed by V: 0x" + 
		                       (new BigInteger(1, ecdhV.generateSecret()).toString(16)).toUpperCase());
		  }
	 public static void sign() throws Exception 
	 {
		    KeyPairGenerator kpg;
		    kpg = KeyPairGenerator.getInstance("EC","SunEC");

		    ECGenParameterSpec ecsp;
		    ecsp = new ECGenParameterSpec("sect163k1");
		    kpg.initialize(ecsp);

		    KeyPair kp = kpg.genKeyPair();
		    PrivateKey privKey = kp.getPrivate();
		    PublicKey pubKey = kp.getPublic();
		    System.out.println(privKey.toString());
		    System.out.println(pubKey.toString());
		    
		    Signature ecdsa;
		    ecdsa = Signature.getInstance("SHA1withECDSA","SunEC");
		    ecdsa.initSign(privKey);

		    String text = "In teaching others we teach ourselves";
		    System.out.println("Text: " + text);
		    byte[] baText = text.getBytes("UTF-8");

		    ecdsa.update(baText);
		    byte[] baSignature = ecdsa.sign();
		    System.out.println("Signature: 0x" + (new BigInteger(1, baSignature).toString(16)).toUpperCase());

		    Signature signature;
		    signature = Signature.getInstance("SHA1withECDSA","SunEC");
		    signature.initVerify(pubKey);
		    signature.update(baText);
		    boolean result = signature.verify(baSignature);
		    System.out.println("Valid: " + result);
		  }
}
