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
 * The Class MDN_AchievementGroup.
 */
public class MDN_AchievementGroup
{
	
	/** The name. */
	String name;
	
	/** The achievements. */
	List <MDN_Achievement> achievements;
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the achievements.
	 *
	 * @return the achievements
	 */
	public List<MDN_Achievement> getAchievements() {
		return achievements;
	}
	
	/**
	 * Sets the achievements.
	 *
	 * @param achievements the new achievements
	 */
	public void setAchievements(List<MDN_Achievement> achievements) {
		this.achievements = achievements;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return name;
	}
}
