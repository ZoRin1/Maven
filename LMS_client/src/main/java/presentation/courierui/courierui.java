package presentation.courierui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import presentation.mainui.mainui;


public class courierui extends JFrame{
		private String[] args;
		private JButton outjButton;
		JButton orderfoundButton;
  		JButton orderfinishButton;
  		JButton documentreplyButton;
  		private courierJpanel courierJpanel;
  		courierOperationJpanel operationJpanel;
  		private JButton tuichuButton;
  		private JButton zuixiaohuaButton;
  		private String account;
  		public courierui(String s,String[] args,String account) {
	// TODO Auto-generated constructor stub
  		super(s);
  		this.account=account;
  		this.args=args;
		init();
		registListener(this,courierJpanel);
}
 private void init(){
	 	ImageIcon orderfoundIcon=new ImageIcon("picture/寄件单创建.png");
	 	ImageIcon orderfinishIcon=new ImageIcon("picture/收件单创建.png");
	 	ImageIcon documentreplyIcon=new ImageIcon("picture/单据反馈.png");
	 	ImageIcon tuichuIcon=new ImageIcon("picture/退出.png");
		ImageIcon zuixiaohuaIcon=new ImageIcon("picture/最小化.png");
		zuixiaohuaButton=new JButton(zuixiaohuaIcon);
		zuixiaohuaButton.setBounds(904, 0, 50, 50);
		zuixiaohuaButton.setContentAreaFilled(false);
		zuixiaohuaButton.setBorderPainted(false);
		tuichuButton=new JButton(tuichuIcon);
		tuichuButton.setBounds(974, 0, 50, 50);
		tuichuButton.setContentAreaFilled(false);
		tuichuButton.setBorderPainted(false);
	 	orderfinishButton=new JButton(orderfinishIcon);
	 	orderfoundButton=new JButton(orderfoundIcon);
	 	orderfinishButton.setContentAreaFilled(false);
	 	orderfoundButton.setContentAreaFilled(false);
	 	documentreplyButton=new JButton(documentreplyIcon);
		documentreplyButton.setContentAreaFilled(false);
	 	courierJpanel=new courierJpanel();
	 	operationJpanel=new courierOperationJpanel(courierJpanel);

	 	orderfoundButton.setBounds(30, 130, 200, 50);
	 	orderfinishButton.setBounds(30, 330, 200, 50);
	 	documentreplyButton.setBounds(30, 530, 200, 50);
	 	ImageIcon outIcon=new ImageIcon("picture/退出登录.png");
		outjButton=new JButton(outIcon);
		outjButton.setBounds(30, 650,  48,48);
		outjButton.setContentAreaFilled(false);
		courierJpanel.add(documentreplyButton);
		 courierJpanel.add(outjButton);
	 	courierJpanel.add(orderfinishButton);
	 	courierJpanel.add(orderfoundButton);
	 	courierJpanel.add(tuichuButton);
	 	courierJpanel.add(zuixiaohuaButton);
	 	courierJpanel.setLayout(null);

	 	this.add(courierJpanel);
	 	this.setSize( 1024, 730);
		//居中
		Toolkit kitToolkit =Toolkit.getDefaultToolkit();
		Dimension screenSize=kitToolkit.getScreenSize();
		int screenWidth=screenSize.width;
		int screenHeight=screenSize.height;
		int windowWidth=this.getWidth();
		int windowHeight=this.getHeight();
		this.setLocation((screenWidth-windowWidth)/2, (screenHeight-windowHeight)/2);
		//不允许窗口改变大小
		this.setResizable(false);
		this.setUndecorated(true);
		this.setVisible(true);
		
}
	private void registListener(final courierui courierui,final courierJpanel courierJpanel){
		zuixiaohuaButton.addMouseListener(new MouseAdapter() {
			ImageIcon zuixiaohuaIcon=new ImageIcon("picture/最小化.png");
			ImageIcon zuixiaohuaIcon2=new ImageIcon("picture/最小化2.png");
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				zuixiaohuaButton.setIcon(zuixiaohuaIcon);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				zuixiaohuaButton.setIcon(zuixiaohuaIcon2);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				courierui.setExtendedState(JFrame.ICONIFIED);
			}
		});
		tuichuButton.addMouseListener(new MouseAdapter() {
			ImageIcon tuichuIcon=new ImageIcon("picture/退出.png");
			ImageIcon tuichuIcon2=new ImageIcon("picture/退出2.png");
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);	
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				tuichuButton.setIcon(tuichuIcon);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				tuichuButton.setIcon(tuichuIcon2);
			}
		});
		outjButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
	
				new mainui().main(args);
				courierui.dispose();
			}
		});
		documentreplyButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				courierJpanel.remove(courierui.operationJpanel);
				courierui.orderfinishButton.setEnabled(false);
				courierui.orderfoundButton.setEnabled(false);
				courierui.documentreplyButton.setEnabled(false);
				new documentJpanel(courierui,courierJpanel,account);
				courierJpanel.repaint();
			}
		});
		orderfoundButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				courierJpanel.remove(courierui.operationJpanel);
				courierui.orderfinishButton.setEnabled(false);
				courierui.orderfoundButton.setEnabled(false);
				courierui.documentreplyButton.setEnabled(false);
				new b1Jpanel1(courierui,courierJpanel,account);
				courierJpanel.repaint();
			}
		});
		orderfinishButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				courierJpanel.remove(courierui.operationJpanel);
				courierui.orderfinishButton.setEnabled(false);
				courierui.orderfoundButton.setEnabled(false);
				courierui.documentreplyButton.setEnabled(false);
				new b2Jpanel1(courierui,courierJpanel,account);
				courierJpanel.repaint();
			}
		});
	}
}
class courierJpanel extends JPanel{
		private ImageIcon backgroundIcon=new ImageIcon("picture/背景.png");
		public void paintComponent(Graphics g)  
		{  
			super.paintComponent(g);    
			g.drawImage(backgroundIcon.getImage(),0,0,null);
		}
   }
class courierOperationJpanel extends JPanel{
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
