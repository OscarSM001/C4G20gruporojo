package com.unab.reto2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.unab.reto2.entity.Tripulantes;
import com.unab.reto2.service.ITripulantesService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/Tripulantes")
public class TripulantesController {

	@Autowired
	private ITripulantesService servicio;
	
	@GetMapping
	public List<Tripulantes> listar() {
		return servicio.listar();
	}
	
	@GetMapping("{id}")
	public Optional<Tripulantes> mostrar(@PathVariable Long id) {
		return servicio.buscarxId(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Tripulantes insertar(@RequestBody Tripulantes vartabla) {
		return servicio.guardar(vartabla);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Tripulantes actualizar(@PathVariable Long id, @RequestBody Tripulantes datosRecibidos) {
		Optional< Tripulantes > resultado = servicio.buscarxId(id);
		
		if (!resultado.isEmpty()) {
			Tripulantes tablaParaModificar = resultado.get();
			
			tablaParaModificar.setId(datosRecibidos.getId());
			tablaParaModificar.setFuncion(datosRecibidos.getFuncion());
			tablaParaModificar.setIdPersona(datosRecibidos.getIdPersona());
		
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