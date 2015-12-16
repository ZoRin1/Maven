package presentation.bhclerkui;

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

import po.documentsPO.YDispatchPO;
import po.orgPO.VehiclePO;
import vo.orgVO.VehicleVO;
import businesslogic.organizationbl.BhclerkController;

public class CarInfoJpanelJTable {
	
	private JTable carInfTable;
	private CarInfoJpanel CarInfoJpanel;
	private JScrollPane scrollPane;
	private bhclerkui ui;
	private bhclerkJpanel panel;
	private String ID;
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	
	public CarInfoJpanelJTable(bhclerkui ui,bhclerkJpanel panel,CarInfoJpanel CarInfoJpanel,String account){
		ID=account;
		this.panel=panel;
		this.CarInfoJpanel = CarInfoJpanel;
		initTable();
		init();
	}
	
	private void init(){
        scrollPane = new JScrollPane(carInfTable); 
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		scrollPane.setViewportView(carInfTable);
        scrollPane.setColumnHeaderView(carInfTable.getTableHeader());
        
        scrollPane.getColumnHeader().setOpaque(false);
		scrollPane.setBounds(0, 0, 730, 571);
        
		CarInfoJpanel.add(scrollPane);
	}
	
	private void initTable(){
		
		String[] inDepotName = new String[]{"车辆代号"};
		String[] list=new BhclerkController().getVehicleList(ID);
		int size=list.length;
		String [][]inDepotValue=new String[size][1];
		for(int i=0;i<size;i++){
			inDepotValue[i][0]=list[i];
		}
		DefaultTableModel tableModel = new DefaultTableModel(inDepotValue,inDepotName);
		
		carInfTable = new JTable(tableModel){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		carInfTable.setFont(new Font("幼圆", Font.BOLD, 20));
		carInfTable.getTableHeader().setReorderingAllowed(false); //设置列不可重排
		carInfTable.getTableHeader().setResizingAllowed(false); //设置列不可拖动
		
		//对双击的监听
		carInfTable.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2){
					int row = carInfTable.getSelectedRow();
					String value = carInfTable.getValueAt(row, 0).toString().trim();
					VehicleVO info=new BhclerkController().getVehicleInfo(ID, value);
					new CarInfoJpanel2(ui, panel, CarInfoJpanel, info, ID);
					//监听的具体实现
				}
			}
		});
		
		carInfTable.setRowHeight(32);
		carInfTable.setShowGrid(false);
		TableColumn column = null;
		column = carInfTable.getColumnModel().getColumn(0);
		column.setPreferredWidth(413);
		column = carInfTable.getColumnModel().getColumn(1);
		column.setPreferredWidth(310);
		
		
		carInfTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		carInfTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		
		carInfTable.setOpaque(false); 
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();   
		render.setOpaque(false);
		
		carInfTable.setDefaultRenderer(Object.class,render);
		
		JTableHeader header = carInfTable.getTableHeader();
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
//class CarInfoDialog extends JDialog{
//	private dialogJpanel jPanel;
//	private JButton jButton;
//	private JTable Jtabel;
//	private VehicleVO vo;
//	private JScrollPane scrollPane;
//	public CarInfoDialog(JFrame frame,String title,boolean modal,VehicleVO vo) {
//		super(frame,title,modal);
//		this.vo=vo;
//		initTable();
//		init();
//		registerListener();
//		this.setVisible(true);
//	}
//	private void initTable(){
//		//假设的数据
//		String[] inDepotName = new String[]{" "," "};
//		String [][] inDepotValue={{"车牌号：",vo.getPlateNumber()},{"服役时间：",vo.getDate()}};
//		DefaultTableModel tableModel = new DefaultTableModel(inDepotValue,inDepotName);
//		
//		Jtabel = new JTable(tableModel){
//			public boolean isCellEditable(int row, int column){
//				return false;
//			}
//		};
//		Jtabel.setEnabled(false);
//		Jtabel.getTableHeader().setReorderingAllowed(false); //设置列不可重排
//		Jtabel.getTableHeader().setResizingAllowed(false);//设置列不可拖动
//				
//		Jtabel.setRowHeight(32);
//		Jtabel.setShowGrid(false);
//		TableColumn column = null;
//		column = Jtabel.getColumnModel().getColumn(0);
//		column.setPreferredWidth(180);
//		
//		column = Jtabel.getColumnModel().getColumn(1);
//		column.setPreferredWidth(200);
//		Jtabel.setFont(new Font("幼圆", Font.BOLD, 20));
//		Jtabel.setForeground(Color.white);
//		Jtabel.setOpaque(false); 
//		
//		Jtabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
//		
//		Jtabel.setOpaque(false); 
//		DefaultTableCellRenderer render = new DefaultTableCellRenderer();   
//		render.setOpaque(false);
//		
//		Jtabel.setDefaultRenderer(Object.class,render);
//		
//		JTableHeader header = Jtabel.getTableHeader();
//		header.setOpaque(false);
//		header.getTable().setOpaque(false);
//		
//		header.setDefaultRenderer(render); 
//		TableCellRenderer headerRenderer = header.getDefaultRenderer();
//		if (headerRenderer instanceof JLabel) {
//			((JLabel) headerRenderer).setHorizontalAlignment(JLabel.CENTER);
//			((JLabel) headerRenderer).setOpaque(false); 
//		}
//	}
//	private void init(){
//		scrollPane = new JScrollPane(Jtabel); 
//		scrollPane.getViewport().setOpaque(false);
//		scrollPane.setOpaque(false);
//		scrollPane.setViewportView(Jtabel);
//		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//        scrollPane.setColumnHeaderView(Jtabel.getTableHeader());
//        scrollPane.getColumnHeader().setOpaque(false);
//        scrollPane.setBounds(50,5,400,180);
//        this.add(scrollPane);
//        
//		ImageIcon yesIcon=new ImageIcon("picture/登录.png");
//		jPanel=new dialogJpanel();
//		
//		jButton=new JButton(yesIcon);
//		jButton.setContentAreaFilled(false);
//		jButton.setBounds(218,190, 64, 64);
//		jPanel.add(jButton);
//		jPanel.setLayout(null);
//		
//		this.add(jPanel);
//		this.setSize(500, 300);
//		Toolkit kitToolkit =Toolkit.getDefaultToolkit();
//		Dimension screenSize=kitToolkit.getScreenSize();
//		int screenWidth=screenSize.width;
//		int screenHeight=screenSize.height;
//		int dialogWidth=this.getWidth();
//		int dialogHeight=this.getHeight();
//		this.setLocation((screenWidth-dialogWidth)/2, (screenHeight-dialogHeight)/2);
//		this.setResizable(false);
//	}
//	private void registerListener(){
//		jButton.addActionListener(new ActionListener() {		
//			public void actionPerformed(ActionEvent e) {
//				CarInfoDialog.this.dispose();
//			}
//		});
//	}
//}