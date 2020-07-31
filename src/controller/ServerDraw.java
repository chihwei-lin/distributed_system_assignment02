package controller;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import model.remote.IRemoteDraw;
import model.server.RemoteDraw;
import view.DrawPanel;

public class ServerDraw {
	
	public ServerDraw(DrawPanel dpanel)
	{
		IRemoteDraw remoteDraw;
		Registry registry;
		try 
		{
			
			remoteDraw = new RemoteDraw(dpanel);
			registry = LocateRegistry.getRegistry();
			registry.bind("DrawMethod", remoteDraw);


//			LocateRegistry.createRegistry(port);
//			Naming.rebind(rmiIpAddr, remoteDraw);
			
		} catch (AccessException e) {
			State.ErrorLog(e.getMessage());
			State.ErrorLog(e.getStackTrace().toString());
		} catch (RemoteException e) {
			State.ErrorLog(e.getMessage());
			State.ErrorLog(e.getStackTrace().toString());
		} catch (AlreadyBoundException e) {
			State.ErrorLog(e.getMessage());
			State.ErrorLog(e.getStackTrace().toString());
		}
	    
	    State.Log("Draw server ready");
	}
}
