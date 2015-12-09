package businesslogic.storagebl.ExcelModel;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.storagedataservice.GetDepotExcelDataSer;
import dataservice.storagedataservice.storageFactory;
import po.excelPO.DepotExcelPO;
import presentation.mainui.ipConfig;

public class GetExcelInf {
	
	private ArrayList<DepotExcelPO> excelPOList;
	private ipConfig ip;
	
	public GetExcelInf(){
		super();
		excelPOList = new ArrayList<DepotExcelPO>();
		ip = new ipConfig();
	}
	
	public ArrayList<DepotExcelPO> getExcel(String city){
		try {
			String ipp = ip.getIP();
			storageFactory stoFactory = (storageFactory)Naming.lookup("rmi://"+ipp+"/stoFactory");
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
