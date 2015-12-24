package presentation.topmanagerui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MyDialog extends JPanel {
	private ImageIcon dialogIcon=new ImageIcon("picture/对话框背景.png");
	public void paintComponent(Graphics g)  
	{  
	    super.paintComponent(g);    
	    g.drawImage(dialogIcon.getImage(),0,0,null);
      
     }
	
}
class DisplayDialog extends JDialog{
	private MyDialog jPanel;
	private JLabel jLabel;
	private JButton jButton;
	private String words;
	public DisplayDialog(JFrame frame,String words) {
		super(frame,"提示信息",true);
		this.words=words;
		init();
		registerListener();
		this.setVisible(true);
	}
	private void init(){
		ImageIcon yesIcon=new ImageIcon("picture/登录.png");
		jLabel=new JLabel(words,jLabel.CENTER);
		jLabel.setForeground(Color.white);
		jLabel.setFont(new Font("幼圆",Font.BOLD,27));
		jPanel=new MyDialog();
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
				DisplayDialog.this.dispose();
			}
		});
	}
}

class DocumentsDialog extends JDialog{
	private MyDialog jPanel;
	private JLabel jLabel;
	private JButton jButton;
	private String words;
	public DocumentsDialog(JFrame frame,String title,String words) {
		super(frame,title,true);
		this.words=words;
		init();
		registerListener();
		this.setVisible(true);
	}
	private void init(){
		ImageIcon yesIcon=new ImageIcon("picture/登录.png");
		jLabel=new JLabel(words,jLabel.CENTER);
		jLabel.setForeground(Color.white);
		jLabel.setFont(new Font("幼圆",Font.BOLD,18));
		jPanel=new MyDialog();
		jButton=new JButton(yesIcon);
		jButton.setContentAreaFilled(false);
		jPanel.setLayout(null);
		jButton.setBounds(218,230, 64, 64);
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
				DocumentsDialog.this.dispose();
			}
		});
	}
}
class AskDialog extends JDialog{
	private MyDialog jPanel;
	private JLabel jLabel;
	private JButton confirm;
	private JButton cancel;
    boolean state;
	private String words;
	public AskDialog(JFrame frame,String title,boolean modal,String words) {
		super(frame,title,modal);
		this.words=words;
		init();
		registerListener();
		this.setVisible(true);
	}
	private void init(){
		state = false;
		ImageIcon confirmIcon = new ImageIcon("picture/对话框确定.png");
		ImageIcon cancelIcon=new ImageIcon("picture/取消.png");
		
		jLabel=new JLabel(words,jLabel.CENTER);
		jLabel.setForeground(Color.white);
		jLabel.setFont(new Font("幼圆",Font.BOLD,27));
		jPanel=new MyDialog();
		
		jPanel.setLayout(null);
		jLabel.setBounds(0, 0, 500, 200);
		
		confirm = new JButton(confirmIcon);
		confirm.setContentAreaFilled(false);
		confirm.setBounds(180, 210, 72, 24);
		
		cancel=new JButton(cancelIcon);
		cancel.setContentAreaFilled(false);
		cancel.setBounds(268,210, 72, 24);
		
		jPanel.add(jLabel);
		jPanel.add(cancel);
		jPanel.add(confirm);
		
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
		cancel.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				AskDialog.this.dispose();
			}
		});
		
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				state = true;
				AskDialog.this.dispose();
			}
		});
	}
}
