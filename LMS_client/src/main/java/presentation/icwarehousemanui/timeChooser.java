package presentation.icwarehousemanui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class timeChooser extends JPanel{
	private JLabel j1,j2,j3,j4;
	
	private JComponent showDate;
	
	private Font font = new Font("宋体", Font.PLAIN, 12);
	
	public  timeChooser(checkDepotDialog checkDepotDialog){
		init();
		checkDepotDialog.checkDepot.add(this);
		
	}
	
	public void init(){
		j1 = new JLabel("时间：");
		j2 = new JLabel("时");
		j3 = new JLabel("分：");
		j4 = new JLabel("秒：");
		j1.setFont(font);
		j2.setFont(font);
		j3.setFont(font);
		j4.setFont(font);
		
		j1.setBounds(0, 10, 30, 30);
		j2.setBounds(50, 10, 30, 30);
		j3.setBounds(100, 10, 30, 30);
		j4.setBounds(150, 10, 30, 30);
		
		this.setBounds(151, 88, 200, 300);
		this.add(j1);
		this.add(j2);
		this.add(j3);
		this.add(j4);
		
	 	this.setLayout(null);
	 	this.setOpaque(false);
	}
	
	public void register(final JComponent showDate) {
		this.showDate = showDate;
		
		showDate.setRequestFocusEnabled(true);
		showDate.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				showDate.requestFocusInWindow();
				System.out.println("aaa");
			}
		});
		
		this.setBackground(Color.WHITE);
		this.add(showDate, BorderLayout.CENTER);
		
	}
}
