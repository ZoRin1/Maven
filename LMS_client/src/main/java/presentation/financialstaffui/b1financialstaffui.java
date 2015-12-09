package presentation.financialstaffui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import businesslogic.financebl.ProfitListModel.ProfitListBL;
import businesslogic.financebl.ProfitModel.ProfitController;
import vo.financeVO.ProfitVO;

public class b1financialstaffui extends JFrame{
	private financialstaffJpanel financialstaffJpanel;
	financialstaffb1OperationJpanel operationJpanel;
	JButton b1,b2;
	private JButton tuichuButton;
	private JButton zuixiaohuaButton;
	
	
	private ProfitVO vo;
	private ArrayList<ProfitVO> voList;
	private ProfitController proController;
	private ProfitListBL profitList;
	public b1financialstaffui(String s,financialstaffui fsui) {
		// TODO Auto-generated constructor stub
		super(s);
		getProfit();
		init(fsui);
		registListener(this,financialstaffJpanel);
	}
	private void registListener(final b1financialstaffui b1financialstaffui,
			final financialstaffJpanel financialstaffJpanel) {
		zuixiaohuaButton.addMouseListener(new MouseAdapter() {
			ImageIcon zuixiaohuaIcon=new ImageIcon("picture/最小化.png");
			ImageIcon zuixiaohuaIcon2=new ImageIcon("picture/最小化2.png");
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				zuixiaohuaButton.setIcon(zuixiaohuaIcon);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				zuixiaohuaButton.setIcon(zuixiaohuaIcon2);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				b1financialstaffui.setExtendedState(JFrame.ICONIFIED);
			}
		});
		tuichuButton.addMouseListener(new MouseAdapter() {
			ImageIcon tuichuIcon=new ImageIcon("picture/退出.png");
			ImageIcon tuichuIcon2=new ImageIcon("picture/退出2.png");
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);	
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				tuichuButton.setIcon(tuichuIcon);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				tuichuButton.setIcon(tuichuIcon2);
			}
		});
		// TODO Auto-generated method stub
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new b1b1Jpanel1(b1financialstaffui, financialstaffJpanel);
				financialstaffJpanel.remove(operationJpanel);
				b1.setEnabled(false);
				b2.setEnabled(false);
				financialstaffJpanel.repaint();
			}
		});
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new b1b2Jpanel1(b1financialstaffui, financialstaffJpanel,voList);
				financialstaffJpanel.remove(operationJpanel);
				b1.setEnabled(false);
				b2.setEnabled(false);
				financialstaffJpanel.repaint();
			}
		});
	}
	private void init(financialstaffui fsui){
		financialstaffJpanel=new financialstaffJpanel();
		operationJpanel=new financialstaffb1OperationJpanel(financialstaffJpanel,fsui,this);
		ImageIcon b1Icon=new ImageIcon("picture/经营情况.png");
		ImageIcon b2Icon=new ImageIcon("picture/成本收益.png");
		ImageIcon tuichuIcon=new ImageIcon("picture/退出.png");
		ImageIcon zuixiaohuaIcon=new ImageIcon("picture/最小化.png");
		zuixiaohuaButton=new JButton(zuixiaohuaIcon);
		zuixiaohuaButton.setBounds(904, 0, 50, 50);
		zuixiaohuaButton.setContentAreaFilled(false);
		zuixiaohuaButton.setBorderPainted(false);
		tuichuButton=new JButton(tuichuIcon);
		tuichuButton.setBounds(974, 0, 50, 50);
		tuichuButton.setContentAreaFilled(false);
		tuichuButton.setBorderPainted(false);
		b1=new JButton(b1Icon);
		b2=new JButton(b2Icon);
		b1.setContentAreaFilled(false);
		b2.setContentAreaFilled(false);
	
		b1.setBounds(30, 230,200, 50);
		b2.setBounds(30, 430,200, 50);
		financialstaffJpanel.add(b1);
		financialstaffJpanel.add(b2);
		financialstaffJpanel.add(tuichuButton);
		financialstaffJpanel.add(zuixiaohuaButton);
		financialstaffJpanel.setLayout(null);

		this.add(financialstaffJpanel);
		this.setSize( 1024, 730);
		//居中
		Toolkit kitToolkit =Toolkit.getDefaultToolkit();
		Dimension screenSize=kitToolkit.getScreenSize();
		int screenWidth=screenSize.width;
		int screenHeight=screenSize.height;
		int windowWidth=this.getWidth();
		int windowHeight=this.getHeight();
		this.setLocation((screenWidth-windowWidth)/2, (screenHeight-windowHeight)/2);
		//不允许窗口改变大小
		this.setResizable(false);
		this.setUndecorated(true);
		this.setVisible(true);
	}
	
	//得到成本收益集合的方法
	public void getProfit(){
		voList=new ArrayList<>();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());
		proController = new ProfitController();
		profitList = new ProfitListBL();
		vo = proController.returnPro(date);
		proController.addPro();
		ArrayList<ProfitVO> tempList = profitList.getProList();
		voList.add(vo);
		for(int i =0 ; i<tempList.size();i++){
			voList.add(tempList.get(i));
		}
//		voList = new ArrayList<ProfitVO>();
//		ProfitVO v1 = new ProfitVO(2.3, 5.5, "2015-10-17 13:56:20");
//		ProfitVO v2 = new ProfitVO(2, 5.5, "2015-10-17 13:56:20");
//		ProfitVO v3 = new ProfitVO(2.3, 5.5, "2015-10-17 13:56:20");
//		ProfitVO v4 = new ProfitVO(2.3, 5.5, "2015-10-17 13:56:20");
//		ProfitVO v5 = new ProfitVO(2.3, 5.5, "2015-10-17 13:56:20");
//		ProfitVO v6 = new ProfitVO(2.3, 5.5, "2015-10-17 13:56:20");
//		ProfitVO v7 = new ProfitVO(2.3, 5.5, "2015-10-17 13:56:20");
//		ProfitVO v8 = new ProfitVO(2.3, 5.5, "2015-10-17 13:56:20");
//		voList.add(v1);
//		voList.add(v2);
//		voList.add(v3);
//		voList.add(v4);
//		voList.add(v5);
//		voList.add(v6);
//		voList.add(v7);
//		voList.add(v8);
	}
	//得到成本收益集合的方法
	
}

class financialstaffb1OperationJpanel extends JPanel{
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JButton returnButton;
	public financialstaffb1OperationJpanel(financialstaffJpanel financialstaffJpanel,financialstaffui fsui,b1financialstaffui b1fsui) {
		// TODO Auto-generated constructor stub
		init();
		financialstaffJpanel.add(this);
		registListener(fsui, b1fsui);
	}
	private void init(){
		ImageIcon returnIcon=new ImageIcon("picture/返回.png");
		returnButton=new JButton(returnIcon);
		returnButton.setBounds(662, 575, 48,48);
		returnButton.setContentAreaFilled(false);	
		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(260, 60,730,650);
		this.add(returnButton);
	}
	private void registListener(final financialstaffui fsui,final b1financialstaffui b1fsui){
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fsui.setVisible(true);
				b1fsui.dispose();
		
			}
		});
	}
	public void paintComponent(Graphics g)  
	{  
	    super.paintComponent(g);    
	    g.drawImage(frameIcon.getImage(),-7,-12,null);
     }
	
}