package serverSimple;

import java.io.*;
import java.net.*;

public class Server {
	
	public static void main(String args[]) throws IOException{
		ServerSocket listener = new ServerSocket(50000);
		Socket s = listener.accept();
		System.out.println("conectado");
		BufferedReader fClient;
		fClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintWriter tClient;
		tClient = new PrintWriter(s.getOutputStream());
		String fileName = fClient.readLine();
		String line = null;
//		FileReader reader = new FileReader(fileName);
//        BufferedReader bufferedReader = new BufferedReader(reader);
//        while((line = bufferedReader.readLine()) != null) {
//            tClient.println(line);
//        }
		tClient.println(fileName);
		tClient.flush();
//        bufferedReader.close();
        listener.close();
        tClient.close();
        fClient.close();
        s.close();
	}
}
