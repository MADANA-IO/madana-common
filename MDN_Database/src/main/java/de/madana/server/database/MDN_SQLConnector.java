package de.madana.server.database;

import java.util.Properties;

/**
 * Stellt via JDBC die Verbindung zur Datenbank her
 * @author Jean
 * @since 01.04.2017
 *
 */
public class MDN_SQLConnector extends MDN_A_MySQLConnector
{

	protected void saveProperties() 
	{
		//Nothing to do
	}
	
	/**
	 * List die Konfigurationsdatei aus und setz Datenbank-Treiber, Name, URL
	 * und initialisiert den Konfigurationshandle
	 * @author Jean
	 * @throws ClassNotFoundException 
	 * @since 13.05.2017
	 */
	protected Properties initProperties() throws ClassNotFoundException 
	{
		Properties oProperties = new Properties();
		oProperties.setProperty("user", System.getenv("RDS_USERNAME"));
		oProperties.setProperty("password", System.getenv("RDS_PASSWORD"));
		oProperties.setProperty("MaxPooledStatements", "250");
		DATABASE_DRIVER = "com.mysql.jdbc.Driver";
		DATABASE_URL =	"jdbc:mysql://"+System.getenv("RDS_HOSTNAME")+":"+System.getenv("RDS_PORT")+"/"+System.getenv("RDS_DB_NAME")+"?user="+System.getenv("RDS_USERNAME")+"&password="+System.getenv("RDS_PASSWORD");
		Class.forName(DATABASE_DRIVER);
		return oProperties;

	}

	
}