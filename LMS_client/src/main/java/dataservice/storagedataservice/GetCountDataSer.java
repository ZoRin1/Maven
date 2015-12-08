package dataservice.storagedataservice;

public interface GetCountDataSer {
	
	/**
	 * 系统返回当前仓库当前时间点的库存数量合计
	 * 已请求库存查询
	 * @author YangGuan
	 *
	 */
	public int getCount(String city);
}
