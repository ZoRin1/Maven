package presentation.financialstaffui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import businesslogic.financebl.AccountManageModel.AccountManageBL;
import presentation.icwarehousemanui.checkDepotPanel;
import vo.financeVO.AccountVO;

public class b2b1Jpanel1JTable {
	
	private JTable accountJtabel;
	private b2b1Jpanel1 b2b1Jpanel1;
	private JScrollPane scrollPane;
	private ArrayList<AccountVO> accountInf;
	private JButton b2,b3,b4,b5;
	private int row;
	private DefaultTableModel tableModel;
	private b2financialstaffui b2financialstaffui;
	private String theName;
	private String theSums;
	
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public b2b1Jpanel1JTable(b2financialstaffui b2financialstaffui,b2b1Jpanel1 b2b1Jpanel1,ArrayList<AccountVO> accountInf,JButton b2,
			JButton b3,JButton b4,JButton b5){
		this.b2financialstaffui = b2financialstaffui;
		this.b2b1Jpanel1 = b2b1Jpanel1;
		this.accountInf = accountInf;
		this.b2 = b2;
		this.b3 = b3;
		this.b4 = b4;
		this.b5 = b5;
		initTable();
		init();
		registListener();
	}
	private void init(){
        scrollPane = new JScrollPane(accountJtabel); 
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		scrollPane.setViewportView(accountJtabel);
        scrollPane.setColumnHeaderView(accountJtabel.getTableHeader());
        
        scrollPane.getColumnHeader().setOpaque(false);
		scrollPane.setBounds(0,34, 730, 540);
        
		b2b1Jpanel1.add(scrollPane);
	}
	
	private void initTable(){
		//假设的数据
		String[] inDepotName = new String[]{"帐户名称","账户余额"};
		Object[][] inDepotValue = new Object[accountInf.size()][2];
		for(int i = 0 ; i <accountInf.size();i++){
			inDepotValue[i][0] = accountInf.get(i).getName();
			inDepotValue[i][1] = accountInf.get(i).getSums();
		}
		//假设的数据： 完善后要从数据库拿取数据来填写表格
		
		tableModel = new DefaultTableModel(inDepotValue,inDepotName);
		
		accountJtabel = new JTable(tableModel){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		accountJtabel.setFont(new Font("幼圆", Font.BOLD, 20));
		accountJtabel.getTableHeader().setReorderingAllowed(false); //设置列不可重排
		accountJtabel.getTableHeader().setResizingAllowed(false);//设置列不可拖动
		
		accountJtabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1){
					b2.setEnabled(true);
					b3.setEnabled(true);
					b4.setEnabled(true);
					b5.setEnabled(true);
					row = accountJtabel.getSelectedRow();
					System.out.println("row:"+row);
					String value = accountJtabel.getValueAt(row, 0).toString().trim();
					System.out.println(value);
					
					//下面实现对出入库单的调用！！！！
					
					//还要实现一个出入库单的dialog 来显示调用的出入库单
				}
			}
		});
		
		accountJtabel.setRowHeight(32);
		accountJtabel.setShowGrid(false);
		TableColumn column = null;
		column = accountJtabel.getColumnModel().getColumn(0);
		column.setPreferredWidth(361);
		column = accountJtabel.getColumnModel().getColumn(1);
		column.setPreferredWidth(366);
		
		
		accountJtabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		accountJtabel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		
		accountJtabel.setOpaque(false); 
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();   
		render.setOpaque(false);
		
		accountJtabel.setDefaultRenderer(Object.class,render);
		
		JTableHeader header = accountJtabel.getTableHeader();
		header.setOpaque(false);
		header.getTable().setOpaque(false);
		
		header.setDefaultRenderer(render); 
		TableCellRenderer headerRenderer = header.getDefaultRenderer();
		if (headerRenderer instanceof JLabel) {
			((JLabel) headerRenderer).setHorizontalAlignment(JLabel.CENTER);
			((JLabel) headerRenderer).setOpaque(false); 
		}
	}
	private void registListener(){
		b2.addActionListener(new ActionListener() {
			//删除账户的监听
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
     			accountInf.remove(row);
     			tableModel.removeRow(row);
     			b2.setEnabled(false);
				b3.setEnabled(false);
				b5.setEnabled(false);
			}
		});
		b3.addActionListener(new ActionListener() {
			//修改账户的监听
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				new xiugaiDialog(b2financialstaffui);
				tableModel.setValueAt(theName, row, 0);//修改JTable里指定的值
				accountInf.get(row).setName(theName);//修改arrayList里指定的值
			}
		});
		b4.addActionListener(new ActionListener() {
			//新增账户监听
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				new xinzengDialog(b2financialstaffui);
				String []rowValues = {theName,theSums};
				tableModel.addRow(rowValues);
				AccountVO vo = new AccountVO(theName, Double.parseDouble(theSums));
				accountInf.add(vo);
			}
		});
		b5.addActionListener(new ActionListener() {
			//初始化账户监听
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				new chushihuaDialog(b2financialstaffui);
				tableModel.setValueAt(theName, row, 0);
				tableModel.setValueAt(theSums, row, 1);
				accountInf.get(row).setName(theName);
				accountInf.get(row).setSums(Double.parseDouble(theSums));
			}
		});
		
	}
	private class xiugaiDialog{
		JDialog xiugai;
		JPanel dialogPanel;
		JLabel newName;
		JTextField inputName;
		JButton jButton;
		Font font=new Font("幼圆", Font.BOLD, 20);
		ImageIcon yesIcon=new ImageIcon("picture/登录.png");
		public xiugaiDialog(JFrame ui){
			xiugai = new JDialog(ui,"修改界面",true);
			xiugai.setBounds(500, 500, 400, 250);
			xiugai.setLocationRelativeTo(null);
			
			newName = new JLabel();
			newName.setText("请输入新名称:");
			newName.setFont(font);
			newName.setForeground(Color.white);
			newName.setBounds(10, 50, 150, 24);
			
			inputName = new JTextField();
			inputName.setFont(font);
			inputName.setForeground(Color.white);
			inputName.setOpaque(false);
			inputName.setBounds(160, 50, 150, 24);
			
			jButton=new JButton(yesIcon);
			jButton.setContentAreaFilled(false);
			jButton.setBounds(160, 120, 64, 64);
			jButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO 自动生成的方法存根
					if(inputName.getText().equals("")){
						new panduanDialog(b2financialstaffui);
						return;
					}
					theName = inputName.getText();
					b2.setEnabled(false);
					b3.setEnabled(false);
					b5.setEnabled(false);
					xiugai.dispose();
				}
			});
			
			dialogPanel = new beijingPanel();
			dialogPanel.setLayout(null);
			
			xiugai.setContentPane(dialogPanel);
			xiugai.setUndecorated(true);
			dialogPanel.add(newName);
			dialogPanel.add(inputName);
			dialogPanel.add(jButton);
			xiugai.setVisible(true);
		}
	}
	private class xinzengDialog{
		JDialog xinzeng;
		JPanel dialogPanel;
		JLabel newName,newSums;
		JTextField inputName,inputSums;
		JButton jButton;
		Font font=new Font("幼圆", Font.BOLD, 20);
		ImageIcon yesIcon=new ImageIcon("picture/登录.png");
		public xinzengDialog(JFrame ui){
			xinzeng = new JDialog(ui,"修改界面",true);
			xinzeng.setBounds(500, 500, 400, 250);
			xinzeng.setLocationRelativeTo(null);
			
			newName = new JLabel();
			newName.setText("请输入名称:");
			newName.setFont(font);
			newName.setForeground(Color.white);
			newName.setBounds(10, 50, 150, 24);
			
			newSums = new JLabel();
			newSums.setText("请输入余额:");
			newSums.setFont(font);
			newSums.setForeground(Color.white);
			newSums.setBounds(10,90, 150, 24);
			
			inputName = new JTextField();
			inputName.setFont(font);
			inputName.setForeground(Color.white);
			inputName.setOpaque(false);
			inputName.setBounds(160, 50, 150, 24);
			
			inputSums = new JTextField();
			inputSums.setFont(font);
			inputSums.setForeground(Color.white);
			inputSums.setOpaque(false);
			inputSums.setBounds(160,90, 150, 24);
			inputSums.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e){
					int keyChar = e.getKeyChar();
					if(keyChar>=KeyEvent.VK_0&&keyChar<=KeyEvent.VK_9||keyChar==KeyEvent.VK_PERIOD){
					}else{
						e.consume();
					}
				}
			});
			
			jButton=new JButton(yesIcon);
			jButton.setContentAreaFilled(false);
			jButton.setBounds(160,150, 64, 64);
			jButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO 自动生成的方法存根
					if(inputName.getText().equals("")||inputSums.getText().equals("")){
						new panduanDialog(b2financialstaffui);
						return;
					}
					String[] temp = inputSums.getText().split("\\.");
					if(temp.length>2){
						new geshiDialog(b2financialstaffui);
						return;
					}
					theName = inputName.getText();
					theSums = inputSums.getText();
					b2.setEnabled(false);
					b3.setEnabled(false);
					b5.setEnabled(false);
					xinzeng.dispose();
				}
			});
			
			dialogPanel = new beijingPanel();
			dialogPanel.setLayout(null);
			
			xinzeng.setContentPane(dialogPanel);
			xinzeng.setUndecorated(true);
			dialogPanel.add(newName);
			dialogPanel.add(newSums);
			dialogPanel.add(inputName);
			dialogPanel.add(inputSums);
			dialogPanel.add(jButton);
			
			xinzeng.setVisible(true);
		}
	}
	private class chushihuaDialog{
		JDialog chushihua;
		JPanel dialogPanel;
		JLabel newName,newSums;
		JTextField inputName,inputSums;
		JButton jButton;
		Font font=new Font("幼圆", Font.BOLD, 20);
		ImageIcon yesIcon=new ImageIcon("picture/登录.png");
		public chushihuaDialog(JFrame ui){
			chushihua = new JDialog(ui,"修改界面",true);
			chushihua.setBounds(500, 500, 400, 250);
			chushihua.setLocationRelativeTo(null);
			
			newName = new JLabel();
			newName.setText("请输入新名称:");
			newName.setFont(font);
			newName.setForeground(Color.white);
			newName.setBounds(10, 50, 150, 24);
			
			newSums = new JLabel();
			newSums.setText("请输入新余额:");
			newSums.setFont(font);
			newSums.setForeground(Color.white);
			newSums.setBounds(10,90, 150, 24);
			
			inputName = new JTextField();
			inputName.setFont(font);
			inputName.setForeground(Color.white);
			inputName.setOpaque(false);
			inputName.setBounds(160, 50, 150, 24);
			
			inputSums = new JTextField();
			inputSums.setFont(font);
			inputSums.setForeground(Color.white);
			inputSums.setOpaque(false);
			inputSums.setBounds(160,90, 150, 24);
			inputSums.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e){
					int keyChar = e.getKeyChar();
					if(keyChar>=KeyEvent.VK_0&&keyChar<=KeyEvent.VK_9||keyChar==KeyEvent.VK_PERIOD){
					}else{
						e.consume();
					}
				}
			});
			
			jButton=new JButton(yesIcon);
			jButton.setContentAreaFilled(false);
			jButton.setBounds(160,150, 64, 64);
			jButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO 自动生成的方法存根
					if(inputName.getText().equals("")||inputSums.getText().equals("")){
						new panduanDialog(b2financialstaffui);
						return;
					}
					String[] temp = inputSums.getText().split("\\.");
					if(temp.length>2){
						new geshiDialog(b2financialstaffui);
						return;
					}
					theName = inputName.getText();
					theSums = inputSums.getText();
					b2.setEnabled(false);
					b3.setEnabled(false);
					b5.setEnabled(false);
					chushihua.dispose();
				}
			});
			
			dialogPanel = new beijingPanel();
			dialogPanel.setLayout(null);
			
			chushihua.setContentPane(dialogPanel);
			chushihua.setUndecorated(true);
			dialogPanel.add(newName);
			dialogPanel.add(newSums);
			dialogPanel.add(inputName);
			dialogPanel.add(inputSums);
			dialogPanel.add(jButton);
			chushihua.setVisible(true);
		}
	}
	private class panduanDialog{
		JDialog panduan;
		JPanel dialogPanel;
		JLabel newName;
		JButton jButton;
		Font font=new Font("幼圆", Font.BOLD, 20);
		ImageIcon yesIcon=new ImageIcon("picture/登录.png");
		public panduanDialog(JFrame ui){
			panduan = new JDialog(ui,"修改界面",true);
			panduan.setBounds(500, 500, 400, 250);
			panduan.setLocationRelativeTo(null);
			
			newName = new JLabel();
			newName.setText("<html>您的输入为空！请重新输入！</html>");
			newName.setFont(font);
			newName.setForeground(Color.white);
			newName.setBounds(60, 0, 400, 150);
			
			jButton=new JButton(yesIcon);
			jButton.setContentAreaFilled(false);
			jButton.setBounds(160,150, 64, 64);
			jButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO 自动生成的方法存根
					panduan.dispose();
				}
			});
			
			dialogPanel = new beijingPanel();
			dialogPanel.setLayout(null);
			
			panduan.setContentPane(dialogPanel);
			panduan.setUndecorated(true);
			dialogPanel.add(newName);
			dialogPanel.add(jButton);
			panduan.setVisible(true);
		}
	}
	private class geshiDialog{
		JDialog geshi;
		JPanel dialogPanel;
		JLabel newName;
		JButton jButton;
		Font font=new Font("幼圆", Font.BOLD, 20);
		ImageIcon yesIcon=new ImageIcon("picture/登录.png");
		public geshiDialog(JFrame ui){
			geshi = new JDialog(ui,"修改界面",true);
			geshi.setBounds(500, 500, 400, 250);
			geshi.setLocationRelativeTo(null);
			
			newName = new JLabel();
			newName.setText("余额输入格式错误！请重新输入！");
			newName.setFont(font);
			newName.setForeground(Color.white);
			newName.setBounds(35,60,350, 24);
			
			jButton=new JButton(yesIcon);
			jButton.setContentAreaFilled(false);
			jButton.setBounds(160,150, 64, 64);
			jButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO 自动生成的方法存根
					geshi.dispose();
				}
			});
			
			dialogPanel = new beijingPanel();
			dialogPanel.setLayout(null);
			
			geshi.setContentPane(dialogPanel);
			geshi.setUndecorated(true);
			dialogPanel.add(newName);
			dialogPanel.add(jButton);
			geshi.setVisible(true);
		}
	}
	private class beijingPanel extends JPanel{
		ImageIcon beijing = new ImageIcon("picture/小背景.png");
		public beijingPanel(){
			
		}
		public void paintComponent(Graphics g){
			g.drawImage(beijing.getImage(), 0, 0, null);
		}
	}
}
