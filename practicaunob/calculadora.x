/*
 * Archivo: calculadora.x
 * Descripción: Definición de la interfaz RPC para un servicio de calculadora
 */

struct operandos {
    int a;
    int b;
};

program CALCULADORA_PROG {
    version CALCULADORA_VERS {
        int SUMA(operandos) = 1;
        int RESTA(operandos) = 2;
        int MULTIPLICA(operandos) = 3;
        double DIVIDE(operandos) = 4;
    } = 1;
} = 0x31234567;
