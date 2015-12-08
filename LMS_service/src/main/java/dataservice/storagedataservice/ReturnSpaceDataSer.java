package dataservice.storagedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ReturnSpaceDataSer extends Remote{
	
	/**
	 * 系统根据输入将机动区空间还原
	 * 初始化请求成功
	 * @author YangGuan
	 *
	 */
	public void reSpace(String city) throws RemoteException;
}
