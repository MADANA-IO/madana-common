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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
/**
 * Verwaltungsklasse für Konfigurationsdateien
 * @author Jean
 * @since 10.05.2017
 *
 */
public class DC_ConfigHandler 
{
	Properties props;
	File fPropertyFile;
	/**
	 * 
	 * @param fPropertyFile
	 * @throws IOException
	 * @author Jean
	 * @since 10.05.2017
	 */
	public DC_ConfigHandler(File fPropertyFile) throws IOException 
	{
		this.fPropertyFile=fPropertyFile;
		if(!fPropertyFile.exists())
		{
			fPropertyFile.createNewFile();
			System.out.println(fPropertyFile.getCanonicalPath()+ " wurde nicht gefunden und neuangelegt");
		}

		loadProperties();
	}
	public String getPath() throws IOException
	{
		return fPropertyFile.getCanonicalPath().toString();
	}
	/**
	 * 
	 * @param strPropertyFileName
	 * @throws IOException
	 * @author Jean
	 * @since 10.05.2017
	 */
	public DC_ConfigHandler(String strPropertyFileName) throws IOException 
	{
		fPropertyFile = new File("./conf/"+strPropertyFileName+".dcconf");
		if(!fPropertyFile.exists())
		{
			System.err.println(fPropertyFile.getCanonicalPath()+ " wurde nicht gefunden");
			fPropertyFile.createNewFile();
			System.err.println(fPropertyFile.getCanonicalPath()+ " wurde nicht gefunden und neuangelegt");
		}
		loadProperties();
	}
	/**
	 * 
	 * @return
	 * @author Jean
	 * @since 10.05.2017
	 */
	public String getName()
	{
		return fPropertyFile.getName();
	}
	/**
	 * 
	 * @return
	 * @author Jean
	 * @since 10.05.2017
	 */
	public static List <DC_ConfigHandler> getAllConfigs()
	{
		List <DC_ConfigHandler> oConfigs = new ArrayList<DC_ConfigHandler>();
		File fRootDir = new File ("./conf/");
		File[] fConfigFiles = fRootDir.listFiles(new FilenameFilter() 
		{
		
			public boolean accept(File dir, String name) 
			{
				return name.toLowerCase().endsWith(".dcconf");
			}
		});
		for(int i=0; i<fConfigFiles.length;i++)
		{
			try 

			{
				oConfigs.add(new DC_ConfigHandler(fConfigFiles[i]));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return oConfigs;
	}
	/**
	 * 
	 * @return
	 * @author Jean
	 * @since 10.05.2017
	 */
	public Properties getProperties()
	{
		try 
		{
			loadProperties();
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return props;
	}
	/**
	 * 
	 * @param strPropertyName
	 * @return
	 * @author Jean
	 * @since 10.05.2017
	 */
	public String getProperty(String strPropertyName)
	{
		String strPropertyValue =props.getProperty(strPropertyName);
		if(strPropertyValue==null)
		{
			setProperty(strPropertyName,"");
			try {
				saveProperties();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "";
		}
		return strPropertyValue;
	}
	/**
	 * 
	 * @param strPropertyName
	 * @param strValue
	 * @author Jean
	 * @since 10.05.2017
	 */
	public void setProperty(String strPropertyName, String strValue)
	{
		props.setProperty(strPropertyName, strValue);  
	}
	/**
	 * 
	 * @throws IOException
	 * @author Jean
	 * @since 10.05.2017
	 */
	void loadProperties() throws IOException
	{
		props = new Properties();
		FileInputStream in = new FileInputStream(fPropertyFile);
		try
		{
			props.load(in);
		}
		finally
		{
			in.close();
		}

	}
	/**
	 * 
	 * @throws IOException
	 * @author Jean
	 * @since 10.05.2017
	 */
	public void saveProperties() throws IOException
	{
		FileOutputStream out = new FileOutputStream(fPropertyFile);
		try
		{
			props.store(out, null);
		}
		finally
		{
			out.close();
		}
	}
}
