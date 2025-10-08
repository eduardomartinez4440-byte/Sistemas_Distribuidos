package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class EchoMultiServer {

    public static void main(String[] args) {
        try {
            // Crea el registro RMI (si no existe)
            LocateRegistry.createRegistry(1099);

            // Crea el objeto remoto compartido
            EchoObject obj = new EchoObject();

            // Registra el objeto remoto en el registro RMI
            Naming.rebind("EchoService", obj);

            System.out.println("Servidor multihilo listo y esperando clientes...");

        } catch (Exception e) {
            System.out.println("Error en el servidor: " + e);
        }
    }
}
