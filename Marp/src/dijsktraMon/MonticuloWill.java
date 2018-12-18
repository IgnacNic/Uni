package dijsktraMon;

import java.util.ArrayList;

public class MonticuloWill{

	private ArrayList<Nodo<Integer>> lista;
	private int k;

	public MonticuloWill(){
		lista = new ArrayList<Nodo<Integer>>();
		lista.add(null);
		k = 0;
	}

	public int getNodo(Integer clave) {
		int i = 1;
		while(i <= k) {
			if(lista.get(i).getKey() == clave)
				return i;
			i++;
		}
		return -1;
	}

	public void decrecerClave(double val, Integer key) {
		int i = getNodo(key);
		lista.get(i).setVal(val);
		flotar(i);
	}

	public void flotar(int i) {
		if(i > 1 && k >= i) {
			int p = i / 2;
			Nodo<Integer> aux = lista.get(p);
			if(lista.get(i).getVal() < aux.getVal()) {
				lista.set(p,lista.get(i));
				lista.set(i, aux);
				flotar(p);
			}
		}
	}

	public void hundir(int i) {
		Nodo<Integer> hi,hd;
		if(k >= i*2 && i > 0) { hi = lista.get(i*2);
		if(k > i*2) hd = lista.get(i*2+1);
		else hd =new Nodo<Integer>(null, Double.POSITIVE_INFINITY);
		if(hi.getVal() <= hd.getVal()) {
			lista.set(i*2, lista.get(i));
			lista.set(i, hi);
			hundir(i*2);
		}
		else {
			lista.set(i*2+1, lista.get(i));
			lista.set(i, hd);
			hundir(i*2+1);
		}
		}
	}

	public boolean vacia() {
		return k == 0;
	}

	public Nodo<Integer> min() {
		if(k == 0)return null;
		return lista.get(1);
	}

	public void insertar(Nodo<Integer> nodo) {
		lista.add(nodo);
		k++;
		flotar(k);
	}

	public Nodo<Integer> elim(Integer clave){
		int i = getNodo(clave);
		if(i >0) {
			Nodo<Integer> ret = lista.get(i);
			k--;
			if(k > 0) {
				lista.set(i, lista.get(k+1));
			}
			lista.remove(k+1);
			return ret;
		}
		return null;
	}

	public Nodo<Integer> elimMin(){
		if(k == 0)return null;
		k --;
		Nodo<Integer> ret = lista.get(1);
		if(k > 0) {
			lista.set(1, lista.get(k+1));
			lista.remove(k+1);
			hundir(1);
		}
		return ret;
	}

	public String toString() {
		String ret;
		ret = new String();
		ret += k + '\n';
		int i = 1;
		while(i < k){
			for(int j = 0; j <= Math.pow(2,Math.log(i)/Math.log(2));j++) {
				if(i < k)
					ret += lista.get(i).getKey() + ", "
							+lista.get(i++).getVal() + "   ";
			}
			ret += '\n';
		}
		return ret;
	}

}
