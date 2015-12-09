package dataservice.storagedataservice;

import java.util.ArrayList;

import po.excelPO.DepotExcelPO;

public interface GetDepotExcelDataSer {
	
	public ArrayList<DepotExcelPO> getDepotExcel(String city);
}
