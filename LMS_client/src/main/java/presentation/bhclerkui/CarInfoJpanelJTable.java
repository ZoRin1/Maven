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
	private String state;
	private DefaultTableModel tableModel;
	private int row;
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	
	public CarInfoJpanelJTable(bhclerkui ui,bhclerkJpanel panel,CarInfoJpanel CarInfoJpanel,String state){
		this.ui=ui;
		this.state=state;
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
		final String stateString[]=state.split("-");
		String[] inDepotName = new String[]{" "};
		String[] list=new BhclerkController().getVehicleList(stateString[4]+"-"+stateString[5]);
		String [][]inDepotValue;
		if (list==null) {
			inDepotValue=new String[0][1];
		}else {
			inDepotValue=new String[list.length][1];
			for(int i=0;i<list.length;i++){
				inDepotValue[i][0]=list[i];
			}
		}
		tableModel = new DefaultTableModel(inDepotValue,inDepotName);
		
		carInfTable = new JTable(tableModel){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		carInfTable.setFont(new Font("幼圆", Font.BOLD, 24));
		carInfTable.getTableHeader().setReorderingAllowed(false); //设置列不可重排
		carInfTable.getTableHeader().setResizingAllowed(false); //设置列不可拖动
		//对双击的监听
		carInfTable.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2){
					row = carInfTable.getSelectedRow();
					String value = carInfTable.getValueAt(row, 0).toString().trim();
					VehicleVO info=new BhclerkController().getVehicleInfo(stateString[4]+"-"+stateString[5], value);
				    panel.remove(CarInfoJpanel);
					new CarInfoJpanel2(ui, panel, CarInfoJpanel, info, state,tableModel,row);
					panel.repaint();
					//监听的具体实现
				}
			}
		});
		
		carInfTable.setRowHeight(31);
		carInfTable.setShowGrid(false);
		TableColumn column = null;
		column = carInfTable.getColumnModel().getColumn(0);
		column.setPreferredWidth(725);
//		column = carInfTable.getColumnModel().getColumn(1);
//		column.setPreferredWidth(310);
		
		
		carInfTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		carInfTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		
		carInfTable.setOpaque(false); 
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();   
		render.setOpaque(false);
		
		carInfTable.setDefaultRenderer(Object.class,render);
		
		JTableHeader header = carInfTable.getTableHeader();
		header.setSize(725, 27);
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
