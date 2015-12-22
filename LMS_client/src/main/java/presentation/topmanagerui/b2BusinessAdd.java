package presentation.topmanagerui;

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

import businesslogic.organizationbl.BusinessController;
import businesslogic.organizationbl.MiddleController;
import vo.orgVO.BussinessOrgVO;

public class b2BusinessAdd extends JPanel {
	
	private JLabel diQu,zhongZhuan;
	private JTextField diQuF,zhongZhuanF;
	private JButton yesButton,returnButton;
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");	
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	private ImageIcon yesIcon=new ImageIcon("picture/确定.png");
	
	public b2BusinessAdd(b2topmanagerui b2ui,topmanagerJpanel tjpl,String org){
		init();
		tjpl.add(this);
		registListener(b2ui, tjpl, this, org);
	}
    private void init() {
    	Font font = new Font("幼圆", Font.BOLD, 30);
    	
    	diQu = new JLabel("所在地区:");
    	diQu.setFont(font);
    	diQu.setForeground(Color.WHITE);
    	diQu.setBounds(100, 150, 180, 60);
    	this.add(diQu);
    	
    	diQuF = new JTextField();
    	diQuF.setFont(font);
    	diQuF.setForeground(Color.BLACK);
    	diQuF.setBounds(290, 150, 200, 60);
    	this.add(diQuF);
    	
    	zhongZhuan = new JLabel("所属中转中心编号:");
    	zhongZhuan.setFont(font);
    	zhongZhuan.setForeground(Color.WHITE);
    	zhongZhuan.setBounds(100, 250, 280, 60);
    	this.add(zhongZhuan);
    	
    	zhongZhuanF = new JTextField();
    	zhongZhuanF.setFont(font);
    	zhongZhuanF.setForeground(Color.BLACK);
    	zhongZhuanF.setBounds(390, 250, 200, 60);
    	this.add(zhongZhuanF);
    	
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
    
    private void registListener(final b2topmanagerui b2ui,final topmanagerJpanel tjpl,final b2BusinessAdd b2BusinessAdd,final String org) {
		
    	final MiddleController middleController = new MiddleController();
    	final BusinessController businessController = new BusinessController();
    	
    	returnButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tjpl.remove(b2BusinessAdd);
				new b2SearchOrg(b2ui, tjpl, org);
				tjpl.repaint();
				
			}
		});

		yesButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String di = diQuF.getText();
				String zhong = zhongZhuanF.getText();
				if (zhong.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入所属中转中心编号");
				}
				if (di.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入所在地区");
				}
				
				if ((!zhong.equals("")) && (!di.equals(""))) {							
					String mCity = middleController.GetInfo(zhong);
					if (mCity==null) {
						JOptionPane.showMessageDialog(tjpl, "不存在此中转中心");
					}else {
						String bianHao = "";	
						if (middleController.getBussinessHallList(zhong) != null) {
							int n = middleController.getBussinessHallList(zhong).length;
							if (n < 9) {
								bianHao = "00" + String.valueOf(n + 1);
							}else if (n < 99) {
								bianHao = "0" + String.valueOf(n + 1);
							}else {
								bianHao = String.valueOf(n + 1);
							}
						}else {
							bianHao = "001";
						}
						BussinessOrgVO vo = new BussinessOrgVO(mCity, di, zhong + "-" +bianHao, zhong, null, null, null, null);
						boolean result = businessController.addBussinessHall(bianHao, vo);
						if (result) {
							JOptionPane.showMessageDialog(tjpl, "创建成功,机构编号为"+ zhong + "-" + bianHao);
							tjpl.remove(b2BusinessAdd);
							new b2SearchOrg(b2ui, tjpl, org);
							tjpl.repaint();
						}else {
							JOptionPane.showMessageDialog(tjpl, "修改失败,已存在同名营业厅");
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
