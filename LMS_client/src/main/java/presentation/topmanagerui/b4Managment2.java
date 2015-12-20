package presentation.topmanagerui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

import po.excelPO.BillsExcelPO;
import po.excelPO.ExcelPO;
import presentation.financialstaffui.FileChooser;
import vo.documentsVO.PaymentVO;
import businesslogic.financebl.ProfitModel.CostStatisticsBL;
import businesslogic.storagebl.ExcelModel.OutExcel;

public class b4Managment2 extends JPanel{
	
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JButton returnButton,excelButton;
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	private JLabel j1;
	private JButton shoukuan;
	
	private CostStatisticsBL costBL;
	private ArrayList<PaymentVO> payList;
	private b4Magaement2Table fukuanTable;
	
	private b4topmanagerui b4topmanagerui;
	private FileChooser file;
	private String address;
	private OutExcel outExcel;
	public b4Managment2(b4topmanagerui b4topmanagerui,topmanagerJpanel topmanagerJpanel) {
		// TODO Auto-generated constructor stub
		this.b4topmanagerui = b4topmanagerui;
		costBL = new CostStatisticsBL();
		payList = new ArrayList<PaymentVO>();
		init();
		topmanagerJpanel.add(this);
		registListener(b4topmanagerui,topmanagerJpanel,this);
	}
	private void init(){
		Font font=new Font("幼圆",Font.BOLD,20);
		ImageIcon i1 = new ImageIcon("picture/财务图片/经营付款.png");
		ImageIcon Excel = new ImageIcon("picture/小导出EXCEL.png");
		excelButton = new JButton(Excel);
		
		j1 = new JLabel(i1);
		j1.setBounds(0, 0, 723, 561);
		
		shoukuan = new JButton();
		shoukuan.setBounds(18, 11, 43, 18);
		shoukuan.setContentAreaFilled(false);
		shoukuan.setBorderPainted(false);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());
		payList = costBL.getPayBills(date);
		fukuanTable = new b4Magaement2Table(this, payList);
		
		returnButton=new JButton(returnIcon);
		returnButton.setBounds(662, 575,48,48);
		returnButton.setContentAreaFilled(false);
		
		excelButton.setBounds(581, 575, 47, 47);
		excelButton.setContentAreaFilled(false);

	 	this.setBounds(260, 60, 730,650);
	 	
	 	j1.add(shoukuan);
	 	j1.add(fukuanTable.getScrollPane());

	 	this.add(j1);
	 	this.add(returnButton);
	 	this.add(excelButton);
	 	this.setLayout(null);
	 	this.setOpaque(false);
	}
	private void registListener(final b4topmanagerui b4topmanagerui,final topmanagerJpanel topmanagerJpanel,final b4Managment2 b4Managment2){
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				topmanagerJpanel.remove(b4Managment2);
				topmanagerJpanel.add(b4topmanagerui.operationJpanel);
				b4topmanagerui.b1.setEnabled(true);
				b4topmanagerui.b2.setEnabled(true);
				topmanagerJpanel.repaint();
			}
		});
		shoukuan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				topmanagerJpanel.remove(b4Managment2);
				topmanagerJpanel.add(new b4Management(b4topmanagerui, topmanagerJpanel));
				topmanagerJpanel.repaint();
			}
		});
		excelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (ClassNotFoundException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
				file = new FileChooser(b4topmanagerui);
				address = file.getAddress();
				
				ArrayList<BillsExcelPO> vo = new ArrayList<BillsExcelPO>();
				for(int i = 0 ; i < payList.size();i++){
					BillsExcelPO p1 = new BillsExcelPO(payList.get(i).getCode(), payList.get(i).getDate(), payList.get(i).getDoName(), payList.get(i).getFund());
					vo.add(p1);
				}
				
				ArrayList<ExcelPO> fatherList = new ArrayList<ExcelPO>();
				for(int i = 0 ; i < vo.size();i++){
					ExcelPO p2 = vo.get(i);
					fatherList.add(p2);
				}
				
				outExcel = new OutExcel();
				String[] name = {"付款单编号","付款日期","单据名","付款金额"};
				outExcel.outExcel("经营情况表", name, address, fatherList);
			}
		});
	}
	public void paintComponent(Graphics g)  
{  
		super.paintComponent(g);    
		g.drawImage(frameIcon.getImage(),-7,-12,null);
 }
}
