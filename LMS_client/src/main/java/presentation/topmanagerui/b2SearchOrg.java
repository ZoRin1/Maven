package presentation.topmanagerui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ColorConvertOp;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import businesslogic.organizationbl.BusinessController;
import businesslogic.organizationbl.MiddleController;
import presentation.adminui.MyTable;
import presentation.adminui.NumberFieldListener;
import presentation.financialstaffui.financialstaffui;

public class b2SearchOrg extends JPanel {
	
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	ImageIcon searchIcon=new ImageIcon("picture/搜索.png");
	private JLabel tiShi;
	private JTextField orgF;
	private JButton search,returnButton;
	JButton b4;
	ImageIcon b4Icon=new ImageIcon("picture/新建.png");
	private String orgs;
	private String[][]data={{"",""}};
	private String[] columnNames = {"机构编号","机构名称"};
	private MyTable orgTable;
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	
	public b2SearchOrg(b2topmanagerui b2ui,topmanagerJpanel tjpl,String org){
		init(b2ui, tjpl, this, org);
		tjpl.add(this);
		registListener(b2ui, tjpl, this, org);
	}
	
	private void init(final b2topmanagerui b2ui,final topmanagerJpanel tjpl,final b2SearchOrg b2SearchOrg,String org){
		
		
		Font font = new Font("幼圆", Font.BOLD, 30);
		
		tiShi = new JLabel("请输入" + org + "编号");
		tiShi.setFont(font);
		tiShi.setForeground(Color.WHITE);
		tiShi.setBounds(185, 100, 300, 50);
		this.add(tiShi);
		
		orgF = new JTextField();
		orgF.setOpaque(false);
		orgF.setFont(font);
		orgF.setForeground(Color.WHITE);
		orgF.setBounds(185, 160, 200, 50);
		this.add(orgF);
		
		search = new JButton(searchIcon);
		search.setFont(font);
		search.setContentAreaFilled(false);
		search.setBounds(395, 160, 48, 48);
		this.add(search);
		
		b4=new JButton(b4Icon);		
		b4.setContentAreaFilled(false);
		b4.setBorderPainted(false);
		b4.setBounds(235,480,208, 58);
		this.add(b4);
		
		returnButton=new JButton(returnIcon);
		returnButton.setBounds(662, 575,48,48);
		returnButton.setContentAreaFilled(false);
		this.add(returnButton);
		
		
		this.setBounds(260, 60, 730,650);	
	 	this.setLayout(null);
	 	this.setOpaque(false);
		
	}

	private void registListener(final b2topmanagerui b2ui,final topmanagerJpanel tjpl,
			final b2SearchOrg b2SearchOrg,final String org) {
		
		if (org.equals("营业厅")) {
			orgF.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					int keyChar=e.getKeyChar();
					if ((keyChar>=KeyEvent.VK_0 && keyChar<=KeyEvent.VK_9 )||keyChar == KeyEvent.VK_MINUS) {

					} else {
					e.consume(); 
					}
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}else{
			orgF.addKeyListener(new NumberFieldListener());
		}
		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tjpl.remove(b2SearchOrg);
				if(org.equals("营业厅")){
					new b2BusinessAdd(b2ui, tjpl, org);
				}else {
					new b2MiddleAdd(b2ui, tjpl, org);
				}
				
				tjpl.repaint();
			}
		});
		search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Font font = new Font("幼圆", Font.BOLD, 30);
				final String input = orgF.getText();
				if (!input.equals("")) {
					if(org.equals("营业厅")){
						if (DataCheck.isBusinessCOde(input)) {
							BusinessController businessController = null;
							try {
								businessController = new BusinessController();
							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
								new InternetDialog(b2ui);
							}
							orgs = businessController.getInfo(input);	
						}else{
							new DisplayDialog(b2ui, "请输入正确的营业厅编号，形如“001-001”");
//							JOptionPane.showMessageDialog(null, "请输入正确的营业厅编号，形如“001-001”");
						}
								
					}else{
						MiddleController middleController = null;
						try {
							middleController = new MiddleController();
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							new InternetDialog(b2ui);
						}
						orgs = middleController.GetInfo(input);
					}
					if (orgs != null) {
						data[0][1] = orgs + org;
						data[0][0] = input;
						orgTable = new MyTable(data,columnNames);
						orgTable.setForeground(Color.GRAY);
						orgTable.setFont(font);
						orgTable.getTableHeader().setFont(font);
						orgTable.setRowHeight(40);
						orgTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
						orgTable.getColumnModel().getColumn(0).setPreferredWidth(240);
						orgTable.getColumnModel().getColumn(1).setPreferredWidth(240);
						orgTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						orgTable.setSelectionForeground(Color.BLACK);
						orgTable.getTableHeader().setFont(new Font("宋体", Font.BOLD, 20));
						
						orgTable.addMouseListener(new MouseAdapter() {
							
							 public void mouseClicked(MouseEvent e) {
								 if(e.getClickCount()==2){
									 
									 int r = orgTable.getSelectedRow();
									 if (org.equals("营业厅")) {
										
										tjpl.remove(b2SearchOrg);

										b2ui.b1.setEnabled(false);
										b2ui.b2.setEnabled(false);
										b2ui.b3.setEnabled(false);

										new b2BusinessInfo(b2ui, tjpl, data[r][0]);
										tjpl.repaint();
										 
									}else {
									
											 tjpl.remove(b2SearchOrg);
											 
											b2ui.b1.setEnabled(false);
											b2ui.b2.setEnabled(false);
											b2ui.b3.setEnabled(false);
											new b2MiddleInfo(b2ui, tjpl, input);
											tjpl.repaint();
									
								 }
								 
								 }
							 }
						});
					
						final JScrollPane jsp = new JScrollPane(orgTable);
						jsp.setBounds(150, 220, 482, 200);
						
						b2SearchOrg.add(jsp);
					
					
						
					}else{
						if (org.equals("营业厅")) {
							new DisplayDialog(b2ui, "未找到，请重新输入营业厅编号");
//							JOptionPane.showMessageDialog(null, "未找到，请输入营业厅编号");
							tjpl.remove(b2SearchOrg);
							new b2SearchOrg(b2ui, tjpl, org);
							tjpl.repaint();
						}else {
							new DisplayDialog(b2ui, "未找到，请重新输入中转中心编号");
//							JOptionPane.showMessageDialog(null, "未找到，请输入中转中心编号");
							tjpl.remove(b2SearchOrg);
							new b2SearchOrg(b2ui, tjpl, org);
							tjpl.repaint();
						}
						
					}
				}else {
					if (org.equals("营业厅")) {
						new DisplayDialog(b2ui, "请输入营业厅编号，形如“001-001”");
//						JOptionPane.showMessageDialog(null, "请输入营业厅编号，形如“001-001”");
					}else {
						new DisplayDialog(b2ui, "请输入中转中心编号，形如“001”");
//						JOptionPane.showMessageDialog(null, "请输入中转中心编号，形如“001”");
					}
					
				}
				}
				
		});
		
		returnButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				tjpl.remove(b2SearchOrg);
				tjpl.add(b2ui.operationJpanel);

				b2ui.b1.setEnabled(true);
				b2ui.b2.setEnabled(true);
				b2ui.b3.setEnabled(true);
				

				b2ui.repaint();

			}
		});
		


	}
	public void paintComponent(Graphics g)  
	{  
			super.paintComponent(g);    
			g.drawImage(frameIcon.getImage(),-7,-12,null);
	 }
}
