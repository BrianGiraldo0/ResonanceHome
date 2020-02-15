package com.resonance.usuarios;

import java.util.Date;

public class Huesped extends Usuario{

	public Huesped(String nombre, String email, String uRLFoto, String direccion, Date fechaNacimiento,
			String contrasenia, String biografia) {
		super(nombre, email, uRLFoto, direccion, fechaNacimiento, contrasenia, biografia);
	}
	
	public Huesped(String nombre, String email, String direccion, Date fechaNacimiento,
			String contrasenia, String biografia) {
		super(nombre, email, direccion, fechaNacimiento, contrasenia, biografia);
	}

}
