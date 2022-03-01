package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.cinema.utilitario.ValidarContraseña;

public class TestContraseña {
	
	@Test
	public void contraseñaMala() {
		
		String contraseña = "holaquicho";
		String contraseña1 = "Hdfsdfs";
		String contraseña2 = "dfsdfs12";
		String contraseña3 = "Sad2";
		boolean contraseñaVal1 = ValidarContraseña.comprobarPassword(contraseña);
		boolean contraseñaVal2 = ValidarContraseña.comprobarPassword(contraseña1);
		boolean contraseñaVal3 = ValidarContraseña.comprobarPassword(contraseña2);
		boolean contraseñaVal4 = ValidarContraseña.comprobarPassword(contraseña3);
		assertEquals(false, contraseñaVal1);
		assertEquals(false, contraseñaVal2);
		assertEquals(false, contraseñaVal3);
		assertEquals(false, contraseñaVal4);
	}
	
	@Test
	public void contraseñaBuena() {
		String contraseña = "Voleibol123";
		boolean contraseña1 = ValidarContraseña.comprobarPassword(contraseña);
		assertEquals(true, contraseña1);
	}

}
