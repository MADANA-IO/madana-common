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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
// TODO: Auto-generated Javadoc

/**
 * Verwaltungsklasse für Konfigurationsdateien.
 *
 * @author Jean
 * @since 10.05.2017
 */
public class ConfigHandler 
{
	
	/** The props. */
	Properties props;
	
	/** The property file. */
	File fPropertyFile;
	
	/**
	 * Instantiates a new d C config handler.
	 *
	 * @author Jean
	 * @param fPropertyFile the f property file
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @since 10.05.2017
	 */
	public ConfigHandler(File fPropertyFile) throws IOException 
	{
		this.fPropertyFile=fPropertyFile;
		if(!fPropertyFile.exists())
		{
			fPropertyFile.createNewFile();
			System.out.println(fPropertyFile.getCanonicalPath()+ " wurde nicht gefunden und neuangelegt");
		}

		loadProperties();
	}
	
	/**
	 * Gets the path.
	 *
	 * @return the path
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public String getPath() throws IOException
	{
		return fPropertyFile.getCanonicalPath().toString();
	}
	
	/**
	 * Instantiates a new d C config handler.
	 *
	 * @author Jean
	 * @param strPropertyFileName the str property file name
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @since 10.05.2017
	 */
	public ConfigHandler(String strPropertyFileName) throws IOException 
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
	 * Gets the name.
	 *
	 * @author Jean
	 * @return the name
	 * @since 10.05.2017
	 */
	public String getName()
	{
		return fPropertyFile.getName();
	}
	
	/**
	 * Gets the all configs.
	 *
	 * @author Jean
	 * @return the all configs
	 * @since 10.05.2017
	 */
	public static List <ConfigHandler> getAllConfigs()
	{
		List <ConfigHandler> oConfigs = new ArrayList<ConfigHandler>();
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
				oConfigs.add(new ConfigHandler(fConfigFiles[i]));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return oConfigs;
	}
	
	/**
	 * Gets the properties.
	 *
	 * @author Jean
	 * @return the properties
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
	 * Gets the property.
	 *
	 * @author Jean
	 * @param strPropertyName the str property name
	 * @return the property
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
	 * Sets the property.
	 *
	 * @author Jean
	 * @param strPropertyName the str property name
	 * @param strValue the str value
	 * @since 10.05.2017
	 */
	public void setProperty(String strPropertyName, String strValue)
	{
		props.setProperty(strPropertyName, strValue);  
	}
	
	/**
	 * Load properties.
	 *
	 * @author Jean
	 * @throws IOException Signals that an I/O exception has occurred.
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
	 * Save properties.
	 *
	 * @author Jean
	 * @throws IOException Signals that an I/O exception has occurred.
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
