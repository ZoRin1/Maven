package rmiService.transportation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.transportationdataservice.TransportationDataSer;
import dataservice.transportationdataservice.TransportationFactory;

public class TransportationFactoryImpl extends UnicastRemoteObject implements TransportationFactory{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2352423704610340540L;

	public TransportationFactoryImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	@Override
	public TransportationDataSer createTransportationDataSer()
			throws RemoteException {
		// TODO 自动生成的方法存根
		return new TransportationDataSerImpl();
	}

}
