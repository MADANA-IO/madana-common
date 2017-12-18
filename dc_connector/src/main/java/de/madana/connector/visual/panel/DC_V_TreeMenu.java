package de.madana.connector.visual.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeSelectionModel;

import de.madana.common.DC_ConfigHandler;
import de.madana.common.MD_KeyHandler;
import de.madana.common.database.DC_SQLConnector;
import de.madana.common.database.DC_SQLTable;
import de.madana.connector.system.DC_SerialPortHandler;
import de.madana.connector.visual.DC_V_MainFrame;

@SuppressWarnings("serial")
/**
 * 
 * @author J.-Fabian Wenisch
 * @since 10.04.2017
 */
public class DC_V_TreeMenu extends JPanel implements TreeSelectionListener 
{
	private JTree jTree;
	private DC_SQLConnector oConnector;
	private DC_V_TreeDetailPanel oDetailPanel;
	public DC_V_TreeMenu(DC_SQLConnector oConnector, DC_V_TreeDetailPanel oDetailPanel)
	{

		this.oConnector=oConnector;
		this.oDetailPanel=oDetailPanel;
		setLayout(new BorderLayout());
		DefaultMutableTreeNode top =
				new DefaultMutableTreeNode("Menü");
		createNodes(top);
		jTree = new JTree(top);
		DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer() 
		{

			public Component getTreeCellRendererComponent(JTree tree,Object value, boolean sel, boolean expanded, boolean leaf,int row, boolean hasFocus)
			{
				DefaultMutableTreeNode currentTreeNode = (DefaultMutableTreeNode) value;
				super.setForeground(Color.WHITE);
//			if (currentTreeNode.toString().contains("EXIT"))
//				{
//					super.setLeafIcon(ICON_EXIT);
//				}
//				else 	if (currentTreeNode.toString().contains("INPUT"))
//				{
//					super.setLeafIcon(ICON_INPUT);
//				}
//				else 	if (currentTreeNode.toString().contains("usb"))
//				{
//					super.setLeafIcon(ICON_RFID);
//				}
				return super.getTreeCellRendererComponent(tree, value, sel,expanded, leaf, row, hasFocus);
			}};
			jTree.setCellRenderer(renderer);
			jTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
			jTree.addTreeSelectionListener(this);
			JScrollPane treeView = new JScrollPane(jTree);
			treeView.setPreferredSize(new Dimension(200,400));
			add(treeView, BorderLayout.CENTER);
			jTree.setForeground(DC_V_MainFrame.COLOR_4);
			jTree.setBackground(DC_V_MainFrame.COLOR_1);

	}
	private void createNodes(DefaultMutableTreeNode top) 
	{
		DefaultMutableTreeNode jCategoryNode = null;
		DefaultMutableTreeNode subcategory = null;

		top.add(new DefaultMutableTreeNode("Übersicht"));

		List<String> oPorts = DC_SerialPortHandler.getPortNames();
		subcategory = new DefaultMutableTreeNode("EXIT Zone");
		top.add(subcategory);
//		if(DC_V_MainFrame.oClientConnection!= null &&DC_V_MainFrame.oClientConnection.isInitialized())
//		{
//			List <DC_A_RFIDAntenna> oAntennas = DC_A_RFIDAntenna.getRegisteredAntennas();
//			for(int i=0; i < oAntennas.size(); i++)
//			{
//				subcategory.add(new DefaultMutableTreeNode(oAntennas.get(i).getName()));
//			}		
//
//
//		}
//		else
//		{
//			for(int i=0; i < oPorts.size(); i++)
//			{
//				subcategory.add(new DefaultMutableTreeNode(oPorts.get(i)));
//			}
//		}



		subcategory = new DefaultMutableTreeNode("INPUT Zone");
		top.add(subcategory);
		//original Tutorial

		for(int i=0; i < oPorts.size(); i++)
		{
			subcategory.add(new DefaultMutableTreeNode(oPorts.get(i)));
		}





		//...add more books for programmers...


		jCategoryNode = new DefaultMutableTreeNode("Einstellungen");
		top.add(jCategoryNode);
		DefaultMutableTreeNode oNodeRFID = new DefaultMutableTreeNode("Serielle Schnittstellen");
		jCategoryNode.add(oNodeRFID);
		for(int i=0; i < oPorts.size(); i++)
		{
			oNodeRFID.add(new DefaultMutableTreeNode(oPorts.get(i)));
		}
		subcategory =new DefaultMutableTreeNode("Schlüssel");
		jCategoryNode.add(subcategory);
		List<MD_KeyHandler> oKeyList = MD_KeyHandler.getAllKeys();
		for(int i=0; i < oKeyList.size(); i++)
		{
			subcategory.add(new DefaultMutableTreeNode(oKeyList.get(i).getName()));
		}
		subcategory =new DefaultMutableTreeNode("Konfiguration");
		jCategoryNode.add(subcategory);
		List<DC_ConfigHandler> oConfigList = DC_ConfigHandler.getAllConfigs();
		for(int i=0; i < oConfigList.size(); i++)
		{
			subcategory.add(new DefaultMutableTreeNode(oConfigList.get(i).getName()));
		}
		subcategory = new DefaultMutableTreeNode("Datenbank");
		jCategoryNode.add(subcategory);
		if(DC_SQLConnector.isConnected())
		{
			try 
			{
				List<String> oTables=	oConnector.getAllTables();
				for(int i=0; i<oTables.size(); i++)
					subcategory.add(new DefaultMutableTreeNode(oTables.get(i)));
			} catch (SQLException e)
			{
				JOptionPane.showMessageDialog(DC_V_MainFrame.oFrame,  e.getMessage(), "Es ist ein Fehler aufgetreten", JOptionPane.ERROR_MESSAGE);

				e.printStackTrace();
			}
		}
		jCategoryNode.add(new DefaultMutableTreeNode("Lizenz"));
		jCategoryNode.add(new DefaultMutableTreeNode("Info"));
	}
	@Override
	public void valueChanged(TreeSelectionEvent arg0) 
	{
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)jTree.getLastSelectedPathComponent();
		if (node == null | node.getParent()==null)
			return;

		try
		{
			if (node.toString().equals("Übersicht"))
				oDetailPanel.initVisual(new DC_V_SummaryPanel());
			else if(node.toString().equals("Lizenz"))
				oDetailPanel.initVisual(new DC_V_LicensePanel());
			else if(node.getParent().toString().equals("Datenbank"))
				oDetailPanel.initVisual(new DC_SQLTable(node.toString()));
//			else if (node.getParent().toString().equals("INPUT Zone"))
//			{
//				if(DC_V_MainFrame.oClientConnection.isInitialized())
//				{
//					List <DC_A_RFIDAntenna> oAntennas = DC_A_RFIDAntenna.getRegisteredAntennas();
//					for(int i=0; i < oAntennas.size(); i++)
//					{
//						if(oAntennas.get(i).getName().equals(node.toString()))
//						{
//							oDetailPanel.initVisual(new DC_V_RFIDInputPanel(oAntennas.get(i)));
//							break;
//						}
//					}
//				}
//				else
//				{
//					List<String> oPorts = DC_SerialPortHandler.getPortNames();
//					for(int i=0; i < oPorts.size(); i++)
//					{
//						if(oPorts.get(i).equals(node.toString()))
//						{
//							oDetailPanel.initVisual(new DC_V_RFIDInputPanel(new DC_DefaultRFIDAntenna(SerialPort.getCommPort(oPorts.get(i)))));
//							break;
//						}
//					}
//				}
//			}
//			else if (node.getParent().toString().equals("EXIT Zone"))
//			{
//				if(DC_V_MainFrame.oClientConnection.isInitialized())
//				{
//					List <DC_A_RFIDAntenna> oAntennas = DC_A_RFIDAntenna.getRegisteredAntennas();
//					for(int i=0; i < oAntennas.size(); i++)
//					{
//						if(oAntennas.get(i).getName().equals(node.toString()))
//						{
//							oDetailPanel.initVisual(new DC_V_RFIDExportPanel(oAntennas.get(i)));
//							break;
//						}
//					}
//				}
//				else
//				{
//					List<String> oPorts = DC_SerialPortHandler.getPortNames();
//					for(int i=0; i < oPorts.size(); i++)
//					{
//						if(oPorts.get(i).equals(node.toString()))
//						{
//							oDetailPanel.initVisual(new DC_V_RFIDExportPanel(new DC_DefaultRFIDAntenna(SerialPort.getCommPort(oPorts.get(i)))));
//							break;
//						}
//					}
//				}
//			}
//			else if (node.getParent().toString().equals("Serielle Schnittstellen"))
//			{
//				List<String> oPorts = DC_SerialPortHandler.getPortNames();
//				for(int i=0; i < oPorts.size(); i++)
//				{
//					if(oPorts.get(i).equals(node.toString()))
//					{
//						oDetailPanel.initVisual(new DC_V_AntennaPanel(new DC_DefaultRFIDAntenna(SerialPort.getCommPort(oPorts.get(i)))));
//						break;
//					}
//
//				}
//
//			}
			else if (node.getParent().toString().equals("Konfiguration"))
			{
				List<DC_ConfigHandler> oConfigList = DC_ConfigHandler.getAllConfigs();
				for(int i=0; i < oConfigList.size(); i++)
				{
					if(oConfigList.get(i).getName().equals(node.toString()))
					{
						oDetailPanel.initVisual(new DC_V_ConfigPanel(oConfigList.get(i)));
						break;
					}
				}


			}
			else if (node.toString().equals("Schlüssel"))
			{
			
						oDetailPanel.initVisual(new MD_V_KeyManagementPanel());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}
