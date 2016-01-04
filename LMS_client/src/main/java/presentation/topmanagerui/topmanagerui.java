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

import presentation.mainui.mainui;

public class topmanagerui extends JFrame{
	static Point origin = new Point();
	private String[] args;
	private JButton outjButton;
	 private topmanagerJpanel topmanagerJpanel;
	topmanagerOperationJpanel operationJpanel;
	JButton b1,b2,b3,b4,b5;
	private JButton tuichuButton;
	private JButton zuixiaohuaButton;
	public topmanagerui(String s,String [] args) {
		// TODO Auto-generated constructor stub
		super(s);
		this.args=args;
		init();
		registListener(this);
	}
	private void init(){
		topmanagerJpanel=new topmanagerJpanel();
		operationJpanel=new topmanagerOperationJpanel(topmanagerJpanel);
		ImageIcon b1Icon=new ImageIcon("picture/工资管理.png");
		ImageIcon b2Icon=new ImageIcon("picture/机构管理.png");
		ImageIcon b3Icon=new ImageIcon("picture/审批单据.png");
		ImageIcon b4Icon=new ImageIcon("picture/统计分析.png");
		ImageIcon b5Icon=new ImageIcon("picture/常量修改.png");
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
		b1.setContentAreaFilled(false);
		b2.setContentAreaFilled(false);
		b3.setContentAreaFilled(false);
		b4.setContentAreaFilled(false);
		b5.setContentAreaFilled(false);
		b1.setBounds(30, 130,200, 50);
		b2.setBounds(30, 230,200, 50);
		b3.setBounds(30, 330,200, 50);
		b4.setBounds(30, 430,200, 50);
		b5.setBounds(30, 530,200, 50);

		ImageIcon outIcon=new ImageIcon("picture/退出登录.png");
		outjButton=new JButton(outIcon);
		outjButton.setBounds(30, 650,  48,48);
		outjButton.setContentAreaFilled(false);
		 topmanagerJpanel.add(outjButton);
		topmanagerJpanel.add(b1);
		topmanagerJpanel.add(b2);
		topmanagerJpanel.add(b3);
		topmanagerJpanel.add(b4);
		topmanagerJpanel.add(b5);
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
	private void registListener(final topmanagerui topmanagerui){
		topmanagerui.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				// 当鼠标按下的时候获得窗口当前的位置
				origin.x = e.getX();
				origin.y = e.getY();
			}
		});
		topmanagerui.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				// 当鼠标拖动时获取窗口当前位置
				Point p = topmanagerui.getLocation();
				// 设置窗口的位置
				// 窗口当前的位置 + 鼠标当前在窗口的位置 - 鼠标按下的时候在窗口的位置
				topmanagerui.setLocation(p.x + e.getX() - origin.x, p.y + e.getY()- origin.y);
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
				topmanagerui.setExtendedState(JFrame.ICONIFIED);
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
				topmanagerui.dispose();
				
			}
		});
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new b1topmanagerui("总经理——工资管理", topmanagerui);
				topmanagerui.setVisible(false);
			}
		});
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new b2topmanagerui("总经理——机构管理", topmanagerui);
				topmanagerui.setVisible(false);
			}
		});
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				topmanagerJpanel.remove(operationJpanel);
				topmanagerui.b1.setEnabled(false);
				topmanagerui.b2.setEnabled(false);
				topmanagerui.b3.setEnabled(false);
				topmanagerui.b4.setEnabled(false);
				topmanagerui.b5.setEnabled(false);
				new b3JPanel(topmanagerui, topmanagerJpanel);
				topmanagerJpanel.repaint();
			}
		});
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new b4topmanagerui("总经理——统计分析", topmanagerui);
				topmanagerui.setVisible(false);
				
			}
		});
		b5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new b5topmanagerui("总经理——修改常量", topmanagerui);
				topmanagerui.setVisible(false);
			
			}
		});
	}
}