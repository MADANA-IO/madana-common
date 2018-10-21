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
package de.madana.common.utils.handler;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class KeyHandler.
 */
public class KeyHandler 
{

	/** The key file. */
	File fKeyFile;
	
	/**
	 * Instantiates a new m D key handler.
	 *
	 * @param file the file
	 */
	public KeyHandler(File file) {
		fKeyFile=file;
	}

	/**
	 * Gets the all keys.
	 *
	 * @author Jean
	 * @return the all keys
	 * @since 10.05.2017
	 */
	public static List <KeyHandler> getAllKeys()
	{
		List <KeyHandler> oConfigs = new ArrayList<KeyHandler>();
		File fRootDir = new File ("./keys/");
		File[] fConfigFiles = fRootDir.listFiles(new FilenameFilter() 
		{
			public boolean accept(File dir, String name) 
			{
				return name.toLowerCase().endsWith(".key");
			}
		});
		if(fConfigFiles!=null)
		for(int i=0; i<fConfigFiles.length;i++)
		{
			oConfigs.add(new KeyHandler(fConfigFiles[i]));
		}
		return oConfigs;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public Object getName() 
	{
		return fKeyFile.getName();
	}
}
