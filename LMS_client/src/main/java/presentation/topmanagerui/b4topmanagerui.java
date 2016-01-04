package presentation.topmanagerui;

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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class b4topmanagerui extends JFrame{
	static Point origin = new Point();
		private topmanagerJpanel topmanagerJpanel;
		topmanagerb4OperationJpanel operationJpanel;
		JButton b1,b2;
		private JButton tuichuButton;
		private JButton zuixiaohuaButton;
		public b4topmanagerui(String s,topmanagerui tmui) {
			// TODO Auto-generated constructor stub
			super(s);
			init(tmui);
			registListener(this);
		}
		private void registListener(final b4topmanagerui b4topmanagerui) {
			// TODO Auto-generated method stub
			b4topmanagerui.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					// 当鼠标按下的时候获得窗口当前的位置
					origin.x = e.getX();
					origin.y = e.getY();
				}
			});
			b4topmanagerui.addMouseMotionListener(new MouseMotionAdapter() {
				public void mouseDragged(MouseEvent e) {
					// 当鼠标拖动时获取窗口当前位置
					Point p = b4topmanagerui.getLocation();
					// 设置窗口的位置
					// 窗口当前的位置 + 鼠标当前在窗口的位置 - 鼠标按下的时候在窗口的位置
					b4topmanagerui.setLocation(p.x + e.getX() - origin.x, p.y + e.getY()- origin.y);
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
					b4topmanagerui.setExtendedState(JFrame.ICONIFIED);
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
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					topmanagerJpanel.remove(b4topmanagerui.operationJpanel);
					b1.setEnabled(false);
					b2.setEnabled(false);
					new b4Management(b4topmanagerui, topmanagerJpanel);
					topmanagerJpanel.repaint();
				}
			});
			b2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					topmanagerJpanel.remove(b4topmanagerui.operationJpanel);
					b1.setEnabled(false);
					b2.setEnabled(false);
					new b4Benifit(b4topmanagerui, topmanagerJpanel);
					topmanagerJpanel.repaint();
				}
			});
		}
		private void init(topmanagerui topmanagerui){
			topmanagerJpanel=new topmanagerJpanel();
			operationJpanel=new topmanagerb4OperationJpanel(topmanagerJpanel,topmanagerui,this);
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
			topmanagerJpanel.add(b1);
			topmanagerJpanel.add(b2);
			topmanagerJpanel.add(tuichuButton);
			topmanagerJpanel.add(zuixiaohuaButton);
			topmanagerJpanel.setLayout(null);
			this.add(topmanagerJpanel);
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
class topmanagerb4OperationJpanel extends JPanel{
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JButton returnButton;
	public topmanagerb4OperationJpanel(topmanagerJpanel topmanagerJpanel,topmanagerui topmanagerui,b4topmanagerui b4topmanagerui) {
		// TODO Auto-generated constructor stub
		init();
		topmanagerJpanel.add(this);
		registListener(topmanagerui, b4topmanagerui);
	}
	private void init(){
		ImageIcon returnIcon=new ImageIcon("picture/返回.png");
		returnButton=new JButton(returnIcon);
		returnButton.setBounds(662, 575, 48,48);
		returnButton.setContentAreaFilled(false);
		this.setBounds(260, 60,730,650);
		this.setOpaque(false);
		this.setLayout(null);
		this.add(returnButton);
	}
	private void registListener(final topmanagerui tmui,final b4topmanagerui b4tmui){
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tmui.setVisible(true);
				b4tmui.dispose();
				
			}
		});
	}
	public void paintComponent(Graphics g)  
	{  
	    super.paintComponent(g);    
	    g.drawImage(frameIcon.getImage(),-7,-12,null);
     }
}
