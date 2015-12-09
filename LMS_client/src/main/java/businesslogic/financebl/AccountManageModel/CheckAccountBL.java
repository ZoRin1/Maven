package businesslogic.financebl.AccountManageModel;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.financePO.AccountPO;
import presentation.mainui.ipConfig;
import dataservice.financedataservice.GetAccountDataSer;
import dataservice.financedataservice.financeFactory;
import vo.financeVO.AccountVO;
import businesslogicservice.financeblservice.GetAccountBlSer;

public class CheckAccountBL implements GetAccountBlSer{

	private ipConfig ip;
	
	public CheckAccountBL(){
		ip = new ipConfig();
	}
	
	@Override
	public ArrayList<AccountVO> getAccount() {
		// TODO 自动生成的方法存根
		ArrayList<AccountVO> vo = new ArrayList<AccountVO>();
		ArrayList<AccountPO> po;
		AccountVO v1;
		AccountPO p1;
		try {
			String ipp = ip.getIP();
			financeFactory finFactory = (financeFactory)Naming.lookup("rmi://"+ipp+"/finFactory");
			GetAccountDataSer getAccount = finFactory.createGetAccountDataSer();
			po = getAccount.getAccount();
			for(int i = 0 ; i <po.size();i++){
				p1 = po.get(i);
				v1 = new AccountVO(p1.getName(),p1.getSums());
				vo.add(v1);
			}
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
		return vo;
	}

}
