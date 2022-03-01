package com.cinema.controller;

import java.util.List;

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

import com.cinema.model.Reserva;
import com.cinema.model.Silla;
import com.cinema.service.ReservaService;
import com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer;

@RestController
@CrossOrigin("*")
@RequestMapping("api/cinema/reserva")
public class ReservaController {
	
	@Autowired
	public ReservaService reservaService;
	
	@PostMapping("crear")
	public Reserva crearReserva(@RequestBody Reserva reserva){
		return reservaService.crearReserva(reserva);
	}
	
	@GetMapping("obtenertodas")
	public ResponseEntity<Object>obtenerTodasReservas(){
		return reservaService.obtenerTodasReservas();
	}
	
	@GetMapping("obtener/{idUser}")
	public ResponseEntity<Object>obtenerReserva(@PathVariable int idUser){
		return reservaService.obtenerReserva(idUser);
	}
	
	@GetMapping("obtener")
	public ResponseEntity<Object>obtenerReservaId(@RequestParam int idReserva){
		return reservaService.obtenerReservaId(idReserva);
	}
	
	@DeleteMapping("eliminar")
	public Reserva eliminarReserva(@RequestParam int idReserva){
		return reservaService.eliminarReserva(idReserva);
	}
	
	@PutMapping("modificar")
	public Reserva modificarReserva(@RequestBody Reserva reserva){
		return reservaService.modificarReserva(reserva);
	}
	
	@GetMapping("obtenerByPelicula")
	public ResponseEntity<Object> obtenerReservaSala(@RequestParam int idPelicula){
		return reservaService.reservaByPelicula(idPelicula);
	}
}
