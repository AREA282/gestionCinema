package com.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.cinema.model.Usuario;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Integer>{

	@Query(value = "select * from usuario where correo = ? and password = ?", nativeQuery = true)
	public List<Usuario> loginUsuario(@RequestParam String correo, @RequestParam String password);
	
	Usuario findByCorreo(String correo);
	
	Usuario findById (Long id);
}