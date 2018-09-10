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

public class MDN_SocialHistoryObject implements Comparable
{
	String objectid;
	String benefit;
	String platform;
	String action;
	String text;
	String link;
	String created;
	public String getObjectid() {
		return objectid;
	}
	public void setObjectid(String objectid) {
		this.objectid = objectid;
	}
	public String getBenefit() {
		return benefit;
	}
	public void setBenefit(String benefit) {
		this.benefit = benefit;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
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
