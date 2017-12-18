package de.madana.connector.visual.panel;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class MD_V_DefaultPanel extends JPanel
{
	public static ImageIcon imgLogo = new ImageIcon("./img/intro.jpg");
	int iWidth2 = imgLogo.getImage().getWidth(this)/2;
    int iHeight2 = imgLogo.getImage().getHeight(this)/2;
	@Override
	  protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
	    int x = this.getParent().getWidth()/2 - iWidth2;
        int y = this.getParent().getHeight()/2 - iHeight2;
        g.drawImage(imgLogo.getImage(),x,y,this);
	}
}
