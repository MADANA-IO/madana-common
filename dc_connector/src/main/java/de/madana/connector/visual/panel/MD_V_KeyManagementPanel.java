package de.madana.connector.visual.panel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JPanel;

import de.madana.common.security.GenerateKeys;

public class MD_V_KeyManagementPanel extends MD_V_DefaultPanel
{
 MD_V_KeyManagementPanel()
 {
	 JPanel jButtonPane = new JPanel();
		jButtonPane.setLayout(new FlowLayout());
		JButton jBtnLoad = new JButton("create");
		jBtnLoad.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				GenerateKeys gk;
				try {
					String strTimestamp = new SimpleDateFormat("MMddyyyyHHmmss").format(new Date());
					gk = new GenerateKeys(4096);
					gk.createKeys();
					gk.writeToFile("./keys/publicKey"+strTimestamp+".key", gk.getPublicKey().getEncoded());
					gk.writeToFile("./keys//privateKey"+strTimestamp+".key", gk.getPrivateKey().getEncoded());
				} catch (NoSuchAlgorithmException | NoSuchProviderException ex) {
					System.err.println(ex.getMessage());
				} catch (IOException ex) {
					System.err.println(ex.getMessage());
				}
			} 

		} );
		jButtonPane.add(jBtnLoad);
		add(jButtonPane, BorderLayout.CENTER);
 }
}
