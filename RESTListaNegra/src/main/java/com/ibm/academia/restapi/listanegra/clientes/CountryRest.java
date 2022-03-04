package com.ibm.academia.restapi.listanegra.clientes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ibm.academia.restapi.listanegra.modelo.entidades.MonedaPais;


@FeignClient(name = "api-countrylayer", url="${restcountry.url}")
public interface CountryRest{

	@GetMapping("/alpha/{code}")
	public MonedaPais buscarPaisPorCodigo3(@PathVariable("code") String code3);
}