package po.orgPO;
/**
 * 用来表示财务部机构信息持久化对象
 * 
 * @author YangHua'an
 *
 */
import java.io.Serializable;
import java.util.ArrayList;

import po.accountPO.AccountInfoPO;


public class FinanceOrgPO implements Serializable {

	/**
	 * 
	 * 序列号版本号
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String city;//机构所在城市
	private String codeNumber;//机构编号，财务部唯一且为000；
	private ArrayList<AccountInfoPO> financer;//财务人员账号列表
	
	public FinanceOrgPO(String city, String codeNumber, ArrayList<AccountInfoPO> financer) {
		super();
		this.city = city;
		this.codeNumber = codeNumber;
		this.financer = financer;
		for(AccountInfoPO po:financer){
			po.setState(5+"-"+city+"-财务部");
		}
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCodeNumber() {
		return codeNumber;
	}

	public void setCodeNumber(String codeNumber) {
		this.codeNumber = codeNumber;
	}

	
	public ArrayList<AccountInfoPO> getFinancer() {
		return financer;
	}

	public void setFinancer(ArrayList<AccountInfoPO> financer) {
		this.financer = financer;
	}

	public void addFinancer(AccountInfoPO po){
		this.financer.add(po);	
		po.setState(5+"-"+city+"-财务部");
	}
	
	public void removeFinancer(AccountInfoPO po){
	this.financer.remove(po);
	po.setState(null);

	}
	
	
}