package presentation.mainui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import businesslogic.accountbl.AccountLoginController;
import businesslogic.documentsbl.documentController;
import presentation.adminui.adminui;
import presentation.bhclerkui.bhclerkui;
import presentation.courierui.courierui;
import presentation.financialstaffui.financialstaffui;
import presentation.icclerkui.icclerkui;
import presentation.icwarehousemanui.icwarehousemanui;
import presentation.senderui.senderui;
import presentation.topmanagerui.topmanagerui;

public class mainui  {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new mainFrame("物流管理系统",args);
	}
}
class mainFrame extends JFrame{
	private AccountLoginController accountLoginController;
	private documentController documentController;
	private JTextField codeJTextField; 
	private JTextField accountnumberJTextField;
	private JPasswordField passwordField;
	private JButton checkButton;
	private JButton loginButton;
	private JButton aboutButton;
	private JLabel numberIconJLabel;
	private JLabel numberJLabel,passwordJLabel,codeJLabel;
	private mainJpanel mainJPanel;
	private JLabel titleJLabel;
	private JButton tuichuButton;
	private JButton zuixiaohuaButton;
		public mainFrame(String s,String []args) {
			// TODO Auto-generated constructor stub
			super(s);
			init();
			//此方法为预览各个界面，之后删除
			preview(this,args);
			registerLister(this,args);
		}
		private void init() {
			ImageIcon titleIcon=new ImageIcon("picture/项目名.png");
			ImageIcon numberIcon=new ImageIcon("picture/帐号.png");
			ImageIcon logicIcon=new ImageIcon("picture/登录.png");
			ImageIcon checkIcon=new ImageIcon("picture/查询.png");
			ImageIcon aboutIcon=new ImageIcon("picture/关于.png");
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
			titleJLabel=new JLabel(titleIcon);
			titleJLabel.setBounds(0, 50, 1024, 150);
			numberIconJLabel=new JLabel(numberIcon);
			codeJTextField=new JTextField();
			codeJTextField.setOpaque(false);
			codeJTextField.setForeground(Color.white);
			codeJTextField.setFont(new Font("幼圆",Font.BOLD,24));
			accountnumberJTextField=new JTextField();
			accountnumberJTextField.setOpaque(false);
			accountnumberJTextField.setForeground(Color.white);
			accountnumberJTextField.setFont(new Font("幼圆",Font.BOLD,24));
			passwordField=new JPasswordField();
			passwordField.setOpaque(false);
			passwordField.setFont(new Font("幼圆",Font.BOLD,24));
			passwordField.setForeground(Color.white);
			passwordField.setEchoChar('*');
			checkButton=new JButton(checkIcon);
			loginButton=new JButton(logicIcon);
			aboutButton=new JButton(aboutIcon);
			aboutButton.setContentAreaFilled(false);
			loginButton.setContentAreaFilled(false);
			numberJLabel=new JLabel("帐号");
			passwordJLabel=new JLabel("密码");
			codeJLabel=new JLabel("物流查询");
			codeJLabel.setForeground(Color.white);
			codeJLabel.setFont(new Font("幼圆",Font.BOLD, 30));
			mainJPanel=new mainJpanel();
			numberJLabel.setFont(new Font("幼圆",Font.BOLD, 30));
			numberJLabel.setForeground(Color.white);
			passwordJLabel.setFont(new Font("幼圆",Font.BOLD, 30));
			passwordJLabel.setForeground(Color.white);

			checkButton.setContentAreaFilled(false);
			mainJPanel.setLayout(null);
			codeJTextField.setBounds(400, 270, 250, 30);
			codeJLabel.setBounds(250,270, 150, 30);
			accountnumberJTextField.setBounds(400, 400, 250, 30);
			passwordField.setBounds(400,460,250,30);
			checkButton.setBounds(710,250,64,64);
			loginButton.setBounds(590,520 , 64, 64);
			aboutButton.setBounds(840, 640, 150, 50);
			numberJLabel.setBounds(300, 400, 100, 30);
			numberIconJLabel.setBounds(220, 380,52, 52);
			passwordJLabel.setBounds(300, 460,100, 30);
			checkButton.setForeground(Color.RED);
			mainJPanel.add(numberIconJLabel);
			mainJPanel.add(codeJLabel);
			mainJPanel.add(codeJTextField);
			mainJPanel.add(accountnumberJTextField);
			mainJPanel.add(passwordField);
			mainJPanel.add(checkButton);
			mainJPanel.add(loginButton);
			mainJPanel.add(aboutButton);
			mainJPanel.add(numberJLabel);
			mainJPanel.add(passwordJLabel);
			mainJPanel.add(titleJLabel);
			mainJPanel.add(tuichuButton);
			mainJPanel.add(zuixiaohuaButton);
			this.setContentPane(mainJPanel);
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
			this.setResizable(false);
			this.setUndecorated(true);
			this.setVisible(true);
		}
		private void registerLister(final mainFrame mf,final String[] args) {
			accountnumberJTextField.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					int keyChar = e.getKeyChar();
					if (keyChar<=KeyEvent.VK_9&&keyChar>=KeyEvent.VK_0) {
						
					}else {
						e.consume();
					}
				}
			});
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
					 mf.setExtendedState(JFrame.ICONIFIED);
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
			
			loginButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub		
					if (accountnumberJTextField.getText().equals("")) {
						new loginFailDialog(mf, "登陆失败", true);
					}
					else {
						if(accountnumberJTextField.getText().charAt(0)=='0'){
							new loginFailDialog(mf, "登陆失败", true);
						}
						else {
							accountLoginController=new AccountLoginController();
							long ID=Long.parseLong(accountnumberJTextField.getText());
							String account=accountnumberJTextField.getText();
							String state=accountLoginController.login(ID, String.valueOf(passwordField.getPassword()));
							if (state==null) {
								new loginFailDialog(mf, "登陆失败", true);
							}
							else {
								String s[]=state.split("-");
								switch (s[0]) {
								case "1":
									new courierui("快递员界面",args,account,state);
									mf.dispose();
									break;
								case "2":
									new bhclerkui("营业厅业务员界面",args,account,state);
									mf.dispose();
									break;
								case "3":
								new icclerkui("中转中心业务员界面",args,account,state);
									mf.dispose();
									break;
								case "4":
									new icwarehousemanui("中转中心仓库管理员界面",args,account,state);
									mf.dispose();
									break;
								case "5":
									new financialstaffui("财务人员界面",args,account,state);
									mf.dispose();
									break;
			
								case "6":
									new topmanagerui("总经理界面",args);
									mf.dispose();
									break;
								case "7":
									new adminui("管理员界面",args);
									mf.dispose();
									break;
								default :
									new loginFailDialog(mf, "登陆失败", true);
									break;					
								}
							}
						}
					}			
				}
			});
			checkButton.addActionListener(new ActionListener() {			
				public void actionPerformed(ActionEvent e) {
					documentController=new documentController();
					ArrayList<String> wuliuInfoList=documentController.getWuliuInfo(codeJTextField.getText());
					// TODO Auto-generated method stub
					if (wuliuInfoList==null) {
						new checkFailDialog(mf, "查询失败", true);
					}
					else {
						new senderui("物流信息查询",args,wuliuInfoList);
						mf.dispose();
					}									
				}
			});
			aboutButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new aboutDialog(mf, "关于我们", true);
				}
			});
		}
//		此方法为预览各个界面，之后删除
		private void preview(final mainFrame mf,final String[] args){
			JLabel privewJLabel=new JLabel("预览界面");
			 JButton b1,b2,b3,b4,b5,b6,b7;
			b1=new JButton("admin");
			b2=new JButton("bhclerk");
			b3=new JButton("courier");
			b4=new JButton("financialstaff");
			b5=new JButton("icclerk");
			b6=new JButton("icwarehouseman");
			b7=new JButton("topmanager");
			mainJPanel.add(privewJLabel);
			mainJPanel.add(b1);
			mainJPanel.add(b2);
			mainJPanel.add(b3);
			mainJPanel.add(b4);
			mainJPanel.add(b5);
			mainJPanel.add(b6);
			mainJPanel.add(b7);
			privewJLabel.setBounds(420, 520, 200, 50);
			privewJLabel.setForeground(Color.white);
			privewJLabel.setFont(new Font("幼圆",Font.BOLD,36));
			b1.setBounds(150,600 , 80, 30);
			b2.setBounds(250,600 , 80, 30);
			b3.setBounds(350,600 , 80, 30);
			b4.setBounds(450,600 , 80, 30);
			b5.setBounds(550,600 , 80, 30);
			b6.setBounds(650,600 , 80, 30);
			b7.setBounds(750,600 , 80, 30);
b1.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					new adminui("管理员界面",args);
					mf.dispose();
				}
			});
b2.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					new bhclerkui("营业厅业务员界面",args,"111","3-南京-仙林营业厅-001-001");
					mf.dispose();
				}
			});
b3.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		new courierui("快递员界面",args,accountnumberJTextField.getText(),"");
		mf.dispose();
	}
});
b4.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		new financialstaffui("财务人员界面",args,"1515","");
		mf.dispose();
	}
});
b5.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		new icclerkui("中转中心业务员界面",args,"111","3-南京-南京中转中心-001");
		mf.dispose();
	}
});
b6.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		new icwarehousemanui("中转中心仓库管理员界面",args,"1515","4-南京-中转中心-001");
		mf.dispose();
	}
});
b7.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		new topmanagerui("总经理界面",args);
		mf.dispose();
	}
});
		}
}
class mainJpanel extends JPanel{
	private ImageIcon backgroundIcon=new ImageIcon("picture/背景.png");
	public void paintComponent(Graphics g)  
	{  
	    super.paintComponent(g);    
	    g.drawImage(backgroundIcon.getImage(),0,0,null);
      
     }
   }
class aboutDialog extends JDialog{
	private dialogJpanel jPanel;
	private JButton jButton;
	private JLabel jLabel;
	public aboutDialog(JFrame frame,String title,boolean modal) {
		super(frame,title,modal);
		init();
		registerListener();
		this.setVisible(true);
	}
	private void init(){
		ImageIcon yesIcon=new ImageIcon("picture/登录.png");
		jLabel=new JLabel("", JLabel.CENTER);
		jLabel.setText("<html>By:              <br> 杨关，杨华安，熊凯奇，王泽霖</html>"); 
		jLabel.setForeground(Color.white);
		jLabel.setFont(new Font("幼圆",Font.BOLD,27));
		jPanel=new dialogJpanel();
		jButton=new JButton(yesIcon);
		jButton.setContentAreaFilled(false);
		jPanel.setLayout(null);
		jButton.setBounds(218, 190, 64, 64);
		jLabel.setBounds(0, 0, 500, 200);
		jPanel.add(jLabel);
		jPanel.add(jButton);
		this.add(jPanel);
		this.setSize(500, 300);
		Toolkit kitToolkit =Toolkit.getDefaultToolkit();
		Dimension screenSize=kitToolkit.getScreenSize();
		int screenWidth=screenSize.width;
		int screenHeight=screenSize.height;
		int dialogWidth=this.getWidth();
		int dialogHeight=this.getHeight();
		this.setLocation((screenWidth-dialogWidth)/2, (screenHeight-dialogHeight)/2);
		this.setResizable(false);
	}
	private void registerListener(){
		jButton.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				aboutDialog.this.dispose();
			}
		});
	}
}
class dialogJpanel extends JPanel{
	private ImageIcon dialogIcon=new ImageIcon("picture/背景.png");
	public void paintComponent(Graphics g)  
	{  
	    super.paintComponent(g);    
	    g.drawImage(dialogIcon.getImage(),0,0,null);
      
     }
   }
class loginFailDialog extends JDialog{
	private dialogJpanel jPanel;
	private JButton jButton;
	private JLabel jLabel;
	public loginFailDialog(JFrame frame,String title,boolean modal) {
		super(frame,title,modal);
		init();
		registerListener();
		this.setVisible(true);
	}
	private void init(){
		ImageIcon yesIcon=new ImageIcon("picture/登录.png");
		jLabel=new JLabel("", JLabel.CENTER);
		jLabel.setText("<html>帐号或密码错误，请重新输入</html>"); 
		jLabel.setForeground(Color.white);
		jLabel.setFont(new Font("幼圆",Font.BOLD,27));
		jPanel=new dialogJpanel();
		jButton=new JButton(yesIcon);
		jButton.setContentAreaFilled(false);
		jPanel.setLayout(null);
		jButton.setBounds(218, 190, 64, 64);
		jLabel.setBounds(0, 0, 500, 200);
		jPanel.add(jLabel);
		jPanel.add(jButton);
		this.add(jPanel);
		this.setSize(500, 300);
		Toolkit kitToolkit =Toolkit.getDefaultToolkit();
		Dimension screenSize=kitToolkit.getScreenSize();
		int screenWidth=screenSize.width;
		int screenHeight=screenSize.height;
		int dialogWidth=this.getWidth();
		int dialogHeight=this.getHeight();
		this.setLocation((screenWidth-dialogWidth)/2, (screenHeight-dialogHeight)/2);
		this.setResizable(false);
	}
	private void registerListener(){
		jButton.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				loginFailDialog.this.dispose();
			}
		});
	}
}
class checkFailDialog extends JDialog{
	private dialogJpanel jPanel;
	private JButton jButton;
	private JLabel jLabel;
	public checkFailDialog(JFrame frame,String title,boolean modal) {
		super(frame,title,modal);
		init();
		registerListener();
		this.setVisible(true);
	}
	private void init(){
		ImageIcon yesIcon=new ImageIcon("picture/登录.png");
		jLabel=new JLabel("", JLabel.CENTER);
		jLabel.setText("<html>条形码号不存在，请重新输入</html>"); 
		jLabel.setForeground(Color.white);
		jLabel.setFont(new Font("幼圆",Font.BOLD,27));
		jPanel=new dialogJpanel();
		jButton=new JButton(yesIcon);
		jButton.setContentAreaFilled(false);
		jPanel.setLayout(null);
		jButton.setBounds(218, 190, 64, 64);
		jLabel.setBounds(0, 0, 500, 200);
		jPanel.add(jLabel);
		jPanel.add(jButton);
		this.add(jPanel);
		this.setSize(500, 300);
		Toolkit kitToolkit =Toolkit.getDefaultToolkit();
		Dimension screenSize=kitToolkit.getScreenSize();
		int screenWidth=screenSize.width;
		int screenHeight=screenSize.height;
		int dialogWidth=this.getWidth();
		int dialogHeight=this.getHeight();
		this.setLocation((screenWidth-dialogWidth)/2, (screenHeight-dialogHeight)/2);
		this.setResizable(false);
	}
	private void registerListener(){
		jButton.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				checkFailDialog.this.dispose();
			}
		});
	}
}