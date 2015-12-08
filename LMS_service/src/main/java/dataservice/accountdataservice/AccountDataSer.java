package dataservice.accountdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.accountPO.AccountInfoPO;



public interface AccountDataSer extends Remote{
	/**
	 * 提供信息验证-(所属中转中心城市-）所在城市-所属机构名称-中转中心编号（-营业厅编号）
	 * @param ID 账号
	 * @param passwrd 密码
	 * @return String 信息验证结果   int-(所属中转中心城市-）所在城市-所属机构名称-中转中心编号（-营业厅编号）
	 * 0代表空闲
	 * 1代表快递员
	 * 2代表营业厅业务员
	 * 3代表中转中心业务员
	 * 4代表中转中心仓库管理员
	 * 5代表财务人员
	 * 6代表总经理
	 * 7代表系统管理员
	 * 例子：1-南京-鼓楼-营业厅-001-001  表示南京鼓楼营业厅的快递员
	 *      3-南京-中转中心-001  表示南京中转中心的业务员
	 *      0 表示空闲
	 *      null表示验证失败
	 */
	public String campare(long ID,String password)throws RemoteException;
	
	/**
	 * 增加一个账号
	 * @param ID 账号
	 * @param po 账号详细信息
	 * @return boolean 操作是否成功的信息
	 * 
	 */
	public boolean insert(long ID,AccountInfoPO po)throws RemoteException;
	
	/**
	 * 修改账号信息
	 * @param ID 账号
	 * @param po 账号详细信息
	 * @return  返回操作是否成功的信息
	 * 
	 */
	public boolean update(long ID,AccountInfoPO po)throws RemoteException;
	
	/**
	 * 删除一个账号信息
	 * @param ID 账号
	 * @return 操作是否成功的信息
	 * 
	 */
	public boolean delete(long ID)throws RemoteException;
	
	/**
	 * 获得与输入ID相同的账号的信息
	 * @param ID 账号
	 * @return 账号信息
	 */
	public AccountInfoPO find(long ID)throws RemoteException;
	/**
	 * 获得与输入name相同的账号的ID+name列表
	 * @param name 账号姓名
	 * @return String[],ID+name
	 * 
	 */
	public String[] find(String name)throws RemoteException;
	
	/**
	 * 获得现在空闲的账号员工账号和姓名列表
	 * @return ID+name列表
	 * 
	 */
	public String[] find()throws RemoteException;
}
