package presentation.bhclerkui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import businesslogic.organizationbl.BhclerkController;
import vo.orgVO.DriverVO;

public class DriverInfoJpanel2 extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DriverVO vo;
	private DriverVO vo1;
	private String state;
	private DefaultTableModel tableModel;
	private int row;
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
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
	private JButton deleteButton;
	private JButton returnButton;
	private JButton yesButton;
	private ImageIcon deleteIcon=new ImageIcon("picture/删除.png");
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	private ImageIcon yesIcon=new ImageIcon("picture/确定.png");
	public DriverInfoJpanel2(bhclerkui ui,bhclerkJpanel panel,DriverInfoJpanel panel2,DriverVO vo,String state,DefaultTableModel tableModel,int row){
		this.tableModel=tableModel;
		this.row=row;
		this.state=state;
		vo1=vo;
		init();
		panel.add(this);
		registListener(ui,panel,panel2,this);
	}
	private void init(){
		Font font=new Font("幼圆",Font.BOLD,24);
		DriverName=new JLabel("司机姓名：");
		DriverName.setForeground(Color.white);
		DriverName.setFont(font);
		DriverName.setBounds(30,30,125,27);
		this.add(DriverName);
		
		dname=new JTextField();
		dname.setBounds(155,30,150,27);
		dname.setFont(font);
		dname.setText(vo1.getName());
		this.add(dname);
		
		sex=new JLabel("性别：");
		sex.setForeground(Color.white);
		sex.setFont(font);
		sex.setBounds(360,30,75,27);
		this.add(sex);
		
		Sex=new JTextField();
		Sex.setBounds(435,30,25,27);
		Sex.setFont(font);
		Sex.setText(vo1.getSex());
		this.add(Sex);//此处或应改为复选框
				
		date=new JLabel("出生日期：");
		date.setForeground(Color.white);
		date.setFont(font);
		date.setBounds(30,97,125,27);
		this.add(date);
		
		Date=new JTextField();
		Date.setBounds(155,97,200,27);
		Date.setFont(font);
		Date.setText(vo1.getDate());
		this.add(Date);
		
		ID=new JLabel("身份证号：");
		ID.setForeground(Color.white);
		ID.setFont(font);
		ID.setBounds(30,164,125,27);
		this.add(ID);
		
		id=new JTextField();
		id.setBounds(155,164,250,27);
		id.setFont(font);
		id.setText(vo1.getID());
		this.add(id);
		
		phoneNumber=new JLabel("手机号码：");
		phoneNumber.setForeground(Color.white);
		phoneNumber.setFont(font);
		phoneNumber.setBounds(30,231,125,27);
		this.add(phoneNumber);
		
		Phone=new JTextField();
		Phone.setBounds(155,231,250,27);
		Phone.setFont(font);
		Phone.setText(vo1.getPhone());
		this.add(Phone);
		
		time=new JLabel("行驶证期限：");
		time.setForeground(Color.white);
		time.setFont(font);
		time.setBounds(30,298,150,27);
		this.add(time);
		
		Time=new JTextField();
		Time.setBounds(180,298,100,27);
		Time.setFont(font);
		Time.setText(vo1.getToDate());
		this.add(Time);
		
		deleteButton=new JButton(deleteIcon);
		deleteButton.setBounds(542, 575, 48, 48);
		deleteButton.setContentAreaFilled(false);
		this.add(deleteButton);
		
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
	private void registListener(final bhclerkui ui,final bhclerkJpanel panel,final DriverInfoJpanel panel2,final DriverInfoJpanel2 panel3){
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
				if(dname.getText().equals("")||Sex.getText().equals("")||Date.getText().equals("")||id.getText().equals("")
						||Phone.getText().equals("")||Time.getText().equals("")){
					new notFinishDialog(ui,"输入有误",true);
				}
				else{
					vo=new DriverVO(vo1.getCodeCity(), vo1.getCodeBussinessHall(), vo1.getCodeID(), dname.getText(), 
							Date.getText(), id.getText(), Phone.getText(), Sex.getText(), Time.getText());
					String stateString[]=state.split("-");
					try {
						new BhclerkController().changeDriver(stateString[4]+"-"+stateString[5], vo);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						new InternetDialog(ui);
					}
					panel.remove(panel3);
					panel.add(panel2);
					panel.repaint();
				}
			}
		});
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String stateString[]=state.split("-");
				try {
					new BhclerkController().removeDriver(stateString[4]+"-"+stateString[5],vo1.getCodeCity()+vo1.getCodeBussinessHall()+vo1.getCodeID());
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					new InternetDialog(ui);
				}
				panel.remove(panel3);
				tableModel.removeRow(row);
				panel2.repaint();
				panel.add(panel2);
				panel.repaint();
			}
		});
	}
	public void paintComponent(Graphics g)  
	{  
			super.paintComponent(g);    
			g.drawImage(frameIcon.getImage(),-7,-12,null);
	 }
}
