package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

public class Server {
	
	private HashMap<Integer, ArrayList<String>> tablaUser;
	private HashMap<Integer, ArrayList<Socket>> tablaSocket;
	private static ServerSocket ss;
	
	public Server(){};
	
	public synchronized ArrayList<Socket> getSocket(Integer id){
		//BARRERA
		return tablaSocket.get(id);
	}
	
	public synchronized ArrayList<String> getArchivos(Integer id){
		//BARRERA
		return tablaUser.get(id);
	}
	
	public synchronized void setSocket(Integer id, ArrayList<Socket> sk){
		//BARRERA
		tablaSocket.put(id, sk);
	}
	
	public synchronized void setArchivos(Integer id, ArrayList<String> fl){
		//BARRERA
		tablaUser.put(id, fl);
	}
	
	public static void main(String args[]) throws UnknownHostException, IOException{
		Server s = new Server();
		while(true){
			Socket sc = ss.accept();
			(new OyenteCliente(sc, s)).start();
		}
	}
}
