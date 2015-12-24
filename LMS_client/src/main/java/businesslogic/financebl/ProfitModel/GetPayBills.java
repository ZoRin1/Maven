package businesslogic.financebl.ProfitModel;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.documentsPO.PaymentPO;
import po.documentsPO.ReceiptPO;
import businesslogic.documentsbl.GetPayment;
import vo.documentsVO.PaymentVO;
import vo.documentsVO.ReceiptVO;

public class GetPayBills {
	
	private GetPayment getPay;
	private ArrayList<PaymentVO> vo;
	
	public GetPayBills(){
		super();
		getPay = new GetPayment();
		vo = new ArrayList<PaymentVO>();
	}
	//得到付款单集合
	public ArrayList<PaymentVO> getAllPay(String end) throws RemoteException{
		ArrayList<PaymentPO> po = getPay.getAllPay(end);
		PaymentVO v1;
		PaymentPO p1;
		for(int i = 0 ; i<po.size();i++){
			p1 = po.get(i);
			v1 = new PaymentVO(p1.getCode(), p1.getDoName(), p1.getDate(), p1.getAccount(), p1.getFund(), p1.getName2(), p1.getAccount2(), p1.getType(), p1.getRemark());
			vo.add(v1);
		}
		return vo;
	}
}