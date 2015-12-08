package businesslogic.storagebl.ExcelModel;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.storagedataservice.GetDepotExcelDataSer;
import dataservice.storagedataservice.storageFactory;
import po.storagePO.DepotExcelPO;

public class GetExcelInf {
	
	private ArrayList<DepotExcelPO> excelPOList;
	
	public GetExcelInf(){
		super();
		excelPOList = new ArrayList<DepotExcelPO>();
	}
	
	public ArrayList<DepotExcelPO> getExcel(String city){
		try {
			storageFactory stoFactory = (storageFactory)Naming.lookup("rmi://127.0.0.1:6600/stoFactory");
			GetDepotExcelDataSer getExcel = stoFactory.createGetDepotExcelDataSer();
			excelPOList = getExcel.getDepotExcel(city);
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return excelPOList;
	}
}
