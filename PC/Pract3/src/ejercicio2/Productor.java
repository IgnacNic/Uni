package ejercicio2;

import ejercicio2.almacenes.Almacen;

public class Productor<Producto> extends Thread {

	private Almacen<Producto> almacen;
	private Producto lista[];
	private int productos;
	
	public Productor(Almacen<Producto> almacen,int prods, Producto lista[]){
		this.almacen = almacen;
		this.productos = prods;
		this.lista = lista;
	}
	
	@Override
	public void run(){
		for(int i = 0; i < this.productos; i++){
			this.almacen.almacenar(lista[i]);
			System.out.println("Se ha almacenado: "+ lista[i]);
		}
	}
}
