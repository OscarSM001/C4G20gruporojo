package com.unab.reto2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.unab.reto2.entity.Aeropuertos;
import com.unab.reto2.service.IAeropuertosService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/aeropuertos")
public class AeropuertosController {

	@Autowired
	private IAeropuertosService servicio;
	
	@GetMapping
	public List<Aeropuertos> listar() {
		return servicio.listar();
	}
	
	@GetMapping("{id}")
	public Optional<Aeropuertos> mostrar(@PathVariable Long id) {
		return servicio.buscarxId(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Aeropuertos insertar(@RequestBody Aeropuertos vartabla) {
		return servicio.guardar(vartabla);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Aeropuertos actualizar(@PathVariable Long id, @RequestBody Aeropuertos datosRecibidos) {
		Optional<Aeropuertos> resultado = servicio.buscarxId(id);
		
		if (!resultado.isEmpty()) {
			Aeropuertos tablaParaModificar = resultado.get();
			tablaParaModificar.setCantidadPista(datosRecibidos.getCantidadPista());
			tablaParaModificar.setCantidadSala(datosRecibidos.getCantidadSala());
			tablaParaModificar.setIdCiudad(datosRecibidos.getIdCiudad());
			tablaParaModificar.setNombre(datosRecibidos.getNombre());
			tablaParaModificar.setId(datosRecibidos.getId());


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
