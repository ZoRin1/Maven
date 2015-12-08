package vo.storageVO;



/**
 * 用于显示入库快递编号、入库日期、目的地和存储位置
 * 用于库存盘点
 * @author YangGuan
 *
 */
public class InDepotInfVO {
	
	
	private String InDepotNum; //入库快递编号
	private String InDepotDate; //入库日期
	private String Destination; // 目的地
	private int AreaNum; //区号
	private int RowNum; //排号
	private int ShelvesNum;  //架号
	private int SositionNum; //位号
	
	
	public InDepotInfVO(String inDepotNum, String inDepotDate,
			String destination, int areaNum, int rowNum,
			int shelvesNum, int sositionNum) {
		super();
		InDepotNum = inDepotNum;
		InDepotDate = inDepotDate;
		Destination = destination;
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


	public String getInDepotDate() {
		return InDepotDate;
	}


	public void setInDepotDate(String inDepotDate) {
		InDepotDate = inDepotDate;
	}


	public String getDestination() {
		return Destination;
	}


	public void setDestination(String destination) {
		Destination = destination;
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
