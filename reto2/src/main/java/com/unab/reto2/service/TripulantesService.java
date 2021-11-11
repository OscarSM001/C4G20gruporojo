package com.unab.reto2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.reto2.entity.Tripulantes;
import com.unab.reto2.repository.ITripulantesRepository;

@Service
public class TripulantesService implements ITripulantesService {

	@Autowired
	private ITripulantesRepository repository;
	
	@Override
	public List<Tripulantes> listar() {
		return this.repository.findAll();
	}

	@Override
	public Optional<Tripulantes> buscarxId(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public Tripulantes guardar(Tripulantes variabletabla) {
		return this.repository.save(variabletabla);
	}

	@Override
	public void borrar(Long id) {
		this.repository.deleteById(id);

	}

}
