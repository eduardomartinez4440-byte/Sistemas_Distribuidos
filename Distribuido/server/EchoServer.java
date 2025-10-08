package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class EchoServer {
    public static void main(String[] args) {
        try {
            // Inicia el registro RMI en el puerto 1099
            LocateRegistry.createRegistry(1099);
            // Crea e instancia el objeto remoto
            EchoObject obj = new EchoObject();
            // Lo registra con el nombre "EchoService"
            Naming.rebind("EchoService", obj);
            System.out.println("Servidor listo y registrado como EchoService...");
        } catch (Exception e) {
            System.out.println("Error en el servidor: " + e);
        }
    }
}
