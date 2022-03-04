package com.ibm.academia.restapi.listanegra.excepciones;

public class NotAllowedException extends RuntimeException {

	public NotAllowedException(String mensaje) {
		super(mensaje);
	}
	
	private static final long serialVersionUID = -1399540529409809521L;

}
