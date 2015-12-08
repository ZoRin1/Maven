package presentation.icwarehousemanui;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import vo.storageVO.InDepotInfVO;

public class stockDepotJTable {
	
	private JTable stockDepotTable;
	private stockDepotPanel stockDepotPanel;
	private JScrollPane scrollPane;
	
	private ArrayList<InDepotInfVO> VOList;
	
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	
	public stockDepotJTable(stockDepotPanel stockDepotPanel,ArrayList<InDepotInfVO> VOList){
		this.VOList = VOList;
		this.stockDepotPanel = stockDepotPanel;
		initTable();
		init();
	}
	
	private void init(){
        scrollPane = new JScrollPane(stockDepotTable); 
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		scrollPane.setViewportView(stockDepotTable);
        scrollPane.setColumnHeaderView(stockDepotTable.getTableHeader());
        
        scrollPane.getColumnHeader().setOpaque(false);
		scrollPane.setBounds(0, 57, 730, 475);
        
		stockDepotPanel.add(scrollPane);
	}
	
	private void initTable(){
		//假设的数据
		String[] inDepotName = new String[]{" "," "," "," "," "," "," "};
		
//		Object[][] inDepotValue1 = new Object[][]{{"楚留","2321","fyk","2012-07-","545","dfdf","wew"},
//				{"楚留奇","232134 KB","fykhlp","2012","455","sfdf","dfsd"},
//			{"楚留奇","2324 KB","fhlp","2012-07-2","454545","fdsf","dsf"},
//					{"楚香传奇","2324 KB","fykhlp","2012-07","455","dsad","dsad"},
//				{"楚奇","232134 KB","fykhlp","2012-07","455","dsada","sadad"}
//					};
		
		Object[][] inDepotValue = new Object[VOList.size()][7];
		for(int i = 0 ; i < VOList.size() ; i++){
			inDepotValue[i][0] = VOList.get(i).getInDepotNum();
			inDepotValue[i][1] = VOList.get(i).getInDepotDate();
			inDepotValue[i][2] = VOList.get(i).getDestination();
			inDepotValue[i][3] = VOList.get(i).getAreaNum();
			inDepotValue[i][4] = VOList.get(i).getRowNum();
			inDepotValue[i][5] = VOList.get(i).getShelvesNum();
			inDepotValue[i][6] = VOList.get(i).getSositionNum();
		}
		//假设的数据： 完善后要从数据库拿取数据来填写表格
		
		DefaultTableModel tableModel = new DefaultTableModel(inDepotValue,inDepotName);
		
		stockDepotTable = new JTable(tableModel){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		
		stockDepotTable.getTableHeader().setReorderingAllowed(false); //设置列不可重排
		stockDepotTable.getTableHeader().setResizingAllowed(false); //设置列不可拖动
		
		
		stockDepotTable.setRowHeight(32);
		stockDepotTable.setShowGrid(false);
		TableColumn column = null;
		column = stockDepotTable.getColumnModel().getColumn(0);
		column.setPreferredWidth(177);
		column = stockDepotTable.getColumnModel().getColumn(1);
		column.setPreferredWidth(91);
		column = stockDepotTable.getColumnModel().getColumn(2);
		column.setPreferredWidth(91);
		column = stockDepotTable.getColumnModel().getColumn(3);
		column.setPreferredWidth(91);
		column = stockDepotTable.getColumnModel().getColumn(4);
		column.setPreferredWidth(91);
		column = stockDepotTable.getColumnModel().getColumn(5);
		column.setPreferredWidth(91);
		column = stockDepotTable.getColumnModel().getColumn(6);
		column.setPreferredWidth(91);
		
		
		stockDepotTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		stockDepotTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		
		stockDepotTable.setOpaque(false); 
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();   
		render.setOpaque(false);
		
		stockDepotTable.setDefaultRenderer(Object.class,render);
		
		JTableHeader header = stockDepotTable.getTableHeader();
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
