package com.ibm.academia.restapi.listanegra.clientes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ibm.academia.restapi.listanegra.modelo.entidades.NombrePais;


@FeignClient(name="api-ip2country" , url = "${ip2country.url}")
public interface Ip2CountryRest {
	
	@GetMapping("/ip?{ip}")
	public NombrePais buscarPaisPorIp(@PathVariable String ip);

}

