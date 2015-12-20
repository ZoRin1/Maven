package presentation.bhclerkui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import po.documentsPO.YDispatchPO;
import po.documentsPO.YReceivePO;
import businesslogic.documentsbl.createDocument;
import businesslogic.documentsbl.documentController;
import businesslogic.organizationbl.BusinessController;

public class AcceptDocumentJpanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String date2;//接收日期
	private String code2;//接收单编号
	private String doName2;//单据名
	private String code3;//订单条形码号
	private String account;//创建人账号
	private String state1;
	private String departure2;//出发地
	private String arrival2;//本营业厅
	private String state2;//货物状态
	private String[] split;
	private YReceivePO po;
	
	private JLabel code;
	private JLabel code1;
	private JLabel doName;
	private JLabel date;
	private JLabel date1;
	private JLabel departure;
	private JLabel arrival;
	private JLabel Tcode;
	private JTextField tcode;
	private JLabel state;
	private JTextField State;
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JButton returnButton;
	private JButton yesButton;
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	private ImageIcon yesIcon=new ImageIcon("picture/确定.png");
	public AcceptDocumentJpanel(bhclerkui ui,bhclerkJpanel bhclerkJpanel,String account,String state) {
		this.account=account;
		state1=state;
		init();
		bhclerkJpanel.add(this);
		registListener(ui,bhclerkJpanel,this);
	}
	public void init(){
		split=state1.split("-");
		Font font=new Font("幼圆",Font.BOLD,24);
		code=new JLabel("单据编号：");
		code.setForeground(Color.white);
		code.setFont(font);
		code.setBounds(30,30,125,27);
		this.add(code);
		
		code1=new JLabel();
		code2=new documentController().getDocCode("营业厅接收单",account);
		code1.setText(code2);
		code1.setForeground(Color.white);
		code1.setFont(font);
		code1.setBounds(155,30,131,27);
		this.add(code1);
		
		doName=new JLabel("单据名：接收单");
		doName.setForeground(Color.white);
		doName.setFont(font);
		doName.setBounds(360,30,175,27);
		this.add(doName);
		
		date=new JLabel("到达日期：");
		date.setForeground(Color.white);
		date.setFont(font);
		date.setBounds(30,97,125,27);
		this.add(date);
		
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		date2 = dateFormat.format( now );
		date1=new JLabel(date2);
		date1.setForeground(Color.white);
		date1.setFont(font);
		date1.setBounds(155,97,250,27);
		this.add(date1);
		
		departure=new JLabel("出发地："+split[1]+"中转中心");
		departure.setForeground(Color.white);
		departure.setFont(font);
		departure.setBounds(30,164,275,27);
		this.add(departure);
		
		arrival=new JLabel("到达地："+split[2]+"营业厅");
		arrival.setForeground(Color.white);
		arrival.setFont(font);
		arrival.setBounds(30,231,250,27);
		this.add(arrival);
		
		Tcode=new JLabel("订单条形码号：");
		Tcode.setForeground(Color.white);
		Tcode.setFont(font);
		Tcode.setBounds(30,298,175,27);
		this.add(Tcode);
		
		tcode=new JTextField();
		tcode.setBounds(205,298,130,27);
		tcode.setFont(font);
		this.add(tcode);
		
		state=new JLabel("货物状态：");
		state.setForeground(Color.white);
		state.setFont(font);
		state.setBounds(30,365,125,27);
		this.add(state);
		
		State=new JTextField();
		State.setBounds(155,365,125,27);
		State.setFont(font);
		this.add(State);
		
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
	private void registListener(final bhclerkui ui,final bhclerkJpanel panel,final AcceptDocumentJpanel panel2){
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ui.setTitle("快递员——寄件单创建 1");
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
				String stri=tcode.getText();
				ArrayList<String> list1=new documentController().getWuliuInfo(stri);
				boolean a=false;
				if(list1.equals(null)){
					a=true;
				}
				if(tcode.getText().equals("")||State.getText().equals("")){
					new notFinishDialog(ui,"输入有误",true);
				}
				else if(a){
					new notFindDialog(ui, "订单条形码号不存在", true, "订单条形码号");
				}
				else{
					code3=tcode.getText();
					state2=State.getText();
					po=new YReceivePO(date2, code2, "营业厅接收单", code3, account, departure2, arrival2, state2);
					new documentController().createBlock(po);
					new finishDialog2(ui, "接收单创建完成", true,"接收单");
					panel.remove(panel2);
					new DispatchJpanel(ui,panel,panel2,account,stri,state1);
					panel.repaint();
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
class DispatchJpanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String date2;//派件日期
	private String code2;//派件单编号
	private String code3;//对应订单编号
	private String account;//创建人账号
	private String name2;//派件快递员姓名
	private String tcode;
	private String state;
	private YDispatchPO po;
	
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JLabel code;
	private JLabel code1;
	private JLabel doName;
	private JLabel date;
	private JLabel date1;
	private JLabel Tcode;
	private JLabel member;
	private JTextField Member;
	private JButton yesButton;
	private ImageIcon yesIcon=new ImageIcon("picture/确定.png");
	public DispatchJpanel(bhclerkui ui,bhclerkJpanel panel,AcceptDocumentJpanel panel2,String account,String tcode,String state){
		this.state=state;
		this.account=account;
		this.tcode=tcode;
		init();
		panel.add(this);
		registListener(ui,panel,panel2,this);
	}
	private void init(){
		Font font=new Font("幼圆",Font.BOLD,24);
		code=new JLabel("单据编号：");
		code.setForeground(Color.white);
		code.setFont(font);
		code.setBounds(30,30,125,27);
		this.add(code);
		
		code1=new JLabel();
		code2=new documentController().getDocCode("派件单",account);
		code1.setText(code2);
		code1.setForeground(Color.white);
		code1.setFont(font);
		code1.setBounds(155,30,131,27);
		this.add(code1);
		
		doName=new JLabel("单据名：派件单");
		doName.setForeground(Color.white);
		doName.setFont(font);
		doName.setBounds(360,30,175,27);
		this.add(doName);
		
		date=new JLabel("到达日期：");
		date.setForeground(Color.white);
		date.setFont(font);
		date.setBounds(30,97,125,27);
		this.add(date);
		
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		date2 = dateFormat.format( now );
		date1=new JLabel(date2);
		date1.setForeground(Color.white);
		date1.setFont(font);
		date1.setBounds(155,97,250,27);
		this.add(date1);
		
		Tcode=new JLabel("订单条形码号："+tcode);
		Tcode.setForeground(Color.white);
		Tcode.setFont(font);
		Tcode.setBounds(30,164,300,27);
		this.add(Tcode);
		
		member=new JLabel("派件员：");
		member.setForeground(Color.white);
		member.setFont(font);
		member.setBounds(30,231,100,27);
		this.add(member);
		
		Member=new JTextField();
		Member.setBounds(130,231,125,27);
		Member.setFont(font);
		this.add(Member);
		
		yesButton=new JButton(yesIcon);
		yesButton.setBounds(602, 575,48,48);
		yesButton.setContentAreaFilled(false);
		this.add(yesButton);
		
		this.setBounds(260, 60, 730,650);
		this.setLayout(null);
	 	this.setOpaque(false);
	}
	private void registListener(final bhclerkui ui,final bhclerkJpanel panel,
			final AcceptDocumentJpanel panel2,final DispatchJpanel dispatchJpanel) {
		// TODO Auto-generated method stub
		
		yesButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] split=state.split("-");
				String[] list=new BusinessController().getCourierList(split[4]+split[5]);
				boolean a=true;
				int length=list.length;
				for(int i=0;i<length;i++){
					if(list[i].equals(Member.getText())){
						a=false;
						break;
					}
				}
				if(Member.getText().equals("")){
					new notFinishDialog(ui,"输入有误",true);
				}
				else if(a){
					new notFindDialog(ui, "派件员输入错误", true, "派件员");
				}
				else{
					name2=Member.getText();
					po=new YDispatchPO(date2, code2, "派件单", tcode, account, name2);
					new documentController().createBlock(po);
					new finishDialog2(ui, "派件单创建完成", true,"派件单");
					panel.remove(dispatchJpanel);
					panel.add(ui.operationJpanel);
					ui.carinformationbButton.setEnabled(true);
					ui.cashdocumentbButton.setEnabled(true);
					ui.documentreplyButton.setEnabled(true);
					ui.driverinformationbButton.setEnabled(true);
					ui.loaddocumentbButton.setEnabled(true);
					ui.acceptdocumentbButton.setEnabled(true);
					panel.repaint();
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
