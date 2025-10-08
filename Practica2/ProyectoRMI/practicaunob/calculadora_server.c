#include "calculadora.h"
#include <stdio.h>
#include <stdlib.h>

/* Implementación del servicio SUMA */
int *suma_1_svc(operandos *ops, struct svc_req *rqstp) {
    static int resultado;
    resultado = ops->a + ops->b;
    printf("Servidor: SUMA(%d, %d) = %d\n", ops->a, ops->b, resultado);
    return &resultado;
}

/* Implementación del servicio RESTA */
int *resta_1_svc(operandos *ops, struct svc_req *rqstp) {
    static int resultado;
    resultado = ops->a - ops->b;
    printf("Servidor: RESTA(%d, %d) = %d\n", ops->a, ops->b, resultado);
    return &resultado;
}

/* Implementación del servicio MULTIPLICA */
int *multiplica_1_svc(operandos *ops, struct svc_req *rqstp) {
    static int resultado;
    resultado = ops->a * ops->b;
    printf("Servidor: MULTIPLICA(%d, %d) = %d\n", ops->a, ops->b, resultado);
    return &resultado;
}

/* Implementación del servicio DIVIDE */
double *divide_1_svc(operandos *ops, struct svc_req *rqstp) {
    static double resultado;
    if (ops->b == 0) {
        printf("Servidor: DIVIDE(%d, %d) -> ERROR: división entre cero\n", ops->a, ops->b);
        resultado = 0.0;
    } else {
        resultado = (double) ops->a / (double) ops->b;
        printf("Servidor: DIVIDE(%d, %d) = %.2f\n", ops->a, ops->b, resultado);
    }
    return &resultado;
}
