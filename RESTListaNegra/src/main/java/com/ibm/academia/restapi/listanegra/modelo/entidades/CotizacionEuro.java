package com.ibm.academia.restapi.listanegra.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CotizacionEuro implements Serializable{


	@Positive(message = "Debe ser mayor a 0")
	@Column(name="cotizacion")
	private BigDecimal cotizacion;
	
	private static final long serialVersionUID = -8682581768980454665L;
	
	

}
