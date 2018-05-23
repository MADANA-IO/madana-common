package de.madana.common.datastructures;

/**
 * 
 * @author J.-Fabian Wenisch
 *
 */
public class MDN_User 
{
	private String firstName ="";
	private String lastName="";
	private String mail="";
	private MDN_UserCredentials credentials;
	

	/**
	 * 
	 * @return the firstName as string
	 * @author J.-Fabian Wenisch
	 */
	public String getFirstName() 
	{
		return firstName;
	}
	/**
	 * 
	 * @param firstName sets the provided firstName
	 * @author J.-Fabian Wenisch
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	/**
	 * 
	 * @return the lastName as String
	 * @author J.-Fabian Wenisch
	 */
	public String getLastName()
	{
		return lastName;
	}
	/**
	 * 
	 * @param lastName sets the lastname as string
	 * @author J.-Fabian Wenisch
	 */
	public void setLastName(String lastName)
	{
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
		return "User [firstname=" + firstName + ", lastname=" + lastName + " mail " + mail+"]";
	}

}
