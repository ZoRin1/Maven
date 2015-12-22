package presentation.adminui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.AppletInitializer;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import po.accountPO.AccountInfoPO;
import businesslogic.accountbl.AccountInfoController;
import vo.accountVO.AccountNumberVO;

public class ChangeAccount extends JPanel {
	private JLabel daBiaoTi;
	private JLabel zhangHao;
	private JLabel zhangHaoNo;
	private JLabel miMa;
	private JTextField miMaF;
	private JLabel miMaTishi;
	private JLabel xinMing;
	private JTextField xinMingF;
	private JLabel xinMingTiShi;
	private JLabel dianHua;
	private JTextField dianHuaF;
	private JLabel dianHuaTiShi;
	private JLabel shenFenZhengHaoMa;
	private JTextField shenFenZhengHaoMaF;
	private JLabel shenFenZhengHaoMaTiShi;
	
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JButton returnButton;
	private JButton yesButton;
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	private ImageIcon yesIcon=new ImageIcon("picture/确定.png");
	protected Component aat;
	
	public ChangeAccount(adminui aui,adminJpanel apl,AccountInfo accountInfo,AccountNumberVO accountNumberVO){
		init(accountNumberVO);
		apl.add(this);
		registListener(aui, apl, this,accountNumberVO);
	}
	
private void init(AccountNumberVO accountNumberVO){
		
		Font fontB=new Font("幼圆",Font.BOLD,30);
		Font font=new Font("幼圆",Font.BOLD,20);
		
		
		daBiaoTi = new JLabel("请输入正确的信息并确定");
		daBiaoTi.setForeground(Color.WHITE);
		daBiaoTi.setFont(fontB);
		daBiaoTi.setBounds(180, 50, 500, 50);
		this.add(daBiaoTi);
		
		
		zhangHao = new JLabel("账号：");
		zhangHao.setForeground(Color.WHITE);
		zhangHao.setFont(font);
		zhangHao.setBounds(100, 150, 64, 40);
		this.add(zhangHao);
		
		long ID = accountNumberVO.getID();
		zhangHaoNo = new JLabel(String.valueOf(ID));
		zhangHaoNo.setForeground(Color.WHITE);
		zhangHaoNo.setFont(font);
		zhangHaoNo.setBounds(180, 150, 150, 40);
		this.add(zhangHaoNo);
		
		
		miMa = new JLabel("密码：");
		miMa.setForeground(Color.WHITE);
		miMa.setFont(font);
		miMa.setBounds(100, 220, 64, 40);
		this.add(miMa);
		
		miMaF = new JTextField(accountNumberVO.getPassword());
		miMaF.setFont(font);
		miMaF.setBounds(180, 220, 150, 40);
		miMaF.addKeyListener(new NumberFieldListener());
		this.add(miMaF);
		
		miMaTishi = new JLabel("(6个字母)");
		miMaTishi.setForeground(Color.WHITE);
		miMaTishi.setFont(font);
		miMaTishi.setBounds(340, 220, 100, 40);
		this.add(miMaTishi);
		
		
		xinMing = new JLabel("姓名：");
		xinMing.setForeground(Color.WHITE);
		xinMing.setFont(font);
		xinMing.setBounds(100, 300, 64, 40);
		this.add(xinMing);
		
		xinMingF = new JTextField(accountNumberVO.getName());
		xinMingF.setFont(font);
		xinMingF.setBounds(180, 300, 120, 40);
		this.add(xinMingF);
		
		xinMingTiShi = new JLabel("(2--4个汉字)");
		xinMingTiShi.setForeground(Color.WHITE);
		xinMingTiShi.setFont(font);
		xinMingTiShi.setBounds(310, 300, 160, 40);
		this.add(xinMingTiShi);
		
			
		dianHua = new JLabel("电话：");
		dianHua.setFont(font);
		dianHua.setForeground(Color.WHITE);
		dianHua.setBounds(100, 380, 64, 40);
		this.add(dianHua);
		
		dianHuaF = new JTextField(accountNumberVO.getPhone());
		dianHuaF.setFont(font);
		dianHuaF.setBounds(180, 380, 150, 40);
		dianHuaF.addKeyListener(new NumberFieldListener());
		this.add(dianHuaF);
		
		dianHuaTiShi = new JLabel("(11个数字)");
		dianHuaTiShi.setForeground(Color.WHITE);
		dianHuaTiShi.setFont(font);
		dianHuaTiShi.setBounds(340, 380, 150, 40);
		this.add(dianHuaTiShi);
		
		
		shenFenZhengHaoMa = new JLabel("身份证号码：");
		shenFenZhengHaoMa.setForeground(Color.WHITE);
		shenFenZhengHaoMa.setFont(font);
		shenFenZhengHaoMa.setBounds(100, 460, 150, 40);
		this.add(shenFenZhengHaoMa);
		
		shenFenZhengHaoMaF = new JTextField(accountNumberVO.getsID());
		shenFenZhengHaoMaF.setFont(font);
		shenFenZhengHaoMaF.setBounds(240, 460, 220, 40);
		shenFenZhengHaoMaF.addKeyListener(new NumberFieldListener());
		this.add(shenFenZhengHaoMaF);
		
		shenFenZhengHaoMaTiShi = new JLabel("(18位数字)");
		shenFenZhengHaoMaTiShi.setForeground(Color.WHITE);
		shenFenZhengHaoMaTiShi.setFont(font);
		shenFenZhengHaoMaTiShi.setBounds(470, 460, 150, 40);
		this.add(shenFenZhengHaoMaTiShi);
		
		
		returnButton=new JButton(returnIcon);		
		returnButton.setBounds(662, 575,48,48);
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

	private void registListener(final adminui aui, final adminJpanel apl, final ChangeAccount changeAccount,final AccountNumberVO accountNumberVO) {

		returnButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				apl.remove(changeAccount);
				
				new AccountInfo(aui, apl, accountNumberVO);

				apl.repaint();
			}
		});

		yesButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				changeAccount.miMaTishi.setForeground(Color.WHITE);
				changeAccount.xinMingTiShi.setForeground(Color.WHITE);
				changeAccount.dianHuaTiShi.setForeground(Color.WHITE);
				changeAccount.shenFenZhengHaoMaTiShi.setForeground(Color.WHITE);
				
				boolean bMiMa = (miMaF.getText().length() == 6);
				boolean bXinMing = (xinMingF.getText().length()>=2 && xinMingF.getText().length()<=10);
				boolean bDianHua = (dianHuaF.getText().length() == 11);
				boolean bShenFenZhengHao = (shenFenZhengHaoMaF.getText().length() == 18);
				
				if(!bMiMa){
					changeAccount.miMaTishi.setForeground(Color.RED);
				}
				if (!bXinMing) {
					changeAccount.xinMingTiShi.setForeground(Color.RED);
				}
				if (!bDianHua) {
					changeAccount.dianHuaTiShi.setForeground(Color.RED);
				}
				if (!bShenFenZhengHao) {
					changeAccount.shenFenZhengHaoMaTiShi.setForeground(Color.RED);
				}
				
				//暂时不用
				//正常使用时启用
				if(bMiMa && bXinMing && bDianHua && bShenFenZhengHao){
					AccountInfoController accountInfoController = new AccountInfoController();
					AccountNumberVO vo = accountInfoController.getInfo(Long.parseLong(zhangHaoNo.getText()));
					AccountNumberVO accountNumberVO = new AccountNumberVO(xinMingF.getText(), 
							Long.parseLong(zhangHaoNo.getText()), miMaF.getText(),
							vo.getState(), dianHuaF.getText(), shenFenZhengHaoMaF.getText(), 
							vo.getDate());
					
					boolean result = accountInfoController.changeInfo(Long.parseLong(zhangHaoNo.getText()), accountNumberVO);
					if (result) {
						JOptionPane.showMessageDialog(aui, "修改成功");
						apl.remove(changeAccount);
						apl.add(aui.operationJpanel);
						aui.accountField.setEditable(true);
						aui.searchButton.setEnabled(true);
						aui.addaccountButton.setEnabled(true);
						aui.repaint();
					}else {
						JOptionPane.showMessageDialog(null, "修改失败，请重试");
					}

				}

			}
		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(frameIcon.getImage(), -7, -12, null);
	}
}
