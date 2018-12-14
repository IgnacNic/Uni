package monticulo;

public class Monticulo <T>{

	private Nodo<T> raiz;
	private Monticulo<T> hd;
	private Monticulo<T> hi;
	
	public Monticulo(Nodo<T> r){
		setRaiz(r);
	}

	public Monticulo<T> getHi() {
		return hi;
	}

	public void setHi(Monticulo<T> hi) {
		this.hi = hi;
	}

	public Monticulo<T> getHd() {
		return hd;
	}

	public void setHd(Monticulo<T> hd) {
		this.hd = hd;
	}

	public Nodo<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo<T> raiz) {
		this.raiz = raiz;
	}
}
