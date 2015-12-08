package businesslogicservice.organizationblservice;

/**
 * @author YangHua'an
 *
 */

public interface FinanceOrgBLSer {
	
	/**
	 * 返回财务人员列表
	 * @return 财务人员ID+name列表
	 */
	public String[] getFinancersList();
	
	/**
	 * 增加一个财务人员
	 * @param ID 增加的财务人员的编号
	 * @return 操作是否成功的信息
	 */
	public boolean addFinancer(long ID);
	
	/**
	 * 删除一个财务人员
	 * @param ID 要删除的财务人员的账号
	 * @return 操作是否成功的信息
	 */
	public boolean removeFinancer(long ID);

}
