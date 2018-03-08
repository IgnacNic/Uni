import java.util.ArrayList;
import java.util.Scanner;


public class Main1 {
	public static int[] in;
	public static int[] last;
	public static boolean lock;
	public static int var;
	public static int m;
	public static final int N = 2000;
	
	public static void main(String args[]) throws InterruptedException{
		//int n;
		Scanner s = new Scanner(System.in);
		//System.out.println("Introduce el numero de operaciones:");
		//n = s.nextInt();
		var = 0;
		m = 4;
		//ejercicio2TieBreaker(6);
		//ejercicio2Ticket(N);
		ejercicio2Bakery(N);
		System.out.println("El valor final de la variable n es: " + var);
		if(var != 0)
			System.out.println("Ha habido carrera de datos!");
		s.close();
	}

	private static void ejercicio2Ticket(int n) throws InterruptedException {
		ArrayList<Thread> ts = new ArrayList<Thread>();
		ArrayList<Thread> tr = new ArrayList<Thread>();
		for(int i = 0 ; i < 2*n; i+=2){
			SumadorTicket p1 = new SumadorTicket(i);
			SumadorTicket p2 = new SumadorTicket(i+1);
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
	
	
	private static void ejercicio2Bakery(int n) throws InterruptedException {
		ArrayList<Thread> ts = new ArrayList<Thread>();
		ArrayList<Thread> tr = new ArrayList<Thread>();
		for(int i = 0 ; i < 2*n; i+=2){
			SumadorBakery p1 = new SumadorBakery(i);
			SumadorBakery p2 = new SumadorBakery(i+1);
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

	private static void ejercicio2TieBreaker(int n) throws InterruptedException {
		ArrayList<Thread> ts = new ArrayList<Thread>();
		ArrayList<Thread> tr = new ArrayList<Thread>();
		lock = false;
		in = new int[2*n];
		last = new int[2*n];
		for(int i = 0; i < 2*n; i++){
			in[i] = 0;
			last[i] = -1;
		}
		
		for(int i = 0 ; i < 2*n; i+=2){
			SumadorTieBreaker p1 = new SumadorTieBreaker(i,n*2);
			SumadorTieBreaker p2 = new SumadorTieBreaker(i+1,n*2);
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
