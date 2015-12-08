package presentation.financialstaffui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import po.documentsPO.ReceiptPO;

public class b4Jpanel2 extends JPanel{
	
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JButton returnButton;
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	private JLabel j1,j2;
	private JTextField t1;
	private JButton b1,b2;
	private b4Jpanel2JTable b4Jpanel2JTable;
	
	private ArrayList<ReceiptPO> receiptList;
	public b4Jpanel2(financialstaffui financialstaffui,financialstaffJpanel financialstaffJpanel,ArrayList<ReceiptPO> receiptList) {
		// TODO Auto-generated constructor stub
		this.receiptList = receiptList;
		init();
		financialstaffJpanel.add(this);
		registListener(financialstaffui,financialstaffJpanel,this);
	}
	private void init(){
		Font font=new Font("幼圆",Font.BOLD,20);
		ImageIcon i1 = new ImageIcon("picture/财务图片/收款单列表信息.png");
		j1 = new JLabel(i1);
		j1.setBounds(0, 0, 723, 545);
		
		double AllEarn = 0;
		for(int i = 0 ; i < receiptList.size();i++){
			AllEarn += receiptList.get(i).getFund();
		}
		j2 = new JLabel(String.valueOf(AllEarn));
		j2.setFont(new Font("幼圆",Font.BOLD,40));
		j2.setBounds(443, 465, 260, 46);
		
		t1 = new JTextField();
		t1.setBounds(502, 5, 200, 27);
		t1.setBorder(BorderFactory.createEmptyBorder());
		b1 = new JButton();
		b1.setBounds(483,9, 16, 19);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		b2 = new JButton();
		b2.setBounds(0,450, 65, 69);
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);
		
		b4Jpanel2JTable = new b4Jpanel2JTable(this,receiptList);

		returnButton=new JButton(returnIcon);
		returnButton.setBounds(662, 575,48,48);
		returnButton.setContentAreaFilled(false);

	 	this.setBounds(260, 60, 730,650);

	 	this.add(j1);
	 	j1.add(j2);
	 	j1.add(t1);
	 	j1.add(b1);
	 	j1.add(b2);
	 	j1.add(b4Jpanel2JTable.getScrollPane());
	 	this.add(returnButton);

	 	this.setLayout(null);
	 	this.setOpaque(false);
	}
	private void registListener(final financialstaffui financialstaffui,final financialstaffJpanel financialstaffJpanel,final b4Jpanel2 b4Jpanel2){
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				financialstaffJpanel.remove(b4Jpanel2);
				financialstaffJpanel.add(financialstaffui.operationJpanel);
//				b1financialstaffui.b1.setEnabled(true);
//				b1financialstaffui.b2.setEnabled(true);
				financialstaffui.b1.setEnabled(true);
				financialstaffui.b2.setEnabled(true);
				financialstaffui.b3.setEnabled(true);
				financialstaffui.b4.setEnabled(true);
				financialstaffui.b5.setEnabled(true);
				financialstaffJpanel.repaint();
			}
		});
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存
				System.out.println("搜索");
				//这个搜索是没有必要的！！！！！
			}
		});
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
//				double AllEarn = 0;
//				for(int i = 0 ; i < receiptList.size();i++){
//					AllEarn += receiptList.get(i).getFund();
//				}
//				j2 = new JLabel(String.valueOf(AllEarn));
//				j2.setFont(new Font("幼圆",Font.BOLD,40));
//				j2.setBounds(443, 470, 260, 46);
//				b4Jpanel2.add(j2);
//				System.out.println("合计="+AllEarn);
			}
		});
	}
	public void paintComponent(Graphics g)  
{  
		super.paintComponent(g);    
		g.drawImage(frameIcon.getImage(),-7,-12,null);
 }
}
