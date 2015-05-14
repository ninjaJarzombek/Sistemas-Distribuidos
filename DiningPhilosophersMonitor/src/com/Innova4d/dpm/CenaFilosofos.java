package com.Innova4d.dpm;

/**
 * Esta versión no causa Dealock.
 * Un filósofo podría morir de hambre.
 * 
 * @author Aurelio Canto 146562
 * @version v1.0
 *
 */
public class CenaFilosofos {

	private static final int num_filosofos = 5;
	
	public static void main (String[] args) {
		Filosofo[] filosofos = new Filosofo[num_filosofos];

        Monitor monitor;
		monitor = new Monitor(num_filosofos);
		for (int i = 0; i < num_filosofos; i++) {
			filosofos[i] = new Filosofo(i, monitor);
			new Thread(filosofos[i]).start();
		}
	}
}