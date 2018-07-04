package de.madana.common.datastructures;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MDN_SocialPost implements Comparable
{

	String id;
	String link;
	String created;
	String text;
	String picture;
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public int compareTo(Object o) 
	{
		SimpleDateFormat oFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dMyCreated;
		try
		{
			dMyCreated = oFormat.parse(getCreated());
			Date dComparedCreated  = oFormat.parse(((MDN_SocialPost) o).getCreated());

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
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;



	}

}
