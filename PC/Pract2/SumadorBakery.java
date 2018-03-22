import java.util.concurrent.atomic.AtomicInteger;


public class SumadorBakery extends Thread {

	private int id;
	private int sum;
	private static int turn[] = new int[Main1.N * 2];
	public static AtomicInteger number = new  AtomicInteger(1);
	public static int next = 1;
	private Tupla t;
	
	private class Tupla{
		private int el1;
		private int el2;
		
		public Tupla(int a,int b){
			el1 = a;
			el2 = b;
		}
		
		public boolean greaterThan(Tupla t){
			if(el1 > t.el1 || el1 == t.el1 && el2 > t.el2)
				return true;
			return false;
		}
	}
	
	public SumadorBakery(int i){
		id = i;
		if(id%2 == 0){
			sum = 1;
		}
		else sum = -1;
	}
	
	@Override
	public void run(){
		turn[id] = 1; turn[id]= number.addAndGet(1);
		t = new Tupla(turn[id],id);
		for(int j = 0; j < Main1.N*2; j++){
			Tupla t2 = new Tupla(turn[j],j);
			while(turn[j] != 0 && t.greaterThan(t2));
		}
		Main1.var += sum;
		turn[id] = 0;
	}
	
}
