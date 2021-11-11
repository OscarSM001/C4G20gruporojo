package com.unab.reto2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.reto2.entity.Pasajeros;
import com.unab.reto2.repository.IPasajerosRepository;


@Service
public class PasajerosService implements IPasajerosService {

	@Autowired
	private IPasajerosRepository repository;
	
	@Override
	public List<Pasajeros> listar() {
		return this.repository.findAll();
	}

	@Override
	public Optional<Pasajeros> buscarxId(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public Pasajeros guardar(Pasajeros variabletabla) {
		return this.repository.save(variabletabla);
	}

	@Override
	public void borrar(Long id) {
		this.repository.deleteById(id);

	}

}
