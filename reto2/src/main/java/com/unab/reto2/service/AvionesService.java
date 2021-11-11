package com.unab.reto2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.reto2.entity.Aviones;
import com.unab.reto2.repository.IAvionesRepository;


@Service
public class AvionesService implements IAvionesService {
	@Autowired
	private IAvionesRepository repository;
	
	@Override
	public List<Aviones> listar() {
		return this.repository.findAll();
	}

	@Override
	public Optional<Aviones> buscarxId(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public Aviones guardar(Aviones variabletabla) {
		return this.repository.save(variabletabla);
	}

	@Override
	public void borrar(Long id) {
		this.repository.deleteById(id);

	}

}
