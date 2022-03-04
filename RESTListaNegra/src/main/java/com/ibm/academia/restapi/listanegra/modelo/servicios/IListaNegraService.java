package com.ibm.academia.restapi.listanegra.modelo.servicios;


import com.ibm.academia.restapi.listanegra.modelo.dto.PaisDTO;
import com.ibm.academia.restapi.listanegra.modelo.entidades.ListaNegra;


public interface IListaNegraService {
	
	public PaisDTO buscarPaisPorIp(String ip);
	public ListaNegra ipBan(String ip);

}
