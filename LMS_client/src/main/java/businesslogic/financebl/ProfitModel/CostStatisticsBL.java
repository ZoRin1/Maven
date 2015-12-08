package businesslogic.financebl.ProfitModel;

import java.util.ArrayList;

import vo.documentsVO.PaymentVO;
import vo.documentsVO.ReceiptVO;
import businesslogicservice.financeblservice.EarnOrPayBlSer;

public class CostStatisticsBL implements EarnOrPayBlSer{
	
	private GetPayBills getPayBills;
	private GetReceipt getReceipt;
	
	public CostStatisticsBL(){
		super();
		getPayBills = new GetPayBills();
		getReceipt = new GetReceipt();
	}
	//得到总收入
	public double CalculateGet(String end){
		ArrayList<ReceiptVO> get = getReceipt.getAllReceivables(end);
		double Earn = 0;
		for(int i = 0 ; i < get.size();i++){
			Earn+=get.get(i).getFund();
		}
		return Earn;
		
	}
	//得到总支出
	public double CalculatePay(String end){
		ArrayList<PaymentVO> pay = getPayBills.getAllPay(end);
		double Allpay =0;
		for(int i = 0 ; i <pay.size();i++){
			Allpay+=pay.get(i).getFund();
		}
		return Allpay;
	}
	//得到成本收益
	public double CalculateCost(){
		return 0;
		
	}
	//调用CalculateGet
	@Override
	public double allEarn(String end) {
		// TODO 自动生成的方法存根
		return 0;
	}
	//调用CalculatePay
	@Override
	public double allPay(String end) {
		// TODO 自动生成的方法存根
		return 0;
	}
}
