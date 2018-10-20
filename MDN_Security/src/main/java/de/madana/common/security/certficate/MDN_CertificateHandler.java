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
package de.madana.common.security.certficate;

import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.Provider;
import java.security.Security;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class MDN_CertificateHandler.
 */
public class MDN_CertificateHandler
{
	
	/**
	 * Self sign.
	 *
	 * @param keyPair the key pair
	 * @param subjectDN the subject DN
	 * @return the x 509 certificate
	 * @throws OperatorCreationException the operator creation exception
	 * @throws CertificateException the certificate exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static X509Certificate selfSign(KeyPair keyPair, String subjectDN) throws OperatorCreationException, CertificateException, IOException
	{
	    Provider bcProvider = new BouncyCastleProvider();
	    Security.addProvider(bcProvider);

	    long now = System.currentTimeMillis();
	    Date startDate = new Date(now);

	    X500Name dnName = new X500Name("CN=Sample Cert, OU=R&D, O=Company Ltd., L=Dublin 4,C=IE");
	    BigInteger certSerialNumber = new BigInteger(Long.toString(now)); // <-- Using the current timestamp as the certificate serial number

	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(startDate);
	    calendar.add(Calendar.YEAR, 1); // <-- 1 Yr validity

	    Date endDate = calendar.getTime();

	    String signatureAlgorithm = "SHA256WithRSA"; // <-- Use appropriate signature algorithm based on your keyPair algorithm.

	    ContentSigner contentSigner = new JcaContentSignerBuilder(signatureAlgorithm).build(keyPair.getPrivate());

	    JcaX509v3CertificateBuilder certBuilder = new JcaX509v3CertificateBuilder(dnName, certSerialNumber, startDate, endDate, dnName, keyPair.getPublic());

	    // Extensions --------------------------

	    // Basic Constraints
	    BasicConstraints basicConstraints = new BasicConstraints(true); // <-- true for CA, false for EndEntity

	    certBuilder.addExtension(new ASN1ObjectIdentifier("2.5.29.19"), true, basicConstraints); // Basic Constraints is usually marked as critical.

	    // -------------------------------------

	    return new JcaX509CertificateConverter().setProvider(bcProvider).getCertificate(certBuilder.build(contentSigner));
	}
	
	/**
	 * Convert to pem.
	 *
	 * @param cert the cert
	 * @return the string
	 * @throws CertificateEncodingException the certificate encoding exception
	 */
	public static String convertToPem(X509Certificate cert) throws CertificateEncodingException 
	{
		 Base64 encoder = new Base64(64);
		 String cert_begin = "-----BEGIN CERTIFICATE-----\n";
		 String end_cert = "-----END CERTIFICATE-----";

		 byte[] derCert = cert.getEncoded();
		 String pemCertPre = new String(encoder.encode(derCert));
		 String pemCert = cert_begin + pemCertPre + end_cert;
		 return pemCert;
		}
}
