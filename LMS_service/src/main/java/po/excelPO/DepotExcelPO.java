package po.excelPO;

import java.io.Serializable;

public class DepotExcelPO extends ExcelPO implements Serializable{
	
	private int qu;
	private int pai;
	private int jia;
	private int wei;
	private String code;
	private String date;
	public DepotExcelPO(int qu, int pai, int jia, int wei, String code,
			String date) {
		super();
		this.qu = qu;
		this.pai = pai;
		this.jia = jia;
		this.wei = wei;
		this.code = code;
		this.date = date;
	}
	public int getQu() {
		return qu;
	}
	public void setQu(int qu) {
		this.qu = qu;
	}
	public int getPai() {
		return pai;
	}
	public void setPai(int pai) {
		this.pai = pai;
	}
	public int getJia() {
		return jia;
	}
	public void setJia(int jia) {
		this.jia = jia;
	}
	public int getWei() {
		return wei;
	}
	public void setWei(int wei) {
		this.wei = wei;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Object getData(int index){
		switch(index){
		case 0:
			return getCode();
		case 1:
			return getDate();
		case 2:
			return getQu();
		case 3:
			return getPai();
		case 4:
			return getJia();
		case 5:
			return getWei();
		default:
			return null;
		}
	}
}
