package dataservice.documentsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface deleteDataSer extends Remote{
	
	/**
	 * code为单据编号,doName为单据名
	 * 系统删除缓冲区中对应单据
	 * 返回boolean值是否删除成功
	 * @author XiongKaiQi
	 *
	 */
	public boolean delete(String code,String doName)throws RemoteException;//xiugai
}

