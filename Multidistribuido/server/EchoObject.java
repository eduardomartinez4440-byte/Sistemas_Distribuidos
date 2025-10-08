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
        try {
            // Simula un servicio que tarda 3 segundos
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Server (respuesta en hilo " + Thread.currentThread().getName() + "): " + msg;
    }
}
