package businesslogic.storagebl.ExcelModel;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import po.storagePO.DepotExcelPO;

public class OutExcel {
	
	private String addresss;
//	private ArrayList<DepotExcelPO> list;
	private List<DepotExcelPO> Depotlist;
	
	public OutExcel(){
		super();
	}
	
	public void outExcel(String address,ArrayList<DepotExcelPO> arrList){
		Depotlist = arrList;
		
		// 第一步，创建一个webbook，对应一个Excel文件 
		HSSFWorkbook wb = new HSSFWorkbook();  
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
        HSSFSheet sheet = wb.createSheet("库存快照表"); 
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
        HSSFRow row = sheet.createRow((int) 0);  
        // 第四步，创建单元格，并设置值表头 设置表头居中 
        HSSFCellStyle style = wb.createCellStyle();  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
        
        HSSFCell cell = row.createCell((short) 0);  
        cell.setCellValue("入库单编号");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 1);  
        cell.setCellValue("入库日期");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 2);  
        cell.setCellValue("区");  
        cell.setCellStyle(style); 
        cell = row.createCell((short) 3);  
        cell.setCellValue("排");  
        cell.setCellStyle(style); 
        cell = row.createCell((short) 4);  
        cell.setCellValue("架");  
        cell.setCellStyle(style); 
        cell = row.createCell((short) 5);  
        cell.setCellValue("位");  
        cell.setCellStyle(style);  
        
        for(int i = 0 ; i < Depotlist.size() ;i++){
        	row = sheet.createRow((int)i+1);
        	DepotExcelPO po =(DepotExcelPO) Depotlist.get(i);
        	// 第四步，创建单元格，并设置值 
        	row.createCell((short)0).setCellValue(po.getCode());
           	row.createCell((short)1).setCellValue(po.getDate());
           	row.createCell((short)2).setCellValue(po.getQu());
           	row.createCell((short)3).setCellValue(po.getPai());
           	row.createCell((short)4).setCellValue(po.getJia());
           	row.createCell((short)5).setCellValue(po.getWei());
        }
        
        try{
        	FileOutputStream fout = new FileOutputStream(address);  
        	wb.write(fout);  
        	fout.close();  
        }catch(Exception e){
        	e.printStackTrace();
        }
	}
}
