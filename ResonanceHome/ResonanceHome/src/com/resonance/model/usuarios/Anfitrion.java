package com.resonance.model.usuarios;

import java.util.ArrayList;
import java.util.Date;

/**
 * Proyecto de programación - Analisis de algoritmos
 * 
 * @author Cesar Marquez, Brian Giraldo, Esteban Sanchez
 *
 */
public class Anfitrion extends Usuario {

	private ArrayList<String> hospedajes = new ArrayList<String>();

	/**
	 * Metodo constructor de la clase
	 * 
	 * @param nombre
	 * @param email
	 * @param uRLFoto
	 * @param direccion
	 * @param fechaNacimiento
	 * @param contrasenia
	 * @param biografia
	 * @param nametag
	 */
	public Anfitrion(String nombre, String email, String uRLFoto, String direccion, Date fechaNacimiento,
			String contrasenia, String biografia, String nametag) {
		super(nombre, email, uRLFoto, direccion, fechaNacimiento, contrasenia, biografia, nametag);

	}

	/**
	 * Metodo constructor de la clase
	 * 
	 * @param nombre
	 * @param email
	 * @param direccion
	 * @param fechaNacimiento
	 * @param contrasenia
	 * @param biografia
	 * @param nametag
	 */
	public Anfitrion(String nombre, String email, String direccion, Date fechaNacimiento, String contrasenia,
			String biografia, String nametag) {
		super(nombre, email, direccion, fechaNacimiento, contrasenia, biografia, nametag);

	}

	public ArrayList<String> getHospedajes() {
		return hospedajes;
	}

	public void agregarHospedaje(String id) {
		hospedajes.add(id);
	}

}
