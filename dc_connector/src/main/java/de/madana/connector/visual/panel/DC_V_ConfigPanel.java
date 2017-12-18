package de.madana.connector.visual.panel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import de.madana.common.DC_ConfigHandler;
import de.madana.connector.visual.DC_V_MainFrame;
import de.madana.connector.visual.component.DC_V_InfoLabel;

@SuppressWarnings("serial")
public class DC_V_ConfigPanel extends MD_V_DefaultPanel
{
	DC_ConfigHandler oConfigHandler;
	final JPanel messagePane = new JPanel();

	Map<String, JTextField> map = new HashMap<String, JTextField>();
	DC_V_ConfigPanel(DC_ConfigHandler oConfigHandler)
	{
		this.oConfigHandler= oConfigHandler;
		setLayout(new BorderLayout());
		messagePane.setOpaque(false);
		messagePane.setLayout(new GridLayout(0,2));
		loadPanel();
	
		add(messagePane,BorderLayout.CENTER);

		// Create a button
		JPanel jButtonPane = new JPanel();
		jButtonPane.setLayout(new FlowLayout());
		JButton jBtnLoad = new JButton("Laden");
		jBtnLoad.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				loadPanel();
			} 

		} );
		jButtonPane.add(jBtnLoad);

		JButton jBtnSave = new JButton("Speichern");
		jBtnSave.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{

				for (Entry<String, JTextField> oEntrySet : map.entrySet())
				{
					oConfigHandler.setProperty( oEntrySet.getKey(),  oEntrySet.getValue().getText());
				}
				try 
				{
					oConfigHandler.saveProperties();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(DC_V_MainFrame.oFrame, "Konfiguration gespeichert");
			} 

		} );
		jButtonPane.add(jBtnSave);
		add(jButtonPane,BorderLayout.SOUTH);
	}
	void loadPanel()
	{
		messagePane.removeAll();
		map.clear();
		Properties props =oConfigHandler.getProperties();
		Enumeration<?> eProperties = props.propertyNames();
		while (eProperties.hasMoreElements()) 
		{
			String key = (String) eProperties.nextElement();
			JTextField jTextField =new JTextField(props.getProperty(key));
			messagePane.add(new DC_V_InfoLabel(key));
			messagePane.add( jTextField);
			map.put(key, jTextField);
		}
		validate();

	}
}
