import java.util.ArrayList;
import java.util.Scanner;


public class Ejercicio2 {

	public static int var;
	public static int m;
	public static void main(String args[]) throws InterruptedException{
		//int n;
		Scanner s = new Scanner(System.in);
		//System.out.println("Introduce el numero de operaciones:");
		//n = s.nextInt();
		var = 0;
		m = 4;
		ejercicio2(500);
		System.out.println("El valor final de la variable n es: " + var);
		if(var != 0)
			System.out.println("Ha habido carrera de datos!");
		s.close();
	}

	private static void ejercicio2(int n) throws InterruptedException {
		ArrayList<Thread> ts = new ArrayList<Thread>();
		ArrayList<Thread> tr = new ArrayList<Thread>();
		for(int i = 0; i < n; i++){
			Thread sum = new Thread(){
				public void run(){
					for(int j = 0; j < m ; j++){
						var++;
					}
				}
			};	
			Thread res = new Thread(){
				public void run(){
					for(int j = 0; j < m ; j++){
						var--;
					}
				}
			};
			ts.add(sum);
			tr.add(res);
			sum.start();
			res.start();
		}
		for(int i = 0; i < n; i++){
			ts.get(i).join();
			tr.get(i).join();
		}
	}
	
}
