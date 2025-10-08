package client;

import java.util.Scanner;

public class Echo {
    private static EchoObjectStub ss;

    public static void main(String[] args) {
        ss = new EchoObjectStub(); // a) Generar instancia del stub
        Scanner sc = new Scanner(System.in);
        String msg;

        while (true) { // b) Bucle infinito
            System.out.print("Cliente: "); 
            msg = sc.nextLine(); // c) Leer del teclado
            String respuesta = ss.echo(msg); // d) Invocar stub
            System.out.println(respuesta); // e) Imprimir respuesta
        }
    }
}
