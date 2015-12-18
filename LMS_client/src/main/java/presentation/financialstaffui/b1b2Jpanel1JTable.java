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

import vo.financeVO.ProfitVO;

public class b1b2Jpanel1JTable {
	
	private JTable ProfitJtabel;
	private b1b2Jpanel1 b1b2Jpanel1;
	private JScrollPane scrollPane;
	private ArrayList<ProfitVO> profitList;
	
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public b1b2Jpanel1JTable(b1b2Jpanel1 b1b2Jpanel1,ArrayList<ProfitVO> profitList){
		this.b1b2Jpanel1 = b1b2Jpanel1;
		this.profitList = profitList;
		initTable();
		init();
	}
	private void init(){
        scrollPane = new JScrollPane(ProfitJtabel); 
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		scrollPane.setViewportView(ProfitJtabel);
        scrollPane.setColumnHeaderView(ProfitJtabel.getTableHeader());
        
        scrollPane.getColumnHeader().setOpaque(false);
		scrollPane.setBounds(0,32, 730, 540);
        
		b1b2Jpanel1.add(scrollPane);
	}
	
	private void initTable(){

		String[] inDepotName = new String[]{"总收入","总支出","生成时间","成本收益"};

		Object[][] inDepotValue = new Object[profitList.size()][4];
		for(int i = 0 ; i < profitList.size();i++){
				inDepotValue[i][0] = profitList.get(i).getTotalRevenue();
				inDepotValue[i][1] = profitList.get(i).getTotalPay();
				inDepotValue[i][2] = profitList.get(i).getGenerationDate();
				double count = profitList.get(i).getTotalRevenue() - profitList.get(i).getTotalPay();
				inDepotValue[i][3] =count;
			
		}
	
		
		DefaultTableModel tableModel = new DefaultTableModel(inDepotValue,inDepotName);
		
		ProfitJtabel = new JTable(tableModel){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		ProfitJtabel.setFont(new Font("幼圆", Font.BOLD, 14));
		ProfitJtabel.getTableHeader().setReorderingAllowed(false); //设置列不可重排
		ProfitJtabel.getTableHeader().setResizingAllowed(false);//设置列不可拖动
		
		ProfitJtabel.setRowHeight(32);
		ProfitJtabel.setShowGrid(false);
		TableColumn column = null;
		column = ProfitJtabel.getColumnModel().getColumn(0);
		column.setPreferredWidth(178);
		column = ProfitJtabel.getColumnModel().getColumn(1);
		column.setPreferredWidth(182);
		column = ProfitJtabel.getColumnModel().getColumn(2);
		column.setPreferredWidth(182);
		column = ProfitJtabel.getColumnModel().getColumn(3);
		column.setPreferredWidth(182);
		
		
		ProfitJtabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		ProfitJtabel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		
		ProfitJtabel.setOpaque(false); 
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();   
		render.setOpaque(false);
		
		ProfitJtabel.setDefaultRenderer(Object.class,render);
		
		JTableHeader header = ProfitJtabel.getTableHeader();
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
