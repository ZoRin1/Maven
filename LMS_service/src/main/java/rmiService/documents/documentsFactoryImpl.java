package rmiService.documents;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.documentsdataservice.GetDocCodeDataSer;
import dataservice.documentsdataservice.NotApproved;
import dataservice.documentsdataservice.addDocummentInfoDataSer;
import dataservice.documentsdataservice.deleteDataSer;
import dataservice.documentsdataservice.documentsFactory;
import dataservice.documentsdataservice.getBufferedCodeDataSer;
import dataservice.documentsdataservice.getBufferedInfoDataSer;
import dataservice.documentsdataservice.getCodeDataSer;
import dataservice.documentsdataservice.getDocumentInfoDataSer;
import dataservice.documentsdataservice.getNotPassDocCode;
import dataservice.documentsdataservice.getWuliuInfoDataSer;

public class documentsFactoryImpl extends UnicastRemoteObject implements documentsFactory{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2425119006902233918L;

	public documentsFactoryImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	@Override
	public addDocummentInfoDataSer createaddDocummentInfoDataSer()
			throws RemoteException {
		// TODO 自动生成的方法存根
		return addDocummentInfoDataSerImpl.getInstance();
	}

	@Override
	public deleteDataSer createDeleteDataSer() throws RemoteException {
		// TODO 自动生成的方法存根
		return deleteDataSerImpl.getInstance();
	}

	@Override
	public getBufferedCodeDataSer createGetBudderedCodeDataSer()
			throws RemoteException {
		// TODO 自动生成的方法存根
		return getBufferedCodeDataSerImpl.getInstance();
	}

	@Override
	public getBufferedInfoDataSer createGetBufferedInfoDataSer()
			throws RemoteException {
		// TODO 自动生成的方法存根
		return getBufferedInfoDataSerImpl.getInstance();
	}

	@Override
	public getCodeDataSer createGetCodeDataSer() throws RemoteException {
		// TODO 自动生成的方法存根
		return getCodeDataSerImpl.getInstance();
	}

	@Override
	public getDocumentInfoDataSer createGetDocumentInfoDataSer()
			throws RemoteException {
		// TODO 自动生成的方法存根
		return getDocumentInfoDataSerImpl.getInstance();
	}

	@Override
	public getNotPassDocCode createGetNotPassDocCode() throws RemoteException {
		// TODO 自动生成的方法存根
		return getNotPassDocCodeImpl.getInstance();
	}

	@Override
	public NotApproved createNotApproved() throws RemoteException {
		// TODO 自动生成的方法存根
		return NotApprovedImpl.getInstance();
	}

	@Override
	public GetDocCodeDataSer createGetDocCodeDataSer() throws RemoteException {
		// TODO Auto-generated method stub
		return GetDocCodeDataSerImpl.getInstance();
	}

	@Override
	public getWuliuInfoDataSer createGetWuliuInfoDataSer()
			throws RemoteException {
		// TODO Auto-generated method stub
		return getWuliuInfoDataSerImpl.getInstance();
	}



}