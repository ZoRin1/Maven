package presentation.courierui;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import businesslogic.documentsbl.documentController;


public class documentJtable {
	private documentController documentController;
	private JTable billsJtabel;
	private documentJpanel documentJpanel;
	private JScrollPane scrollPane;
	private String account;
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public documentJtable(documentJpanel documentJpanel,String account){
		this.account=account;
		this.documentJpanel = documentJpanel;
		initTable();
		init();
	}
	private void init(){
        scrollPane = new JScrollPane(billsJtabel); 
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		scrollPane.setViewportView(billsJtabel);
        scrollPane.setColumnHeaderView(billsJtabel.getTableHeader());
        scrollPane.setFont(new Font("幼圆", Font.BOLD, 20));
        scrollPane.getColumnHeader().setOpaque(false);
		scrollPane.setBounds(0,32, 730, 540);
        
		documentJpanel.add(scrollPane);
	}
	
	private void initTable(){
		String[] inDepotName = new String[]{" "," "};
		documentController=new documentController();
		ArrayList<String>codeNameList= documentController.showOwnList(account);
		Object[][] inDepotValue;
		if (codeNameList.size()==0) {
			inDepotValue=new Object[0][0];
		}
		else {
			 inDepotValue = new Object[codeNameList.size()][2];
			for (int i = 0; i < codeNameList.size(); i++) {
				String[] string=codeNameList.get(i).split(",");
				inDepotValue[i][0]=string[0];
				inDepotValue[i][1]=string[1];
			}
		}
		
		DefaultTableModel tableModel = new DefaultTableModel(inDepotValue,inDepotName);
		
		billsJtabel = new JTable(tableModel){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		
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
