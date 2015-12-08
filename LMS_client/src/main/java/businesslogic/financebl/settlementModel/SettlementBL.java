package businesslogic.financebl.settlementModel;

import java.util.ArrayList;

import po.documentsPO.ReceiptPO;
import businesslogic.documentsbl.GetReceipt;
import businesslogicservice.financeblservice.GetReceivablesBillsBlSer;
import vo.documentsVO.ReceiptVO;

public class SettlementBL implements GetReceivablesBillsBlSer{
	
	private ArrayList<ReceiptVO> vo;
	private ArrayList<ReceiptPO> po;
	private GetReceipt getReceipt;
	
	public SettlementBL(){
		super();
		getReceipt = new GetReceipt();
		vo = new ArrayList<ReceiptVO>();
	}

	@Override
	public ArrayList<ReceiptVO> getReceivables(String selling, String date) {
		// TODO 自动生成的方法存根
		po = getReceipt.getReceipts(selling, date);
		ReceiptVO v1;
		ReceiptPO p1;
		for(int i = 0 ; i<po.size();i++){
			p1 = po.get(i);
			v1 = new ReceiptVO(p1.getCode(), p1.getDoName(), p1.getDate(), p1.getFund(), p1.getAccount(), p1.getOrgCode(), p1.getName2(), p1.getTCode());
			vo.add(v1);
		}
		return vo;
	}

	@Override
	public ArrayList<ReceiptVO> getAllReceivables(String end) {
		// TODO 自动生成的方法存根
		po = getReceipt.getAllReceipts(end);
		ReceiptVO v1;
		ReceiptPO p1;
		for(int i = 0 ; i<po.size();i++){
			p1 = po.get(i);
			v1 = new ReceiptVO(p1.getCode(), p1.getDoName(), p1.getDate(), p1.getFund(), p1.getAccount(), p1.getOrgCode(), p1.getName2(), p1.getTCode());
			vo.add(v1);
		}
		return vo;
	}

	@Override
	public ArrayList<ReceiptVO> getSomeReceivables(String start,
			String end) {
		// TODO 自动生成的方法存根
		po = getReceipt.getAllReceipts(start, end);
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
