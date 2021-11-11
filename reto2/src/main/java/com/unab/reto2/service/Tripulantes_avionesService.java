package com.unab.reto2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.reto2.entity.Tripulantes_aviones;
import com.unab.reto2.repository.ITripulantesAvionesRepository;

@Service
public class Tripulantes_avionesService implements ITripulantes_avionesService {

	@Autowired
	private ITripulantesAvionesRepository repository;
	
	@Override
	public List<Tripulantes_aviones> listar() {
		return this.repository.findAll();
	}

	@Override
	public Optional<Tripulantes_aviones> buscarxId(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public Tripulantes_aviones guardar(Tripulantes_aviones variabletabla) {
		return this.repository.save(variabletabla);
	}

	@Override
	public void borrar(Long id) {
		this.repository.deleteById(id);

	}

}
