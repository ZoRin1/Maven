package dataservice.financedataservice;

public interface ChangeAccountDataSer {
	
	/**
	 * 通过银行账户和收益 增加指定账户的金额
	 */
	
	public void changeEarn(String accountName,double earn);
	
	
	/**
	 * 通过银行账户和收益 减去指定账户的金额
	 */
	
	public void changePay(String accountName,double earn);
}
