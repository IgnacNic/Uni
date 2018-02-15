import java.util.ArrayList;
import java.util.Scanner;



public class Ejercicio1 {

	public static void main(String args[]) throws InterruptedException{
		int n, t;
		Scanner s = new Scanner(System.in);
		System.out.println("Introduce el numero de threads y el tiempo de espera en milisegundos:");
		n = s.nextInt();
		t = s.nextInt();
		ejercicio1(n, t);
		s.close();
	}

	private static void ejercicio1(int n, int t) throws InterruptedException {
		ArrayList<Thread> ts = new ArrayList<Thread>();
		for(int i = 0; i < n; i++){
			 Thread thread = new Thread(){
				public void run(){
					try {
						System.out.println(this.getId());
						sleep(t);
					} catch (InterruptedException e) {}
					System.out.println(this.getId());
				}
			};
			ts.add(thread);
			thread.start();
		}
		for(Thread tt:ts){
			tt.join();
		}
		
		System.out.println("FIN DE LA EJECUCION");
	}
}
