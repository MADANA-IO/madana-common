package de.madana.connector.visual.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import de.madana.common.database.DC_SQLConnector;
import de.madana.common.database.DC_SQLTable;
import de.madana.common.datastructures.DC_CurrencyHandler;
import de.madana.connector.object.business.DC_SimpleDatabaseProduct;
import de.madana.connector.visual.component.DC_V_InfoLabel;

@SuppressWarnings("serial")
public class DC_V_SummaryPanel extends MD_V_DefaultPanel
{
	DC_V_SummaryPanel() throws SQLException
	{
		setLayout(new BorderLayout());
		
		//Tabellen laden
		
		DC_SQLTable oTableLager = new DC_SQLTable("Waren_Lager");
		DC_SQLTable oTableVerkauft = new DC_SQLTable("Waren_Verkauft");
		
		//HeaderPanel
		JPanel oHeaderPanel = new JPanel();
		oHeaderPanel.setLayout(new GridLayout(0,1));
		DC_V_InfoLabel oUeberschrift = new DC_V_InfoLabel("Übersicht");
		oUeberschrift.setFont(new Font("Verdana", Font.PLAIN, 22));
		oUeberschrift.setForeground(Color.WHITE);
		oHeaderPanel.add(oUeberschrift);

		oHeaderPanel.add(new DC_V_InfoLabel("Warenbestand: " + oTableLager.getRowCount())	);
		oHeaderPanel.add(new DC_V_InfoLabel("Insgesamt verkaufte Waren: " + oTableVerkauft.getRowCount())	);
		DC_CurrencyHandler oCurrencyToday = new DC_CurrencyHandler(Locale.GERMANY,0.0);
		DC_CurrencyHandler oCurrencyGlobal = new DC_CurrencyHandler(Locale.GERMANY,0.0);
		
		

		
		///////////////////////////
	
		JPanel messagePane = new JPanel();
		messagePane.setLayout(new GridLayout(0, 2));
		
		JPanel oPanel = new JPanel();
		oPanel.setLayout(new GridLayout(0,1));
		messagePane.add(oPanel);
		ResultSet oNewSet = DC_SQLConnector.executeQuery("Select Artikel.artikel_name, Count(Waren_Verkauft.artikel_nr) Anzahl from Artikel,Waren_Verkauft where Artikel.artikel_nr=Waren_Verkauft.artikel_nr group by Artikel.artikel_name order by Anzahl DESC ");
		
		JFreeChart char1t = ChartFactory.createPieChart(      
		         "Meist verkaufte Waren",  // chart title 
		         createDataset( DC_SQLConnector.executeQuery("Select Artikel.artikel_name, Count(Waren_Verkauft.artikel_nr) Anzahl from Artikel,Waren_Verkauft where Artikel.artikel_nr=Waren_Verkauft.artikel_nr group by Artikel.artikel_name order by Anzahl DESC ")),
		 		  false,           // include legend   
		         true, 
		         false);

		ResultSet oSoldSet = oTableVerkauft.getData();
		HashMap<String, DC_CurrencyHandler> hm = new HashMap<String, DC_CurrencyHandler>();
		while(oSoldSet.next())
		{
			DC_SimpleDatabaseProduct oCurrentProduct = new DC_SimpleDatabaseProduct(oSoldSet);
			String strNewPreis = oCurrentProduct.getPreis().replace(",", ".");
			oCurrencyGlobal.deposit(Double.valueOf(strNewPreis)); 
			
			if(hm.get(oCurrentProduct.getDatum())==null)
			{
				hm.put(oCurrentProduct.getDatum(), new DC_CurrencyHandler(Locale.GERMANY,Double.valueOf(strNewPreis)));
			}
			else
			{
				DC_CurrencyHandler oCurrentCurrency =hm.get(oCurrentProduct.getDatum());
				oCurrentCurrency.deposit(Double.valueOf(strNewPreis));
			}
		}
		
		JFreeChart barchart =  ChartFactory.createBarChart(
				"Umsatzstatistik",
				  "Datum", "Umsatz in €", createDataset(hm), PlotOrientation.VERTICAL,
				   false, false, false);
		
		DC_V_InfoLabel oGlobalUmsatz = new DC_V_InfoLabel("Umsatz Insagesamt: " + oCurrencyGlobal.getAmount()+" €");
		oHeaderPanel.add(oGlobalUmsatz);
		
		JPanel oParentHeaderPanel = new JPanel();
		oParentHeaderPanel.setLayout(new BorderLayout());
		oParentHeaderPanel.add(oHeaderPanel,BorderLayout.NORTH);
		ChartPanel myChartPanel = new ChartPanel(barchart);
		myChartPanel.setPreferredSize(new Dimension(800,200));
		oParentHeaderPanel.add(myChartPanel,BorderLayout.CENTER);
		oParentHeaderPanel.add(new DC_V_InfoLabel( " "),BorderLayout.SOUTH);
		oPanel.add(new ChartPanel(char1t));
		oPanel.add(new JScrollPane(new JTable(DC_V_TablePanel.buildTableModel(oNewSet))));
		
		JPanel oPanel1 = new JPanel();
		oPanel1.setLayout(new GridLayout(0,1));

		ResultSet oSet=oTableVerkauft.getEntries("datum", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		ResultSet oTableSet = DC_SQLConnector.executeQuery("Select Artikel.artikel_name, Count(Waren_Verkauft.artikel_nr) Anzahl from Artikel,Waren_Verkauft where Artikel.artikel_nr=Waren_Verkauft.artikel_nr and datum ='"+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+"' group by Artikel.artikel_name order by Anzahl DESC ");
		
		JFreeChart chart = ChartFactory.createPieChart(      
		         "Heute verkaufte Waren",  // chart title 
		         createDataset(DC_SQLConnector.executeQuery("Select Artikel.artikel_name, Count(Waren_Verkauft.artikel_nr) Anzahl from Artikel,Waren_Verkauft where Artikel.artikel_nr=Waren_Verkauft.artikel_nr and datum ='"+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+"' group by Artikel.artikel_name order by Anzahl DESC ")),        // data    
		         false,           // include legend   
		         true, 
		         false);

	
		oPanel1.add(new ChartPanel(chart));
		oPanel1.add(new JScrollPane(new JTable(DC_V_TablePanel.buildTableModel(oTableSet))));


		   

		while(oSet.next())
		{
			DC_SimpleDatabaseProduct oCurrentProduct = new DC_SimpleDatabaseProduct(oSet);
			String strNewPreis = oCurrentProduct.getPreis().replace(",", ".");
			oCurrencyToday.deposit(Double.valueOf(strNewPreis)); 
		}
		DC_V_InfoLabel oUmsatz = new DC_V_InfoLabel("Umsatz Heute: " + oCurrencyToday.getAmount()+" €");
		oHeaderPanel.add(oUmsatz);
		messagePane.add(oPanel1);
		

		oHeaderPanel.add(new DC_V_InfoLabel("")	);

		// zusammenbauen
		add(oParentHeaderPanel,BorderLayout.NORTH);
		add(messagePane,BorderLayout.CENTER);
		validate();
	}
	 private static PieDataset createDataset(ResultSet oSet ) throws SQLException 
	   {
	      DefaultPieDataset dataset = new DefaultPieDataset( );
	      while(oSet.next())
	      dataset.setValue( oSet.getString(1) , oSet.getDouble(2) );  

	      return dataset;         
	   }
	 private static DefaultCategoryDataset    createDataset(HashMap<String, DC_CurrencyHandler> oSet ) 
	   {
		 DefaultCategoryDataset    dataset = new DefaultCategoryDataset   ();
	      Set<Map.Entry<String, DC_CurrencyHandler>> set = oSet.entrySet();

	      for (Entry<String, DC_CurrencyHandler> me : set) {
	    	  
	        dataset.setValue(  me.getValue().getAmount(),"Umsatz",me.getKey() );  
	      }
	      

	      return dataset;         
	   }
}
