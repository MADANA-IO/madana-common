package de.madana.connector.visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import de.madana.common.DC_ConfigHandler;
import de.madana.common.database.DC_SQLConnector;
import de.madana.connector.system.DC_ClientConnector;
import de.madana.connector.visual.panel.DC_V_TreeDetailPanel;
import de.madana.connector.visual.panel.DC_V_TreeMenu;


@SuppressWarnings("serial")
/**
 * 
 * @author J.-Fabian Wenisch
 * @since 10.04.2017
 */
public class DC_V_MainFrame extends JFrame
{
	public static ImageIcon imgLogo = new ImageIcon("./img/madana.png");
	public static  Frame oFrame;
	public static DC_ClientConnector oClientConnection;
	public static Color COLOR_1 = Color.decode("#274863");
	public static Color COLOR_2 = Color.decode("#4d7da2");
	public static Color COLOR_3 = Color.decode("#f3f3f6");
	public static Color COLOR_4 = Color.decode("#a0c3e8");
	public static final ExecutorService service = Executors.newCachedThreadPool();

	
	public DC_V_MainFrame(final DC_SQLConnector oConnector, DC_ClientConnector oSocketConnector, JWindow window)
	{
		super("MADANA Connector");;
	
		oClientConnection=oSocketConnector;
		if(oClientConnection!=null)
		{
			
			service.execute(oClientConnection);
		}
		setLayout(new BorderLayout());
		setSize(900,500);
		DC_V_TreeDetailPanel oDetailPanel = new DC_V_TreeDetailPanel();
		JPanel oHeaderpanel = new JPanel();
		oHeaderpanel.setBackground(COLOR_2);
		oHeaderpanel.setForeground(COLOR_3);
		oHeaderpanel.setSize(this.getWidth(),50);
		oHeaderpanel.setLayout(new BorderLayout());
		String strLizenz = "NICHT REGISTRIERT";
		try
		{
			strLizenz="  "+new DC_ConfigHandler(new File("./conf/license")).getProperty("NAME");
		}
		catch(Exception e)
		{
			
		}
		JLabel oHeaderLabel = new JLabel (strLizenz);
		oHeaderLabel.setFont(new Font("Serif", Font.PLAIN, 22));
		oHeaderLabel.setForeground(Color.WHITE);
		oHeaderpanel.add(new JLabel("",new ImageIcon(imgLogo.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT)), SwingConstants.LEFT),BorderLayout.WEST);
		oHeaderpanel.add(oHeaderLabel,BorderLayout.CENTER);
		JLabel jLabelConnection = new JLabel();
		if (oClientConnection!=null && oClientConnection.isInitialized() )
			jLabelConnection.setText("<html>Verbindung zum Server hergestellt <br>"+oClientConnection.getRemoteAddress()+"<html>");
		else
			jLabelConnection.setText("NOT CONNECTED");
			oHeaderpanel.add(jLabelConnection,BorderLayout.EAST);

		add(oHeaderpanel,BorderLayout.NORTH);
		add(oDetailPanel,BorderLayout.CENTER);
		add(new DC_V_TreeMenu(oConnector,oDetailPanel), BorderLayout.WEST);
		window.setVisible(false);

		window.dispose();
		setVisible(true);
		setIconImage(imgLogo.getImage());
		 oFrame= this;

		addWindowListener(new java.awt.event.WindowAdapter() 
		{
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) 
			{
				if (JOptionPane.showConfirmDialog(oFrame, 
						"Are you sure to close this window?", "Really Closing?", 
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
				{
					oConnector.disconnect();
					System.exit(0);
				}
			}
		});
	}
}
