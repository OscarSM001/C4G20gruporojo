package com.unab.reto2.entity;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name = "vuelos")
public class Vuelos implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "hora_salida", nullable = false)
	private Long horaSalida;
	
	@Column(name = "hora_llegada", nullable = false)
	private Long horaLlegada;
	
	@Column(name = "fecha_salida", nullable = true)
	private Date fechaSalida;
	
	@Column(name = "fecha_llegada", nullable = true)
	private Date fechaLlegada;
	
	@Column(name = "cantidad_pasajero", nullable = true)
	private Long cantidadPasajero;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "id_aeropuertos_salida", nullable = false)
	private Aeropuertos idAeropuertoSalida;
	
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "id_aeropuertos_llegada", nullable = false)
	private Aeropuertos idAeropuertoLlegada;
	
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "id_aviones", nullable = false)
	private Aviones idAvion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(Long horaSalida) {
		this.horaSalida = horaSalida;
	}

	public Long getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(Long horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Date getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public Long getCantidadPasajero() {
		return cantidadPasajero;
	}

	public void setCantidadPasajero(Long cantidadPasajero) {
		this.cantidadPasajero = cantidadPasajero;
	}

	public Aeropuertos getIdAeropuertoSalida() {
		return idAeropuertoSalida;
	}

	public void setIdAeropuertoSalida(Aeropuertos idAeropuertoSalida) {
		this.idAeropuertoSalida = idAeropuertoSalida;
	}

	public Aeropuertos getIdAeropuertoLlegada() {
		return idAeropuertoLlegada;
	}

	public void setIdAeropuertoLlegada(Aeropuertos idAeropuertoLlegada) {
		this.idAeropuertoLlegada = idAeropuertoLlegada;
	}

	public Aviones getIdAvion() {
		return idAvion;
	}

	public void setIdAvion(Aviones idAvion) {
		this.idAvion = idAvion;
	}
	
	
	

}
