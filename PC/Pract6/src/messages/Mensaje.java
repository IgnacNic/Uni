package messages;

import java.io.Serializable;

public abstract class Mensaje implements Serializable{

	private static final long serialVersionUID = 1L;
	private Mensajes msg;
	
	public Mensaje(Mensajes m){
		this.msg = m;
	}
	
	public boolean equals(Mensaje o){
		return this.msg == o.msg;
	}
	
}
