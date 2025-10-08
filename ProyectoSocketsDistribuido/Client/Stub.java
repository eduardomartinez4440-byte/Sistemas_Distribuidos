package client;

import java.io.*;
import java.net.*;

public class Stub {
    private String host;
    private int puerto;

    public Stub(String host, int puerto) {
        this.host = host;
        this.puerto = puerto;
    }

    public String enviarOperacion(String op, int a, int b) {
        try (Socket socket = new Socket(host, puerto);
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            salida.println(op + " " + a + " " + b);
            return entrada.readLine();

        } catch (IOException e) {
            return "Error: " + e.getMessage();
        }
    }
}
