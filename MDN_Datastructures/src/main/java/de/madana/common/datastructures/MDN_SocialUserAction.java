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
