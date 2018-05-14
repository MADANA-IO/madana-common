package de.madana.server.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class MDN_A_MySQLConnector extends MDN_A_SQLConnector
{
	/**
	 * Liest alle Tabellen aus der Datenbank aus
	 * @return eine aus String bestehende Liste welche die Namen der Tabellen enthält
	 * @throws SQLException
	 * @author Jean
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
	 * Stellt eine Verbindung zur Datenbank her
	 * @return {@link Connection}
	 * @author Jean
	 * @throws ClassNotFoundException 
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
			} 
			catch ( SQLException e) 
			{
			
				e.printStackTrace();
			}
		}
		return connection;
	}

}
