package de.madana.server.database;

import java.sql.SQLException;

public class MDN_ConnectToDatabase {

	public static void main(String[] args)
	{
		MDN_SQLConnector oConnector = new MDN_SQLConnector();
		try 
		{
			oConnector.connect(true);
			System.out.println("Amount of Tables"+ oConnector.getAllTables().size());
			
		} catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
