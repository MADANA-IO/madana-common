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

public class MDN_PersonalSocialPost extends MDN_SocialPost
{
	boolean isCompleted;
	String embeddCode;
	
	public String getEmbeddCode() {
		return embeddCode;
	}
	public void setEmbeddCode(String embeddCode) {
		this.embeddCode = embeddCode;
	}
	public List<String> getAvailableActions() {
		return availableActions;
	}
	public void setAvailableActions(List<String> availableActions) {
		this.availableActions = availableActions;
	}
	public List<String> getCompletedActions() {
		return completedActions;
	}
	public void setCompletedActions(List<String> completedActions) {
		this.completedActions = completedActions;
	}
	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	List<String> availableActions = new ArrayList<String>();
	List<String> completedActions = new ArrayList<String>();

	public void addAvailableAction(String strAction)
	{
		availableActions.add(strAction);
		isCompleted=false;
	}
	public void addCompletedAction(String strAction)
	{
		if(availableActions.contains(strAction))
			completedActions.add(strAction);
		
		if (completedActions.size()== availableActions.size())
			isCompleted=true;
	}
}
