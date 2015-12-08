package businesslogic.accountbl;

import vo.accountVO.AccountNumberVO;

public class AccountInfoController {
	AccountBL aBL=new AccountBL();

	public boolean addAccount(long ID, AccountNumberVO vo) {
		// TODO 自动生成的方法存根
		return aBL.addAccount(ID, vo);
	}


	public boolean changeInfo(long ID, AccountNumberVO vo) {
		// TODO 自动生成的方法存根
		return aBL.changeInfo(ID, vo);
	}


	public boolean deleteAccount(long ID) {
		// TODO 自动生成的方法存根
		return deleteAccount(ID);
	}


	public String[] getAccount(long ID) {
		// TODO 自动生成的方法存根
		return aBL.getAccount(ID);
	}


	public String[] getAccountList(String name) {
		// TODO 自动生成的方法存根
		return aBL.getAccountList(name);	}


	public AccountNumberVO getInfo(long ID) {
		// TODO 自动生成的方法存根
		return aBL.getInfo(ID);
	}


	public String[] getAccountList() {
		// TODO 自动生成的方法存根
		return aBL.getAccountList();
	}


}
