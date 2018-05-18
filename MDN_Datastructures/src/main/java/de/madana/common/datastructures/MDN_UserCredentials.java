package de.madana.common.datastructures;

/**
 * 
 * @author J.-Fabian Wenisch
 *
 */
public class MDN_UserCredentials
{
	private String username;
	private String password;
	/**
	 * 
	 * @return the username as string
	 * @author J.-Fabian Wenisch
	 */
	public String getUsername() 
	{
		return username;
	}
	/**
	 * 
	 * @param username sets the username, expects string
	 * @author J.-Fabian Wenisch
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}
	/**
	 * 
	 * @return the password as string
	 * @author J.-Fabian Wenisch
	 */
	public String getPassword() 
	{
		return password;
	}
	/**
	 * 
	 * @param password sets the provided password in the credentials, expects string
	 * @author J.-Fabian Wenisch
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

}
