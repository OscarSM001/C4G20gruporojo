package com.unab.reto2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.reto2.entity.Vuelos;
import com.unab.reto2.repository.IVuelosRepository;

@Service
public class VuelosService implements IVuelosService {

	@Autowired
	private IVuelosRepository repository;

	
	@Override
	public List<Vuelos> listar() {
		return this.repository.findAll();
	}

	@Override
	public Optional<Vuelos> buscarxId(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public Vuelos guardar(Vuelos variabletabla) {
		return this.repository.save(variabletabla);
	}

	@Override
	public void borrar(Long id) {
		this.repository.deleteById(id);
	}

}
