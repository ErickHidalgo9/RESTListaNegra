package com.ibm.academia.restapi.listanegra.modelo.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NombrePaisDTO implements Serializable {

	private String nombre;
	private String codigoIso;
	
	
	private static final long serialVersionUID = -6462038577838501094L;

}
