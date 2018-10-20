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
package de.madana.common.security.test;

//Copyright (C) Leejae Karinja 2016

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.KeyPurposeId;
import org.bouncycastle.asn1.x509.KeyUsage;
import org.bouncycastle.asn1.x509.SubjectKeyIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.bc.BcX509ExtensionUtils;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class Client.
 */
public class Client {

  /** The host. */
  private String host;
  
  /** The port. */
  private int port;
  
  /** The nonce. */
  private byte[] nonce;
  
  /** The key data. */
  private byte[] keyData;
  
  /** The server. */
  private SSLSocket server;
  
  /** The writer. */
  private DataOutputStream writer;
  
  /** The reader. */
  private DataInputStream reader;

  /** The Constant PROVIDER_NAME. */
  private static final String PROVIDER_NAME = BouncyCastleProvider.PROVIDER_NAME;
  static {
      Security.addProvider(new BouncyCastleProvider());
  }
  
  /** The Constant SIGNATURE_ALGORITHM. */
  private static final String SIGNATURE_ALGORITHM = "SHA512withECDSA";
  
  /** The Constant KEY_GENERATION_ALGORITHM. */
  private static final String KEY_GENERATION_ALGORITHM = "ECDH";
  
  /** The Constant SSL_CONTEXT. */
  private static final String SSL_CONTEXT = "TLSv1.2";
  
  /** The Constant KEY_STORE_INSTANCE. */
  private static final String KEY_STORE_INSTANCE = "JKS";
  
  /** The Constant KMF_INSTANCE. */
  private static final String KMF_INSTANCE = "PKIX";
  
  /** The Constant BEFORE. */
  private static final Date BEFORE = new Date(System.currentTimeMillis() - 5000);
  
  /** The Constant AFTER. */
  private static final Date AFTER = new Date(System.currentTimeMillis() + 600000);

  /**
   * Default constructor.
   */
  Client() {

  }

  /**
   * Constructor with specified host and port.
   *
   * @param host Host to connect to
   * @param port Port to connect to
   */
  Client(String host, int port) {
      this.host = host;
      this.port = port;
  }

  /**
   * Generates a one time use secure random number to be used as the password
   * for a keystore.
   *
   * @return Returns void on completion
   */
  private void genNonce() {
      SecureRandom rand = new SecureRandom();
      this.nonce = new byte[2048];
      rand.nextBytes(nonce);
      return;
  }

  /**
   * Generates a one time use keystore for use with an SSL session.
   *
   * @return Returns void on completion
   */
  private void genKeystore() {
      try {
          KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_GENERATION_ALGORITHM, PROVIDER_NAME);
          KeyPair keyPair = keyPairGenerator.generateKeyPair();

          X509Certificate cert = createCACert(keyPair.getPublic(), keyPair.getPrivate());

          KeyStore ks = KeyStore.getInstance("JKS");
          ks.load(null, (new String(this.nonce)).toCharArray());
          byte[] tempPass = new byte[2048];
          new SecureRandom().nextBytes(tempPass);
          ks.setKeyEntry("foo.bar", keyPair.getPrivate(), new String(tempPass).toCharArray(), new java.security.cert.Certificate[] { cert });
          ByteArrayOutputStream os = new ByteArrayOutputStream();
          ks.store(os, (new String(this.nonce)).toCharArray());
          this.keyData = os.toByteArray();
          //System.out.println("Client Key Data: " + new String(this.keyData));
          //System.out.println("Client Public Cert Key: " + cert.getPublicKey());
          //System.out.println("Client Public Key: " + keyPair.getPublic());
          //System.out.println("Client Private Key: " + keyPair.getPrivate());
          os.close();
      } catch (Exception e) {
          e.printStackTrace();
      }
      return;
  }

  /**
   * Create a certificate to use by a Certificate Authority
   * 
   * Retrieved from http://www.programcreek.com/java-api-examples/index.php?class=org.bouncycastle.cert.X509v3CertificateBuilder&method=addExtension
   *
   * @param publicKey Public key
   * @param privateKey Private key
   * @return Generated X509 Certificate
   * @throws Exception the exception
   */
  private X509Certificate createCACert(PublicKey publicKey, PrivateKey privateKey) throws Exception {
      X500Name issuerName = new X500Name("CN=127.0.0.1, O=FOO, L=BAR, ST=BAZ, C=QUX");

      X500Name subjectName = issuerName;

      BigInteger serial = BigInteger.valueOf(new SecureRandom().nextInt());

      X509v3CertificateBuilder builder = new JcaX509v3CertificateBuilder(issuerName, serial, BEFORE, AFTER, subjectName, publicKey);
      builder.addExtension(Extension.subjectKeyIdentifier, false, createSubjectKeyIdentifier(publicKey));
      builder.addExtension(Extension.basicConstraints, true, new BasicConstraints(true));

      KeyUsage usage = new KeyUsage(KeyUsage.keyCertSign | KeyUsage.digitalSignature | KeyUsage.keyEncipherment | KeyUsage.dataEncipherment | KeyUsage.cRLSign);
      builder.addExtension(Extension.keyUsage, false, usage);

      ASN1EncodableVector purposes = new ASN1EncodableVector();
      purposes.add(KeyPurposeId.id_kp_serverAuth);
      purposes.add(KeyPurposeId.id_kp_clientAuth);
      purposes.add(KeyPurposeId.anyExtendedKeyUsage);
      builder.addExtension(Extension.extendedKeyUsage, false, new DERSequence(purposes));

      X509Certificate cert = signCertificate(builder, privateKey);
      cert.checkValidity(new Date());
      cert.verify(publicKey);

      return cert;
  }

  /**
   * Helper method
   * 
   * Retrieved from http://www.programcreek.com/java-api-examples/index.php?api=org.bouncycastle.cert.bc.BcX509ExtensionUtils
   *
   * @param key the key
   * @return the subject key identifier
   * @throws Exception the exception
   */
  private static SubjectKeyIdentifier createSubjectKeyIdentifier(Key key) throws Exception {
      ASN1InputStream is = new ASN1InputStream(new ByteArrayInputStream(key.getEncoded()));
      ASN1Sequence seq = (ASN1Sequence) is.readObject();
      is.close();
      @SuppressWarnings("deprecation")
      SubjectPublicKeyInfo info = new SubjectPublicKeyInfo(seq);
      return new BcX509ExtensionUtils().createSubjectKeyIdentifier(info);
  }

  /**
   * Helper method
   * 
   * Retrieved from http://www.programcreek.com/java-api-examples/index.php?source_dir=mockserver-master/mockserver-core/src/main/java/org/mockserver/socket/KeyStoreFactory.java
   *
   * @param certificateBuilder the certificate builder
   * @param signedWithPrivateKey the signed with private key
   * @return the x 509 certificate
   * @throws Exception the exception
   */
  private static X509Certificate signCertificate(X509v3CertificateBuilder certificateBuilder, PrivateKey signedWithPrivateKey) throws Exception {
      ContentSigner signer = new JcaContentSignerBuilder(SIGNATURE_ALGORITHM).setProvider(PROVIDER_NAME).build(signedWithPrivateKey);
      return new JcaX509CertificateConverter().setProvider(PROVIDER_NAME).getCertificate(certificateBuilder.build(signer));
  }

  /**
   * Sets the host to connect to.
   *
   * @param host Host to connect to
   * @return Returns void on completion
   */
  public void setHost(String host) {
      this.host = host;
      return;
  }

  /**
   * Sets the port to connect to.
   *
   * @param port Port to connect to
   * @return Returns void on completion
   */
  public void setPort(int port) {
      this.port = port;
      return;
  }

  /**
   * Starts the SSL session.
   *
   * @return Returns void on completion
   */
  protected void start() {
      try {
          if (this.nonce == null) this.genNonce();
          if (this.keyData == null) this.genKeystore();

          if (this.server == null) this.startConnection();
      } catch (Exception e) {
          e.printStackTrace();
      }
      return;
  }

  /**
   * Stopps the SSL session.
   *
   * @return Returns void on completion
   */
  protected void stop() {
      this.nonce = null;
      this.keyData = null;
      this.endConnection();
      return;
  }

  /**
   * Creates an SSL session.
   *
   * @return Returns void on completion
   */
  private void startConnection() {
      try {
          KeyStore ks = KeyStore.getInstance(KEY_STORE_INSTANCE);
          ks.load(new ByteArrayInputStream(this.keyData), (new String(this.nonce).toCharArray()));

          KeyManagerFactory kmf = KeyManagerFactory.getInstance(KMF_INSTANCE);
          kmf.init(ks, (new String(this.nonce).toCharArray()));

          SSLContext context = SSLContext.getInstance(SSL_CONTEXT);
          context.init(kmf.getKeyManagers(), null, new SecureRandom());

          SSLSocketFactory sf = context.getSocketFactory();

          this.server = (SSLSocket) sf.createSocket(this.host, this.port);
          this.server.setEnabledCipherSuites(this.server.getSupportedCipherSuites());
          this.server.setEnabledProtocols(this.server.getSupportedProtocols());
          this.server.startHandshake();

          this.writer = new DataOutputStream(this.server.getOutputStream());
          this.reader = new DataInputStream(this.server.getInputStream());
      } catch (Exception e) {
          e.printStackTrace();
      }
      return;
  }

  /**
   * Ends the SSL session.
   *
   * @return Returns void on completion
   */
  private void endConnection() {
      try {
          this.writer.close();
          this.reader.close();
          this.server.close();
      } catch (Exception e) {
          e.printStackTrace();
      }
      return;
  }

  /**
   * Sends data to the server.
   *
   * @param data Data to send to the server as a byte array
   * @return Returns void on completion
   */
  public void sendData(byte[] data) {
      try {
          int x = 0;
          for (x = 0; x < data.length; x++) {
              this.writer.writeByte(data[x]);
          }
          this.writer.writeByte(-1);
          this.writer.flush();
      } catch (Exception e) {
          e.printStackTrace();
      }
      return;
  }

  /**
   * Receives data from the server.
   *
   * @return Returns data received from the server as a byte array
   */
  public byte[] receiveData() {
      try {
          List<Byte> dataRead = new ArrayList<Byte>();
          byte temp = this.reader.readByte();
          while (temp != (-1)) {
              dataRead.add(temp);
              temp = this.reader.readByte();
          }
          Byte[] data = new Byte[dataRead.size()];
          data = dataRead.toArray(data);
          byte[] dataFinal = new byte[data.length];
          int x = 0;
          for (x = 0; x < data.length; x++) {
              dataFinal[x] = data[x].byteValue();
          }
          return dataFinal;
      } catch (Exception e) {
          e.printStackTrace();
          return null;
      }
  }
}
