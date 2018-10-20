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


// TODO: Auto-generated Javadoc
/**
 * The Class MDN_UserProfile.
 */
public class MDN_UserProfile extends MDN_SimpleUserProfile
{
	 
	
	 /** The history. */
 	List<MDN_SocialHistoryObject> history;
	 
 	/** The achievements. */
 	private List<MDN_AchievementGroup> achievements;
	

	/**
	 * Gets the history.
	 *
	 * @return the history
	 */
	public List<MDN_SocialHistoryObject> getHistory() {
		return history;
	}
	
	/**
	 * Sets the history.
	 *
	 * @param oHistory the new history
	 */
	public void setHistory(List<MDN_SocialHistoryObject> oHistory) {
		this.history = oHistory;
	}
	
	/**
	 * Gets the achievements.
	 *
	 * @return the achievements
	 */
	public List<MDN_AchievementGroup> getAchievements() {
		return achievements;
	}
	
	/**
	 * Sets the achievements.
	 *
	 * @param achievements the new achievements
	 */
	public void setAchievements(List<MDN_AchievementGroup> achievements) {
		this.achievements = achievements;
	}



}
