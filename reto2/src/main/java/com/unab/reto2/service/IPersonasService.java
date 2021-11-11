package com.unab.reto2.service;

import java.util.List;
import java.util.Optional;

import com.unab.reto2.entity.Personas;

public interface IPersonasService {

	public List<Personas> listar();
	
	public Optional<Personas> buscarxId(Long id);
	
	public Personas guardar(Personas variabletabla);
	
	public void borrar(Long id);

}
