package businesslogicservice.storageblservice;

import businesslogic.state.ResultMessage;


public interface DriveBlSer {
	
	
	/**
	 * 系统根据输出减去机动区相应空间，判断是否超界，
	 * 若超界则返回失败信息，
	 * 若未超界，则更新库存信息并返回成功消息
	 * @author YangGuan
	 * @param city TODO
	 *
	 */
	public ResultMessage drive(int shipping,int trains,int motor, String city);
}
