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

import java.text.SimpleDateFormat;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class MDN_SocialHistoryObject.
 */
public class MDN_SocialHistoryObject implements Comparable
{
	
	/** The objectid. */
	String objectid;
	
	/** The benefit. */
	String benefit;
	
	/** The platform. */
	String platform;
	
	/** The action. */
	String action;
	
	/** The text. */
	String text;
	
	/** The link. */
	String link;
	
	/** The created. */
	String created;
	
	/**
	 * Gets the objectid.
	 *
	 * @return the objectid
	 */
	public String getObjectid() {
		return objectid;
	}
	
	/**
	 * Sets the objectid.
	 *
	 * @param objectid the new objectid
	 */
	public void setObjectid(String objectid) {
		this.objectid = objectid;
	}
	
	/**
	 * Gets the benefit.
	 *
	 * @return the benefit
	 */
	public String getBenefit() {
		return benefit;
	}
	
	/**
	 * Sets the benefit.
	 *
	 * @param benefit the new benefit
	 */
	public void setBenefit(String benefit) {
		this.benefit = benefit;
	}
	
	/**
	 * Gets the platform.
	 *
	 * @return the platform
	 */
	public String getPlatform() {
		return platform;
	}
	
	/**
	 * Sets the platform.
	 *
	 * @param platform the new platform
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	/**
	 * Gets the action.
	 *
	 * @return the action
	 */
	public String getAction() {
		return action;
	}
	
	/**
	 * Sets the action.
	 *
	 * @param action the new action
	 */
	public void setAction(String action) {
		this.action = action;
	}
	
	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Sets the text.
	 *
	 * @param text the new text
	 */
	public void setText(String text) {
		this.text = text;
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
	 * Gets the created.
	 *
	 * @return the created
	 */
	public String getCreated() {
		return created;
	}
	
	/**
	 * Sets the created.
	 *
	 * @param created the new created
	 */
	public void setCreated(String created) {
		this.created = created;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Object o) 
	{
		SimpleDateFormat oFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dMyCreated;
		try
		{
			dMyCreated = oFormat.parse(getCreated());
			Date dComparedCreated  = oFormat.parse(((MDN_SocialHistoryObject) o).getCreated());

			if (dMyCreated.before(dComparedCreated))
			{
				return 1;
			} else if (dMyCreated.after(dComparedCreated))
			{
				return -1;
			} 
			else
			{
				return 0;
			}   
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		return 0;



	}
}
