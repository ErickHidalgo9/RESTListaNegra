package com.ibm.academia.restapi.listanegra.modelo.repositorios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.restapi.listanegra.modelo.entidades.ListaNegra;


@Repository
public interface ListaNegraRepository extends CrudRepository<ListaNegra, Long> {

	public Optional<ListaNegra> findByIp(String ip);
	
}