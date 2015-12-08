package businesslogic.storagebl.OutDepot;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.storagedataservice.OutDepotDataSer;
import dataservice.storagedataservice.storageFactory;
import po.storagePO.DepotPO;
import vo.storageVO.DepotVO;

public class OutDepotBL {
	
	private DepotPO po;
	public void outDepot(DepotVO depo,String city){
		try {
			storageFactory stoFactory = (storageFactory)Naming.lookup("rmi://114.212.42.143:6600/stoFactory");
			OutDepotDataSer outDepot = stoFactory.createOutDepotDataSer();
			po = new DepotPO(depo.getQu(),depo.getPai(),depo.getJia(),depo.getWei());
			outDepot.outDepot(po, city);
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