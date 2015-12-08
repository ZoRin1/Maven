package businesslogicservice.organizationblservice;

import vo.orgVO.MiddleOrgVO;



public interface MiddleOrgBLSer {
	
	/**
	 * 获得业务员列表
	 * @param ID 中转中心编号
	 * @return 业务员的ID+name列表
	 */
	public String[] getBussinessmanList(String ID);
	
	/**
	 * 增加一个业务员
	 * @param ID 中转中心编号
	 * @param bID 欲增加的业务员账号
	 * @return 操作是否成功的信息
	 */
	public boolean addBussinessman(String ID, long bID);
	
	/**
	 * 删除一个业务员
	 * @param ID 中转中心编号
	 * @param bID 要删除的业务员的账号
	 * @return 操作是否成功的信息
	 */
	public boolean removeBussinessman(String ID, long bID);

	/**
	 * 获得仓库管理员列表
	 * @param ID 中转中心编号
	 * @return 仓库管理员的ID+name列表
	 */
	public String[] getStorgerList(String ID);
	/**
	 * 增加一个仓库管理员
	 * @param ID 中转中心编号
	 * @param bID 欲增加的业务员账号
	 * @return 操作是否成功的信息
	 */
	public boolean addStorger(String ID, long bID);
	
	/**
	 * 删除一个仓库管理员
	 * @param ID 中转中心编号
	 * @param bID 要删除的仓库管理员的账号
	 * @return 操作是否成功的信息
	 */
	public boolean removeStorger(String ID, long bID); 
	
	/**
	 * 获得下辖营业厅列表
	 * 
	 * 注意：中转中心没有增加营业厅功能，这要通过新建营业厅时选择所属中转中心实现，详见BussinessOrgBLSer.addBussinessHall(BussinessOrgVO vo)
	 * 中转中心也没有删除营业厅功能，这要通过删除营业厅时实现，详见BussinessOrgBLSer.removeBussinessHall(String codeNumber)
	 * @param ID 中转中心编号
	 * @return city+codeNumber列表
	 */
	public String[] getBussinessHallList(String ID);
	
	
	/**
	 * 返回机构所在城市
	 * @param ID 中转中心编号
	 * @return city
	 */
	
	public String GetInfo(String ID);
	
	/**
	 * 修改中转中心所在城市    
	 * 修改后要先删除原有城市在添加现在的城市
	 * @param ID 中转中心编号
	 * @param city 欲修改的城市
	 * @return 操作是否成功的信息
	 */
	public boolean changeCity(String ID, String city);
	
	/**
	 * 新增一个中转中心
	 * @param ID 中转中心编号
	 * @param vo 欲创建的中转中心机构信息
	 * @return 操作是否成功的信息
	 */
	public boolean addMiddleOrg(String ID, MiddleOrgVO vo);
	
	/**
	 * 删除一个中转中心
	 * 
	 * 注：没看到有修改机构信息的方法吧？机构的城市和编号不能修改，修改机构通过增减业务员、仓库管理员和下辖机构表现
	 * @param ID 中转中心编号
	 * @return 操作是否成功的信息
	 */
	public boolean removeMiddleOrg(String ID);
	
	
	
	

}
