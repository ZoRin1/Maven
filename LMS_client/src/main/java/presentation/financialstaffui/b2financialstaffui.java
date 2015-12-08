package presentation.financialstaffui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import vo.financeVO.AccountVO;
import businesslogic.financebl.AccountManageModel.AccountManageBL;

public class b2financialstaffui extends JFrame{
	 private financialstaffJpanel financialstaffJpanel;
	 financialstaffb2OperationJpanel operationJpanel;
	JButton b1;
	 JButton b2;
	 JButton b3;
	JButton b4;
	 JButton b5;
	 private JButton tuichuButton;
		private JButton zuixiaohuaButton;
		
		private AccountManageBL account;
		private ArrayList<AccountVO> accountInf;
	public b2financialstaffui(String s,financialstaffui fsui) {
		// TODO Auto-generated constructor stub
		super(s);
		getAccountVO();
		init(fsui);
		registListener(this,financialstaffJpanel);
	}
	private void registListener(
			final b2financialstaffui b2financialstaffui,
			final financialstaffJpanel financialstaffJpanel) {
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
				b2financialstaffui.setExtendedState(JFrame.ICONIFIED);
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
		// TODO Auto-generated method stub
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new b2b1Jpanel1(b2financialstaffui, financialstaffJpanel,accountInf,b2,b3,b4,b5);
				financialstaffJpanel.remove(operationJpanel);
//				b1.setEnabled(false);
				b2.setEnabled(false);
				b3.setEnabled(false);

				b5.setEnabled(false);
				financialstaffJpanel.remove(b1);
				financialstaffJpanel.add(b2);
				financialstaffJpanel.add(b3);
				financialstaffJpanel.add(b4);
				financialstaffJpanel.add(b5);
				financialstaffJpanel.repaint();
			}
		});

	}
	
	private void getAccountVO(){
//		accountInf = new ArrayList<AccountVO>();
//		AccountVO v1 = new AccountVO("张三", 100);
//		AccountVO v2 = new AccountVO("李四", 5252);
//		AccountVO v3 = new AccountVO("哈哈", 4272);
//		AccountVO v4 = new AccountVO("卧槽", 100);
//		AccountVO v5 = new AccountVO("尼玛", 100);
//		AccountVO v6 = new AccountVO("啦啦", 100);
//		AccountVO v7 = new AccountVO("矿泉水", 100);
//		accountInf.add(v1);
//		accountInf.add(v2);
//		accountInf.add(v3);
//		accountInf.add(v4);
//		accountInf.add(v5);
//		accountInf.add(v6);
//		accountInf.add(v7);
		account = new AccountManageBL();
		accountInf=new ArrayList<>();
		accountInf = account.getAccountInf();
	}
	
	private void init(financialstaffui fsui){
		financialstaffJpanel=new financialstaffJpanel();
		operationJpanel=new financialstaffb2OperationJpanel(financialstaffJpanel,fsui,this);
		ImageIcon b1Icon=new ImageIcon("picture/查询账户.png");
		ImageIcon b2Icon=new ImageIcon("picture/删除账户.png");
		ImageIcon b3Icon=new ImageIcon("picture/修改账户.png");
		ImageIcon b4Icon=new ImageIcon("picture/新增账户.png");
		ImageIcon b5Icon=new ImageIcon("picture/初始化账户.png");
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
		b1=new JButton(b1Icon);
		b2=new JButton(b2Icon);
		b3=new JButton(b3Icon);
		b4=new JButton(b4Icon);
		b5=new JButton(b5Icon);
		b1.setBounds(30, 130,200, 50);
		b2.setBounds(30, 230,200, 50);
		b3.setBounds(30, 330,200, 50);
		b4.setBounds(30, 430,200, 50);
		b5.setBounds(30, 530,200, 50);
		b1.setContentAreaFilled(false);
		b2.setContentAreaFilled(false);
		b3.setContentAreaFilled(false);
		b4.setContentAreaFilled(false);
		b5.setContentAreaFilled(false);

		financialstaffJpanel.add(b1);
//		financialstaffJpanel.add(b2);
//		financialstaffJpanel.add(b3);
//		financialstaffJpanel.add(b4);
//		financialstaffJpanel.add(b5);
		financialstaffJpanel.add(tuichuButton);
		financialstaffJpanel.add(zuixiaohuaButton);
		financialstaffJpanel.setLayout(null);

		this.add(financialstaffJpanel);
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
}
class financialstaffb2OperationJpanel extends JPanel{
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JButton returnButton;
	public financialstaffb2OperationJpanel(financialstaffJpanel financialstaffJpanel,financialstaffui fsui,b2financialstaffui b2fsui) {
		// TODO Auto-generated constructor stub
		init();
		financialstaffJpanel.add(this);
		registListener(fsui, b2fsui);
	}
	private void init(){
		ImageIcon returnIcon=new ImageIcon("picture/返回.png");
		returnButton=new JButton(returnIcon);
		returnButton.setBounds(662, 575, 48,48);
		returnButton.setContentAreaFilled(false);	
		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(260, 60,730,650);
		this.add(returnButton);
	}
	private void registListener(final financialstaffui fsui,final b2financialstaffui b2fsui){
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fsui.setVisible(true);
				b2fsui.dispose();
		
			}
		});
	}
	public void paintComponent(Graphics g)  
	{  
	    super.paintComponent(g);    
	    g.drawImage(frameIcon.getImage(),-7,-12,null);
     }
	
}