package com.unab.reto2.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.unab.reto2.entity.Personas;
import com.unab.reto2.repository.IPersonasRepository;

@Service
public class PersonasService implements IPersonasService {

	@Autowired
	private IPersonasRepository repository;

	@Override
	public List<Personas> listar() {
		return this.repository.findAll();
	}

	@Override
	public Optional<Personas> buscarxId(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public Personas guardar(Personas variabletabla) {
		return this.repository.save(variabletabla);
	}

	@Override
	public void borrar(Long id) {
		this.repository.deleteById(id);

	}

}
