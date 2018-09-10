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

public class MDN_SocialUserObject 
{
 String ident;
 String image;
 String platform;
public String getIdent() {
	return ident;
}
public void setIdent(String ident) {
	this.ident = ident;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public String getPlatform() {
	return platform;
}
public void setPlatform(String platform) {
	this.platform = platform;
}
}
