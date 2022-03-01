package com.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.model.Usuario;
import com.cinema.service.UsuarioService;

@RestController

@RequestMapping("api/cinema/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("crear")
	public ResponseEntity<Object> crearUsuario(@RequestBody Usuario usuario) {
		return usuarioService.crearUsuario(usuario);
	}
	
	@GetMapping("login")
	public ResponseEntity<Object> loginUsuario(@RequestParam String correo, @RequestParam String password) {
		return usuarioService.loginUsuario(correo, password);
	}

	
	@GetMapping("obtener")
	public List<Usuario> obtenerUsuarios(){
		return usuarioService.obtenerTodoUsuario();
	}
	
}
