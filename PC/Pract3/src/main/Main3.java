package main;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import ejercicio1.SumadorSem;
import ejercicio2.Consumidor;
import ejercicio2.Productor;
import ejercicio2.almacenes.AlmacenUnitario;


public class Main3 {
	public static int[] in;
	public static int[] last;
	public static boolean lock;
	public static int var;
	public static int m;
	public static final int N = 2000;
	
	public static void main(String args[]) throws InterruptedException{
		var = 0;
		m = 4;
		ejercicio1(20);
		System.out.println("El valor final de la variable n es: " + var);
		if(var != 0)
			System.out.println("Ha habido carrera de datos!");
		ejercicio2();
	}
	
	private static void ejercicio2() throws InterruptedException {
		Integer lista[] = new Integer[6];
		for(int i = 0; i < 6; i++)lista[i] = i;
		AlmacenUnitario<Integer> almacen = new AlmacenUnitario<Integer>();
		Consumidor<Integer> consumidor = new Consumidor<Integer>(almacen, 6);
		Productor<Integer> productor = new Productor<Integer>(almacen,6,lista);
		consumidor.start();
		productor.start();
		consumidor.join();
		productor.join();
		
	}

	private static void ejercicio1(int n) throws InterruptedException {
		ArrayList<Thread> ts = new ArrayList<Thread>();
		ArrayList<Thread> tr = new ArrayList<Thread>();
		Semaphore sem = new Semaphore(1);
		lock = false;
		in = new int[2*n];
		last = new int[2*n];
		for(int i = 0; i < 2*n; i++){
			in[i] = 0;
			last[i] = -1;
		}
		
		for(int i = 0 ; i < 2*n; i+=2){
			SumadorSem p1 = new SumadorSem(i,sem);
			SumadorSem p2 = new SumadorSem(i+1,sem);
			p1.start();
			p2.start();
			ts.add(p1);
			tr.add(p2);
		}
		for(int i = 0 ; i < n ; i++){
			tr.get(i).join();
			ts.get(i).join();
		}
	}
	
}
