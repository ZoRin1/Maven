package businesslogic.financebl.ProfitModel;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.financedataservice.StorageProDataSer;
import dataservice.financedataservice.financeFactory;
import po.financePO.ProfitPO;
import presentation.mainui.ipConfig;

public class addProfit {
	
	private ipConfig ip;
	private financeFactory finFactory;
	
	public addProfit()throws RemoteException{
		ip = new ipConfig();
		String ipp = ip.getIP();
		try {
			finFactory = (financeFactory)Naming.lookup("rmi://"+ipp+"/finFactory");
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}  catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public void addPro(ProfitPO po) throws RemoteException{

			StorageProDataSer stoPro = finFactory.createStorageProDataSer();
			stoPro.setCostRecords(po);
		
		
	}
}
