package com.ibm.academia.restapi.listanegra.modelo.mapper;

import java.math.BigDecimal;
import java.util.Map;

import com.ibm.academia.restapi.listanegra.modelo.dto.CotizacionEuroDTO;

public class CotizacionEuroMapper {
	
	public static CotizacionEuroDTO mapCotizar(Map<String, ?> cotizaciones, String monedaLocal) {
		CotizacionEuroDTO cotizacionEuroDto = new CotizacionEuroDTO();
		cotizacionEuroDto.setCotizacionActual((BigDecimal.valueOf(Double.valueOf(cotizaciones.get(monedaLocal).toString()))));
		
		return cotizacionEuroDto;
	}

}
