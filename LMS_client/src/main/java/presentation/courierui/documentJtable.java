package presentation.courierui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
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
import po.documentsPO.LoadingPO;
import po.documentsPO.OrderPO;
import po.documentsPO.ReceiptPO;
import po.documentsPO.YDispatchPO;
import po.documentsPO.YReceivePO;
import businesslogic.documentsbl.documentController;


public class documentJtable {
	private documentController documentController;
	private JTable Jtable;
	private documentJpanel documentJpanel;
	private JScrollPane scrollPane;
	private String account;
	private DocumentPO po;
	private courierui courierui;
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public documentJtable(courierui courierui,documentJpanel documentJpanel,String account){
		this.account=account;
		this.courierui=courierui;
		this.documentJpanel = documentJpanel;
		initTable();
		init();
	}
	private void init(){
        scrollPane = new JScrollPane(Jtable); 
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		scrollPane.setViewportView(Jtable);
        scrollPane.setColumnHeaderView(Jtable.getTableHeader());
        scrollPane.setFont(new Font("幼圆", Font.BOLD, 20));
        scrollPane.getColumnHeader().setOpaque(false);
		scrollPane.setBounds(0,32, 730, 540);
        
		documentJpanel.add(scrollPane);
	}
	
	private void initTable(){
		String[] inDepotName = new String[]{" "," "};
		documentController=new documentController();
		ArrayList<String> codeNameList=null;
		try {
			codeNameList = documentController.showOwnList(account);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			new InternetDialog(courierui);
		}
		Object[][] inDepotValue;
			 inDepotValue = new Object[codeNameList.size()][2];
			for (int i = 0; i < codeNameList.size(); i++) {
				String[] string=codeNameList.get(i).split(",");
				inDepotValue[i][0]=string[0];
				inDepotValue[i][1]=string[1];
			}
		
		
		DefaultTableModel tableModel = new DefaultTableModel(inDepotValue,inDepotName);
		
		Jtable = new JTable(tableModel){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		
		Jtable.getTableHeader().setReorderingAllowed(false); //设置列不可重排
		Jtable.getTableHeader().setResizingAllowed(false);//设置列不可拖动
		
		//对双击的监听
		Jtable.addMouseListener(new MouseAdapter() {
							
					public void mouseClicked(MouseEvent e) {
						if(e.getClickCount()==2){
							int row = Jtable.getSelectedRow();
							String value = Jtable.getValueAt(row, 0).toString().trim();
							String value2= Jtable.getValueAt(row, 1).toString().trim();
							try {
								po=new documentController().getBufferedInfo(value, value2);
							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
								new InternetDialog(courierui);
							}
							if(value2.equals("寄件单")){
								OrderPO po1=(OrderPO)po;
								new OrderDialog(courierui, "寄件单", true, po1);
							}
							else {
								GetOrderPO po1=(GetOrderPO)po;
								new GetOrderDialog(courierui, "收件单", true, po1);
							}
						
							//监听的具体实现
						}
					}
				});
		Jtable.setRowHeight(32);
		Jtable.setShowGrid(false);
		TableColumn column = null;
		column = Jtable.getColumnModel().getColumn(0);
		column.setPreferredWidth(361);
		column = Jtable.getColumnModel().getColumn(1);
		column.setPreferredWidth(366);
		
		Jtable.setFont(new Font("幼圆",Font.BOLD,20));
		Jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		Jtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		
		Jtable.setOpaque(false); 
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();   
		render.setOpaque(false);
		
		Jtable.setDefaultRenderer(Object.class,render);
		
		JTableHeader header = Jtable.getTableHeader();
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
class OrderDialog extends JDialog{
	private dialogJpanel jPanel;
	private JButton jButton;
	private JTable Jtabel;
	private OrderPO po;
	private JScrollPane scrollPane;
	public OrderDialog(JFrame frame,String title,boolean modal,OrderPO po) {
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
		String [][] inDepotValue=new String[20][2];
		inDepotValue[0][0]="订单编号：";
		inDepotValue[0][1]=po.getCode();
		inDepotValue[1][0]="单据名：";
		inDepotValue[1][1]=po.getDoName();
		inDepotValue[2][0]="日期：";
		inDepotValue[2][1]=po.getDate();
		inDepotValue[3][0]="寄件人姓名：";
		inDepotValue[3][1]=po.getReceiverName();
		inDepotValue[4][0]="寄件人地址：";
		inDepotValue[4][1]= po.getReceiverAddress();
		inDepotValue[5][0]="寄件人单位：";
		inDepotValue[5][1]= po.getReceiverOrg();
		inDepotValue[6][0]="寄件人电话：";
		inDepotValue[6][1]= po.getRPhoneNumber();	
		inDepotValue[7][0]="寄件人手机号：";
		inDepotValue[7][1]= po.getRMobileNumber();
		inDepotValue[8][0]="收件人姓名：";
		inDepotValue[8][1]= po.getSenderName();
		inDepotValue[9][0]="收件人地址：";
		inDepotValue[9][1]= po.getSenderAddress();
		inDepotValue[10][0]="收件人单位：";
		inDepotValue[10][1]=po.getSenderOrg() ;
		inDepotValue[11][0]="收件人电话：";
		inDepotValue[11][1]= po.getSPhoneNumber();
		inDepotValue[12][0]="收件人手机号：";
		inDepotValue[12][1]= po.getSMobileNumber();	
		inDepotValue[13][0]="货物数量：";
		inDepotValue[13][1]= Integer.toString(po.getNumber());
		inDepotValue[14][0]="货物重量：";
		inDepotValue[14][1]= Double.toString(po.getWeight());
		inDepotValue[15][0]="货物体积：";
		inDepotValue[15][1]= Double.toString(po.getShape())+" cm^3";
		inDepotValue[16][0]="货物名：";
		inDepotValue[16][1]= po.getCargoNameList();
		inDepotValue[17][0]="货物大小：";
		double[] sizeList=po.getSizeList();
		inDepotValue[17][1]= sizeList[0]+" cm * "+sizeList[1]+" cm * "+sizeList[2]+" cm";
		inDepotValue[18][0]="总费用：";
		inDepotValue[18][1]= Double.toString(po.getSumCost());
		inDepotValue[19][0]="快递种类：";
		inDepotValue[19][1]= po.getState();
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
        scrollPane.setBounds(50,5,600,350);
        this.add(scrollPane);
        
		ImageIcon yesIcon=new ImageIcon("picture/登录.png");
		jPanel=new dialogJpanel();
		
		jButton=new JButton(yesIcon);
		jButton.setContentAreaFilled(false);
		jButton.setBounds(318,390, 64, 64);
		jPanel.add(jButton);
		jPanel.setLayout(null);
		
		this.add(jPanel);
		this.setSize(700, 500);
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
				OrderDialog.this.dispose();
			}
		});
	}
}
class GetOrderDialog extends JDialog{
	private dialogJpanel jPanel;
	private JButton jButton;
	private JTable Jtabel;
	private GetOrderPO po;
	private JScrollPane scrollPane;
	public GetOrderDialog(JFrame frame,String title,boolean modal,GetOrderPO po) {
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
		String [][] inDepotValue=new String[5][2];
		inDepotValue[0][0]="收件单编号：";
		inDepotValue[0][1]=po.getCode();
		inDepotValue[1][0]="单据名：";
		inDepotValue[1][1]=po.getDoName();
		inDepotValue[2][0]="订单编号：";
		inDepotValue[2][1]= po.getCode1();
		inDepotValue[3][0]="收件人姓名：";
		inDepotValue[3][1]=po.getReceiverName();
		inDepotValue[4][0]="收件日期：";
		inDepotValue[4][1]=po.getDate();

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
				GetOrderDialog.this.dispose();
			}
		});
	}
}