package de.madana.common.datastructures;

import java.util.List;


public class MDN_UserProfile 
{
	 String firstName ="";
	 String lastName="";
	 String userName="";
	 String created="";
	 String lastActive="";
	 String points;
	 List<MDN_SocialHistoryObject> history;
	
	public String getPoints() {
		return points;
	}
	public void setPoints(String points) {
		this.points = points;
	}
	public List<MDN_SocialHistoryObject> getHistory() {
		return history;
	}
	public void setHistory(List<MDN_SocialHistoryObject> oHistory) {
		this.history = oHistory;
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
