package dataservice.storagedataservice;

import java.util.ArrayList;

import po.storagePO.DepotExcelPO;

public interface GetDepotExcelDataSer {
	
	public ArrayList<DepotExcelPO> getDepotExcel(String city);
}
