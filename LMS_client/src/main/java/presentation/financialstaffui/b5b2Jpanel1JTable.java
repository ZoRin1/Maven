package presentation.financialstaffui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import po.financePO.BooksPO;
public class b5b2Jpanel1JTable {
	
	private JTable booksJtabel;
	private b5b2Jpanel1 b5b2Jpanel1;
	private JScrollPane scrollPane;
	
	private ArrayList<BooksPO> bookList;
	private b5financialstaffui b5financialstaffui;
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public b5b2Jpanel1JTable(b5financialstaffui b5financialstaffui,b5b2Jpanel1 b5b2Jpanel1,ArrayList<BooksPO> bookList){
		this.b5financialstaffui = b5financialstaffui;
		this.bookList = bookList;
		this.b5b2Jpanel1 = b5b2Jpanel1;
		initTable();
		init();
	}
	private void init(){
        scrollPane = new JScrollPane(booksJtabel); 
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		scrollPane.setViewportView(booksJtabel);
        scrollPane.setColumnHeaderView(booksJtabel.getTableHeader());
        
        scrollPane.getColumnHeader().setOpaque(false);
		scrollPane.setBounds(0,35, 730, 540);
        
		b5b2Jpanel1.add(scrollPane);
	}
	
	private void initTable(){
		//假设的数据
		String[] inDepotName = new String[]{" "," "};
		
		Object[][] inDepotValue = new Object[bookList.size()][2];
		for(int i = 0 ; i < bookList.size();i++){
			inDepotValue[i][0] = bookList.get(i).getName();
			inDepotValue[i][1] = bookList.get(i).getDate();
			
		}
		//假设的数据： 完善后要从数据库拿取数据来填写表格
		
		DefaultTableModel tableModel = new DefaultTableModel(inDepotValue,inDepotName);
		
		booksJtabel = new JTable(tableModel){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		
		booksJtabel.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				if(e.getClickCount()==2){
					int row = booksJtabel.getSelectedRow();
					String value = booksJtabel.getValueAt(row, 0).toString().trim();
					BooksPO po = bookList.get(row);
					
					new booksDialog(b5financialstaffui,po);
					//获取里面的内容 并得到相应的数据 再通过dialog 显示出来！！！
					//获取里面的内容 并得到相应的数据 再通过dialog 显示出来！！！
					
				}
			}
		});
		booksJtabel.setFont(new Font("幼圆", Font.BOLD, 20));
		booksJtabel.getTableHeader().setReorderingAllowed(false); //设置列不可重排
		booksJtabel.getTableHeader().setResizingAllowed(false);//设置列不可拖动
		
		booksJtabel.setRowHeight(32);
		booksJtabel.setShowGrid(false);
		TableColumn column = null;
		column = booksJtabel.getColumnModel().getColumn(0);
		column.setPreferredWidth(361);
		column = booksJtabel.getColumnModel().getColumn(1);
		column.setPreferredWidth(362);
		
		
		booksJtabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		booksJtabel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		
		booksJtabel.setOpaque(false); 
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();   
		render.setOpaque(false);
		
		booksJtabel.setDefaultRenderer(Object.class,render);
		
		JTableHeader header = booksJtabel.getTableHeader();
		header.setOpaque(false);
		header.getTable().setOpaque(false);
		
		header.setDefaultRenderer(render); 
		TableCellRenderer headerRenderer = header.getDefaultRenderer();
		if (headerRenderer instanceof JLabel) {
			((JLabel) headerRenderer).setHorizontalAlignment(JLabel.CENTER);
			((JLabel) headerRenderer).setOpaque(false); 
		}
	}
	
	private class booksDialog{
		JDialog books;
		JPanel dialogPanel;
		JLabel newName;
		JButton jButton;
		
		Font font=new Font("幼圆", Font.BOLD, 20);
		ImageIcon yesIcon=new ImageIcon("picture/登录.png");
		

		MyTable booksTable;
		BooksPO po;
	    JScrollPane scrollPane1;
		public booksDialog(JFrame ui,BooksPO po){
			this.po = po;
			books = new JDialog(ui,"修改界面",true);
			books.setBounds(500, 500,730, 500);
			books.setLocationRelativeTo(null);
			
			newName = new JLabel();
			newName.setText("<html>账本详细信息</html>");
			newName.setFont(font);
			newName.setForeground(Color.white);
			newName.setBounds(320, 0, 400,50);
			
			
			jButton=new JButton(yesIcon);
			jButton.setContentAreaFilled(false);
			jButton.setBounds(355,418, 64, 64);
			jButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO 自动生成的方法存根
					books.dispose();
				}
			});
			
			dialogPanel = new beijingPanel();
			dialogPanel.setLayout(null);
			
			initTable();
			init();
			
			books.setContentPane(dialogPanel);
			books.setUndecorated(true);
			dialogPanel.add(newName);
			dialogPanel.add(jButton);
			books.setVisible(true);
		}
		
		private void init(){
			scrollPane1 = new JScrollPane(booksTable); 
			scrollPane1.getViewport().setOpaque(false);
			scrollPane1.setOpaque(false);
			scrollPane1.setViewportView(booksTable);
			scrollPane1.setColumnHeaderView(booksTable.getTableHeader());
	        
			scrollPane1.getColumnHeader().setOpaque(false);
			scrollPane1.setBounds(0,57, 730, 347);
	        
			dialogPanel.add(scrollPane1);
		}
		
		private void initTable(){
			//假设的数据
			Object[] o1 = po.getBussinessHallCode().split(",");
			Object[] o2 = po.getMiddleCode().split(",");
			Object[] o3 = po.getFinanceCode().split(",");
			Object[] o4 = po.getIDCode().split(",");
			Object[] o5 = po.getVehicleCode().split(",");
			Object[] o6 = po.getAccountName().split(",");
			
			//假设的数据： 完善后要从数据库拿取数据来填写表格
			
//			DefaultTableModel tableModel = new DefaultTableModel(inDepotValue,inDepotName);
			
			booksTable = new MyTable(){
				public boolean isCellEditable(int row, int column){
					return false;
				}
			};
			booksTable.setFont(new Font("幼圆", Font.BOLD,16));
			booksTable.setForeground(Color.white);
			
			DefaultTableModel tableModel = (DefaultTableModel) booksTable.getModel();
			tableModel.addColumn("机构编号",o1);
			tableModel.addColumn("中转中心编号",o2);
			tableModel.addColumn("营业厅编号",o3);
			tableModel.addColumn("人员编号",o4);
			tableModel.addColumn("车辆编号",o5);
			tableModel.addColumn("账户",o6);
			
			
			booksTable.getTableHeader().setReorderingAllowed(false); //设置列不可重排
			booksTable.getTableHeader().setResizingAllowed(false);//设置列不可拖动
			
			booksTable.setRowHeight(32);
			booksTable.setShowGrid(true);
			TableColumn column = null;
			column = booksTable.getColumnModel().getColumn(0);
			column.setPreferredWidth(146);
			column = booksTable.getColumnModel().getColumn(1);
			column.setPreferredWidth(146);
			column = booksTable.getColumnModel().getColumn(2);
			column.setPreferredWidth(145);
			column = booksTable.getColumnModel().getColumn(3);
			column.setPreferredWidth(145);
			column = booksTable.getColumnModel().getColumn(4);
			column.setPreferredWidth(145);
			column = booksTable.getColumnModel().getColumn(5);
			column.setPreferredWidth(145);
			
			
			booksTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			booksTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
			
			booksTable.setOpaque(false); 
			DefaultTableCellRenderer render = new DefaultTableCellRenderer();   
			render.setOpaque(false);
			
			booksTable.setDefaultRenderer(Object.class,render);
			
			JTableHeader header = booksTable.getTableHeader();
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
	
	private class beijingPanel extends JPanel{
		ImageIcon beijing = new ImageIcon("picture/小大背景.png");
		public beijingPanel(){
			
		}
		public void paintComponent(Graphics g){
			g.drawImage(beijing.getImage(), 0, 0, null);
		}
	}
}
