package serverSimple;

import java.io.*;
import java.net.*;

public class SocketPrueba {

		public static void main(String args[]) throws UnknownHostException, IOException{
			Socket sc = new Socket("localhost", 50000);
			BufferedReader fServer = new BufferedReader(new InputStreamReader(sc.getInputStream()));
			PrintWriter tServer = new PrintWriter(sc.getOutputStream());
			tServer.println("test.txt");
			tServer.flush();
			System.out.println("conectado");
			String line = fServer.readLine();
			System.out.println(line);
			fServer.close();
			tServer.close();
			sc.close();
		}
}