package com.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.model.Silla;
import com.cinema.service.SillaService;

@RestController
@RequestMapping("api/cinema/silla")
public class SillaController {
	
	@Autowired
	private SillaService sillaService;
	
	@PostMapping("crear")
	public ResponseEntity<Object>crearSilla(@RequestBody Silla silla){
		return sillaService.crearSilla(silla);
	}
	
	@GetMapping("consultar")
	public ResponseEntity<Object>consultarSillasDisponibles(){
		return sillaService.obtenerSillasDisponibles();
	}
	
	@GetMapping("consultarSillasSala")
	public ResponseEntity<Object>consultarSillasSala(@RequestParam long idSala){
		return sillaService.obtenerSillasSala(idSala);
	}
	
	@DeleteMapping("eliminar")
	public ResponseEntity<Object> eliminarSilla (@RequestParam int idSilla){
		return sillaService.eliminarSilla(idSilla);
	}

	@DeleteMapping("eliminarTodas")
	public Boolean eliminarTodasSilla(@RequestParam long idPelicula){
		sillaService.eliminarTodas(idPelicula);
		return true;
	}

}
