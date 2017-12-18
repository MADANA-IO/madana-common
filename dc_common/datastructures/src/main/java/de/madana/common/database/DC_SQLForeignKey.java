package de.madana.common.database;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Klasse zur Verwaltung von Fremdschlüsseln
 * @author Jean
 * @since 01.04.2017
 *
 */
public class DC_SQLForeignKey 
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
	DC_SQLForeignKey(String strTableName,ResultSet oSet) throws SQLException
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
