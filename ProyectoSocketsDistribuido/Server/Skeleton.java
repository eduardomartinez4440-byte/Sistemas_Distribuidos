package server;

import java.io.*;
import java.net.*;

public class Skeleton {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6000);
        System.out.println("Skeleton en espera...");

        OperacionesImpl obj = new OperacionesImpl();

        while (true) {
            Socket socket = serverSocket.accept();
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

            String mensaje = entrada.readLine();
            String[] partes = mensaje.split(" ");
            String operacion = partes[0];
            int a = Integer.parseInt(partes[1]);
            int b = Integer.parseInt(partes[2]);
            int resultado = 0;

            if (operacion.equals("SUMA")) resultado = obj.sumar(a, b);
            else if (operacion.equals("RESTA")) resultado = obj.restar(a, b);

            salida.println("Resultado: " + resultado);
            socket.close();
        }
    }
}
