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
	private String state;
	private bhclerkJpanel panel;
	DefaultTableModel tableModel;
	private int row;
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	
	public DriverInfoJpanelJTable(bhclerkui ui,bhclerkJpanel panel,DriverInfoJpanel DriverInfoJpanel,String state){
		this.state=state;
		this.ui=ui;
		this.panel=panel;
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
		String stateString[]=state.split("-");
		String[] list=new BhclerkController().getDriverList(stateString[4]+"-"+stateString[5]);
		String [][] inDepotValue = null;
		if (list==null) {
			inDepotValue=new String[0][1];
		}else {
			inDepotValue=new String[list.length][1];
			for(int i=0;i<list.length;i++){
				inDepotValue[i][0]=list[i];
			}
		}
		//假设的数据： 完善后要从数据库拿取数据来填写表格
		
		tableModel = new DefaultTableModel(inDepotValue,inDepotName);
		
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
					row = driverInfTable.getSelectedRow();
					String value = driverInfTable.getValueAt(row, 0).toString().trim();
					String stateString[]=state.split("-");
					panel.remove(DriverInfoJpanel);
					new DriverInfoJpanel2(ui, panel, DriverInfoJpanel, new BhclerkController().getDriverInfo(stateString[4]+"-"+stateString[5], value),state,tableModel,row);
					panel.repaint();
					//监听的具体实现
				}
			}
		});
		
		driverInfTable.setRowHeight(32);
		driverInfTable.setShowGrid(false);
		TableColumn column = null;
		column = driverInfTable.getColumnModel().getColumn(0);
		column.setPreferredWidth(452);

		
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
