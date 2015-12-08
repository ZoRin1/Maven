package dataservice.storagedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UsedSpaceDataSer extends Remote{
	/**
	 * 得到库存各分区已用空间大小
	 * 进入分区调整界面后
	 * @author YangGuan
	 *
	 */
	public int[] getUsedSpace(String city) throws RemoteException;
	
	/**
	 * 得到库存各分区总空间大小
	 * 进入分区调整界面后
	 * @author YangGuan
	 *
	 */
	public int[] getAllSpace(String city) throws RemoteException;
	
	
	/**
	 * 得到库存机动分区空间大小
	 * 进入分区调整界面后
	 * @author YangGuan
	 *
	 */
	public int getJiDongSpace(String city)throws RemoteException;
}
