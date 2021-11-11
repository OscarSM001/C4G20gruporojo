package com.unab.reto2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.unab.reto2.entity.Tripulantes_aviones;
import com.unab.reto2.service.ITripulantes_avionesService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/Tripulantes_aviones")
public class Tripulantes_avionesController {

	@Autowired
	private ITripulantes_avionesService servicio;
	
	@GetMapping
	public List<Tripulantes_aviones> listar() {
		return servicio.listar();
	}
	
	@GetMapping("{id}")
	public Optional<Tripulantes_aviones> mostrar(@PathVariable Long id) {
		return servicio.buscarxId(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Tripulantes_aviones insertar(@RequestBody Tripulantes_aviones vartabla) {
		return servicio.guardar(vartabla);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Tripulantes_aviones actualizar(@PathVariable Long id, @RequestBody Tripulantes_aviones datosRecibidos) {
		Optional< Tripulantes_aviones > resultado = servicio.buscarxId(id);
		
		if (!resultado.isEmpty()) {
			Tripulantes_aviones tablaParaModificar = resultado.get();
			
			tablaParaModificar.setId(datosRecibidos.getId());
			tablaParaModificar.setIdAvion(datosRecibidos.getIdAvion());
			tablaParaModificar.setIdTripulante(datosRecibidos.getIdTripulante());
		
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