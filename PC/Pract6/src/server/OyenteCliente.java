package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;







import messages.*;

public class OyenteCliente extends Thread{

	private Socket sc;
	private boolean end = false;
	private ObjectInputStream input;
	private Server s;
	
	public OyenteCliente(Socket sc, Server s){
		this.sc = sc;
		this.s = s;
	}

	@Override
	public void run() {
		while(!end){
			Mensaje m = null;
			try {
				m = (Mensaje) input.readObject();
			} catch (ClassNotFoundException e) {
				System.out.println("Not found exception");
			} catch (IOException e) {
				System.out.println("IO exception");
			}
			if(m.equals(new MensajeConexion())){
				MensajeConexion mc = (MensajeConexion)m;
				s.setArchivos(mc.getId(), mc.getFiles());
				
			}else if(m.equals(new MensajeListaUsuario())){
				
			}else if(m.equals(new MensajePedirFichero())){
				
			}else if(m.equals(new MensajePreparadoClienteServidor())){
				
			}else if(m.equals(new MensajeCerrarConexion())){
				
			}
		}
	}

}
