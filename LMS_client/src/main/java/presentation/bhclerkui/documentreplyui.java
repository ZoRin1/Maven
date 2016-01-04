package presentation.bhclerkui;

import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JLabel;
import javax.swing.JPanel;


public class documentreplyui extends JFrame{
	static Point origin = new Point();
	private bhclerkJpanel bhclerkJpanel;
	private bhclerkdocumentreplyOperationJpanel operationJpanel;
//	private JButton b1,b2,b3,b4;
	private JButton tuichuButton;
	private JButton zuixiaohuaButton;
	private String account;
	public documentreplyui(String s,bhclerkui bhclerkui,String account) {
		// TODO Auto-generated constructor stub
		super(s);
		this.account=account;
		init(bhclerkui);
		registListener(this);
	}
	private void registListener(final documentreplyui documentreplyui) {
		// TODO Auto-generated method stub
		documentreplyui.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				// 当鼠标按下的时候获得窗口当前的位置
				origin.x = e.getX();
				origin.y = e.getY();
			}
		});
		documentreplyui.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				// 当鼠标拖动时获取窗口当前位置
				Point p = documentreplyui.getLocation();
				// 设置窗口的位置
				// 窗口当前的位置 + 鼠标当前在窗口的位置 - 鼠标按下的时候在窗口的位置
				documentreplyui.setLocation(p.x + e.getX() - origin.x, p.y + e.getY()- origin.y);
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
			documentreplyui.setExtendedState(JFrame.ICONIFIED);
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
private void init(bhclerkui bhclerkui){
	bhclerkJpanel=new bhclerkJpanel();
	operationJpanel=new bhclerkdocumentreplyOperationJpanel(bhclerkJpanel,bhclerkui,this,account);
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
	
	bhclerkJpanel.add(tuichuButton);
	bhclerkJpanel.add(zuixiaohuaButton);
	bhclerkJpanel.setLayout(null);

	this.add(bhclerkJpanel);
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

class bhclerkdocumentreplyOperationJpanel extends JPanel{
	private JButton returnButton;
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	private JLabel j1;
	private documentReplyJTable jtable;
	private String account;
	private documentreplyui ui;
	public bhclerkdocumentreplyOperationJpanel(bhclerkJpanel bhclerkJpanel,bhclerkui bhclerkui,documentreplyui documentreplyui,String account) {
		// TODO Auto-generated constructor stub
		this.account=account;
		ui=documentreplyui;
		init();
		registListener(bhclerkJpanel,bhclerkui, documentreplyui);
		bhclerkJpanel.add(this);
	}
	public void paintComponent(Graphics g)  
	{  
	    super.paintComponent(g);    
	    g.drawImage(frameIcon.getImage(),-7,-12,null);
     }
	private void init(){
		Font font=new Font("幼圆",Font.BOLD,20);
		ImageIcon i1 = new ImageIcon("picture/财务图片/单据反馈框架.png");
		j1 = new JLabel(i1);
		j1.setBounds(0, 0, 720, 566);
		jtable=new documentReplyJTable(ui,this,account);
		
		returnButton=new JButton(returnIcon);
		returnButton.setBounds(662, 575,48,48);
		returnButton.setContentAreaFilled(false);
		
		this.setBounds(260, 60, 730,650);
		this.add(j1);
		this.add(returnButton);
		this.setLayout(null);
		this.setOpaque(false);
	}
	private void registListener(final bhclerkJpanel bhclerkJpanel,final bhclerkui bhclerkui,final documentreplyui documentreplyui){
		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				bhclerkui.setVisible(true);
				documentreplyui.dispose();				
			}
		});
	}
}
