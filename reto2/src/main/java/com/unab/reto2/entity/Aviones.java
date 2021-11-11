package com.unab.reto2.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aviones")
public class Aviones implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "codigo", nullable = false)
	private Long codigo;
	
	@Column(name = "cantidad_pasajero", nullable = true)
	private Long cantidadPasajero;
	
	@Column(name = "fabricante", length = 30, nullable = false)
	private String fabricante;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getCantidadPasajero() {
		return cantidadPasajero;
	}

	public void setCantidadPasajero(Long cantidadPasajero) {
		this.cantidadPasajero = cantidadPasajero;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	

}
