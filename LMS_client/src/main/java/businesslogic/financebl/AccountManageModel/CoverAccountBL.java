package businesslogic.financebl.AccountManageModel;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.financedataservice.CoverDataSer;
import dataservice.financedataservice.financeFactory;
import po.financePO.AccountPO;
import presentation.mainui.ipConfig;

public class CoverAccountBL {
	
	ArrayList<AccountPO> PO;
	
	private ipConfig ip;

	public CoverAccountBL(ArrayList<AccountPO> pO) {
		super();
		PO = pO;
		ip = new ipConfig();
	}
	
	public boolean CoverAccount(){
		try {
			String ipp = ip.getIP();
			financeFactory finFactory = (financeFactory)Naming.lookup("rmi://"+ipp+"/finFactory");
			CoverDataSer cover = finFactory.createCoverDataSer();
			cover.coverAccount(PO);
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
		return true;
	}
}
