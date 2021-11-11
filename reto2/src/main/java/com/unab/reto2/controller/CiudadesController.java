package com.unab.reto2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.unab.reto2.entity.Ciudades;
import com.unab.reto2.service.ICiudadesService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/ciudades")
public class CiudadesController   {

	@Autowired
	private ICiudadesService service;
	
	@GetMapping
	public List<Ciudades> listar() {
		return service.all();
	}

	@GetMapping("{id}")
	public Optional<Ciudades> show(@PathVariable Long id) {
		return service.findById(id);
	}
	
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Ciudades insertar(@RequestBody Ciudades vartabla) {
		return service.save(vartabla);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Ciudades actualizar(@PathVariable Long id, @RequestBody Ciudades datosRecibidos) {
		Optional<Ciudades> resultado = service.findById(id);
		
		if (!resultado.isEmpty()) {
			Ciudades tablaParaModificar = resultado.get();
			
			tablaParaModificar.setDescripcion( datosRecibidos.getDescripcion() );
			tablaParaModificar.setCodigoDane(datosRecibidos.getCodigoDane());
			tablaParaModificar.setId(datosRecibidos.getId());
			
			return service.save(tablaParaModificar);
		}
		
		return datosRecibidos;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void borrar(@PathVariable Long id) {
		service.delete(id);
	}
	
}
