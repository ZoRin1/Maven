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
		String result = "单据编号:" + po.getCode();
		result = result + "\n对应订单编号:" + po.getCode1();
		result = result + "\n创建人账号:" + po.getAccount();
		result = result + "\n收件人姓名:" + po.getReceiverName();
		result = result + "\n收件时间:" + po.getDate();
		return result;
	}
	
	public static String inBillsPO (InBillsPO po){
		String result ="单据编号:" + po.getCode();
		result = result + "\n入库快递编号:" + po.getInDepotNum();
		result = result + "\n创入库日期:" + po.getInDepotDate();
		result = result + "\n创建人账号:" + po.getAccount();
		result = result + "\n目的地:" + po.getDestination();
		result = result + "\n区号:" + po.getAreaNum();
		result = result + "\n排号:" + po.getRowNum();
		result = result + "\n架号:" + po.getShelvesNum();
		result = result + "\n位号:" + po.getSositionNum();
		return result;
	}
	
	public static String loadingPO(LoadingPO po){
		String result = "单据编号:" + po.getCode();
		result = result + "\n装运日期:" + po.getDate();
		result = result + "\n创建人账号:" + po.getAccount();
		result = result + "\n出发地:" + po.getDeparture();
		result = result + "\n目的地:" + po.getArrival();
		result = result + "\n监装员:" + po.getSupervisor();
		result = result + "\n亚运员:" + po.getSupercargo();
		result = result + "\n运费:" + String.valueOf(po.getCharge());
		return result;
	}
	
	public static String orderPO(OrderPO po){
		String result = "单据编号:" + po.getCode();
		result = result + "    创建人账号:" + po.getAccount();
		result = result + "\n日期:" + po.getDate();
		result = result + "    寄件人姓名:" + po.getSenderName();
		result = result + "\n寄件人地址:" + po.getSenderAddress();
		result = result + "    寄件人电话:" + po.getSPhoneNumber();
		result = result + "\n寄件人手机:" + po.getSMobileNumber();
		result = result + "    收件人姓名:" + po.getReceiverName();
		result = result + "\n收件人地址:" + po.getReceiverAddress();
		result = result + "    收件人单位:" + po.getReceiverOrg();
		result = result + "\n收件人电话:" + po.getRPhoneNumber();
		result = result + "    收件人手机:" + po.getRMobileNumber();
		result = result + "\n货物数量:" + String.valueOf(po.getNumber());
		result = result + "    货物重量:" + String.valueOf(po.getWeight());
		result = result + "\n货物体积:" + String.valueOf(po.getShape());
		result = result + "    货物名:" + po.getCargoNameList();
		result = result + "\n货物大学:" + "/长:" + po.getSizeList()[0] + "/宽:" + po.getSizeList()[1] + "/高:" + po.getSizeList()[2];
		result = result + "    总费用:" + po.getSumCost();
		result = result + "\n快递种类:" + po.getState();
		return result;
	}
	
	public static String outBillsPO(OutbillsPO po){
		String result =  "单据编号:" + po.getCode();
		result = result + "\n快递编号:" + po.getPackCode();
		result = result + "\n出库日期:" + po.getDate();
		result = result + "\n创建人账号:" + po.getAccount();
		result = result + "\n目的地:" + po.getArrival();
		result = result + "\n装运形式:" + po.getMode();
		result = result + "\n汽运编号:" + po.getTransCode();
		return result;
	}
	
	public static String payMentPO(PaymentPO po){
		String result = "单据编号:" + po.getCode();
		result = result + "\n付款日期:" + po.getDate();
		result = result + "\n创建人账号:" + po.getAccount();
		result = result + "\n付款金额:" + po.getFund();
		result = result + "\n付款人姓名:" + po.getName2();
		result = result + "\n付款账号:" + po.getAccount2();
		result = result + "\n条目:" + po.getType();
		result = result + "\n备注:" + po.getRemark();			
		return result;
	}
	
	public static String receiptPO(ReceiptPO po){
		String result = "单据编号:" + po.getCode();
		result = result + "\n收款日期:" + po.getDate();
		result = result + "\n创建人账号:" + po.getAccount();
		result = result + "\n营业厅编号:" + po.getOrgCode();
		result = result + "\n收款金额:" + po.getFund();
		result = result + "\n快递员姓名:" + po.getName2();		
		return result;
	}
	
	public static String yDispatchPO(YDispatchPO po){
		String result = "单据编号:" + po.getCode();
		result = result + "\n派件日期:" + po.getDate();
		result = result + "\n对应订单编号:" + po.getCode2();
		result = result + "\n创建人账号:" + po.getAccount();
		result = result + "\n派件快递员姓名:" + po.getName2();		
		return result;
	}
	
	public static String yReceivePO (YReceivePO po){
		String result ="单据编号:" + po.getCode();
		result = result + "\n派件日期:" + po.getDate();
		result = result + "\n订单条形码号:" + po.getCode1();
		result = result + "\n创建人账号:" + po.getAccount();
		result = result + "\n出发地:" + po.getDeparture();
		result = result + "\n到达地:" + po.getArrival();
		result = result + "\n货物状态:" + po.getState();
		return result;
	}

	public static String zLoadingPO(ZLoadingPO po){
		String result = "单据编号:" + po.getCode();
		result = result + "\n装运日期:" + po.getDate();
		result = result + "\n创建人账号:" + po.getAccount();
		result = result + "\n车辆编号:" + po.getTranscode();
		result = result + "\n出发地:" + po.getDeparture();
		result = result + "\n到达地:" + po.getArrival();
		result = result + "\n监装员姓名:" + po.getName2();
		result = result + "\n运费:" + po.getCarriage();	
		return result;
	}
	
	public static String zReceivePO(ZReceivePO po){
		String result = "单据编号:" + po.getCode();
		result = result + "\n中转日期:" + po.getDate();
		result = result + "\n创建人账号:" + po.getAccount();
		result = result + "\n中转中心汽运编号:" + po.getzCode();
		result = result + "\n出发地:" + po.getDeparture();
		result = result + "\n到达地:" + po.getArrival();
		return result;
	}
}
