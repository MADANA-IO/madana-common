package de.madana.security.certficate;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Enumeration;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.Attribute;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.ExtendedKeyUsage;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.KeyPurposeId;
import org.bouncycastle.asn1.x509.KeyUsage;
import org.bouncycastle.cert.CertIOException;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509ExtensionUtils;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.pkcs.jcajce.JcaPKCS10CertificationRequest;


public class MDN_CAHandler {
	private X509Certificate signCertificateRequest(X509Certificate caCert, PrivateKey caPrivateKey, PKCS10CertificationRequest csr,
			Date notBefore, Date notAfter)
					throws NoSuchAlgorithmException, InvalidKeyException, CertificateException, CertIOException, OperatorCreationException {

		JcaPKCS10CertificationRequest jcaRequest = new JcaPKCS10CertificationRequest(csr);
		X509v3CertificateBuilder certificateBuilder = new JcaX509v3CertificateBuilder(caCert,
				BigInteger.valueOf(System.currentTimeMillis()), notBefore, notAfter, jcaRequest.getSubject(), jcaRequest.getPublicKey());

		JcaX509ExtensionUtils extUtils = new JcaX509ExtensionUtils();
		certificateBuilder.addExtension(Extension.authorityKeyIdentifier, false, extUtils.createAuthorityKeyIdentifier(caCert))
		.addExtension(Extension.subjectKeyIdentifier, false, extUtils.createSubjectKeyIdentifier(jcaRequest.getPublicKey()))
		.addExtension(Extension.basicConstraints, true, new BasicConstraints(0))
		.addExtension(Extension.keyUsage, true, new KeyUsage(KeyUsage.digitalSignature | KeyUsage.keyEncipherment))
		.addExtension(Extension.extendedKeyUsage, true, new ExtendedKeyUsage(KeyPurposeId.id_kp_serverAuth));

		// add pkcs extensions
		org.bouncycastle.asn1.pkcs.Attribute[] attributes = csr.getAttributes();
		for (org.bouncycastle.asn1.pkcs.Attribute attr : attributes) {
			// process extension request
			if (attr.getAttrType().equals(PKCSObjectIdentifiers.pkcs_9_at_extensionRequest)) {
				Extensions extensions = Extensions.getInstance(attr.getAttrValues().getObjectAt(0));
				Enumeration e = extensions.oids();
				while (e.hasMoreElements()) {
					ASN1ObjectIdentifier oid = (ASN1ObjectIdentifier) e.nextElement();
					Extension ext = extensions.getExtension(oid);
					certificateBuilder.addExtension(oid, ext.isCritical(), ext.getParsedValue());
				}
			}
		}

		ContentSigner signer = new JcaContentSignerBuilder("SHA1withRSA").setProvider("BC").build(caPrivateKey);
		return new JcaX509CertificateConverter().setProvider("BC").getCertificate(certificateBuilder.build(signer));
	}
	private String convertCertificateToPEM(X509Certificate signedCertificate) throws IOException {
		StringWriter signedCertificatePEMDataStringWriter = new StringWriter();
		JcaPEMWriter pemWriter = new JcaPEMWriter(signedCertificatePEMDataStringWriter);
		pemWriter.writeObject(signedCertificate);
		pemWriter.close();
		return signedCertificatePEMDataStringWriter.toString();
	}
}
