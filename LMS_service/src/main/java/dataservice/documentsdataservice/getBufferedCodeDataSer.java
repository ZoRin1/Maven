package dataservice.documentsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface getBufferedCodeDataSer extends Remote{
	/**
	 * 
	 * 系统自缓冲区返回所有单据的编码及单据名(编号，单据)
	 * @author XiongKaiQi
	 *
	 */
	public ArrayList<String> getCode()throws RemoteException;//xiugai
}
