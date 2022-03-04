package com.ibm.academia.restapi.listanegra.controladores;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.restapi.listanegra.modelo.dto.PaisDTO;
import com.ibm.academia.restapi.listanegra.modelo.entidades.ListaNegra;
import com.ibm.academia.restapi.listanegra.modelo.servicios.IListaNegraService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

@RestController
public class ListaNegraController {
	
	private final static Logger logger = LoggerFactory.getLogger(ListaNegraController.class);
	
	@Autowired
	private IListaNegraService listaNegraService;
	
	
	/**
	 * Endpoint para consultar la informacion de un país mediante la ip
	 * @param ip
	 * @return nombre, codigo iso, moneda local, cotizacion actual del pais, la cotizacion por defecto que arroja la api son EUROS
	 * @author EHS 02-03-2022
	 */
	@CircuitBreaker(name="ip-informacion", fallbackMethod = "metodoAlternativo")
	@TimeLimiter(name="ip-informacion")
	@GetMapping("/ip-informacion/{ip}")
	public CompletableFuture<ResponseEntity<?>> obtenerPaisPorIp(@PathVariable String ip){
		
		return CompletableFuture.supplyAsync(() -> new ResponseEntity<PaisDTO>(listaNegraService.buscarPaisPorIp(ip), HttpStatus.OK));  
	}
	
	
	/**
	 * Endpoint alternativo en caso de shutdown
	 * @param e Error producido en caso de shutdown
	 * @return el error producido ante el shutdown
	 * @author EHS 02-03-2022
	 */
	public CompletableFuture<ResponseEntity<?>> metodoAlternativo(Throwable e){
		logger.info(e.getMessage());
		
		Map<String, Object>respuesta = new HashMap<>();
		respuesta.put("error", e.getMessage());
		respuesta.put("data", new PaisDTO());
		
		return CompletableFuture.supplyAsync(()->new ResponseEntity<Map<String, Object>>(respuesta,HttpStatus.OK));
		
	}
	
	
	
	/**
	 * Endpoint para banear una ip, se agrega la ip a la BD lista_negra
	 * @param ip que se va a banear
	 * @return la informacion de la ip baneada con los datos del pais
	 * @author EHS  02-03-2022
	 */
	
	@PutMapping ("/ip-baneada/{ip}")
	public ResponseEntity<?> ipBaneada(@PathVariable String ip){
		
		ListaNegra guardar = null;
		guardar = listaNegraService.ipBan(ip);
		
		return new ResponseEntity<ListaNegra>(guardar, HttpStatus.OK);
		
		
	}

}
