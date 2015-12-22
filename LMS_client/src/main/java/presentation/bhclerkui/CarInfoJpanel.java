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

public class CarInfoJpanel extends JPanel{
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JButton returnButton;
	private JButton addButton;
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	private JLabel CarLabel;
	private CarInfoJpanelJTable CarInfoJpanelJTable;
	private bhclerkui ui;
	private bhclerkJpanel panel;
	private String state;
	public CarInfoJpanel(bhclerkui ui,bhclerkJpanel bhclerkJpanel,String state) {
		this.state=state;
		this.ui=ui;
		this.panel=bhclerkJpanel;
		init();
		createjtable();
		bhclerkJpanel.add(this);
		registListener(ui,bhclerkJpanel,this);
	}
	public void createjtable(){
		CarInfoJpanelJTable = new CarInfoJpanelJTable(ui,panel,this,state);
		CarLabel.add(CarInfoJpanelJTable.getScrollPane());
	}
	public void init(){
		Font font=new Font("幼圆",Font.BOLD,24);
		ImageIcon i1 = new ImageIcon("picture/车辆信息框架.png");
		
		
		returnButton=new JButton(returnIcon);
		returnButton.setBounds(662,575,48,48);
		returnButton.setContentAreaFilled(false);
		this.add(returnButton);
		
		CarLabel = new JLabel(i1);
		CarLabel.setBounds(0, 0, 723, 571);
		
		this.add(CarLabel);
		
		
		addButton=new JButton("添加");
		addButton.setFont(font);
		addButton.setForeground(Color.white);
		addButton.setBounds(30, 575, 100, 48);
		addButton.setContentAreaFilled(false);
		this.add(addButton);
		
		this.setBounds(260, 60, 730,650);
		this.setLayout(null);
	 	this.setOpaque(false);
	}
	private void registListener(final bhclerkui ui,final bhclerkJpanel panel,
			final CarInfoJpanel panel2) {
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
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.remove(panel2);
				new CarInfoJpanel3(ui, panel, panel2,state);
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
