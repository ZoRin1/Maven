package dataservice.documentsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.documentsPO.DocumentPO;

public interface getBufferedInfoDataSer extends Remote {
	/**
	 * 系统返回一个完整的PO对象
	 * 用于显示单据的完整信息
	 * @author XiongKaiQi
	 *
	 */
	public DocumentPO getBufferedInfo(String code,String doName)throws RemoteException;//xiugai
}

