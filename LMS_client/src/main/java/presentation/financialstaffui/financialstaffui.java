package presentation.financialstaffui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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

import org.omg.CORBA.PRIVATE_MEMBER;

import presentation.mainui.mainui;

public class financialstaffui extends JFrame{
	private String[] args;
	private JButton outjButton;
	financialstaffJpanel financialstaffJpanel;
	financialstaffOperationJpanel operationJpanel;
	JButton b1,b2,b3,b4,b5;
	private JButton tuichuButton;
	private JButton zuixiaohuaButton;
	
	private String account;
	private String state;
	public financialstaffui(String s,String [] args,String account,String state) {
		// TODO Auto-generated constructor stub
		super(s);
		this.account=account;
		this.state=state;
		this.args=args;
		init();
		registListener(this,financialstaffJpanel);
	}
	private void init(){
		financialstaffJpanel=new financialstaffJpanel();
		operationJpanel=new financialstaffOperationJpanel(financialstaffJpanel);
		
		ImageIcon b1imaIcon=new ImageIcon("picture/统计报表.png");
		ImageIcon b2imaIcon=new ImageIcon("picture/账户管理.png");
		ImageIcon b3imaIcon=new ImageIcon("picture/成本管理.png");
		ImageIcon b4imaIcon=new ImageIcon("picture/结算管理.png");
		ImageIcon b5imaIcon=new ImageIcon("picture/期初建账.png");
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
		b1=new JButton(b1imaIcon); 
		b2=new JButton(b2imaIcon);
		b3=new JButton(b3imaIcon);
		b4=new JButton(b4imaIcon);
		b5=new JButton(b5imaIcon);

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
		 financialstaffJpanel.add(outjButton);
		financialstaffJpanel.add(b1);
		financialstaffJpanel.add(b2);
		financialstaffJpanel.add(b3);
		financialstaffJpanel.add(b4);
		financialstaffJpanel.add(b5);
		financialstaffJpanel.add(tuichuButton);
		financialstaffJpanel.add(zuixiaohuaButton);
		financialstaffJpanel.setLayout(null);
	
		this.add(financialstaffJpanel);
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
	private void registListener(final financialstaffui financialstaffui,final financialstaffJpanel financialstaffJpanel){
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
				financialstaffui.setExtendedState(JFrame.ICONIFIED);
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
				financialstaffui.dispose();
			}
		});
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new b1financialstaffui("财务人员——统计报表", financialstaffui);
				financialstaffui.setVisible(false);
				
			}
		});
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new b2financialstaffui("财务人员——账户管理", financialstaffui);
				financialstaffui.setVisible(false);
				
			}
		});
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new b3financialstaffui("财务人员——成本管理", financialstaffui,account);
				financialstaffui.setVisible(false);
			}
		});
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new b4Jpanel1(financialstaffui, financialstaffJpanel);
				financialstaffJpanel.remove(operationJpanel);
				b1.setEnabled(false);
				b2.setEnabled(false);
				b3.setEnabled(false);
				b4.setEnabled(false);
				b5.setEnabled(false);
				financialstaffJpanel.repaint();
			}
		});
		b5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new b5financialstaffui("财务人员——期初建账", financialstaffui);
				financialstaffui.setVisible(false);
			}
		});
	}
}

