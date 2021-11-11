package com.unab.reto2.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "aeropuertos")
public class Aeropuertos implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre", length = 30, nullable = false)
	private String nombre;
	
	@Column(name = "cantidad_pista", nullable = true)
	private Long cantidadPista;
	
	@Column(name = "cantidad_sala", nullable = true)
	private Long cantidadSala;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "id_ciudad", nullable = false)
	private Ciudades idCiudad;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getCantidadPista() {
		return cantidadPista;
	}

	public void setCantidadPista(Long cantidadPista) {
		this.cantidadPista = cantidadPista;
	}

	public Long getCantidadSala() {
		return cantidadSala;
	}

	public void setCantidadSala(Long cantidadSala) {
		this.cantidadSala = cantidadSala;
	}

	public Ciudades getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Ciudades idCiudad2) {
		this.idCiudad = idCiudad2;
	}
	
	
}
