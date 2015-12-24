package presentation.topmanagerui;

import businesslogic.storagebl.DriveModel.returnSpace;
import po.documentsPO.GetOrderPO;
import po.documentsPO.InBillsPO;
import po.documentsPO.LoadingPO;
import po.documentsPO.OrderPO;
import po.documentsPO.OutbillsPO;
import po.documentsPO.PaymentPO;
import po.documentsPO.ReceiptPO;
import po.documentsPO.YDispatchPO;
import po.documentsPO.YReceivePO;
import po.documentsPO.ZLoadingPO;
import po.documentsPO.ZReceivePO;

public class DocumentsToString {
	
	public static String getOrderPO (GetOrderPO po){
		String result = "<html>单据编号:" + po.getCode();
		result = result + "<br>对应订单编号:" + po.getCode1();
		result = result + "<br>创建人账号:" + po.getAccount();
		result = result + "<br>收件人姓名:" + po.getReceiverName();
		result = result + "<br>收件时间:" + po.getDate()+"</html>";
		return result;
	}
	
	public static String inBillsPO (InBillsPO po){
		String result ="<html>单据编号:" + po.getCode();
		result = result + "<br>入库快递编号:" + po.getInDepotNum();
		result = result + "<br>创入库日期:" + po.getInDepotDate();
		result = result + "<br>创建人账号:" + po.getAccount();
		result = result + "<br>目的地:" + po.getDestination();
		result = result + "<br>区号:" + po.getAreaNum();
		result = result + "<br>排号:" + po.getRowNum();
		result = result + "<br>架号:" + po.getShelvesNum();
		result = result + "<br>位号:" + po.getSositionNum()+"</html>";
		return result;
	}
	
	public static String loadingPO(LoadingPO po){
		String result = "<html>单据编号:" + po.getCode();
		result = result + "<br>装运日期:" + po.getDate();
		result = result + "<br>创建人账号:" + po.getAccount();
		result = result + "<br>出发地:" + po.getDeparture();
		result = result + "<br>目的地:" + po.getArrival();
		result = result + "<br>监装员:" + po.getSupervisor();
		result = result + "<br>亚运员:" + po.getSupercargo();
		result = result + "<br>运费:" + String.valueOf(po.getCharge())+"</html>";
		return result;
	}
	
	public static String orderPO(OrderPO po){
		String result = "<html>单据编号:" + po.getCode();
		result = result + "    创建人账号:" + po.getAccount();
		result = result + "<br>日期:" + po.getDate();
		result = result + "    寄件人姓名:" + po.getSenderName();
		result = result + "<br>寄件人地址:" + po.getSenderAddress();
		result = result + "    寄件人电话:" + po.getSPhoneNumber();
		result = result + "<br>寄件人手机:" + po.getSMobileNumber();
		result = result + "    收件人姓名:" + po.getReceiverName();
		result = result + "<br>收件人地址:" + po.getReceiverAddress();
		result = result + "    收件人单位:" + po.getReceiverOrg();
		result = result + "<br>收件人电话:" + po.getRPhoneNumber();
		result = result + "    收件人手机:" + po.getRMobileNumber();
		result = result + "<br>货物数量:" + String.valueOf(po.getNumber());
		result = result + "    货物重量:" + String.valueOf(po.getWeight());
		result = result + "<br>货物体积:" + String.valueOf(po.getShape());
		result = result + "    货物名:" + po.getCargoNameList();
		result = result + "<br>货物大学:" + "/长:" + po.getSizeList()[0] + "/宽:" + po.getSizeList()[1] + "/高:" + po.getSizeList()[2];
		result = result + "    总费用:" + po.getSumCost();
		result = result + "<br>快递种类:" + po.getState()+"</html>";
		return result;
	}
	
	public static String outBillsPO(OutbillsPO po){
		String result =  "<html>单据编号:" + po.getCode();
		result = result + "<br>快递编号:" + po.getPackCode();
		result = result + "<br>出库日期:" + po.getDate();
		result = result + "<br>创建人账号:" + po.getAccount();
		result = result + "<br>目的地:" + po.getArrival();
		result = result + "<br>装运形式:" + po.getMode();
		result = result + "<br>汽运编号:" + po.getTransCode()+"</html>";
		return result;
	}
	
	public static String payMentPO(PaymentPO po){
		String result = "<html>单据编号:" + po.getCode();
		result = result + "<br>付款日期:" + po.getDate();
		result = result + "<br>创建人账号:" + po.getAccount();
		result = result + "<br>付款金额:" + po.getFund();
		result = result + "<br>付款人姓名:" + po.getName2();
		result = result + "<br>付款账号:" + po.getAccount2();
		result = result + "<br>条目:" + po.getType();
		result = result + "<br>备注:" + po.getRemark()+"</html>";			
		return result;
	}
	
	public static String receiptPO(ReceiptPO po){
		String result = "<html>单据编号:" + po.getCode();
		result = result + "<br>收款日期:" + po.getDate();
		result = result + "<br>创建人账号:" + po.getAccount();
		result = result + "<br>营业厅编号:" + po.getOrgCode();
		result = result + "<br>收款金额:" + po.getFund();
		result = result + "<br>快递员姓名:" + po.getName2()+"</html>";		
		return result;
	}
	
	public static String yDispatchPO(YDispatchPO po){
		String result = "<html>单据编号:" + po.getCode();
		result = result + "<br>派件日期:" + po.getDate();
		result = result + "<br>对应订单编号:" + po.getCode2();
		result = result + "<br>创建人账号:" + po.getAccount();
		result = result + "<br>派件快递员姓名:" + po.getName2()+"</html>";		
		return result;
	}
	
	public static String yReceivePO (YReceivePO po){
		String result ="<html>单据编号:" + po.getCode();
		result = result + "<br>派件日期:" + po.getDate();
		result = result + "<br>订单条形码号:" + po.getCode1();
		result = result + "<br>创建人账号:" + po.getAccount();
		result = result + "<br>出发地:" + po.getDeparture();
		result = result + "<br>到达地:" + po.getArrival();
		result = result + "<br>货物状态:" + po.getState()+"</html>";
		return result;
	}

	public static String zLoadingPO(ZLoadingPO po){
		String result = "<html>单据编号:" + po.getCode();
		result = result + "<br>装运日期:" + po.getDate();
		result = result + "<br>创建人账号:" + po.getAccount();
		result = result + "<br>车辆编号:" + po.getTranscode();
		result = result + "<br>出发地:" + po.getDeparture();
		result = result + "<br>到达地:" + po.getArrival();
		result = result + "<br>监装员姓名:" + po.getName2();
		result = result + "<br>运费:" + po.getCarriage()+"</html>";	
		return result;
	}
	
	public static String zReceivePO(ZReceivePO po){
		String result = "<html>单据编号:" + po.getCode();
		result = result + "<br>中转日期:" + po.getDate();
		result = result + "<br>创建人账号:" + po.getAccount();
		result = result + "<br>中转中心汽运编号:" + po.getzCode();
		result = result + "<br>出发地:" + po.getDeparture();
		result = result + "<br>到达地:" + po.getArrival()+"</html>";
		return result;
	}
}
