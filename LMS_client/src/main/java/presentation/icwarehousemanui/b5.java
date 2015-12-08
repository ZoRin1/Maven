package presentation.icwarehousemanui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import businesslogic.storagebl.DriveModel.DriverBL;
import businesslogic.storagebl.DriveModel.spaceBL;

public class b5{
	public b5(icwarehousemanui icwarehousemanui,String account,String state) {
		// TODO Auto-generated constructor stub
		init();
		new finishb5Dialog(icwarehousemanui, "库存分区调整完成", true,account,state);
	}
	//实现库存分区调整
	private void init(){
		

	}

}
class finishb5Dialog extends JDialog{
	private dialogJpanel jPanel;
	private JButton jButton;
	private JLabel j1,j2,j3,j4,j5,j6;
	private JLabel j11,j12,j13,j21,j22,j23;
	private JTextField t1,t2,t3;
	private spaceBL space;
	private DriverBL drive;
	private int[] used;
	private int[] all;
	
	private String account;
	private String state;
	public finishb5Dialog(JFrame frame,String title,boolean modal,String account,String state) {
		super(frame,title,modal);
		this.account = account;
		this.state = state;
		space = new spaceBL();
		usedSpace();
		allSpace();
		init();
		registerListener();
		this.setVisible(true);
	}
	private void init(){
		ImageIcon yesIcon=new ImageIcon("picture/登录.png");
		
		j1 = new JLabel("总空间:");
		j1.setForeground(Color.white);
		j1.setFont(new Font("幼圆",Font.BOLD,20));
		j1.setBounds(20, 60, 80, 24);//132 32
		
		j2 = new JLabel("航运区");
		j2.setForeground(Color.white);
		j2.setFont(new Font("幼圆",Font.BOLD,20));
		j2.setBounds(150, 28, 80, 24);
		
		j3 = new JLabel("铁运区");
		j3.setForeground(Color.white);
		j3.setFont(new Font("幼圆",Font.BOLD,20));
		j3.setBounds(250, 28, 80, 24);
		
		j4 = new JLabel("汽运区");
		j4.setForeground(Color.white);
		j4.setFont(new Font("幼圆",Font.BOLD,20));
		j4.setBounds(350, 28, 80, 24);
		
		j5 = new JLabel("已用空间：");
		j5.setForeground(Color.white);
		j5.setFont(new Font("幼圆",Font.BOLD,20));
		j5.setBounds(20, 100, 120, 24);
		
		j6 = new JLabel("分配空间：");
		j6.setForeground(Color.white);
		j6.setFont(new Font("幼圆",Font.BOLD,20));
		j6.setBounds(20, 140, 120, 24);
		
		j11 = new JLabel(String.valueOf(all[0]));
		j11.setForeground(Color.white);
		j11.setFont(new Font("幼圆",Font.BOLD,20));
		j11.setBounds(160, 60, 40, 24);
		
		j12 = new JLabel(String.valueOf(all[1]));
		j12.setForeground(Color.white);
		j12.setFont(new Font("幼圆",Font.BOLD,20));
		j12.setBounds(260, 60, 40, 24);
		
		j13 = new JLabel(String.valueOf(all[2]));
		j13.setForeground(Color.white);
		j13.setFont(new Font("幼圆",Font.BOLD,20));
		j13.setBounds(360, 60, 40, 24);
		
		j21 = new JLabel(String.valueOf(used[0]));
		j21.setForeground(Color.white);
		j21.setFont(new Font("幼圆",Font.BOLD,20));
		j21.setBounds(160, 100, 40, 24);
		
		j22 = new JLabel(String.valueOf(used[1]));
		j22.setForeground(Color.white);
		j22.setFont(new Font("幼圆",Font.BOLD,20));
		j22.setBounds(260, 100, 40, 24);
		
		j23 = new JLabel(String.valueOf(used[2]));
		j23.setForeground(Color.white);
		j23.setFont(new Font("幼圆",Font.BOLD,20));
		j23.setBounds(360, 100, 40, 24);
		
		MyDocument document1 = new MyDocument(3);
		MyDocument document2 = new MyDocument(3);
		MyDocument document3 = new MyDocument(3);
		
		t1 = new JTextField();
		t1.setForeground(Color.white);
		t1.setFont(new Font("幼圆",Font.BOLD,20));
		t1.setBounds(150, 140, 60, 24);
		t1.setOpaque(false);
		t1.setDocument(document1);
		t1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int keyChar = e.getKeyChar();
				if(keyChar>=KeyEvent.VK_0&&keyChar<=KeyEvent.VK_9){
				}else{
					e.consume();
				}
			}
		});
		
		t2 = new JTextField();
		t2.setForeground(Color.white);
		t2.setFont(new Font("幼圆",Font.BOLD,20));
		t2.setBounds(250, 140, 60, 24);
		t2.setOpaque(false);
		t2.setDocument(document2);
		t2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int keyChar = e.getKeyChar();
				if(keyChar>=KeyEvent.VK_0&&keyChar<=KeyEvent.VK_9){
				}else{
					e.consume();
				}
			}
		});
		
		t3 = new JTextField();
		t3.setForeground(Color.white);
		t3.setFont(new Font("幼圆",Font.BOLD,20));
		t3.setBounds(350, 140, 60, 24);
		t3.setOpaque(false);
		t3.setDocument(document3);
		t3.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int keyChar = e.getKeyChar();
				if(keyChar>=KeyEvent.VK_0&&keyChar<=KeyEvent.VK_9){
				}else{
					e.consume();
				}
			}
		});
		
		jPanel=new dialogJpanel();
		jButton=new JButton(yesIcon);
		jButton.setContentAreaFilled(false);
		jPanel.setLayout(null);
		jButton.setBounds(218,190, 64, 64);
		jPanel.add(j1);
		jPanel.add(j2);
		jPanel.add(j3);
		jPanel.add(j4);
		jPanel.add(j5);
		jPanel.add(j6);
		jPanel.add(t1);
		jPanel.add(t2);
		jPanel.add(t3);
		jPanel.add(j11);
		jPanel.add(j12);
		jPanel.add(j13);
		jPanel.add(j21);
		jPanel.add(j22);
		jPanel.add(j23);
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
				
				//这个下面还要添加  库存输入是否超出机动区大小！！！！
				
				//这个上面还要添加  库存输入是否超出机动区大小！！！！
				String[] temp = state.split("-");
				drive = new DriverBL();
				drive.drive(Integer.parseInt(t1.getText()), Integer.parseInt(t2.getText()), Integer.parseInt(t3.getText()), temp[1]);
				
				//这里要添加库存报警的功能！！！！
				used = space.usedSpaceInf(temp[1]);
				all = space.allSpaceInf(temp[1]);
				if(((double)used[0]/(double)all[0])<0.8){
					System.out.println("航运区库存空余");
					//这里要改变库存报警的图片
				}
				if(((double)used[1]/(double)all[1])<0.8){
					System.out.println("铁运区库存空余");
					//这里要改变库存报警的图片
				}
				if(((double)used[2]/(double)all[2])<0.8){
					System.out.println("汽运区库存空余");
					//这里要改变库存报警的图片
				}
				//这里要添加库存报警的功能！！！！
				
				finishb5Dialog.this.dispose();
			}
		});
	}
	private void usedSpace(){
		String[] temp = state.split("-");
		used = space.usedSpaceInf(temp[1]);
	}
	private void allSpace(){
		String[] temp = state.split("-");
		all = space.allSpaceInf(temp[1]);
	}
	
	private class MyDocument extends PlainDocument{
		   int maxLength =10; 
		   public MyDocument(int newMaxLength){ 
			      super(); 
			      maxLength = newMaxLength; 
			   }
		   public MyDocument(){ 
			      this(10); 
			   }
		    public void insertString(int offset,String str,AttributeSet a)throws BadLocationException{ 
		        if(getLength()+str.length()>maxLength){//这里假定你的限制长度为10 
		             return; 
		        } 
		        else{  
		            super.insertString(offset,str,a); 

		        }     
		      }
	}
}


