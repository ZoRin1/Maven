package presentation.bhclerkui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
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
	private String state;
	
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JLabel carcode;
	private JLabel code;
	private JLabel time;
	private JTextField Carcode;
	private JTextField Code;
	private JTextField Time;
	private JButton returnButton;
	private JButton yesButton;
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	private ImageIcon yesIcon=new ImageIcon("picture/确定.png");
	public CarInfoJpanel3(bhclerkui ui,bhclerkJpanel panel,CarInfoJpanel panel2,String state){
		this.state=state;
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
				String[] split=state.split("-");
				String[] list=new BhclerkController().getVehicleList(split[4]+"-"+split[5]);
				boolean a=false;
				if (list!=null) {
					String code1=split[4]+split[5]+Carcode.getText();
					int length=list.length;			
					for(int i=0;i<length;i++){
						if(code1.equals(list[i])){
							a=true;
							break;
						}
					}
				}
				
				if(Code.getText().equals("")||Time.getText().equals("")){
					new notFinishDialog(ui,"输入有误",true);
				}
				else if(a){
					new OverWriteDialog(ui, "输入有误", true);
				}
				else{
					vo=new VehicleVO(split[4], split[5], Carcode.getText(), Code.getText(), Time.getText());
					new BhclerkController().addVehicle(split[4]+"-"+split[5], vo);
					new finishDialog2(ui, "车辆信息添加", true,"车辆信息" );
					panel.remove(panel3);
					new CarInfoJpanel(ui, panel,state);
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
class OverWriteDialog extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private dialogJpanel jPanel;
	private JLabel jLabel;
	private JButton jButton;
	public OverWriteDialog(JFrame frame,String title,boolean modal) {
		super(frame,title,modal);
		init();
		registerListener();
		this.setVisible(true);
	}
	private void init(){
		ImageIcon yesIcon=new ImageIcon("picture/登录.png");
		jLabel=new JLabel("车辆编号已存在，请检查后重新输入",jLabel.CENTER);
		jLabel.setForeground(Color.white);
		jLabel.setFont(new Font("幼圆",Font.BOLD,27));
		jLabel.setBounds(0, 0, 500, 200);
		
		jButton=new JButton(yesIcon);
		jButton.setContentAreaFilled(false);
		jButton.setBounds(218,190, 64, 64);
		
		jPanel=new dialogJpanel();
		jPanel.setLayout(null);
		jPanel.add(jLabel);
		jPanel.add(jButton);
		this.add(jPanel);
		this.setSize(500, 300);
		Toolkit kitToolkit =Toolkit.getDefaultToolkit();
		Dimension screenSize=kitToolkit.getScreenSize();
		int screenWidth=screenSize.width;
		int screenHeight=screenSize.height;
		int dialogWidth=this.getWidth();
		int dialogHeight=this.getHeight();
		this.setLocation((screenWidth-dialogWidth)/2, (screenHeight-dialogHeight)/2);
		this.setResizable(false);
	}
	private void registerListener(){
		jButton.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				OverWriteDialog.this.dispose();
			}
		});
	}
}

