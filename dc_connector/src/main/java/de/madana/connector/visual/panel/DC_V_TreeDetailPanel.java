package de.madana.connector.visual.panel;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JPanel;

import de.madana.common.database.DC_SQLTable;

@SuppressWarnings("serial")
/**
 * 
 * @author J.-Fabian Wenisch
 * @since 10.04.2017
 */
public class DC_V_TreeDetailPanel extends MD_V_DefaultPanel
{
	public DC_V_TreeDetailPanel()
	{
		setLayout(new BorderLayout());
	}

	public void initVisual(DC_SQLTable dc_A_SQLTable) throws SQLException
	{
		removeAll();
		JPanel newPanel=new DC_V_TablePanel(dc_A_SQLTable,this);
		add(newPanel, BorderLayout.CENTER);
		validate();
	}

	public void initVisual(JPanel oPanel)
	{
		removeAll();
		add(oPanel, BorderLayout.CENTER);
		validate();
		
	}
}
