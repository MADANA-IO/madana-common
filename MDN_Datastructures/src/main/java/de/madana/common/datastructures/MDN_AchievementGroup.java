package de.madana.common.datastructures;

import java.util.List;

public class MDN_AchievementGroup
{
	String name;
	List <MDN_Achievement> achievements;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<MDN_Achievement> getAchievements() {
		return achievements;
	}
	public void setAchievements(List<MDN_Achievement> achievements) {
		this.achievements = achievements;
	}

	public String toString()
	{
		return name;
	}
}
