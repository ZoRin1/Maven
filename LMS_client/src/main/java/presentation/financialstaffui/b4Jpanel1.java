package presentation.financialstaffui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import po.documentsPO.ReceiptPO;
import businesslogic.documentsbl.documentController;

public class b4Jpanel1 extends JPanel{
	private JLabel bussinessHallCodeJLabel;
	private JTextField bussinessHallCodeField;
	private JLabel dateJLabel;
	private JTextField dateField;
	private JButton yesButton;
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JButton returnButton;
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	private ImageIcon yesIcon=new ImageIcon("picture/确定.png");
	private b4Jpanel2 b4Jpanel2;
	
	private DateChooser date;
	private documentController docController;
	private ArrayList<ReceiptPO> receiptList;
	public b4Jpanel1(financialstaffui financialstaffui,financialstaffJpanel financialstaffJpanel) {
		// TODO Auto-generated constructor stub
		init();
		financialstaffJpanel.add(this);
		registListener(financialstaffui,financialstaffJpanel,this);
	}
	private void init(){
		Font font=new Font("幼圆",Font.BOLD,30);
		bussinessHallCodeField=new JTextField();
		bussinessHallCodeField.setFont(font);
		bussinessHallCodeField.setBounds(320, 200, 250, 30);
		bussinessHallCodeField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int keyChar = e.getKeyChar();
				if(keyChar>=KeyEvent.VK_0&&keyChar<=KeyEvent.VK_9||keyChar==KeyEvent.VK_MINUS){
					
				}else{
					e.consume();
				}
			}
		});
		bussinessHallCodeJLabel=new JLabel("营业厅编号");
		bussinessHallCodeJLabel.setForeground(Color.white);
		bussinessHallCodeJLabel.setFont(font);
		bussinessHallCodeJLabel.setBounds(100, 200, 200, 30);
		dateJLabel=new JLabel("查询日期");
		dateJLabel.setForeground(Color.white);
		dateJLabel.setFont(font);
		dateJLabel.setBounds(100, 300, 200, 30);
		dateField=new JTextField("点击选择日期");
		
	    date = DateChooser.getInstance("yyyy-MM-dd");        //日期选择类
	    date.register(dateField);
	    
		dateField.setFont(font);
		dateField.setBounds(320, 300, 250, 30);
		yesButton=new JButton(yesIcon);
		yesButton.setBounds(602, 575,48,48);
		yesButton.setContentAreaFilled(false);
		returnButton=new JButton(returnIcon);
		returnButton.setBounds(662, 575,48,48);
		returnButton.setContentAreaFilled(false);

	 	this.setBounds(260, 60, 730,650);
	 	this.add(bussinessHallCodeField);
	 	this.add(bussinessHallCodeJLabel);
	 	this.add(dateField);
	 	this.add(dateJLabel);
	 	this.add(yesButton);
	 	this.add(returnButton);
	 	this.setLayout(null);
	 	this.setOpaque(false);
	}
	private void registListener(final financialstaffui financialstaffui,final financialstaffJpanel financialstaffJpanel,final b4Jpanel1 b4Jpanel1){
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				financialstaffJpanel.remove(b4Jpanel1);
				financialstaffJpanel.add(financialstaffui.operationJpanel);
				financialstaffui.b1.setEnabled(true);
				financialstaffui.b2.setEnabled(true);
				financialstaffui.b3.setEnabled(true);
				financialstaffui.b4.setEnabled(true);
				financialstaffui.b5.setEnabled(true);
				financialstaffJpanel.repaint();
			}
		});
		yesButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				docController = new documentController();
				String now = date.getStrDate();
				String selling = bussinessHallCodeField.getText();
				receiptList = docController.getReceipts(selling, now);
				
				//本地测试的假数据
//				ArrayList<String> TCode = new ArrayList<String>();
//				TCode.add("123156456");
//				TCode.add("12356");
//				TCode.add("123");
//				TCode.add("1256456");
//				TCode.add("1231566");
//				TCode.add("12356");
//				TCode.add("1236");
//				receiptList =new  ArrayList<ReceiptPO>();
//				ReceiptPO p1= new ReceiptPO("11233", "sdsad", "dasdas", "dadasd", "545646", 465, "545", TCode);
//				receiptList.add(p1);
				//本地测试的假数据
				
				b4Jpanel2 = new b4Jpanel2(financialstaffui, financialstaffJpanel,receiptList);
				financialstaffJpanel.add(b4Jpanel2);
				financialstaffJpanel.remove(b4Jpanel1);
				financialstaffJpanel.repaint();
			}
		});
	}
	public void paintComponent(Graphics g)  
{  
		super.paintComponent(g);    
		g.drawImage(frameIcon.getImage(),-7,-12,null);
 }
}
