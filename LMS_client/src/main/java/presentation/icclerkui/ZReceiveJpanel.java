package presentation.icclerkui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import po.documentsPO.ZReceivePO;
import businesslogic.documentsbl.createDocument;
import businesslogic.documentsbl.documentController;


public class ZReceiveJpanel extends JPanel{
	private String code2;//中转单编号
	private String date2;
	private String account;//创建人账号
	private String zCode;//中转中心编号
	private ArrayList<String> codeList;//所有订单条形码号
	private String departure2;
	private String state2;
	private String arrival2;
	private ZReceivePO po;
	
	private JLabel code;
	private JLabel code1;
	private JLabel doName;
	private JLabel date;
	private JLabel date1;
	private JLabel departure;
	private JTextField depart;
	private JLabel TCode;
	private JTextArea tcode;
	private JLabel state;
	private JComboBox<String> State;
//	private JScrollPane jsp;
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JButton returnButton;
	private JButton yesButton;
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	private ImageIcon yesIcon=new ImageIcon("picture/确定.png");
	public ZReceiveJpanel(icclerkui ui,icclerkJpanel panel,String account,String state) {
		this.account=account;
		state2=state;
		init();
		panel.add(this);
		registListener(ui,panel,this);
	}
	public void init(){
		Font font=new Font("幼圆",Font.BOLD,24);
		code=new JLabel("单据编号：");
		code.setForeground(Color.white);
		code.setFont(font);
		code.setBounds(30,30,125,27);
		this.add(code);
		
		code1=new JLabel();
		code2=new documentController().getDocCode("中转中心接收单",account);
		code1.setText(code2);
		code1.setForeground(Color.white);
		code1.setFont(font);
		code1.setBounds(155,30,131,27);
		this.add(code1);
		
		doName=new JLabel("单据名：中转中心接收单");
		doName.setForeground(Color.white);
		doName.setFont(font);
		doName.setBounds(360,30,275,27);
		this.add(doName);
		
		date=new JLabel("到达日期:");
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
		
		departure=new JLabel("出发地：");
		departure.setForeground(Color.white);
		departure.setFont(font);
		departure.setBounds(30,164,100,27);
		this.add(departure);
		
		depart=new JTextField();
		depart.setBounds(130,164,125,27);
		depart.setFont(font);
		this.add(depart);
		
		TCode=new JLabel("所有订单条形码号：");
		TCode.setForeground(Color.white);
		TCode.setFont(font);
		TCode.setBounds(30,231,225,27);
		this.add(TCode);
		
		tcode=new JTextArea();
		tcode.setBounds(255,231,150,108);
		tcode.setLineWrap(true);
		tcode.setFont(font);
//		jsp = new JScrollPane(tcode);
//		jsp.setBounds(388,231,20,108);
//		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(tcode);
//		this.add(jsp);
		
		state=new JLabel("货物状态：");
		state.setForeground(Color.white);
		state.setFont(font);
		state.setBounds(30,365,125,27);
		this.add(state);
		String []type={"完整","破损","丢失"};
		State=new JComboBox<String>(type);
		State.setEditable(false);
		State.setBounds(155,365,125,30);
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
	public void registListener(final icclerkui ui,final icclerkJpanel panel,final ZReceiveJpanel panel2){
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
				String[] list1=tcode.getText().split("，");//此处或许应该加以参数把英文逗号转为中文逗号或要求员工必须使用中文输入法
				int length=list1.length;
				codeList=new ArrayList<>();
				boolean b=false;
				String str3="";
				for(int i=0;i<length;i++){
					ArrayList<String> stri=new documentController().getWuliuInfo(list1[i]);
					if(stri.equals(null)){
						b=true;
						str3=list1[i];
						break;
					}
					codeList.add(list1[i]);
				}
				if(depart.getText().equals("")||tcode.getText().equals("")){
					new notFinishDialog(ui,"输入有误",true);
				}
				else if(b=true){
					new notFindDialog(ui, "订单条形码号不存在", true, str3);
				}
				else{
					String[] list=state2.split("-");
					zCode=list[3];
					arrival2=list[1];
					departure2=depart.getText();
					po=new ZReceivePO(code2, "中转中心接收单", date2, account, zCode, codeList, departure2, arrival2);
					new documentController().createBlock(po);
					new finishDialog2(ui, "中转接收单创建完成", true,"中转接收单");
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

