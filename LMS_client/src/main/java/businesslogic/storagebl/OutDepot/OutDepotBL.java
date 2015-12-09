package businesslogic.storagebl.OutDepot;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.storagedataservice.OutDepotDataSer;
import dataservice.storagedataservice.storageFactory;
import po.storagePO.DepotPO;
import presentation.mainui.ipConfig;
import vo.storageVO.DepotVO;

public class OutDepotBL {
	
	private DepotPO po;
	private ipConfig ip;
	
	public OutDepotBL(){
		ip = new ipConfig();
	}
	public void outDepot(DepotVO depo,String city){
		try {
			String ipp = ip.getIP();
			storageFactory stoFactory = (storageFactory)Naming.lookup("rmi://"+ipp+"/stoFactory");
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