package presentation.mainui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ipConfig {
	
	private String ip;
	
	public String getIP(){
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("rmi_ip")));
			ip = reader.readLine();
			reader.close();
			System.out.println(ip);
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ip;
	}
	
//	public static void main(String[] args){
//		ipConfig i = new ipConfig();
//		System.out.println(	i.getIP());
//	}
}
