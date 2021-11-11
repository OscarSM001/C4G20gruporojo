package com.unab.reto2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.unab.reto2.entity.Vuelos;
import com.unab.reto2.service.IVuelosService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/Vuelos")
public class VuelosController {

	@Autowired
	private IVuelosService servicio;
	
	@GetMapping
	public List<Vuelos> listar() {
		return servicio.listar();
	}
	
	@GetMapping("{id}")
	public Optional<Vuelos> mostrar(@PathVariable Long id) {
		return servicio.buscarxId(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Vuelos insertar(@RequestBody Vuelos vartabla) {
		return servicio.guardar(vartabla);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Vuelos actualizar(@PathVariable Long id, @RequestBody Vuelos datosRecibidos) {
		Optional< Vuelos > resultado = servicio.buscarxId(id);
		
		if (!resultado.isEmpty()) {
			Vuelos tablaParaModificar = resultado.get();
			tablaParaModificar.setCantidadPasajero(datosRecibidos.getCantidadPasajero());
			tablaParaModificar.setFechaLlegada(datosRecibidos.getFechaLlegada());
			tablaParaModificar.setFechaSalida(datosRecibidos.getFechaSalida());
			tablaParaModificar.setHoraLlegada(datosRecibidos.getHoraLlegada());
			tablaParaModificar.setHoraSalida(datosRecibidos.getHoraSalida());
			tablaParaModificar.setId(datosRecibidos.getId());
			tablaParaModificar.setIdAeropuertoLlegada(datosRecibidos.getIdAeropuertoLlegada());
			tablaParaModificar.setIdAeropuertoSalida(datosRecibidos.getIdAeropuertoSalida());
			tablaParaModificar.setIdAvion(datosRecibidos.getIdAvion());
		
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