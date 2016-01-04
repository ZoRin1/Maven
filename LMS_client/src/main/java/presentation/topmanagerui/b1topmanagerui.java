package presentation.topmanagerui;

import java.awt.Color;
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

import presentation.financialstaffui.financialstaffui;

public class b1topmanagerui extends JFrame{
	static Point origin = new Point();
	topmanagerJpanel topmanagerJpanel;
	topmanagerb1OperationJpanel operationJpanel;
	JButton b1,b2,b3,b4,b5,b6;
	private JButton tuichuButton;
	private JButton zuixiaohuaButton;
	public b1topmanagerui(String s,topmanagerui tui) {
		// TODO Auto-generated constructor stub
		super(s);
		init(tui);	
		registListener(tui,topmanagerJpanel,this);
	}
	private void init(topmanagerui topmanagerui){
		topmanagerJpanel=new topmanagerJpanel();
		operationJpanel=new topmanagerb1OperationJpanel(topmanagerJpanel,topmanagerui,this);
		ImageIcon b1Icon=new ImageIcon("picture/快递员.png");
		ImageIcon b2Icon=new ImageIcon("picture/营业厅业务员.png");
		ImageIcon b3Icon=new ImageIcon("picture/中转中心业务员.png");
		ImageIcon b4Icon=new ImageIcon("picture/中转中心仓库管理员.png");
		ImageIcon b5Icon=new ImageIcon("picture/财务人员.png");
		ImageIcon b6Icon=new ImageIcon("picture/管理员.png");
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
		b1.setContentAreaFilled(false);
		b2.setContentAreaFilled(false);
		b3.setContentAreaFilled(false);
		b4.setContentAreaFilled(false);
		b5.setContentAreaFilled(false);
		b6.setContentAreaFilled(false);

		b1.setBounds(30, 80,200, 50);
		b2.setBounds(30,180,200, 50);
		b3.setBounds(30,280,200, 50);
		b4.setBounds(30,380,200, 50);
		b5.setBounds(30,480,200, 50);
		b6.setBounds(30,580,200, 50);
		topmanagerJpanel.add(b1);
		topmanagerJpanel.add(b2);
		topmanagerJpanel.add(b3);
		topmanagerJpanel.add(b4);
		topmanagerJpanel.add(b5);
		topmanagerJpanel.add(b6);
		topmanagerJpanel.add(tuichuButton);
		topmanagerJpanel.add(zuixiaohuaButton);
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
	
	private void registListener(final topmanagerui tui,final topmanagerJpanel tjpl,final b1topmanagerui b1ui){
		b1ui.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				// 当鼠标按下的时候获得窗口当前的位置
				origin.x = e.getX();
				origin.y = e.getY();
			}
		});
		b1ui.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				// 当鼠标拖动时获取窗口当前位置
				Point p = b1ui.getLocation();
				// 设置窗口的位置
				// 窗口当前的位置 + 鼠标当前在窗口的位置 - 鼠标按下的时候在窗口的位置
				b1ui.setLocation(p.x + e.getX() - origin.x, p.y + e.getY()- origin.y);
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
				b1ui.setExtendedState(JFrame.ICONIFIED);
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
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tjpl.remove(b1ui.operationJpanel);
				b1ui.setTitle("设置快递员工资策略");
				b1ui.b1.setEnabled(false);
				b1ui.b2.setEnabled(false);
				b1ui.b3.setEnabled(false);
				b1ui.b4.setEnabled(false);
				b1ui.b5.setEnabled(false);
				b1ui.b6.setEnabled(false);
				
				new b1Salary(tui,tjpl,b1ui,1);
				b1ui.repaint();
				
				
			}
		});
		

		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tjpl.remove(b1ui.operationJpanel);
				b1ui.setTitle("设置营业厅业务员工资策略");
				b1ui.b1.setEnabled(false);
				b1ui.b2.setEnabled(false);
				b1ui.b3.setEnabled(false);
				b1ui.b4.setEnabled(false);
				b1ui.b5.setEnabled(false);
				b1ui.b6.setEnabled(false);
				
				new b1Salary(tui,tjpl,b1ui,2);
				b1ui.repaint();
				
				
			}
		});


		
		b3.addActionListener(new ActionListener() {	    
			@Override	
			public void actionPerformed(ActionEvent e) {
		
				// TODO Auto-generated method stub
		
				tjpl.remove(b1ui.operationJpanel);
				b1ui.setTitle("设置中转中心业务员工资策略");
				b1ui.b1.setEnabled(false);
				b1ui.b2.setEnabled(false);
				b1ui.b3.setEnabled(false);
				b1ui.b4.setEnabled(false);		
				b1ui.b5.setEnabled(false);		
				b1ui.b6.setEnabled(false);		
		
				new b1Salary(tui,tjpl,b1ui,3);
				b1ui.repaint();
			}
		});



		b4.addActionListener(new ActionListener() {
	
	
			@Override	
			public void actionPerformed(ActionEvent e) {		
				// TODO Auto-generated method stub		
				tjpl.remove(b1ui.operationJpanel);
				b1ui.setTitle("设置中转中心仓库管理员工资策略");
				b1ui.b1.setEnabled(false);		
				b1ui.b2.setEnabled(false);						
				b1ui.b3.setEnabled(false);	
				b1ui.b4.setEnabled(false);		
				b1ui.b5.setEnabled(false);		
				b1ui.b6.setEnabled(false);				
		
				new b1Salary(tui,tjpl,b1ui,4);	
				b1ui.repaint();
			}
		});

		b5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tjpl.remove(b1ui.operationJpanel);
				b1ui.setTitle("设置财务人员工资策略");
				b1ui.b1.setEnabled(false);
				b1ui.b2.setEnabled(false);
				b1ui.b3.setEnabled(false);
				b1ui.b4.setEnabled(false);
				b1ui.b5.setEnabled(false);	
				b1ui.b6.setEnabled(false);

				new b1Salary(tui,tjpl,b1ui,5);
				b1ui.repaint();
			}
		});

		b6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tjpl.remove(b1ui.operationJpanel);
				b1ui.setTitle("设置系统管理员工资策略");
				b1ui.b6.setEnabled(false);
				b1ui.b2.setEnabled(false);
				b1ui.b3.setEnabled(false);
				b1ui.b4.setEnabled(false);
				b1ui.b5.setEnabled(false);
				b1ui.b1.setEnabled(false);

				new b1Salary(tui,tjpl,b1ui,6);
				b1ui.repaint();
			}
		});

	}

}
class topmanagerb1OperationJpanel extends JPanel{
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JButton returnButton;
	public topmanagerb1OperationJpanel(topmanagerJpanel topmanagerJpanel,topmanagerui topmanagerui,b1topmanagerui b1topmanagerui) {
		// TODO Auto-generated constructor stub
		init();
		topmanagerJpanel.add(this);
		registListener(topmanagerui, b1topmanagerui);
	}
	private void init(){
		this.setLayout(null);

		Font font=new Font("幼圆",Font.BOLD,50);
		
		JLabel welcome = new JLabel("请选择员工种类");
		welcome.setFont(font);
		welcome.setForeground(Color.WHITE);
		welcome.setBounds(200, 200, 400, 100);
		this.add(welcome);
		
		this.setBounds(260, 60, 730,650);
		this.setOpaque(false);
		ImageIcon returnIcon=new ImageIcon("picture/返回.png");
		returnButton=new JButton(returnIcon);
		returnButton.setBounds(662, 575, 48,48);
		returnButton.setContentAreaFilled(false);
		this.setOpaque(false);
		this.setLayout(null);
		this.add(returnButton);
	}
	private void registListener(final topmanagerui tmui,final b1topmanagerui b1tmui){
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tmui.setVisible(true);
				b1tmui.dispose();
				
			}
		});
	}
	public void paintComponent(Graphics g)  
	{  
	    super.paintComponent(g);    
	    g.drawImage(frameIcon.getImage(),-7,-12,null);
     }
}