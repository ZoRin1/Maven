package vo.storageVO;



/**
 * 用于显示入库快递编号、金额信息和存储位置
 * 用于库存查询
 * @author YangGuan
 *
 */
public class SimpleInDepotInfVO {
	
	
	private String InDepotNum; //入库快递编号
	private int AreaNum; //区号
	private int RowNum; //排号
	private int ShelvesNum;  //架号
	private int SositionNum; //位号
	public SimpleInDepotInfVO(String inDepotNum, int areaNum,
			int rowNum, int shelvesNum, int sositionNum) {
		super();
		InDepotNum = inDepotNum;
		AreaNum = areaNum;
		RowNum = rowNum;
		ShelvesNum = shelvesNum;
		SositionNum = sositionNum;
	}
	public String getInDepotNum() {
		return InDepotNum;
	}
	public void setInDepotNum(String inDepotNum) {
		InDepotNum = inDepotNum;
	}
	public int getAreaNum() {
		return AreaNum;
	}
	public void setAreaNum(int areaNum) {
		AreaNum = areaNum;
	}
	public int getRowNum() {
		return RowNum;
	}
	public void setRowNum(int rowNum) {
		RowNum = rowNum;
	}
	public int getShelvesNum() {
		return ShelvesNum;
	}
	public void setShelvesNum(int shelvesNum) {
		ShelvesNum = shelvesNum;
	}
	public int getSositionNum() {
		return SositionNum;
	}
	public void setSositionNum(int sositionNum) {
		SositionNum = sositionNum;
	}
	
	
}
