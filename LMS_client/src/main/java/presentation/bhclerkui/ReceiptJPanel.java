package presentation.bhclerkui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dataservice.financedataservice.CustomException;
import po.documentsPO.ReceiptPO;
import businesslogic.documentsbl.createDocument;
import businesslogic.documentsbl.documentController;
import businesslogic.financebl.AccountManageModel.AccountManageBL;
import businesslogic.organizationbl.BusinessController;

public class ReceiptJPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code2;//收款单编号
	private String date2;//收款日期
	private String account2;//创建人账号
	private String OrgCode;//营业厅编号
	private double fund;//收款金额
	private String name2;//快递员姓名
	private ArrayList<String> TCode2;//所有订单条形码号
	private String state;
	private ReceiptPO po;
	
	private JLabel code;
	private JLabel code1;
	private JLabel doName;
	private JLabel date;
	private JLabel date1;
	private JLabel Name;
	private JTextField name;
	private JLabel account;
	private JTextField Account;
	private JLabel TCode;
	private JTextArea tcode;
	private JLabel zhanghumingJLabel;
	private JTextField zhanghumingJTextField;
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JButton returnButton;
	private JButton yesButton;
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	private ImageIcon yesIcon=new ImageIcon("picture/确定.png");
	
	private AccountManageBL accountManage;
	public ReceiptJPanel(bhclerkui ui,bhclerkJpanel bhclerkJpanel,String account,String state) {

		this.account2=account;
		this.state=state;
		init(ui);
		bhclerkJpanel.add(this);
		registListener(ui,bhclerkJpanel,this);
	}
	public void init(bhclerkui ui){
		Font font=new Font("幼圆",Font.BOLD,24);
		code=new JLabel("单据编号：");
		code.setForeground(Color.white);
		code.setFont(font);
		code.setBounds(30,30,125,27);
		this.add(code);
		
		code1=new JLabel();
		try {
			code2=new documentController().getDocCode("收款单",account2);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new InternetDialog(ui);
		}
		code1.setText(code2);
		code1.setForeground(Color.white);
		code1.setFont(font);
		code1.setBounds(155,30,131,27);
		this.add(code1);
		
		doName=new JLabel("单据名：收款单");
		doName.setForeground(Color.white);
		doName.setFont(font);
		doName.setBounds(360,30,175,27);
		this.add(doName);
		
		date=new JLabel("收款日期:");
		date.setForeground(Color.white);
		date.setFont(font);
		date.setBounds(30,97,125,27);
		this.add(date);
		
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		date2= dateFormat.format( now );
		date1=new JLabel(date2);
		date1.setForeground(Color.white);
		date1.setFont(font);
		date1.setBounds(155,97,250,27);
		this.add(date1);
		
		Name=new JLabel("收款快递员姓名:");
		Name.setForeground(Color.white);
		Name.setFont(font);
		Name.setBounds(30,164,200,27);
		this.add(Name);
		
		name=new JTextField();
		name.setBounds(230,164,125,27);
		name.setFont(font);
		this.add(name);
		
		account=new JLabel("收款金额：");
		account.setForeground(Color.white);
		account.setFont(font);
		account.setBounds(30,231,125,27);
		this.add(account);
		
		Account=new JTextField();
		Account.setBounds(155,231,125,27);
		Account.setFont(font);
		this.add(Account);
		zhanghumingJLabel =new JLabel("账户名：");
		zhanghumingJLabel.setForeground(Color.white);
		zhanghumingJLabel.setFont(font);
		zhanghumingJLabel.setBounds(330, 231, 100, 27);
		this.add(zhanghumingJLabel);
		zhanghumingJTextField=new JTextField();
		zhanghumingJTextField.setBounds(430, 231,150,27);
		zhanghumingJTextField.setFont(font);
		this.add(zhanghumingJTextField);
		TCode=new JLabel("订单条形码号：");
		TCode.setForeground(Color.white);
		TCode.setFont(font);
		TCode.setBounds(30,298,175,27);
		this.add(TCode);
		
		tcode=new JTextArea();
		tcode.setBounds(205,298,143,108);
		tcode.setLineWrap(true);
		tcode.setFont(font);
		this.add(tcode);
		
		returnButton=new JButton(returnIcon);
		returnButton.setBounds(662,575,48,48);
		returnButton.setContentAreaFilled(false);
		this.add(returnButton);
		
		yesButton=new JButton(yesIcon);
		yesButton.setBounds(602, 575,48,48);
		yesButton.setContentAreaFilled(false);
		this.add(yesButton);
		
		this.setBounds(260, 60, 730,650);
		this.setLayout(null);
	 	this.setOpaque(false);
	}
	private void registListener(final bhclerkui ui,final bhclerkJpanel panel,
			final ReceiptJPanel panel2) {
		// TODO Auto-generated method stub
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.remove(panel2);
				panel.add(ui.operationJpanel);
				ui.carinformationbButton.setEnabled(true);
				ui.cashdocumentbButton.setEnabled(true);
				ui.documentreplyButton.setEnabled(true);
				ui.driverinformationbButton.setEnabled(true);
				ui.loaddocumentbButton.setEnabled(true);
				ui.acceptdocumentbButton.setEnabled(true);
				panel.repaint();
			}
		});
		yesButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] list=state.split("-");
				String str=list[4]+"-"+list[5];
				String[] list1=null;
				try {
					list1 = new BusinessController().getCourierList(str);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					new InternetDialog(ui);
				}
				int size1=list1.length;
				boolean a=true;//a为真代表快递员不存在
				for(int i=0;i<size1;i++){
					String cname[]=list1[i].split("-");
					if(name.getText().equals(cname[1])){
						a=false;
						break;
					}
				}
				if(Account.getText().equals("")||tcode.getText().equals("")){
					new notFinishDialog(ui,"输入有误",true);
				}
				else if(a){
					new notFindDialog(ui, "未找到相应快递员", true, "快递员");
				}
				else{
					OrgCode=list[4]+"-"+list[5];
					fund=Double.parseDouble(Account.getText());
					name2=name.getText();
					String[] list2=tcode.getText().split("，");//此处或许应该加以参数把英文逗号转为中文逗号或要求员工必须使用中文输入法
					int size=list2.length;
					TCode2=new ArrayList<String>();
					for(int i=0;i<size;i++){
						TCode2.add(list2[i]);
					}
					po=new ReceiptPO(code2, "收款单", date2, account2, OrgCode, fund, name2, TCode2);
					
					//此处增加相应账户的余额
					accountManage = new AccountManageBL();
					int sign = 0;
					try {
						sign = accountManage.ChangeEarn(zhanghumingJTextField.getText(), fund);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						new InternetDialog(ui);
					}
					if(sign==-1){
						new notFindDialog(ui, "未找到账户", true ,"账户");
					}else {

						try {
							new documentController().createBlock(po);
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							new InternetDialog(ui);
						}
						new finishDialog2(ui, "收款单创建完成", true,"收款单");
						panel.remove(panel2);
						panel.add(ui.operationJpanel);
						ui.carinformationbButton.setEnabled(true);
						ui.cashdocumentbButton.setEnabled(true);
						ui.documentreplyButton.setEnabled(true);
						ui.driverinformationbButton.setEnabled(true);
						ui.loaddocumentbButton.setEnabled(true);
						ui.acceptdocumentbButton.setEnabled(true);
						panel.repaint();
					}

					//此处增加相应账户的余额

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
