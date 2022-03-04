package com.ibm.academia.restapi.listanegra.modelo.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CotizacionEuroDTO implements Serializable{

	private BigDecimal cotizacionActual;
	
	private static final long serialVersionUID = 8929273896370434166L;

}
