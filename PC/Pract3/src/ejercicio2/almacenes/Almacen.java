package ejercicio2.almacenes;

public interface Almacen<T> {

	/**
	* Almacena (como ultimo) un producto en el almacen. Si no hay
	* hueco el proceso que ejecute el metodo bloqueara hasta que lo
	* haya.
	*/
	public void almacenar(T producto);
	
	/**
	* Extrae el primer producto disponible. Si no hay productos el
	* proceso que ejecute el metodo bloqueara hasta que se almacene un
	* dato.
	*/
	public T extraer();
}
