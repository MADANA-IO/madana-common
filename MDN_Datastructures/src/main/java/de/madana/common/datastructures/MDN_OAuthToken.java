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
package de.madana.common.datastructures;

// TODO: Auto-generated Javadoc
/**
 * The Class MDN_OAuthToken.
 */
public class MDN_OAuthToken 
{
	
	/** The token. */
	String token;
	
	/** The verifier. */
	String verifier;
	
	/**
	 * Gets the token.
	 *
	 * @return the token
	 */
	public String getToken() 
	{
		return token;
	}

	/**
	 * Sets the token.
	 *
	 * @param token the new token
	 */
	public void setToken(String token) 
	{
		this.token = token;
	}

	/**
	 * Gets the verifier.
	 *
	 * @return the verifier
	 */
	public String getVerifier() 
	{
		return verifier;
	}

	/**
	 * Sets the verifier.
	 *
	 * @param verifier the new verifier
	 */
	public void setVerifier(String verifier)
	{
		this.verifier = verifier;
	}

	
}
