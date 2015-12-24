package businesslogicservice.storageblservice;

import java.rmi.RemoteException;

import businesslogic.state.ResultMessage;

public interface RetuenSpaceBlSer {
	
	/**
	 * 将空间返还给机动区
	 * @author YangGuan
	 * @param city TODO
	 * @throws RemoteException 
	 *
	 */
	public void  returnSpace(String city) throws RemoteException;
}
