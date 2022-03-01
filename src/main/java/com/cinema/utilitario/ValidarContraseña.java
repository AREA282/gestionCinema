package com.cinema.utilitario;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarContraseña {

	public static boolean comprobarPassword(String Password) {

		// Patrón para validar el email
		Pattern pattern = Pattern.compile("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{5,70}$");

		Matcher mather = pattern.matcher(Password);

		if (mather.find() == true) {
			return true;
		} else {
			return false;
		}
	}
}
