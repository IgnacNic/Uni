package grafo;

import java.util.ArrayList;
import monticulo.Nodo;

public class Vertice <T> {

	private T key;
	private ArrayList<Nodo<T>> adj;
	
	public Vertice(T key) {
		this.key = key;
		this.adj = new ArrayList<Nodo<T>>();
	}
	
	public void addAdj(T adj[], int d[], int n) {
		for(int i = 0; i < n; i++) {
			this.adj.add(new Nodo<T>(adj[i],d[i]));
		}
	}
	
	public T getKey() {
		return key;
	}
	
	public ArrayList<Nodo<T>> getAdj(){
		return adj;
	}
}
