package presentation.topmanagerui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellEditor;

import businesslogic.documentsbl.documentController;
import presentation.adminui.MyTable;
import presentation.adminui.adminui;

public class b3JPanel extends JPanel {
	
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JTable table;
	private String[][] data;
	private String[] columnsName = {"单据编号","单据种类","审批状态"};
	private JButton yesButton,returnButton;
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	private ImageIcon yesIcon=new ImageIcon("picture/确定.png");
	private ArrayList<String> pass = new ArrayList<>();
	private ArrayList<String> dispass = new ArrayList<>();
	
	public b3JPanel(topmanagerui tui,topmanagerJpanel tjpl) {
		// TODO Auto-generated constructor stub
		init(tui, tjpl);	
		registListener(tui, tjpl, this);
		tjpl.add(this);
	}
	private void init(topmanagerui tui,topmanagerJpanel tjpl){
		documentController documentController = new documentController();
		ArrayList<String> documents = documentController.showList();
		
			data = new String[documents.size()][3];
			
			for(int i = 0; i < documents.size(); i ++){
				String[] temp = documents.get(i).split(",");
				data[i][0] = temp[0];
				data[i][1] = temp[1];
				data[i][2] = "";
			}
			
			table = new JTable(data,columnsName);
			Font font = new Font("幼圆", Font.BOLD, 20);
			table.setForeground(Color.GRAY);
			table.setFont(font);
			table.getTableHeader().setFont(font);
			table.setRowHeight(25);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.getColumnModel().getColumn(0).setPreferredWidth(160);
			table.getColumnModel().getColumn(1).setPreferredWidth(160);
			table.getColumnModel().getColumn(2).setPreferredWidth(160);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setSelectionForeground(Color.BLACK);
			table.getTableHeader().setFont(new Font("宋体", Font.BOLD, 20));	
			
			//监听表格			
			String[] chooses = {"通过","返工"};
	    	final JComboBox jc = new JComboBox(chooses);
	    	jc.setSelectedIndex(-1);
	    	TableCellEditor te = new DefaultCellEditor(jc);
	    	table.getColumnModel().getColumn(2).setCellEditor(te);

			table.addMouseListener(new MouseAdapter() {				
				 public void mouseClicked(MouseEvent e) {
					 if(e.getClickCount()==1){										
						int r = table.getSelectedRow();
						JOptionPane.showMessageDialog(null, "单据详情，待会儿完成");						
				 }
			}
			});		
			
			final JScrollPane jsp = new JScrollPane(table);
			jsp.setBounds(150, 180, 482, 200);
			this.add(jsp);
		
			yesButton=new JButton(yesIcon);
			yesButton.setBounds(300, 480,48,48);
			yesButton.setContentAreaFilled(false);	 	 	
		 	this.add(yesButton);
			
			returnButton=new JButton(returnIcon);		
			returnButton.setBounds(400, 480,48,48);
			returnButton.setContentAreaFilled(false);
			this.add(returnButton);
			
			
			
			this.setBounds(260, 60, 730,650);	 	
			
		 	this.setLayout(null);
			this.setOpaque(false);	
	
		
		
		
		
		
	}
	
	
	private void registListener(final topmanagerui tui,final topmanagerJpanel tjpl,final b3JPanel b3jpl) {
		
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tjpl.remove(b3jpl);
				tjpl.add(tui.operationJpanel);
				tui.b1.setEnabled(true);
				tui.b2.setEnabled(true);
				tui.b3.setEnabled(true);
				tui.b4.setEnabled(true);
				tui.b5.setEnabled(true);
				tjpl.repaint();
			}
		});
		
		yesButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				documentController documentController = new documentController();
				for(int i = 0; i < data.length;i ++){
					String state = (String) table.getValueAt(i, 2);
					boolean b = false;
					if (state.equals("通过")) {
						b = true;
					}
					documentController.examined(data[i][0], data[i][1], b);
				}
				tjpl.remove(b3jpl);
				new b3JPanel(tui, tjpl);
				tjpl.repaint();
			}
		});
		
	}
	
	public void paintComponent(Graphics g)  
	{  
			super.paintComponent(g);    
			g.drawImage(frameIcon.getImage(),-7,-12,null);
	 }
}