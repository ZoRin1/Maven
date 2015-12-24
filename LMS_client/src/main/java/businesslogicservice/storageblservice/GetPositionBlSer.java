package businesslogicservice.storageblservice;

import java.rmi.RemoteException;

import vo.storageVO.DepotVO;

public interface GetPositionBlSer {
	
	public DepotVO getPOsition(String city, int qu) throws RemoteException;
	
}
