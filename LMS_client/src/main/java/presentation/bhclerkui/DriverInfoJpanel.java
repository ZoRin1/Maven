package presentation.bhclerkui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DriverInfoJpanel extends JPanel{
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JButton returnButton;
	private JButton yesButton;
	private JButton addButton;
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	private ImageIcon yesIcon=new ImageIcon("picture/确定.png");
	private JLabel kuangjia;
	private DriverInfoJpanelJTable DriverInfoJpanelJTable;
	private bhclerkui ui;
	private bhclerkJpanel panel;
	private String state;
	public DriverInfoJpanel(bhclerkui ui,bhclerkJpanel bhclerkJpanel,String state) {
		this.ui=ui;
		this.panel=bhclerkJpanel;
		this.state=state;
		init();
		bhclerkJpanel.add(this);
		registListener(ui,bhclerkJpanel,this);
	}
	private void init() {
		// TODO Auto-generated method stub
		ImageIcon i1 =new  ImageIcon("picture/司机信息框架.png");
		Font font=new Font("幼圆",Font.BOLD,24);
		kuangjia = new JLabel(i1);
		kuangjia.setBounds(0, 0, 723, 571);
		kuangjia.add(DriverInfoJpanelJTable.getScrollPane());
		this.add(kuangjia);
		
		returnButton=new JButton(returnIcon);
		returnButton.setBounds(662,575,48,48);
		returnButton.setContentAreaFilled(false);
		this.add(returnButton);
		
		yesButton=new JButton(yesIcon);
		yesButton.setBounds(602, 575,48,48);
		yesButton.setContentAreaFilled(false);
		this.add(yesButton);
		
		addButton=new JButton("添加");
		addButton.setBounds(30, 575, 80, 30);
		addButton.setContentAreaFilled(false);
		this.add(addButton);
		
		DriverInfoJpanelJTable = new DriverInfoJpanelJTable(ui,panel,this,state);
		
		this.setBounds(260, 60, 730,650);
		this.setLayout(null);
	 	this.setOpaque(false);
	}
	private void registListener(final bhclerkui ui,final bhclerkJpanel panel,
			final DriverInfoJpanel panel2) {
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
				new DriverInfoJpanel3(ui, panel, panel2,state);
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
