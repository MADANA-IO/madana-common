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
 * The Class MDN_UserCredentials.
 *
 * @author J.-Fabian Wenisch
 */
public class MDN_UserCredentials
{
	
	/** The username. */
	private String username;
	
	/** The password. */
	private String password;
	
	/**
	 * Gets the username.
	 *
	 * @author J.-Fabian Wenisch
	 * @return the username as string
	 */
	public String getUsername() 
	{
		return username;
	}
	
	/**
	 * Sets the username.
	 *
	 * @author J.-Fabian Wenisch
	 * @param username sets the username, expects string
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	/**
	 * Gets the password.
	 *
	 * @author J.-Fabian Wenisch
	 * @return the password as string
	 */
	public String getPassword() 
	{
		return password;
	}
	
	/**
	 * Sets the password.
	 *
	 * @author J.-Fabian Wenisch
	 * @param password sets the provided password in the credentials, expects string
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

}
