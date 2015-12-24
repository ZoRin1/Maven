package presentation.topmanagerui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import businesslogic.organizationbl.FinanceController;

public class b2FianaceInfo extends JPanel {
	private JLabel bianHao,biaoHaoI,caiWuRenYuan;
    private JButton change,returnButton;
    private JComboBox caiWuRenYuanB;
    private ImageIcon changeIcon = new ImageIcon("picture/修改y.png");
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");	
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	
	public b2FianaceInfo(b2topmanagerui b2ui,topmanagerJpanel tjpl){
		init(b2ui, tjpl);
		tjpl.add(this);
		registListener(b2ui, tjpl, this);
	}

	private void init(b2topmanagerui b2ui,topmanagerJpanel tjpl) {
		
		Font bFont = new Font("幼圆", Font.BOLD, 30);
		Font sFont = new Font("幼圆", Font.BOLD, 20);
		FinanceController financeController = null;
		try {
			financeController = new FinanceController();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new InternetDialog(b2ui);
		}
		
		bianHao = new JLabel("机构编号:");
		bianHao.setFont(bFont);
		bianHao.setForeground(Color.WHITE);
		bianHao.setBounds(190, 120, 200, 50);
		this.add(bianHao);
		
		biaoHaoI = new JLabel("000");
		biaoHaoI.setFont(bFont);
		biaoHaoI.setForeground(Color.WHITE);
		biaoHaoI.setBounds(380, 120, 150, 50);
		this.add(biaoHaoI);
		
		caiWuRenYuan = new JLabel("财务人员列表:");
		caiWuRenYuan.setFont(sFont);
		caiWuRenYuan.setForeground(Color.WHITE);
		caiWuRenYuan.setBounds(240, 200, 180, 40);
		this.add(caiWuRenYuan);		
		
		if (financeController.getFinancersList() != null) {
			caiWuRenYuanB = new JComboBox(financeController.getFinancersList());
			caiWuRenYuanB.setFont(sFont);
			caiWuRenYuanB.setOpaque(false);
			caiWuRenYuanB.setForeground(Color.WHITE);
			caiWuRenYuanB.setBounds(240, 250, 180, 40);
			this.add(caiWuRenYuanB);
		}
		
		
		change = new JButton(changeIcon);
		change.setContentAreaFilled(false);
		change.setBorderPainted(false);
		change.setBounds(238, 425, 158, 58);
		this.add(change);


		returnButton = new JButton(returnIcon);
		returnButton.setBounds(662, 575,48,48);
		returnButton.setContentAreaFilled(false);
		this.add(returnButton);

		this.setBounds(260, 60, 730, 650);
		this.setLayout(null);
		this.setOpaque(false);
	}
	
	
	private void registListener(final b2topmanagerui b2ui,final topmanagerJpanel tjpl,final b2FianaceInfo b2FianaceInfo) {
		
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tjpl.remove(b2FianaceInfo);
				tjpl.add(b2ui.operationJpanel);
				b2ui.b1.setEnabled(true);
				b2ui.b2.setEnabled(true);
				b2ui.b3.setEnabled(true);
				tjpl.repaint();
			}
		});
		
		change.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tjpl.remove(b2FianaceInfo);
				new b2FinanceChange(b2ui, tjpl);
				tjpl.repaint();
			}
		});
		
	}
	public void paintComponent(Graphics g)  
	{  
	    super.paintComponent(g);    
	    g.drawImage(frameIcon.getImage(),-7,-12,null);
     }
}