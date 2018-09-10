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
