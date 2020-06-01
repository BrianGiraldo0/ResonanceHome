package com.resonance.model.util;

import java.util.ArrayList;

import com.resonance.model.usuarios.Huesped;

/**
 * Proyecto de programación - Analisis de algoritmos
 * 
 * @author Cesar Marquez, Brian Giraldo, Esteban Sanchez
 *
 */
public class ClienteEstadistica {

	private Huesped huesped;
	private ArrayList<String> ciudades;

	/**
	 * @param huesped
	 * @param ciudades
	 */
	public ClienteEstadistica(Huesped huesped, ArrayList<String> ciudades) {
		super();
		this.huesped = huesped;
		this.ciudades = ciudades;
	}

	public void agregarCiudad(String a) {
		ciudades.add(a);
	}
	/**
	 * @return the huesped
	 */
	public Huesped getHuesped() {
		return huesped;
	}

	/**
	 * @param huesped the huesped to set
	 */
	public void setHuesped(Huesped huesped) {
		this.huesped = huesped;
	}

	/**
	 * @return the ciudades
	 */
	public ArrayList<String> getCiudades() {
		return ciudades;
	}

	/**
	 * @param ciudades the ciudades to set
	 */
	public void setCiudades(ArrayList<String> ciudades) {
		this.ciudades = ciudades;
	}

}
