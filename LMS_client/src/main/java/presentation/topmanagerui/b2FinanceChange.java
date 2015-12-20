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

import businesslogic.accountbl.AccountInfoController;
import businesslogic.organizationbl.FinanceController;
import businesslogic.organizationbl.MiddleController;

public class b2FinanceChange extends JPanel {
	private JLabel bianHao,biaoHaoI,caiWuRenYuan;
    private JButton returnButton;
    private JComboBox caiWuRenYuanB,kongXian;
	
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");	
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	
	public b2FinanceChange(b2topmanagerui b2ui,topmanagerJpanel tjpl){
		init();
		tjpl.add(this);
		registListener(b2ui, tjpl, this);
	}
	
	private void init() {
		Font bFont = new Font("幼圆", Font.BOLD, 30);
		Font sFont = new Font("幼圆", Font.BOLD, 20);
		FinanceController financeController = new FinanceController();
		AccountInfoController accountInfoController = new AccountInfoController();
		
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
			String k = "增加财务人员";
			caiWuRenYuanB = new JComboBox(financeController.getFinancersList());
			caiWuRenYuanB.addItem(k);
		}else {
			String[] a = {"增加财务人员"};
			caiWuRenYuanB = new JComboBox(a);
		}		
		caiWuRenYuanB.setFont(sFont);
		caiWuRenYuanB.setForeground(Color.BLACK);
		caiWuRenYuanB.setBounds(240, 250, 180, 40);
		caiWuRenYuanB.setSelectedIndex(-1);
		this.add(caiWuRenYuanB);
		
		if (accountInfoController.getAccountList() != null) {
			kongXian = new JComboBox(accountInfoController.getAccountList());
			kongXian.setFont(sFont);
			kongXian.setForeground(Color.BLACK);
			kongXian.setBounds(240, 300, 180, 40);
			kongXian.setSelectedIndex(-1);
			kongXian.setVisible(false);
			this.add(kongXian);
		}
				


		returnButton = new JButton(returnIcon);
		returnButton.setBounds(500, 400, 48, 48);
		returnButton.setContentAreaFilled(false);
		this.add(returnButton);

		this.setBounds(260, 60, 730, 650);
		this.setLayout(null);
		this.setOpaque(false);
	}
	
	private void registListener(final b2topmanagerui b2ui,final topmanagerJpanel tjpl,final b2FinanceChange b2FinanceChange) {
		
		final AccountInfoController accountInfoController = new AccountInfoController();
		final FinanceController financeController = new FinanceController();
		
		returnButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				tjpl.remove(b2FinanceChange);
				new b2FianaceInfo(b2ui, tjpl);
				tjpl.repaint();
			}
		});

		
		caiWuRenYuanB.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				FinanceController financeController = new FinanceController();
				int state = e.getStateChange();
				if (state == ItemEvent.SELECTED) {
					if (!caiWuRenYuanB.getSelectedItem().equals("增加财务人员")) {
						Object[] options = { "确定", "取消" };
						int result = JOptionPane.showOptionDialog(null, "删除财务人员", "删除该财务人员", JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
						if (result == 0) {
							String temd = (String) caiWuRenYuanB.getSelectedItem();
							String[] Temp = temd.split("-");
							financeController.removeFinancer(Long.parseLong(Temp[0]));
							tjpl.remove(b2FinanceChange);
							new b2FinanceChange(b2ui, tjpl);
							tjpl.repaint();

						}
					} else {
						
						if (accountInfoController.getAccountList() != null) {
							kongXian.setVisible(true);
						}						
					}

				}

			}
		});
		if (accountInfoController.getAccountList() != null) {
			kongXian.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					FinanceController financeController = new FinanceController();
					int state = e.getStateChange();
					if (state == ItemEvent.SELECTED) {
						String temp = (String) kongXian.getSelectedItem();
						String[] arr = temp.split("-");
						financeController.addFinancer(Long.parseLong(arr[0]));
						tjpl.remove(b2FinanceChange);
						new b2FinanceChange(b2ui, tjpl);
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
