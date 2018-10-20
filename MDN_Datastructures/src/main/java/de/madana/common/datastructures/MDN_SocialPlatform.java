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
 * The Class MDN_SocialPlatform.
 */
public class MDN_SocialPlatform
{
	
	/** The name. */
	private String name= "";
	
	/** The link. */
	private String link="";
	
	/** The icon. */
	private String icon="";
	
	/** The is referral platform. */
	private String isReferralPlatform = "false";
	
	/** The is disabled. */
	private String isDisabled = "true";
	
	/**
	 * Gets the checks if is disabled.
	 *
	 * @return the checks if is disabled
	 */
	public String getIsDisabled() {
		return isDisabled;
	}

	/**
	 * Sets the checks if is disabled.
	 *
	 * @param isDisabled the new checks if is disabled
	 */
	public void setIsDisabled(String isDisabled) {
		this.isDisabled = isDisabled;
	}

	/** The feed. */
	private List<MDN_SocialPost> feed;

	/**
	 * Gets the feed.
	 *
	 * @return the feed
	 */
	public List<MDN_SocialPost> getFeed() {
		return feed;
	}

	/**
	 * Sets the feed.
	 *
	 * @param feed the new feed
	 */
	public void setFeed(List<MDN_SocialPost> feed) {
		this.feed = feed;
	}

	/**
	 * Gets the link.
	 *
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * Sets the link.
	 *
	 * @param link the new link
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * Gets the icon.
	 *
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * Sets the icon.
	 *
	 * @param icon the new icon
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

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
	 * Gets the checks if is referral platform.
	 *
	 * @return the checks if is referral platform
	 */
	public String getIsReferralPlatform() {
		return isReferralPlatform;
	}

	/**
	 * Sets the checks if is referral platform.
	 *
	 * @param isReferralPlatform the new checks if is referral platform
	 */
	public void setIsReferralPlatform(String isReferralPlatform) {
		this.isReferralPlatform = isReferralPlatform;
	}

}
