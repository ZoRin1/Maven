package presentation.topmanagerui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businesslogic.accountbl.AccountInfoController;
import businesslogic.organizationbl.BusinessController;
import presentation.adminui.NumberFieldListener;

public class b2BusinessChange extends JPanel {
	private JLabel suoShu,suoShuC,suoZai,bianHao,bianHaoC,kuaiDiYuan,yeWuYuan;
	private JLabel suoZaiF;
	private JComboBox kuaiDiYuanb,yeWuYuanb,kongXianK,kongXianY;
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JButton returnButton;
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");

	
	public b2BusinessChange(b2topmanagerui b2ui,topmanagerJpanel tjpl,String ID){
		init(ID);
		tjpl.add(this);
		registListener(b2ui, tjpl, this, ID);
	}
	
	private void init(String ID) {
		BusinessController businessController = new BusinessController();
		String[] temp = ID.split("-");
		Font bFont = new Font("幼圆", Font.BOLD, 30);
		Font sFont = new Font("幼圆", Font.BOLD, 20);
		
		suoShu = new JLabel("所属中转中心编号:");
		suoShu.setFont(bFont);
		suoShu.setForeground(Color.WHITE);
		suoShu.setBounds(100, 70, 300, 50);
		this.add(suoShu);
		
		suoShuC = new JLabel(temp[0]);
		suoShuC.setFont(bFont);
		suoShuC.setForeground(Color.WHITE);
		suoShuC.setBounds(400, 70, 200, 50);
		this.add(suoShuC);
		
		suoZai = new JLabel("所在地区:");
		suoZai.setFont(bFont);
		suoZai.setForeground(Color.WHITE);
		suoZai.setBounds(100, 130, 180, 50);
		this.add(suoZai);
		
		suoZaiF = new JLabel(businessController.getInfo(ID));
		suoZaiF.setFont(bFont);
		suoZaiF.setForeground(Color.white);
		suoZaiF.setBounds(290, 130, 150, 50);
		this.add(suoZaiF);
		
		bianHao = new JLabel("机构编号:");
		bianHao.setFont(bFont);
		bianHao.setForeground(Color.WHITE);
		bianHao.setBounds(100, 190, 200, 50);
		this.add(bianHao);
		
		bianHaoC = new JLabel(temp[1]);
		bianHaoC.setFont(bFont);
		bianHaoC.setForeground(Color.WHITE);
		bianHaoC.setBounds(290, 190, 180, 50);
		this.add(bianHaoC);
		
		kuaiDiYuan = new JLabel("快递员列表:");
		kuaiDiYuan.setFont(sFont);
		kuaiDiYuan.setForeground(Color.WHITE);
		kuaiDiYuan.setBounds(120, 260, 180, 40);
		this.add(kuaiDiYuan);
		
		yeWuYuan = new JLabel("业务员列表:");
		yeWuYuan.setFont(sFont);
		yeWuYuan.setForeground(Color.WHITE);
		yeWuYuan.setBounds(330, 260, 180, 40);
		this.add(yeWuYuan);
		
		if (businessController.getCourierList(ID) != null) {
			String addCurier = "增加快递员";
			kuaiDiYuanb = new JComboBox(businessController.getCourierList(ID));
			kuaiDiYuanb.addItem(addCurier);
		}else {
			String[] a = {"增加快递员"};
			kuaiDiYuanb = new JComboBox(a);
		}
		kuaiDiYuanb.setFont(sFont);
		kuaiDiYuanb.setForeground(Color.BLACK);
		kuaiDiYuanb.setBounds(120, 310, 180, 40);		
		kuaiDiYuanb.setSelectedIndex(-1);
		this.add(kuaiDiYuanb);
		
		if (businessController.getBussinessmanList(ID) != null) {
			String addAssisant = "增加业务员";
			yeWuYuanb = new JComboBox(businessController.getBussinessmanList(ID));
			yeWuYuanb.addItem(addAssisant);
		}else {
			String [] a = {"增加业务员"};
			yeWuYuanb = new JComboBox(a);
		}		
		yeWuYuanb.setFont(sFont);
		yeWuYuanb.setForeground(Color.BLACK);
		yeWuYuanb.setBounds(330, 310, 180, 40);		
		yeWuYuanb.setSelectedIndex(-1);
		this.add(yeWuYuanb);
		
		AccountInfoController accountInfoController = new AccountInfoController();
		
		if (accountInfoController.getAccountList() != null) {
			kongXianK = new JComboBox(accountInfoController.getAccountList());
			kongXianK.setFont(sFont);
			kongXianK.setForeground(Color.BLACK);
			kongXianK.setBounds(120, 360, 180, 40);
			kongXianK.setVisible(false);
			kongXianK.setSelectedIndex(-1);
			this.add(kongXianK);
		}
		
		if (accountInfoController.getAccountList() != null) {
			kongXianY = new JComboBox(accountInfoController.getAccountList());
			kongXianY.setFont(sFont);
			kongXianY.setForeground(Color.BLACK);
			kongXianY.setBounds(330, 360, 180, 40);
			kongXianY.setVisible(false);
			kongXianY.setSelectedIndex(-1);
			this.add(kongXianY);
		}
		
		
		
		//到时候再加图片
		returnButton=new JButton(returnIcon);		
		returnButton.setBounds(662, 575,48,48);
		returnButton.setContentAreaFilled(false);
		this.add(returnButton);

		this.setBounds(260, 60, 730, 650);
		this.setLayout(null);
		this.setOpaque(false);
	}
	
	private void registListener(final b2topmanagerui b2ui,final topmanagerJpanel tjpl,final b2BusinessChange b2BusinessChange,final String ID) {
		
		final BusinessController businessController = new BusinessController();
		final AccountInfoController accountInfoController = new AccountInfoController();
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tjpl.remove(b2BusinessChange);
				new b2BusinessInfo(b2ui, tjpl, ID);
				tjpl.repaint();
			}
		});
		
		
		
		kuaiDiYuanb.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				int state = e.getStateChange();
				if(state==ItemEvent.SELECTED){
					if (!kuaiDiYuanb.getSelectedItem().equals("增加快递员")) {
						Object[] options = { "确定", "取消" };
						int result = JOptionPane.showOptionDialog(null, "删除快递员", "删除该快递员", JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
						if (result == 0) {
							String temd = (String)kuaiDiYuanb.getSelectedItem();
							String[] Temp = temd.split("-");
							businessController.removeCourier(ID, Long.parseLong(Temp[0]));
							tjpl.remove(b2BusinessChange);
							new b2BusinessChange(b2ui, tjpl, ID);
							tjpl.repaint();														
						
						}
					}else {
						if (accountInfoController.getAccountList() != null) {
							kongXianK.setVisible(true);
						}
						
					}
					
				}
				
			}
		});
		
		if (accountInfoController.getAccountList() != null) {
			kongXianK.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					BusinessController businessController = new BusinessController();
					int state = e.getStateChange();
					if(state==ItemEvent.SELECTED){
						String temp = (String) kongXianK.getSelectedItem();
						String[] arr = temp.split("-");
						businessController.addCourier(ID, Long.parseLong(arr[0]));
						tjpl.remove(b2BusinessChange);
						new b2BusinessChange(b2ui, tjpl, ID);
						tjpl.repaint();
						
					}
				}
			});
		}
		
		
		yeWuYuanb.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				BusinessController businessController = new BusinessController();
				int state = e.getStateChange();
				if(state==ItemEvent.SELECTED){
					if (!yeWuYuanb.getSelectedItem().equals("增加业务员")) {
						Object[] options = { "确定", "取消" };
						int result = JOptionPane.showOptionDialog(null, "删除业务员", "删除改业务员", JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
						if (result == 0) {
							String temd = (String)yeWuYuanb.getSelectedItem();
							String[] Temp = temd.split("-");
							businessController.removeBussinessman(ID, Long.parseLong(Temp[0]));
							yeWuYuanb = new JComboBox(businessController.getBussinessmanList(ID));
							tjpl.remove(b2BusinessChange);
							new b2BusinessChange(b2ui, tjpl, ID);
							tjpl.repaint();														
						
						}
					}else {
						if (accountInfoController.getAccountList() != null) {
							kongXianY.setVisible(true);
						}
						
					}
					
				}
				
			}
		});
		
		if (accountInfoController.getAccountList() != null) {
			kongXianY.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					BusinessController businessController = new BusinessController();
					int state = e.getStateChange();
					if(state==ItemEvent.SELECTED){
						String temp = (String) kongXianY.getSelectedItem();
						String[] arr = temp.split("-");
						businessController.addBussinessman(ID, Long.parseLong(arr[0]));
						tjpl.remove(b2BusinessChange);
						new b2BusinessChange(b2ui, tjpl, ID);
						tjpl.repaint();
						
					}
					
				}
			});
		}
		
		
		
	}
	public void paintComponent(Graphics g)  
	{  
	    super.paintComponent(g);    
	    g.drawImage(frameIcon.getImage(),-7,-12,null);
     }

}
