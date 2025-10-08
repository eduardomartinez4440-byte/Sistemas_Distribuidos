#include "calculadora.h"
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
    CLIENT *clnt;
    operandos ops;
    int *resultado_int;
    double *resultado_double;

    if (argc < 2) {
        printf("Uso: %s <host_servidor>\n", argv[0]);
        exit(1);
    }

    clnt = clnt_create(argv[1], CALCULADORA_PROG, CALCULADORA_VERS, "udp");
    if (clnt == NULL) {
        clnt_pcreateerror(argv[1]);
        exit(1);
    }

    printf("=== Cliente RPC Calculadora ===\n");
    printf("Introduce dos números: ");
    scanf("%d %d", &ops.a, &ops.b);

    resultado_int = suma_1(&ops, clnt);
    if (resultado_int == NULL)
        clnt_perror(clnt, "Fallo en SUMA");
    else
        printf("Suma: %d\n", *resultado_int);

    resultado_int = resta_1(&ops, clnt);
    if (resultado_int == NULL)
        clnt_perror(clnt, "Fallo en RESTA");
    else
        printf("Resta: %d\n", *resultado_int);

    resultado_int = multiplica_1(&ops, clnt);
    if (resultado_int == NULL)
        clnt_perror(clnt, "Fallo en MULTIPLICA");
    else
        printf("Multiplicación: %d\n", *resultado_int);

    resultado_double = divide_1(&ops, clnt);
    if (resultado_double == NULL)
        clnt_perror(clnt, "Fallo en DIVIDE");
    else
        printf("División: %.2f\n", *resultado_double);

    clnt_destroy(clnt);
    return 0;
}
