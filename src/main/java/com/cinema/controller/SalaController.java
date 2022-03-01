package com.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.model.Sala;
import com.cinema.service.SalaService;

@RestController
@RequestMapping("api/cinema/sala")
public class SalaController {

	@Autowired
	private SalaService salaService;
	
	@PostMapping("crear")
	public ResponseEntity<Object>crearSala(@RequestBody Sala sala){
		return salaService.crearSala(sala);
	}
	
	@GetMapping("obtener")
	public ResponseEntity<Object>obtenerTodasLasSalas(){
		return salaService.obtenerSalas();
	}
	
	@GetMapping("obtenerSala/{id}")
	public ResponseEntity<Object> obtenerSala(@PathVariable int id){
		return salaService.obtenerSalaPelicula(id);
	}
	
	@PutMapping("modificar")
	public ResponseEntity<Object>modificarSala(@RequestBody Sala sala){
		return salaService.modificarSala(sala);
	}
	
	@DeleteMapping("eliminar")
	public ResponseEntity<Object>eliminarSala(@RequestParam int id){
		return salaService.eliminarSala(id);
	}
	
	@DeleteMapping("eliminarByPelicula")
	public void eliminarSalaByPelicula(@RequestParam int idPelicula){
		salaService.eliminarSalaByPelicula(idPelicula);
	}

}
