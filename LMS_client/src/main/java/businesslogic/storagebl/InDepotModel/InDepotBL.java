package businesslogic.storagebl.InDepotModel;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.storagedataservice.InDepotDataSer;
import dataservice.storagedataservice.storageFactory;
import po.storagePO.DepotPO;
import vo.storageVO.DepotVO;

public class InDepotBL {
	
	
	public void inDepotExcel(String inDepotCode,String inDepotDate,DepotPO depo,String city){
		try {
			storageFactory stoFactory = (storageFactory)Naming.lookup("rmi://127.0.0.1:6600/stoFactory");
			InDepotDataSer inDepot = stoFactory.createInDepotDataSer();
			inDepot.inDepotExcel(inDepotCode, inDepotDate, depo, city);
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
		
	}
	
}
