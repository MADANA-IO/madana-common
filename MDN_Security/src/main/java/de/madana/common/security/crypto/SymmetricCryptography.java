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
package de.madana.common.security.crypto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;
// TODO: Auto-generated Javadoc

/**
 * The Class SymmetricCryptography.
 */
public class SymmetricCryptography 
{
	// Reflection based "Hack" to use 24 & 32 bit key sizes for AES without the need of external jar
	// https://stackoverflow.com/questions/6481627/java-security-illegal-key-size-or-default-parameters
	static
	{
	    String errorString = "Failed manually overriding key-length permissions.";
	    int newMaxKeyLength;
	    try {
	        if ((newMaxKeyLength = Cipher.getMaxAllowedKeyLength("AES")) < 256) {
	            Class c = Class.forName("javax.crypto.CryptoAllPermissionCollection");
	            Constructor con = c.getDeclaredConstructor();
	            con.setAccessible(true);
	            Object allPermissionCollection = con.newInstance();
	            Field f = c.getDeclaredField("all_allowed");
	            f.setAccessible(true);
	            f.setBoolean(allPermissionCollection, true);

	            c = Class.forName("javax.crypto.CryptoPermissions");
	            con = c.getDeclaredConstructor();
	            con.setAccessible(true);
	            Object allPermissions = con.newInstance();
	            f = c.getDeclaredField("perms");
	            f.setAccessible(true);
	            ((Map) f.get(allPermissions)).put("*", allPermissionCollection);

	            c = Class.forName("javax.crypto.JceSecurityManager");
	            f = c.getDeclaredField("defaultPolicy");
	            f.setAccessible(true);
	            Field mf = Field.class.getDeclaredField("modifiers");
	            mf.setAccessible(true);
	            mf.setInt(f, f.getModifiers() & ~Modifier.FINAL);
	            f.set(null, allPermissions);

	            newMaxKeyLength = Cipher.getMaxAllowedKeyLength("AES");
	        }
	    } catch (Exception e) {
	        throw new RuntimeException(errorString, e);
	    }
	    if (newMaxKeyLength < 256)
	        throw new RuntimeException(errorString); // hack failed
	}
	
	/** The secret key. */
	private SecretKeySpec secretKey;
	
	/** The cipher. */
	private Cipher cipher;

	/**
	 * Instantiates a new symmetric cryptography.
	 *
	 * @param secret the secret
	 * @param length the length
	 * @param algorithm the algorithm
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 * @throws NoSuchAlgorithmException the no such algorithm exception
	 * @throws NoSuchPaddingException the no such padding exception
	 */
	public SymmetricCryptography(String secret, int length, String algorithm)
			throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException {
		byte[] key = new byte[length];
		key = fixSecret(secret, length);
		this.secretKey = new SecretKeySpec(key, algorithm);
		this.cipher = Cipher.getInstance(algorithm);
	}

	/**
	 * Fix secret.
	 *
	 * @param s the s
	 * @param length the length
	 * @return the byte[]
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
	private byte[] fixSecret(String s, int length) throws UnsupportedEncodingException {
		if (s.length() < length) {
			int missingLength = length - s.length();
			for (int i = 0; i < missingLength; i++) {
				s += " ";
			}
		}
		return s.substring(0, length).getBytes("UTF-8");
	}

	/**
	 * Encrypt file.
	 *
	 * @param f the f
	 * @throws InvalidKeyException the invalid key exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws IllegalBlockSizeException the illegal block size exception
	 * @throws BadPaddingException the bad padding exception
	 */
	public void encryptFile(File f)
			throws InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException {
		System.out.println("Encrypting file: " + f.getName());
		this.cipher.init(Cipher.ENCRYPT_MODE, this.secretKey);
		this.writeToFile(f);
	}
	
	/**
	 * Encrypt.
	 *
	 * @param bytes the bytes
	 * @return the byte[]
	 * @throws InvalidKeyException the invalid key exception
	 * @throws IllegalBlockSizeException the illegal block size exception
	 * @throws BadPaddingException the bad padding exception
	 */
	public byte[] encrypt(byte [] bytes) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException
	{
		this.cipher.init(Cipher.ENCRYPT_MODE, this.secretKey);
		byte[] output = this.cipher.doFinal(bytes);
		return output;
	}

	/**
	 * Decrypt file.
	 *
	 * @param f the f
	 * @throws InvalidKeyException the invalid key exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws IllegalBlockSizeException the illegal block size exception
	 * @throws BadPaddingException the bad padding exception
	 */
	public void decryptFile(File f)
			throws InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException {
		System.out.println("Decrypting file: " + f.getName());
		this.cipher.init(Cipher.DECRYPT_MODE, this.secretKey);
		this.writeToFile(f);
	}
	
	/**
	 * Decrypt.
	 *
	 * @param bytes the bytes
	 * @return the byte[]
	 * @throws InvalidKeyException the invalid key exception
	 * @throws IllegalBlockSizeException the illegal block size exception
	 * @throws BadPaddingException the bad padding exception
	 */
	public byte[] decrypt(byte[] bytes) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException
	{
		this.cipher.init(Cipher.DECRYPT_MODE, this.secretKey);
		byte[] output = this.cipher.doFinal(bytes);
		return output;
	}

	/**
	 * Write to file.
	 *
	 * @param f the f
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws IllegalBlockSizeException the illegal block size exception
	 * @throws BadPaddingException the bad padding exception
	 */
	public void writeToFile(File f) throws IOException, IllegalBlockSizeException, BadPaddingException {
		FileInputStream in = new FileInputStream(f);
		byte[] input = new byte[(int) f.length()];
		in.read(input);

		FileOutputStream out = new FileOutputStream(f);
		byte[] output = this.cipher.doFinal(input);
		out.write(output);

		out.flush();
		out.close();
		in.close();
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		File dir = new File("src/cryptodir");
		File[] filelist = dir.listFiles();

		SymmetricCryptography ske;
		try {
			ske = new SymmetricCryptography("!@#$MySecr3tPassw0rd", 16, "AES");

			int choice = -2;
			while (choice != -1) {
				String[] options = { "Encrypt All", "Decrypt All", "Exit" };
				choice = JOptionPane.showOptionDialog(null, "Select an option", "Options", 0,
						JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

				switch (choice) {
				case 0:
					Arrays.asList(filelist).forEach(file -> {
						try {
							ske.encryptFile(file);
						} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException
								| IOException e) {
							System.err.println("Couldn't encrypt " + file.getName() + ": " + e.getMessage());
						}
					});
					System.out.println("Files encrypted successfully");
					break;
				case 1:
					Arrays.asList(filelist).forEach(file -> {
						try {
							ske.decryptFile(file);
						} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException
								| IOException e) {
							System.err.println("Couldn't decrypt " + file.getName() + ": " + e.getMessage());
						}
					});
					System.out.println("Files decrypted successfully");
					break;
				default:
					choice = -1;
					break;
				}
			}
		} catch (UnsupportedEncodingException ex) {
			System.err.println("Couldn't create key: " + ex.getMessage());
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			System.err.println(e.getMessage());
		}
	}
}
