package com.unab.reto2.service;
import java.util.List;
import java.util.Optional;
import com.unab.reto2.entity.Vuelos;
public interface IVuelosService {
	public List<Vuelos> listar();
	
	public Optional< Vuelos > buscarxId(Long id);
	
	public Vuelos guardar(Vuelos variabletabla);
	
	public void borrar(Long id);
	
}
