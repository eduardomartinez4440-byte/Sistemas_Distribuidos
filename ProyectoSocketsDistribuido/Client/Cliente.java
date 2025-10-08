package client;

import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Stub stub = new Stub("localhost", 6000);
        Scanner sc = new Scanner(System.in);

        System.out.print("Operación (SUMA/RESTA): ");
        String op = sc.next();
        System.out.print("Número 1: ");
        int a = sc.nextInt();
        System.out.print("Número 2: ");
        int b = sc.nextInt();

        String respuesta = stub.enviarOperacion(op, a, b);
        System.out.println(respuesta);
    }
}
