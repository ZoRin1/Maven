package dataservice.storagedataservice;

public interface UpdateSpaceDataSer {
	
	
	
	/**
	 * 根据输入更新库存信息
	 * 已完成分区调整
	 * @author YangGuan
	 *
	 */
	public void updateDrive(int shipping,int trains,int motor,String city);
}
