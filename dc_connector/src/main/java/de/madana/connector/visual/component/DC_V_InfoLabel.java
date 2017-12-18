package de.madana.connector.visual.component;

import java.awt.Font;

import javax.swing.JLabel;

import de.madana.connector.visual.DC_V_MainFrame;

@SuppressWarnings("serial")
/**
 * 
 * @author Jean
 *
 */
public class DC_V_InfoLabel extends JLabel
{
	public DC_V_InfoLabel(String strText)
	{
		super(strText);
		setForeground(DC_V_MainFrame.COLOR_3);
		setFont(new Font("Verdana", Font.BOLD, 14));
	}
}
