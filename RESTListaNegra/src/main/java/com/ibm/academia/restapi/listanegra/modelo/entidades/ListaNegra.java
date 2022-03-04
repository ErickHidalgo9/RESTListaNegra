package com.ibm.academia.restapi.listanegra.modelo.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ibm.academia.restapi.listanegra.modelo.dto.PaisDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Lista_Negra")
public class ListaNegra implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="ip")
	private String ip;
	
	@Embedded
	private PaisDTO pais;
	
	@Column(name = "fecha_creacion", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;
	
	@PrePersist
	private void pre() {
		fechaCreacion = new Date();
	}
	
	public ListaNegra(Long id, String ip, PaisDTO pais) {
		super();
		this.id = id;
		this.ip = ip;
		this.pais = pais;
	}
	
	
	private static final long serialVersionUID = -3743973215395019378L;
	
	

}
