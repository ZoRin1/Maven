package businesslogic.accountbl;

public class AccountLoginController {
	AccountBL aBL=new AccountBL();
	public String login(long ID, String password) {
		// TODO 自动生成的方法存根
		return aBL.login(ID, password);
	}
	public String[] getAccount(long ID) {
		// TODO 自动生成的方法存根
		return aBL.getAccount(ID);
	}

}
