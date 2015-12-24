package presentation.icwarehousemanui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class b1icwarehousemanui extends JFrame{
	private icwarehousemanJpanel icwarehousemanJpanel;
	private icwarehousemanb1OperationJpanel operationJpanel;
	private String account;
	private String state;
	public icwarehousemanb1OperationJpanel getOperationJpanel() {
		return operationJpanel;
	}
	public JButton getB1() {
		return b1;
	}
	private JButton b1;
	private JButton tuichuButton;
	private JButton zuixiaohuaButton;
	private b1Jpanel2 b1jpanel;
	public b1icwarehousemanui(String s,icwarehousemanui icwarehousemanui,String account,String state) {
		// TODO Auto-generated constructor stub
		super(s);
		this.account=account;
		this.state=state;
		init(icwarehousemanui);
		registListener(this,icwarehousemanui);
	}
	private void registListener(final b1icwarehousemanui b1icwarehousemanui,final icwarehousemanui icwarehousemanui) {
		// TODO Auto-generated method stub
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
				b1icwarehousemanui.setExtendedState(JFrame.ICONIFIED);
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
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				icwarehousemanJpanel.remove(operationJpanel);
				b1icwarehousemanui.b1.setEnabled(false);
				new b1Jpanel1(icwarehousemanui,b1icwarehousemanui,icwarehousemanJpanel,account,state);
				icwarehousemanJpanel.repaint();
			}
		});
	}
	private void init(icwarehousemanui icwarehousemanui){
		icwarehousemanJpanel=new icwarehousemanJpanel();
		operationJpanel=new icwarehousemanb1OperationJpanel(icwarehousemanJpanel,icwarehousemanui,this);
		ImageIcon b1Icon=new ImageIcon("picture/新建出库单.png");
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
		b1.setBounds(30, 230,200, 50);
		b1.setContentAreaFilled(false);

		icwarehousemanJpanel.add(b1);
		icwarehousemanJpanel.add(tuichuButton);
		icwarehousemanJpanel.add(zuixiaohuaButton);
		icwarehousemanJpanel.setLayout(null);

		this.add(icwarehousemanJpanel);
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
	
}
