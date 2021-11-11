package com.unab.reto2.service;

import java.util.List;
import java.util.Optional;

import com.unab.reto2.entity.Aeropuertos;

public interface IAeropuertosService {

	public List<Aeropuertos> listar();
	
	public Optional< Aeropuertos > buscarxId(Long id);
	
	public Aeropuertos guardar(Aeropuertos variabletabla);
	
	public void borrar(Long id);

	
}
