package com.unab.reto2.service;

import java.util.List;
import java.util.Optional;

import com.unab.reto2.entity.Tripulantes;
public interface ITripulantesService {
	public List<Tripulantes> listar();
	
	public Optional< Tripulantes > buscarxId(Long id);
	
	public Tripulantes guardar(Tripulantes variabletabla);
	
	public void borrar(Long id);
}
