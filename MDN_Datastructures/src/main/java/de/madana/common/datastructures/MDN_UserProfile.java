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
	public void setAchievements(List<MDN_AchievementGroup> achievements) {
		this.achievements = achievements;
	}



}
