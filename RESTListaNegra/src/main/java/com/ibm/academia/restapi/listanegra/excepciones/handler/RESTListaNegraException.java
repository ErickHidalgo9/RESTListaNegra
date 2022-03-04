package com.ibm.academia.restapi.listanegra.excepciones.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ibm.academia.restapi.listanegra.excepciones.AlreadyExistException;
import com.ibm.academia.restapi.listanegra.excepciones.NotAllowedException;
import com.ibm.academia.restapi.listanegra.excepciones.NotFoundException;

@ControllerAdvice
public class RESTListaNegraException {

	@ExceptionHandler(value=NotFoundException.class)
	public ResponseEntity<Object> noExisteException(NotFoundException exception){
		Map<String, Object> respuesta = new HashMap<String, Object>();
		respuesta.put("error", exception.getMessage());
		return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=AlreadyExistException.class)
	public ResponseEntity<Object> siExisteException(AlreadyExistException exception){
		
		Map<String, Object> respuesta = new HashMap<String, Object>();
		respuesta.put("error", exception.getMessage());
		return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value=NotAllowedException.class)
	public ResponseEntity<Object> sinPermisoException(NotAllowedException exception){
		
		Map<String, Object> respuesta = new HashMap<String, Object>();
		respuesta.put("error", exception.getMessage());
		return new ResponseEntity<>(respuesta, HttpStatus.METHOD_NOT_ALLOWED);
	}
}
