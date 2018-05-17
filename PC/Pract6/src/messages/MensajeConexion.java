package messages;

import java.util.*;


public class MensajeConexion extends Mensaje {

	private static final long serialVersionUID = 1L;
	private int id;
	private ArrayList<String> files;
	
	public MensajeConexion(){
		super(Mensajes.MSG_DE_CONEXION);
	}
	
	public MensajeConexion(int id, ArrayList<String> files) {
		super(Mensajes.MSG_DE_CONEXION);
		this.id = id;
		this.files = files;
	}
	
	public int getId(){
		return id;
	}
	
	public ArrayList<String> getFiles(){
		return files;
	}
}
	