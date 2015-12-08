package dataservice.transportationdataservice;

import java.rmi.RemoteException;

import po.transpotationPO.RoutePO;



public interface TransportationDataSer {

	/**
	 * 修改对应线路的距离常量
	 * @param RoutePO 修改后的路线
	 * @return boolean 操作是否成功的信息
	 * 
	 */
	public boolean updateDistance(RoutePO route);
	
	/**
	 * 更新成本常量
	 * @param type 成本常量种类 1代表公路 2代表铁路 3代表空运
	 * @param int 修改后的成本常量
	 * @return boolean 操作是否成功的信息
	 * 
	 */
	public boolean updateCost(int type, double cost);
	
	/**
	 * 获得成本常量
	 * @param type 成本常量种类 1代表公路 2代表铁路 3代表空运
	 * 
	 * @return int 成本常量
	 * 
	 */
	public double findCost(int type);
	
	/**
	 * 增加一条路线
	 * @param RoutePO 欲增加的路线
	 * @return boolean 操作是否成功的信息
	 * 
	 */
	public boolean insertRoute(RoutePO route);
	
	/**
	 * 获得对应线路的距离常量
	 * @param line 查询的线路
	 * @return int,距离常量
	 * 
	 */
	public double findDistance(String line);
	
	/**
	 * 获得除选择的城市之外的城市列表
	 * @param String city 选择的城市
	 * @return String[] 城市列表
	 */
	public String[] findCityList(String city);
	
	
	/**
	 * 从现有城市列表增加一个城市
	 * @param city 欲增加的城市
	 * @return boolean 操作是否成功的信息
	 */
	public boolean insertCity(String city);
	
	/**
	 * 从现有城市列表删除一个城市
	 * @param city 欲删除的城市
	 * @return boolean 操作是否成功的信息
	 */
	public boolean removeCity(String city);
	
	/*
	 * 获得工资策略
	 * @param employee 员工种类
	 * 1代表快递员
	 * 2代表营业厅业务员
	 * 3代表中转中心业务员
	 * 4代表中转中心仓库管理员
	 * 5代表财务人员
	 * 6代表总经理
	 * 7代表系统管理员
	 
	 *@return double[] 对应员工的三个工资策略数值的数组  分别是 按月  计次  提成
	 *
	 */
	public double[] getSalary(int employee);
	
	/*
	 * 修改工资策略
	 * @param employee 员工种类
	 * 1代表快递员
	 * 2代表营业厅业务员
	 * 3代表中转中心业务员
	 * 4代表中转中心仓库管理员
	 * 5代表财务人员
	 * 6代表总经理
	 * 7代表系统管理员
	 * @param salary 员工的三个工资策略数值的数组  分别是 按月  计次  提成
	 * @return boolean 修改操作是否成功
	 * 
	 */
	
	public boolean changeSalary(int employee,double [] salary);
	
}
