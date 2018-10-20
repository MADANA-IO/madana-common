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

// TODO: Auto-generated Javadoc
/**
 * The Class MDN_Achievement.
 */
public class MDN_Achievement
{
	
	/**
	 * Instantiates a new MD N achievement.
	 */
	public MDN_Achievement()
	{
		completed="false";
	}
	
	/** The name. */
	String name;
	
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
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Gets the reward.
	 *
	 * @return the reward
	 */
	public String getReward() {
		return reward;
	}
	
	/**
	 * Sets the reward.
	 *
	 * @param reward the new reward
	 */
	public void setReward(String reward) {
		this.reward = reward;
	}
	
	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	
	/**
	 * Sets the image.
	 *
	 * @param image the new image
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
	/** The description. */
	String description;
	
	/** The reward. */
	String reward;
	
	/** The image. */
	String image;
	
	/** The completed. */
	String completed;

	/**
	 * Gets the completed.
	 *
	 * @return the completed
	 */
	public String getCompleted() {
		return completed;
	}
	
	/**
	 * Sets the completed.
	 *
	 * @param completed the new completed
	 */
	public void setCompleted(String completed) {
		this.completed = completed;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return name;
	}
}
