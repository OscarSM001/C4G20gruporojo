package com.unab.reto2.service;

import java.util.List;
import java.util.Optional;

import com.unab.reto2.entity.Pasajeros;

public interface IPasajerosService {
	public List<Pasajeros> listar();
	
	public Optional< Pasajeros > buscarxId(Long id);
	
	public Pasajeros guardar(Pasajeros variabletabla);
	
	public void borrar(Long id);
}
