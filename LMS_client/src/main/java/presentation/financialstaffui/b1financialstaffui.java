package presentation.financialstaffui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.rmi.RemoteException;
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
	static Point origin = new Point();
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
		b1financialstaffui.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				// 当鼠标按下的时候获得窗口当前的位置
				origin.x = e.getX();
				origin.y = e.getY();
			}
		});
		b1financialstaffui.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				// 当鼠标拖动时获取窗口当前位置
				Point p = b1financialstaffui.getLocation();
				// 设置窗口的位置
				// 窗口当前的位置 + 鼠标当前在窗口的位置 - 鼠标按下的时候在窗口的位置
				b1financialstaffui.setLocation(p.x + e.getX() - origin.x, p.y + e.getY()- origin.y);
			}
		});
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
		try {
			proController = new ProfitController();
			profitList = new ProfitListBL();
			vo = proController.returnPro(date);
			ArrayList<ProfitVO> tempList = profitList.getProList();
			proController.addPro();
			for(int i =0 ; i<tempList.size();i++){
				voList.add(tempList.get(i));
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new InternetDialog(this);
		}
		voList.add(vo);
	}
	//得到成本收益集合的方法
	
	
}
