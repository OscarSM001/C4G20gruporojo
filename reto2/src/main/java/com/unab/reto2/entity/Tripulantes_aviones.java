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
@Table(name = "tripulantes_aviones")
	public class Tripulantes_aviones implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "id_tripulantes", nullable = false)
	private Tripulantes idTripulante;
	
	/*
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "id_aviones", nullable = true)
	*/
	private Aviones idAvion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Tripulantes getIdTripulante() {
		return idTripulante;
	}

	public void setIdTripulante(Tripulantes idTripulante) {
		this.idTripulante = idTripulante;
	}

	public Aviones getIdAvion() {
		return idAvion;
	}

	public void setIdAvion(Aviones idAvion) {
		this.idAvion = idAvion;
	}
	
	
}
