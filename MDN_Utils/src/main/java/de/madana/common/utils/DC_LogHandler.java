package de.madana.common.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author Jean
 * @since 13.05.2017
 *
 */
public class DC_LogHandler extends PrintStream 
{
	SimpleDateFormat oDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
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