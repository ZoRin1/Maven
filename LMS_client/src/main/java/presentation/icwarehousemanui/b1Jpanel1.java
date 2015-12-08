package presentation.icwarehousemanui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import businesslogic.documentsbl.documentController;

public class b1Jpanel1 extends JPanel{
	
	private String account;
	private String state;
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JButton returnButton,b1;
	private JLabel j1;
	 JTextField t1;
	private JButton yesButton;
	private JLabel dingdantiaoxingmaJLabel;
	 JLabel dingdantiaoxingmanumJLabel;
	private documentController documentController;
	public b1Jpanel1(b1icwarehousemanui ui,icwarehousemanJpanel icwarehousemanJpanel,String account,String state) {
		// TODO Auto-generated constructor stub
		this.account=account;
		this.state=state;
		init();
		icwarehousemanJpanel.add(this);
		registListener(ui,icwarehousemanJpanel,this);
	}
	
	private void init(){
		documentController=new documentController();
		Font font=new Font("幼圆", Font.BOLD, 20);
		ImageIcon returnIcon=new ImageIcon("picture/返回.png");
		ImageIcon i1 = new ImageIcon("picture/搜索.png");
		ImageIcon yesIcon=new ImageIcon("picture/确定.png");
		
		returnButton=new JButton(returnIcon);
		j1 = new JLabel("订单条形码号:");
		j1.setForeground(Color.white);
		j1.setFont(font);
		j1.setBounds(100, 150, 150, 30);
		dingdantiaoxingmaJLabel=new JLabel("订单条形码号:");
		dingdantiaoxingmaJLabel.setForeground(Color.white);
		dingdantiaoxingmaJLabel.setFont(font);
		dingdantiaoxingmaJLabel.setBounds(100, 350, 150, 30);
		dingdantiaoxingmanumJLabel=new JLabel();
		dingdantiaoxingmanumJLabel.setForeground(Color.white);
		dingdantiaoxingmanumJLabel.setFont(font);
		dingdantiaoxingmanumJLabel.setBounds(280, 350, 150, 30);
		b1 = new JButton(i1);
		b1.setContentAreaFilled(false);
		b1.setBounds(530, 230, 48, 48);
		
		yesButton=new JButton(yesIcon);
		yesButton.setBounds(602, 575,48,48);
		yesButton.setContentAreaFilled(false);
		
		t1 = new JTextField();
		t1.setForeground(Color.black);
		t1.setFont(new Font("幼圆",Font.BOLD,24));
		t1.setBounds(280, 150, 300, 30);
		t1.addKeyListener(new KeyAdapter() {
			
			public void keyTyped(KeyEvent e) {
				int keyChar = e.getKeyChar();
				if(keyChar>=KeyEvent.VK_0&&keyChar<=KeyEvent.VK_9){
					
				}else{
					e.consume();
				}
			}
		});
		
		this.add(j1);
		this.add(t1);
		this.add(b1);
		this.add(dingdantiaoxingmaJLabel);
		this.add(dingdantiaoxingmanumJLabel);
	 	this.add(yesButton);
		
		
		returnButton.setBounds(662, 575,48,48);
		returnButton.setContentAreaFilled(false);
		this.add(returnButton);
		this.setOpaque(false);
		this.setBounds(260, 60, 730,650);
		this.setLayout(null);
	}
	private boolean isCodeTrue(){
		if (documentController.getWuliuInfo(t1.getText())==null) {
			return false;
		}
		return true;
	}
	private void registListener(final b1icwarehousemanui ui,final icwarehousemanJpanel icwarehousemanJpanel,final b1Jpanel1 b1Jpanel1){
		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				icwarehousemanJpanel.remove(b1Jpanel1);
				icwarehousemanJpanel.add(ui.getOperationJpanel());
				ui.getB1().setEnabled(true);
				icwarehousemanJpanel.repaint();
			}
		});
		yesButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if (dingdantiaoxingmanumJLabel.getText().equals("")) {
					new tiaoxingmafailDialog(ui, "条形码错误", true);
				}
				else {
					icwarehousemanJpanel.remove(b1Jpanel1);
					new b1Jpanel2(ui, icwarehousemanJpanel,b1Jpanel1,dingdantiaoxingmanumJLabel.getText(),account,state);
					icwarehousemanJpanel.repaint();	
				}		
			}
		});
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if (isCodeTrue()) {
					dingdantiaoxingmanumJLabel.setText(t1.getText());
				}
				else {
					dingdantiaoxingmanumJLabel.setText("");
					new tiaoxingmafailDialog(ui, "错误", true);
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
	class dialogJpanel extends JPanel{
		private ImageIcon dialogIcon=new ImageIcon("picture/背景.png");
		public void paintComponent(Graphics g)  
		{  
		    super.paintComponent(g);    
		    g.drawImage(dialogIcon.getImage(),0,0,null);
	      
	     }
	   }
}
