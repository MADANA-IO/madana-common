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

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;

// TODO: Auto-generated Javadoc
/**
 * The Class GenerateKeys.
 */
public class GenerateKeys {
	
	/** The key gen. */
	private KeyPairGenerator keyGen;
	
	/** The pair. */
	private KeyPair pair;
	
	/** The private key. */
	private PrivateKey privateKey;
	
	/** The public key. */
	private PublicKey publicKey;

	/**
	 * Instantiates a new generate keys.
	 *
	 * @param keylength the keylength
	 * @throws NoSuchAlgorithmException the no such algorithm exception
	 * @throws NoSuchProviderException the no such provider exception
	 */
	public GenerateKeys(int keylength) throws NoSuchAlgorithmException, NoSuchProviderException {
		this.keyGen = KeyPairGenerator.getInstance("RSA");
		this.keyGen.initialize(keylength);
	}

	/**
	 * Creates the keys.
	 */
	public void createKeys() {
		this.pair = this.keyGen.generateKeyPair();
		this.privateKey = pair.getPrivate();
		this.publicKey = pair.getPublic();
	}

	/**
	 * Gets the private key.
	 *
	 * @return the private key
	 */
	public PrivateKey getPrivateKey() {
		return this.privateKey;
	}

	/**
	 * Gets the public key.
	 *
	 * @return the public key
	 */
	public PublicKey getPublicKey() 
	{
		return this.publicKey;
	}
	
	/**
	 * Gets the keypair.
	 *
	 * @return the keypair
	 */
	public KeyPair getKeypair()
	{
		return this.getKeypair();
	}

	
}
