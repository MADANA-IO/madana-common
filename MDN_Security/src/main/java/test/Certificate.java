package test;

import java.io.IOException;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import org.bouncycastle.operator.OperatorCreationException;

import de.madana.common.MD_FileHandler;
import de.madana.common.security.GenerateKeys;
import de.madana.security.certficate.MDN_CertificateHandler;

public class Certificate {

	public static void main(String[] args) 
	{
		GenerateKeys gk;
		try {
//			gk = new GenerateKeys(4096);
//			gk.createKeys();
//			X509Certificate oCert = MDN_Certficatehandler.selfSign(gk.getKeypair(),"Test");
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
	        keyGen.initialize(512);
			X509Certificate oCert = MDN_CertificateHandler.selfSign(keyGen.generateKeyPair(),"Test");
			String strPEM = MDN_CertificateHandler.convertToPem(oCert);
			MD_FileHandler.writeToFile("C:\\Temp\\Test.crt", strPEM);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OperatorCreationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}

}
