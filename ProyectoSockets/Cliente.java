import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            // Conectar al servidor en localhost, puerto 5000
            Socket socket = new Socket("localhost", 5000);

            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            Scanner sc = new Scanner(System.in);

            // Leer operación y datos
            System.out.print("Operación (SUMA o RESTA): ");
            String op = sc.next();
            System.out.print("Número 1: ");
            int a = sc.nextInt();
            System.out.print("Número 2: ");
            int b = sc.nextInt();

            // Enviar solicitud al servidor
            salida.println(op + " " + a + " " + b);

            // Leer y mostrar la respuesta
            String respuesta = entrada.readLine();
            System.out.println("Respuesta del servidor: " + respuesta);

            socket.close();
        } catch (IOException e) {
            System.out.println("Error en el cliente: " + e.getMessage());
        }
    }
}
