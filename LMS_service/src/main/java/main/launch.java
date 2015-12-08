package main;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmiService.account.accountFactoryImpl;
import rmiService.documents.documentsFactoryImpl;
import rmiService.finance.financeFactoryImpl;
import rmiService.organization.organizationFactoryImpl;
import rmiService.storage.storageFactoryImpl;
import rmiService.transportation.TransportationFactoryImpl;
import dataservice.accountdataservice.accountFactory;
import dataservice.documentsdataservice.documentsFactory;
import dataservice.financedataservice.financeFactory;
import dataservice.organizationdataservice.organizationFactory;
import dataservice.storagedataservice.storageFactory;
import dataservice.transportationdataservice.TransportationFactory;

public class launch {
	public static void main(String[] args){
		try{
			financeFactory finFactory = new financeFactoryImpl();
			//创建财务人员的工厂
			storageFactory stoFactory = new storageFactoryImpl();
			//创建中转中心仓库管理员的工厂
			accountFactory accFactory = new accountFactoryImpl();
			//创建管理员的工厂
			documentsFactory docFactory = new documentsFactoryImpl();
			//创建单据工厂
			organizationFactory orgFactory = new organizationFactoryImpl();
			//创建机构工厂
			TransportationFactory traFactory = new TransportationFactoryImpl();
			//创建常量工厂
			Registry registry =creatRegistry(6600);
			
			registry.rebind("finFactory", finFactory);
			System.out.println("服务器注册了finance工厂");
			//以上是finance接口rmi的通信
			registry.rebind("stoFactory", stoFactory);
			System.out.println("服务器注册了storage工厂");
			//以上是storage接口rmi的通信
			registry.rebind("accFactory", accFactory);
			System.out.println("服务器注册了accFactory工厂");
			//以上是account接口rmi的通信
			registry.rebind("docFactory", docFactory);
			System.out.println("服务器注册了docFactory工厂");
			//以上是documents接口rmi的通信
			registry.rebind("orgFactory", orgFactory);
			System.out.println("服务器注册了orgFactory工厂");
			//以上是organization接口rmi的通信
			registry.rebind("traFactory", traFactory);
			System.out.println("服务器注册了traFactory工厂");
			//以上是transportation接口rmi的通信
			
			System.out.println("Service Start");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	private static Registry creatRegistry(int port){
		Registry registry = null;
		
		try{
			registry = LocateRegistry.getRegistry(port);//如果该端口未被注册，则抛异常 
			registry.list();//拿到该端口注册的rmi对象 
		}catch (final Exception e){
			try{
				registry = LocateRegistry.createRegistry(port);
			}catch (final Exception ee){
				ee.printStackTrace();
			}
		}
		return registry;
	}
}