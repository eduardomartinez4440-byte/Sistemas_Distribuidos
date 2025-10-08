package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import rmi.EchoInt;

public class EchoObject extends UnicastRemoteObject implements EchoInt {

    public EchoObject() throws RemoteException {
        super();
    }

    @Override
    public String echo(String msg) throws RemoteException {
        return "Server: " + msg;
    }
}
