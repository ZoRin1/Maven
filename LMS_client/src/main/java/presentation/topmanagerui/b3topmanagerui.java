package presentation.topmanagerui;

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

public class b3topmanagerui extends JFrame{
	static Point origin = new Point();
	private topmanagerJpanel topmanagerJpanel;
	private topmanagerb3OperationJpanel operationJpanel;
	private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
	private JButton tuichuButton;
	private JButton zuixiaohuaButton;
	public b3topmanagerui(String s,topmanagerui tmui) {
		// TODO Auto-generated constructor stub
		super(s);
		init(tmui);
		registListener(this);
	}
	private void registListener(final b3topmanagerui b3topmanagerui) {
		// TODO Auto-generated method stub
		b3topmanagerui.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				// 当鼠标按下的时候获得窗口当前的位置
				origin.x = e.getX();
				origin.y = e.getY();
			}
		});
		b3topmanagerui.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				// 当鼠标拖动时获取窗口当前位置
				Point p = b3topmanagerui.getLocation();
				// 设置窗口的位置
				// 窗口当前的位置 + 鼠标当前在窗口的位置 - 鼠标按下的时候在窗口的位置
				b3topmanagerui.setLocation(p.x + e.getX() - origin.x, p.y + e.getY()- origin.y);
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
				b3topmanagerui.setExtendedState(JFrame.ICONIFIED);
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
	}
	private void init(topmanagerui topmanagerui){
		topmanagerJpanel=new topmanagerJpanel();
		operationJpanel=new topmanagerb3OperationJpanel(topmanagerJpanel,topmanagerui,this);
		ImageIcon b1Icon=new ImageIcon("picture/寄件单.png");
		ImageIcon b2Icon=new ImageIcon("picture/收款单.png");
		ImageIcon b3Icon=new ImageIcon("picture/装车单.png");
		ImageIcon b4Icon=new ImageIcon("picture/中转中心接收单.png");
		ImageIcon b5Icon=new ImageIcon("picture/装运单.png");
		ImageIcon b6Icon=new ImageIcon("picture/出库单.png");
		ImageIcon b7Icon=new ImageIcon("picture/入库单.png");
		ImageIcon b8Icon=new ImageIcon("picture/营业厅接收单.png");
		ImageIcon b9Icon=new ImageIcon("picture/派件单.png");
		ImageIcon b10Icon=new ImageIcon("picture/收件单.png");
		ImageIcon b11Icon=new ImageIcon("picture/付款单.png");
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
		b1=new JButton(b1Icon);
		b2=new JButton(b2Icon);
		b3=new JButton(b3Icon);
		b4=new JButton(b4Icon);
		b5=new JButton(b5Icon);
		b6=new JButton(b6Icon);
		b7=new JButton(b7Icon);
		b8=new JButton(b8Icon);
		b9=new JButton(b9Icon);
		b10=new JButton(b10Icon);
		b11=new JButton(b11Icon);		
		b1.setContentAreaFilled(false);
		b2.setContentAreaFilled(false);
		b3.setContentAreaFilled(false);
		b4.setContentAreaFilled(false);
		b5.setContentAreaFilled(false);
		b6.setContentAreaFilled(false);
		b7.setContentAreaFilled(false);
		b8.setContentAreaFilled(false);
		b9.setContentAreaFilled(false);
		b10.setContentAreaFilled(false);
		b11.setContentAreaFilled(false);
		b1.setBounds(30, 70,200, 50);
		b2.setBounds(30,125,200, 50);
		b3.setBounds(30,180,200, 50);
		b4.setBounds(30,235,200, 50);
		b5.setBounds(30,290,200, 50);
		b6.setBounds(30,345,200, 50);
		b7.setBounds(30,400,200, 50);
		b8.setBounds(30,455,200, 50);
		b9.setBounds(30,510,200, 50);
		b10.setBounds(30,565,200, 50);
		b11.setBounds(30,620,200, 50);
		topmanagerJpanel.add(b1);
		topmanagerJpanel.add(b2);
		topmanagerJpanel.add(b3);
		topmanagerJpanel.add(b4);
		topmanagerJpanel.add(b5);
		topmanagerJpanel.add(b6);
		topmanagerJpanel.add(b7);
		topmanagerJpanel.add(b8);
		topmanagerJpanel.add(b9);
		topmanagerJpanel.add(b10);
		topmanagerJpanel.add(b11);
		topmanagerJpanel.add(zuixiaohuaButton);
		topmanagerJpanel.add(tuichuButton);
		topmanagerJpanel.setLayout(null);

		this.add(topmanagerJpanel);
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

}
class topmanagerb3OperationJpanel extends JPanel{
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JButton returnButton;
	public topmanagerb3OperationJpanel(topmanagerJpanel topmanagerJpanel,topmanagerui topmanagerui,b3topmanagerui b3topmanagerui) {
		// TODO Auto-generated constructor stub
		init();
		topmanagerJpanel.add(this);
		registListener(topmanagerui, b3topmanagerui);
	}
	private void init(){
		ImageIcon returnIcon=new ImageIcon("picture/返回.png");
		returnButton=new JButton(returnIcon);
		returnButton.setBounds(662, 575, 48,48);
		returnButton.setContentAreaFilled(false);
		this.setBounds(260, 60,730,650);
		this.setOpaque(false);
		this.setLayout(null);
		this.add(returnButton);
	}
	private void registListener(final topmanagerui tmui,final b3topmanagerui b3tmui){
		
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tmui.setVisible(true);
				b3tmui.dispose();
				
			}
		});
	}
	public void paintComponent(Graphics g)  
	{  
	    super.paintComponent(g);    
	    g.drawImage(frameIcon.getImage(),-7,-12,null);
     }

}

