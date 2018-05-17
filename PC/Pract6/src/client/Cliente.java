package client;

import java.io.*;
import java.net.*;

public class Cliente {

	private static Socket cs;
	public static void main(String args[]) throws UnknownHostException, IOException{
		cs = new Socket("localhost", 50000);
		
		PrintWriter tServer = new PrintWriter(cs.getOutputStream());
		BufferedReader fServer = new BufferedReader(new InputStreamReader(cs.getInputStream()));
		String read;
	}
}
