package de.madana.common.datastructures;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DC_ShoppingCart implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4701329014042344972L;
	List<DC_A_Product> oItems = new ArrayList<DC_A_Product>();
	DC_CurrencyHandler oCurrencyHandler;
	
	public DC_ShoppingCart(DC_CurrencyHandler oCurrency)
	{
		this.oCurrencyHandler=oCurrency;
	}
	public void addItem(DC_A_Product oItem)
	{
		oItems.add(new DC_Product(oItem.name, oItem.preis, oItem.strHersteller,oItem.strGroesse));
		oCurrencyHandler.deposit(oItem.getPreis());
	}
	public List<DC_A_Product> getItems()
	{
		return oItems;
	}
	public DC_CurrencyHandler getCurrency()
	{
		return oCurrencyHandler;
	}
	public double getAmount()
	{
		return oCurrencyHandler.getAmount();
	}
}
