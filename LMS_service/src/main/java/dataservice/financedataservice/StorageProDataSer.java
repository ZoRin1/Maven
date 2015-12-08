package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.financePO.*;

public interface StorageProDataSer extends Remote{
	
	/**
	 * 系统持久化存入成本收益记录
	 * @author YangGuan
	 *
	 */
	public void setCostRecords(ProfitPO po) throws RemoteException;
}
