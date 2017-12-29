package de.madana.common.datastructures;

import java.io.Serializable;

public abstract class DC_A_Product implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5947596840757570530L;
	protected String name;
	protected String preis;
	protected String description;
	protected String strHersteller;
	protected String strGroesse;
	protected String strId;
	protected String strDatum;
	public String getDescription()
	{
		return toString();
	}
	public String getName()
	{
		return name;
	}
	/**
	 *  Gibt den Preis des Produkts zurück
	 * @return Preis als String
	 * @author Jean
	 * @since 01.05.2017
	 */
	public String getPreis()
	{
		return preis;
	}
	/**
	 * Gibt die ID (PrimaryKey) des Produkts zurück
	 * @return ID als String
	 * @author Jean
	 * @since 01.05.2017
	 */
	public String getId()
	{
		return strId;
	}
	/**
	 * Gibt das Datum zurück an dem der Artikel in das Lager eingegangen ist
	 * @return Datum als String
	 * @author Jean
	 * @since 01.05.2017
	 */
	public String getDatum()
	{
		return strDatum;
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return strHersteller + " "+ name + " "+ strGroesse;
	}
}
