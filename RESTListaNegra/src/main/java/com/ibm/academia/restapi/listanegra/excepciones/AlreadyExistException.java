package com.ibm.academia.restapi.listanegra.excepciones;

public class AlreadyExistException extends RuntimeException {
	

	public AlreadyExistException(String mensaje) {
		super(mensaje);
	}
	
	private static final long serialVersionUID = 3691015831432980504L;

}
