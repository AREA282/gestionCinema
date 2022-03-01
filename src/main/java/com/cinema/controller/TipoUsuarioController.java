package com.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.model.TipoUsuario;
import com.cinema.service.TipoUsuarioService;

@RestController
@RequestMapping("api/cinema/tipousuario")
public class TipoUsuarioController {

	@Autowired
	private TipoUsuarioService tipoUsuarioService;

	@PostMapping("crear")
	public String crearUsuario(@RequestBody TipoUsuario tipoUsuario) {
		return tipoUsuarioService.crearTipoUsuario(tipoUsuario);
	}
	
	@GetMapping("obtener")
	public List<TipoUsuario> obtenerTipoUsuario() {
		return tipoUsuarioService.obtenerTipoUsuario();
	}
	
	
}