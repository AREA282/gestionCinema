package com.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.cinema.model.Silla;
import com.cinema.model.Usuario;

@Repository
public interface SillaDao extends JpaRepository<Silla, Integer>{

	@Query(value = "select * from silla where estado_silla = true", nativeQuery = true)
	public List<Silla> sillasDisponibles();
	
	@Query(value = "select * from silla where id_sala = ?", nativeQuery = true)
	public List<Silla> sillasSala(long idSala);
	
	@Query(value = "select silla.* from pelicula peli\r\n"
			+ "inner join sala sala on peli.id = sala.pelicula\r\n"
			+ "inner join silla silla on sala.id = silla.id_sala  where peli.id =?", nativeQuery = true)
	public List<Silla> sillasPelicula(long idPelicula);
	
	
	
	Silla findById(int id);
	
}
