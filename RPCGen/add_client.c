/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "add.h"


void
add_prog_1(char *host, int funcion, char *nombre)
{
	CLIENT *clnt;
	char * *result_1;
	char * add_1_arg;
	char * *result_2;
	char * search_1_arg;

#ifndef	DEBUG
	clnt = clnt_create (host, ADD_PROG, ADD_VERS, "udp");
	if (clnt == NULL) {
		clnt_pcreateerror (host);
		exit (1);
	}
#endif	/* DEBUG */

	char *nombreR=nombre;
	if (funcion == 1){

		result_1 = add_1(&nombreR, clnt);
	}
	if (funcion == 2){
		
		result_2 = search_1(&nombreR, clnt);
		printf("Encontrado: %s", *result_2);

	}
	
#ifndef	DEBUG
	clnt_destroy (clnt);
#endif	 /* DEBUG */
}


int
main (int argc, char *argv[])
{
	char *host;
	char *nombre;
	int funcion;


	if (argc < 2) {
		printf ("usage: %s server_host\n", argv[0]);
		exit (1);
	}
	host = argv[1];
	funcion = atoi(argv[2]);
	nombre = argv[3];
	
	add_prog_1 (host, funcion, nombre);
exit (0);
}
