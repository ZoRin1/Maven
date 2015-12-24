package presentation.adminui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import businesslogic.accountbl.AccountInfoController;
import vo.accountVO.AccountNumberVO;

public class SearchAccount extends JPanel {
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private MyTable accountTable;
	private String[][]data={{"",""},{"",""},{"",""}};
	private String[] columnNames = {"账号","姓名"};
	private JButton returnButton;
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	
	public SearchAccount(final adminui aui,final adminJpanel apl,String[]accounts){
		
		init(accounts,aui,apl,this);
		apl.add(this);
		registListener(aui, apl, this);
	}
	
	private void init(String[] accounts,final adminui aui,final adminJpanel apl,final SearchAccount searchAccount) {
		String[]temp = accounts[0].split("-");
		data[0][0] = temp[0];
		data[0][1] = temp[1];
		accountTable = new MyTable(data,columnNames);
		Font font = new Font("幼圆", Font.BOLD, 25);
		accountTable.setForeground(Color.GRAY);
		accountTable.setFont(font);
		accountTable.getTableHeader().setFont(font);
		accountTable.setRowHeight(40);
		accountTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		accountTable.getColumnModel().getColumn(0).setPreferredWidth(240);
		accountTable.getColumnModel().getColumn(1).setPreferredWidth(240);
		accountTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		accountTable.setSelectionForeground(Color.BLACK);
		accountTable.getTableHeader().setFont(new Font("宋体", Font.BOLD, 20));
		final JScrollPane jsp = new JScrollPane(accountTable);
		jsp.setBounds(150, 180, 482, 200);
		
		//监听表格
		accountTable.addMouseListener(new MouseAdapter() {
			
			 public void mouseClicked(MouseEvent e) {
				 if(e.getClickCount()==2){
					
				
					aui.setTitle("账号详细信息");
					apl.remove(searchAccount);
					aui.searchButton.setEnabled(false);
					aui.addaccountButton.setEnabled(false);
					aui.accountField.setEditable(false);
					
					//真正使用时去掉
		        	//暂时不用
					int r = accountTable.getSelectedRow();
					long ID = Long.parseLong(data[r][0]);
					try {
						AccountInfoController accountInfoController = new AccountInfoController();
						AccountNumberVO accountNumberVO = accountInfoController.getInfo(ID);   
															
						new AccountInfo(aui,apl, accountNumberVO);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						new InternetDialog(aui);
					}
					aui.repaint();
			 }
		}
		});		
		this.add(jsp);
		
		
		returnButton=new JButton(returnIcon);
		returnButton.setBounds(662, 575,48,48);
		returnButton.setContentAreaFilled(false);
		this.add(returnButton);
		
		this.setBounds(260, 60, 730,650);	
	 	this.setLayout(null);
	 	this.setOpaque(false);	
		
		}
		
	
	private void registListener(final adminui aui,final adminJpanel apl,final SearchAccount searchAccount) {
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				apl.remove(searchAccount);
				apl.add(aui.operationJpanel);
				aui.accountField.setEditable(true);
				aui.searchButton.setEnabled(true);
				aui.addaccountButton.setEnabled(true);
				
				aui.repaint();
				
			}
		});
		
	}
	
	
	public void paintComponent(Graphics g)  
	{  
			super.paintComponent(g);    
			g.drawImage(frameIcon.getImage(),-7,-12,null);
	 }
	

}
