package presentation.bhclerkui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vo.orgVO.DriverVO;
import vo.orgVO.VehicleVO;
import businesslogic.organizationbl.BhclerkController;

public class CarInfoJpanel3 extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VehicleVO vo;
	private String account;
	
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JLabel carcode;
	private JLabel code;
	private JLabel time;
	private JTextField Carcode;
	private JTextField Code;
	private JTextField Time;
	private JButton returnButton;
	private JButton yesButton;
	private ImageIcon deleteIcon=new ImageIcon("picture/删除.png");
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	private ImageIcon yesIcon=new ImageIcon("picture/确定.png");
	public CarInfoJpanel3(bhclerkui ui,bhclerkJpanel panel,CarInfoJpanel panel2,String account){
		this.account=account;
		init();
		panel.add(this);
		registListener(ui,panel,panel2,this);
	}
	private void init(){
		Font font=new Font("幼圆",Font.BOLD,24);
		carcode=new JLabel("车辆编号：");
		carcode.setForeground(Color.white);
		carcode.setFont(font);
		carcode.setBounds(30,30,125,27);
		this.add(carcode);
		
		Carcode=new JTextField();
		Carcode.setBounds(155,30,150,27);
		Carcode.setFont(font);
		this.add(Carcode);
		//此处单指车辆编号，不含营业厅编号和城市编号
		code=new JLabel("车牌号：");
		code.setForeground(Color.white);
		code.setFont(font);
		code.setBounds(30,97,100,27);
		this.add(code);
		
		Code=new JTextField();
		Code.setBounds(130,97,150,27);
		Code.setFont(font);
		this.add(Code);
		
		time=new JLabel("服役时间：");
		time.setForeground(Color.white);
		time.setFont(font);
		time.setBounds(30,164,125,27);
		this.add(time);
		
		Time=new JTextField();
		Time.setBounds(155,164,150,27);
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
	private void registListener(final bhclerkui ui,final bhclerkJpanel panel,final CarInfoJpanel panel2,final CarInfoJpanel3 panel3){
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
				if(Code.getText().equals("")||Time.getText().equals("")){
					new notFinishDialog(ui,"输入有误",true);
				}
				else{
//					vo=new VehicleVO(vo1.getCodeCity(), vo1.getCodeBussinessHall(), vo1.getCodeID(), Code.getText(), Time.getText());
//					new BhclerkController().changeVehicle(account, vo);
					panel.remove(panel3);
					panel.add(panel2);
					panel.repaint();
				}
			}
		});
	}
}

