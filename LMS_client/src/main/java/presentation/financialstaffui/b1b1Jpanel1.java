package presentation.financialstaffui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import po.documentsPO.ReceiptPO;
import po.excelPO.BillsExcelPO;
import po.excelPO.ExcelPO;
import po.excelPO.ProfitExcelPO;
import vo.documentsVO.ReceiptVO;
import businesslogic.financebl.ProfitModel.CostStatisticsBL;
import businesslogic.storagebl.ExcelModel.OutExcel;


public class b1b1Jpanel1 extends JPanel{
	
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JButton returnButton,excelButton;
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	private JLabel j1;
	private JButton fukuan;
	
	private CostStatisticsBL costBL;
	private ArrayList<ReceiptVO> ReceiptList;
	private b1b1Jpanel1Jtable shoukuanTable;
	
	private b1financialstaffui b1financialstaffui;
	private FileChooser file;
	private String address;
	private OutExcel outExcel;
	public b1b1Jpanel1(b1financialstaffui b1financialstaffui,financialstaffJpanel financialstaffJpanel) {
		// TODO Auto-generated constructor stub
		this.b1financialstaffui = b1financialstaffui;
		this.costBL = new CostStatisticsBL();
		this.ReceiptList = new ArrayList<ReceiptVO>();
		init();
		financialstaffJpanel.add(this);
		registListener(b1financialstaffui,financialstaffJpanel,this);
	}
	private void init(){
		Font font=new Font("幼圆",Font.BOLD,20);
		ImageIcon i1 = new ImageIcon("picture/财务图片/经营收款.png");
		ImageIcon Excel = new ImageIcon("picture/小导出EXCEL.png");
		excelButton = new JButton(Excel);
		
		j1 = new JLabel(i1);
		j1.setBounds(0, 0, 723, 561);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());
		ReceiptList = costBL.getInBills(date);
		shoukuanTable = new b1b1Jpanel1Jtable(this, ReceiptList);
		
		fukuan = new JButton();
		fukuan.setBounds(70, 11, 43, 18);
		fukuan.setContentAreaFilled(false);
		fukuan.setBorderPainted(false);
		
		returnButton=new JButton(returnIcon);
		returnButton.setBounds(662, 575,48,48);
		returnButton.setContentAreaFilled(false);
		
		excelButton.setBounds(581, 575, 47, 47);
		excelButton.setContentAreaFilled(false);

	 	this.setBounds(260, 60, 730,650);

	 	j1.add(fukuan);
	 	j1.add(shoukuanTable.getScrollPane());
	 	
	 	this.add(j1);
	 	this.add(returnButton);
	 	this.add(excelButton);
	 	this.setLayout(null);
	 	this.setOpaque(false);
	}
	private void registListener(final b1financialstaffui b1financialstaffui,final financialstaffJpanel financialstaffJpanel,final b1b1Jpanel1 b1b1Jpanel1){
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				financialstaffJpanel.remove(b1b1Jpanel1);
				financialstaffJpanel.add(b1financialstaffui.operationJpanel);
				b1financialstaffui.b1.setEnabled(true);
				b1financialstaffui.b2.setEnabled(true);
				financialstaffJpanel.repaint();
			}
		});
		fukuan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				financialstaffJpanel.remove(b1b1Jpanel1);
				financialstaffJpanel.add(new b1b1Jpanel2(b1financialstaffui, financialstaffJpanel));
				financialstaffJpanel.repaint();
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
				
				file = new FileChooser(b1financialstaffui);
				address = file.getAddress();
				
				ArrayList<BillsExcelPO> vo = new ArrayList<BillsExcelPO>();
				for(int i = 0 ; i < ReceiptList.size();i++){
					BillsExcelPO p1 = new BillsExcelPO(ReceiptList.get(i).getCode(), ReceiptList.get(i).getDate(), ReceiptList.get(i).getDoName(), ReceiptList.get(i).getFund());
					vo.add(p1);
				}
				
				ArrayList<ExcelPO> fatherList = new ArrayList<ExcelPO>();
				for(int i = 0 ; i < vo.size();i++){
					ExcelPO p2 = vo.get(i);
					fatherList.add(p2);
				}
				
				outExcel = new OutExcel();
				String[] name = {"收款单编号","收款日期","单据名","收款金额"};
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
