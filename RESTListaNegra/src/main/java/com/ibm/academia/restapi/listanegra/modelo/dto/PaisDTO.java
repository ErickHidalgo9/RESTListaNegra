package com.ibm.academia.restapi.listanegra.modelo.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class PaisDTO implements Serializable {

	private String nombre;
	private String codigoIso;
	private String monedaLocal;
	private BigDecimal cotizacionActual;
	private String cotizacion="EUR";
	
	private static final long serialVersionUID = -3965978905098013933L;
	
	

}
