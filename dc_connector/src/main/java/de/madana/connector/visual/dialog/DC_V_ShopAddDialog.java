package de.madana.connector.visual.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import de.madana.common.DC_ConfigHandler;
import de.madana.connector.visual.DC_V_MainFrame;
import de.madana.connector.visual.component.DC_V_InfoLabel;

@SuppressWarnings("serial")
public class DC_V_ShopAddDialog extends JDialog 
{


	public DC_V_ShopAddDialog(Frame oFrame, JPanel messagePane, Map<String, JTextField> map, DC_ConfigHandler oConfigHandler) 
	{
		super(oFrame, "Datensatz hinzufügen");
		// set the position of the window
		Point p = new Point(400, 400);
		setLocation(p.x, p.y);

		JPanel oHeaderPanel = new JPanel();
		oHeaderPanel.setLayout(new BorderLayout());
	
		oHeaderPanel.add(new JLabel("",DC_V_MainFrame.imgLogo, SwingConstants.CENTER),BorderLayout.CENTER);
		oHeaderPanel.add(new DC_V_InfoLabel("Bitte füllen Sie alle Felder aus um Ihren Shop im Online-System zu registrieren"),BorderLayout.SOUTH);
		getContentPane().add(oHeaderPanel, BorderLayout.NORTH);
		getContentPane().add(messagePane, BorderLayout.CENTER);
		
		// Create a button
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout());
		JButton jBtnAdd = new JButton("Registrieren");
		jBtnAdd.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				StringBuilder oStringBuilder = new StringBuilder();
				oStringBuilder.append(map.get("NAME").getText());
				oStringBuilder.append("|");
				oStringBuilder.append(map.get("URL").getText());
				oStringBuilder.append("|");
				oStringBuilder.append(map.get("ADDRESS").getText());
				oStringBuilder.append("|");
				oStringBuilder.append(map.get("POSTCODE").getText());
				oStringBuilder.append("|");
				oStringBuilder.append(map.get("PLACE").getText());
				oStringBuilder.append("|");
				oStringBuilder.append(map.get("COUNTRY").getText());
				try
				{
					String strLicense = DC_V_MainFrame.oClientConnection.registerShop(oStringBuilder.toString());
					System.out.println("Registrierung erfolgreich:"+strLicense);
					oConfigHandler.setProperty("NAME", map.get("NAME").getText());
					oConfigHandler.setProperty("URL", map.get("URL").getText());
					oConfigHandler.setProperty("ADDRESS", map.get("ADDRESS").getText());
					oConfigHandler.setProperty("POSTCODE", map.get("POSTCODE").getText());
					oConfigHandler.setProperty("PLACE", map.get("PLACE").getText());
					oConfigHandler.setProperty("COUNTRY", map.get("COUNTRY").getText());
					oConfigHandler.setProperty("LICENSE", strLicense);
					oConfigHandler.saveProperties();
					setVisible(false);
					dispose();
					JOptionPane.showMessageDialog(DC_V_MainFrame.oFrame,  "Vielen Dank für Ihre Registierung im Online System von digiClothes", "Erfolgreich registriert", JOptionPane.INFORMATION_MESSAGE);
					
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(DC_V_MainFrame.oFrame,  ex.getMessage(), "Es ist ein Fehler aufgetreten", JOptionPane.ERROR_MESSAGE);
					setVisible(false);
					dispose();
				}
			} 
		
		} );
		JButton button = new JButton("Abbrechen");
		buttonPane.add(jBtnAdd);
		buttonPane.add(button);
		// set action listener on the button
		button.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				dispose();
			} 
		
		} );
		getContentPane().add(buttonPane, BorderLayout.PAGE_END);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}
	

	// override the createRootPane inherited by the JDialog, to create the rootPane.
	// create functionality to close the window when "Escape" button is pressed
	public JRootPane createRootPane() {
		JRootPane rootPane = new JRootPane();
		KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
		Action action = new AbstractAction() {
			
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				System.out.println("escaping..");
				setVisible(false);
				dispose();
			}
		};
		InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMap.put(stroke, "ESCAPE");
		rootPane.getActionMap().put("ESCAPE", action);
		return rootPane;
	}


}