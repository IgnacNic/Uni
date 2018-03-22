package ejercicio2;

import ejercicio2.almacenes.Almacen;

public class Consumidor<Producto> extends Thread {

	private Almacen<Producto> almacen;
	private int productos;
	
	public Consumidor(Almacen<Producto> almacen, int productos){
		this.almacen = almacen;
		this.productos = productos;
	}
	
	@Override
	public void run(){
		Producto aux;
		for(int i = 0; i < this.productos; i++){
			aux = this.almacen.extraer();
			System.out.println("Se ha extraido: "+ aux);
		}
	}
}
