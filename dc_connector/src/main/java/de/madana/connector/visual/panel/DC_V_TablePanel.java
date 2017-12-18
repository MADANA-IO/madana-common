package de.madana.connector.visual.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSetMetaData;

import de.madana.common.database.DC_SQLTable;
import de.madana.connector.visual.DC_V_MainFrame;
import de.madana.connector.visual.component.DC_V_InfoLabel;
import de.madana.connector.visual.dialog.DC_V_DBAddDialog;

@SuppressWarnings("serial")
/**
 * 
 * @author J.-Fabian Wenisch
 * @since 10.04.2017
 */
public class DC_V_TablePanel extends MD_V_DefaultPanel
{
	private JButton jBtnAdd = new JButton("Datensatz hinzufügen");
	private JButton jBtnDel = new JButton("Datensatz löschen");
	private int iCurrentSelectedId=0;
	public DC_V_TablePanel(final DC_SQLTable oSQLTable, final DC_V_TreeDetailPanel dc_V_TreeDetailPanel) throws SQLException
	{
		setLayout(new BorderLayout());
//		add(new JLabel(oSQLTable.getName()),BorderLayout.NORTH);
		final JTable jTable = new JTable(buildTableModel(oSQLTable.getData()));
		jTable.setSelectionMode( javax.swing.ListSelectionModel.SINGLE_SELECTION); 
		jTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            // do some actions here, for example
	            // print first column value from selected row
	        	iCurrentSelectedId=Integer.valueOf(jTable.getValueAt(jTable.getSelectedRow(), 0).toString());
	        }
	    });
		JScrollPane jScrollPane =new JScrollPane(jTable);
		jScrollPane.setPreferredSize(new Dimension(595,395));
		add(new JScrollPane(jTable),BorderLayout.CENTER);
		
		JPanel jButtonPanel = new JPanel();
		jButtonPanel.add(new DC_V_InfoLabel("Anzahl Datensätze: " +oSQLTable.getRowCount()),BorderLayout.SOUTH);
		jButtonPanel.add(jBtnAdd);
		jButtonPanel.add(jBtnDel);
		jButtonPanel.setLayout(new FlowLayout());
		jBtnAdd.addActionListener(new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent e) 
			{ 
				try {
					new DC_V_DBAddDialog(DC_V_MainFrame.oFrame,dc_V_TreeDetailPanel, oSQLTable);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(DC_V_MainFrame.oFrame,  e1.getMessage(), "Es ist ein Fehler aufgetreten", JOptionPane.ERROR_MESSAGE);

				}
			} 
		} );
		jBtnDel.addActionListener(new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent e) 
			{ 
				try {
					oSQLTable.deleteEntry(String.valueOf(iCurrentSelectedId));
					dc_V_TreeDetailPanel.initVisual(oSQLTable);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(DC_V_MainFrame.oFrame, e1.getMessage(), "Es ist ein Fehler aufgetreten", JOptionPane.ERROR_MESSAGE);

					e1.printStackTrace();
				}
			} 
		} );
		add(jButtonPanel, BorderLayout.SOUTH);
	}
	public static DefaultTableModel buildTableModel(ResultSet rs)
			throws SQLException {

		ResultSetMetaData metaData = (ResultSetMetaData) rs.getMetaData();

		// names of columns
		Vector<String> columnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();
		for (int column = 1; column <= columnCount; column++) {
			columnNames.add(metaData.getColumnName(column));
		}

		// data of the table
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();
			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
				vector.add(rs.getObject(columnIndex));
			}
			data.add(vector);
		}

		return new oSQLTableModel(data, columnNames);

	}
}
 @SuppressWarnings("serial")
class oSQLTableModel extends DefaultTableModel
{
	public oSQLTableModel(Vector<Vector<Object>> data,
			Vector<String> columnNames) {
		super(data,columnNames);
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) 
	{
		return false;
	}
}
