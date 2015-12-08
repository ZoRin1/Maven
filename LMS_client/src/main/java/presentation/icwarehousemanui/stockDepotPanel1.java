package presentation.icwarehousemanui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

import vo.storageVO.InDepotInfVO;
import businesslogic.storagebl.CheckModel.CheckController;
import businesslogic.storagebl.DriveModel.spaceBL;

public class stockDepotPanel1 extends JPanel{
	
	
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JButton returnButton,excelButton;
	private JLabel j1;
	private stockDepotJTable1 stockTable1;
	private JButton hangyun,qiyun;
//	private inDepotCheckJTable inDepotCheckJTable;
//	private JTable inDepotTable;
	private stockDepotPanel stock;
	private stockDepotPanel2 stock2;
	private JLabel inDepotCount,AllDepotCount;
	
	private String account;
	private String state;
	private CheckController checkController;
	private ArrayList<InDepotInfVO> InVOList;
	private ArrayList<InDepotInfVO> VOList;
	private spaceBL usedSpace;
	private int[] useSpace;
	public stockDepotPanel1(icwarehousemanui icwarehousemanui,icwarehousemanJpanel icwarehousemanJpanel,String account,String state){
		this.account = account;
		this.state = state;
		check();
		getDepotCount();
		init();
		icwarehousemanJpanel.add(this);
		registListener(icwarehousemanui,icwarehousemanJpanel,this);
	}
	
	
	private void  init(){
		ImageIcon returnIcon=new ImageIcon("picture/返回.png");
		ImageIcon kuangjia = new ImageIcon("picture/库存图片/铁运区.png");
		ImageIcon Excel = new ImageIcon("picture/小导出EXCEL.png");
		returnButton=new JButton(returnIcon);
		excelButton = new JButton(Excel);
		hangyun = new JButton();
		hangyun.setBounds(20, 15, 38, 15);
		hangyun.setContentAreaFilled(false);
		hangyun.setBorderPainted(false);
		qiyun = new JButton();
		qiyun.setBounds(134, 16, 38, 17);
		qiyun.setContentAreaFilled(false);
		qiyun.setBorderPainted(false);
		j1 = new JLabel(kuangjia);
		j1.setBounds(0, 0, 720, 570);
		
		
//		inDepotCount = new JLabel("103");
		inDepotCount = new JLabel(String.valueOf(VOList.size()));
		inDepotCount.setFont(new Font("幼圆", Font.BOLD, 20));
		inDepotCount.setBounds(572, 35, 80, 24);
		
//		AllDepotCount = new JLabel("6594");
		AllDepotCount = new JLabel(String.valueOf(useSpace[1]));
		AllDepotCount.setFont(new Font("幼圆", Font.BOLD, 20));
		AllDepotCount.setBounds(612, 542, 80, 24);
		
		
		stockTable1 = new stockDepotJTable1(this,VOList);
		
		returnButton.setBounds(662, 575,48,48);
		returnButton.setContentAreaFilled(false);
		excelButton.setBounds(581, 575, 47, 47);
		excelButton.setContentAreaFilled(false);
		
		this.add(j1);
		this.add(returnButton);
		this.add(excelButton);
		j1.add(stockTable1.getScrollPane());
		j1.add(qiyun);
		j1.add(hangyun);
		j1.add(inDepotCount);
		j1.add(AllDepotCount);
		this.setOpaque(false);
		this.setBounds(260, 60, 730,650);
		this.setLayout(null);
	}
	
	private void registListener(final icwarehousemanui ui,final icwarehousemanJpanel icwarehousemanJpanel,final stockDepotPanel1 stockDepotPanel1){
		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				icwarehousemanJpanel.remove(stockDepotPanel1);
				ui.getB1().setEnabled(true);
				ui.getB2().setEnabled(true);
				ui.getB3().setEnabled(true);
				ui.getB4().setEnabled(true);
				ui.getB5().setEnabled(true);
				ui.getB6().setEnabled(true);
				icwarehousemanJpanel.add(ui.getOperationJpanel());
				icwarehousemanJpanel.repaint();
			}
		});
		excelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				
			}
		});
		hangyun.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				System.out.println("hangyun");
				icwarehousemanJpanel.remove(stockDepotPanel1);
				stock = new stockDepotPanel(ui, icwarehousemanJpanel,account,state);
				icwarehousemanJpanel.add(stock);
				icwarehousemanJpanel.repaint();
			}
		});
		qiyun.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				System.out.println("qiyun");
				icwarehousemanJpanel.remove(stockDepotPanel1);
				stock2 = new stockDepotPanel2(ui, icwarehousemanJpanel,account,state);
				icwarehousemanJpanel.add(stock2);
				icwarehousemanJpanel.repaint();
			}
		});
	}
	
	private void check(){
		SimpleDateFormat endDf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		SimpleDateFormat startdf = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String startDate = startdf.format(new Date())+" 00:00:00";
		String endDate = endDf.format(new Date());
		System.out.println(startDate);
		System.out.println(endDate);
		
		
		checkController = new CheckController();
		InVOList = checkController.conInventory(account, startDate, endDate);
		VOList = new ArrayList<InDepotInfVO>();
		for(int i = 0 ; i < InVOList.size();i++){
			if(InVOList.get(i).getAreaNum()==2||InVOList.get(i).getAreaNum()==6){
				VOList.add(InVOList.get(i));
			}
		}
	}
	
	private void getDepotCount(){
		usedSpace =new spaceBL();
		String[] temp = state.split("-");
		useSpace = usedSpace.usedSpaceInf(temp[1]);
	}
	
	public void paintComponent(Graphics g)  
	{  
	    super.paintComponent(g);    
	    g.drawImage(frameIcon.getImage(),-7,-12,null);
     }
	
}