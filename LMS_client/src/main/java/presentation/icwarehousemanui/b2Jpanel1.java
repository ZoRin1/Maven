package presentation.icwarehousemanui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

import po.documentsPO.InBillsPO;
import po.storagePO.DepotPO;
import vo.storageVO.DepotVO;
import businesslogic.documentsbl.documentController;
import businesslogic.storagebl.DriveModel.spaceBL;
import businesslogic.storagebl.InDepotModel.InDepotBL;
import businesslogic.storagebl.InDepotModel.getPosition;

public class b2Jpanel1 extends JPanel{
	private documentController documentController;
	private InDepotBL inDepot;
	private spaceBL depot110;
	
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JButton returnButton;
	private JLabel t1,t2,t4,j1,j2,j3,j4,j5,j6,j7,j8,j9,j10,j11,t7,t8,t9;
	private JTextField t3,t5,t6;
	private JButton yesButton,sousuo;
	private String account;
	private String state;
	private getPosition getPosition;
	private ImageIcon yesIcon=new ImageIcon("picture/确定.png");
	public b2Jpanel1(b2icwarehousemanui ui,icwarehousemanJpanel icwarehousemanJpanel,String account,String state) {
		// TODO Auto-generated constructor stub
		this.account=account;
		this.state=state;
		init();
		icwarehousemanJpanel.add(this);
		registListener(ui,icwarehousemanJpanel,this);
	}
	private void init(){
		documentController=new documentController();
		inDepot = new InDepotBL();
		depot110 = new spaceBL();
		ImageIcon returnIcon=new ImageIcon("picture/返回.png");
		ImageIcon i1 = new ImageIcon("picture/库存图片/入库单.png");
		ImageIcon i2 = new ImageIcon("picture/库存图片/入库单编号.png");
		ImageIcon i3 = new ImageIcon("picture/库存图片/单据名.png");
		ImageIcon i4 = new ImageIcon("picture/库存图片/入库快递单号.png");
		ImageIcon i5 = new ImageIcon("picture/库存图片/入库日期.png");
		ImageIcon i6 = new ImageIcon("picture/库存图片/目的地.png");
		ImageIcon i7 = new ImageIcon("picture/库存图片/存储位置.png");
		ImageIcon i8 = new ImageIcon("picture/库存图片/区.png");
		ImageIcon i9 = new ImageIcon("picture/库存图片/排.png");
		ImageIcon i10 = new ImageIcon("picture/库存图片/架.png");
		ImageIcon i11 = new ImageIcon("picture/库存图片/位.png");
		ImageIcon i12 = new ImageIcon("picture/小搜索.png");

		returnButton=new JButton(returnIcon);
		j1 = new JLabel(i1);
		j2 = new JLabel(i2);
		j3 = new JLabel(i3);
		j4 = new JLabel(i4);
		j5 = new JLabel(i5);
		j6 = new JLabel(i6);
		j7 = new JLabel(i7);
		j8 = new JLabel(i8);
		j9 = new JLabel(i9);
		j10 = new JLabel(i10);
		j11 = new JLabel(i11);
		yesButton=new JButton(yesIcon);
		yesButton.setBounds(602, 575,48,48);
		yesButton.setContentAreaFilled(false);
		j1.setBounds(298,45,121,45);
		j2.setBounds(12, 137, 129, 27);
		j3.setBounds(370,136, 81, 27);
		j4.setBounds(12,194, 153, 27);
		j5.setBounds(370,194, 105, 27);
		j6.setBounds(48,264, 81, 27);
		j7.setBounds(36,340, 105, 27);
		j8.setBounds(236,344, 16, 18);
		j9.setBounds(430,344, 16, 18);
		j10.setBounds(236,409, 16, 18);
		j11.setBounds(430,409, 16, 18);
		
		t1 = new JLabel(documentController.getDocCode("入库单"));
		t2 = new JLabel("入库单");
		t3 = new JTextField();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		t4 = new JLabel(dateFormat.format(new Date()));
		t5 = new JTextField();
		t6 = new JTextField();
		t7 = new JLabel("",JLabel.CENTER);
		t8 = new JLabel("",JLabel.CENTER);
		t9 = new JLabel("",JLabel.CENTER);
		t1.setForeground(Color.white);
		t2.setForeground(Color.white);
		t4.setForeground(Color.white);
		t7.setForeground(Color.white);
		t8.setForeground(Color.white);
		t9.setForeground(Color.white);
		t1.setFont(new Font("幼圆",Font.BOLD,24));
		t2.setFont(new Font("幼圆",Font.BOLD,24));
		t3.setFont(new Font("幼圆",Font.BOLD,24));
		t4.setFont(new Font("幼圆",Font.BOLD,24));
		t5.setFont(new Font("幼圆",Font.BOLD,24));
		t6.setFont(new Font("幼圆",Font.BOLD,24));
		t7.setFont(new Font("幼圆",Font.BOLD,24));
		t8.setFont(new Font("幼圆",Font.BOLD,24));
		t9.setFont(new Font("幼圆",Font.BOLD,24));
		
		t1.setBounds(158, 138, 200, 27);
		t2.setBounds(476, 138, 200, 27);
		t3.setBounds(174, 194, 182, 27);
		t4.setBounds(475, 198, 250, 27);
		t5.setBounds(158, 264, 200, 27);
		t6.setBounds(200, 378, 98, 24);
		t7.setBounds(389, 375, 98, 24);
		t8.setBounds(200, 437, 98, 24);
		t9.setBounds(389, 437, 98, 24);
		

		sousuo = new JButton(i12);

		sousuo.setBounds(310, 378, 24, 24);
		sousuo.setContentAreaFilled(false);
		sousuo.setBorderPainted(false);
		
		
		returnButton.setBounds(662, 575,48,48);
		returnButton.setContentAreaFilled(false);
		this.add(returnButton);
		this.add(j1);
		this.add(j2);
		this.add(j3);
		this.add(j4);
		this.add(j5);
		this.add(j6);
		this.add(j7);
		this.add(j8);
		this.add(j9);
		this.add(j10);
		this.add(j11);
		this.add(t1);
		this.add(t2);
		this.add(t3);
		this.add(t4);
		this.add(t5);
		this.add(t6);
		this.add(t7);
		this.add(t8);
		this.add(t9);
		this.add(yesButton);
		this.add(sousuo);
		
		this.setOpaque(false);
		this.setBounds(260, 60, 730,650);
		this.setLayout(null);
	}
	private boolean isFull(){
		if (t3.getText().equals("")) {
			return false;
		}
		if (t5.getText().equals("")) {
			return false;
		}
		if (t6.getText().equals("")) {
			return false;
		}
		if (t7.getText().equals("")) {
			return false;
		}
		return true;
	}
	private void registListener(final b2icwarehousemanui ui,final icwarehousemanJpanel icwarehousemanJpanel,final b2Jpanel1 b2jpanel){
		t6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyChar()=='1'||e.getKeyChar()=='2'||e.getKeyChar()=='3'||e.getKeyChar()=='5'||e.getKeyChar()=='6'||e.getKeyChar()=='7') {
					if (t6.getText().length()==1) {
						e.consume();
					}
				}else {
					e.consume();
				}
			}
		});
		sousuo.addMouseListener(new MouseAdapter() {
		     ImageIcon i12 = new ImageIcon("picture/小搜索.png");
			 ImageIcon i13 = new ImageIcon("picture/小搜索红.png");
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO 自动生成的方法存根
				if (t7.getText().equals("")) {
					if (t6.getText().equals("")) {
						new failDialog(ui, "失败", true);
					}
					else {
						returnButton.setEnabled(false);
						getPosition=new getPosition();
						String stateList[]=state.split("-");	
						DepotVO vo=getPosition.getPOsition(stateList[1], Integer.parseInt(t6.getText()));
						t7.setText(Integer.toString(vo.getPai()));
						t8.setText(Integer.toString(vo.getJia()));
						t9.setText(Integer.toString(vo.getWei()));
						b2jpanel.repaint();
					}
				}			
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO 自动生成的方法存根
				sousuo.setIcon(i12);
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO 自动生成的方法存根
				sousuo.setIcon(i13);
			}
		});
		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				icwarehousemanJpanel.remove(b2jpanel);
				icwarehousemanJpanel.add(ui.getOperationJpanel());
				ui.getB1().setEnabled(true);
				icwarehousemanJpanel.repaint();
			}
		});
		yesButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (isFull()) {
					documentController.createBlock(new InBillsPO(t1.getText(), "入库单", t3.getText(), t4.getText(), account, t5.getText(), Integer.parseInt(t6.getText()),  Integer.parseInt(t7.getText()),  Integer.parseInt(t8.getText()),  Integer.parseInt(t9.getText())));
					
					
                    //库存信息表的添加！！！！
					DepotPO po = new DepotPO(Integer.parseInt(t6.getText()),  Integer.parseInt(t7.getText()),  Integer.parseInt(t8.getText()),  Integer.parseInt(t9.getText()));
					String[] temp = state.split("-");
					inDepot.inDepotExcel(t1.getText(), t4.getText(), po, temp[1]);
					//库存信息表的添加！！！！
					
					//库存报警功能的添加！！！！
					int[] used = depot110.usedSpaceInf(temp[1]);
					int[] all = depot110.allSpaceInf(temp[1]);
					if(((double)used[0]/(double)all[0])>=0){
						System.out.println("航运区库存快满了");
						//这里要改变库存报警的图片
					}
					if(((double)used[1]/(double)all[1])>=0){
						System.out.println("铁运区库存快满了");
						//这里要改变库存报警的图片
					}
					if(((double)used[2]/(double)all[2])>=0){
						System.out.println("汽运区库存快满了");
						//这里要改变库存报警的图片
					}
					//库存报警功能的添加！！！！
					
					icwarehousemanJpanel.remove(b2jpanel);
					icwarehousemanJpanel.add(ui.getOperationJpanel());
					ui.getB1().setEnabled(true);
					icwarehousemanJpanel.repaint();
				}else {
					new failDialog(ui, "失败", true);
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
class failDialog extends JDialog{
	private dialogJpanel jPanel;
	private JLabel jLabel;
	private JButton jButton;
	public failDialog(JFrame frame,String title,boolean modal) {
		super(frame,title,modal);
		init();
		registerListener();
		this.setVisible(true);
	}
	private void init(){
		ImageIcon yesIcon=new ImageIcon("picture/登录.png");
		jLabel=new JLabel("填写不完整，请继续填写",jLabel.CENTER);
		jLabel.setForeground(Color.white);
		jLabel.setFont(new Font("幼圆",Font.BOLD,27));
		jPanel=new dialogJpanel();
		jButton=new JButton(yesIcon);
		jButton.setContentAreaFilled(false);
		jPanel.setLayout(null);
		jButton.setBounds(218,190, 64, 64);
		jLabel.setBounds(0, 0, 500, 200);
		jPanel.add(jLabel);
		jPanel.add(jButton);
		this.add(jPanel);
		this.setSize(500, 300);
		Toolkit kitToolkit =Toolkit.getDefaultToolkit();
		Dimension screenSize=kitToolkit.getScreenSize();
		int screenWidth=screenSize.width;
		int screenHeight=screenSize.height;
		int dialogWidth=this.getWidth();
		int dialogHeight=this.getHeight();
		this.setLocation((screenWidth-dialogWidth)/2, (screenHeight-dialogHeight)/2);
		this.setResizable(false);
	}
	private void registerListener(){
		jButton.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				failDialog.this.dispose();
			}
		});
	}
	class dialogJpanel extends JPanel{
		private ImageIcon dialogIcon=new ImageIcon("picture/背景.png");
		public void paintComponent(Graphics g)  
		{  
		    super.paintComponent(g);    
		    g.drawImage(dialogIcon.getImage(),0,0,null);
	      
	     }
	   }
}
