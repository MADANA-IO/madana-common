package de.madana.common.datastructures;

import java.io.Serializable;
import java.util.Currency;
import java.util.Locale;
/**
 * Klasse zur Berechnung von des Kassenbons
 * @author Jean
 * @since 01.05.2017
 */
public class DC_CurrencyHandler implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 675794071631702141L;
	private Locale locale;
	private double amount;
	private Currency c;
	
	public DC_CurrencyHandler(Locale locale, double amount) {
		this.locale = locale;
		this.amount = amount;
		this.c = Currency.getInstance(locale);
	}
	
	public double getAmount() {
		return amount;
	}
	
	public Locale getLocale() {
		return this.locale;
	}
	
	
	public void deposit(double deposit) {
		amount += deposit;
	}
	public void deposit(String  strdeposit) 
	{
		String strNewPreis = strdeposit.replace(",", ".");
		deposit(Double.valueOf(strNewPreis)); 
	}
	
	public void withdraw(int w) {
		if (w<amount) {
			amount -= w;
			System.out.println(w + " " + c.getCurrencyCode()+" withdrawed");
		} else {
			System.out.println("You can't withdraw  "+w+" "+ c.getCurrencyCode()+"!");
		}
		
	}
	
}