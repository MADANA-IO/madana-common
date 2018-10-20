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

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class MDN_SocialUserAction.
 */
public class MDN_SocialUserAction 
{
	
	/** The socialplatform. */
	String socialplatform;
	
	/** The socialaction. */
	String socialaction;
	
	/** The socialobjectid. */
	String socialobjectid;
	
	/** The socialuserid. */
	String socialuserid;
	
	/**
	 * Instantiates a new MD N social user action.
	 *
	 * @param strPlatform the str platform
	 * @param strAction the str action
	 * @param strPost the str post
	 * @param strSocialIdentifier the str social identifier
	 */
	public MDN_SocialUserAction(String strPlatform, String strAction, String strPost, String strSocialIdentifier)
	{
		socialplatform=strPlatform;
		socialaction=strAction;
		socialobjectid=strPost;
		socialuserid=strSocialIdentifier;
	}

	/**
	 * Instantiates a new MD N social user action.
	 */
	public MDN_SocialUserAction()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the socialplatform.
	 *
	 * @return the socialplatform
	 */
	public String getSocialplatform() 
	{
		return socialplatform;
	}
	
	/**
	 * Sets the socialplatform.
	 *
	 * @param socialplatform the new socialplatform
	 */
	public void setSocialplatform(String socialplatform) {
		this.socialplatform = socialplatform;
	}
	
	/**
	 * Gets the socialaction.
	 *
	 * @return the socialaction
	 */
	public String getSocialaction() {
		return socialaction;
	}
	
	/**
	 * Sets the socialaction.
	 *
	 * @param socialaction the new socialaction
	 */
	public void setSocialaction(String socialaction) {
		this.socialaction = socialaction;
	}
	
	/**
	 * Gets the socialobjectid.
	 *
	 * @return the socialobjectid
	 */
	public String getSocialobjectid() {
		return socialobjectid;
	}
	
	/**
	 * Sets the socialobjectid.
	 *
	 * @param socialobjectid the new socialobjectid
	 */
	public void setSocialobjectid(String socialobjectid) {
		this.socialobjectid = socialobjectid;
	}
	
	/**
	 * Gets the socialuserid.
	 *
	 * @return the socialuserid
	 */
	public String getSocialuserid() {
		return socialuserid;
	}
	
	/**
	 * Sets the socialuserid.
	 *
	 * @param socialuserid the new socialuserid
	 */
	public void setSocialuserid(String socialuserid) {
		this.socialuserid = socialuserid;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return new Date().toGMTString() +": User "+socialuserid+ " did " +socialaction+ " " +socialobjectid+ " on " +socialplatform;
	}
}
