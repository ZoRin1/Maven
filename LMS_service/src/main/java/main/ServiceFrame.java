package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ServiceFrame {
	
	private JFrame mainFrame;
	public JFrame getMainFrame() {
		return mainFrame;
	}

	private JPanel mainPanel;
	private JButton qidong,zhongzhi;
	private String result;
	public void setResult(String result) {
		this.result = result;
		q1 = new JLabel(result);
		q1.setBounds(250, 75, 100, 50);
		q1.setForeground(Color.white);
		mainPanel.add(q1);
		mainPanel.repaint();
	}

	public JButton getQidong() {
		return qidong;
	}

	public JButton getZhongzhi() {
		return zhongzhi;
	}

	private JLabel q1,q2;
	private ImageIcon frameIcon =new ImageIcon("对话框背景.png");
	
	public ServiceFrame(){
		init();
	}
	
	private void init(){
		mainFrame = new JFrame();
		mainPanel = new JPanel(){
			public void paintComponent(Graphics g)  
			{  
					super.paintComponent(g);    
					g.drawImage(frameIcon.getImage(),-7,-12,null);
			 }
		};
		mainPanel.setLayout(null);
		
		qidong = new JButton("启动");
		qidong.setBounds(50, 75, 100, 50);
		qidong.setForeground(Color.white);
//		qidong.setBorderPainted(false);
		qidong.setContentAreaFilled(false);
		
		zhongzhi = new JButton("终止");
		zhongzhi.setBounds(50, 175, 100, 50);
		zhongzhi.setForeground(Color.white);
//		zhongzhi.setBorderPainted(false);
		zhongzhi.setContentAreaFilled(false);
		
//		q1 = new JLabel();
		q2 = new JLabel();
		
		mainPanel.add(qidong);
		mainPanel.add(zhongzhi);
		
		mainFrame.setContentPane(mainPanel);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		mainFrame.setSize(450, 300);
		mainFrame.setBounds(400, 400, 450, 300);
		mainFrame.setVisible(true);
	}
}
