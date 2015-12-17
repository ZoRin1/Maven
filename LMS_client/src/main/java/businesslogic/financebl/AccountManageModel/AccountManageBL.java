package businesslogic.financebl.AccountManageModel;

import java.util.ArrayList;

import dataservice.financedataservice.CostException;
import dataservice.financedataservice.CustomException;
import po.financePO.AccountPO;
import businesslogic.state.ResultMessage;
import vo.financeVO.AccountVO;

public class AccountManageBL {
	
	private ArrayList<AccountVO> accountInf;
	private CheckAccountBL checkAccount;
	private addAccountBL addAccount;
	private CoverAccountBL coverAccount;
	private changeTheAccount changeAccount;
	
	
	public ArrayList<AccountVO> getAccountInf() {
		CheckManage();
		return accountInf;
	}

	public AccountManageBL(){
		super();
		checkAccount = new CheckAccountBL();
		addAccount = new addAccountBL();
		changeAccount = new changeTheAccount();
	}
	
    //账户信息
	public void CheckManage(){
		accountInf = checkAccount.getAccount();
	}
	
	//需增加账户
	public void AddManage(String name,double money){
		AccountVO vo = addAccount.addAccount(name, money);
		accountInf.add(vo);
	}
	//需删除用户
	public void DeleteManage(int index){
		accountInf.remove(index);
	}
	//需初始化账户
	public void IntalizaManage(String name,double money,int index){
		accountInf.remove(index);
		AccountVO vo = addAccount.addAccount(name, money);
		accountInf.set(index, vo);
	}
	
	//更新账户信息
	public boolean UpdateAccount(ArrayList<AccountVO> vo){
		ArrayList<AccountPO> po = new ArrayList<AccountPO>();
		AccountPO p1;
		AccountVO v1;
		for(int i = 0 ; i <vo.size();i++){
			v1 = vo.get(i);
			p1 = new AccountPO(v1.getName(),v1.getSums());
			po.add(p1);
		}
		coverAccount = new CoverAccountBL(po);
		return coverAccount.CoverAccount();
	}
	
	//增加账户余额
	public int ChangeEarn(String accountName,double earn){
		return changeAccount.addEarn(accountName, earn);
	}
	//减少账户余额
	public int  ChangePay(String accountName,double pay){
		return changeAccount.subPay(accountName, pay);
	}
	
}
