package presentation.bhclerkui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import vo.orgVO.DriverVO;
import vo.orgVO.VehicleVO;
import businesslogic.organizationbl.BhclerkController;

public class CarInfoJpanel2 extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VehicleVO vo;
	private VehicleVO vo1;
	private String state;
	
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JLabel code;
	private JLabel time;
	private JTextField Code;
	private JLabel Time;
	private JButton deleteButton;
	private JButton returnButton;
	private JButton yesButton;
	private ImageIcon deleteIcon=new ImageIcon("picture/删除.png");
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	private ImageIcon yesIcon=new ImageIcon("picture/确定.png");
	private DefaultTableModel tableModel;
	private int row;
	public CarInfoJpanel2(bhclerkui ui,bhclerkJpanel panel,CarInfoJpanel panel2,VehicleVO vo,String state,DefaultTableModel tableModel,int row){
		this.state=state;
		this.tableModel=tableModel;
		this.row = row;
		vo1=vo;
		init();
		panel.add(this);
		registListener(ui,panel,panel2,this);
	}
	private void init(){
		Font font=new Font("幼圆",Font.BOLD,24);
		code=new JLabel("车牌号：");
		code.setForeground(Color.white);
		code.setFont(font);
		code.setBounds(30,30,100,27);
		this.add(code);
		
		Code=new JTextField();
		Code.setBounds(130,30,150,27);
		Code.setFont(font);
		Code.setText(vo1.getPlateNumber());
		this.add(Code);
		
		time=new JLabel("服役时间：");
		time.setForeground(Color.white);
		time.setFont(font);
		time.setBounds(30,97,125,27);
		this.add(time);
		String string[]=vo1.getDate().split(" ");
		Time=new JLabel(string[0]);
		Time.setForeground(Color.white);
		Time.setBounds(155,97,450,27);
		Time.setFont(font);
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
	private void registListener(final bhclerkui ui,final bhclerkJpanel panel,final CarInfoJpanel panel2,final CarInfoJpanel2 panel3){
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
					vo=new VehicleVO(vo1.getCodeCity(), vo1.getCodeBussinessHall(), vo1.getCodeID(), Code.getText(), Time.getText());
					String stateString[]=state.split("-");
					new BhclerkController().changeVehicle(stateString[4]+"-"+stateString[5], vo);
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
				new BhclerkController().removeVehicle(stateString[4]+"-"+stateString[5],vo1.getCodeCity()+vo1.getCodeBussinessHall()+vo1.getCodeID());
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
