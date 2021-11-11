package com.unab.reto2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.unab.reto2.entity.Pasajeros;
import com.unab.reto2.service.IPasajerosService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/Pasajeros")
public class PasajerosController {

	@Autowired
	private IPasajerosService servicio;
	
	@GetMapping
	public List<Pasajeros> listar() {
		return servicio.listar();
	}
	
	@GetMapping("{id}")
	public Optional<Pasajeros> mostrar(@PathVariable Long id) {
		return servicio.buscarxId(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Pasajeros insertar(@RequestBody Pasajeros vartabla) {
		return servicio.guardar(vartabla);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Pasajeros actualizar(@PathVariable Long id, @RequestBody Pasajeros datosRecibidos) {
		Optional< Pasajeros > resultado = servicio.buscarxId(id);
		
		if (!resultado.isEmpty()) {
			Pasajeros tablaParaModificar = resultado.get();
			
			tablaParaModificar.setId(datosRecibidos.getId());
			tablaParaModificar.setIdPersona(datosRecibidos.getIdPersona());
			tablaParaModificar.setIdvuelo(datosRecibidos.getIdvuelo());
		
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
