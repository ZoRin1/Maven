package presentation.topmanagerui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businesslogic.transportationbl.TransportationController;
<<<<<<< HEAD

=======
>>>>>>> origin/master

public class b1Salary extends JPanel {
	private JLabel tiShi,anYue,yuanMeiYue,jiCi,yuanMeiCi,tiCheng,baiFenHao;
	private JTextField anYueF,jiCiF,tiChengF;
	
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JButton returnButton;
	private JButton yesButton;
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	private ImageIcon yesIcon=new ImageIcon("picture/确定.png");
	
	public b1Salary(topmanagerui tui,topmanagerJpanel tjpl,b1topmanagerui b1ui,int employee) {
		init(employee,b1ui);
		tjpl.add(this);
		registListener(tjpl, b1ui, this,employee);
	}
	
	private void init(int employee,b1topmanagerui b1ui) {//employee 为员工种类
	
		TransportationController transportationController=null;

		try {
			transportationController = new TransportationController();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new InternetDialog(b1ui);
		}
		double[] salary = transportationController.getSalary(employee);
		
		Font big = new Font("幼圆", Font.BOLD, 40);
		Font small = new Font("幼圆", Font.BOLD, 32);
		
		tiShi = new JLabel("请输入工资策略数值");
		tiShi.setForeground(Color.WHITE);
		tiShi.setFont(big);
		tiShi.setBounds(50, 112, 550, 45);
		this.add(tiShi);
		
		anYue = new JLabel("*按月：");
		anYue.setForeground(Color.WHITE);
		anYue.setFont(small);
		anYue.setBounds(170, 240, 120, 43);
		this.add(anYue);
		
		anYueF = new JTextField(String.valueOf(salary[0]));
		anYueF.setFont(small);
		anYueF.setBounds(280, 240, 150, 43);
		anYueF.addKeyListener(new KeyListenerOfDouble());
		this.add(anYueF);
		
		yuanMeiYue = new JLabel("元/月");
		yuanMeiYue.setForeground(Color.WHITE);
		yuanMeiYue.setFont(small);
		yuanMeiYue.setBounds(450, 240, 93, 43);
		this.add(yuanMeiYue);
		
		jiCi = new JLabel("*计次：");
		jiCi.setForeground(Color.WHITE);
		jiCi.setFont(small);
		jiCi.setBounds(170, 310, 120, 43);
		this.add(jiCi);
		
		jiCiF = new JTextField(String.valueOf(salary[1]));
		jiCiF.setFont(small);
		jiCiF.setBounds(280, 310, 150, 43);
		jiCiF.addKeyListener(new KeyListenerOfDouble());
		this.add(jiCiF);
		
		yuanMeiCi = new JLabel("元/次");
		yuanMeiCi.setForeground(Color.WHITE);
		yuanMeiCi.setFont(small);
		yuanMeiCi.setBounds(450, 310, 93, 43);
		this.add(yuanMeiCi);
		
		tiCheng = new JLabel("*提成：");
		tiCheng.setForeground(Color.WHITE);
		tiCheng.setFont(small);
		tiCheng.setBounds(170, 380, 120, 43);
		this.add(tiCheng);
		
		tiChengF = new JTextField(String.valueOf(salary[2]));
		tiChengF.setFont(small);
		tiChengF.setBounds(280, 380, 150, 43);
		tiChengF.addKeyListener(new KeyListenerOfDouble());
		this.add(tiChengF);
		
		baiFenHao = new JLabel("%");
		baiFenHao.setForeground(Color.WHITE);
		baiFenHao.setFont(small);
		baiFenHao.setBounds(450, 380, 93, 43);
		this.add(baiFenHao);
		
		yesButton=new JButton(yesIcon);
		yesButton.setBounds(602, 575,48,48);
		yesButton.setContentAreaFilled(false);	 	 	
	 	this.add(yesButton);
		
		returnButton=new JButton(returnIcon);		
		returnButton.setBounds(662, 575,48,48);
		returnButton.setContentAreaFilled(false);
		this.add(returnButton);
		
		
		
		this.setBounds(260, 60, 730,650);	 	
		
	 	this.setLayout(null);
		this.setOpaque(false);	
	 
	 	
		
	}
	
	

	
	private void registListener(final topmanagerJpanel tjpl,final b1topmanagerui b1ui,final b1Salary salary,final int employee) {
		
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				b1ui.setTitle("总经理--工资管理");
				tjpl.remove(salary);
				tjpl.add(b1ui.operationJpanel);
				b1ui.b1.setEnabled(true);
				b1ui.b2.setEnabled(true);
				b1ui.b3.setEnabled(true);
				b1ui.b4.setEnabled(true);
				b1ui.b5.setEnabled(true);
				b1ui.b6.setEnabled(true);
				
				tjpl.repaint();
				
			}
		});
		
		yesButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean bAnYue = DataCheck.isDouble(anYueF.getText());
				boolean bJiCi = DataCheck.isDouble(jiCiF.getText());
				boolean bTIiCheng = DataCheck.isDouble(tiChengF.getText());
				
				if (!bAnYue) {
					new DisplayDialog(b1ui, "请输入正确的按月工资策略数值");
//					JOptionPane.showMessageDialog(null, "请输入正确的按月工资策略数值");
				}
				if (!bJiCi) {
					new DisplayDialog(b1ui, "请输入正确的计次工资策略数值");
//					JOptionPane.showMessageDialog(null, "请输入正确的计次工资策略数值");
				}
				if (!bTIiCheng) {
					new DisplayDialog(b1ui, "请输入正确的提成工资策略数值");
//					JOptionPane.showMessageDialog(null, "请输入正确的提成工资策略数值");
				}
				if (bAnYue && bJiCi && bTIiCheng) {
					TransportationController t=null;
					try {
						t = new TransportationController();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						new InternetDialog(b1ui);
					}
					double[] salarys = new double[3];
					salarys[0] = Double.parseDouble(anYueF.getText());
					salarys[1] = Double.parseDouble(jiCiF.getText());
					salarys[2] = Double.parseDouble(tiChengF.getText());
					boolean result = t.changeSalary(employee, salarys);
					if (result) {
						new DisplayDialog(b1ui, "修改成功！");
//						JOptionPane.showMessageDialog(b1ui, "修改成功！");
						b1ui.setTitle("总经理--工资管理");
						tjpl.remove(salary);
						tjpl.add(b1ui.operationJpanel);												
						b1ui.b1.setEnabled(true);
						b1ui.b2.setEnabled(true);
						b1ui.b3.setEnabled(true);
						b1ui.b4.setEnabled(true);
						b1ui.b5.setEnabled(true);
						b1ui.b6.setEnabled(true);
						tjpl.repaint();
					}else {
						new DisplayDialog(b1ui, "修改失败，请重试！");
//						JOptionPane.showMessageDialog(b1ui, "修改失败，请重试！");
					}
					
					
				}
				
			}
		});
	}
	public void paintComponent(Graphics g)  
	{  
			super.paintComponent(g);    
			g.drawImage(frameIcon.getImage(),-7,-12,null);
	 }

}
