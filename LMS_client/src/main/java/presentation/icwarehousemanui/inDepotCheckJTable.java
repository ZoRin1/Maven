package presentation.icwarehousemanui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import vo.storageVO.SimpleInDepotInfVO;

public class inDepotCheckJTable {
	private JTable inDepotTable;
	private checkDepotPanel checkDepotPanel;
	private JScrollPane scrollPane;
	private ArrayList<SimpleInDepotInfVO> simpleInf;
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public inDepotCheckJTable(checkDepotPanel checkDepotPanel,ArrayList<SimpleInDepotInfVO> simpleInf){
		this.checkDepotPanel = checkDepotPanel;
		this.simpleInf=simpleInf;
		initTable();
		init();
	}
	private void init(){
        scrollPane = new JScrollPane(inDepotTable); 
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		scrollPane.setViewportView(inDepotTable);
        scrollPane.setColumnHeaderView(inDepotTable.getTableHeader());
        
        scrollPane.getColumnHeader().setOpaque(false);
		scrollPane.setBounds(0, 57, 723, 475);
        
        checkDepotPanel.add(scrollPane);
	}
	
	private void initTable(){

		String[] inDepotName = new String[]{" "," "," "," "," "};
		Object[][] 	inDepotValue = new Object[simpleInf.size()][5];
			for (int i = 0; i < simpleInf.size(); i++) {
				inDepotValue[i][0]=simpleInf.get(i).getInDepotNum();
				inDepotValue[i][1]=simpleInf.get(i).getAreaNum();
				inDepotValue[i][2]=simpleInf.get(i).getRowNum();
				inDepotValue[i][3]=simpleInf.get(i).getShelvesNum();
				inDepotValue[i][4]=simpleInf.get(i).getSositionNum();
			}	
		
//		TableModel tableModel = new TableModel(inDepotValue,inDepotName);
		DefaultTableModel tableModel = new DefaultTableModel(inDepotValue,inDepotName);
		inDepotTable = new JTable(tableModel){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		inDepotTable.setFont(new Font("幼圆",Font.BOLD,20));
		inDepotTable.getTableHeader().setReorderingAllowed(false); //设置列不可重排
		inDepotTable.getTableHeader().setResizingAllowed(false); //设置列不可拖动
		
		inDepotTable.setRowHeight(32);
		inDepotTable.setShowGrid(false);
		TableColumn column = null;
		column = inDepotTable.getColumnModel().getColumn(0);
		column.setPreferredWidth(238);
		column = inDepotTable.getColumnModel().getColumn(1);
		column.setPreferredWidth(122);
		column = inDepotTable.getColumnModel().getColumn(2);
		column.setPreferredWidth(122);
		column = inDepotTable.getColumnModel().getColumn(3);
		column.setPreferredWidth(122);
		column = inDepotTable.getColumnModel().getColumn(4);
		column.setPreferredWidth(122);
		
		
		inDepotTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		inDepotTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		
		inDepotTable.setOpaque(false); 
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();   
		render.setOpaque(false);
		
		inDepotTable.setDefaultRenderer(Object.class,render);
		
		JTableHeader header = inDepotTable.getTableHeader();
		header.setOpaque(false);
		header.getTable().setOpaque(false);
		
		header.setDefaultRenderer(render); 
		TableCellRenderer headerRenderer = header.getDefaultRenderer();
		if (headerRenderer instanceof JLabel) {
			((JLabel) headerRenderer).setHorizontalAlignment(JLabel.CENTER);
			((JLabel) headerRenderer).setOpaque(false); 
		}
	}
	
	private class TableModel extends DefaultTableModel{
		public boolean isCellEditable(int row, int column){
			return false;
		}
	}
}
