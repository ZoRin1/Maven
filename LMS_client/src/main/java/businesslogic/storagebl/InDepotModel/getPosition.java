package businesslogic.storagebl.InDepotModel;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import po.storagePO.DepotPO;
import presentation.mainui.ipConfig;
import dataservice.storagedataservice.GetDepotDataSer;
import dataservice.storagedataservice.storageFactory;
import businesslogicservice.storageblservice.GetPositionBlSer;
import vo.storageVO.DepotVO;

public class getPosition implements GetPositionBlSer{
	private DepotVO vo;
	private ipConfig ip;
	
	public getPosition(){
		super();
		ip = new ipConfig();
	}
	@Override
	public DepotVO getPOsition(String city, int qu) throws RemoteException{
		// TODO Auto-generated method stub
		try {
			String ipp = ip.getIP();
			storageFactory stoFactory = (storageFactory)Naming.lookup("rmi://"+ipp+"/stoFactory");
			GetDepotDataSer getDepot  = stoFactory.createGetDepotDataSer();
			DepotPO po = getDepot.getDepot(city, qu);
	        vo = new DepotVO(po.getQu(),po.getPai(),po.getJia(),po.getWei());
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}  catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return vo;
	}
	
}
