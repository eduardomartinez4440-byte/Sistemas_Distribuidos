package server;

import common.Operaciones;

public class OperacionesImpl implements Operaciones {
    public int sumar(int a, int b) {
        return a + b;
    }

    public int restar(int a, int b) {
        return a - b;
    }
}
