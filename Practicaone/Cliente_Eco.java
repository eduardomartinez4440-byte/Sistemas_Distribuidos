import java.io.*;
import java.net.*;

public class Cliente_Eco {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Uso: java Cliente_Eco <IP_servidor> <puerto>");
            return;
        }

        String ipServidor = args[0];
        int puerto = Integer.parseInt(args[1]);

        try (Socket socket = new Socket(ipServidor, puerto);
             BufferedReader entradaServidor = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter salidaServidor = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Conectado al servidor " + ipServidor + " en el puerto " + puerto);

            // Pedir mensaje al usuario
            System.out.print("Escribe un mensaje: ");
            String mensaje = teclado.readLine();

            // Enviar mensaje al servidor
            salidaServidor.println(mensaje);

            // Leer respuesta del servidor
            String respuesta = entradaServidor.readLine();
            System.out.println("Servidor responde: " + respuesta);

        } catch (IOException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }
}
