package de.madana.common.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;



import de.madana.common.DC_ConfigHandler;

/**
 * Stellt via JDBC die Verbindung zur Datenbank her
 * @author Jean
 * @since 01.04.2017
 *
 */
public class DC_SQLConnector 
{
	private static DC_ConfigHandler oDatabaseConfig ;
	public static String DATABASE_DRIVER;
	public static String DATABASE_NAME ;
	public static String DATABASE_URL ;
	public static String DATABASE_INITIALIZED;
	public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	protected static Connection connection;


	/**
	 * Gibt die Verbindungsdaten zurück
	 * @return {@link Properties}
	 * @author Jean
	 * @param bLoadProperties 
	 * @throws IOException 
	 * @since 01.04.2017
	 */
	private Properties getProperties(boolean bLoadProperties) 
	{
		Properties properties = new Properties();
		if(bLoadProperties)
		{
		properties.setProperty("user", oDatabaseConfig.getProperty("user"));
		properties.setProperty("password", oDatabaseConfig.getProperty("password"));
		properties.setProperty("MaxPooledStatements", oDatabaseConfig.getProperty("MaxPooledStatements"));
		}
		else
		{
			properties.setProperty("user", "digiclothes_java");
			properties.setProperty("password", "v5c!vjUBDa");
			properties.setProperty("MaxPooledStatements", "250");

		}
		return properties;
	}
	protected void saveProperties() throws IOException
	{
		oDatabaseConfig.setProperty("databaseDriver", DATABASE_DRIVER);
		oDatabaseConfig.setProperty("databaseURL", DATABASE_URL);
		oDatabaseConfig.setProperty("databaseInitialized", DATABASE_INITIALIZED);
		oDatabaseConfig.saveProperties();
	}
	/**
	 * Führt ein Query in der Datenbank durch
	 * @param strQuery - Das auszuführende SQL Statement als String
	 * @throws SQLException
	 * @author Jean
	 * @since 01.04.2017
	 */
	public static void execute(String strQuery) throws SQLException
	{
		java.sql.Statement stmt =  connection.createStatement();
		stmt.executeUpdate(strQuery);
	}
	/**
	 * Führt ein Query in der Datenbank durch und gibt das Ergebnis als Resultset zurück
	 * @param strQuery - Das auszuführende SQL Statement als String
	 * @return {@link ResultSet}
	 * @throws SQLException
	 * @author Jean
	 * @since 01.04.2017
	 */
	public static ResultSet executeQuery(String strQuery) throws SQLException
	{
		Statement stmt=  connection.createStatement();
		return stmt.executeQuery(strQuery);
	}
	/**
	 * Stellt eine Verbindung zur Datenbank her
	 * @return {@link Connection}
	 * @author Jean
	 * @since 01.04.2017
	 */
	public Connection connect(boolean bLoadProperties) 
	{
		if (connection == null)
		{
			try 
			{
				if(bLoadProperties)
					initProperties();
				Class.forName(DATABASE_DRIVER);
				connection = DriverManager.getConnection(DATABASE_URL, getProperties(bLoadProperties));
			} 
			catch (ClassNotFoundException | SQLException | IOException e) 
			{
				try {
					System.out.println(oDatabaseConfig.getPath()+" nicht gefunden!");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}
		return connection;
	}

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
	 * List die Konfigurationsdatei aus und setz Datenbank-Treiber, Name, URL
	 * und initialisiert den Konfigurationshandle
	 * @throws IOException
	 * @author Jean
	 * @since 13.05.2017
	 */
	protected void initProperties() throws IOException 
	{
		oDatabaseConfig = new DC_ConfigHandler("database");
		DATABASE_DRIVER = oDatabaseConfig.getProperty("databaseDriver");
		DATABASE_URL = oDatabaseConfig.getProperty("databaseURL");
		DATABASE_INITIALIZED= oDatabaseConfig.getProperty("databaseInitialized");

	}
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
	 * Trennt die Verbindung mit der Datenbank
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