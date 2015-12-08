package dataservice.documentsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface NotApproved extends Remote{
	/**
	 *单据已审批未通过时修改缓冲区单据审批状态为true
	 * @author XiongKaiQi
	 *
	 */
	public boolean NotApproved(String code,String doName)throws RemoteException;
}

