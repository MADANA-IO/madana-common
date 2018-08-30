package de.madana.common.datastructures;

import java.util.List;

public class MDN_AchievmentGroup
{
	String name;
	List <MDN_Achievment> achievments;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<MDN_Achievment> getAchievments() {
		return achievments;
	}
	public void setAchievments(List<MDN_Achievment> achievments) {
		this.achievments = achievments;
	}

	public String toString()
	{
		return name;
	}
}
