package dataservice.organizationdataservice;

import java.rmi.RemoteException;

import po.orgPO.BussinessOrgPO;
import po.orgPO.DriverPO;
import po.orgPO.VehiclePO;


public interface BussinessOrgDataSer {

	/**
	 * 获得业务员列表
	 * @param ID 所属中转中心-营业厅编号
	 * @return 业务员的ID+name列表
	 */
	public String[] getBussinessmanList(String ID);
	
	/**
	 * 增加一个业务员
	 * @param ID 所属中转中心-营业厅编号
	 * @param bID 欲增加的业务员账号
	 * @return 操作是否成功的信息
	 */
	public boolean addBussinessman(String ID, long bID);
	
	/**
	 * 删除一个业务员
	 * @param ID 所属中转中心-营业厅编号
	 * @param bID 要删除的业务员的账号
	 * @return 操作是否成功的信息
	 */
	public boolean removeBussinessman(String ID, long bID);

	/**
	 * 获得快递员列表
	 * @param ID 所属中转中心-营业厅编号
	 * @param bID 营业厅编号
	 * @return 仓库管理员的ID+name列表
	 */
	public String[] getCourierList(String ID, long bID);
	/**
	 * 增加一个快递员
	 * @param ID 所属中转中心-营业厅编号
	 * @param bID 欲增加的业务员账号
	 * @return 操作是否成功的信息
	 */
	public boolean addCourier(String ID, long bID);
	
	/**
	 * 删除一个快递员
	 * @param ID 所属中转中心-营业厅编号
	 * @param bID 要删除的快递员的账号
	 * @return 操作是否成功的信息
	 */
	public boolean removeCourier(String ID, long bID); 
	
	/**
	 * 获得车辆列表
	 * @param ID 所属中转中心-营业厅编号
	 * @return 车辆代号列表 城市编号+营业厅编号+编号
	 * 
	 */
	public String[] getVehicleList(String ID);
	
	/**
	 * 获得车辆详细信息
	 * @param ID 所属中转中心-营业厅编号
	 * @param codeVehicle 车辆代号 城市编号+营业厅编号+编号
	 * @return 车辆信息
	 */
	public VehiclePO getVehicleInfo(String ID, String codeVehicle);
	
	/**
	 * 增加一个车辆信息
	 * @param ID ；所属中转中心-营业厅编号
	 * @param po 车辆详细信息
	 * @return 操作是否成功的信息
	 * 
	 * @return 
	 */
	public boolean addVehicle(String ID, VehiclePO po);
	
	/**
	 * 删除一个车辆信息
	 * @param ID 所属中转中心-营业厅编号
	 * @param codeVehicle 车辆代号 城市编号+营业厅编号+编号
	 * @return 操作是否成功的信息
	 */
	public boolean removeVehicle(String ID, String codeVehicle);
	
	/**
	 * 修改一个车辆信息
	 * @param ID 所属中转中心-营业厅编号
	 * @param po 车辆详细信息
	 * @return 操作是否成功的信息
	 */
	public boolean changeVehicle(String ID, VehiclePO po);
		
	/**
	 * 获得司机列表
	 * @param ID 所属中转中心-营业厅编号
	 * @return 司机列表 城市编号+营业厅编号+编号
	 * 
	 */
	public String[] getDriverList(String ID);
	
	/**
	 * 获得司机详细信息
	 * @param ID 所属中转中心-营业厅编号
	 * @param codeDriver 车辆代号 城市编号+营业厅编号+编号
	 * @return 司机信息
	 */
	public DriverPO getDriverInfo(String ID, String codeDriver);
	
	/**
	 * 增加一个司机信息
	 * @param ID 所属中转中心-营业厅编号
	 * @param po 车辆详细信息
	 * @return 操作是否成功的信息
	 *
	 */
	public boolean addDriver(String ID, DriverPO po);
	
	/**
	 * 删除一个司机信息
	 * @param ID 所属中转中心-营业厅编号
	 * @param codeDriver 车辆编号 城市编号+营业厅编号+编号
	 * @return 操作是否成功的信息
	 */
	public boolean removeDriver(String ID, String codeDriver);
	
	/**
	 * 修改一个司机信息
	 * @param ID 所属中转中心-营业厅编号
	 * @param po 车辆详细信息
	 * @return 操作是否成功的信息
	 */
	public boolean changeDriver(String ID, DriverPO po);
	
	/**
	 * 新增一个营业厅
	 * @param ID 所属中转中心-营业厅编号
	 * @param po 新增营业厅详细信息
	 * @return 操作是否成功的信息
	 */
	public boolean addBussinessHall(String ID, BussinessOrgPO po);
	
	/**
	 * 删除营业厅
	 * @param ID 所属中转中心-营业厅编号
	 * @param codeNumber 营业厅编号 3位
	 * @return 操作是否成功的信息
	 */
	public boolean removeBussinessHall(String ID, String codeNumber);
	
	/**不实现
	 */
	public String getCodeNumber()throws RemoteException;
	
	/**
	 * 不实现
	 */
	public boolean changeCodeNumberOfMiddle(String ID, String codeNumberOfMiddle);
	
	/**
	 * 返回机构所在地区
	 * @return city
	 */
	public String getInfo(String ID);
	
	/**
	 * 不实现
	 */
	 public boolean changeCity(String ID, String city);
	 
	 /**
	  * 不实现
	  */
	 public boolean changeCodeNumber(String ID, String codeNumber);
	
}
