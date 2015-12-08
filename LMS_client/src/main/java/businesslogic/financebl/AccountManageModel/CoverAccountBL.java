package businesslogic.financebl.AccountManageModel;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.financedataservice.CoverDataSer;
import dataservice.financedataservice.financeFactory;
import po.financePO.AccountPO;

public class CoverAccountBL {
	
	ArrayList<AccountPO> PO;

	public CoverAccountBL(ArrayList<AccountPO> pO) {
		super();
		PO = pO;
	}
	
	public boolean CoverAccount(){
		try {
			financeFactory finFactory = (financeFactory)Naming.lookup("rmi://127.0.0.1:6600/finFactory");
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
