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

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class MDN_PersonalSocialPost.
 */
public class MDN_PersonalSocialPost extends MDN_SocialPost
{
	
	/** The is completed. */
	boolean isCompleted;
	
	/** The embedd code. */
	String embeddCode;
	
	/**
	 * Gets the embedd code.
	 *
	 * @return the embedd code
	 */
	public String getEmbeddCode() {
		return embeddCode;
	}
	
	/**
	 * Sets the embedd code.
	 *
	 * @param embeddCode the new embedd code
	 */
	public void setEmbeddCode(String embeddCode) {
		this.embeddCode = embeddCode;
	}
	
	/**
	 * Gets the available actions.
	 *
	 * @return the available actions
	 */
	public List<String> getAvailableActions() {
		return availableActions;
	}
	
	/**
	 * Sets the available actions.
	 *
	 * @param availableActions the new available actions
	 */
	public void setAvailableActions(List<String> availableActions) {
		this.availableActions = availableActions;
	}
	
	/**
	 * Gets the completed actions.
	 *
	 * @return the completed actions
	 */
	public List<String> getCompletedActions() {
		return completedActions;
	}
	
	/**
	 * Sets the completed actions.
	 *
	 * @param completedActions the new completed actions
	 */
	public void setCompletedActions(List<String> completedActions) {
		this.completedActions = completedActions;
	}
	
	/**
	 * Checks if is completed.
	 *
	 * @return true, if is completed
	 */
	public boolean isCompleted() {
		return isCompleted;
	}
	
	/**
	 * Sets the completed.
	 *
	 * @param isCompleted the new completed
	 */
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	
	/** The available actions. */
	List<String> availableActions = new ArrayList<String>();
	
	/** The completed actions. */
	List<String> completedActions = new ArrayList<String>();

	/**
	 * Adds the available action.
	 *
	 * @param strAction the str action
	 */
	public void addAvailableAction(String strAction)
	{
		availableActions.add(strAction);
		isCompleted=false;
	}
	
	/**
	 * Adds the completed action.
	 *
	 * @param strAction the str action
	 */
	public void addCompletedAction(String strAction)
	{
		if(availableActions.contains(strAction))
			completedActions.add(strAction);
		
		if (completedActions.size()== availableActions.size())
			isCompleted=true;
	}
}
