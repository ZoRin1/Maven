package businesslogic.accountbl;

import java.rmi.RemoteException;

public class AccountLoginController {
	AccountBL aBL;
	public  AccountLoginController() throws RemoteException {
		aBL=new AccountBL();
	}
	
	public String login(long ID, String password) {
		// TODO 自动生成的方法存根
		return aBL.login(ID, password);
	}
	public String[] getAccount(long ID) {
		// TODO 自动生成的方法存根
		return aBL.getAccount(ID);
	}

}
