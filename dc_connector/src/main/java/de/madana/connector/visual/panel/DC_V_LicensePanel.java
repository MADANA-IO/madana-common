package de.madana.connector.visual.panel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import de.madana.common.DC_ConfigHandler;
import de.madana.connector.visual.DC_V_MainFrame;
import de.madana.connector.visual.component.DC_V_InfoLabel;
import de.madana.connector.visual.dialog.DC_V_ShopAddDialog;

@SuppressWarnings("serial")
public class DC_V_LicensePanel extends DC_V_ConfigPanel
{

	DC_V_LicensePanel() throws IOException 
	{
		super(new DC_ConfigHandler(new File("./conf/license")));
		setOpaque(false);
		removeAll();
		if(oConfigHandler.getProperty("NAME").length()==0)
		{
			oConfigHandler.getProperty("NAME");
			oConfigHandler.getProperty("URL");
			oConfigHandler.getProperty("ADDRESS");
			oConfigHandler.getProperty("POSTCODE");
			oConfigHandler.getProperty("PLACE");
			oConfigHandler.getProperty("COUNTRY");
			loadPanel();
			add (new DC_V_InfoLabel("SHOP derzeit nicht registriert"));
			JPanel jButtonPane = new JPanel();
			jButtonPane.setLayout(new FlowLayout());
			JButton jBtnLoad = new JButton("SHOP registrieren");
			jBtnLoad.addActionListener(new ActionListener() 
			{

				@Override
				public void actionPerformed(ActionEvent e) 
				{
					new DC_V_ShopAddDialog(DC_V_MainFrame.oFrame,messagePane,map,oConfigHandler);
					} 

			} );
			jButtonPane.add(jBtnLoad);
			add(jButtonPane,BorderLayout.SOUTH);
			}
		else
		{
			add(messagePane);
			for (Entry<String, JTextField> oEntrySet : map.entrySet())
			{
				oEntrySet.getValue().setEditable(false);
				oEntrySet.getValue().setEnabled(false);
			}
		}
		// TODO Auto-generated constructor stub
	}

}
