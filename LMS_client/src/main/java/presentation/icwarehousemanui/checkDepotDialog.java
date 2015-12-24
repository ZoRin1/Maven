package presentation.icwarehousemanui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

import businesslogic.storagebl.CheckModel.CheckController;
import presentation.financialstaffui.DateChooser;
import vo.storageVO.SimpleInDepotInfVO;

public class checkDepotDialog {
	JDialog checkDepot;
	JButton b1,b2;
	JTextField startTime,endTime;
	JComboBox jcombobox1,jcombobox2,jcombobox3,jcombobox4,jcombobox5,jcombobox6;
	JLabel shi,fen,miao,shi1,fen1,miao1;
	String shi_1,fen_1,miao_1,shi_2,fen_2,miao_2;
	JLabel start,end;
	JPanel panel;
	ImageIcon checkIcon,b1Icon,b2Icon;
	icwarehousemanui icUI;
	checkDepotPanel panel1;
	icwarehousemanJpanel icwarehousemanJpanel;
	icwarehousemanOperationJpanel operationJpanel;
	CheckController checkController;
	private String account;
	public checkDepotDialog(final icwarehousemanui ui,final String account){
		this.account=account;
		final String labels[] = {"00","01","02","03","04","05","06","07","08","09",
				"10","11","12","13","14","15","16","17","18","19","20","21","22",
				"23"};
		final String labels1[] = {"00","01","02","03","04","05","06","07","08","09",
				"10","11","12","13","14","15","16","17","18","19","20","21","22",
				"23","24","25","26","27","28","29","30","31","32","33","34","35",
				"36","37","38","39","40","41","42","43","44","45","46","47","48","49","50",
				"51","52","53","54","55","56","57","58","59"};
		DateChooser date1 =  DateChooser.getInstance("yyyy-MM-dd");
		DateChooser date2 =  DateChooser.getInstance("yyyy-MM-dd");
//		timeChooser date = new timeChooser(this);
		
		icUI = ui;
		icwarehousemanJpanel = ui.getIcwarehousemanJpanel();
		operationJpanel = ui.getOperationJpanel();
	    checkIcon = new ImageIcon("picture/库存查询框.png");
	    b1Icon = new ImageIcon("picture/对话框确定.png");
	    b2Icon = new ImageIcon("picture/取消.png");
		checkDepot = new JDialog(ui,"时间段输入",true);
		b1 = new JButton(b1Icon);
		b2 = new JButton(b2Icon);
		start = new JLabel();
		start.setText("起始时间:");
		start.setForeground(Color.black);
		start.setFont(new Font("幼圆",Font.BOLD,20));
		end = new JLabel();
		end.setText("终止时间:");
		end.setForeground(Color.black);
		end.setFont(new Font("幼圆",Font.BOLD,20));
		//JCombobox
		jcombobox1 = new JComboBox(labels);
		jcombobox1.setEditable(false);
		jcombobox1.setBounds(150, 60, 60, 24);
		shi = new JLabel("时");
		shi.setFont(new Font("幼圆",Font.BOLD,16));
		shi.setBounds(215, 60, 30, 24);
		 
	    jcombobox1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent itemEvent) {
				// TODO 自动生成的方法存根
		          int state = itemEvent.getStateChange();   
		          if(state == itemEvent.SELECTED){
			          shi_1 = itemEvent.getItem().toString();
		          }
			}
		});
	      
		jcombobox2 = new JComboBox(labels1);
		jcombobox2.setEditable(false);
		jcombobox2.setBounds(240, 60, 60, 24);
		fen = new JLabel("分");
		fen.setFont(new Font("幼圆",Font.BOLD,16));
		fen.setBounds(305, 60, 30, 24);
	    jcombobox2.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent itemEvent) {
				// TODO 自动生成的方法存根
		          int state = itemEvent.getStateChange();   
		          if(state == itemEvent.SELECTED){
			          fen_1 = itemEvent.getItem().toString();
		          }
			}
		});
		
		jcombobox3 = new JComboBox(labels1);
		jcombobox3.setEditable(false);
		jcombobox3.setBounds(325, 60, 60, 24);
		miao = new JLabel("秒");
		miao.setFont(new Font("幼圆",Font.BOLD,16));
		miao.setBounds(390, 60, 30, 24);
	    jcombobox3.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent itemEvent) {
				// TODO 自动生成的方法存根
		          int state = itemEvent.getStateChange();  
		          if(state == itemEvent.SELECTED){
				      miao_1 = itemEvent.getItem().toString();
		          }
			}
		});
		
		jcombobox4 = new JComboBox(labels);
		jcombobox4.setEditable(false);
		jcombobox4.setBounds(150,130, 60, 24);
		shi1 = new JLabel("时");
		shi1.setFont(new Font("幼圆",Font.BOLD,16));
		shi1.setBounds(215, 130, 30, 24);
	    jcombobox4.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent itemEvent) {
				// TODO 自动生成的方法存根
		          int state = itemEvent.getStateChange();   
		          if(state == itemEvent.SELECTED){
			          shi_2 = itemEvent.getItem().toString();
		          }
			}
		});
		
		jcombobox5 = new JComboBox(labels1);
		jcombobox5.setEditable(false);
		jcombobox5.setBounds(240, 130, 60, 24);
		fen1 = new JLabel("分");
		fen1.setFont(new Font("幼圆",Font.BOLD,16));
		fen1.setBounds(305, 130, 30, 24);
	    jcombobox5.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent itemEvent) {
				// TODO 自动生成的方法存根
		          int state = itemEvent.getStateChange();   
		          if(state == itemEvent.SELECTED){
			          fen_2 = itemEvent.getItem().toString();
		          }
			}
		});
		
		jcombobox6 = new JComboBox(labels1);
		jcombobox6.setEditable(false);
		jcombobox6.setBounds(325, 130, 60, 24);
		miao1 = new JLabel("秒");
		miao1.setFont(new Font("幼圆",Font.BOLD,16));
		miao1.setBounds(390, 130, 30, 24);
	    jcombobox6.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent itemEvent) {
				// TODO 自动生成的方法存根
		          int state = itemEvent.getStateChange();   
		          if(state == itemEvent.SELECTED){
			          if(itemEvent.getItem()==null){
			        	  miao_2 = "00";
			          }else{
				          miao_2 = itemEvent.getItem().toString();
			          }
		          }
			}
		});
		//JCombobox
	    
//		startTime = new JTextField();
//		endTime = new JTextField();
//		startTime.setForeground(Color.black);
//		endTime.setForeground(Color.black);
//		startTime.setFont(new Font("幼圆",Font.BOLD,20));
//		endTime.setFont(new Font("幼圆",Font.BOLD,20));
//		date.register(startTime);
//		date1.register(startTime);
//		date2.register(endTime);
//		startTime.setBounds(150, 60, 200, 24);
//		endTime.setBounds(150, 130, 200, 24);
	    
		checkDepot.setBounds(830, 400, 450, 249);
		//checkDepot.setLocationRelativeTo(null);
		
		panel = new tempJpanel();
		panel.setLayout(null);
		panel.add(b1);
		panel.add(b2);
		panel.add(start);
		panel.add(end);
		
//		panel.add(startTime);
//		panel.add(endTime);
		
		panel.add(jcombobox1);
		panel.add(shi);
		panel.add(jcombobox2);
		panel.add(fen);
		panel.add(jcombobox3);
		panel.add(miao);
		panel.add(jcombobox4);
		panel.add(shi1);
		panel.add(jcombobox5);
		panel.add(fen1);
		panel.add(jcombobox6);
		panel.add(miao1);
		
		b1.setBounds(250, 180, 72, 24);
		b2.setBounds(350, 180, 72, 24);
		start.setBounds(40, 50, 180, 40);
		end.setBounds(40, 120, 180, 40);
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				//时间段前后的判断
				//时间段前后的判断
				if(shi_1==null){
					shi_1="00";
				}
				if(shi_2==null){
					shi_2="00";
				}
				if(miao_1==null){
					miao_1 = "00";
				}
				if(miao_2==null){
					miao_2 = "00";
				}
				if(fen_1==null){
					fen_1 = "00";
				}
				if(fen_2==null){
					fen_2 = "00";
				}
				if(Integer.parseInt(shi_1)>Integer.parseInt(shi_2)){
					try {
						throw new timeException();
					} catch (timeException e) {
						// TODO 自动生成的 catch 块
						//这个地方要弹出对话框
						System.out.println("时间段输入错误");
					}
				}else if(Integer.parseInt(shi_1)==Integer.parseInt(shi_2)){
					if(Integer.parseInt(fen_1)>Integer.parseInt(fen_2)||(Integer.parseInt(fen_1)==Integer.parseInt(fen_2)&&Integer.parseInt(miao_1)>=Integer.parseInt(miao_2))){
						try {
							throw new timeException();
						} catch (timeException e) {
							// TODO 自动生成的 catch 块
							//这个地方要弹出对话框
							System.out.println("时间段输入错误");
						}
					}
					else {
						String now ="";
						Date date = new Date();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
						now = sdf.format(date);
						
						String starttime = now+" "+shi_1+":"+fen_1+":"+miao_1;
						String endtime = now+" "+shi_2+":"+fen_2+":"+miao_2;
						
						
						//这中间要加对单据的调用
						checkController = new CheckController();
						ArrayList<SimpleInDepotInfVO> simpleInf=null;
						try {
							simpleInf = checkController.conCheck(account, starttime, endtime);
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							new InternetDialog(ui);
						}
						//这中间要加对单据的调用
						
						checkDepot.dispose();
						icwarehousemanJpanel.remove(operationJpanel);
						new checkDepotPanel(ui,icwarehousemanJpanel,simpleInf);//checkDepotPanel的构造函数还要加上单据的参数才能显示
						icwarehousemanJpanel.repaint();
					}
				}
				else {
					String now ="";
					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
					now = sdf.format(date);
					
					String starttime = now+" "+shi_1+":"+fen_1+":"+miao_1;
					String endtime = now+" "+shi_2+":"+fen_2+":"+miao_2;
					
					
					//这中间要加对单据的调用
					checkController = new CheckController();
					ArrayList<SimpleInDepotInfVO> simpleInf=null;
					try {
						simpleInf = checkController.conCheck(account, starttime, endtime);
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						new InternetDialog(ui);
					}
					//这中间要加对单据的调用
					
					checkDepot.dispose();
					icwarehousemanJpanel.remove(operationJpanel);
					new checkDepotPanel(ui,icwarehousemanJpanel,simpleInf);//checkDepotPanel的构造函数还要加上单据的参数才能显示
					icwarehousemanJpanel.repaint();
				}
				
			}
		});
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				checkDepot.dispose();
				ui.getB1().setEnabled(true);
				ui.getB2().setEnabled(true);
				ui.getB3().setEnabled(true);
				ui.getB4().setEnabled(true);
				ui.getB5().setEnabled(true);
				ui.getB6().setEnabled(true);
			}
		});
//		startTime.addKeyListener(new KeyAdapter() {
//			public void keyTyped(KeyEvent e) {
//				int keyChar = e.getKeyChar();
//				if(keyChar>=KeyEvent.VK_0&&keyChar<=KeyEvent.VK_9){
//					
//				}else if(keyChar==KeyEvent.VK_SHIFT){
//					if(keyChar==KeyEvent.VK_SEMICOLON){
//						
//					}else{
//						e.consume();
//					}
//				}else{
//					e.consume();
//				}
//			}
//		});
//		endTime.addKeyListener(new KeyAdapter() {
//			public void keyTyped(KeyEvent e) {
//				int keyChar = e.getKeyChar();
//				if(keyChar>=KeyEvent.VK_0&&keyChar<=KeyEvent.VK_9){
//					
//				}else if(keyChar==KeyEvent.VK_SHIFT){
//					if(keyChar==KeyEvent.VK_SEMICOLON){
//						
//					}else{
//						e.consume();
//					}
//				}else{
//					e.consume();
//				}
//			}
//		});
		checkDepot.add(panel);
		checkDepot.setUndecorated(true);
		checkDepot.setVisible(true);
	}
	
	private boolean checkFormat(String test){
		return false;
	}
	
	private class timeException extends Exception{
		public timeException(){
			
		}
		public timeException(String message){
			super(message);
		}
	}
	
	private class tempJpanel extends JPanel{
		public tempJpanel(){
			
		}
		
		public void paintComponent(Graphics g){
		    super.paintComponent(g);  
			g.drawImage(checkIcon.getImage(),0,0,null);
		}
	}
}