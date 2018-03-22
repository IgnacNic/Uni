package ejercicio1;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

import main.Main3;


public class SumadorSem extends Thread {

	Semaphore sem;
	private int id;
	private int sum;
	public static AtomicInteger number = new  AtomicInteger(1);
	public static int next = 1;
	
	public SumadorSem(int i, Semaphore sem){
		id = i;
		this.sem = sem;
		if(id%2 == 0){
			sum = 1;
		}
		else sum = -1;
	}

	@Override
	public void run(){
		try {
			sem.acquire();
			Main3.var+=sum;
			sem.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
