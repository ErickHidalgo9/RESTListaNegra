package com.ibm.academia.restapi.listanegra.clientes;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "api-fixer", url = "${fixer.url}")
public interface FixerRest {
	
	@GetMapping("/latest")
	public Map<String, Object> obtenerCotizacionEuros(@RequestParam(name="access_key")String apiKey );

}

