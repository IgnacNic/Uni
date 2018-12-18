package dijsktraMon;

public class Nodo <T>{

	private double val;
	private T key;
	
	public Nodo(T key,double val) {
		this.key = key;
		this.val = val;
	}
	
	public void setVal(double val) {
		this.val = val;
	}
	
	public double getVal() {
		return this.val;
	}
	
	public T getKey() {
		return this.key;
	}
	
	public void decreaseVal(int newVal) {
		this.val = newVal;
	}
}
