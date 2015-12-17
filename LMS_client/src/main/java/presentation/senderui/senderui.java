package presentation.senderui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import presentation.mainui.mainui;

public class senderui extends JFrame{
	private String[] args;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JLabel jLabel8;
	private JLabel jLabel9;
	private senderJpanel senderJpanel;
	private senderOperationJpanel operationJpanel;
	private JLabel informationJLabel;
	private JButton returnjButton;
	private JButton tuichuButton;
	private JButton zuixiaohuaButton;
	private ArrayList<String> wuliuInfo;
	public senderui(String s,String[] args,ArrayList<String> wuliuInfo) {
		// TODO Auto-generated constructor stub
		super(s);
		this.wuliuInfo=wuliuInfo;
		this.args=args;	
		init();
		registerLister(this);
	}
	private void init(){
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
		Font font=new Font("幼圆",Font.BOLD,20);
		jLabel1=new JLabel(wuliuInfo.get(0));
		jLabel1.setForeground(Color.white);
		jLabel1.setFont(font);
		jLabel1.setBounds(326, 90, 600, 30);
		jLabel2=new JLabel(wuliuInfo.get(1));
		jLabel2.setForeground(Color.white);
		jLabel2.setFont(font);
		jLabel2.setBounds(326, 150, 600, 30);
		jLabel3=new JLabel(wuliuInfo.get(2));
		jLabel3.setForeground(Color.white);
		jLabel3.setFont(font);
		jLabel3.setBounds(326, 210, 600, 30);
		jLabel4=new JLabel(wuliuInfo.get(3));
		jLabel4.setForeground(Color.white);
		jLabel4.setFont(font);
		jLabel4.setBounds(326, 270, 600, 30);
		jLabel5=new JLabel(wuliuInfo.get(4));
		jLabel5.setForeground(Color.white);
		jLabel5.setFont(font);
		jLabel5.setBounds(326, 330, 600, 30);
		jLabel6=new JLabel(wuliuInfo.get(5));
		jLabel6.setForeground(Color.white);
		jLabel6.setFont(font);
		jLabel6.setBounds(326, 390, 600, 30);
		jLabel7=new JLabel(wuliuInfo.get(6));
		jLabel7.setForeground(Color.white);
		jLabel7.setFont(font);
		jLabel7.setBounds(326, 450, 600, 30);
		jLabel8=new JLabel(wuliuInfo.get(7));
		jLabel8.setForeground(Color.white);
		jLabel8.setFont(font);
		jLabel8.setBounds(326, 510, 600, 30);
		jLabel9=new JLabel(wuliuInfo.get(8));
		jLabel9.setForeground(Color.white);
		jLabel9.setFont(font);
		jLabel9.setBounds(326, 570, 600, 30);
		senderJpanel=new senderJpanel();
		operationJpanel=new senderOperationJpanel();
		informationJLabel=new JLabel("物流信息");
		operationJpanel.setBounds(260, 60, 730,650);
		ImageIcon returnIcon=new ImageIcon("picture/返回.png");
		returnjButton=new JButton(returnIcon);
		returnjButton.setBounds(662, 575, 48,48);
		returnjButton.setContentAreaFilled(false);
		operationJpanel.setLayout(null);
		operationJpanel.add(returnjButton);
		informationJLabel.setFont(new Font("幼圆",Font.BOLD, 36));
		informationJLabel.setBounds(30, 130, 200, 50);
		informationJLabel.setForeground(Color.white);
		senderJpanel.add(informationJLabel);
		senderJpanel.add(operationJpanel);
		senderJpanel.setLayout(null);
		operationJpanel.setOpaque(false);
		senderJpanel.add(jLabel1);
		senderJpanel.add(jLabel2);
		senderJpanel.add(jLabel3);
		senderJpanel.add(jLabel4);
		senderJpanel.add(jLabel5);
		senderJpanel.add(jLabel6);
		senderJpanel.add(jLabel7);
		senderJpanel.add(jLabel8);
		senderJpanel.add(jLabel9);
		senderJpanel.add(zuixiaohuaButton);
		senderJpanel.add(tuichuButton);
		this.add(senderJpanel);
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
	private void registerLister(final senderui s){
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
				s.setExtendedState(JFrame.ICONIFIED);
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
		returnjButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				new mainui().main(args);
				s.dispose();
			}
		});
	}
}
class senderJpanel extends JPanel{
	private ImageIcon backgroundIcon=new ImageIcon("picture/背景.png");
	public void paintComponent(Graphics g)  
	{  
	    super.paintComponent(g);    
	    g.drawImage(backgroundIcon.getImage(),0,0,null);
     }
   }
class senderOperationJpanel extends JPanel{
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	public void paintComponent(Graphics g)  
	{  
	    super.paintComponent(g);    
	    g.drawImage(frameIcon.getImage(),-7,-12,null);
     }
}