package com.ibm.academia.restapi.listanegra.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NombrePais implements Serializable {
	
	@Size(min = 3, max = 100)
	@Column(name="nombre")
	@JsonProperty("countryName")
	private String nombre;
	
	
	@Size(min = 3, max = 100)
	@NotEmpty(message = "No puede ser vacio")
	@NotNull(message = "No puede ser nulo")
	@Column(name="codigoIso")
	@JsonProperty("countryCode3")
	private String codigoIso;
	
	private static final long serialVersionUID = 2131190735866263702L;

}
