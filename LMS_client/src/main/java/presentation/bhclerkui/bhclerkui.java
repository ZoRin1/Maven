package presentation.bhclerkui;

import java.awt.Color;
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

public class bhclerkui extends JFrame{
	static Point origin = new Point();
	private String[] args;
	JButton outjButton;
	JButton loaddocumentbButton;
	JButton cashdocumentbButton;
	JButton acceptdocumentbButton;
	JButton carinformationbButton;
	JButton driverinformationbButton;
	JButton documentreplyButton;
	private JButton tuichuButton;
	private JButton zuixiaohuaButton;
	bhclerkOperationJpanel operationJpanel;
	private bhclerkJpanel bhclerkJpanel;
	
	//设置两个暂时的账号和状态
		private String account;
		private String state;
		
	public bhclerkui(String s,String[] args,String account,String state) {
		super(s);
		this.account=account;
		this.state=state;
		this.args=args;
		init();
		registListener(this,bhclerkJpanel);
	}
	private void init(){
		ImageIcon outIcon=new ImageIcon("picture/退出登录.png");
		ImageIcon driverinformationIcon=new ImageIcon("picture/司机信息管理.png");
		ImageIcon carinformationIcon=new ImageIcon("picture/车辆信息管理.png");
		ImageIcon acceptdocumentIcon=new ImageIcon("picture/接收与派件.png");
		ImageIcon cashdocumentIcon=new ImageIcon("picture/收款单创建.png");
		ImageIcon loaddocumentIcon=new ImageIcon("picture/装车单创建.png");
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
		outjButton=new JButton(outIcon);
		outjButton.setBounds(30, 650, 48,48);
		outjButton.setContentAreaFilled(false);
		loaddocumentbButton=new JButton(loaddocumentIcon);
		loaddocumentbButton.setContentAreaFilled(false);
		cashdocumentbButton=new JButton(cashdocumentIcon);
		cashdocumentbButton.setContentAreaFilled(false);
		acceptdocumentbButton=new JButton(acceptdocumentIcon);
		acceptdocumentbButton.setContentAreaFilled(false);
		carinformationbButton=new JButton(carinformationIcon);
		carinformationbButton.setContentAreaFilled(false);
		driverinformationbButton=new JButton(driverinformationIcon);
		driverinformationbButton.setContentAreaFilled(false);
		documentreplyButton=new JButton(documentreplyIcon);
		documentreplyButton.setContentAreaFilled(false);
		bhclerkJpanel=new bhclerkJpanel();
		operationJpanel=new bhclerkOperationJpanel(bhclerkJpanel);


		loaddocumentbButton.setBounds(30, 80,200, 50);
		cashdocumentbButton.setBounds(30,180,200, 50);
		acceptdocumentbButton.setBounds(30, 280, 200, 50);
		carinformationbButton.setBounds(30, 380, 200, 50);
		driverinformationbButton.setBounds(30, 480, 200, 50);
		documentreplyButton.setBounds(30,580 ,200, 50);
		bhclerkJpanel.add(outjButton);
		bhclerkJpanel.add(documentreplyButton);
		bhclerkJpanel.add(loaddocumentbButton);
		bhclerkJpanel.add(cashdocumentbButton);
		bhclerkJpanel.add(acceptdocumentbButton);
		bhclerkJpanel.add(carinformationbButton);
		bhclerkJpanel.add(driverinformationbButton);
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
	private void registListener(final bhclerkui bhclerkui,final bhclerkJpanel bhclerkJpanel){
		bhclerkui.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				// 当鼠标按下的时候获得窗口当前的位置
				origin.x = e.getX();
				origin.y = e.getY();
			}
		});
		bhclerkui.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				// 当鼠标拖动时获取窗口当前位置
				Point p = bhclerkui.getLocation();
				// 设置窗口的位置
				// 窗口当前的位置 + 鼠标当前在窗口的位置 - 鼠标按下的时候在窗口的位置
				bhclerkui.setLocation(p.x + e.getX() - origin.x, p.y + e.getY()- origin.y);
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
				 bhclerkui.setExtendedState(JFrame.ICONIFIED);
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
				bhclerkui.dispose();
			}
		});
		documentreplyButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new documentreplyui("营业厅业务员——单据反馈", bhclerkui,account);
				bhclerkui.setVisible(false);
			}
		});
		loaddocumentbButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				bhclerkJpanel.remove(operationJpanel);
				bhclerkui.carinformationbButton.setEnabled(false);
				bhclerkui.cashdocumentbButton.setEnabled(false);
				bhclerkui.documentreplyButton.setEnabled(false);
				bhclerkui.driverinformationbButton.setEnabled(false);
				bhclerkui.loaddocumentbButton.setEnabled(false);
				bhclerkui.acceptdocumentbButton.setEnabled(false);
				new LoadingJpanel(bhclerkui,bhclerkJpanel,account,state);
				bhclerkJpanel.repaint();
			}
		});
		acceptdocumentbButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				bhclerkJpanel.remove(operationJpanel);
				bhclerkui.carinformationbButton.setEnabled(false);
				bhclerkui.cashdocumentbButton.setEnabled(false);
				bhclerkui.documentreplyButton.setEnabled(false);
				bhclerkui.driverinformationbButton.setEnabled(false);
				bhclerkui.loaddocumentbButton.setEnabled(false);
				bhclerkui.acceptdocumentbButton.setEnabled(false);
				new AcceptDocumentJpanel(bhclerkui,bhclerkJpanel,account,state);
				bhclerkJpanel.repaint();
			}
		});
		cashdocumentbButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				bhclerkJpanel.remove(operationJpanel);
				bhclerkui.carinformationbButton.setEnabled(false);
				bhclerkui.cashdocumentbButton.setEnabled(false);
				bhclerkui.documentreplyButton.setEnabled(false);
				bhclerkui.driverinformationbButton.setEnabled(false);
				bhclerkui.loaddocumentbButton.setEnabled(false);
				bhclerkui.acceptdocumentbButton.setEnabled(false);
				new ReceiptJPanel(bhclerkui,bhclerkJpanel,account,state);
				bhclerkJpanel.repaint();
			}
		});
		carinformationbButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				bhclerkJpanel.remove(operationJpanel);
				bhclerkui.carinformationbButton.setEnabled(false);
				bhclerkui.cashdocumentbButton.setEnabled(false);
				bhclerkui.documentreplyButton.setEnabled(false);
				bhclerkui.driverinformationbButton.setEnabled(false);
				bhclerkui.loaddocumentbButton.setEnabled(false);
				bhclerkui.acceptdocumentbButton.setEnabled(false);
				new CarInfoJpanel(bhclerkui,bhclerkJpanel,state);
				bhclerkJpanel.repaint();
			}
		});
		driverinformationbButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				bhclerkJpanel.remove(operationJpanel);
				bhclerkui.carinformationbButton.setEnabled(false);
				bhclerkui.cashdocumentbButton.setEnabled(false);
				bhclerkui.documentreplyButton.setEnabled(false);
				bhclerkui.driverinformationbButton.setEnabled(false);
				bhclerkui.loaddocumentbButton.setEnabled(false);
				bhclerkui.acceptdocumentbButton.setEnabled(false);
				new DriverInfoJpanel(bhclerkui,bhclerkJpanel,state);
				bhclerkJpanel.repaint();
			}
		});
}
}


