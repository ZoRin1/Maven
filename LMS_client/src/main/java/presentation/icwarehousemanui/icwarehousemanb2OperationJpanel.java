package presentation.icwarehousemanui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class icwarehousemanb2OperationJpanel extends JPanel{
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JButton returnButton;
	public icwarehousemanb2OperationJpanel(icwarehousemanJpanel icwarehousemanJpanel,icwarehousemanui icwarehousemanui,b2icwarehousemanui b2icwarehousemanui) {
		// TODO Auto-generated constructor stub
		init();
		icwarehousemanJpanel.add(this);
		registListener(icwarehousemanui, b2icwarehousemanui);
	}
	private void init(){
		ImageIcon returnIcon=new ImageIcon("picture/返回.png");
		returnButton=new JButton(returnIcon);

		
		returnButton.setBounds(662, 575,48,48);
		returnButton.setContentAreaFilled(false);
		this.add(returnButton);
		this.setOpaque(false);
		this.setBounds(260, 60, 730,650);
		this.setLayout(null);
	}
	private void registListener(final icwarehousemanui icwarehousemanui,final b2icwarehousemanui b2icwarehousemanui){
		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				icwarehousemanui.setVisible(true);
				b2icwarehousemanui.dispose();
			}
		});
	}
	public void paintComponent(Graphics g)  
	{  
	    super.paintComponent(g);    
	    g.drawImage(frameIcon.getImage(),-7,-12,null);
     }
}