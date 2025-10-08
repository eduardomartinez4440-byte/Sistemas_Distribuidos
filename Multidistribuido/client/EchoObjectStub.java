package client;

import java.rmi.Naming;
import rmi.EchoInt;

public class EchoObjectStub {
    private EchoInt eo;

    public EchoObjectStub() {
        try {
            // Conecta con el objeto remoto registrado como EchoService
            eo = (EchoInt) Naming.lookup("rmi://localhost/EchoService");
        } catch (Exception e) {
            System.out.println("Error al conectar con el servidor: " + e);
        }
    }

    public String echo(String msg) {
        try {
            return eo.echo(msg);
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
