package presentation.icclerkui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Spliterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import po.documentsPO.ZLoadingPO;
import businesslogic.documentsbl.createDocument;
import businesslogic.documentsbl.documentController;

public class ZloadingJpanel extends JPanel{
	private String date2;
	private String code2;//装运单编号
	private String account;//创建人账号
	private String transcode2;//车辆代号
	private String departure2;//出发地
	private String arrival2;//到达地
	private String name2;//监装员姓名
	private ArrayList<String> codeList;//所有订单条形码号
	private double carriage;//运费
	private String state;//一长段机构信息
	private ZLoadingPO po;
	
	private String state1;
	private JLabel code;
	private JLabel code1;
	private JLabel doName;
	private JLabel date;
	private JLabel date1;
	private JLabel departure;
	private JLabel arrival;
	private JTextField arrive;
	private JLabel transcode;
	private JTextField Transcode;
	private JLabel jianzhuangyuan;
	private JTextField name;
	private JLabel TCode;
	private JTextArea tcode;
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JButton returnButton;
	private JButton yesButton;
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	private ImageIcon yesIcon=new ImageIcon("picture/确定.png");
	public ZloadingJpanel(icclerkui ui,icclerkJpanel panel,String state1,String account,String state) {
		this.state1=state1;
		this.account=account;
		this.state=state;
		init(state1,ui);
		ui.setTitle("中转中心业务员-中转接收单创建");
		panel.add(this);
		registListener(ui,panel,this);
	}
	public void init(String state1,icclerkui ui){
		String[] split=state.split("-");
		Font font=new Font("幼圆",Font.BOLD,24);
		code=new JLabel("单据编号：");
		code.setForeground(Color.white);
		code.setFont(font);
		code.setBounds(30,30,125,27);
		this.add(code);
		
		code1=new JLabel();
		try {
			code2=new documentController().getDocCode("中转中心转运单",account);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new InternetDialog(ui);
		}
		code1.setText(code2);
		code1.setForeground(Color.white);
		code1.setFont(font);
		code1.setBounds(155,30,131,27);
		this.add(code1);
		
		doName=new JLabel("单据名：中转中心装运单");
		doName.setForeground(Color.white);
		doName.setFont(font);
		doName.setBounds(360,30,275,27);
		this.add(doName);

		date=new JLabel("收款日期:");
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
		
		departure=new JLabel("出发地："+split[1]);
		departure.setForeground(Color.white);
		departure.setFont(font);
		departure.setBounds(30,164,175,27);
		this.add(departure);
		
		arrival=new JLabel("到达地：");
		arrival.setForeground(Color.white);
		arrival.setFont(font);
		arrival.setBounds(360,164,100,27);
		this.add(arrival);
		
		arrive=new JTextField();
		arrive.setBounds(460,164,125,27);
		arrive.setFont(font);
		this.add(arrive);
		
		transcode=new JLabel();
		if(state1.equals("特快专递"))
			transcode.setText("航班号：");
		else
			transcode.setText("车次号：");
		transcode.setForeground(Color.white);
		transcode.setFont(font);
		transcode.setBounds(30,231,100,27);
		this.add(transcode);
		
		Transcode=new JTextField();
		Transcode.setBounds(130,231,125,27);
		Transcode.setFont(font);
		this.add(Transcode);
		
		jianzhuangyuan=new JLabel("监装员：");
		jianzhuangyuan.setForeground(Color.white);
		jianzhuangyuan.setFont(font);
		jianzhuangyuan.setBounds(30,298,100,27);
		this.add(jianzhuangyuan);
		
		name=new JTextField();
		name.setBounds(130,298,125,27);
		name.setFont(font);
		this.add(name);
		
		TCode=new JLabel("所有订单条形码号：");
		TCode.setForeground(Color.white);
		TCode.setFont(font);
		TCode.setBounds(30,365,225,27);
		this.add(TCode);
		
		tcode=new JTextArea();
		tcode.setBounds(255,365,150,108);
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
	public void registListener(final icclerkui ui,final icclerkJpanel panel,final ZloadingJpanel panel2){
		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ui.setTitle("中转中心业务员——中转接收单创建 ");
				panel.remove(panel2);
				panel.add(ui.operationJpanel);
				ui.b1.setEnabled(true);
				ui.b2.setEnabled(true);
				ui.b3.setEnabled(true);
				ui.b4.setEnabled(true);
				ui.b5.setEnabled(true);
				ui.b6.setEnabled(true);
				panel.repaint();
			}
		});
		yesButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] split=state.split("-");
				
				String[] list1=tcode.getText().split("，");//此处或许应该加以参数把英文逗号转为中文逗号或要求员工必须使用中文输入法
				int length=list1.length;
				codeList=new ArrayList<>();
				boolean b=false;
				String str3="";
				for(int i=0;i<length;i++){
					ArrayList<String> stri=null;
					try {
						stri = new documentController().getWuliuInfo(list1[i]);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						new InternetDialog(ui);
					}
					if(stri==null){
						b=true;
						str3=list1[i];
						break;
					}
					codeList.add(list1[i]);
				}
				
				if(arrive.getText().equals("")||Transcode.getText().equals("")||name.getText().equals("")
						||tcode.getText().equals("")){
					new notFinishDialog(ui, "输入有误", true);
					panel.repaint();
				}
				else if(b){
					new notFindDialog(ui, "订单条形码号不存在", true, str3);
				}
				else{
					transcode2=Transcode.getText();
					arrival2=arrive.getText();
					name2=name.getText();
					String[] list=tcode.getText().split("，");//此处或许应该加以参数把英文逗号转为中文逗号或要求员工必须使用中文输入法
					int size=list.length;
					codeList=new ArrayList<>();
					for(int i=0;i<size;i++){
						codeList.add(list[i]);
					}
					DecimalFormat df = new DecimalFormat("0.00");
					documentController co=new documentController();
					String str=null;
					try {
						if(state.equals("特快专递")){
							str=df.format(co.getCost(split[1], arrival2, state1, 50000));
						}
						else if(state.equals("普通快递")){
							str=df.format(co.getCost(split[1], arrival2, state1, 2000000));
						}
						else{
							str=df.format(co.getCost(split[1], arrival2, state1, 10000));
						}
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						new InternetDialog(ui);
					}
					carriage=Double.parseDouble(str);
					po=new ZLoadingPO(date2, code2, "中转中心转运单", account, transcode2, split[1],arrival2, name2, codeList, carriage);
					try {
						new documentController().createBlock(po);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						new InternetDialog(ui);
					}
					new finishDialog3(ui, "中转中心装运单创建完成", true , str);
					panel.remove(panel2);
					panel.add(ui.operationJpanel);
					ui.b1.setEnabled(true);
					ui.b2.setEnabled(true);
					ui.b3.setEnabled(true);
					ui.b4.setEnabled(true);
					ui.b5.setEnabled(true);
					ui.b6.setEnabled(true);
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
