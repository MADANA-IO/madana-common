package de.madana.common.datastructures;

import java.util.HashMap;
import java.util.Map;

public class MDN_UserSpecificSocialPlatform extends MDN_SocialPlatform
{
	public Map<String, String> oActions = new HashMap<String, String>();

	public Map<String, String> getoActions() {
		return oActions;
	}

	public void setoActions(Map<String, String> oActions) {
		this.oActions = oActions;
	}
}
