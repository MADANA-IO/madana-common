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

// TODO: Auto-generated Javadoc
/**
 * The Class MDN_User.
 *
 * @author J.-Fabian Wenisch
 */
public class MDN_User extends MDN_A_UserObject
{
;
	
	/** The mail. */
	private String mail="";
	
	/** The credentials. */
	private MDN_UserCredentials credentials;
	 
 	/** The first name. */
 	String firstName ="";
	 
 	/** The last name. */
 	String lastName="";
	 
 	/** The guid. */
 	String guid="";
	 
 	/** The social accounts. */
 	List<MDN_SocialUserObject> socialAccounts;
	 
 	/** The settings. */
 	List<MDN_UserSetting> settings;

		/**
		 * Gets the settings.
		 *
		 * @return the settings
		 */
		public List<MDN_UserSetting> getSettings() {
		return settings;
	}
	
	/**
	 * Sets the settings.
	 *
	 * @param settings the new settings
	 */
	public void setSettings(List<MDN_UserSetting> settings) {
		this.settings = settings;
	}
		
		/**
		 * Gets the social accounts.
		 *
		 * @return the social accounts
		 */
		public List<MDN_SocialUserObject> getSocialAccounts() {
		return socialAccounts;
	}
	
	/**
	 * Sets the social accounts.
	 *
	 * @param socialAccounts the new social accounts
	 */
	public void setSocialAccounts(List<MDN_SocialUserObject> socialAccounts) {
		this.socialAccounts = socialAccounts;
	}
		
		/**
		 * Gets the guid.
		 *
		 * @return the guid
		 */
		public String getGuid() {
		return guid;
	}
	
	/**
	 * Sets the guid.
	 *
	 * @param guid the new guid
	 */
	public void setGuid(String guid) {
		this.guid = guid;
	}
		
		/**
		 * Gets the first name.
		 *
		 * @return the first name
		 */
		public String getFirstName() {
			return firstName;
		}
		
		/**
		 * Sets the first name.
		 *
		 * @param firstName the new first name
		 */
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		
		/**
		 * Gets the last name.
		 *
		 * @return the last name
		 */
		public String getLastName() {
			return lastName;
		}
		
		/**
		 * Sets the last name.
		 *
		 * @param lastName the new last name
		 */
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
	
	/**
	 * Gets the mail.
	 *
	 * @author J.-Fabian Wenisch
	 * @return the mail as string
	 */
	public String getMail() 
	{
		return mail;
	}
	
	/**
	 * Sets the mail.
	 *
	 * @author J.-Fabian Wenisch
	 * @param mail sets the provided mail as string
	 */
	public void setMail(String mail) 
	{
		this.mail = mail;
	}
	
	/**
	 * Gets the credentials.
	 *
	 * @author J.-Fabian Wenisch
	 * @return the credentials as object
	 */
	public MDN_UserCredentials getCredentials()
	{
		return credentials;
	}
	
	/**
	 * Sets the credentials.
	 *
	 * @author J.-Fabian Wenisch
	 * @param oCredentials sets the provided credentials for the user
	 */
	public void setCredentials(MDN_UserCredentials oCredentials)
	{
		this.credentials = oCredentials;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		return "User [" + getUserName() + "]";
	}

}
