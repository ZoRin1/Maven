package presentation.financialstaffui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class financialstaffOperationJpanel extends JPanel{
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JLabel welcome1;
	private JLabel welcome2;
	public financialstaffOperationJpanel(financialstaffJpanel financialstaffJpanel) {
		// TODO Auto-generated constructor stub
		init();
		financialstaffJpanel.add(this);
	}
	private void init(){
		
		this.setLayout(null);

		Font font=new Font("幼圆",Font.BOLD,60);
		
		welcome1 = new JLabel("欢迎使用");
		welcome1.setFont(font);
		welcome1.setForeground(Color.WHITE);
		welcome1.setBounds(220, 200, 300, 100);
		this.add(welcome1);
		
		welcome2 = new JLabel("NJU物流管理系统");
		welcome2.setFont(font);
		welcome2.setForeground(Color.WHITE);
		welcome2.setBounds(110, 300, 700, 100);
		this.add(welcome2);
		this.setBounds(260, 60, 730,650);
		this.setOpaque(false);

	}
	public void paintComponent(Graphics g)  
	{  
	    super.paintComponent(g);    
	    g.drawImage(frameIcon.getImage(),-7,-12,null);
     }
}