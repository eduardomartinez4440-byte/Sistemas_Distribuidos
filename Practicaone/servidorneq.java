import java.io.*;
import java.net.*;

public class ServidorEntero {
    public static void main(String[] args) {
        int puerto = 5000; // Puerto del servidor

        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor escuchando en el puerto " + puerto);

            Socket socket = serverSocket.accept(); // Esperar cliente
            System.out.println("Cliente conectado: " + socket.getInetAddress());

            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

            int numero;
            do {
                numero = entrada.readInt(); // Leer entero del cliente
                System.out.println("Cliente envió: " + numero);

                if (numero != 0) {
                    int respuesta = numero + 1;
                    salida.writeInt(respuesta); // Enviar respuesta
                }

            } while (numero != 0);

            System.out.println("Fin de la comunicación.");
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

