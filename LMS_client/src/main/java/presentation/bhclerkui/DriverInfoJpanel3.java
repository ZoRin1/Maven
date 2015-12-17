package presentation.bhclerkui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vo.orgVO.DriverVO;
import vo.orgVO.VehicleVO;
import businesslogic.organizationbl.BhclerkController;

public class DriverInfoJpanel3 extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DriverVO vo;
	private String account;
	private String state;
	
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JLabel drivercode;
	private JTextField Drivercode;
	private JLabel DriverName;
	private JTextField dname;
	private JLabel sex;
	private JTextField Sex;
	private JLabel date;
	private JTextField Date;
	private JLabel ID;
	private JTextField id;
	private JLabel phoneNumber;
	private JTextField Phone;
	private JLabel time;
	private JTextField Time;
	private JButton returnButton;
	private JButton yesButton;
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	private ImageIcon yesIcon=new ImageIcon("picture/确定.png");
	public DriverInfoJpanel3(bhclerkui ui,bhclerkJpanel panel,DriverInfoJpanel panel2,String account,String state){
		this.account=account;
		this.state=state;
		init();
		panel.add(this);
		registListener(ui,panel,panel2,this);
	}
	private void init(){
		Font font=new Font("幼圆",Font.BOLD,24);
		drivercode=new JLabel("司机编号：");
		drivercode.setForeground(Color.white);
		drivercode.setFont(font);
		drivercode.setBounds(30,30,125,27);
		this.add(drivercode);
		
		Drivercode=new JTextField();
		Drivercode.setBounds(155,30,150,27);
		Drivercode.setFont(font);
		this.add(Drivercode);
		//此处单指司机编号，不含营业厅编号和城市编号
		DriverName=new JLabel("司机姓名：");
		DriverName.setForeground(Color.white);
		DriverName.setFont(font);
		DriverName.setBounds(30,97,125,27);
		this.add(DriverName);
		
		dname=new JTextField();
		dname.setBounds(155,97,150,27);
		dname.setFont(font);
		this.add(dname);
		
		sex=new JLabel("性别：");
		sex.setForeground(Color.white);
		sex.setFont(font);
		sex.setBounds(360,97,75,27);
		this.add(sex);
		
		Sex=new JTextField();
		Sex.setBounds(435,97,25,27);
		Sex.setFont(font);
		this.add(Sex);//此处或应改为复选框
				
		date=new JLabel("出生日期：");
		date.setForeground(Color.white);
		date.setFont(font);
		date.setBounds(30,164,125,27);
		this.add(date);
		
		Date=new JTextField();
		Date.setBounds(155,164,200,27);
		Date.setFont(font);
		this.add(Date);
		
		ID=new JLabel("身份证号：");
		ID.setForeground(Color.white);
		ID.setFont(font);
		ID.setBounds(30,231,125,27);
		this.add(ID);
		
		id=new JTextField();
		id.setBounds(155,231,250,27);
		id.setFont(font);
		this.add(id);
		
		phoneNumber=new JLabel("手机号码：");
		phoneNumber.setForeground(Color.white);
		phoneNumber.setFont(font);
		phoneNumber.setBounds(30,298,125,27);
		this.add(phoneNumber);
		
		Phone=new JTextField();
		Phone.setBounds(155,298,250,27);
		Phone.setFont(font);
		this.add(Phone);
		
		time=new JLabel("行驶证期限：");
		time.setForeground(Color.white);
		time.setFont(font);
		time.setBounds(30,365,150,27);
		this.add(time);
		
		Time=new JTextField();
		Time.setBounds(180,365,100,27);
		Time.setFont(font);
		this.add(Time);
		
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
	private void registListener(final bhclerkui ui,final bhclerkJpanel panel,final DriverInfoJpanel panel2,final DriverInfoJpanel3 panel3){
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.remove(panel3);
				panel.add(panel2);
				panel.repaint();
			}
		});
		yesButton.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] split=state.split("-");
				String[] list=new BhclerkController().getVehicleList(account);
				String code1=split[4]+split[5]+Drivercode.getText();
				int length=list.length;
				boolean a=false;
				for(int i=0;i<length;i++){
					if(code1.equals(list[i])){
						a=true;
						break;
					}
				}
				if(Drivercode.getText().equals("")||dname.getText().equals("")||Sex.getText().equals("")||Date.getText().equals("")
						||id.getText().equals("")||Phone.getText().equals("")||Time.getText().equals("")){
					new notFinishDialog(ui,"输入有误",true);
				}
				else if(a){
					new OverWriteDialog(ui, "输入有误", true);
				}
				else{
					vo=new DriverVO(split[4], split[5], Drivercode.getText(), dname.getText(), 
							Date.getText(), id.getText(), Phone.getText(), Sex.getText(), Time.getText());
					new BhclerkController().addDriver(account, vo);
					new finishDialog2(ui, "车辆信息添加", true,"车辆信息" );
					panel.remove(panel3);
					new CarInfoJpanel(ui, panel, account,state);
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
