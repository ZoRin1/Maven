package presentation.financialstaffui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import po.documentsPO.DocumentPO;
import po.documentsPO.GetOrderPO;
import po.documentsPO.PaymentPO;
import businesslogic.documentsbl.documentController;

public class b3b2Jpanel1JTable {
	private b3financialstaffui b3financialstaffui;
	private JTable billsJtabel;
	private b3b2Jpanel1 b3b2Jpanel1;
	private JScrollPane scrollPane;
	private documentController documentController;
	private String account;
	private DocumentPO po;
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public b3b2Jpanel1JTable(b3financialstaffui b3financialstaffui,b3b2Jpanel1 b3b2Jpanel1,String account){
		this.b3financialstaffui=b3financialstaffui;
		this.account=account;
		this.b3b2Jpanel1 = b3b2Jpanel1;
		initTable();
		init();
	}
	private void init(){
        scrollPane = new JScrollPane(billsJtabel); 
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		scrollPane.setViewportView(billsJtabel);
        scrollPane.setColumnHeaderView(billsJtabel.getTableHeader());
        
        scrollPane.getColumnHeader().setOpaque(false);
		scrollPane.setBounds(0,32, 730, 540);
        
		b3b2Jpanel1.add(scrollPane);
	}
	
	private void initTable(){
		//假设的数据
		String[] inDepotName = new String[]{" "," "};
		
//		Object[][] inDepotValue = new Object[][]{{"楚留","2321"},
//				{"楚留奇","232134 KB"},
//			{"楚留奇","2324 KB"},
//					{"楚香传奇","2324 KB"},
//				{"楚奇","232134 KB"}
//					};
		//假设的数据： 完善后要从数据库拿取数据来填写表格
		documentController=new documentController();
		ArrayList<String>codeNameList= documentController.showOwnList(account);
		Object[][] inDepotValue;
			 inDepotValue = new Object[codeNameList.size()][2];
			for (int i = 0; i < codeNameList.size(); i++) {
				String[] string=codeNameList.get(i).split(",");
				inDepotValue[i][0]=string[0];
				inDepotValue[i][1]=string[1];
			}
		DefaultTableModel tableModel = new DefaultTableModel(inDepotValue,inDepotName);
		
		billsJtabel = new JTable(tableModel){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		billsJtabel.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2){
					int row = billsJtabel.getSelectedRow();
					String value = billsJtabel.getValueAt(row, 0).toString().trim();
					String value2= billsJtabel.getValueAt(row, 1).toString().trim();
					po=new documentController().getBufferedInfo(value, value2);
					PaymentPO po1=(PaymentPO)po;
						new PaymentDialog(b3financialstaffui, "付款单", true, po1);
					//监听的具体实现
				}
			}
		});
		billsJtabel.setFont(new Font("幼圆", Font.BOLD, 20));
		billsJtabel.getTableHeader().setReorderingAllowed(false); //设置列不可重排
		billsJtabel.getTableHeader().setResizingAllowed(false);//设置列不可拖动
		
		
		billsJtabel.setRowHeight(32);
		billsJtabel.setShowGrid(false);
		TableColumn column = null;
		column = billsJtabel.getColumnModel().getColumn(0);
		column.setPreferredWidth(361);
		column = billsJtabel.getColumnModel().getColumn(1);
		column.setPreferredWidth(366);
		
		
		billsJtabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		billsJtabel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		
		billsJtabel.setOpaque(false); 
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();   
		render.setOpaque(false);
		
		billsJtabel.setDefaultRenderer(Object.class,render);
		
		JTableHeader header = billsJtabel.getTableHeader();
		header.setOpaque(false);
		header.getTable().setOpaque(false);
		
		header.setDefaultRenderer(render); 
		TableCellRenderer headerRenderer = header.getDefaultRenderer();
		if (headerRenderer instanceof JLabel) {
			((JLabel) headerRenderer).setHorizontalAlignment(JLabel.CENTER);
			((JLabel) headerRenderer).setOpaque(false); 
		}
	}
	
}
class PaymentDialog extends JDialog{
	private dialogJpanel jPanel;
	private JButton jButton;
	private JTable Jtabel;
	private PaymentPO po;
	private JScrollPane scrollPane;
	public PaymentDialog(JFrame frame,String title,boolean modal,PaymentPO po) {
		super(frame,title,modal);
		this.po=po;
		initTable();
		init();
		registerListener();
		this.setVisible(true);
	}
	private void initTable(){
		//假设的数据
		String[] inDepotName = new String[]{" "," "};
		String [][] inDepotValue=new String[8][2];
		inDepotValue[0][0]="付款单编号：";
		inDepotValue[0][1]=po.getCode();
		inDepotValue[1][0]="单据名：";
		inDepotValue[1][1]=po.getDoName();
		inDepotValue[2][0]="付款日期：";
		inDepotValue[2][1]=po.getDate();
		inDepotValue[3][0]="付款金额：";
		inDepotValue[3][1]= Double.toString(po.getFund());
		inDepotValue[4][0]="付款人姓名：";
		inDepotValue[4][1]=po.getName2();
		inDepotValue[5][0]="付款账号：";
		inDepotValue[5][1]=po.getAccount();
		inDepotValue[6][0]="条目：";
		inDepotValue[6][1]=po.getType();
		inDepotValue[7][0]="备注：";
		inDepotValue[7][1]=po.getRemark();

		DefaultTableModel tableModel = new DefaultTableModel(inDepotValue,inDepotName);
		
		Jtabel = new JTable(tableModel){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		
		Jtabel.getTableHeader().setReorderingAllowed(false); //设置列不可重排
		Jtabel.getTableHeader().setResizingAllowed(false);//设置列不可拖动
				
		Jtabel.setRowHeight(32);
		Jtabel.setShowGrid(false);
		TableColumn column = null;
		column = Jtabel.getColumnModel().getColumn(0);
		column.setPreferredWidth(300);
		
		column = Jtabel.getColumnModel().getColumn(1);
		column.setPreferredWidth(300);
		Jtabel.setFont(new Font("幼圆", Font.BOLD, 20));
		Jtabel.setForeground(Color.white);
		Jtabel.setOpaque(false); 
		
		Jtabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		Jtabel.setEnabled(false);
		
		Jtabel.setOpaque(false); 
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();   
		render.setOpaque(false);
		
		Jtabel.setDefaultRenderer(Object.class,render);
		
		JTableHeader header = Jtabel.getTableHeader();
		header.setOpaque(false);
		header.getTable().setOpaque(false);
		
		header.setDefaultRenderer(render); 
		TableCellRenderer headerRenderer = header.getDefaultRenderer();
		if (headerRenderer instanceof JLabel) {
			((JLabel) headerRenderer).setHorizontalAlignment(JLabel.CENTER);
			((JLabel) headerRenderer).setOpaque(false); 
		}
	}
	private void init(){
		scrollPane = new JScrollPane(Jtabel); 
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		scrollPane.setViewportView(Jtabel);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED );
        scrollPane.setColumnHeaderView(Jtabel.getTableHeader());
        scrollPane.getColumnHeader().setOpaque(false);
        scrollPane.setBounds(50,5,600,200);
        this.add(scrollPane);
        
		ImageIcon yesIcon=new ImageIcon("picture/登录.png");
		jPanel=new dialogJpanel();
		
		jButton=new JButton(yesIcon);
		jButton.setContentAreaFilled(false);
		jButton.setBounds(318,235, 64, 64);
		jPanel.add(jButton);
		jPanel.setLayout(null);
		
		this.add(jPanel);
		this.setSize(700, 350);
		Toolkit kitToolkit =Toolkit.getDefaultToolkit();
		Dimension screenSize=kitToolkit.getScreenSize();
		int screenWidth=screenSize.width;
		int screenHeight=screenSize.height;
		int dialogWidth=this.getWidth();
		int dialogHeight=this.getHeight();
		this.setLocation((screenWidth-dialogWidth)/2, (screenHeight-dialogHeight)/2);
		this.setResizable(false);
	}
	private void registerListener(){
		jButton.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				PaymentDialog.this.dispose();
			}
		});
	}
}