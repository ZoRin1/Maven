package presentation.bhclerkui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class dialogJpanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon dialogIcon=new ImageIcon("picture/对话框背景.png");
	public void paintComponent(Graphics g)  
	{  
	    super.paintComponent(g);    
	    g.drawImage(dialogIcon.getImage(),0,0,null);
      
     }
}
//单独用于装车单的dialog,当输入没有问题时弹出
class finishDialog extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private dialogJpanel jPanel;
	private JLabel jLabel;
	private JLabel jLabel1;
	private JButton jButton;
	private String str;
	public finishDialog(JFrame frame,String title,boolean modal,String str) {
		super(frame,title,modal);
		this.str=str;
		init();
		registerListener();
		this.setVisible(true);
	}
	private void init(){
		ImageIcon yesIcon=new ImageIcon("picture/登录.png");
		jLabel=new JLabel("装车单创建完成",jLabel.CENTER);
		jLabel.setForeground(Color.white);
		jLabel.setFont(new Font("幼圆",Font.BOLD,27));
		jLabel.setBounds(0, 0, 500, 200);
		
		jLabel1=new JLabel("运费："+str+"元",jLabel.CENTER);
		jLabel1.setForeground(Color.white);
		jLabel1.setFont(new Font("幼圆",Font.BOLD,27));
		jLabel1.setBounds(0, 60, 500, 200);
		
		jButton=new JButton(yesIcon);
		jButton.setContentAreaFilled(false);
		jButton.setBounds(218,190, 64, 64);
		
		jPanel=new dialogJpanel();
		jPanel.setLayout(null);
		jPanel.add(jLabel);
		jPanel.add(jLabel1);
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
				finishDialog.this.dispose();
			}
		});
	}
}
//所有单据输入不完整时均会弹出
class notFinishDialog extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private dialogJpanel jPanel;
	private JLabel jLabel;
	private JLabel jLabel1;
	private JButton jButton;
	public notFinishDialog(JFrame frame,String title,boolean modal) {
		super(frame,title,modal);
		init();
		registerListener();
		this.setVisible(true);
	}
	private void init(){
		ImageIcon yesIcon=new ImageIcon("picture/登录.png");
		jLabel=new JLabel("您的输入不完整，请检查补充",jLabel.CENTER);
		jLabel.setForeground(Color.white);
		jLabel.setFont(new Font("幼圆",Font.BOLD,27));
		jLabel.setBounds(0, 0, 500, 200);
		
		jButton=new JButton(yesIcon);
		jButton.setContentAreaFilled(false);
		jButton.setBounds(218,190, 64, 64);
		
		jPanel=new dialogJpanel();
		jPanel.setLayout(null);
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
				notFinishDialog.this.dispose();
			}
		});
	}
}

//当输入的东西在数据库中应该有保存但检测中没有时出现，含订单条形码号，城市（转运单中到达地），营业厅（营业厅装车单中为到达地），收款单中的快递员
class notFindDialog extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private dialogJpanel jPanel;
	private JLabel jLabel;
	private JLabel jLabel1;
	private JButton jButton;
	private String str;
	public notFindDialog(JFrame frame,String title,boolean modal,String str1) {
		super(frame,title,modal);
		str=str1;
		init();
		registerListener();
		this.setVisible(true);
	}
	private void init(){
		ImageIcon yesIcon=new ImageIcon("picture/登录.png");
		jLabel=new JLabel("您所输入的"+str+"不存在",jLabel.CENTER);
		jLabel.setForeground(Color.white);
		jLabel.setFont(new Font("幼圆",Font.BOLD,27));
		jLabel.setBounds(0, 0, 500, 200);
		
		jButton=new JButton(yesIcon);
		jButton.setContentAreaFilled(false);
		jButton.setBounds(218,190, 64, 64);
		
		jPanel=new dialogJpanel();
		jPanel.setLayout(null);
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
				notFindDialog.this.dispose();
			}
		});
	}
}
//收款单，车辆信息，司机信息创建完成时显示
class finishDialog2 extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private dialogJpanel jPanel;
	private JLabel jLabel;
	private JButton jButton;
	private String doName;
	public finishDialog2(JFrame frame,String title,boolean modal,String doName) {
		super(frame,title,modal);
		this.doName=doName;
		init();
		registerListener();
		this.setVisible(true);
	}
	private void init(){
		ImageIcon yesIcon=new ImageIcon("picture/登录.png");
		jLabel=new JLabel(doName+"创建完成",jLabel.CENTER);
		jLabel.setForeground(Color.white);
		jLabel.setFont(new Font("幼圆",Font.BOLD,27));
		jPanel=new dialogJpanel();
		jButton=new JButton(yesIcon);
		jButton.setContentAreaFilled(false);
		jPanel.setLayout(null);
		jButton.setBounds(218,190, 64, 64);
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
				finishDialog2.this.dispose();
			}
		});
	}
}
//添加车辆信息或司机信息时如果车辆编号或司机编号已存在，则显示此对话框
class OverWriteDialog extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private dialogJpanel jPanel;
	private JLabel jLabel;
	private JButton jButton;
	private String str;
	public OverWriteDialog(JFrame frame,String title,boolean modal,String str) {
		super(frame,title,modal);
		this.str=str;
		init();
		registerListener();
		this.setVisible(true);
	}
	private void init(){
		ImageIcon yesIcon=new ImageIcon("picture/登录.png");
		jLabel=new JLabel(str+"编号已存在，请检查后重新输入",jLabel.CENTER);
		jLabel.setForeground(Color.white);
		jLabel.setFont(new Font("幼圆",Font.BOLD,27));
		jLabel.setBounds(0, 0, 500, 200);
		
		jButton=new JButton(yesIcon);
		jButton.setContentAreaFilled(false);
		jButton.setBounds(218,190, 64, 64);
		
		jPanel=new dialogJpanel();
		jPanel.setLayout(null);
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
				OverWriteDialog.this.dispose();
			}
		});
	}
}
//添加车辆或者司机时编号似乎是进行填写的，不是自动化的
class codeDialog extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private dialogJpanel jPanel;
	private JLabel jLabel;
	private JButton jButton;
	private String str;
	public codeDialog(JFrame frame,String title,boolean modal,String str) {
		super(frame,title,modal);
		this.str=str;
		init();
		registerListener();
		this.setVisible(true);
	}
	private void init(){
		ImageIcon yesIcon=new ImageIcon("picture/登录.png");
		jLabel=new JLabel(str+"编号为三位，格式不符，请检查",jLabel.CENTER);
		jLabel.setForeground(Color.white);
		jLabel.setFont(new Font("幼圆",Font.BOLD,27));
		jLabel.setBounds(0, 0, 500, 200);
		
		jButton=new JButton(yesIcon);
		jButton.setContentAreaFilled(false);
		jButton.setBounds(218,190, 64, 64);
		
		jPanel=new dialogJpanel();
		jPanel.setLayout(null);
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
				codeDialog.this.dispose();
			}
		});
	}
}
class InternetDialog extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private dialogJpanel jPanel;
	private JLabel jLabel;
	private JButton jButton;
	public InternetDialog(JFrame frame) {
		super(frame,"连接失败",true);
		init();
		registerListener();
		this.setVisible(true);
	}
	private void init(){
		ImageIcon yesIcon=new ImageIcon("picture/登录.png");
		jLabel=new JLabel("网络连接失败，系统退出，请检查网络",jLabel.CENTER);
		jLabel.setForeground(Color.white);
		jLabel.setFont(new Font("幼圆",Font.BOLD,27));
		jPanel=new dialogJpanel();
		jButton=new JButton(yesIcon);
		jButton.setContentAreaFilled(false);
		jPanel.setLayout(null);
		jButton.setBounds(218,190, 64, 64);
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
				System.exit(0);
			}
		});
	}
}