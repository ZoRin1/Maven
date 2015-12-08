package businesslogic.financebl.AccountManageModel;

import vo.financeVO.AccountVO;
import businesslogicservice.financeblservice.AddAccountBlSer;

public class addAccountBL implements AddAccountBlSer{

	AccountVO vo;

	@Override
	public AccountVO addAccount(String name, double money) {
		// TODO 自动生成的方法存根
		vo = new AccountVO(name,money);
		return vo;
	}

}
