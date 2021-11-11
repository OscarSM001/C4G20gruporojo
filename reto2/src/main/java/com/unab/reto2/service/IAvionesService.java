package com.unab.reto2.service;

import java.util.List;
import java.util.Optional;

import com.unab.reto2.entity.Aviones;

public interface IAvionesService {
	public List<Aviones> listar();
	
	public Optional< Aviones > buscarxId(Long id);
	
	public Aviones guardar(Aviones variabletabla);
	
	public void borrar(Long id);
}
