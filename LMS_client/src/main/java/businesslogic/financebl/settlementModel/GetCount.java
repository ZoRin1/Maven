package businesslogic.financebl.settlementModel;

import java.util.ArrayList;

import vo.documentsVO.ReceiptVO;
import businesslogicservice.financeblservice.GetAllcountBlSer;

public class GetCount implements GetAllcountBlSer{

	@Override
	public double getAllciunt(ArrayList<ReceiptVO> vo) {
		// TODO 自动生成的方法存根
		double AllEarn = 0;
		for(int i = 0 ; i<vo.size();i++){
			AllEarn += vo.get(i).getFund();
		}
		return AllEarn;
	}

}
