package com.ibm.academia.restapi.listanegra.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;

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
public class MonedaPais implements Serializable {

	@Column(name="moneda_local")
	private String monedaLocal;
	
	@JsonProperty("currencies")
	private void monedas(List<Map<String, Object>> currencies) {
		monedaLocal = (String) currencies.get(0).get("code");
	}
	
	
	private static final long serialVersionUID = -6215867779632923682L;

}
