package presentation.financialstaffui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class financialstaffb3OperationJpanel extends JPanel{
	private ImageIcon frameIcon =new ImageIcon("picture/操作面板.png");
	private JButton returnButton;
	public financialstaffb3OperationJpanel(financialstaffJpanel financialstaffJpanel,financialstaffui fsui,b3financialstaffui b3fsui) {
		// TODO Auto-generated constructor stub
		init();
		financialstaffJpanel.add(this);
		registListener(fsui, b3fsui);
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
	private void registListener(final financialstaffui fsui,final b3financialstaffui b3fsui){
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fsui.setVisible(true);
				b3fsui.dispose();
		
			}
		});
	}
	public void paintComponent(Graphics g)  
	{  
	    super.paintComponent(g);    
	    g.drawImage(frameIcon.getImage(),-7,-12,null);
     }
	
}
