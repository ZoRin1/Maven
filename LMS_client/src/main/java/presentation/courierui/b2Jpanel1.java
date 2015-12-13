package presentation.courierui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import po.documentsPO.GetOrderPO;
import businesslogic.documentsbl.documentController;

public class b2Jpanel1 extends JPanel{
	private JLabel dingdantiaoxingmahaoJLabel;
	 JTextField dingdantiaoxingmahaoField;
	private JButton serchButton;
	private JLabel dingdantiaoxingmaJLabel;
	 JLabel dingdantiaoxingmanumJLabel;
	private ImageIcon serchIcon=new ImageIcon("picture/搜索.png");
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JButton returnButton;
	private JButton yesButton;
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	private ImageIcon yesIcon=new ImageIcon("picture/确定.png");
	private documentController documentController;
	private String account;
	public b2Jpanel1(courierui courierui,courierJpanel courierJpanel,String account) {
		// TODO Auto-generated constructor stub
		this.account=account;
		init();
	 	courierJpanel.add(this);
		registListener(courierui,courierJpanel,this);
	}
	private void init(){
		documentController=new documentController();
		Font font=new Font("幼圆", Font.BOLD, 20);
		dingdantiaoxingmahaoJLabel=new JLabel("订单条形码号:");
		dingdantiaoxingmahaoJLabel.setForeground(Color.white);
		dingdantiaoxingmahaoJLabel.setFont(font);
		dingdantiaoxingmahaoJLabel.setBounds(100, 150, 150, 30);
		dingdantiaoxingmahaoField=new JTextField();
		dingdantiaoxingmahaoField.setFont(font);
		dingdantiaoxingmahaoField.setBounds(280, 150, 300, 30);
		dingdantiaoxingmaJLabel=new JLabel("订单条形码号:");
		dingdantiaoxingmaJLabel.setForeground(Color.white);
		dingdantiaoxingmaJLabel.setFont(font);
		dingdantiaoxingmaJLabel.setBounds(100, 350, 150, 30);
		dingdantiaoxingmanumJLabel=new JLabel();
		dingdantiaoxingmanumJLabel.setForeground(Color.white);
		dingdantiaoxingmanumJLabel.setFont(font);
		dingdantiaoxingmanumJLabel.setBounds(280, 350, 150, 30);
		serchButton=new JButton(serchIcon);
		serchButton.setContentAreaFilled(false);
		serchButton.setBounds(530, 230, 48, 48);
		returnButton=new JButton(returnIcon);
		returnButton.setBounds(662, 575,48,48);
		returnButton.setContentAreaFilled(false);
		yesButton=new JButton(yesIcon);
		yesButton.setBounds(602, 575,48,48);
		yesButton.setContentAreaFilled(false);
		this.add(dingdantiaoxingmaJLabel);
		this.add(dingdantiaoxingmahaoField);
		this.add(dingdantiaoxingmahaoJLabel);
		this.add(dingdantiaoxingmanumJLabel);
		this.add(serchButton);
	 	this.setBounds(260, 60, 730,650);
	 	this.add(yesButton);
	 	this.add(returnButton);
	 	this.setLayout(null);
	 	this.setOpaque(false);
	}
	private boolean isCodeTrue(){
		if (documentController.getWuliuInfo(dingdantiaoxingmahaoField.getText())==null) {
			return false;
		}
		return true;
	}
	private void registListener(final courierui courierui,final courierJpanel courierJpanel,final b2Jpanel1 b2Jpanel1){
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				courierJpanel.remove(b2Jpanel1);
				courierJpanel.add(courierui.operationJpanel);
				courierui.orderfinishButton.setEnabled(true);
				courierui.orderfoundButton.setEnabled(true);
				courierui.documentreplyButton.setEnabled(true);
				courierJpanel.repaint();
			}
		});
		yesButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (dingdantiaoxingmanumJLabel.getText().equals("")) {
					new tiaoxingmafailDialog(courierui, "条形码错误", true);
				}
				else {
					courierJpanel.remove(b2Jpanel1);
					new b2Jpanel2(courierui, courierJpanel, b2Jpanel1,dingdantiaoxingmanumJLabel.getText(),account);
					courierJpanel.repaint();
				}
			}
		});
		serchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (isCodeTrue()) {
					dingdantiaoxingmanumJLabel.setText(dingdantiaoxingmahaoField.getText());
				}
				else {
					dingdantiaoxingmanumJLabel.setText("");
					new tiaoxingmafailDialog(courierui, "错误", true);
				}
			}
		});
	}
	public void paintComponent(Graphics g)  
{  
		super.paintComponent(g);    
		g.drawImage(frameIcon.getImage(),-7,-12,null);
 }
}
class b2Jpanel2 extends JPanel{
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private String code;
	private JLabel dingdantiaoxingmahaoJLabel;
	 JLabel dingdantiaoxingmahaonumJLabel;
	private JLabel shoujiandanbianhaoJLabel;
	private JLabel shoujiandanbianhaonumJLabel;
	private JLabel shoujianrenJLabel;
	private JTextField shoujianrenField;
	private JLabel shoujianriqiJLabel;
	private JLabel riqiJLabel;
	private JButton returnButton;
	private JButton yesButton;
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	private ImageIcon yesIcon=new ImageIcon("picture/确定.png");
	private documentController documentController;
	private String account;
	public b2Jpanel2(courierui courierui,courierJpanel courierJpanel,b2Jpanel1 b2Jpanel1,String code,String account) {
		// TODO Auto-generated constructor stub
		this.code=code;
		this.account=account;
		init();
	 	courierJpanel.add(this);
		registListener(courierui,courierJpanel,b2Jpanel1,this);
	}
	private void init(){
		documentController=new documentController();
		Font font=new Font("幼圆", Font.BOLD, 20);
		dingdantiaoxingmahaoJLabel=new JLabel("订单条形码号:");
		dingdantiaoxingmahaoJLabel.setForeground(Color.white);
		dingdantiaoxingmahaoJLabel.setFont(font);
		dingdantiaoxingmahaoJLabel.setBounds(100,100, 150, 30);
		dingdantiaoxingmahaonumJLabel=new JLabel();
		dingdantiaoxingmahaonumJLabel.setForeground(Color.white);
		dingdantiaoxingmahaonumJLabel.setFont(font);
		dingdantiaoxingmahaonumJLabel.setBounds(280,100, 250, 30);
		dingdantiaoxingmahaonumJLabel.setText(code);
		shoujiandanbianhaoJLabel=new JLabel("收件单编号:");
		shoujiandanbianhaoJLabel.setForeground(Color.white);
		shoujiandanbianhaoJLabel.setFont(font);
		shoujiandanbianhaoJLabel.setBounds(100, 200, 150, 30);
		shoujiandanbianhaonumJLabel=new JLabel();
		shoujiandanbianhaonumJLabel.setForeground(Color.white);
		shoujiandanbianhaonumJLabel.setFont(font);
		shoujiandanbianhaonumJLabel.setBounds(280, 200, 250, 30);
		shoujiandanbianhaonumJLabel.setText(documentController.getDocCode("收件单",account));
		shoujianrenJLabel=new JLabel("收件人:");
		shoujianrenJLabel.setForeground(Color.white);
		shoujianrenJLabel.setFont(font);
		shoujianrenJLabel.setBounds(100, 300, 100, 30);
		shoujianrenField=new JTextField();
		shoujianrenField.setFont(font);
		shoujianrenField.setBounds(280, 300, 150, 30);
		shoujianriqiJLabel=new JLabel("收件日期:");
		shoujianriqiJLabel.setForeground(Color.white);
		shoujianriqiJLabel.setFont(font);
		shoujianriqiJLabel.setBounds(100, 400, 100, 30);
		riqiJLabel=new JLabel();
		riqiJLabel.setForeground(Color.white);
		riqiJLabel.setFont(font);
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String riqi = dateFormat.format( now );
		riqiJLabel.setText(riqi);
		riqiJLabel.setBounds(280, 400, 250, 30);
		returnButton=new JButton(returnIcon);
		returnButton.setBounds(662, 575,48,48);
		returnButton.setContentAreaFilled(false);
		yesButton=new JButton(yesIcon);
		yesButton.setBounds(602, 575,48,48);
		yesButton.setContentAreaFilled(false);
	 	this.setBounds(260, 60, 730,650);
	 	this.add(dingdantiaoxingmahaoJLabel);
	 	this.add(dingdantiaoxingmahaonumJLabel);
	 	this.add(shoujiandanbianhaoJLabel);
	 	this.add(shoujiandanbianhaonumJLabel);
	 	this.add(shoujianrenField);
	 	this.add(shoujianrenJLabel);
	 	this.add(shoujianriqiJLabel);
	 	this.add(riqiJLabel);
	 	this.add(yesButton);
	 	this.add(returnButton);
	 	this.setLayout(null);
	 	this.setOpaque(false);
	}
	private boolean isFull(){
		if (shoujianrenField.getText().equals("")) {
			return false;
		}
		return true;
	}
	private void registListener(final courierui courierui,final courierJpanel courierJpanel,final b2Jpanel1 b2Jpanel1,final b2Jpanel2 b2Jpanel2){
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				b2Jpanel1.dingdantiaoxingmahaoField.setText("");
				b2Jpanel1.dingdantiaoxingmanumJLabel.setText("");
				b2Jpanel1.repaint();
				courierJpanel.remove(b2Jpanel2);
				courierJpanel.add(b2Jpanel1);
				courierJpanel.repaint();
			}
		});
		yesButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (isFull()) {
					GetOrderPO getOrderPO=new GetOrderPO(shoujiandanbianhaonumJLabel.getText(), "收件单", code, account, shoujianrenField.getText(), riqiJLabel.getText());
					documentController.createBlock(getOrderPO);
					new orderfinishDialog(courierui, "收件单创建完成", true);
					courierJpanel.remove(b2Jpanel2);
					courierJpanel.add(courierui.operationJpanel);
					courierui.orderfinishButton.setEnabled(true);
					courierui.orderfoundButton.setEnabled(true);
					courierui.documentreplyButton.setEnabled(true);
					courierJpanel.repaint();
				}
				else {
					new failDialog(courierui, "失败", true);
				}			
			}
		});
	}
	public void paintComponent(Graphics g)  
{  
		super.paintComponent(g);    
		g.drawImage(frameIcon.getImage(),-7,-12,null);
 }
}
class tiaoxingmafailDialog extends JDialog{
	private dialogJpanel jPanel;
	private JLabel jLabel;
	private JButton jButton;
	public tiaoxingmafailDialog(JFrame frame,String title,boolean modal) {
		super(frame,title,modal);
		init();
		registerListener();
		this.setVisible(true);
	}
	private void init(){
		ImageIcon yesIcon=new ImageIcon("picture/登录.png");
		jLabel=new JLabel("条形码错误，请修改",jLabel.CENTER);
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
				tiaoxingmafailDialog.this.dispose();
			}
		});
	}
}
class orderfinishDialog extends JDialog{
	private dialogJpanel jPanel;
	private JLabel jLabel;
	private JButton jButton;
	public orderfinishDialog(JFrame frame,String title,boolean modal) {
		super(frame,title,modal);
		init();
		registerListener();
		this.setVisible(true);
	}
	private void init(){
		ImageIcon yesIcon=new ImageIcon("picture/登录.png");
		jLabel=new JLabel("收件单创建完成",jLabel.CENTER);
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
				orderfinishDialog.this.dispose();
			}
		});
	}
}