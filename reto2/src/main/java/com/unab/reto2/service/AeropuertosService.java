package com.unab.reto2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.reto2.entity.Aeropuertos;
import com.unab.reto2.repository.IAeropuertosRepository;


@Service
public class AeropuertosService implements IAeropuertosService {

	@Autowired
	private IAeropuertosRepository repository;
	
	@Override
	public List<Aeropuertos> listar() {
		return this.repository.findAll();
	}

	@Override
	public Optional<Aeropuertos> buscarxId(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public Aeropuertos guardar(Aeropuertos variabletabla) {
		return this.repository.save(variabletabla);
	}

	@Override
	public void borrar(Long id) {
		this.repository.deleteById(id);

	}

}
