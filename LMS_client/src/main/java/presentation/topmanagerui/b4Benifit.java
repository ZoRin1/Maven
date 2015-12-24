package presentation.topmanagerui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import businesslogic.financebl.ProfitListModel.ProfitListBL;
import businesslogic.financebl.ProfitModel.ProfitController;
import presentation.financialstaffui.b1b2Jpanel1JTable;
import vo.financeVO.ProfitVO;

public class b4Benifit extends JPanel {
	
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JButton returnButton;
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	private JLabel j1;
	private ArrayList<ProfitVO> voList = new ArrayList<>();
	private ProfitVO  vo;
	
	public b4Benifit(b4topmanagerui b4ui,topmanagerJpanel tjpl) {
		// TODO Auto-generated constructor stub
		try {
			getProfit();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new InternetDialog(b4ui);
		}
		init(b4ui, tjpl);
		tjpl.add(this);
		registListener(b4ui, tjpl, this);
		
	}
	private void init(b4topmanagerui b4ui,topmanagerJpanel tjpl){
		Font font=new Font("幼圆",Font.BOLD,20);
		ImageIcon i1 = new ImageIcon("picture/财务图片/成本收益表框架.png");
		j1 = new JLabel(i1);
		j1.setBounds(0, 0, 723, 571);
		if (!voList.isEmpty()) {
			b4BenifitTable b4table = new b4BenifitTable(b4ui, tjpl, voList);
			j1.add(b4table.getScrollPane());
			this.add(j1);
		}else {
			JOptionPane.showMessageDialog(null, "未找到相关数据");
		}
		
		
		returnButton=new JButton(returnIcon);
		returnButton.setBounds(662, 575,48,48);
		returnButton.setContentAreaFilled(false);

	 	this.setBounds(260, 60, 730,650);

	 	
	 	this.add(returnButton);
	 	
	 	this.setLayout(null);
	 	this.setOpaque(false);
	}

	//得到成本收益集合的方法
	public void getProfit() throws RemoteException{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String date = df.format(new Date());
			ProfitController proController = new ProfitController();
			ProfitListBL profitListBL = new ProfitListBL();
			vo = proController.returnPro(date);
			if (vo != null) {
				ArrayList<ProfitVO> tempList = profitListBL.getProList();
				voList.add(vo);
				for(int i =0 ; i<tempList.size();i++){
					voList.add(tempList.get(i));
			}
			
			
			}
//			profitList = new ArrayList<ProfitVO>();
//			ProfitVO v1 = new ProfitVO(2.3, 5.5, "2015-10-17 13:56:20");
//			ProfitVO v2 = new ProfitVO(2, 5.5, "2015-10-17 13:56:20");
//			ProfitVO v3 = new ProfitVO(2.3, 5.5, "2015-10-17 13:56:20");
//			ProfitVO v4 = new ProfitVO(2.3, 5.5, "2015-10-17 13:56:20");
//			ProfitVO v5 = new ProfitVO(2.3, 5.5, "2015-10-17 13:56:20");
//			ProfitVO v6 = new ProfitVO(2.3, 5.5, "2015-10-17 13:56:20");
//			ProfitVO v7 = new ProfitVO(2.3, 5.5, "2015-10-17 13:56:20");
//			ProfitVO v8 = new ProfitVO(2.3, 5.5, "2015-10-17 13:56:20");
//			profitList.add(v1);
//			profitList.add(v2);
//			profitList.add(v3);
//			profitList.add(v4);
//			profitList.add(v5);
//			profitList.add(v6);
//			profitList.add(v7);
//			profitList.add(v8);
		}
	//得到成本收益集合的方法
		
	private void registListener(final b4topmanagerui b4ui,final topmanagerJpanel tjpl,final b4Benifit b4Benifit) {
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tjpl.remove(b4Benifit);
				tjpl.add(b4ui.operationJpanel);
				b4ui.b1.setEnabled(true);
				b4ui.b2.setEnabled(true);
				tjpl.repaint();
			}
		});
		
	}	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(frameIcon.getImage(), -7, -12, null);
	}

}
