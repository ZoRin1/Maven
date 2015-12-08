package businesslogicservice.storageblservice;

import vo.storageVO.DepotVO;

public interface GetPositionBlSer {
	
	public DepotVO getPOsition(String city, int qu);
	
}
