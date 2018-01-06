package de.madana.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MD_KeyHandler 
{

	File fKeyFile;
	
	public MD_KeyHandler(File file) {
		fKeyFile=file;
	}

	/**
	 * 
	 * @return
	 * @author Jean
	 * @since 10.05.2017
	 */
	public static List <MD_KeyHandler> getAllKeys()
	{
		List <MD_KeyHandler> oConfigs = new ArrayList<MD_KeyHandler>();
		File fRootDir = new File ("./keys/");
		File[] fConfigFiles = fRootDir.listFiles(new FilenameFilter() 
		{
			@Override
			public boolean accept(File dir, String name) 
			{
				return name.toLowerCase().endsWith(".key");
			}
		});
		if(fConfigFiles!=null)
		for(int i=0; i<fConfigFiles.length;i++)
		{
			oConfigs.add(new MD_KeyHandler(fConfigFiles[i]));
		}
		return oConfigs;
	}

	public Object getName() 
	{
		return fKeyFile.getName();
	}
}
