package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.financePO.*;

public interface GetAccountDataSer extends Remote{
	
	
	/**
	 * 系统返回一个持久化对象集合（账户）
	 * 用于账户查询
	 * @author YangGuan
	 *
	 */
	public ArrayList<AccountPO> getAccount() throws RemoteException;
}
