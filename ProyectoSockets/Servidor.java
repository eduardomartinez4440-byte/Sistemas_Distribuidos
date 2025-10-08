import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Servidor iniciado. Esperando conexiones...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado desde " + socket.getInetAddress());

                BufferedReader entrada = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

                // Leer la operación del cliente
                String mensaje = entrada.readLine();
                System.out.println("Petición recibida: " + mensaje);

                // Separar la operación y los operandos
                String[] partes = mensaje.split(" ");
                String operacion = partes[0].toUpperCase();
                int a = Integer.parseInt(partes[1]);
                int b = Integer.parseInt(partes[2]);
                int resultado = 0;

                // Ejecutar la operación
                switch (operacion) {
                    case "SUMA":
                        resultado = a + b;
                        break;
                    case "RESTA":
                        resultado = a - b;
                        break;
                    default:
                        salida.println("Operación no válida");
                        socket.close();
                        continue;
                }

                // Enviar el resultado al cliente
                salida.println("Resultado: " + resultado);
                System.out.println("Resultado enviado al cliente.");

                socket.close();
            }
        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}
