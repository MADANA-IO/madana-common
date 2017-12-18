package de.madana.connector.visual.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

import de.madana.common.database.DC_SQLColumn;
import de.madana.common.database.DC_SQLTable;
import de.madana.connector.visual.DC_V_MainFrame;
import de.madana.connector.visual.component.DC_V_InfoLabel;
import de.madana.connector.visual.panel.DC_V_TreeDetailPanel;

@SuppressWarnings("serial")
/**
 * 
 * @author Jean
 *
 */
public class DC_V_DBAddDialog extends JDialog 
{


	 DC_SQLTable oTable;

	public DC_V_DBAddDialog(Frame oFrame, final DC_V_TreeDetailPanel dc_V_TreeDetailPanel, final DC_SQLTable oTable) throws SQLException
	{
		super(oFrame, "Datensatz hinzufügen");
		this.oTable = oTable;
		// set the position of the window
		Point p = new Point(400, 400);
		setLocation(p.x, p.y);

		// Create a message
		JPanel messagePane = new JPanel();
	
		messagePane.setLayout(new GridLayout(0, 2));
		final List<DC_SQLColumn> oTableColumns = oTable.getColumns();
		setSize(200,oTableColumns.size()*15);
		messagePane.setLayout(new GridLayout(0, 2));

		for(int i=1; i < oTableColumns.size(); i++)
		{
			messagePane.add(new DC_V_InfoLabel(oTableColumns.get(i).getName()));
			messagePane.add( oTableColumns.get(i).getInputComponent());
		}
		getContentPane().add(messagePane);
		
		// Create a button
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout());
		JButton jBtnAdd = new JButton("Anlegen");
		jBtnAdd.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					ArrayList<String> oValues = new ArrayList<String>();
					for(int i=1; i <oTableColumns.size(); i++)
					{	
					oValues.add(oTableColumns.get(i).getInputComponentValue());
					}
					oTable.addEntry(oValues);
					dc_V_TreeDetailPanel.initVisual(oTable);
					setVisible(false);
					dispose();
					
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(DC_V_MainFrame.oFrame,  e1.getMessage(), "Es ist ein Fehler aufgetreten", JOptionPane.ERROR_MESSAGE);


					e1.printStackTrace();
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
