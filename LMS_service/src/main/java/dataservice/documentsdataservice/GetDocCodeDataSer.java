package dataservice.documentsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GetDocCodeDataSer extends Remote{
	//新建单据时生成新的单据编号

	public String getDocCode(String doName)throws RemoteException;
}