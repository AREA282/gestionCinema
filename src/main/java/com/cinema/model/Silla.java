package com.cinema.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="silla")
public class Silla implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id 
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="estadoSilla")
	private boolean estadoSilla = true;
	@Column(name="numeroSilla")
	private int numeroSilla;
	@JoinColumn(name = "idSala")
	@OneToOne
	private Sala idSala;
	

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isEstadoSilla() {
		return estadoSilla;
	}
	public void setEstadoSilla(boolean estadoSilla) {
		this.estadoSilla = estadoSilla;
	}
	public int getnumeroSilla() {
		return numeroSilla;
	}
	public void setnumeroSilla(int numeroSilla) {
		this.numeroSilla = numeroSilla;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Sala getIdSala() {
		return idSala;
	}
	public void setIdSala(Sala idSala) {
		this.idSala = idSala;
	}
	
	
	
	
	
	

	
	
	
}
