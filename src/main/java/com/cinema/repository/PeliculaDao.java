package com.cinema.repository;

import org.springframework.stereotype.Repository;
import com.cinema.model.Pelicula;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface PeliculaDao extends JpaRepository <Pelicula, Integer>{

	Pelicula findByTitulo (String titulo);
	
	List<Pelicula> findById(int id);
	

}
