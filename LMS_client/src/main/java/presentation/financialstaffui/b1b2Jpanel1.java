package presentation.financialstaffui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vo.financeVO.ProfitVO;

public class b1b2Jpanel1 extends JPanel{
	
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JButton returnButton;
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	private JLabel j1;
	private b1b2Jpanel1JTable b1b2Jpanel1JTable;
	private ArrayList<ProfitVO> profitList;
	
	public b1b2Jpanel1(b1financialstaffui b1financialstaffui,financialstaffJpanel financialstaffJpanel,ArrayList<ProfitVO> profitList) {
		// TODO Auto-generated constructor stub
		this.profitList = profitList;
		init();
		financialstaffJpanel.add(this);
		registListener(b1financialstaffui,financialstaffJpanel,this);
	}
	private void init(){
		Font font=new Font("幼圆",Font.BOLD,20);
		ImageIcon i1 = new ImageIcon("picture/财务图片/成本收益表框架.png");
		j1 = new JLabel(i1);
		j1.setBounds(0, 0, 723, 571);
		
		b1b2Jpanel1JTable = new b1b2Jpanel1JTable(this,profitList);
		
		returnButton=new JButton(returnIcon);
		returnButton.setBounds(662, 575,48,48);
		returnButton.setContentAreaFilled(false);

	 	this.setBounds(260, 60, 730,650);

	 	j1.add(b1b2Jpanel1JTable.getScrollPane());
	 	this.add(returnButton);
	 	this.add(j1);
	 	this.setLayout(null);
	 	this.setOpaque(false);
	}
	private void registListener(final b1financialstaffui b1financialstaffui,final financialstaffJpanel financialstaffJpanel,final b1b2Jpanel1 b1b2Jpanel1){
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				financialstaffJpanel.remove(b1b2Jpanel1);
				financialstaffJpanel.add(b1financialstaffui.operationJpanel);
				b1financialstaffui.b1.setEnabled(true);
				b1financialstaffui.b2.setEnabled(true);
				financialstaffJpanel.repaint();
			}
		});
	}
	public void paintComponent(Graphics g)  
{  
		super.paintComponent(g);    
		g.drawImage(frameIcon.getImage(),-7,-12,null);
 }
}

