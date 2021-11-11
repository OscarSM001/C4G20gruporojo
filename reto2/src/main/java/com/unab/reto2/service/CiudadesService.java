package com.unab.reto2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.reto2.entity.Ciudades;
import com.unab.reto2.repository.ICiudadesRepository;

@Service
public class CiudadesService implements ICiudadesService {

	@Autowired
	private ICiudadesRepository repository;

	@Override
	public List<Ciudades> all() {
		return this.repository.findAll();
	}
	
	@Override
	public Optional<Ciudades> findById(Long id) {
		return this.repository.findById(id);
	}
	
	@Override
	public Ciudades save(Ciudades ciudades) {
		return this.repository.save(ciudades);
	}

	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}

}
