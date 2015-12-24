package presentation.topmanagerui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businesslogic.organizationbl.MiddleController;
import businesslogic.transportationbl.CityController;
import businesslogic.transportationbl.TransportationController;
import presentation.financialstaffui.financialstaffui;
import vo.orgVO.BussinessOrgVO;
import vo.orgVO.MiddleOrgVO;

public class b2MiddleAdd extends JPanel {
	
	private JLabel diQu;
	private JTextField diQuF;
	private JButton yesButton,returnButton;
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");	
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	private ImageIcon yesIcon=new ImageIcon("picture/确定.png");
	
	public b2MiddleAdd(b2topmanagerui b2ui,topmanagerJpanel tjpl,String org){
		init();
		tjpl.add(this);
		try {
			registLIstener(b2ui, tjpl, this, org);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new InternetDialog(b2ui);
		}
	}

	private void init() {
    	Font font = new Font("幼圆", Font.BOLD, 30);
    	
    	diQu = new JLabel("所在城市:");
    	diQu.setFont(font);
    	diQu.setForeground(Color.WHITE);
    	diQu.setBounds(100, 250, 180, 60);
    	this.add(diQu);
    	
    	diQuF = new JTextField();
    	diQuF.setFont(font);
    	diQuF.setForeground(Color.BLACK);
    	diQuF.setBounds(290, 250, 200, 60);
    	this.add(diQuF);
    	
    	
    	//到时候再加图片
		returnButton = new JButton(returnIcon);
		returnButton.setBounds(662, 575,48,48);
		returnButton.setContentAreaFilled(false);
		this.add(returnButton);

		yesButton = new JButton(yesIcon);
		yesButton.setBounds(602, 575,48,48);
		yesButton.setContentAreaFilled(false);
		this.add(yesButton);

		this.setBounds(260, 60, 730, 650);
		this.setLayout(null);
		this.setOpaque(false);
		
	}
	
	private void registLIstener(final b2topmanagerui b2ui,final topmanagerJpanel tjpl,final b2MiddleAdd b2MiddleAdd,final String org) throws RemoteException {
		
		final TransportationController transportationController = new TransportationController();
		final MiddleController middleController = new MiddleController();
		
		returnButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tjpl.remove(b2MiddleAdd);
				new b2SearchOrg(b2ui, tjpl, org);
				tjpl.repaint();
				
			}
		});
		
		yesButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String di = diQuF.getText();
				if (di.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入所在地区");
				}
				
				if (!di.equals("")) {
					String bianHao = "";
					String mCity = diQuF.getText();
					if (transportationController.getCityList(null) != null) {
						String[] citys = transportationController.getCityList(null);
						int n = citys.length;
						boolean b = true;
						for(int i = 0; i < n; i ++){
							if (mCity.equals(citys[i])) {
								b = false;
							}
						}
						if (b) {
							if (n < 9) {
								bianHao = "00" + String.valueOf(n + 1);
							}else if (n < 99) {
								bianHao = "0" + String.valueOf(n + 1);
							}else {
								bianHao = String.valueOf(n + 1);
							}
							MiddleOrgVO vo = new MiddleOrgVO(mCity, bianHao, null, null, null);
							boolean r1 = middleController.addMiddleOrg(bianHao, vo);
							CityController cityController = null;
							try {
								cityController = new CityController();
							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
								new InternetDialog(b2ui);
							}
							boolean r2 = cityController.addCity(mCity);
							if (r1 && r2) {
								JOptionPane.showMessageDialog(tjpl, "创建成功,机构编号为" + bianHao);
								tjpl.remove(b2MiddleAdd);
								new b2SearchOrg(b2ui, tjpl, org);
								tjpl.repaint();
							}else {
								JOptionPane.showMessageDialog(tjpl, "创建失败,请重试");
							}
							
						}else {
							JOptionPane.showMessageDialog(null, "该城市已存在，请重新输入");
						}
						
					}
			
					
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
