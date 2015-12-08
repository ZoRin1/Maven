package businesslogic.financebl.ProfitModel;

import java.text.SimpleDateFormat;
import java.util.Date;

import vo.financeVO.ProfitVO;

public class ProfitController {
	
	private CostStatisticsBL cost;
	
	//返回ProfitVO逻辑类
	private ProfitBL profit;
	
	
	public ProfitController() {
		super();
		cost = new CostStatisticsBL();
		profit = new ProfitBL();
	}

	//不太需要
//	public double earn(String [] selling){
//		return 0;
//	}
	
	//不太需要
//	public double pay(String [] selling){
//		return 0;
//	}
	
	public ProfitVO returnPro(String end){
		double earn = cost.CalculateGet(end);
		double pay = cost.CalculatePay(end);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());
		ProfitVO pro = new ProfitVO(earn,pay,date);
		return pro;
	}
}
