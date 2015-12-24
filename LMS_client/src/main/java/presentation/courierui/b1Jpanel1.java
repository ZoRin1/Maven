package presentation.courierui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.peer.LightweightPeer;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListDataListener;

import po.documentsPO.OrderPO;
import businesslogic.documentsbl.documentController;
import businesslogic.transportationbl.TransportationController;

public class b1Jpanel1 extends JPanel{
	private JLabel jijianrenJLabel;
	private JLabel jijianrennameJLabel;
	private JTextField jijianrennameField;
	private JLabel jijianrendianhuaJLabel;
	private JTextField jijianrendianhuaField;
	private JLabel jijianrenshoujiJLabel;
	private JTextField jijianrenshoujiField;
	private JLabel jijianrendanweiJLabel;
	private JTextField jijianrendanweiField;
	private JLabel jijianrenchengshi;
	private JLabel jijianrenchengshiLabel;
	private JLabel jijianrenzhuzhiJLabel;
	private JTextField jijianrenzhuzhiField;
	private JLabel shoujianrenJLabel;
	private JLabel shoujianrennameJLabel;
	private JTextField shoujianrennameField;
	private JLabel shoujianrendianhuaJLabel;
	private JTextField shoujianrendianhuaField;
	private JLabel shoujianrenshoujiJLabel;
	private JTextField shoujianrenshoujiField;
	private JLabel shoujianrendanweiJLabel;
	private JTextField shoujianrendanweiField;
	private JLabel shoujianrenchengshi;
	private JComboBox<String> shoujianrenchengshiBox;
	private JLabel shoujianrenzhuzhiJLabel;
	private JTextField shoujianrenzhuzhiField;
	private JLabel tuoyunwupinxinxiJLabel;
	private JLabel jianshuJLabel;
	private JTextField jianshuField;
	private JLabel zhongliangJLabel;
	private JTextField zhongliangField;
	private JLabel kgJLabel;
	private JLabel tijiJLabel;
	private JTextField tijiField;
	private JLabel lifangcmJLabel;
	private JLabel chicunJLabel;
	private JTextField chicun1Field;
	private JLabel cm1JLabel;
	private JTextField chicun2Field;
	private JLabel cm2JLabel;
	private JTextField chicun3Field;
	private JLabel cm3JLabel;
	private JLabel neijianpinmingJLabel;
	private JTextField neijianpinmingField;
	private JLabel dingdanxinxiJLabel;
	private JLabel kuaidizhongleiJLabel;
	private JComboBox<String> kuaidizhongleiBox;
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JButton returnButton;
	private JButton yesButton;
	private String account;
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	private ImageIcon yesIcon=new ImageIcon("picture/确定.png");
	private String state;
	public b1Jpanel1(courierui courierui,courierJpanel courierJpanel,String account,String state) {
		// TODO Auto-generated constructor stub
		this.account=account;
		this.state=state;
		init(courierui);
	 	courierJpanel.add(this);
		registListener(courierui,courierJpanel,this);
	}
	private void init(courierui courierui){
		Font font=new Font("幼圆",Font.BOLD,20);
		jijianrenJLabel=new JLabel("寄件人:");
		jijianrenJLabel.setForeground(Color.white);
		jijianrenJLabel.setFont(font);
		jijianrenJLabel.setBounds(10, 30, 80, 27);
		jijianrennameJLabel=new JLabel("姓名:");
		jijianrennameJLabel.setForeground(Color.white);
		jijianrennameJLabel.setFont(font);
		jijianrennameJLabel.setBounds(135, 30, 56, 27);
		jijianrennameField=new JTextField();
		jijianrennameField.setFont(font);
		jijianrennameField.setBounds(205, 30, 145, 30);
		jijianrendianhuaJLabel=new JLabel("电话:");
		jijianrendianhuaJLabel.setForeground(Color.white);
		jijianrendianhuaJLabel.setFont(font);
		jijianrendianhuaJLabel.setBounds(135, 75, 56, 27);
		jijianrendianhuaField=new JTextField("");
		jijianrendianhuaField.setBounds(205, 75, 145, 30);
		jijianrendianhuaField.setFont(font);
		
		jijianrenshoujiJLabel=new JLabel("手机:");
		jijianrenshoujiJLabel.setForeground(Color.white);
		jijianrenshoujiJLabel.setFont(font);
		jijianrenshoujiJLabel.setBounds(360, 30, 56, 27);
		jijianrenshoujiField=new JTextField("");
		jijianrenshoujiField.setFont(font);
		jijianrenshoujiField.setBounds(	440, 30, 250, 30);
		
		jijianrendanweiJLabel=new JLabel("单位:");
		jijianrendanweiJLabel.setForeground(Color.white);
		jijianrendanweiJLabel.setFont(font);
		jijianrendanweiJLabel.setBounds(360, 75, 56, 27);
		jijianrendanweiField=new JTextField();
		jijianrendanweiField .setFont(font);
		jijianrendanweiField.setBounds(440, 75, 250, 30);
		
		jijianrenchengshi=new JLabel("城市:");
		jijianrenchengshi.setForeground(Color.white);
		jijianrenchengshi.setFont(font);
		jijianrenchengshi.setBounds(135, 120, 56, 27);
		this.add(jijianrenchengshi);
		String stateString[]=state.split("-");
		jijianrenchengshiLabel=new JLabel(stateString[1]);
		jijianrenchengshiLabel.setForeground(Color.white);
		jijianrenchengshiLabel.setFont(font);
		jijianrenchengshiLabel.setBounds(205, 120, 145, 27);
		this.add(jijianrenchengshiLabel);
		
		jijianrenzhuzhiJLabel=new JLabel("住址:");
		jijianrenzhuzhiJLabel.setForeground(Color.white);
		jijianrenzhuzhiJLabel.setFont(font);
		jijianrenzhuzhiJLabel.setBounds(360, 120, 56, 27);
		jijianrenzhuzhiField=new JTextField();
		jijianrenzhuzhiField.setFont(font);
		jijianrenzhuzhiField.setBounds(440, 120, 250, 30);
		
		shoujianrenJLabel=new JLabel("收件人:");
		shoujianrenJLabel.setForeground(Color.white);
		shoujianrenJLabel.setFont(font);
		shoujianrenJLabel.setBounds(10, 185, 80, 27);
		
		shoujianrennameJLabel=new JLabel("姓名:");
		shoujianrennameJLabel.setForeground(Color.white);
		shoujianrennameJLabel.setFont(font);
		shoujianrennameJLabel.setBounds(135,185,56,27);
		shoujianrennameField=new JTextField();
		shoujianrennameField.setFont(font);
		shoujianrennameField.setBounds(205, 185, 145, 30);
		
		shoujianrendianhuaJLabel=new JLabel("电话:");
		shoujianrendianhuaJLabel.setForeground(Color.white);
		shoujianrendianhuaJLabel.setFont(font);
		shoujianrendianhuaJLabel.setBounds(135, 230, 56, 27);
		shoujianrendianhuaField=new JTextField();
		shoujianrendianhuaField.setFont(font);
		shoujianrendianhuaField.setBounds(205, 230, 145, 30);
		
		shoujianrenshoujiJLabel=new JLabel("手机:");
		shoujianrenshoujiJLabel.setForeground(Color.white);
		shoujianrenshoujiJLabel.setFont(font);
		shoujianrenshoujiJLabel.setBounds(360, 185, 56, 27);
		shoujianrenshoujiField=new JTextField();
		shoujianrenshoujiField.setFont(font);
		shoujianrenshoujiField.setBounds(440, 185, 250, 30);
		
		shoujianrendanweiJLabel=new JLabel("单位:");
		shoujianrendanweiJLabel.setForeground(Color.white);
		shoujianrendanweiJLabel.setFont(font);
		shoujianrendanweiJLabel.setBounds(360, 230, 56, 27);
		shoujianrendanweiField=new JTextField();
		shoujianrendanweiField.setFont(font);
		shoujianrendanweiField.setBounds(440, 230,250 , 30);
		
		shoujianrenchengshi=new JLabel("城市:");
		shoujianrenchengshi.setForeground(Color.white);
		shoujianrenchengshi.setFont(font);
		shoujianrenchengshi.setBounds(135, 275, 56, 27);
		this.add(shoujianrenchengshi);
		try {
			shoujianrenchengshiBox=new JComboBox<String>(new TransportationController().getCityList(""));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new InternetDialog(courierui);
		}
		shoujianrenchengshiBox.setEditable(false);
		shoujianrenchengshiBox.setFont(font);
		shoujianrenchengshiBox.setBounds(205, 275, 145, 27);
		this.add(shoujianrenchengshiBox);
		
		shoujianrenzhuzhiJLabel=new JLabel("住址:");
		shoujianrenzhuzhiJLabel.setForeground(Color.white);
		shoujianrenzhuzhiJLabel.setFont(font);
		shoujianrenzhuzhiJLabel.setBounds(360, 275, 56, 27);
		shoujianrenzhuzhiField=new JTextField();
		shoujianrenzhuzhiField.setFont(font);
		shoujianrenzhuzhiField.setBounds(440, 275, 250, 30);
		
		tuoyunwupinxinxiJLabel=new JLabel("托运物品信息:");
		tuoyunwupinxinxiJLabel.setForeground(Color.white);
		tuoyunwupinxinxiJLabel.setFont(font);
		tuoyunwupinxinxiJLabel.setBounds(10, 340, 152, 27);
		
		jianshuJLabel=new JLabel("件数:");
		jianshuJLabel.setForeground(Color.white);
		jianshuJLabel.setFont(font);
		jianshuJLabel.setBounds(180, 340, 56, 27);
		jianshuField=new JTextField();
		jianshuField.setFont(font);
		jianshuField.setBounds(250, 340, 50, 30);
	
		zhongliangField=new JTextField();
		zhongliangField.setFont(font);
		zhongliangField.setBounds(440, 340, 50, 30);
		zhongliangJLabel=new JLabel("重量:");
		zhongliangJLabel.setForeground(Color.white);
		zhongliangJLabel.setFont(font);
		zhongliangJLabel.setBounds(360, 340, 56, 27);
		
		kgJLabel=new JLabel("Kg");
		kgJLabel.setForeground(Color.white);
		kgJLabel.setFont(font);
		kgJLabel.setBounds(500, 340, 24, 27);
		
		tijiJLabel=new JLabel("体积:");
		tijiJLabel.setForeground(Color.white);
		tijiJLabel.setFont(font);
		tijiJLabel.setBounds(180, 385, 56, 27);
		tijiField=new JTextField();
		tijiField.setFont(font);
		tijiField.setBounds(250, 385, 50, 30);
		
		lifangcmJLabel=new JLabel("cm^3");
		lifangcmJLabel.setForeground(Color.white);
		lifangcmJLabel.setFont(font);
		lifangcmJLabel.setBounds(310, 385, 47, 27);
		
		chicunJLabel=new JLabel("尺寸:");
		chicunJLabel.setForeground(Color.white);
		chicunJLabel.setFont(font);
		chicunJLabel.setBounds(360, 385, 56, 27);
		chicun1Field=new JTextField();
		chicun1Field.setFont(font);
		chicun1Field.setBounds(440, 385, 50, 30);
		chicun2Field=new JTextField();
		chicun2Field.setFont(font);
		chicun2Field.setBounds(526, 385, 50, 30);
		chicun3Field=new JTextField();
		chicun3Field.setFont(font);
		chicun3Field.setBounds(612, 385, 50, 30);
		
		cm1JLabel=new JLabel("cm*");
		cm1JLabel.setFont(font);
		cm1JLabel.setForeground(Color.white);
		cm1JLabel.setBounds(490, 385, 36, 27);
		cm2JLabel=new JLabel("cm*");
		cm2JLabel.setForeground(Color.white);
		cm2JLabel.setFont(font);
		cm2JLabel.setBounds(576, 385, 36, 27);
		cm3JLabel=new JLabel("cm");
		cm3JLabel.setForeground(Color.white);
		cm3JLabel.setFont(font);
		cm3JLabel.setBounds(662, 385, 36, 27);
		
		neijianpinmingField=new JTextField();
		neijianpinmingField.setFont(font);
		neijianpinmingField.setBounds(290,430, 250, 30);
		neijianpinmingJLabel=new JLabel("内件品名:");
		neijianpinmingJLabel.setFont(font);
		neijianpinmingJLabel.setForeground(Color.white);
		neijianpinmingJLabel.setBounds(180, 430, 104, 27);
		
		dingdanxinxiJLabel=new JLabel("订单信息:");
		dingdanxinxiJLabel.setForeground(Color.white);
		dingdanxinxiJLabel.setFont(font);
		dingdanxinxiJLabel.setBounds(10, 495, 104, 27);
		
		final String type[]={"经济快递","特快专递","普通快递"};
		kuaidizhongleiBox=new JComboBox<String>(type);
		kuaidizhongleiBox.setEditable(false);
		kuaidizhongleiBox.setFont(font);
		kuaidizhongleiBox.setBounds(250, 495, 150, 30);	
		kuaidizhongleiJLabel=new JLabel("快递种类:");
		kuaidizhongleiJLabel.setForeground(Color.white);
		kuaidizhongleiJLabel.setFont(font);
		kuaidizhongleiJLabel.setBounds(135, 495, 104, 27);
		
		this.add(jijianrenJLabel);
		this.add(jijianrennameJLabel);
		this.add(jijianrennameField);
		this.add(jijianrenshoujiField);
		this.add(jijianrenshoujiJLabel);
		this.add(jijianrendianhuaField);
		this.add(jijianrendianhuaJLabel);
		this.add(jijianrendanweiField);
		this.add(jijianrendanweiJLabel);
		this.add(jijianrenzhuzhiField);
		this.add(jijianrenzhuzhiJLabel);
		this.add(shoujianrenJLabel);
		this.add(shoujianrennameJLabel);
		this.add(shoujianrennameField);
		this.add(shoujianrendianhuaField );
		this.add(shoujianrendianhuaJLabel);
		this.add(shoujianrenshoujiField);
		this.add(shoujianrenshoujiJLabel);
		this.add(shoujianrendanweiField);
		this.add(shoujianrendanweiJLabel);
		this.add(shoujianrenzhuzhiField);
		this.add(shoujianrenzhuzhiJLabel);
		this.add(tuoyunwupinxinxiJLabel);
		this.add(jianshuField);
		this.add(jianshuJLabel);
		this.add(zhongliangField);
		this.add(zhongliangJLabel);
		this.add(kgJLabel);
		this.add(tijiField);
		this.add(tijiJLabel);
		this.add(lifangcmJLabel);
		this.add(chicunJLabel);
		this.add(chicun1Field);
		this.add(chicun2Field);
		this.add(chicun3Field);
		this.add(cm1JLabel);
		this.add(cm2JLabel);
		this.add(cm3JLabel);
		this.add(neijianpinmingField);
		this.add(neijianpinmingJLabel);
		this.add(dingdanxinxiJLabel);
		this.add(kuaidizhongleiBox);
		this.add(kuaidizhongleiJLabel);
		returnButton=new JButton(returnIcon);
		returnButton.setBounds(662, 575,48,48);
		returnButton.setContentAreaFilled(false);
		yesButton=new JButton(yesIcon);
		yesButton.setBounds(602, 575,48,48);
		yesButton.setContentAreaFilled(false);
	 	this.setBounds(260, 60, 730,650);
	 	this.add(yesButton);
	 	this.add(returnButton);
	 	this.setLayout(null);
	 	this.setOpaque(false);
	}
	private boolean isFull(){
		if (jijianrennameField.getText().equals("")) {
			return false;
		}
		if (jijianrendianhuaField.getText().equals("")) {
			return false;
		}
		if (jijianrendanweiField.getText().equals("")) {
			return false;
		}
		if (jijianrenzhuzhiField.getText().equals("")) {
			return false;
		}
		if (jijianrenshoujiField.getText().equals("")) {
			return false;
		}
		if (shoujianrennameField.getText().equals("")) {
			return false;
		}
		
		if (shoujianrendianhuaField.getText().equals("")) {
			return false;
		}
		if (shoujianrenshoujiField.getText().equals("")) {
			return false;
		}
		
		if (shoujianrendanweiField.getText().equals("")) {
			return false;
		}
		if (shoujianrenzhuzhiField.getText().equals("")) {
			return false;
		}
		if (jianshuField.getText().equals("")) {
			return false;
		}
		if (zhongliangField.getText().equals("")) {
			return false;
		}
		if (tijiField.getText().equals("")) {
			return false;
		}
		if (chicun1Field.getText().equals("")) {
			return false;
		}
		if (chicun2Field.getText().equals("")) {
			return false;
		}
		if (chicun3Field.getText().equals("")) {
			return false;
		}
		if (neijianpinmingField.getText().equals("")) {
			return false;
		}
		return true;
	}
	private void registListener(final courierui courierui,final courierJpanel courierJpanel,final b1Jpanel1 b1Jpanel1){
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				courierJpanel.remove(b1Jpanel1);
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
				if (isFull()) {
					courierJpanel.remove(b1Jpanel1);
					double sizeList[]={Double.parseDouble(chicun1Field.getText()),Double.parseDouble(chicun2Field.getText()),Double.parseDouble(chicun3Field.getText())};
					new b1Jpanel2(jijianrenchengshiLabel.getText(),(String)shoujianrenchengshiBox.getSelectedItem(),courierui, courierJpanel, b1Jpanel1,new OrderPO(null, "寄件单", account, null, jijianrennameField.getText(), jijianrenchengshiLabel.getText()+jijianrenzhuzhiField.getText(), jijianrendanweiField.getText(), jijianrendianhuaField.getText(), jijianrenshoujiField.getText(), shoujianrennameField.getText(), (String)shoujianrenchengshiBox.getSelectedItem()+shoujianrenzhuzhiField.getText(), shoujianrendanweiField.getText(), shoujianrendianhuaField.getText(), shoujianrenshoujiField.getText(), Integer.parseInt(jianshuField.getText()), Double.parseDouble(zhongliangField.getText()), Double.parseDouble(tijiField.getText()), neijianpinmingField.getText(), sizeList, 0,(String)kuaidizhongleiBox.getSelectedItem()),account);
					courierJpanel.repaint();
				}
				else {
					new failDialog(courierui, "失败", true,"填写不完整，请继续填写");
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
class b1Jpanel2 extends JPanel{
	private documentController documentController;
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JButton returnButton;
	private JButton yesButton;
	private JLabel dingdantiaoxingmahaoJLabel;
	private JLabel dingdannumberJLabel;
	private JLabel cankaobaojiaJLabel;
	private JLabel cankaobaojianumberJLabel;
	private JLabel yuan1;
	private JLabel baozhuangfeiJLabel;
	private JLabel baozhuangfeinumberJLabel;
	private JLabel yuan2;
	private JLabel yugushijianJLabel;
	private JLabel yugushijiannumberJLabel;
	private JLabel tianJLabel;
	private JLabel shijibaojiaJLabel;
	private JLabel yuan3;
	private OrderPO orderPO;
	private JTextField shijibaojianumber;
	private String riqi;
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	private ImageIcon yesIcon=new ImageIcon("picture/确定.png");
	private String account;
	private String jcity;
	private String scity;
	public b1Jpanel2(String jcity,String scity,courierui courierui,courierJpanel courierJpanel,b1Jpanel1 b1Jpanel1,OrderPO orderPO,String account) {
		// TODO Auto-generated constructor stub
		this.jcity=jcity;
		this.scity=scity;
		this.account=account;
		this.orderPO=orderPO;
		init(courierui);
	 	courierJpanel.add(this);
		registListener(courierui,courierJpanel,b1Jpanel1,this);
	}
	private void init(courierui courierui){
		documentController=new documentController();
		Font font=new Font("幼圆",Font.BOLD,20);
		dingdantiaoxingmahaoJLabel=new JLabel("订单条形码号:");
		dingdantiaoxingmahaoJLabel.setForeground(Color.white);
		dingdantiaoxingmahaoJLabel.setFont(font);
		dingdantiaoxingmahaoJLabel.setBounds(150, 150, 150, 30);
		dingdannumberJLabel=new JLabel();
		dingdannumberJLabel.setForeground(Color.white);
		dingdannumberJLabel.setFont(font);
		dingdannumberJLabel.setBounds(350, 150, 300, 30);
		try {
			dingdannumberJLabel.setText(documentController.getDocCode("寄件单",account));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new InternetDialog(courierui);
		}
		
		cankaobaojiaJLabel=new JLabel("参考报价:");
		cankaobaojiaJLabel.setForeground(Color.white);
		cankaobaojiaJLabel.setFont(font);
		cankaobaojiaJLabel.setBounds(150, 250, 100, 30);
		cankaobaojianumberJLabel=new JLabel();
		cankaobaojianumberJLabel.setForeground(Color.white);
		cankaobaojianumberJLabel.setFont(font);
		cankaobaojianumberJLabel.setBounds(260, 250, 100, 30);
		yuan1=new JLabel("元");
		yuan1.setForeground(Color.white);
		yuan1.setFont(font);
		yuan1.setBounds(360, 250, 24, 30);
		baozhuangfeiJLabel=new JLabel("包装费:");
		baozhuangfeiJLabel.setForeground(Color.white);
		baozhuangfeiJLabel.setFont(font);
		baozhuangfeiJLabel.setBounds(400, 250,100, 30);
		baozhuangfeinumberJLabel=new JLabel();
		baozhuangfeinumberJLabel.setForeground(Color.white);
		baozhuangfeinumberJLabel.setFont(font);
		baozhuangfeinumberJLabel.setBounds(510, 250, 50, 30);
		yuan2=new JLabel("元");
		yuan2.setForeground(Color.white);
		yuan2.setFont(font);
		yuan2.setBounds(570, 250, 24, 30);
		yugushijianJLabel=new JLabel("预估时间:");
		yugushijianJLabel.setForeground(Color.white);
		yugushijianJLabel.setFont(font);
		yugushijianJLabel.setBounds(150, 350, 100, 30);
		yugushijiannumberJLabel=new JLabel();
		yugushijiannumberJLabel.setForeground(Color.white);
		yugushijiannumberJLabel.setFont(font);
		yugushijiannumberJLabel.setBounds(260, 350, 50, 30);
		tianJLabel=new JLabel("天");
		tianJLabel.setForeground(Color.white);
		tianJLabel.setFont(font);
		tianJLabel.setBounds(320, 350, 24, 30);
		shijibaojiaJLabel=new JLabel("实际报价:");
		shijibaojiaJLabel.setForeground(Color.white);
		shijibaojiaJLabel.setFont(font);
		shijibaojiaJLabel.setBounds(150, 450, 100, 30);
		shijibaojianumber=new JTextField();
		shijibaojianumber.setFont(font);
		shijibaojianumber.setBounds(260, 450, 50, 30);
		yuan3=new JLabel("元");
		yuan3.setForeground(Color.white);
		yuan3.setFont(font);
		yuan3.setBounds(320, 450,24, 30);
		returnButton=new JButton(returnIcon);
		returnButton.setBounds(662, 575,48,48);
		returnButton.setContentAreaFilled(false);
		yesButton=new JButton(yesIcon);
		yesButton.setBounds(602, 575,48,48);
		yesButton.setContentAreaFilled(false);
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		riqi = dateFormat.format( now );
		String string=null;
		if (jcity.equals(scity)) {
			try {
				string=Double.toString(documentController.getOwnCost(orderPO.getWeight()));
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				new InternetDialog(courierui);
			}
		}else {
			try {
				string=Double.toString(documentController.getCost(jcity, scity, orderPO.getState(), orderPO.getWeight()));
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				new InternetDialog(courierui);
			}
		}
		cankaobaojianumberJLabel.setText(string);
		baozhuangfeinumberJLabel.setText(Integer.toString(orderPO.getNumber()*5));
		try {
			yugushijiannumberJLabel.setText(Integer.toString(documentController.getDays(jcity, scity, orderPO.getState(), orderPO.getWeight())));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new InternetDialog(courierui);
		}
		this.add(dingdannumberJLabel);
		this.add(dingdantiaoxingmahaoJLabel);
		this.add(cankaobaojiaJLabel);
		this.add(cankaobaojianumberJLabel);
		this.add(yuan1);
		this.add(baozhuangfeiJLabel);
		this.add(baozhuangfeinumberJLabel);
		this.add(yuan2);
		this.add(yugushijianJLabel);
		this.add(yugushijiannumberJLabel);
		this.add(shijibaojiaJLabel);
		this.add(shijibaojianumber);
		this.add(tianJLabel);
		this.add(yuan3);
	 	this.setBounds(260, 60, 730,650);
	 	this.add(yesButton);
	 	this.add(returnButton);
	 	this.setLayout(null);
	 	this.setOpaque(false);
	}
	private boolean isFull(){
		if (shijibaojianumber.getText().equals("")) {
			return false;
		}
		return true;
	}
	private void registListener(final courierui courierui,final courierJpanel courierJpanel,final b1Jpanel1 b1Jpanel1,final b1Jpanel2 b1Jpanel2){
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				courierJpanel.remove(b1Jpanel2);
				courierJpanel.add(b1Jpanel1);
				courierJpanel.repaint();
			}
		});
		yesButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (isFull()) {
					orderPO.setCode(dingdannumberJLabel.getText());
					orderPO.setDate(riqi);
					orderPO.setSumCost(Double.parseDouble(shijibaojianumber.getText()));
					try {
						documentController.createBlock(orderPO);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						new InternetDialog(courierui);
					}
					new finishDialog(courierui, "寄件单创建完成", true,"寄件单创建完成");
					courierJpanel.remove(b1Jpanel2);
					courierJpanel.add(courierui.operationJpanel);
					courierui.orderfinishButton.setEnabled(true);
					courierui.orderfoundButton.setEnabled(true);
					courierui.documentreplyButton.setEnabled(true);
					courierJpanel.repaint();
				}
				else {
					new failDialog(courierui, "失败", true,"填写不完整，请继续填写");
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
