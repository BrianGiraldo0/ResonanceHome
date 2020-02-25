package com.resonance.principal;

import java.util.ArrayList;
import java.util.HashMap;

import com.resonance.excepciones.NoExistException;
import com.resonance.hospedajes.Hospedaje;
import com.resonance.hospedajes.Servicio;
import com.resonance.hospedajes.TipoHospedaje;
import com.resonance.usuarios.Anfitrion;
import com.resonance.usuarios.Huesped;

public class ResonanceHome {

	private HashMap<String, Huesped> huespedes = new HashMap<String, Huesped>();
	private HashMap<String, Anfitrion> anfitriones = new HashMap<String, Anfitrion>();
	private HashMap<String, Hospedaje> hospedajes = new HashMap<String, Hospedaje>();

	/**
	 * Metodo constructor de la clase principal
	 */
	public ResonanceHome() {

	}

	/**
	 * Metodo que obtiene un huesped mediante su nombre de usuario
	 * 
	 * @param nametag
	 * @return
	 * @throws NoExistException
	 */
	public Huesped obtenerHuesped(String nametag) throws NoExistException {
		if (huespedes.get(nametag) == null) {
			throw new NoExistException();
		} else {
			return huespedes.get(nametag);
		}

	}

	/**
	 * Metodo que obtiene un anfitrion mediante su nombre de usuario
	 * 
	 * @param nametag
	 * @return
	 * @throws NoExistException
	 */
	public Anfitrion obtenerAnfitrion(String nametag) throws NoExistException {
		if (anfitriones.get(nametag) == null) {
			throw new NoExistException();
		} else {
			return anfitriones.get(nametag);
		}

	}

	/**
	 * Metodo que obtiene un hospedaje mediante su nombre
	 * 
	 * @param name
	 * @return
	 * @throws NoExistException
	 */
	public Hospedaje obtenerHospedaje(String name) throws NoExistException {
		if (hospedajes.get(name) == null) {
			throw new NoExistException();
		} else {
			return hospedajes.get(name);
		}

	}

	public void agregarHospedaje(String direccion, double precio, String nameTagPropietario,
			ArrayList<String> urlsFotos, String descripcion, Servicio servicios, TipoHospedaje tipoH) {
		String id = "";
		Hospedaje hosp = new Hospedaje(id, direccion, precio, nameTagPropietario, urlsFotos, descripcion, servicios,
				tipoH);
	}
}
