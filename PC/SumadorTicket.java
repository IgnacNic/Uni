import java.util.concurrent.atomic.AtomicInteger;


public class SumadorTicket extends Thread {

	private int id;
	private int sum;
	private int turn;
	public static AtomicInteger number = new  AtomicInteger(1);
	public static int next = 1;
	
	public SumadorTicket(int i){
		id = i;
		if(id%2 == 0){
			sum = 1;
		}
		else sum = -1;
	}
	
	@Override
	public void run(){
		turn = number.getAndAdd(1);
		while(turn != next);
		Main1.var+=sum;
		next++;
	}
	
}
