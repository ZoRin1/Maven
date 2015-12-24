package presentation.bhclerkui;

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
import po.documentsPO.LoadingPO;
import po.documentsPO.ReceiptPO;
import po.documentsPO.YDispatchPO;
import po.documentsPO.YReceivePO;
import businesslogic.documentsbl.documentController;

public class documentReplyJTable {
	
	private JTable Jtabel;
	private bhclerkdocumentreplyOperationJpanel panel;
	private JScrollPane scrollPane;
	private String account;
	private DocumentPO po;
	private documentreplyui ui;
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public documentReplyJTable(documentreplyui ui,bhclerkdocumentreplyOperationJpanel jpanel,String account){
		this.ui=ui;
		this.panel = jpanel;
		this.account=account;
		initTable();
		init();
	}
	private void init(){
        scrollPane = new JScrollPane(Jtabel); 
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		scrollPane.setViewportView(Jtabel);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setColumnHeaderView(Jtabel.getTableHeader());
        
        scrollPane.getColumnHeader().setOpaque(false);
		scrollPane.setBounds(0,32, 723,535);
        
		panel.add(scrollPane);
	}
	
	private void initTable(){
		//假设的数据
		String[] inDepotName = new String[]{" "," "};
		ArrayList<String> list=null;
		try {
			list = new documentController().showOwnList(account);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			new InternetDialog(ui);
		}
		int length=list.size();
		String [][] inDepotValue=new String[length][2];
		for(int i=0;i<length;i++){
			String str[]=list.get(i).split(",");
			inDepotValue[i][0]=str[0];
			inDepotValue[i][1]=str[1];
		}
		
		DefaultTableModel tableModel = new DefaultTableModel(inDepotValue,inDepotName);
		
		Jtabel = new JTable(tableModel){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		Jtabel.setFont(new Font("幼圆", Font.BOLD, 20));
		
		Jtabel.getTableHeader().setReorderingAllowed(false); //设置列不可重排
		Jtabel.getTableHeader().setResizingAllowed(false);//设置列不可拖动
		
		//对双击的监听
		Jtabel.addMouseListener(new MouseAdapter() {
					
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2){
					int row = Jtabel.getSelectedRow();
					String value = Jtabel.getValueAt(row, 0).toString().trim();
					String value2= Jtabel.getValueAt(row, 1).toString().trim();
					try {
						po=new documentController().getBufferedInfo(value, value2);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						new InternetDialog(ui);
					}
					if(value2.equals("营业厅装车单")){
						LoadingPO po1=(LoadingPO)po;
						new LoadingDialog(ui, "装车单", true, po1);
					}
					else if(value2.equals("营业厅接收单")){
						YReceivePO po1=(YReceivePO)po;
						new JieshouDialog(ui, "营业厅接收单", true, po1);
					}
					else if(value2.equals("派件单")){
						YDispatchPO po1=(YDispatchPO)po;
						new YDispatchDialog(ui, "派件单", true, po1);
					}
					else{
						ReceiptPO po1=(ReceiptPO)po;
						new ReceiptDialog(ui, "收款单", true, po1);
					}
					//监听的具体实现
				}
			}
		});
				
		Jtabel.setRowHeight(32);
		Jtabel.setShowGrid(false);
		TableColumn column = null;
		column = Jtabel.getColumnModel().getColumn(0);
		column.setPreferredWidth(360);
		column = Jtabel.getColumnModel().getColumn(1);
		column.setPreferredWidth(360);
		
		
		Jtabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		Jtabel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		
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
	
}
class LoadingDialog extends JDialog{
	private dialogJpanel jPanel;
	private JButton jButton;
	private JTable Jtabel;
	private LoadingPO po;
	private JScrollPane scrollPane;
	public LoadingDialog(JFrame frame,String title,boolean modal,LoadingPO po) {
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
		ArrayList<String> list=po.getCodeList();
		int length=list.size();
		String [][] inDepotValue=new String[length+5][2];
		inDepotValue[0][0]="出发地：";
		inDepotValue[0][1]=po.getDeparture();
		inDepotValue[1][0]="到达地：";
		inDepotValue[1][1]=po.getArrival();
		inDepotValue[2][0]="监装员：";
		inDepotValue[2][1]=po.getSupervisor();
		inDepotValue[3][0]="押运员：";
		inDepotValue[3][1]=po.getSupercargo();
		inDepotValue[4][0]="所有托运单号：";
		inDepotValue[length+4][0]="运费:";
		inDepotValue[length+4][1]=po.getCharge()+"";
		for(int i=0;i<length;i++){
			inDepotValue[i+4][1]=list.get(i);
		}
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
		column.setPreferredWidth(180);
		
		column = Jtabel.getColumnModel().getColumn(1);
		column.setPreferredWidth(200);
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
        scrollPane.setColumnHeaderView(Jtabel.getTableHeader());
        scrollPane.getColumnHeader().setOpaque(false);
        scrollPane.setBounds(50,5,400,180);
        this.add(scrollPane);
        
		ImageIcon yesIcon=new ImageIcon("picture/登录.png");
		jPanel=new dialogJpanel();
		
		jButton=new JButton(yesIcon);
		jButton.setContentAreaFilled(false);
		jButton.setBounds(218,190, 64, 64);
		jPanel.add(jButton);
		jPanel.setLayout(null);
		
		this.add(jPanel);
		this.setSize(500, 300);
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
				LoadingDialog.this.dispose();
			}
		});
	}
}

class JieshouDialog extends JDialog{
	private dialogJpanel jPanel;
	private JButton jButton;
	private JTable Jtabel;
	private YReceivePO po;
	private JScrollPane scrollPane;
	public JieshouDialog(JFrame frame,String title,boolean modal,YReceivePO po) {
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
		String [][] inDepotValue={{"出发地：",po.getDeparture()},{"到达地：",po.getArrival()},{"订单条形码号：",po.getCode1()},{"货物状态：",po.getState()}};
		DefaultTableModel tableModel = new DefaultTableModel(inDepotValue,inDepotName);
		
		Jtabel = new JTable(tableModel){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		Jtabel.setEnabled(false);
		Jtabel.getTableHeader().setReorderingAllowed(false); //设置列不可重排
		Jtabel.getTableHeader().setResizingAllowed(false);//设置列不可拖动
				
		Jtabel.setRowHeight(32);
		Jtabel.setShowGrid(false);
		TableColumn column = null;
		column = Jtabel.getColumnModel().getColumn(0);
		column.setPreferredWidth(180);
		
		column = Jtabel.getColumnModel().getColumn(1);
		column.setPreferredWidth(200);
		Jtabel.setFont(new Font("幼圆", Font.BOLD, 20));
		Jtabel.setForeground(Color.white);
		Jtabel.setOpaque(false); 
		Jtabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
		
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
        scrollPane.setColumnHeaderView(Jtabel.getTableHeader());
        scrollPane.getColumnHeader().setOpaque(false);
        scrollPane.setBounds(50,5,400,180);
        this.add(scrollPane);
        
		ImageIcon yesIcon=new ImageIcon("picture/登录.png");
		jPanel=new dialogJpanel();
		
		jButton=new JButton(yesIcon);
		jButton.setContentAreaFilled(false);
		jButton.setBounds(218,190, 64, 64);
		jPanel.add(jButton);
		jPanel.setLayout(null);
		
		this.add(jPanel);
		this.setSize(500, 300);
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
				JieshouDialog.this.dispose();
			}
		});
	}
}

class YDispatchDialog extends JDialog{
	private dialogJpanel jPanel;
	private JButton jButton;
	private JTable Jtabel;
	private YDispatchPO po;
	private JScrollPane scrollPane;
	public YDispatchDialog(JFrame frame,String title,boolean modal,YDispatchPO po) {
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
		String [][] inDepotValue={{"订单条形码号：",po.getCode2()},{"派件员：",po.getName2()}};
		DefaultTableModel tableModel = new DefaultTableModel(inDepotValue,inDepotName);
		
		Jtabel = new JTable(tableModel){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		Jtabel.setEnabled(false);
		Jtabel.getTableHeader().setReorderingAllowed(false); //设置列不可重排
		Jtabel.getTableHeader().setResizingAllowed(false);//设置列不可拖动
				
		Jtabel.setRowHeight(32);
		Jtabel.setShowGrid(false);
		TableColumn column = null;
		column = Jtabel.getColumnModel().getColumn(0);
		column.setPreferredWidth(180);
		
		column = Jtabel.getColumnModel().getColumn(1);
		column.setPreferredWidth(200);
		Jtabel.setFont(new Font("幼圆", Font.BOLD, 20));
		Jtabel.setForeground(Color.white);
		Jtabel.setOpaque(false); 
		
		Jtabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
		
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
        scrollPane.setColumnHeaderView(Jtabel.getTableHeader());
        scrollPane.getColumnHeader().setOpaque(false);
        scrollPane.setBounds(50,5,400,180);
        this.add(scrollPane);
        
		ImageIcon yesIcon=new ImageIcon("picture/登录.png");
		jPanel=new dialogJpanel();
		
		jButton=new JButton(yesIcon);
		jButton.setContentAreaFilled(false);
		jButton.setBounds(218,190, 64, 64);
		jPanel.add(jButton);
		jPanel.setLayout(null);
		
		this.add(jPanel);
		this.setSize(500, 300);
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
				YDispatchDialog.this.dispose();
			}
		});
	}
}

class ReceiptDialog extends JDialog{
	private dialogJpanel jPanel;
	private JButton jButton;
	private JTable Jtabel;
	private ReceiptPO po;
	private JScrollPane scrollPane;
	public ReceiptDialog(JFrame frame,String title,boolean modal,ReceiptPO po) {
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
		ArrayList<String> list=po.getTCode();
		int length=list.size();
		String [][] inDepotValue=new String[length+2][2];
		inDepotValue[0][0]="快递员姓名：";
		inDepotValue[0][1]=po.getName2();
		inDepotValue[1][0]="收款金额：";
		inDepotValue[1][1]=po.getFund()+"";
		inDepotValue[2][0]="所有订单编号：";
		for(int i=0;i<length;i++){
			inDepotValue[i+2][1]=list.get(i);
		}
		DefaultTableModel tableModel = new DefaultTableModel(inDepotValue,inDepotName);
		Jtabel = new JTable(tableModel){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		Jtabel.setEnabled(false);
		Jtabel.getTableHeader().setReorderingAllowed(false); //设置列不可重排
		Jtabel.getTableHeader().setResizingAllowed(false);//设置列不可拖动
				
		Jtabel.setRowHeight(32);
		Jtabel.setShowGrid(false);
		TableColumn column = null;
		column = Jtabel.getColumnModel().getColumn(0);
		column.setPreferredWidth(180);
		
		column = Jtabel.getColumnModel().getColumn(1);
		column.setPreferredWidth(200);
		Jtabel.setFont(new Font("幼圆", Font.BOLD, 20));
		Jtabel.setForeground(Color.white);
		Jtabel.setOpaque(false); 
		
		Jtabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
		
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
        scrollPane.setColumnHeaderView(Jtabel.getTableHeader());
        scrollPane.getColumnHeader().setOpaque(false);
        scrollPane.setBounds(50,5,400,180);
        this.add(scrollPane);
        
		ImageIcon yesIcon=new ImageIcon("picture/登录.png");
		jPanel=new dialogJpanel();
		
		jButton=new JButton(yesIcon);
		jButton.setContentAreaFilled(false);
		jButton.setBounds(218,190, 64, 64);
		jPanel.add(jButton);
		jPanel.setLayout(null);
		
		this.add(jPanel);
		this.setSize(500, 300);
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
				ReceiptDialog.this.dispose();
			}
		});
	}
}