package de.madana.connector.object.business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.madana.common.database.DC_SQLConnector;
import de.madana.common.database.DC_SQLTable;
import de.madana.common.datastructures.DC_A_Product;

/**
 * Klasse zur Verwaltung eines einzelnen Produktes -> Wrapper der Daten aus der Datenbank
 * @author Jean
 *
 */
public class DC_SimpleDatabaseProduct extends DC_A_Product
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static DC_SQLTable oArtikelTable = new DC_SQLTable("Artikel");
	static DC_SQLTable oHerstellerTable = new DC_SQLTable("Hersteller");
	static DC_SQLTable oGroesseTable = new DC_SQLTable("Groesse");
	List<String> oRawData= new ArrayList<String>();

	/**
	 * 
	 * @param oSet
	 * @throws SQLException
	 */
	public DC_SimpleDatabaseProduct(ResultSet oSet) throws SQLException
	{

		strId=oSet.getString(1);
		oRawData.add(oSet.getString(2));
		oRawData.add(oSet.getString(3));
		oRawData.add(oSet.getString(4));
		oRawData.add(oSet.getString(5));
		strDatum =oSet.getString(6);
		ResultSet oArtikelSet =oArtikelTable.getEntries("artikel_nr", oSet.getString(3));
		if(oArtikelSet.next())
		{
			name= oArtikelSet.getString(2);
			preis= oArtikelSet.getString(4);
			ResultSet oHerstellerSet =oHerstellerTable.getEntries("hersteller_nr", oArtikelSet.getString(6));
			if(oHerstellerSet.next())
				strHersteller= oHerstellerSet.getString(2);
		}
		ResultSet oGroesseSet =oGroesseTable.getEntries("groesse_nr", oSet.getString(4));
		if(oGroesseSet.next())
			strGroesse= oGroesseSet.getString(2);




	}

	/**
	 * Gibt den Datensatz als Liste aus Strings zurück
	 * @return String
	 * @author Jean
	 * @since 01.05.2017
	 */
	public List<String> getRawData()
	{
		oRawData.add(DC_SQLConnector.simpleDateFormat.format(new Date()));
		return oRawData;
	}


}
