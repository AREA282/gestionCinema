package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.cinema.utilitario.ValidarContraseña;
import com.cinema.utilitario.ValidarCorreo;

public class TestCorreo {
	
	@Test
	public void correoBueno() {
		String correo = "darkblue.va.28@gmail.com";
		boolean correo1 = ValidarCorreo.validarCorreoUsuario(correo);
		assertEquals(true,correo1); 
	}
	
	@Test
	public void correoMalo() {
		String correo = "asdfasfdcasf.com";
		String correo2 = "dsfgsdfgsdg@afsfdfsdfadsf2";
		String correo3 = "asdasdasd@.com";
		String correo4 = "@";
		String correo5 = "sdfsdf@";
		String correo6 = "@sdfsdfsdf";
		String correo7 = "@.com";
		boolean correoVal1 = ValidarCorreo.validarCorreoUsuario(correo);
		boolean correoVal2 = ValidarCorreo.validarCorreoUsuario(correo2);
		boolean correoVal3 = ValidarCorreo.validarCorreoUsuario(correo3);
		boolean correoVal4 = ValidarCorreo.validarCorreoUsuario(correo4);
		boolean correoVal5 = ValidarCorreo.validarCorreoUsuario(correo5);
		boolean correoVal6 = ValidarCorreo.validarCorreoUsuario(correo6);
		boolean correoVal7 = ValidarCorreo.validarCorreoUsuario(correo7);
		assertEquals(false,correoVal1);
		assertEquals(false, correoVal2);
		assertEquals(false, correoVal3);
		assertEquals(false, correoVal4);
		assertEquals(false, correoVal5);
		assertEquals(false, correoVal6);
		assertEquals(false, correoVal7);
	}

}
