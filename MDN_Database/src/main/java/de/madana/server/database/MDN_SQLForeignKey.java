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

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Klasse zur Verwaltung von Fremdschlüsseln
 * @author Jean
 * @since 01.04.2017
 *
 */
public class MDN_SQLForeignKey 
{
	String strTableName;
	String strColumName;
	String strReferencedTableName;
	String strReferencedColumnName;
	/**
	 * 
	 * @param strTableName
	 * @param oSet
	 * @throws SQLException
	 * @author Jean
	 * @since 01.04.2017
	 */
	MDN_SQLForeignKey(String strTableName,ResultSet oSet) throws SQLException
	{
		this.strTableName=strTableName;
		this.strColumName= oSet.getString(1);
		this.strReferencedTableName=oSet.getString(2);
		this.strReferencedColumnName=oSet.getString(3);
	}
	/**
	 * Gibt den Namen der Tabelle zurück
	 * @return
	 * @author Jean
	 * @since 01.04.2017
	 */
	public String getTableName() 
	{
		return strTableName;
	}
	/**
	 * Gibt den Namen der Spalte zurück
	 * @return
	 * @author Jean
	 * @since 01.04.2017
	 */
	public String getColumName() 
	{
		return strColumName;
	}
	/**
	 * Gibt den Namen der Tabelle zurück auf die der Fremdschlüssel zeigt
	 * @return
	 * @author Jean
	 * @since 01.04.2017
	 */
	public String getReferencedTableName() 
	{
		return strReferencedTableName;
	}
	/**
	 * Gibt den Namen der Spalte zurück auf die der Fremdschlüssel zeigt
	 * @return
	 * @author Jean
	 * @since 01.04.2017
	 */
	public String getReferencedColumnName()
	{
		return strReferencedColumnName;
	}

}
