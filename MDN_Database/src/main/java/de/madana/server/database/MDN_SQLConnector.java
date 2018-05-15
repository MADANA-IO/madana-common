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
//		oProperties.setProperty("user", System.getenv("RDS_USERNAME"));
//		oProperties.setProperty("password", System.getenv("RDS_PASSWORD"));
//		oProperties.setProperty("hostname", System.getenv("RDS_HOSTNAME"));
//		oProperties.setProperty("port", System.getenv("RDS_PORT"));
//		oProperties.setProperty("dbname", System.getenv("RDS_DB_NAME"));
//		
		oProperties.setProperty("user", System.getProperty("RDS_USERNAME"));
		oProperties.setProperty("password", System.getProperty("RDS_PASSWORD"));
		oProperties.setProperty("hostname", System.getProperty("RDS_HOSTNAME"));
		oProperties.setProperty("port", System.getProperty("RDS_PORT"));
		oProperties.setProperty("dbname", System.getProperty("RDS_DB_NAME"));
		oProperties.setProperty("MaxPooledStatements", "250");
		
		
		return oProperties;

	}

	
}