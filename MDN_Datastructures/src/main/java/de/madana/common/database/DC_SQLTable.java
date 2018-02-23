package de.madana.common.database;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/**
 * Klasse zur Verwaltung einer Tabelle in der Datenbank
 * @author Jean
 * @since 01.04.2017
 */
public class DC_SQLTable
{
	private String strName;
	/**
	 * 
	 * @param strName - Name der Tabelle
	 * @author Jean
	 * @since 01.04.2017
	 */
	public DC_SQLTable(String strName)
	{
		this.strName=strName;
	}
	/**
	 * Fügt einen neuen Datensatz in die Tabelle ein, der Primary Key wird unter Nutzung von getCount() automatisch gesetzt
	 * @param oValues ArrayList<String> der einzufügenden Werte
	 * @throws SQLException
	 * @author J.-Fabian Wenisch
	 * @since 09.04.2017
	 */
	public void addEntry(ArrayList<String> oValues) throws SQLException
	{
		String strValues="";
		for(int i=0; i < oValues.size();i++)
			strValues+="'"+oValues.get(i)+"',";
		strValues= strValues.substring(0, strValues.length()-1);
		int iIdent= (int) (getRowCount()+1);
		DC_SQLConnector.execute("INSERT INTO "+strName+" VALUES ("+iIdent+","+strValues+");" );
	}
	/**
	 * Fügt einen neuen Datensatz in die Tabelle ein, der Primary Key wird unter Nutzung von getCount() automatisch gesetzt
	 * @param oValues ArrayList<String> der einzufügenden Werte
	 * @throws SQLException
	 * @author J.-Fabian Wenisch
	 * @since 09.04.2017
	 */
	public void addEntry(List<Object> oValues) throws SQLException
	{
		List <String> oColumnNames = getColumnNames();
		String strColumNames="";
		for(int i=0; i < oColumnNames.size(); i++)
		{
			strColumNames+=oColumnNames.get(i)+", ";
		}
		strColumNames=strColumNames.substring(0, strColumNames.length()-2);
		String strValues=String.valueOf(getRowCount()+1)+", ";
		for(int i=0; i < oValues.size();i++)
		{
				strValues+="?, ";
		}
		strValues= strValues.substring(0, strValues.length()-2);
		PreparedStatement oStatement = DC_SQLConnector.connection.prepareStatement("INSERT INTO "+strName+" ("+strColumNames+")VALUES ("+strValues+")");
		

		for(int i=0; i < oValues.size();i++)
		{
			if(oValues.get(i) instanceof byte[])
			{
				oStatement.setBytes(i+1, (byte[]) oValues.get(i));
			
			}
			else //if(oValues.get(i) instanceof String)
			{
				oStatement.setString(i+1,  (String) oValues.get(i));
			}

		}

		int s = oStatement.executeUpdate();
		if (s > 0)
		{
			System.out.println("Blob Stored in Database");
		}

	}
	/**
	 * Löscht den Eintrag mit der ID aus der Tablle
	 * @param string - Primary ID
	 * @throws SQLException
	 * @author J.-Fabian Wenisch
	 * @since 09.04.2017
	 */
	public void deleteEntry(String string) throws SQLException
	{
		DC_SQLConnector.execute("DELETE FROM "+strName + " WHERE "+getColumnNames().get(0)+" = "+ string);
	}
	/**
	 * Gibt den zuerst gefunden Primärschlüssel aus der Tabelle zurück
	 * @param strColumName - Spalte in der Tabelle
	 * @param strValue - Wert in der Tabelle
	 * @return
	 * @throws SQLException
	 * @author Jean
	 * @since 01.04.2017
	 */
	public String getID(String strColumName, String strValue) throws SQLException
	{
		String strId = "";
		ResultSet oSet=	 DC_SQLConnector.executeQuery("SELECT * FROM "+strName+ " WHERE "+strColumName+" = '"+ strValue+"'");
		if(oSet.next())
			strId=oSet.getString(1);
		return strId;
	}
	public Object getEntryByKey(String strKeyColumn, String strKey, String strColumn) throws SQLException
	{
		ResultSet oSet=	 DC_SQLConnector.executeQuery("SELECT * FROM "+strName+ " WHERE "+strKeyColumn+" = '"+ strKey+"'");
		ResultSetMetaData rsmd=oSet.getMetaData();
		if(rsmd.getColumnTypeName(oSet.findColumn(strColumn)).toUpperCase().equals("BLOB"))
		{
			oSet.next();
			Blob oBlob = oSet.getBlob(oSet.findColumn(strColumn));
			return oBlob.getBytes(1L, (int)oBlob.length());
		}
		return oSet.getString(oSet.findColumn(strColumn));
	}
	/**
	 * Gibt die Einträge zurück die in der übergebenen Spalte die entsprechenden Werte haben
	 * @param strColumName - Name der Spalte
	 * @param strValue - Wert in der SPalte
	 * @return ResultSet
	 * @throws SQLException
	 * @author J.-Fabian Wenisch
	 * @since 09.04.2017
	 */
	public List<String> getEntries(String strColumName, String strValue) throws SQLException
	{
		List<String> oValues = new ArrayList<String>();
		ResultSet oSet=	 DC_SQLConnector.executeQuery("SELECT * FROM "+strName+ " WHERE "+strColumName+" = '"+ strValue+"'");
		while(oSet.next())
			oValues.add(oSet.getString(1));
		return oValues;
	}

	/**
	 * Gibt alle Einträge aus einer Spalte zurück
	 * @param strColumnName
	 * @return
	 * @throws SQLException
	 * @author Jean
	 * @since 01.04.2017
	 */
	public List<String> getEntries(String strColumnName) throws SQLException
	{
		List<String> oValues = new ArrayList<String>();
		ResultSet oSet=		 DC_SQLConnector.executeQuery("SELECT "+strColumnName+" FROM "+strName+ " WHERE "+strColumnName +" is not NULL");
		while(oSet.next())
			oValues.add(oSet.getString(1));
		return oValues;

	}
	/**
	 * Gibt die Anzahl der Datensätze in der Tabelle zurück
	 * @return Long
	 * @throws SQLException
	 * @author J.-Fabian Wenisch
	 * @since 09.04.2017
	 */
	public Long getRowCount() throws SQLException
	{
		ResultSet rs = DC_SQLConnector.executeQuery("SELECT count(*) FROM "+strName);
		rs.next();
		long zeilen = rs.getLong(1);
		return zeilen;
	}
	/**
	 * Liest alle Fremdschlüssel aus einer Tabelle aus
	 * @return
	 * @throws SQLException
	 * @author Jean
	 * @since 01.04.2017
	 */
	public List <DC_SQLForeignKey> getForeignKeys() throws SQLException
	{
		List <DC_SQLForeignKey> oForeignKeys = new ArrayList<DC_SQLForeignKey>();
		ResultSet oSet=		 DC_SQLConnector.executeQuery("SELECT COLUMN_NAME,REFERENCED_TABLE_NAME,REFERENCED_COLUMN_NAME from INFORMATION_SCHEMA.KEY_COLUMN_USAGE where TABLE_SCHEMA = '"+DC_SQLConnector.DATABASE_NAME+"' and TABLE_NAME = '"+strName+"'and referenced_column_name is not NULL;");
		while(oSet.next())
			oForeignKeys.add(new DC_SQLForeignKey(strName,oSet));
		return oForeignKeys;
	}
	/**
	 * Gibt die Anzahl der Datensätze in der Tabelle zurück
	 * @return Long
	 * @throws SQLException
	 * @author J.-Fabian Wenisch
	 * @since 09.04.2017
	 */
	public Long getColumnCount() throws SQLException
	{
		ResultSet rs = DC_SQLConnector.executeQuery("SELECT count(*) FROM information_schema.columns WHERE table_schema = '"+DC_SQLConnector.DATABASE_NAME+"' AND TABLE_NAME = '"+strName+"'");
		rs.next();
		long zeilen = rs.getLong(1);
		return zeilen;
	}
	/**
	 * Gibt die Namen aller Spalten zurück
	 * @return List<String>
	 * @throws SQLException
	 * @author J.-Fabian Wenisch
	 * @since 09.04.2017
	 */
	public List<String> getColumnNames() throws SQLException
	{
		List<String> oColumns = new ArrayList<String>();
		ResultSet rs = DC_SQLConnector.executeQuery("SELECT * FROM "+strName);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		for (int i = 1; i <= columnCount; i++ ) {
			oColumns.add(rsmd.getColumnName(i));
		}
		return oColumns;
	}
	/**
	 * Gibt alle Spalten aus der Tabelle zurück
	 * @return
	 * @throws SQLException
	 * @author Jean
	 * @since 01.04.2017
	 */
	public List <DC_SQLColumn> getColumns() throws SQLException
	{
		List <DC_SQLColumn> oColumns = new ArrayList<DC_SQLColumn>();
		List<DC_SQLForeignKey> oForeignKeys = getForeignKeys();
		List<String> oColumnNames = getColumnNames();

		for(int i=0; i < oColumnNames.size(); i++)
		{
			oColumns.add(new DC_SQLColumn(oColumnNames.get(i)));
		}
		for(int i=0; i < oColumns.size(); i++)
		{
			DC_SQLColumn oCurrentColumn = oColumns.get(i);
			for(int j=0; j < oForeignKeys.size(); j++)
			{
				if(oCurrentColumn.getName().equals(oForeignKeys.get(j).getColumName()))
				{
					oCurrentColumn.setForeignKey(oForeignKeys.get(j));
					break;
				}
			}
		}

		return oColumns;
	}
	/**
	 * Löscht alle Datensätze in der Tabelle
	 * @throws SQLException
	 * @author J.-Fabian Wenisch
	 * @since 09.04.2017
	 */
	public void clear() throws SQLException
	{
		DC_SQLConnector.execute("TRUNCATE TABLE "+strName);

	}
	/**
	 * Liest alle Datensätze aus der Tabelle aus
	 * @return
	 * @throws SQLException
	 * @author Jean
	 * @since 01.04.2017
	 */
	public ResultSet getData() throws SQLException
	{
		return DC_SQLConnector.executeQuery("SELECT * FROM "+strName);
	}
	/**
	 * Liest die in ./conf/ liegende Default Datei aus um default-Datensätze anzulegen
	 * @throws FileNotFoundException
	 * @throws SQLException 
	 * @author J.-Fabian Wenisch
	 * @since 09.04.2017
	 */
	public void initDefaults() throws FileNotFoundException, SQLException
	{
		File file = new File("./conf/"+strName+".default");
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine())
		{
			try
			{
				addEntry(new ArrayList<String>(Arrays.asList(scanner.nextLine())));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		scanner.close();

	}
	/**
	 * Gibt den Namen der Tabelle zurück
	 * @return
	 */
	public String getName() 
	{
		return strName;
	}
}
