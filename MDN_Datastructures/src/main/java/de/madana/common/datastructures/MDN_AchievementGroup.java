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
	public List<MDN_Achievement> getAchievments() {
		return achievements;
	}
	public void setAchievments(List<MDN_Achievement> achievments) {
		this.achievements = achievments;
	}

	public String toString()
	{
		return name;
	}
}
