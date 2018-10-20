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

// TODO: Auto-generated Javadoc
/**
 * The Class MDN_SocialUserObject.
 */
public class MDN_SocialUserObject 
{
 
 /** The ident. */
 String ident;
 
 /** The image. */
 String image;
 
 /** The platform. */
 String platform;

/**
 * Gets the ident.
 *
 * @return the ident
 */
public String getIdent() {
	return ident;
}

/**
 * Sets the ident.
 *
 * @param ident the new ident
 */
public void setIdent(String ident) {
	this.ident = ident;
}

/**
 * Gets the image.
 *
 * @return the image
 */
public String getImage() {
	return image;
}

/**
 * Sets the image.
 *
 * @param image the new image
 */
public void setImage(String image) {
	this.image = image;
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

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
public String toString()
{
	return platform+"["+ident+"]";
}
}
