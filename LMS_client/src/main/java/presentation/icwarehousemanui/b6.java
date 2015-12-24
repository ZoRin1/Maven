package presentation.icwarehousemanui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import businesslogic.storagebl.DriveModel.returnSpace;
import businesslogic.storagebl.DriveModel.spaceBL;

public class b6 {
	
	private String account;
	private String state;
	private spaceBL space;
	private returnSpace reSpace;
	
	public b6(icwarehousemanui icwarehousemanui,String account,String state) {
		// TODO Auto-generated constructor stub
		this.account = account;
		this.state = state;
		int check =init(icwarehousemanui);
		if(check>0){
			//失败DiaLog
			new failDialog(icwarehousemanui, "库存初始化失败", true,"机动区仍存货物！初始化失败！");
		}else{
			String[] temp = state.split("-");
			try {
				reSpace.returnSpace(temp[1]);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				new InternetDialog(icwarehousemanui);
			}
			new finishDialog(icwarehousemanui, "库存初始化完成", true,"库存初始化完成");
		}
	}
	//实现库存初始化
	private int init(icwarehousemanui icwarehousemanui){
		try {
			space =new spaceBL();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			new InternetDialog(icwarehousemanui);
		}
		reSpace = new returnSpace();
		String[] temp = state.split("-");
		return space.getJiDongSpace(temp[1]);
	}

}
   
