package presentation.financialstaffui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileSystemView;

import businesslogic.storagebl.ExcelModel.OutExcel;
import po.excelPO.ExcelPO;
import po.excelPO.ProfitExcelPO;
import vo.financeVO.ProfitVO;

public class b1b2Jpanel1 extends JPanel{
	
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JButton returnButton,excelButton;
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	private JLabel j1;
	private b1b2Jpanel1JTable b1b2Jpanel1JTable;
	private ArrayList<ProfitVO> profitList;
	
	private b1financialstaffui b1financialstaffui;
	private FileChooser file;
	private String address;
	private OutExcel outExcel;
	
	public b1b2Jpanel1(b1financialstaffui b1financialstaffui,financialstaffJpanel financialstaffJpanel,ArrayList<ProfitVO> profitList) {
		// TODO Auto-generated constructor stub
		this.b1financialstaffui = b1financialstaffui;
		this.profitList = profitList;
		init();
		financialstaffJpanel.add(this);
		registListener(b1financialstaffui,financialstaffJpanel,this);
	}
	private void init(){
		Font font=new Font("幼圆",Font.BOLD,20);
		ImageIcon i1 = new ImageIcon("picture/财务图片/成本收益表框架.png");
		ImageIcon Excel = new ImageIcon("picture/小导出EXCEL.png");
		excelButton = new JButton(Excel);
		j1 = new JLabel(i1);
		j1.setBounds(0, 0, 723, 571);
		
		b1b2Jpanel1JTable = new b1b2Jpanel1JTable(this,profitList);
		
		returnButton=new JButton(returnIcon);
		returnButton.setBounds(662, 575,48,48);
		returnButton.setContentAreaFilled(false);
		
		excelButton.setBounds(581, 575, 47, 47);
		excelButton.setContentAreaFilled(false);

	 	this.setBounds(260, 60, 730,650);

	 	j1.add(b1b2Jpanel1JTable.getScrollPane());
	 	this.add(returnButton);
	 	this.add(j1);
		this.add(excelButton);
	 	this.setLayout(null);
	 	this.setOpaque(false);
	}
	private void registListener(final b1financialstaffui b1financialstaffui,final financialstaffJpanel financialstaffJpanel,final b1b2Jpanel1 b1b2Jpanel1){
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				financialstaffJpanel.remove(b1b2Jpanel1);
				financialstaffJpanel.add(b1financialstaffui.operationJpanel);
				b1financialstaffui.b1.setEnabled(true);
				b1financialstaffui.b2.setEnabled(true);
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
				
				ArrayList<ProfitExcelPO> proList = new ArrayList<ProfitExcelPO>();
				for(int i = 0 ; i < profitList.size();i++){
					ProfitExcelPO p1 = new ProfitExcelPO(profitList.get(i).getTotalRevenue(), profitList.get(i).getTotalPay(), profitList.get(i).getGenerationDate());
					proList.add(p1);
				}
					
				ArrayList<ExcelPO> fatherList = new ArrayList<ExcelPO>();
				for(int i = 0 ; i < proList.size();i++){
					ExcelPO p2 = proList.get(i);
					fatherList.add(p2);
				}
				outExcel = new OutExcel();
				String[] name = {"总收入","总支出","生成时间","成本收益"};
				outExcel.outExcel("成本收益表", name, address, fatherList);
			}
		});
	}
	public void paintComponent(Graphics g)  
{  
		super.paintComponent(g);    
		g.drawImage(frameIcon.getImage(),-7,-12,null);
 }
}

