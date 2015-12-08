package presentation.financialstaffui;

import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import po.financePO.BooksPO;
import businesslogic.financebl.BooksModel.BooksController;

public class b5b2Jpanel1 extends JPanel{
	
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JButton returnButton;
	private ImageIcon returnIcon=new ImageIcon("picture/返回.png");
	private JLabel j1;
	private b5b2Jpanel1JTable b5b2Jpanel1JTable;
	
	private ArrayList<BooksPO> bookList;
	private b5financialstaffui b5financialstaffui;
	public b5b2Jpanel1(b5financialstaffui b5financialstaffui,financialstaffJpanel financialstaffJpanel,ArrayList<BooksPO> bookList) {
		// TODO Auto-generated constructor stub
		this.b5financialstaffui = b5financialstaffui;
		this.bookList = bookList;
		init();
		financialstaffJpanel.add(this);
		registListener(b5financialstaffui,financialstaffJpanel,this);
	}
	private void init(){
		Font font=new Font("幼圆",Font.BOLD,20);
		ImageIcon i1 = new ImageIcon("picture/财务图片/账本列表.png");
		j1 = new JLabel(i1);
		j1.setBounds(0, 0, 723, 569);

		returnButton=new JButton(returnIcon);
		returnButton.setBounds(662, 575,48,48);
		returnButton.setContentAreaFilled(false);
		
		b5b2Jpanel1JTable = new b5b2Jpanel1JTable(b5financialstaffui,this,bookList);//还要传账本的参数进去！！！！才能自动显示出来

	 	this.setBounds(260, 60, 730,650);

	 	j1.add(b5b2Jpanel1JTable.getScrollPane());
	 	this.add(j1);
	 	this.add(returnButton);
	 	this.setLayout(null);
	 	this.setOpaque(false);
	}
	private void registListener(final b5financialstaffui b5financialstaffui,final financialstaffJpanel financialstaffJpanel,final b5b2Jpanel1 b5b2Jpanel1){
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Component b3b1Jpanel1;
				// TODO Auto-generated method stub
				financialstaffJpanel.remove(b5b2Jpanel1);
				financialstaffJpanel.add(b5financialstaffui.operationJpanel);
				b5financialstaffui.b1.setEnabled(true);
				b5financialstaffui.b2.setEnabled(true);
				financialstaffJpanel.repaint();
			}
		});
	}
	public void paintComponent(Graphics g)  
{  
		super.paintComponent(g);    
		g.drawImage(frameIcon.getImage(),-7,-12,null);
 }
}

