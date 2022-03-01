package com.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cinema.model.Pelicula;


import com.cinema.service.PeliculaService;

@RestController
@RequestMapping("api/cinema/pelicula")
@CrossOrigin("*")
public class PeliculaController {
	
	@Autowired
	private PeliculaService peliculaService;
	
	@PostMapping("crear")
	public ResponseEntity<Object> crearPelicula(@RequestBody Pelicula pelicula) {
		return peliculaService.crearPelicula(pelicula);
		
	}
	
	@GetMapping("obtenertodas")
	public ResponseEntity<Object> obtenerTodasPeliculas(){
		return peliculaService.obtenerTodasPeliculas();
	}
	
	@GetMapping("obtener/{id}")
	public ResponseEntity<Object> obtenerPelicula(@PathVariable int id){
		return peliculaService.obtenerPelicula(id);
	}
	
	 @DeleteMapping("eliminar")
	 public ResponseEntity<Object> eliminarPelicula(@RequestParam int idPelicula){
		 return peliculaService.eliminarPelicula(idPelicula);
	 }
	 
	 @PutMapping("modificar")
	 public ResponseEntity<Object> modificarPelicula(@RequestParam Pelicula pelicula){
		 return peliculaService.modificarPelicula(pelicula);
	 }
}
