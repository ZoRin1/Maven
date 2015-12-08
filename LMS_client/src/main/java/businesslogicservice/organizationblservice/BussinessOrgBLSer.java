package businesslogicservice.organizationblservice;

import vo.orgVO.BussinessOrgVO;
import vo.orgVO.DriverVO;
import vo.orgVO.VehicleVO;



public interface BussinessOrgBLSer {
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
	 * @return 仓库管理员的ID+name列表
	 */
	public String[] getCourierList(String ID);
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
	 * @param bID 要删除的仓库管理员的账号
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
	public VehicleVO getVehicleInfo(String ID, String codeVehicle);
	
	/**
	 * 增加一个车辆信息
	 * @param ID 所属中转中心-营业厅编号
	 * @param vo 车辆详细信息
	 * @return 操作是否成功的信息
	 * 
	 * @return 
	 */
	public boolean addVehicle(String ID, VehicleVO vo);
	
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
	 * @param vo 车辆详细信息
	 * @return 操作是否成功的信息
	 */
	public boolean changeVehicle(String ID, VehicleVO vo);
		
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
	public DriverVO getDriverInfo(String ID, String codeDriver);
	
	/**
	 * 增加一个司机信息
	 * @param ID 所属中转中心-营业厅编号
	 * @param vo 车辆详细信息
	 * @return 操作是否成功的信息
	 * 
	 * @return 
	 */
	public boolean addDriver(String ID, DriverVO vo);
	
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
	 * @param vo 车辆详细信息
	 * @return 操作是否成功的信息
	 */
	public boolean changeDriver(String ID, DriverVO vo);
	
	/**
	 * 新增一个营业厅
	 * @param ID 所属中转中心-营业厅编号
	 * @param vo 新增营业厅详细信息
	 * @return 操作是否成功的信息
	 */
	public boolean addBussinessHall(String ID, BussinessOrgVO vo);
	
	/**
	 * 删除营业厅
	 * @param ID 所属中转中心-营业厅编号
	 * @param codeNumber 营业厅编号 3位
	 * @return 操作是否成功的信息
	 */
	public boolean removeBussinessHall(String ID, String codeNumber);
	
	/**此方法已经无意义，不必考虑实现
	 * 获得营业厅所属中转中心编号
	 * @return codeNumber 中转中心编号
	 */
	public String getCodeNumber();
	
	/**
	 * 修改营业厅所属中转中心编号
	 * 修改后要重新获得营业厅编号，要修改营业厅编号
	 * @param ID 所属中转中心-营业厅编号
	 * @param codeNumberOfMiddle 所属中转中心编号
	 * @return 操作是否成功的信息
	 */
	public boolean changeCodeNumberOfMiddle(String ID, String codeNumberOfMiddle);
	
	/**
	 * 获得机构其他信息，即城市和编号
	 * @param ID 所属中转中心-营业厅编号
	 * @return 城市+编号
	 */
	public String getInfo(String ID);
	
	/**
	 * 修改营业厅所在城市/地点（较小）
	 * @param ID 所属中转中心-营业厅编号
	 * @param city 欲修改的城市
	 * @return 操作是否成功的信息
	 */
	 public boolean changeCity(String ID, String city);
	 
	 /**
	  * 修改营业厅编号，不是总经理输入，而是改变所属中转中心后有中转中心生成的编号
	 * @param ID 所属中转中心-营业厅编号
	 * @param codeNumber 欲修改的机构编号
	  * @return 操作是否成功的信息
	  */
	 public boolean changeCodeNumber(String ID, String codeNumber);
	
	
	
	
	

}
