package dijsktraList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	private static int nodos;
	
	public static void main(String args[]) throws IOException {
		int caminos[];
		double distancias[];
		double[] grafo[];
		grafo = parser("2.txt");
		caminos = new int[nodos];
		distancias = new double[nodos];
		dijstra(grafo,caminos,distancias,nodos);
		System.out.println("v   P[v]   D[v]\n");
		for(int i = 0; i < nodos; i++) {
			System.out.println(i + "   " + caminos[i] + "   " + distancias[i] + '\n');
		}
	}
	
	private static double [][] parser(String file) throws IOException{
		String cadena;
		FileReader f = new FileReader(file);
		BufferedReader b = new BufferedReader(f);
		int nodos = Integer.parseInt(b.readLine());
		double [] ret[];
		ret = new double[nodos][nodos];
		int j = 0;
		while((cadena = b.readLine())!=null &&
				j < nodos) {
			String[] splited = cadena.split(" ");
			for(int i = 0; i < nodos; i++) {
				if(splited[i].equalsIgnoreCase("i"))
					ret[j][i] = Double.POSITIVE_INFINITY;
				else 
					ret[j][i] = Double.parseDouble(splited[i]);
			}
			j++;
		}
		b.close();
		Main.nodos = nodos;
		return ret;
	}
	
	
	private static void dijstra(double grafo[][], int caminos[], double distancias[], int nodos) {
		boolean seleccionar[];
		seleccionar = new boolean[nodos];
		double min = Double.POSITIVE_INFINITY;
		int sel;
		seleccionar[0] = false;
		for(int i = 1; i < nodos; i++) {
			seleccionar[i] = true;
			caminos[i] = 0;
			distancias[i] = grafo[0][i];
		}
		
		for(int i = 1; i < nodos; i++) {
			sel = 0;
			min = Double.POSITIVE_INFINITY;
			for(int v = 1; v < nodos; v++) 
				if(seleccionar[v] && distancias[v] < min) {
					sel = v; min = distancias[v];
				}
			if(min != Double.POSITIVE_INFINITY) {
				seleccionar[sel] = false;
				for(int w = 1; w < nodos; w++) {
					if(seleccionar[w] && (distancias[sel]+grafo[sel][w] < distancias[w])) {
						distancias[w] = distancias[sel]+grafo[sel][w];
						caminos[w] = sel;
					}
				}
			}
		}
	}
}
