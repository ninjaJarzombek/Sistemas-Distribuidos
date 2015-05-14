package com.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import com.interf.test.TestRemote;

/**
 * @author   Aurelio Canto Macías <aurelio.cantoms@udlap.mx>
 * @version  0.1
 * @since    2015-01-10
 */
public class TestClient {

	public static final String RMI_ID = "TestRMI";
	/**
	 * Define el puerto en donde se encuentra el servidor.
	 */
	public static final int RMI_PORT = 8080;

	/*
	El main por parte del cliente, en donde le va a pedir a la colase remote que ejecute
	diferentes metodos que viven en la definicion del servidor.
	 */

	public static void main(String[] args) throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry("localhost", RMI_PORT);
		TestRemote remote = (TestRemote) registry.lookup(RMI_ID);
		System.out.println(remote.test("123"));
		System.out.println(remote.test("test"));
		System.out.println(remote.multiply(2,2));
		System.out.println(remote.esPalindromo("anita lava la tina"));
	}

}
