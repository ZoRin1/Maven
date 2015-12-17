package businesslogic.financebl.AccountManageModel;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import presentation.mainui.ipConfig;
import dataservice.financedataservice.ChangeAccountDataSer;
import dataservice.financedataservice.CostException;
import dataservice.financedataservice.CustomException;
import dataservice.financedataservice.financeFactory;

public class changeTheAccount {
	
	private ipConfig ip;
	
	public changeTheAccount(){
		ip = new ipConfig();
	}
	
	public int addEarn(String accountName,double earn){
		try {
			String ipp = ip.getIP();
			financeFactory finFactory = (financeFactory)Naming.lookup("rmi://"+ipp+"/finFactory");
			ChangeAccountDataSer change = finFactory.createChangeAccountDateSer();
			change.changeEarn(accountName, earn);
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
		return 0;
	}
	
	
	public int subPay(String accountName,double pay){
		try {
			String ipp = ip.getIP();
			financeFactory finFactory = (financeFactory)Naming.lookup("rmi://"+ipp+"/finFactory");
			ChangeAccountDataSer change = finFactory.createChangeAccountDateSer();
			change.changePay(accountName, pay);
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
		return 0;
	}
}
