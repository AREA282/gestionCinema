package com.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cinema.model.TipoUsuario;
import com.cinema.repository.TipoUsuarioDao;

@Service
public class TipoUsuarioService {

	@Autowired
	private TipoUsuarioDao tipoUsuarioDao;
	
	public String crearTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
		tipoUsuarioDao.save(tipoUsuario);
		return "El usuario fue guardado exitosamente";

	}
	
	public List<TipoUsuario> obtenerTipoUsuario() {
		return tipoUsuarioDao.findAll();
	}
}