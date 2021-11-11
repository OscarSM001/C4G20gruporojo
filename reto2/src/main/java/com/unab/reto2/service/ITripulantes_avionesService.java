package com.unab.reto2.service;

import java.util.List;
import java.util.Optional;

import com.unab.reto2.entity.Tripulantes_aviones;
public interface ITripulantes_avionesService {
	public List<Tripulantes_aviones> listar();
	
	public Optional< Tripulantes_aviones > buscarxId(Long id);
	
	public Tripulantes_aviones guardar(Tripulantes_aviones variabletabla);
	
	public void borrar(Long id);
}
