package de.madana.common.datastructures;

import java.util.List;

public class MDN_SocialPlatform
{
	private String name= "";
	private String link="";
	private String icon="";
	private String isReferralPlatform = "false";
	private String isDisabled = "true";
	public String getIsDisabled() {
		return isDisabled;
	}

	public void setIsDisabled(String isDisabled) {
		this.isDisabled = isDisabled;
	}

	private List<MDN_SocialPost> feed;

	public List<MDN_SocialPost> getFeed() {
		return feed;
	}

	public void setFeed(List<MDN_SocialPost> feed) {
		this.feed = feed;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsReferralPlatform() {
		return isReferralPlatform;
	}

	public void setIsReferralPlatform(String isReferralPlatform) {
		this.isReferralPlatform = isReferralPlatform;
	}

}
