package dataservice.storagedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GetCountDataSer extends Remote{
	/**
	 * 系统返回当前仓库当前时间点的库存数量合计
	 * 已请求库存查询
	 * @author YangGuan
	 *
	 */
	public int getCount(String city) throws RemoteException;
}
