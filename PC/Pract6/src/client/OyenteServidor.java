package client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class OyenteServidor extends Thread{

	ObjectInputStream reader;
	ObjectOutputStream writer;
	Socket sc;
	boolean end = false;
	
	@Override
	public void run() {
		try {
			sc = new Socket("localhost", 50000);
			BufferedReader fServer = new BufferedReader(new InputStreamReader(sc.getInputStream()));
			Object o;
			while(!end){
				o = fServer.readLine();
				if(o.equals(new Object())){
					
				}
			}
		} catch (UnknownHostException e) {
			System.out.println("No server to connect to");
		} catch (IOException e) {
			System.out.println("The wea is lit");
		}
	}

	public void end(){
		end = true;
	}
}
