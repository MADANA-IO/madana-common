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
package de.madana.common.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

// TODO: Auto-generated Javadoc
/**
 * The Class MDN_A_SQLConnector.
 *
 * @author J.-Fabian Wenisch
 */
public abstract class MDN_A_SQLConnector 
{
	
	/** The database driver. */
	public static String DATABASE_DRIVER;
	
	/** The database name. */
	public static String DATABASE_NAME ;
	
	/** The database url. */
	public static String DATABASE_URL ;
	
	/** The o connection details. */
	private Properties oConnectionDetails;
	
	/** The connection. */
	public static Connection connection;
	
	/** The simple date format. */
	public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	/**
	 * Inits the properties.
	 *
	 * @return the properties
	 * @throws ClassNotFoundException the class not found exception
	 */
	protected abstract Properties initProperties() throws ClassNotFoundException;
	
	/**
	 * Save properties.
	 */
	protected abstract void saveProperties();
	
	/**
	 * Gets the all tables.
	 *
	 * @return the all tables
	 * @throws SQLException the SQL exception
	 */
	public  abstract List<String> getAllTables() throws SQLException;
	
	/**
	 * Gibt die Verbindungsdaten zurück.
	 *
	 * @author Jean
	 * @param bLoadProperties the b load properties
	 * @return {@link Properties}
	 * @throws ClassNotFoundException the class not found exception
	 * @since 01.04.2017
	 */
	protected  Properties getProperties(boolean bLoadProperties) throws ClassNotFoundException
	{
		if(bLoadProperties)
			oConnectionDetails=initProperties();
		
		return oConnectionDetails;
	}
	
	/**
	 * Führt ein Query in der Datenbank durch.
	 *
	 * @author Jean
	 * @param strQuery - Das auszuführende SQL Statement als String
	 * @throws SQLException the SQL exception
	 * @since 01.04.2017
	 */
	public static void execute(String strQuery) throws SQLException
	{
		java.sql.Statement stmt =  connection.createStatement();
		stmt.executeUpdate(strQuery);
	}
	
	/**
	 * Führt ein Query in der Datenbank durch und gibt das Ergebnis als Resultset zurück.
	 *
	 * @author Jean
	 * @param strQuery - Das auszuführende SQL Statement als String
	 * @return {@link ResultSet}
	 * @throws SQLException the SQL exception
	 * @since 01.04.2017
	 */
	public static ResultSet executeQuery(String strQuery) throws SQLException
	{
		Statement stmt=  connection.createStatement();
		return stmt.executeQuery(strQuery);
	}
	
	/**
	 * Stellt eine Verbindung zur Datenbank her.
	 *
	 * @author Jean
	 * @param bLoadProperties the b load properties
	 * @return {@link Connection}
	 * @throws ClassNotFoundException the class not found exception
	 * @since 01.04.2017
	 */
	public Connection connect(boolean bLoadProperties) throws ClassNotFoundException 
	{
		if (connection == null)
		{
			try 
			{
			
				connection = DriverManager.getConnection(DATABASE_URL, getProperties(bLoadProperties));
			} 
			catch ( SQLException e) 
			{
			
				e.printStackTrace();
			}
		}
		return connection;
	}

	/**
	 * Checks if is connected.
	 *
	 * @return true, if is connected
	 */
	public static boolean isConnected()
	{
		if(connection==null)
			return false;
		try 
		{
			return (!connection.isClosed());
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Trennt die Verbindung mit der Datenbank.
	 *
	 * @author Jean
	 * @since 01.04.2017
	 */
	public void disconnect() 
	{
		if (connection != null) 
		{
			try 
			{
				connection.close();
				connection = null;
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

}
