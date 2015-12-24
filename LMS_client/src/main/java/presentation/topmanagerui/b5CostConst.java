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
import presentation.adminui.NumberFieldListener;

public class b5CostConst extends JPanel {
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JLabel daBiaoTi,qiChe,huoChe,feiJi,qiCheDanwei,huoCheDanWei,feiJiDanWei;
	private JTextField qiCheF,huoCheF,feiJiF;
	private JButton yesButton,returnButton;
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	private ImageIcon yesIcon=new ImageIcon("picture/确定.png");
	
	public b5CostConst(b5topmanagerui b5ui,topmanagerJpanel tjpl){
		try {
			init();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new InternetDialog(b5ui);
		}
		tjpl.add(this);
		registListener(b5ui, tjpl, this);
	}
	
	private void init() throws RemoteException {
		TransportationController transportationController = new TransportationController();
		
		Font big = new Font("幼圆", Font.BOLD, 35);
		Font small = new Font("幼圆", Font.BOLD, 25);
		
		daBiaoTi = new JLabel("请输入新的成本常量");
		daBiaoTi.setForeground(Color.WHITE);
		daBiaoTi.setFont(big);
		daBiaoTi.setBounds(50, 112, 550, 45);
		this.add(daBiaoTi);
		
		qiChe = new JLabel("*汽车：");
		qiChe.setForeground(Color.WHITE);
		qiChe.setFont(small);
		qiChe.setBounds(130, 240, 120, 43);
		this.add(qiChe);
		
		qiCheF = new JTextField(String.valueOf(transportationController.getCost(1)));
		qiCheF.setFont(small);
		qiCheF.setBounds(240, 240, 150, 43);
		qiCheF.addKeyListener(new KeyListenerOfDouble());
		this.add(qiCheF);
		
		qiCheDanwei = new JLabel("元/(千克*100公里)");
		qiCheDanwei.setForeground(Color.WHITE);
		qiCheDanwei.setFont(small);
		qiCheDanwei.setBounds(410, 240, 230, 43);
		this.add(qiCheDanwei);
		
		huoChe = new JLabel("*火车：");
		huoChe.setForeground(Color.WHITE);
		huoChe.setFont(small);
		huoChe.setBounds(130, 310, 120, 43);
		this.add(huoChe);
		
		huoCheF = new JTextField(String.valueOf(transportationController.getCost(2)));
		huoCheF.setFont(small);
		huoCheF.setBounds(240, 310, 150, 43);
		huoCheF.addKeyListener(new KeyListenerOfDouble());
		this.add(huoCheF);
		
		huoCheDanWei = new JLabel("元/(千克*100公里)");
		huoCheDanWei.setForeground(Color.WHITE);
		huoCheDanWei.setFont(small);
		huoCheDanWei.setBounds(410, 310, 230, 43);
		this.add(huoCheDanWei);
		
		feiJi = new JLabel("*飞机：");
		feiJi.setForeground(Color.WHITE);
		feiJi.setFont(small);
		feiJi.setBounds(130, 380, 120, 43);
		this.add(feiJi);
		
		feiJiF = new JTextField(String.valueOf(transportationController.getCost(3)));
		feiJiF.setFont(small);
		feiJiF.setBounds(240, 380, 150, 43);
		feiJiF.addKeyListener(new KeyListenerOfDouble());
		this.add(feiJiF);
		
		feiJiDanWei = new JLabel("元/(千克*100公里)");
		feiJiDanWei.setForeground(Color.WHITE);
		feiJiDanWei.setFont(small);
		feiJiDanWei.setBounds(410, 380, 230, 43);
		this.add(feiJiDanWei);
		
		yesButton=new JButton(yesIcon);
		yesButton.setBounds(602, 575,48,48);
		yesButton.setContentAreaFilled(false);	 	 	
	 	this.add(yesButton);
		
		returnButton=new JButton(returnIcon);		
		returnButton.setBounds(662, 575,48,48);
		returnButton.setContentAreaFilled(false);
		this.add(returnButton);
		
		this.setBounds(260, 60, 730,650);	 
		this.setOpaque(false);
		this.setLayout(null);
		
		
	}
		
	private void registListener(final b5topmanagerui b5ui,final topmanagerJpanel tjpl,final b5CostConst costConst) {
		
		returnButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tjpl.remove(costConst);
				tjpl.add(b5ui.operationJpanel);
				b5ui.b1.setEnabled(true);
				b5ui.b2.setEnabled(true);

				tjpl.repaint();

			}
		});

		yesButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				boolean b1 = DataCheck.isDouble(qiCheF.getText());
				boolean b2 = DataCheck.isDouble(huoCheF.getText());
				boolean b3 = DataCheck.isDouble(feiJiF.getText());
				if (!b1) {
					new DisplayDialog(b5ui, "请输入正确的汽车成本常量数值，形如1.20");
//					JOptionPane.showMessageDialog(b5ui, "请输入正确的汽车成本常量数值，形如1.20");
				}
				if (!b2) {
					new DisplayDialog(b5ui, "请输入正确的火车成本常量数值，形如1.20");
//					JOptionPane.showMessageDialog(b5ui, "请输入正确的火车成本常量数值，形如1.20");
				}
				if (!b3) {
					new DisplayDialog(b5ui, "请输入正确的飞机成本常量数值，形如1.20");
//					JOptionPane.showMessageDialog(b5ui, "请输入正确的飞机成本常量数值，形如1.20");
				}
				
				if (b1 && b2 && b3) {
					TransportationController transportationController = null;
					try {
						transportationController = new TransportationController();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						new InternetDialog(b5ui);
					}
								
					boolean r1 = transportationController.changeCost(1, Double.parseDouble(qiCheF.getText()));
					boolean r2 = transportationController.changeCost(2, Double.parseDouble(huoCheF.getText()));
					boolean r3 = transportationController.changeCost(3, Double.parseDouble(feiJiF.getText()));
					
					if (r1 && r2 && r3) {
						new DisplayDialog(b5ui, "修改成功！");
//						JOptionPane.showMessageDialog(b5ui, "修改成功！");
						tjpl.remove(costConst);
						tjpl.add(b5ui.operationJpanel);						
						b5ui.b1.setEnabled(true);
						b5ui.b2.setEnabled(true);
						tjpl.repaint();
					}else {
						new DisplayDialog(b5ui, "修改失败，请重试");
//						JOptionPane.showMessageDialog(b5ui, "修改失败，请重试");
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
