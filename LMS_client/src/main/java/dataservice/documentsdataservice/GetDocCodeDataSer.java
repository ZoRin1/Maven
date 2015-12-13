package dataservice.documentsdataservice;

public interface GetDocCodeDataSer {
	//新建单据时生成新的单据编号,
	public String getDocCode(String doName,String account);
}