package po.documentsPO;

import java.io.Serializable;

public class DocumentPO implements Serializable{
	private String code;
	private String doName;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDoName() {
		return doName;
	}
	public void setDoName(String doName) {
		this.doName = doName;
	}
}
