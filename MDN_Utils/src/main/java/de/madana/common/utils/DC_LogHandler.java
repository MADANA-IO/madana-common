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
package de.madana.common.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class DC_LogHandler.
 *
 * @author Jean
 * @since 13.05.2017
 */
public class DC_LogHandler extends PrintStream 
{
	
	/** The o date format. */
	SimpleDateFormat oDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
	
	/**
	 * Instantiates a new d C log handler.
	 *
	 * @param strFileName the str file name
	 * @throws FileNotFoundException the file not found exception
	 */
	public DC_LogHandler (String strFileName) throws FileNotFoundException
	{
		super(new FileOutputStream(new File("./"+strFileName)), true);
	
	}

	/*
	 * (non-Javadoc)
	 * @see java.io.PrintStream#println(java.lang.String)
	 */
	@Override
	public void println(String s) 
	{
		super.print("[ "+  oDateFormat.format(new Date())+ " ] "+s);
	}


}
