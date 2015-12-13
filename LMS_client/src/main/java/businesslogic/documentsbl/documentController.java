package businesslogic.documentsbl;

import java.util.ArrayList;

import po.documentsPO.DocumentPO;
import po.documentsPO.InBillsPO;
import po.documentsPO.PaymentPO;
import po.documentsPO.ReceiptPO;

public class documentController {
	//创建单据时获得单据编号（所有单据都要经过这一步）
	public String getDocCode(String doName,String account) {
		createDocument cr=new createDocument();
		return cr.createDocument(doName,account);
	}
	
	//将po存入数据库（所有单据都要经过这一步）
	public boolean createBlock(DocumentPO po){
		createBlock cr=new createBlock();
		return cr.createBlock(po);
	}
	
	//寄件单,装运单计算运费
	public double getCost(String departure, String arrival, String trans,double weight){
		DocumentsList list=new DocumentsList(departure,arrival,trans,weight);
		return list.getCost();
	}
	
	//装车单计算运费
	public double getShortCost(){
		DocumentsLineItem item=new DocumentsLineItem(1);
		return item.getCost();
	}
	
	//寄件单中获得预计天数
	public int getDays(String departure, String arrival, String trans,double weight){
		DocumentsList list=new DocumentsList(departure,arrival,trans,weight);
		return list.getDays();
	}
	
	//将单个单据已审批和通过情况传入数据库，返回值为是否成功（实际并没有意义，下面还没有防范措施）（总经理）
	public boolean examined(String code, String doName, boolean Examined){
		Examined ex=new Examined();
		return ex.examined(code, doName, Examined);
	}
	
	//审批单据中生成单据列表（总经理）
	public ArrayList<String> showList(){
		showBufferedList sh=new showBufferedList();
		return sh.showList();
	}
	
	//单据反馈中生成单据列表
	public ArrayList<String> showOwnList(String account){
		showBufferedList sh=new showBufferedList();
		return sh.showOwnList(account);
	}
	
	//审批单据和单据反馈中获得单据详细信息
	public DocumentPO getBufferedInfo(String code, String doName){
		getBufferedInfo get=new getBufferedInfo();
		return get.getBufferedInfo(code, doName);
	}
	
	//获得时间段内的入库单
	public ArrayList<InBillsPO> getInBill(String account, String start,
			String end){
		GetInBills get=new GetInBills();
		return get.getInBill(account, start, end);
	}
	
	//获得截止日期内的入库单
	public ArrayList<InBillsPO> getAllInBills(String account, String end){
		GetInBills get=new GetInBills();
		return get.getAllInBills(account, end);
	}
	
	//获得截止日期内的付款单
	public ArrayList<PaymentPO> getAllPay(String end){
		GetPayment get=new GetPayment();
		return get.getAllPay(end);
	}
	
	//获得时间段内的付款单
	public ArrayList<PaymentPO> getAllPay(String start, String end){
		GetPayment get=new GetPayment();
		return get.getAllPay(start,end);
	}
	
	//获得某营业厅某天的收款单
	public ArrayList<ReceiptPO> getReceipts(String selling, String date){
		GetReceipt get=new GetReceipt();
		return get.getReceipts(selling, date);
	}
	
	//获得截止日期内的所有收款单
	public ArrayList<ReceiptPO> getAllReceipts(String end){
		GetReceipt get=new GetReceipt();
		return get.getAllReceipts(end);
	}
	
	//获得时间段内的所有收款单
	public ArrayList<ReceiptPO> getAllReceipts(String start, String end){
		GetReceipt get=new GetReceipt();
		return get.getAllReceipts(start,end);
	}
	
	//获得某个订单的物流信息
	public ArrayList<String> getWuliuInfo(String code){
		getWuliuInfo get=new getWuliuInfo();
		return get.getWuliuInfo(code);
	}
	
	//出库单更新库存信息
	public void updateDrive(String InDepotCode,String city){
		UpdateSpace up=new UpdateSpace(InDepotCode,city);
		up.updateDrive();
	}
}
