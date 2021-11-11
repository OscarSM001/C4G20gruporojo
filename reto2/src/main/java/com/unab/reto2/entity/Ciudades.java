package com.unab.reto2.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "ciudades")
public class Ciudades implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "descripcion", length = 30, nullable = false)
	private String descripcion;
	
	@Column(name = "codigo_dane", nullable = true)
	private Long codigoDane;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getCodigoDane() {
		return codigoDane;
	}

	public void setCodigoDane(Long codigoDane) {
		this.codigoDane = codigoDane;
	}
	
	
}
