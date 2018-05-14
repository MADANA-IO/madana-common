package de.madana.server.database;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
/**
 * Klasse zur Verwaltung einer einzelnen Spalte aus der Datenbank
 * Kümmert sich um die Auflösung der Fremdschlüssel und bestimmt welche visuellen Komponenten für den Input angezeigt werden sollen
 * @author Jean
 * @since 01.04.2017
 */
public class MDN_SQLColumn 
{
	private String strName;
	private JComponent jVisualComponent;
	private MDN_SQLForeignKey oForeignKey=null;

	/**
	 * Konstruktor
	 * @param strName - Name der Spalte
	 * @author Jean
	 * @since 01.04.2017
	 */
	MDN_SQLColumn(String strName)
	{
		this.strName=strName;
	}
	/**
	 * 
	 * @return {@link String} - Name der Spalte
	 * @author Jean
	 * @since 01.04.2017
	 */
	public String getName()
	{
		return strName;
	}
	/**
	 * 
	 * @param oKey {@link MDN_SQLForeignKey}
	 * @author Jean
	 * @since 01.04.2017
	 */
	protected void setForeignKey(MDN_SQLForeignKey oKey)
	{
		oForeignKey=oKey;
	}
	/**
	 * 
	 * @return {@link MDN_SQLForeignKey} - das Fremdschlüsselobjekt
	 * @author Jean
	 * @since 01.04.2017
	 */
	public MDN_SQLForeignKey getForeignKey()
	{
		return oForeignKey;
	}
	/**
	 * Gibt zurück ob die Spalte über einen Fremdschlüssel verknüpft ist
	 * @return {@link boolean}
	 * @author Jean
	 * @since 01.04.2017
	 */
	public boolean isForeignKey()
	{
		return oForeignKey!=null;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	/**
	 * Gibt für die Spalte eine Visuelle Komponente zurück die zum Input von Daten dient
	 * @return {@link JComponent} Combobox, JTextField
	 * @throws SQLException - falls es sich um eine Spalte mit Fremdschlüssel handelt und die referenzierten Daten nicht ausgelesen werden können
	 * @author Jean
	 * @since 01.04.2017
	 */
	public JComponent getInputComponent() throws SQLException
	{
		if(isForeignKey())
		{
			MDN_SQLTable oForeignTable = new MDN_SQLTable(oForeignKey.getReferencedTableName());
			List <String> oValueList =oForeignTable.getEntries(oForeignTable.getColumnNames().get(1));
			String[] stringArray = oValueList.toArray(new String[0]);
			jVisualComponent= new JComboBox(stringArray);
		}
		else
		{
			jVisualComponent = new JTextField();
			if(strName.equalsIgnoreCase("datum"))
			{
				((JTextField) jVisualComponent).setText(MDN_SQLConnector.simpleDateFormat.format(new Date()));
				jVisualComponent.setEnabled(false);
			}
		}
		return jVisualComponent;
	}
	@SuppressWarnings("rawtypes")
	/**
	 * Gibt den in der Input Komponente ausgewählten / eingegeben Wert zurück
	 * @return {@link String}
	 * @throws SQLException - falls es sich um eine Spalte mit Fremdschlüssel handelt und die referenzierten Daten nicht ausgelesen werden können
	 * @author Jean
	 * @since 01.04.2018
	 */
	public String getInputComponentValue() throws SQLException
	{
		String strValue="";
		if(jVisualComponent instanceof JComboBox)
		{
			strValue =  ((JComboBox) jVisualComponent).getSelectedItem().toString();
			MDN_SQLTable oForeignTable = new MDN_SQLTable(oForeignKey.getReferencedTableName());
			strValue =  oForeignTable.getID(oForeignTable.getColumnNames().get(1), strValue);

		}
		else if(jVisualComponent instanceof JTextField)
			strValue= ((JTextField) jVisualComponent).getText();


		return strValue;
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return getName();
	}
}

