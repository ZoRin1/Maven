package presentation.adminui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vo.accountVO.AccountNumberVO;

public class AccountInfo extends JPanel {
	
	//sdajf;sdf;safs
	private JLabel daBiaoTi,zhangHao,zangHaoI,miMa,miMaI,xinMing,xinMingI,dianHua,dianHuaI,shenFenZhengHao,shenFenZhengHaoI,zhuCeRiQi,zhuCeRiQiI;
	private JButton change,delete,returnButton;
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	private ImageIcon yesIcon=new ImageIcon("picture/确定.png");
	
	public AccountInfo(adminui aui,adminJpanel apl,AccountNumberVO accountNumberVO){
		init(accountNumberVO);
		aui.setTitle("账号详细信息");
		apl.add(this);
		registListener(aui, apl, this,accountNumberVO);
	}

	
	
	private void init(AccountNumberVO accountNumberVO){
		
		Font fontB=new Font("幼圆",Font.BOLD,30);
		Font font=new Font("幼圆",Font.BOLD,25);
		
		daBiaoTi = new JLabel("账号详细信息");
		daBiaoTi.setForeground(Color.WHITE);
		daBiaoTi.setFont(fontB);
		daBiaoTi.setBounds(180, 50, 500, 50);
		this.add(daBiaoTi);
		
		
		zhangHao = new JLabel("账号：");
		zhangHao.setForeground(Color.WHITE);
		zhangHao.setFont(font);
		zhangHao.setBounds(100, 150, 80, 40);
		this.add(zhangHao);
		
		zangHaoI = new JLabel(Long.toString(accountNumberVO.getID()));
		zangHaoI.setForeground(Color.WHITE);
		zangHaoI.setFont(font);
		zangHaoI.setBounds(180, 150, 150, 40);
		this.add(zangHaoI);
		
		
		miMa = new JLabel("密码：");
		miMa.setForeground(Color.WHITE);
		miMa.setFont(font);
		miMa.setBounds(340, 150, 80, 40);
		this.add(miMa);
		
		miMaI = new JLabel(accountNumberVO.getPassword());
		miMaI.setForeground(Color.WHITE);
		miMaI.setFont(font);
		miMaI.setBounds(430, 150, 120, 40);
		this.add(miMaI);
		
		
		xinMing = new JLabel("姓名：");
		xinMing.setForeground(Color.WHITE);
		xinMing.setFont(font);
		xinMing.setBounds(100, 230, 80, 40);
		this.add(xinMing);
		
		xinMingI = new JLabel(accountNumberVO.getName());
		xinMingI.setForeground(Color.WHITE);
		xinMingI.setFont(font);
		xinMingI.setBounds(180, 230, 200, 40);
		this.add(xinMingI);
		
			
		dianHua = new JLabel("电话：");
		dianHua.setFont(font);
		dianHua.setForeground(Color.WHITE);
		dianHua.setBounds(340, 230, 80, 40);
		this.add(dianHua);
		
		dianHuaI = new JLabel(accountNumberVO.getPhone());
		dianHuaI.setForeground(Color.WHITE);
		dianHuaI.setFont(font);
		dianHuaI.setBounds(430, 230, 180, 40);
		this.add(dianHuaI);
		
		
		shenFenZhengHao = new JLabel("身份证号码：");
		shenFenZhengHao.setForeground(Color.WHITE);
		shenFenZhengHao.setFont(font);
		shenFenZhengHao.setBounds(100, 310, 180, 40);
		this.add(shenFenZhengHao);
		
		shenFenZhengHaoI = new JLabel(accountNumberVO.getsID());
		shenFenZhengHaoI.setForeground(Color.WHITE);
		shenFenZhengHaoI.setFont(font);
		shenFenZhengHaoI.setBounds(260, 310, 300, 40);
		this.add(shenFenZhengHaoI);
		
		zhuCeRiQi = new JLabel("注册日期：");
		zhuCeRiQi.setForeground(Color.WHITE);
		zhuCeRiQi.setFont(font);
		zhuCeRiQi.setBounds(100, 390, 160, 40);
		this.add(zhuCeRiQi);
		
		zhuCeRiQiI = new JLabel(accountNumberVO.getDate());
		zhuCeRiQiI.setForeground(Color.WHITE);
		zhuCeRiQiI.setFont(font);
		zhuCeRiQiI.setBounds(240, 390, 180, 40);
		this.add(zhuCeRiQiI);
		
		//到时候再加图片
		change = new JButton("修改");
		change.setForeground(Color.BLACK);
		change.setContentAreaFilled(true);
		change.setBorderPainted(true);
		change.setBounds(120, 470, 160, 50);
		this.add(change);

		delete = new JButton("删除");
		delete.setForeground(Color.BLACK);
		delete.setContentAreaFilled(true);
		delete.setBorderPainted(true);
		delete.setBounds(310, 470, 160, 50);
		this.add(delete);

		returnButton = new JButton(returnIcon);
		returnButton.setBounds(500, 470, 48, 48);
		returnButton.setContentAreaFilled(false);
		this.add(returnButton);
		
		this.setBounds(260, 60, 730,650);	
	 	this.setLayout(null);
	 	this.setOpaque(false);	
	}
	
	
	private void registListener(final adminui aui,final adminJpanel apl,final AccountInfo accountInfo,final AccountNumberVO accountNumberVO) {
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				apl.remove(accountInfo);
				apl.add(aui.operationJpanel);
				aui.accountField.setEditable(true);
				aui.searchButton.setEnabled(true);
				aui.addaccountButton.setEnabled(true);
				
				aui.repaint();
				
				
				
			}
		});
		
		change.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				apl.remove(accountInfo);
				
				new ChangeAccount(aui, apl, accountInfo, accountNumberVO);
				
				aui.repaint();
			}
		});
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object[] options = {"确定","取消"};
				int result = JOptionPane.showOptionDialog(null, "删除账号", "删除账号", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
						null, options, options[1]);
				if (result == 0) {
					apl.remove(accountInfo);
					apl.add(aui.operationJpanel);					
					aui.accountField.setEditable(true);
					aui.searchButton.setEnabled(true);
					aui.addaccountButton.setEnabled(true);
					aui.repaint();
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
