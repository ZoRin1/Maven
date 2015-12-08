package dataservice.storagedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UpdateSpaceDataSer extends Remote{
	
	
	
	/**
	 * 根据输入更新库存信息
	 * 已完成分区调整
	 * @author YangGuan
	 *
	 */
	public void updateDrive(int shipping,int trains,int motor,String city) throws RemoteException;
}
