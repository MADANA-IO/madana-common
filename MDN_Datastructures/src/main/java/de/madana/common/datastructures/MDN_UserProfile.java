package de.madana.common.datastructures;

import java.util.List;


public class MDN_UserProfile extends MDN_A_UserObject
{
	 
	 String points;
	 List<MDN_SocialHistoryObject> history;
	 private List<MDN_AchievementGroup> achievements;
	
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
	public List<MDN_AchievementGroup> getAchievements() {
		return achievements;
	}
	public void setAchievements(List<MDN_AchievementGroup> achievments) {
		this.achievements = achievments;
	}



}
