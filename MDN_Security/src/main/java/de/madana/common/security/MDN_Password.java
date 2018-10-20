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
package de.madana.common.security;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.apache.commons.net.util.Base64;

// TODO: Auto-generated Javadoc
/**
 * The Class MDN_Password.
 */
public class MDN_Password {
    // The higher the number of iterations the more 
    // expensive computing the hash is for us and
    /** The Constant iterations. */
    // also for an attacker.
    private static final int iterations = 20*1000;
    
    /** The Constant saltLen. */
    private static final int saltLen = 32;
    
    /** The Constant desiredKeyLen. */
    private static final int desiredKeyLen = 256;

    
    /**
     * Generate salt.
     *
     * @return the byte[]
     * @throws NoSuchAlgorithmException the no such algorithm exception
     */
    public static byte[] generateSalt() throws NoSuchAlgorithmException
    {
    	return SecureRandom.getInstance("SHA1PRNG").generateSeed(saltLen);
    }

  

    /**
     *  Computes a salted PBKDF2 hash of given plaintext password
     *         suitable for storing in a database. 
     *         Empty passwords are not supported.
     *
     * @param password the password
     * @return the salted hash
     * @throws Exception the exception
     */
    public String getSaltedHash(String password) throws Exception {
        byte[] salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(saltLen);
      
        // store the salt with the password
        return Base64.encodeBase64String(salt) + "$" + hash(password, salt);
    }

    /**
     *  Checks whether given plaintext password corresponds 
     *         to a stored salted hash of the password.
     *
     * @param password the password
     * @param stored the stored
     * @return true, if successful
     * @throws Exception the exception
     */
    public static boolean check(String password, String stored) throws Exception{
        String[] saltAndPass = stored.split("\\$");
        if (saltAndPass.length != 2) {
            throw new IllegalStateException(
                "The stored password have the form 'salt$hash'");
        }
        String hashOfInput = hash(password, Base64.decodeBase64(saltAndPass[0]));
        return hashOfInput.equals(saltAndPass[1]);
    }

    // using PBKDF2 from Sun, an alternative is https://github.com/wg/scrypt
    /**
     * Hash.
     *
     * @param password the password
     * @param salt the salt
     * @return the string
     * @throws Exception the exception
     */
    // cf. http://www.unlimitednovelty.com/2012/03/dont-use-bcrypt.html
    public static String hash(String password, byte[] salt) throws Exception {
        if (password == null || password.length() == 0)
            throw new IllegalArgumentException("Empty passwords are not supported.");
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        SecretKey key = f.generateSecret(new PBEKeySpec(
            password.toCharArray(), salt, iterations, desiredKeyLen)
        );
        return Base64.encodeBase64String(key.getEncoded());
    }
}
