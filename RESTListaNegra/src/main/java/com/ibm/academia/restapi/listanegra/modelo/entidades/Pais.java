package com.ibm.academia.restapi.listanegra.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class Pais implements Serializable {

	private String nombre;
	private String codigoIso;
	private String monedaLocal;
	private BigDecimal cotizacionActual;
	private String cotizacion="EUR";
	
	
	private static final long serialVersionUID = -629283575325597721L;
	
	

}
