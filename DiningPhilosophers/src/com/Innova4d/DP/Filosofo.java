package com.Innova4d.DP;
import java.util.Random;
import java.util.concurrent.locks.Lock;
/**
 * La clase Filosofo que utiliza Runnable para poder ser implementada por un thread.
 * @author Francisco Gutiérrez <fsalvador23@gmail.com>
 * @version 1.0
 */
class Filosofo implements Runnable {
	// Tiempo en que come un filósofo
	private Random numGenerator = new Random();
	// El Id del filosofo
	private int id;

	/* 
	 * Definir los cubiertos del filosofo.
	 * En Java los recursos compartidos se definen como Locks.
	 */
	private Lock cubiertoIzquierdo;
	private Lock cubiertoDerecho;

	/**
	 * El constructor del filósofto
	 * @param id el id del filósofo
	 * @param cubiertoIzquierdo cubierto izquierdo
	 * @param cubiertoDerecho cubierto derecho
	 */
	public Filosofo (int id, Lock cubiertoIzquierdo, Lock cubiertoDerecho) {
		this.id = id;
		this.cubiertoIzquierdo = cubiertoIzquierdo;
		this.cubiertoDerecho = cubiertoDerecho;
	}

	/**
	 * Ejecuta el thread, piensa, levanta cubiertos, come.
	 */
	public void run() {
		try {
			while (true) {
				piensa();
				levantaCubiertoIzquierdo();
				levantaCubiertoDerecho();
				come();
				bajaCubiertos();
			}
		} catch (InterruptedException e) {
			System.out.println("El Filósofo " + id + " fue interrumpido.\n");			
		}
	}


	private void piensa() throws InterruptedException {
        System.out.println("El Filósofo " + id + " está pensando.\n");
    }

	private void levantaCubiertoIzquierdo() {
		cubiertoIzquierdo.lock();
		System.out.println("El filósofo " + id + " tiene en la mano un cubierto.\n");
	}


	private void levantaCubiertoDerecho() {
		cubiertoDerecho.lock();
		System.out.println("El folósofo " + id + " tiene en la mano un cubierto.\n");

	}


	private void come() throws InterruptedException {
		System.out.println("El filósofo " + id + " está comiendo.\n");
		Thread.sleep (numGenerator.nextInt(10));
	}


	private void bajaCubiertos() {

		cubiertoDerecho.unlock();
        cubiertoIzquierdo.unlock();


	}
}