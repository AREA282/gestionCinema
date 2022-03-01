package com.cinema.utilitario;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarCorreo {

	public static boolean validarCorreoUsuario(String correo) {
		
		// Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(correo);
 
        if (mather.find() == true) {
            return true;
        } else {
            return false;
        }
	}

}
