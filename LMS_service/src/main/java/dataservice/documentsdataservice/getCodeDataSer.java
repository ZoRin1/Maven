package dataservice.documentsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface getCodeDataSer extends Remote{
	/**
	 * 
	 * 系统返回一段时间内所有响应类型的单据的编码和单据名
	 * starttime可以为空，此时返回endtime之前所有单据
	 * @author XiongKaiQi
	 *
	 */
	public ArrayList<String> getCode(String doName,String startTime,String endTime)throws RemoteException;
	/**
	 * 
	 * 系统返回一段时间内所有账号对应响应类型的单据的编码和单据名
	 * starttime可以为空，此时返回endtime之前所有单据
	 * @author XiongKaiQi
	 *
	 */
	public ArrayList<String> getStoCode(String account,String doName,String startTime,String endTime)throws RemoteException;
	/**
	 * 
	 * 系统返回一段时间内营业厅所有收款单的编码和单据名
	 * startTime和endTime分别为一天内的开始时间和结束时间
	 * selling指的是营业厅的编号 中转中心-营业厅编号
	 * 这个主要是因为营业厅不止一个业务员才添加的
	 * @author XiongKaiQi
	 *
	 */
	public ArrayList<String> getReceiptCode(String selling,String doName,String startTime,String endTime)throws RemoteException;
}
