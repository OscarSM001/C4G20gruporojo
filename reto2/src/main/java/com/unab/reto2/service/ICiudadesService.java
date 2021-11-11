package com.unab.reto2.service;

import java.util.List;
import java.util.Optional;

import com.unab.reto2.entity.Ciudades;

public interface ICiudadesService {
	
	public List<Ciudades> all();
	
	public Optional<Ciudades> findById(Long id);
	
	public Ciudades save(Ciudades ciudades);
	
	public void delete(Long id);


}
