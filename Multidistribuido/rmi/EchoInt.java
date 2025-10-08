package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EchoInt extends Remote {
    public String echo(String msg) throws RemoteException;
}
