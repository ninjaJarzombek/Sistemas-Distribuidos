package com.Innova4d.DP;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * El problema de los filósofos (Esta versión causa un Deadlock).
 * @author Francisco Gutiérrez <fsalvador23@gmail.com>
 * @version 1.0
 */
public class CenaFilosofos {
	// El número de filósofos...
	private static final int NUM_FILOSOFOS = 1;
	

	public static void main (String[] args) {


        ReentrantLock[] tenedores;

        tenedores = new ReentrantLock[NUM_FILOSOFOS];
		for (int i = 0; i < NUM_FILOSOFOS; i++) {
			tenedores[i] = new ReentrantLock();
		}

        for (int i = 0; i < NUM_FILOSOFOS; i++){

            Filosofo filosofo = new Filosofo(i, tenedores[i], tenedores[(i+1)%NUM_FILOSOFOS]);
            new Thread(filosofo).start();

        }



	}

}