package ejercicio2.almacenes;

import java.util.concurrent.Semaphore;

public class AlmacenUnitario<T> implements Almacen<T> {

	private T producto;
	private Semaphore semLleno;
	private Semaphore semVacio;
	
	public AlmacenUnitario(){
		this.semLleno = new Semaphore(0);
		this.semVacio = new Semaphore(1);
	}
	
	@Override
	public void almacenar(T producto) {
		try {
			semVacio.acquire();
			this.producto = producto;
			semLleno.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public T extraer() {
		T aux;
		try {
			semLleno.acquire();
			aux = producto;
			semVacio.release();
			return aux;
		} catch (InterruptedException e) {
			return null;
		}
	}

}
