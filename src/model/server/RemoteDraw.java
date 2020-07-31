package model.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import controller.Tool;
import model.remote.IRemoteDraw;
import view.DrawPanel;

public class RemoteDraw extends UnicastRemoteObject implements IRemoteDraw {


	DrawPanel dpanel;
	
	private static final long serialVersionUID = 1L;

	public RemoteDraw(DrawPanel dpanel) throws RemoteException {
		this.dpanel = dpanel;
	}


	@Override
	public void Draw(Tool tool, Boolean complete, Boolean broadCast) throws RemoteException {
		dpanel.Draw(tool, complete,broadCast);
	}
	
	
}

