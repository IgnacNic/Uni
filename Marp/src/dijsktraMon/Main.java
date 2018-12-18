package dijsktraMon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	private static int nodos;

	public static void main(String args[]) throws IOException {
		int caminos[];
		double distancias[];
		double[] grafo[];
		grafo = parser("1.txt");
		caminos = new int[nodos];
		distancias = new double[nodos];
		dijstra(grafo,caminos,distancias);
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

	private static void dijstra(double grafo[][],
			int caminos[], double distancias[]) {
		MonticuloWill q = new MonticuloWill();
		for(int i = 1; i < nodos;i++) {
			distancias[i] = grafo[0][i];
			q.insertar(new Nodo<Integer>(i,grafo[0][i]));
		}
		while(!q.vacia()) {
			Nodo<Integer> min;
			min = q.elimMin();
			for(int i = 1; i < nodos; i++) {
				if(i != min.getKey() 
						&& grafo[min.getKey()][i] != Double.POSITIVE_INFINITY
						&& (min.getVal() + grafo[min.getKey()][i]) < distancias[i]) {
					caminos[i] = min.getKey();
					distancias[i] = min.getVal()+grafo[min.getKey()][i];
					q.decrecerClave(distancias[i], i);
				}
			}
		}
	}
}
