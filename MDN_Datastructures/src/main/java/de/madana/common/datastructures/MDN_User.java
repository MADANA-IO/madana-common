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

import java.util.List;

/**
 * 
 * @author J.-Fabian Wenisch
 *
 */
public class MDN_User extends MDN_A_UserObject
{
;
	private String mail="";
	
	private MDN_UserCredentials credentials;
	 String firstName ="";
	 String lastName="";
	 String guid="";
	 List<MDN_SocialUserObject> socialAccounts;

		public List<MDN_SocialUserObject> getSocialAccounts() {
		return socialAccounts;
	}
	public void setSocialAccounts(List<MDN_SocialUserObject> socialAccounts) {
		this.socialAccounts = socialAccounts;
	}
		public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
	
	/**
	 * 
	 * @return the mail as string
	 * @author J.-Fabian Wenisch
	 */
	public String getMail() 
	{
		return mail;
	}
	/**
	 * 
	 * @param mail sets the provided mail as string
	 * @author J.-Fabian Wenisch
	 */
	public void setMail(String mail) 
	{
		this.mail = mail;
	}
	/**
	 * 
	 * @return the credentials as object
	 * @author J.-Fabian Wenisch
	 */
	public MDN_UserCredentials getCredentials()
	{
		return credentials;
	}
	/**
	 * 
	 * @param oCredentials sets the provided credentials for the user
	 * @author J.-Fabian Wenisch
	 */
	public void setCredentials(MDN_UserCredentials oCredentials)
	{
		this.credentials = oCredentials;
	}
	
	@Override
	public String toString() 
	{
		return "User [" + getUserName() + "]";
	}

}
