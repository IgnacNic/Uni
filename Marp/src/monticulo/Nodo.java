package monticulo;

public class Nodo <T>{

	private int val;
	private T key;
	
	public Nodo(T key,int val) {
		this.key = key;
		this.val = val;
	}
	
	public int getVal() {
		return this.val;
	}
	
	public T getKey() {
		return this.key;
	}
	
	public void decreaseVal(int newVal) {
		this.val = newVal;
	}
}
