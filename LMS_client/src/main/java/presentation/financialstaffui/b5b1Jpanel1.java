package presentation.financialstaffui;

import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JTextField;

import businesslogic.financebl.BooksModel.BooksController;

public class b5b1Jpanel1 extends JPanel{
	private JLabel newBooksNameJLabel;
	private JTextField newBooksNameField;
	private JButton yesButton;
	private ImageIcon yesIcon=new ImageIcon("picture/确定.png");
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JButton returnButton;
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	private BooksController booksController;
	public b5b1Jpanel1(b5financialstaffui b5financialstaffui,financialstaffJpanel financialstaffJpanel) {
		// TODO Auto-generated constructor stub
		init();
		financialstaffJpanel.add(this);
		registListener(b5financialstaffui,financialstaffJpanel,this);
	}
	private void init(){
		Font font=new Font("幼圆",Font.BOLD,30);
		newBooksNameJLabel=new JLabel("新账本名称");
		newBooksNameJLabel.setForeground(Color.white);
		newBooksNameJLabel.setFont(font);
		newBooksNameJLabel.setBounds(100, 250, 200, 30);
		newBooksNameField=new JTextField();
		newBooksNameField.setFont(font);
		newBooksNameField.setBounds(320,250,250,30);
		returnButton=new JButton(returnIcon);
		returnButton.setBounds(662, 575,48,48);
		returnButton.setContentAreaFilled(false);
		yesButton=new JButton(yesIcon);
		yesButton.setBounds(602, 575,48,48);
		yesButton.setContentAreaFilled(false);
	 	this.setBounds(260, 60, 730,650);
	 	this.add(newBooksNameField);
	 	this.add(newBooksNameJLabel);
	 	this.add(yesButton);
	 	this.add(returnButton);
	 	this.setLayout(null);
	 	this.setOpaque(false);
	}
	private void registListener(final b5financialstaffui b5financialstaffui,final  financialstaffJpanel financialstaffJpanel,final b5b1Jpanel1 b5b1Jpanel1){
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				financialstaffJpanel.remove(b5b1Jpanel1);
				financialstaffJpanel.add(b5financialstaffui.operationJpanel);
				b5financialstaffui.b1.setEnabled(true);
				b5financialstaffui.b2.setEnabled(true);
				financialstaffJpanel.repaint();
			}
		});
		yesButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (newBooksNameField.getText().equals("")) {
					new failBooksDialog(b5financialstaffui, "失败", true);
				}
				else {
					booksController=new BooksController();
					booksController.newBook(newBooksNameField.getText());
					new finishzhangbenDialog(b5financialstaffui, "新建账本完成", true);
					financialstaffJpanel.remove(b5b1Jpanel1);
					financialstaffJpanel.add(b5financialstaffui.operationJpanel);
					b5financialstaffui.b1.setEnabled(true);
					b5financialstaffui.b2.setEnabled(true);
					financialstaffJpanel.repaint();
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
class failBooksDialog extends JDialog{
	private dialogJpanel jPanel;
	private JLabel jLabel;
	private JButton jButton;
	public failBooksDialog(JFrame frame,String title,boolean modal) {
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
				failBooksDialog.this.dispose();
			}
		});
	}
}
class finishzhangbenDialog extends JDialog{
	private dialogJpanel jPanel;
	private JLabel jLabel;
	private JButton jButton;
	public finishzhangbenDialog(JFrame frame,String title,boolean modal) {
		super(frame,title,modal);
		init();
		registerListener();
		this.setVisible(true);
	}
	private void init(){
		ImageIcon yesIcon=new ImageIcon("picture/登录.png");
		jLabel=new JLabel("新建账本完成",jLabel.CENTER);
		jLabel.setForeground(Color.white);
		jLabel.setFont(new Font("幼圆",Font.BOLD,27));
		jPanel=new dialogJpanel();
		jButton=new JButton(yesIcon);
		jButton.setContentAreaFilled(false);
		jPanel.setLayout(null);
		jButton.setBounds(218,160, 64, 64);
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
				finishzhangbenDialog.this.dispose();
			}
		});
	}

}
class dialogJpanel extends JPanel{
	private ImageIcon dialogIcon=new ImageIcon("picture/背景.png");
	public void paintComponent(Graphics g)  
	{  
	    super.paintComponent(g);    
	    g.drawImage(dialogIcon.getImage(),0,0,null);
      
     }
   }