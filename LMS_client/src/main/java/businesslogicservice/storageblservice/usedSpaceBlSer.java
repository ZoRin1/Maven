package businesslogicservice.storageblservice;

public interface usedSpaceBlSer {
	
	/**
	 * 提供分区调整中需要的各库区已用空间大小。
	 * @author YangGuan
	 * @param city TODO
	 *
	 */
	public int[] usedSpaceInf(String city);
	
	
	/**
	 * 提供分区调整中需要的各库区总空间大小。
	 * @author YangGuan
	 * @param city TODO
	 *
	 */
	public int[] allSpaceInf(String city);
	
	
	
	/**
	 * 提供分区调整中机动库区已用空间大小。
	 * @author YangGuan
	 * @param city TODO
	 *
	 */
	public int getJiDongSpace(String city);
}
