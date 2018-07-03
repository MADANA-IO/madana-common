package de.madana.common.datastructures;

public abstract class MDN_A_UserObject 
{
	String userName="";
	String created="";
	String lastActive="";

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getLastActive() {
		return lastActive;
	}
	public void setLastActive(String lastActive) {
		this.lastActive = lastActive;
	}

}
