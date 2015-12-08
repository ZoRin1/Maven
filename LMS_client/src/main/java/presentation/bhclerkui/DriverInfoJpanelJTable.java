package presentation.bhclerkui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

import businesslogic.organizationbl.BhclerkController;
import po.documentsPO.YDispatchPO;
import presentation.icwarehousemanui.stockDepotPanel;
import vo.orgVO.DriverVO;

public class DriverInfoJpanelJTable {
	
	private JTable driverInfTable;
	private DriverInfoJpanel DriverInfoJpanel;
	private JScrollPane scrollPane;
	private bhclerkui ui;
	private String account;
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	
	public DriverInfoJpanelJTable(bhclerkui ui,DriverInfoJpanel DriverInfoJpanel,String account){
		this.account=account;
		this.ui=ui;
		this.DriverInfoJpanel = DriverInfoJpanel;
		initTable();
		init();
	}
	
	private void init(){
        scrollPane = new JScrollPane(driverInfTable); 
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		scrollPane.setViewportView(driverInfTable);
        scrollPane.setColumnHeaderView(driverInfTable.getTableHeader());
        
        scrollPane.getColumnHeader().setOpaque(false);
		scrollPane.setBounds(0, 0, 730, 571);
        
		DriverInfoJpanel.add(scrollPane);
	}
	
	private void initTable(){
		//假设的数据
		String[] inDepotName = new String[]{"司机编号"};
		String[] list=new BhclerkController().getDriverList(account);
		int size=list.length;
		String [][]inDepotValue=new String[size][1];
		for(int i=0;i<size;i++){
			inDepotValue[i][0]=list[i];
		}
		//假设的数据： 完善后要从数据库拿取数据来填写表格
		
		DefaultTableModel tableModel = new DefaultTableModel(inDepotValue,inDepotName);
		
		driverInfTable = new JTable(tableModel){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		driverInfTable.setFont(new Font("幼圆", Font.BOLD, 20));
		driverInfTable.getTableHeader().setReorderingAllowed(false); //设置列不可重排
		driverInfTable.getTableHeader().setResizingAllowed(false); //设置列不可拖动
		
		//对双击的监听
		driverInfTable.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2){
					int row = driverInfTable.getSelectedRow();
					String value = driverInfTable.getValueAt(row, 0).toString().trim();
					new DriverInfoDialog(ui, value, true, new BhclerkController().getDriverInfo(account, value));
					//监听的具体实现
				}
			}
		});
		
		driverInfTable.setRowHeight(32);
		driverInfTable.setShowGrid(false);
		TableColumn column = null;
		column = driverInfTable.getColumnModel().getColumn(0);
		column.setPreferredWidth(452);
		column = driverInfTable.getColumnModel().getColumn(1);
		column.setPreferredWidth(274);
		
		
		driverInfTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		driverInfTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		
		driverInfTable.setOpaque(false); 
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();   
		render.setOpaque(false);
		
		driverInfTable.setDefaultRenderer(Object.class,render);
		
		JTableHeader header = driverInfTable.getTableHeader();
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
class DriverInfoDialog extends JDialog{
	private dialogJpanel jPanel;
	private JButton jButton;
	private JTable Jtabel;
	private DriverVO vo;
	private JScrollPane scrollPane;
	public DriverInfoDialog(JFrame frame,String title,boolean modal,DriverVO vo) {
		super(frame,title,modal);
		this.vo=vo;
		initTable();
		init();
		registerListener();
		this.setVisible(true);
	}
	private void initTable(){
		//假设的数据
		String[] inDepotName = new String[]{" "," "};
		String [][] inDepotValue={{"司机姓名：",vo.getName()},{"性别：",vo.getSex()},{"出生日期：",vo.getDate()},{"身份证号码：",vo.getCodeID()},
				{"手机号码：",vo.getPhone()},{"行驶证期限",vo.getToDate()}};
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
				DriverInfoDialog.this.dispose();
			}
		});
	}
}