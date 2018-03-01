
public class Sumador extends Thread {

	private int id;
	private int sum;
	private int n;
	
	public Sumador(int i,int n){
		id = i;
		this.n = n;
		if(id%2 == 0){
			sum = 1;
		}
		else sum = -1;
	}
	
	@Override
	public void run(){
		for(int j = 0; j < n; j++){
			Main1.in[(int) this.getId() - 11] = j;
			Main1.last[j] = id;
			for(int k = 0; k < n; k++)
				if(k != this.getId() - 11){
					while(Main1.in[k] >= Main1.in[id] && Main1.last[j] == id);
				}
		}
		Main1.var+=sum;
		Main1.in[id] = -1;
	}
	
}
