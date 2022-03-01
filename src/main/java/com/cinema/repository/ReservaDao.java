package com.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cinema.model.Reserva;
import com.cinema.model.Usuario;

public interface ReservaDao extends JpaRepository<Reserva, Integer> {
	
	List<Reserva> findByUsuario(Usuario usuario);
	
	List<Reserva> findById(int id);
	
	
	@Query(value = "select * from reserva where sala = ?", nativeQuery = true)
	List<Reserva> findByidSala(Long id);
	
	@Query(value = "select * from reserva where usuario = ?", nativeQuery = true)
	List<Reserva> FindByIdUser(int idUser);
	
}
