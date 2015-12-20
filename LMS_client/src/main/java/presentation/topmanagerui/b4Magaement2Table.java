package presentation.topmanagerui;

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

import vo.documentsVO.PaymentVO;
import vo.documentsVO.ReceiptVO;

public class b4Magaement2Table {
	
	private JTable fukuanJtabel;
	private b4Managment2 b1b1Jpanel2;
	private JScrollPane scrollPane;
	private ArrayList<PaymentVO> PayList;
	
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public b4Magaement2Table(b4Managment2 b1b1Jpanel2,ArrayList<PaymentVO> PayList){
		this.b1b1Jpanel2 = b1b1Jpanel2;
		this.PayList = PayList;
		initTable();
		init();
	}
	private void init(){
        scrollPane = new JScrollPane(fukuanJtabel); 
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		scrollPane.setViewportView(fukuanJtabel);
        scrollPane.setColumnHeaderView(fukuanJtabel.getTableHeader());
        
        scrollPane.getColumnHeader().setOpaque(false);
		scrollPane.setBounds(0,32, 730, 540);
        
		b1b1Jpanel2.add(scrollPane);
	}
	
	private void initTable(){

		String[] inDepotName = new String[]{"收款单编号","收款日期","单据名","收款金额"};

		Object[][] inDepotValue = new Object[PayList.size()][4];
		for(int i = 0 ; i < PayList.size();i++){
				inDepotValue[i][0] = PayList.get(i).getCode();
				inDepotValue[i][1] = PayList.get(i).getDate();
				inDepotValue[i][2] = PayList.get(i).getDoName();
				inDepotValue[i][3] = PayList.get(i).getFund();
		}
	
		
		DefaultTableModel tableModel = new DefaultTableModel(inDepotValue,inDepotName);
		
		fukuanJtabel = new JTable(tableModel){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		fukuanJtabel.setFont(new Font("幼圆", Font.BOLD, 16));
		fukuanJtabel.getTableHeader().setReorderingAllowed(false); //设置列不可重排
		fukuanJtabel.getTableHeader().setResizingAllowed(false);//设置列不可拖动
		
		fukuanJtabel.setRowHeight(32);
		fukuanJtabel.setShowGrid(false);
		TableColumn column = null;
		column = fukuanJtabel.getColumnModel().getColumn(0);
		column.setPreferredWidth(178);
		column = fukuanJtabel.getColumnModel().getColumn(1);
		column.setPreferredWidth(182);
		column = fukuanJtabel.getColumnModel().getColumn(2);
		column.setPreferredWidth(182);
		column = fukuanJtabel.getColumnModel().getColumn(3);
		column.setPreferredWidth(182);
		
		
		fukuanJtabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		fukuanJtabel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		
		fukuanJtabel.setOpaque(false); 
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();   
		render.setOpaque(false);
		
		fukuanJtabel.setDefaultRenderer(Object.class,render);
		
		JTableHeader header = fukuanJtabel.getTableHeader();
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
