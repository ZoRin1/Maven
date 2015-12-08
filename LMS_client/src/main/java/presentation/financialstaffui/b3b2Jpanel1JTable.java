package presentation.financialstaffui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class b3b2Jpanel1JTable {
	
	private JTable billsJtabel;
	private b3b2Jpanel1 b3b2Jpanel1;
	private JScrollPane scrollPane;
	
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public b3b2Jpanel1JTable(b3b2Jpanel1 b3b2Jpanel1){
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
		
		Object[][] inDepotValue = new Object[][]{{"楚留","2321"},
				{"楚留奇","232134 KB"},
			{"楚留奇","2324 KB"},
					{"楚香传奇","2324 KB"},
				{"楚奇","232134 KB"}
					};
		//假设的数据： 完善后要从数据库拿取数据来填写表格
		
		DefaultTableModel tableModel = new DefaultTableModel(inDepotValue,inDepotName);
		
		billsJtabel = new JTable(tableModel){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
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
