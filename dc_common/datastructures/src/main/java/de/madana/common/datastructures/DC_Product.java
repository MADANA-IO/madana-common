package de.madana.common.datastructures;

import java.io.Serializable;

public class DC_Product extends DC_A_Product implements Serializable
{


	/**
	 * 
	 */
	private static final long serialVersionUID = -8974910254811387553L;

	DC_Product(String strName, String strPreis, String strHersteller, String strGroesse)
	{
		this.name=strName;
		this.preis=strPreis;
		this.strHersteller= strHersteller;
		this.strGroesse= strGroesse;
	}
}
