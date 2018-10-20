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
 * The Class MDN_ErrorMessage.
 */
public class MDN_ErrorMessage 
{

/** The error code. */
String errorCode;

/** The user message. */
String userMessage;

/**
 * Gets the error code.
 *
 * @return the error code
 */
public String getErrorCode() {
	return errorCode;
}

/**
 * Sets the error code.
 *
 * @param errorCode the new error code
 */
public void setErrorCode(String errorCode) {
	this.errorCode = errorCode;
}

/**
 * Gets the error message.
 *
 * @return the error message
 */
public String getErrorMessage() {
	return userMessage;
}

/**
 * Sets the error message.
 *
 * @param errorMessage the new error message
 */
public void setErrorMessage(String errorMessage) {
	this.userMessage = errorMessage;
}
}
