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
		oProperties.setProperty("MaxPooledStatements", "250");
		if(System.getenv("RDS_USERNAME")!= null)
		{
			oProperties.setProperty("user", System.getenv("RDS_USERNAME"));
			oProperties.setProperty("password", System.getenv("RDS_PASSWORD"));
			oProperties.setProperty("hostname", System.getenv("RDS_HOSTNAME"));
			oProperties.setProperty("port", System.getenv("RDS_PORT"));
			oProperties.setProperty("dbname", System.getenv("RDS_DB_NAME"));

		}
		else
		{
			oProperties.setProperty("user", System.getProperty("RDS_USERNAME"));
			oProperties.setProperty("password", System.getProperty("RDS_PASSWORD"));
			oProperties.setProperty("hostname", System.getProperty("RDS_HOSTNAME"));
			oProperties.setProperty("port", System.getProperty("RDS_PORT"));
			oProperties.setProperty("dbname", System.getProperty("RDS_DB_NAME"));
		}


		return oProperties;

	}


}
