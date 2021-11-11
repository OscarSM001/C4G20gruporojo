package com.unab.reto2.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "pasajeros")
public class Pasajeros implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "id_personas", nullable = false)
	private Personas idPersona;
	

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "id_vuelos", nullable = false)
	private Personas idvuelo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Personas getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Personas idPersona) {
		this.idPersona = idPersona;
	}

	public Personas getIdvuelo() {
		return idvuelo;
	}

	public void setIdvuelo(Personas idvuelo) {
		this.idvuelo = idvuelo;
	}
	
	
}
