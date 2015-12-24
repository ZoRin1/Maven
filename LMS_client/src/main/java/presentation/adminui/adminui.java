package presentation.adminui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

import javax.naming.InitialContext;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businesslogic.accountbl.AccountInfoController;
import businesslogic.financebl.AccountManageModel.addAccountBL;
import presentation.mainui.mainui;
import presentation.senderui.senderui;
import vo.accountVO.AccountNumberVO;

public class adminui extends JFrame{
			private String[] args;
			JTextField accountField;
			JButton searchButton;
			private JLabel accountJLabel;
			JButton addaccountButton;
			private adminJpanel adminJpanel;
			adminOperationJpanel operationJpanel;
			JButton outjButton;
			private JButton tuichuButton;
			private JButton zuixiaohuaButton;

			public adminui(String s,String[] args) {
				// TODO Auto-generated constructor stub
				super(s);
				this.args=args;
				init();
				registListener(this,adminJpanel);
			}
			private void init() {
				// TODO Auto-generated method stub
				ImageIcon outIcon=new ImageIcon("picture/退出登录.png");
				ImageIcon searchIcon=new ImageIcon("picture/搜索.png");
				ImageIcon addaccountIcon=new ImageIcon("picture/新增帐号.png");
				ImageIcon tuichuIcon=new ImageIcon("picture/退出.png");
				ImageIcon zuixiaohuaIcon=new ImageIcon("picture/最小化.png");
				zuixiaohuaButton=new JButton(zuixiaohuaIcon);
				zuixiaohuaButton.setBounds(904, 0, 50, 50);
				zuixiaohuaButton.setContentAreaFilled(false);
				zuixiaohuaButton.setBorderPainted(false);
				tuichuButton=new JButton(tuichuIcon);
				tuichuButton.setBounds(974, 0, 50, 50);
				tuichuButton.setContentAreaFilled(false);
				tuichuButton.setBorderPainted(false);
				accountField=new JTextField();
				accountField.addKeyListener(new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
						int keyChar=e.getKeyChar();
						if ((keyChar>=KeyEvent.VK_0 && keyChar<=KeyEvent.VK_9 )) {

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
				accountField.setOpaque(false);
				accountField.setFont(new Font("幼圆",Font.BOLD,24));
				accountField.setForeground(Color.white);
				accountJLabel=new JLabel("请输入帐号");
				searchButton=new JButton(searchIcon);
				addaccountButton=new JButton(addaccountIcon);
				addaccountButton.setBounds(30, 430, 200, 48);
				addaccountButton.setContentAreaFilled(false);
				outjButton=new JButton(outIcon);
				adminJpanel=new adminJpanel();
				operationJpanel=new adminOperationJpanel(adminJpanel);
				accountJLabel.setBounds(30, 150, 200, 30);
				accountField.setBounds(30, 200, 200, 30);
				searchButton.setBounds(180, 250, 48, 48);
				searchButton.setContentAreaFilled(false);

				outjButton.setBounds(30, 650, 48,48);
				outjButton.setContentAreaFilled(false);
				accountJLabel.setFont(new Font("幼圆",Font.BOLD, 20));
				accountJLabel.setForeground(Color.white);
				
				adminJpanel.add(outjButton);
				adminJpanel.add(accountJLabel);
				adminJpanel.add(addaccountButton);
				adminJpanel.add(accountField);
				adminJpanel.add(searchButton);
				adminJpanel.add(tuichuButton);
				adminJpanel.add(zuixiaohuaButton);
								
				adminJpanel.setLayout(null);
				this.add(adminJpanel);
				this.setSize( 1024, 730);
				//居中
				Toolkit kitToolkit =Toolkit.getDefaultToolkit();
				Dimension screenSize=kitToolkit.getScreenSize();
				int screenWidth=screenSize.width;
				int screenHeight=screenSize.height;
				int windowWidth=this.getWidth();
				int windowHeight=this.getHeight();
				this.setLocation((screenWidth-windowWidth)/2, (screenHeight-windowHeight)/2);
				//不允许窗口改变大小
				
				
				
				this.setUndecorated(true);
				this.setResizable(false);
				this.setVisible(true);
			}
			private void registListener(final adminui aui,final adminJpanel apl){
				zuixiaohuaButton.addMouseListener(new MouseAdapter() {
					ImageIcon zuixiaohuaIcon=new ImageIcon("picture/最小化.png");
					ImageIcon zuixiaohuaIcon2=new ImageIcon("picture/最小化2.png");
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						zuixiaohuaButton.setIcon(zuixiaohuaIcon);
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						zuixiaohuaButton.setIcon(zuixiaohuaIcon2);
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						aui.setExtendedState(JFrame.ICONIFIED);
					}
				});
				tuichuButton.addMouseListener(new MouseAdapter() {
					ImageIcon tuichuIcon=new ImageIcon("picture/退出.png");
					ImageIcon tuichuIcon2=new ImageIcon("picture/退出2.png");
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						System.exit(0);	
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						tuichuButton.setIcon(tuichuIcon);
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						tuichuButton.setIcon(tuichuIcon2);
					}
				});
				outjButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
					new mainui().main(args);
					aui.dispose();
					}
				});
				
		addaccountButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				apl.remove(aui.operationJpanel);
				aui.searchButton.setEnabled(false);
				aui.addaccountButton.setEnabled(false);
				aui.accountField.setEditable(false);

				new AddAccount(aui, apl);
				aui.repaint();
			}
		}

		);
		
		
		searchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//暂时不用，正常使用时启用
				String Id = accountField.getText();			
				if (!Id.equals("")) {
					if (Id.charAt(0)!='0') {
						long ID = Long.parseLong(Id);
						try {
							AccountInfoController accountInfoController = new AccountInfoController();
							String[] result = accountInfoController.getAccount(ID);
//						String[]temp = {"1002356-杨华安"};
							if (result != null) {
								apl.remove(aui.operationJpanel);
								aui.searchButton.setEnabled(false);
								aui.addaccountButton.setEnabled(false);
								aui.accountField.setText("");
								aui.accountField.setEditable(false);
								new SearchAccount(aui, apl, result);
								aui.repaint();
							}else{
								JOptionPane.showMessageDialog(aui, "未找到账号，请重新输入");
							}
						} catch (HeadlessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							new InternetDialog(aui);
						}
					}else {
						JOptionPane.showMessageDialog(aui, "请输入账号");
					}					
				}else {
					JOptionPane.showMessageDialog(aui, "请输入账号");
				}
				
			}
		});
			}
}

