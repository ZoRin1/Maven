package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.financePO.*;

public interface ProfitListDataSer extends Remote{
	
	/**
	 *系统根据输入的时间返回一个持久化对象集合（成本收益记录)
	 *用于成本收益表
	 * @author YangGuan
	 *
	 */
	public ArrayList<ProfitPO> ProList(String date) throws RemoteException;
}
