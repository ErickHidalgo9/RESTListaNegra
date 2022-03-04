package com.ibm.academia.restapi.listanegra.modelo.mapper;


import com.ibm.academia.restapi.listanegra.modelo.dto.CotizacionEuroDTO;
import com.ibm.academia.restapi.listanegra.modelo.dto.PaisDTO;
import com.ibm.academia.restapi.listanegra.modelo.entidades.MonedaPais;
import com.ibm.academia.restapi.listanegra.modelo.entidades.NombrePais;

public class PaisMapper {

	public static PaisDTO mapPais(NombrePais nombrePais, MonedaPais moneda, CotizacionEuroDTO fixerDto) {
		PaisDTO paisDto = new PaisDTO();
		
		paisDto.setNombre(nombrePais.getNombre());
		paisDto.setCodigoIso(nombrePais.getCodigoIso());
		paisDto.setMonedaLocal(moneda.getMonedaLocal());
		paisDto.setCotizacionActual(fixerDto.getCotizacionActual());
		
		return paisDto;
	}
}
