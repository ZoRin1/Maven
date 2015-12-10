package presentation.financialstaffui;

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

import vo.documentsVO.ReceiptVO;
import vo.financeVO.ProfitVO;

public class b1b1Jpanel1Jtable {
	
	private JTable shoukuanJtabel;
	private b1b1Jpanel1 b1b1Jpanel1;
	private JScrollPane scrollPane;
	private ArrayList<ReceiptVO> ReceiptList;
	
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public b1b1Jpanel1Jtable(b1b1Jpanel1 b1b1Jpanel1,ArrayList<ReceiptVO> ReceiptList){
		this.b1b1Jpanel1 = b1b1Jpanel1;
		this.ReceiptList = ReceiptList;
		initTable();
		init();
	}
	private void init(){
        scrollPane = new JScrollPane(shoukuanJtabel); 
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		scrollPane.setViewportView(shoukuanJtabel);
        scrollPane.setColumnHeaderView(shoukuanJtabel.getTableHeader());
        
        scrollPane.getColumnHeader().setOpaque(false);
		scrollPane.setBounds(0,32, 730, 540);
        
		b1b1Jpanel1.add(scrollPane);
	}
	
	private void initTable(){

		String[] inDepotName = new String[]{"收款单编号","收款日期","单据名","收款金额"};

		Object[][] inDepotValue = new Object[ReceiptList.size()][4];
		for(int i = 0 ; i < ReceiptList.size();i++){
				inDepotValue[i][0] = ReceiptList.get(i).getCode();
				inDepotValue[i][1] = ReceiptList.get(i).getDate();
				inDepotValue[i][2] = ReceiptList.get(i).getDoName();
				inDepotValue[i][3] = ReceiptList.get(i).getFund();
		}
	
		
		DefaultTableModel tableModel = new DefaultTableModel(inDepotValue,inDepotName);
		
		shoukuanJtabel = new JTable(tableModel){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		shoukuanJtabel.setFont(new Font("幼圆", Font.BOLD, 16));
		shoukuanJtabel.getTableHeader().setReorderingAllowed(false); //设置列不可重排
		shoukuanJtabel.getTableHeader().setResizingAllowed(false);//设置列不可拖动
		
		shoukuanJtabel.setRowHeight(32);
		shoukuanJtabel.setShowGrid(false);
		TableColumn column = null;
		column = shoukuanJtabel.getColumnModel().getColumn(0);
		column.setPreferredWidth(178);
		column = shoukuanJtabel.getColumnModel().getColumn(1);
		column.setPreferredWidth(182);
		column = shoukuanJtabel.getColumnModel().getColumn(2);
		column.setPreferredWidth(182);
		column = shoukuanJtabel.getColumnModel().getColumn(3);
		column.setPreferredWidth(182);
		
		
		shoukuanJtabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		shoukuanJtabel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		
		shoukuanJtabel.setOpaque(false); 
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();   
		render.setOpaque(false);
		
		shoukuanJtabel.setDefaultRenderer(Object.class,render);
		
		JTableHeader header = shoukuanJtabel.getTableHeader();
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
