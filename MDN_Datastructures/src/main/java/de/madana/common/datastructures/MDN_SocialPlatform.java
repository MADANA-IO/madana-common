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
