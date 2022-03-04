package com.ibm.academia.restapi.listanegra.modelo.servicios;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import com.ibm.academia.restapi.listanegra.clientes.CountryRest;
import com.ibm.academia.restapi.listanegra.clientes.FixerRest;
import com.ibm.academia.restapi.listanegra.clientes.Ip2CountryRest;
import com.ibm.academia.restapi.listanegra.excepciones.AlreadyExistException;
import com.ibm.academia.restapi.listanegra.excepciones.NotAllowedException;
import com.ibm.academia.restapi.listanegra.modelo.dto.CotizacionEuroDTO;
import com.ibm.academia.restapi.listanegra.modelo.dto.PaisDTO;
import com.ibm.academia.restapi.listanegra.modelo.entidades.ListaNegra;
import com.ibm.academia.restapi.listanegra.modelo.entidades.MonedaPais;
import com.ibm.academia.restapi.listanegra.modelo.entidades.NombrePais;
import com.ibm.academia.restapi.listanegra.modelo.mapper.CotizacionEuroMapper;
import com.ibm.academia.restapi.listanegra.modelo.mapper.PaisMapper;
import com.ibm.academia.restapi.listanegra.modelo.repositorios.ListaNegraRepository;

@Service
public class ListaNegraServiceImpl implements IListaNegraService {
	
	@Autowired
	private ListaNegraRepository listaNegraRepository;
	
	@Autowired
	private Ip2CountryRest clienteIp;
	
	@Autowired
	private CountryRest paisRest;
	
	@Autowired
	private FixerRest fixerRest;
	
	@Value("${fixer.api-key}")
	private String apiKeyFixer;

	@Override
	public PaisDTO buscarPaisPorIp(String ip) {
		
		Optional<ListaNegra> oListaNegra = listaNegraRepository.findByIp(ip);
		
		if(oListaNegra.isPresent())
			throw new NotAllowedException("Permiso denegado, Ip esta en la lista negra");
		
		NombrePais nombrePais = clienteIp.buscarPaisPorIp(ip);
		MonedaPais moneda = paisRest.buscarPaisPorCodigo3(nombrePais.getCodigoIso());
		
		Map<String, Object> respuestaFixer = fixerRest.obtenerCotizacionEuros(apiKeyFixer);
		
		@SuppressWarnings("unchecked")
		Map<String, BigDecimal> cotizaciones = (Map<String, BigDecimal>) respuestaFixer.get("rates");
		
		
		CotizacionEuroDTO cotizacion = CotizacionEuroMapper.mapCotizar(cotizaciones, moneda.getMonedaLocal());
		
		
		return PaisMapper.mapPais(nombrePais, moneda, cotizacion);
		
	}

	@Override
	public ListaNegra ipBan(String ip) {
		
		Optional<ListaNegra> oListaNegra = listaNegraRepository.findByIp(ip);
		
		if(oListaNegra.isPresent())
			throw new AlreadyExistException("Ip ya existente en la lista Negra");
		
		
		PaisDTO paisDto = buscarPaisPorIp(ip);
		ListaNegra listaNegra = new ListaNegra(null, ip, paisDto);
		
		ListaNegra guardar = listaNegraRepository.save(listaNegra);
		return guardar;
		
	}

}
