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

public class stockDepotPanel2 extends JPanel{
	
	
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JButton returnButton;
	private JLabel j1;
	private stockDepotJTable2 stockTable2;
	private JButton tieyun,hangyun;
//	private inDepotCheckJTable inDepotCheckJTable;
//	private JTable inDepotTable;
	private stockDepotPanel stock;
	private stockDepotPanel1 stock1;
	private JLabel inDepotCount,AllDepotCount;
	
	private String account;
	private String state;
	private CheckController checkController;
	private ArrayList<InDepotInfVO> InVOList;
	private ArrayList<InDepotInfVO> VOList;
	private spaceBL usedSpace;
	private int[] useSpace;
	public stockDepotPanel2(icwarehousemanui icwarehousemanui,icwarehousemanJpanel icwarehousemanJpanel,String account,String state){
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
		ImageIcon kuangjia = new ImageIcon("picture/库存图片/汽运区.png");
		returnButton=new JButton(returnIcon);
		tieyun = new JButton();
		tieyun.setBounds(82, 15, 38, 15);
		tieyun.setContentAreaFilled(false);
		tieyun.setBorderPainted(false);
		hangyun = new JButton();
		hangyun.setBounds(20, 16, 38, 17);
		hangyun.setContentAreaFilled(false);
		hangyun.setBorderPainted(false);
		j1 = new JLabel(kuangjia);
		j1.setBounds(0, 0, 720, 570);
//		inDepotCount = new JLabel("103");
		inDepotCount = new JLabel(String.valueOf(VOList.size()));
		inDepotCount.setFont(new Font("幼圆", Font.BOLD, 20));
		inDepotCount.setBounds(572, 35, 80, 24);
		
//		AllDepotCount = new JLabel("6594");
		AllDepotCount = new JLabel(String.valueOf(useSpace[2]));
		AllDepotCount.setFont(new Font("幼圆", Font.BOLD, 20));
		AllDepotCount.setBounds(612, 542, 80, 24);
		
		
		stockTable2 = new stockDepotJTable2(this,VOList);

		
		returnButton.setBounds(662, 575,48,48);
		returnButton.setContentAreaFilled(false);
		
		this.add(j1);
		this.add(returnButton);
		j1.add(stockTable2.getScrollPane());
		j1.add(hangyun);
		j1.add(tieyun);
		j1.add(inDepotCount);
		j1.add(AllDepotCount);
		this.setOpaque(false);
		this.setBounds(260, 60, 730,650);
		this.setLayout(null);
	}
	
	private void registListener(final icwarehousemanui ui,final icwarehousemanJpanel icwarehousemanJpanel,final stockDepotPanel2 stockDepotPanel2){
		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				icwarehousemanJpanel.remove(stockDepotPanel2);
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
		tieyun.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				System.out.println("tieyun");
				icwarehousemanJpanel.remove(stockDepotPanel2);
				stock1 = new stockDepotPanel1(ui, icwarehousemanJpanel,account,state);
				icwarehousemanJpanel.add(stock1);
				icwarehousemanJpanel.repaint();
			}
		});
		hangyun.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				System.out.println("qiyun");
				icwarehousemanJpanel.remove(stockDepotPanel2);
				stock = new stockDepotPanel(ui, icwarehousemanJpanel,account,state);
				icwarehousemanJpanel.add(stock);
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
			if(InVOList.get(i).getAreaNum()==3||InVOList.get(i).getAreaNum()==7){
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
