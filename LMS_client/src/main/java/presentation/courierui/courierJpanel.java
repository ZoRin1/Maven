package presentation.courierui;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class courierJpanel extends JPanel{
	private ImageIcon backgroundIcon=new ImageIcon("picture/背景.png");
	public void paintComponent(Graphics g)  
	{  
		super.paintComponent(g);    
		g.drawImage(backgroundIcon.getImage(),0,0,null);
	}
}