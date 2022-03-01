package com.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinema.model.TipoUsuario;


@Repository
public interface TipoUsuarioDao extends JpaRepository<TipoUsuario, Integer>{


}
