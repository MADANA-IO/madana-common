package de.madana.server.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

public abstract class MDN_A_SQLConnector 
{
	public static String DATABASE_DRIVER;
	public static String DATABASE_NAME ;
	public static String DATABASE_URL ;
	private Properties oConnectionDetails;
	protected static Connection connection;
	public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	protected abstract Properties initProperties() throws ClassNotFoundException;
	protected abstract void saveProperties();
	public  abstract List<String> getAllTables() throws SQLException;
	/**
	 * Gibt die Verbindungsdaten zurück
	 * @return {@link Properties}
	 * @author Jean
	 * @param bLoadProperties 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 * @since 01.04.2017
	 */
	protected  Properties getProperties(boolean bLoadProperties) throws ClassNotFoundException
	{
		if(bLoadProperties)
			oConnectionDetails=initProperties();
		
		return oConnectionDetails;
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
	 * @throws ClassNotFoundException 
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
