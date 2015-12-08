package presentation.financialstaffui;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import po.documentsPO.ReceiptPO;

public class b4Jpanel2JTable {
	
	private MyTable billsJtabel;
	private b4Jpanel2 b4Jpanel2;
	private JScrollPane scrollPane;
	
	private ArrayList<ReceiptPO> receiptList;
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public b4Jpanel2JTable(b4Jpanel2 b4Jpanel2,ArrayList<ReceiptPO> receiptList){
		this.receiptList = receiptList;
		this.b4Jpanel2 = b4Jpanel2;
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
		scrollPane.setBounds(0,35, 730, 540);
        
		b4Jpanel2.add(scrollPane);
	}
	
	private void initTable(){
		//假设的数据
		String[] inDepotName = new String[]{" "," "," "," "," "," "};
		
		Object[][] inDepotValue = new Object[][]{{"楚留","2321","dfsd","sdsd","sdsad","dsdsd"},
				{"楚留奇","232134 KB","dfsd","sdsd","sdsad","dsdsd"},
			{"楚留奇","2324 KB","dfsd","sdsd","sdsad","dsdsd"},
					{"楚香传奇","2324 KB","dfsd","sdsd","sdsad","dsdsd"},
				{"楚奇","232134 KB","dfsd","sdsd","sdsad","dsdsd"}
					};
		Object[][] inDepotValue1 = new Object[receiptList.size()][6];
//		for(int i = 0 ; i <receiptList.size();i++){
//			inDepotValue[i][0] = receiptList.get(i).getCode();
//			inDepotValue[i][1] = receiptList.get(i).getDoName();
//			inDepotValue[i][2] = receiptList.get(i).getDate();
//			inDepotValue[i][3] = receiptList.get(i).getAccount();
//			inDepotValue[i][4] = receiptList.get(i).getFund();
//			inDepotValue[i][5] = receiptList.get(i).getCode();
//		}
		Object[] o1 = new Object[receiptList.size()];
		Object[] o2 = new Object[receiptList.size()];
		Object[] o3 = new Object[receiptList.size()];
		Object[] o4 = new Object[receiptList.size()];
		Object[] o5 = new Object[receiptList.size()];
		Object[] o6 = new Object[receiptList.size()];
		for(int i = 0 ; i < receiptList.size();i++)
			o1[i] = receiptList.get(i).getCode();
		for(int i = 0 ; i < receiptList.size();i++)
			o2[i] = receiptList.get(i).getDoName();
		for(int i = 0 ; i < receiptList.size();i++)
			o3[i] = receiptList.get(i).getDate();
		for(int i = 0 ; i < receiptList.size();i++)
			o4[i] = receiptList.get(i).getAccount();
		for(int i = 0 ; i < receiptList.size();i++)
			o5[i] = receiptList.get(i).getFund();
		for(int i = 0 ; i < receiptList.size();i++)
			o6[i] = "点击查看所有";
		
//		String [] values = new String[] {"1","2","3"};
		
		
		//假设的数据： 完善后要从数据库拿取数据来填写表格
		
//		DefaultTableModel tableModel = new DefaultTableModel(inDepotValue,inDepotName);
		
		billsJtabel = new MyTable(){
			public boolean isCellEditable(int row, int column){
				if(column==5)
					return true;
				else
					return false;
			}
		};
		DefaultTableModel tableModel = (DefaultTableModel) billsJtabel.getModel();
		tableModel.addColumn(" ",o1);
		tableModel.addColumn(" ",o2);
		tableModel.addColumn(" ",o3);
		tableModel.addColumn(" ",o4);
		tableModel.addColumn(" ",o5);
		tableModel.addColumn(" ",o6);
		
		
		for(int i = 0 ; i < receiptList.size();i++){
			String[] values = new String[receiptList.get(i).getTCode().size()];
			for(int j = 0 ; j < values.length;j++){
				values[j] = receiptList.get(i).getTCode().get(j);
			}
			billsJtabel.setComboCell(i, 5, new MyComboBoxEditor(values));
		}
		billsJtabel.setFont(new Font("幼圆", Font.BOLD, 14));
		billsJtabel.getTableHeader().setReorderingAllowed(false); //设置列不可重排
		billsJtabel.getTableHeader().setResizingAllowed(false);//设置列不可拖动
		
		billsJtabel.setRowHeight(32);
		billsJtabel.setShowGrid(true);
		TableColumn column = null;
		column = billsJtabel.getColumnModel().getColumn(0);
		column.setPreferredWidth(142);
		column = billsJtabel.getColumnModel().getColumn(1);
		column.setPreferredWidth(110);
		column = billsJtabel.getColumnModel().getColumn(2);
		column.setPreferredWidth(110);
		column = billsJtabel.getColumnModel().getColumn(3);
		column.setPreferredWidth(146);
		column = billsJtabel.getColumnModel().getColumn(4);
		column.setPreferredWidth(110);
		column = billsJtabel.getColumnModel().getColumn(5);
		column.setPreferredWidth(107);
		
		
		
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
	
	//----------------表体table------------------
	private class MyTable extends JTable{
		 int myRow=-1,myCol=-1;
		 TableCellEditor myEditor;//边框编辑器
		 
		 public void setComboCell(int row,int col,TableCellEditor editor){
			  this.myRow=row;
			  this.myCol=col;
			  this.myEditor=editor;
			 }
		 
		 public TableCellEditor getCellEditor(int row,int col){
			  if(row==myRow&&col==myCol&&myEditor!=null)
			   return myEditor;
			  return super.getCellEditor(row,col);
			 }
		 
		  /**
		   * 返回数据类型
		   */
		  public Class getColumnClass(int myCol) {
		   return getValueAt(0, myCol).getClass();
		  }
	}
	
	//-----------------------下拉编辑器-----------------------
	private class MyComboBoxEditor extends DefaultCellEditor{
	 
	 private static final long serialVersionUID = 1L;
	 public MyComboBoxEditor(JCheckBox checkBox) {
	  super(checkBox);
	 }
	 public MyComboBoxEditor(String[] value){
	  super(new JComboBox(value));
	 }
	}
	class MyCheckBoxEditor extends DefaultCellEditor{
	 public MyCheckBoxEditor(JCheckBox checkBox) {
	  super(checkBox);
	 }
	 
	 public MyCheckBoxEditor() {
	  super(new JCheckBox());
	 }
	 
	 /**
	  * 
	  */
	 private static final long serialVersionUID = 1L;
	 
	}
	
}
