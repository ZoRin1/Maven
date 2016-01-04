package presentation.courierui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import presentation.mainui.mainui;


public class courierui extends JFrame{
	static Point origin = new Point();
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
  		private String state;
  		public courierui(String s,String[] args,String account,String state) {
	// TODO Auto-generated constructor stub
  		super(s);
  		this.state=state;
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
		courierui.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				// 当鼠标按下的时候获得窗口当前的位置
				origin.x = e.getX();
				origin.y = e.getY();
			}
		});
		courierui.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				// 当鼠标拖动时获取窗口当前位置
				Point p = courierui.getLocation();
				// 设置窗口的位置
				// 窗口当前的位置 + 鼠标当前在窗口的位置 - 鼠标按下的时候在窗口的位置
				courierui.setLocation(p.x + e.getX() - origin.x, p.y + e.getY()- origin.y);
			}
		});
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
				new b1Jpanel1(courierui,courierJpanel,account,state);
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


