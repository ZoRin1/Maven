package businesslogic.financebl.AccountManageModel;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.financebl.CostException;
import businesslogic.financebl.CustomException;
import presentation.mainui.ipConfig;
import dataservice.financedataservice.ChangeAccountDataSer;
import dataservice.financedataservice.financeFactory;

public class changeTheAccount {
	
	private ipConfig ip;
	
	public changeTheAccount(){
		ip = new ipConfig();
	}
	
	public void addEarn(String accountName,double earn) throws CustomException{
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
	}
	
	
	public void subPay(String accountName,double pay)throws CustomException,CostException{
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
	}
}
