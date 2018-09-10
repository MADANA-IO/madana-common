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

public class MDN_SocialUserAction 
{
	String socialplatform;
	String socialaction;
	String socialobjectid;
	String socialuserid;
	
	public MDN_SocialUserAction(String strPlatform, String strAction, String strPost, String strSocialIdentifier)
	{
		socialplatform=strPlatform;
		socialaction=strAction;
		socialobjectid=strPost;
		socialuserid=strSocialIdentifier;
	}

	public MDN_SocialUserAction()
	{
		// TODO Auto-generated constructor stub
	}

	public String getSocialplatform() 
	{
		return socialplatform;
	}
	public void setSocialplatform(String socialplatform) {
		this.socialplatform = socialplatform;
	}
	public String getSocialaction() {
		return socialaction;
	}
	public void setSocialaction(String socialaction) {
		this.socialaction = socialaction;
	}
	public String getSocialobjectid() {
		return socialobjectid;
	}
	public void setSocialobjectid(String socialobjectid) {
		this.socialobjectid = socialobjectid;
	}
	public String getSocialuserid() {
		return socialuserid;
	}
	public void setSocialuserid(String socialuserid) {
		this.socialuserid = socialuserid;
	}
	
	public String toString()
	{
		return new Date().toGMTString() +": User "+socialuserid+ " did " +socialaction+ " " +socialobjectid+ " on " +socialplatform;
	}
}
