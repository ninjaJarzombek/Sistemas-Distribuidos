package com.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.interf.test.TestRemote;

/**
 * @author   Aurelio Canto Macías <aurelio.cantoms@udlap.mx>
 * @version  0.1
 * @since    2015-01-10
 */

/*
 *Clase del servidor en donde se define las funciones que puede realizar, implementa la interface "TestRemote"
 */
public class ServerDefinition extends UnicastRemoteObject implements TestRemote {

	/**
	 * Identificador único de la serialización (Default).
	 */
	private static final long serialVersionUID = 1L;

	protected ServerDefinition() throws RemoteException {
		super();
	}

	@Override
	public Boolean test(String test) throws RemoteException {
		if(test.equalsIgnoreCase("test")) return true;
		return false;
	}

	@Override
	/*
	Metodo que recibe dos enteros y se encarga de hacer su multiplicacion
	 */
	public Integer multiply(int primernum, int segundonum) throws RemoteException {
		 int resultado;

		resultado = primernum*segundonum;


		return resultado;
	}

	@Override
	/*
	Metodo que recibe una cadena de texto y verfica si es un palindromo
	 */
	public Boolean esPalindromo(String word) throws RemoteException {

		word = word.replaceAll(" ","");
		int n = word.length();
		for (int i = 0; i<(n/2) + 1; ++i){
			if(word.charAt(i) != word.charAt(n - i -1)){
				return false;
			}

		}

		return true;
	}

}
