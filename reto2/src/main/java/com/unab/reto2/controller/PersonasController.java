package com.unab.reto2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.unab.reto2.entity.Personas;
import com.unab.reto2.service.IPersonasService;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/personas")

public class PersonasController {
	@Autowired
	private IPersonasService servicio;
	
	@GetMapping
	public List<Personas> listar() {
		return servicio.listar();
	}
	
	@GetMapping("{id}")
	public Optional<Personas> mostrar(@PathVariable Long id) {
		return servicio.buscarxId(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Personas insertar(@RequestBody Personas vartabla) {
		return servicio.guardar(vartabla);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Personas actualizar(@PathVariable Long id, @RequestBody Personas datosRecibidos) {
		Optional<Personas> resultado = servicio.buscarxId(id);
		
		if (!resultado.isEmpty()) {
			Personas tablaParaModificar = resultado.get();
			
			tablaParaModificar.setDocumento(datosRecibidos.getDocumento());
			tablaParaModificar.setCorreo(datosRecibidos.getCorreo());
			tablaParaModificar.setNombre(datosRecibidos.getNombre());
			tablaParaModificar.setApellido(datosRecibidos.getApellido());
			tablaParaModificar.setId(datosRecibidos.getId());
			tablaParaModificar.setTelefono(datosRecibidos.getTelefono());
			
			return servicio.guardar(tablaParaModificar);
		}
		
		return datosRecibidos;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void borrar(@PathVariable Long id) {
		servicio.borrar(id);
	}

}

