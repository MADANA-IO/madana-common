package de.madana.common.datastructures;

import java.util.ArrayList;
import java.util.List;

public class MDN_PersonalSocialPost extends MDN_SocialPost
{
	boolean isCompleted;
	
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
