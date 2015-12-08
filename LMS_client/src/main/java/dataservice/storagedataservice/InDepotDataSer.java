package dataservice.storagedataservice;

import po.storagePO.DepotPO;

public interface InDepotDataSer {
	
	
	public void inDepot(DepotPO depo,String city);
	
	
	public void inDepotExcel(String inDepotCode,String inDepotDate,DepotPO depo,String city);
}
