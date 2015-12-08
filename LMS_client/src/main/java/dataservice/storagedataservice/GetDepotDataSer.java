package dataservice.storagedataservice;

import po.storagePO.DepotPO;

public interface GetDepotDataSer {
	
	public DepotPO getDepot(String city,int AreaNum);
	
}
