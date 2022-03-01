package com.cinema.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="reserva")
public class Reserva implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="hora")
	private String hora;
	@Column(name="pelicula")
	private String pelicula;
	@JoinColumn(name="sillas")
	@OneToMany
	private List<Silla> silla;
	@JoinColumn(name="sala")
	@OneToOne 	
	private Sala sala;
	@JoinColumn(name="usuario")
	@ManyToOne
	private Usuario usuario;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getPelicula() {
		return pelicula;
	}
	public void setPelicula(String pelicula) {
		this.pelicula = pelicula;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	
	public List<Silla> getSilla() {
		return silla;
	}
	public void setSilla(List<Silla> silla) {
		this.silla = silla;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	

}
