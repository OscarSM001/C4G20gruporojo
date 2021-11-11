package com.unab.reto2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.unab.reto2.entity.Aviones;
import com.unab.reto2.service.IAvionesService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/Aviones")
public class AvionesController {

	@Autowired
	private IAvionesService servicio;
	
	@GetMapping
	public List<Aviones> listar() {
		return servicio.listar();
	}
	
	@GetMapping("{id}")
	public Optional<Aviones> mostrar(@PathVariable Long id) {
		return servicio.buscarxId(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Aviones insertar(@RequestBody Aviones vartabla) {
		return servicio.guardar(vartabla);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Aviones actualizar(@PathVariable Long id, @RequestBody Aviones datosRecibidos) {
		Optional< Aviones > resultado = servicio.buscarxId(id);
		
		if (!resultado.isEmpty()) {
			Aviones tablaParaModificar = resultado.get();
			
			tablaParaModificar.setCantidadPasajero(datosRecibidos.getCantidadPasajero());
			tablaParaModificar.setCodigo(datosRecibidos.getCodigo());
			tablaParaModificar.setFabricante(datosRecibidos.getFabricante());
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
