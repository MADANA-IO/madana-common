package de.madana.connector.system;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import de.madana.common.DC_ConfigHandler;
import de.madana.common.DC_LogHandler;
import de.madana.common.database.DC_SQLConnector;
import de.madana.connector.visual.DC_V_MainFrame;

public class Main
{
	static DC_LogHandler oErrorStream ; 
	static DC_LogHandler oOutStream ; 
	public static void main(String[] args) 
	{
		try 
		{
			File oFile = new File("./Error.log");
			if(!oFile.exists())
				oFile.createNewFile();
			oFile = new File("./Output.log");
			if(!oFile.exists())
				oFile.createNewFile();
			oErrorStream = new DC_LogHandler("Error.log");
			oOutStream = new DC_LogHandler("Output.log");
			System.setOut(oOutStream);
			System.setErr(oErrorStream);
		} 
		catch (IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		JWindow window = new JWindow();

		Image newimg = DC_V_MainFrame.imgLogo.getImage().getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
		ImageIcon imageIcon = new ImageIcon(newimg);
		window.getContentPane().add(new JLabel("",imageIcon , SwingConstants.CENTER),BorderLayout.CENTER);
		JProgressBar progressBar = new JProgressBar(0, 100);
		progressBar.setIndeterminate(true);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		window.getContentPane().add(progressBar, BorderLayout.SOUTH);
		window.setBounds(500, 150, 400, 400);
		window.setVisible(true);
		progressBar.setString("Lade Konfiguration");
		try 
		{
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
		    {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            UIManager.put("nimbusBase",  DC_V_MainFrame.COLOR_4);
		            UIManager.put("nimbusBlueGrey",DC_V_MainFrame.COLOR_3);
		            UIManager.put("control", DC_V_MainFrame.COLOR_1);
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}

		DC_SQLConnector oConnect = new DC_SQLConnector();
		DC_ClientConnector oSocketConnector= null;
		try 
		{
			DC_ConfigHandler oConfigHandler = new DC_ConfigHandler("server");
			String	strServerAddress="localhost";
			int iServerPort =13013;
			if(oConfigHandler.getProperty("server").length()>0)
				strServerAddress = oConfigHandler.getProperty("server");
			if(oConfigHandler.getProperty("serverport").length()>0)
				iServerPort = Integer.valueOf(oConfigHandler.getProperty("serverport"));
			Socket oSocket = new Socket (strServerAddress,iServerPort);
			progressBar.setString("Verbinde zu Server");
			 oSocketConnector = new DC_ClientConnector(oSocket);
			 
			} catch (IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	
			progressBar.setString("Verbinde zu Datenbank");
			try
			{
				oConnect.connect(true);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			progressBar.setString("Initialisiere Oberfläche");
			new DC_V_MainFrame(oConnect,oSocketConnector, window);


		}
	}

