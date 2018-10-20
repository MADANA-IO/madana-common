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
package de.madana.common.database.dbms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import de.madana.common.database.MDN_A_SQLConnector;
import de.madana.common.database.MDN_SQLConnector;

// TODO: Auto-generated Javadoc
/**
 * The Class MDN_A_MySQLConnector.
 */
public abstract class MDN_A_MySQLConnector extends MDN_A_SQLConnector
{
	
	/**
	 * Liest alle Tabellen aus der Datenbank aus.
	 *
	 * @author Jean
	 * @return eine aus String bestehende Liste welche die Namen der Tabellen enthält
	 * @throws SQLException the SQL exception
	 * @since 01.04.2017
	 */
	public List<String> getAllTables() throws SQLException
	{
		List<String> oTables = new ArrayList<String>();
//		ResultSet rs = executeQuery("SHOW TABLES FROM "+DATABASE_NAME);
		ResultSet rs = executeQuery("SHOW TABLES");
		while(rs.next())
			oTables.add(rs.getString(1));
		return oTables;
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
				getProperties(bLoadProperties);
				connection = DriverManager.getConnection(DATABASE_URL);
				MDN_SQLConnector.execute("SET SESSION wait_timeout=604800");
				MDN_SQLConnector.execute("SET SESSION interactive_timeout=604800");
			} 
			catch ( SQLException e) 
			{
			
				e.printStackTrace();
			}
		}
		return connection;
	}
	
	/* (non-Javadoc)
	 * @see de.madana.common.database.MDN_A_SQLConnector#getProperties(boolean)
	 */
	protected  Properties getProperties(boolean bLoadProperties) throws ClassNotFoundException
	{
		Properties oProperties = super.getProperties(bLoadProperties);
		DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
		Class.forName(DATABASE_DRIVER);
		DATABASE_URL =	"jdbc:mysql://"+oProperties.getProperty("hostname")+":"+oProperties.getProperty("port")+"/"+oProperties.getProperty("dbname")+"?user="+oProperties.getProperty("user")+"&password="+oProperties.getProperty("password")+"&autoReconnect=true";
		return oProperties;
	}

}
