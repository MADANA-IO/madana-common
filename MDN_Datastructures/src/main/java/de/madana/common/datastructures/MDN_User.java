package de.madana.common.datastructures;

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
