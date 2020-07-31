package model.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

import controller.Tool;

public interface IRemoteDraw extends Remote {

    public void Draw(Tool tool, Boolean complete,Boolean broadCast) throws RemoteException;
}
