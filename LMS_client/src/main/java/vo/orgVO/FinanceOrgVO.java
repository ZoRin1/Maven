package vo.orgVO;

import java.util.ArrayList;

import vo.accountVO.AccountNumberVO;

/**
 * 
 *用来显示财务部
 *
 * @author YangHua'an
 *
 */
public class FinanceOrgVO {

	private String city;//机构所在城市
	private String codeNumber;//机构编号，财务部唯一且为000；
	private ArrayList<String> financer;//财务人员账号列表
	
	public FinanceOrgVO(String city, String codeNumber, ArrayList<String> financer) {
		super();
		this.city = city;
		this.codeNumber = codeNumber;
		this.financer = financer;
//		for(AccountNumberVO vo:financer){
//			vo.setState(5+"-"+city+"-财务部");
//		}
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

//	public ArrayList<AccountNumberVO> getFinancer() {
//		return financer;
//	}
//
//	public void setFinancer(ArrayList<AccountNumberVO> financer) {
//		this.financer = financer;
//	}
//	
//	public void addFinancer(AccountNumberVO vo){
//		this.financer.add(vo);	
//		vo.setState(5+"-"+city+"-财务部");
//	}
//	
//	public void removeFinancer( AccountNumberVO vo){
//	this.financer.remove(vo);
//	vo.setState(null);
//
//	}
}
