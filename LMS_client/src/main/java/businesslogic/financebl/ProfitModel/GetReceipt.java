package businesslogic.financebl.ProfitModel;

import java.util.ArrayList;

import po.documentsPO.ReceiptPO;
import vo.documentsVO.ReceiptVO;

public class GetReceipt {
	
	private businesslogic.documentsbl.GetReceipt getReceipt;
	private ArrayList<ReceiptVO> vo;
	
	public GetReceipt(){
		super();
		getReceipt = new businesslogic.documentsbl.GetReceipt();
		vo = new ArrayList<ReceiptVO>();
	}
	//得到收款单集合
	public ArrayList<ReceiptVO> getAllReceivables(String end){
		ArrayList<ReceiptPO> po = getReceipt.getAllReceipts(end);
		ReceiptVO v1;
		ReceiptPO p1;
		for(int i = 0 ; i<po.size();i++){
			p1 = po.get(i);
			v1 = new ReceiptVO(p1.getCode(), p1.getDoName(), p1.getDate(), p1.getFund(), p1.getAccount(), p1.getOrgCode(), p1.getName2(), p1.getTCode());
			vo.add(v1);
		}
		return vo;
	}
}
