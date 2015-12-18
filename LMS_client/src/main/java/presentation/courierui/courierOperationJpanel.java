package presentation.courierui;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class courierOperationJpanel extends JPanel{
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	public courierOperationJpanel(courierJpanel courierJpanel) {
		// TODO Auto-generated constructor stub
		init();
	 	courierJpanel.add(this);
	}
	private void init(){
	 	this.setBounds(260, 60, 730,650);
	 	this.setOpaque(false);
	}
	public void paintComponent(Graphics g)  
{  
		super.paintComponent(g);    
		g.drawImage(frameIcon.getImage(),-7,-12,null);
 }
}