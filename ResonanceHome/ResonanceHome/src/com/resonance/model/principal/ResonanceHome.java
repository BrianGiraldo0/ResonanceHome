package com.resonance.model.principal;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import com.resonance.model.excepciones.NoExistException;
import com.resonance.model.hospedajes.Direccion;
import com.resonance.model.hospedajes.Hospedaje;
import com.resonance.model.hospedajes.Plus;
import com.resonance.model.hospedajes.Prestacion;
import com.resonance.model.hospedajes.TipoHospedaje;
import com.resonance.model.usuarios.Anfitrion;
import com.resonance.model.usuarios.Huesped;
import com.resonance.model.util.Util;

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

	/**
	 * Metodo que permite agregar un hospedaje a la lista global de hospedajes
	 * @param direccion
	 * @param precio
	 * @param nameTagPropietario
	 * @param urlsFotos
	 * @param descripcion
	 * @param servicios
	 * @param tipoH
	 */
	public void agregarHospedaje(Direccion direccion, double precio, String nameTagPropietario,
			ArrayList<String> urlsFotos, String descripcion, Plus servicios, TipoHospedaje tipoH, Prestacion prestaciones) throws NoExistException {
		
		
		if(anfitriones.get(nameTagPropietario) != null) {
			String id = Util.generarIDHospedaje();
			Hospedaje hosp = new Hospedaje(id, direccion, precio, nameTagPropietario, urlsFotos, descripcion, servicios,
					tipoH, prestaciones);
			anfitriones.get(nameTagPropietario).agregarHospedaje(id);
			Util.agregarSugerencia(direccion.toString());
			hospedajes.put(id, hosp);
		}else {
			throw new NoExistException();		}
	}
	
	/**
	 * Metodo que agrega un anfitrion a la lista
	 * @param nombre
	 * @param email
	 * @param uRLFoto
	 * @param direccion
	 * @param fechaNacimiento
	 * @param contrasenia
	 * @param biografia
	 * @param nametag
	 */
	public void agregarAnfitrion(String nombre, String email, String uRLFoto, String direccion, Date fechaNacimiento,
			String contrasenia, String biografia, String nametag) {
		Anfitrion anfitrion;
		if(uRLFoto == null || uRLFoto.equals("")) {
			anfitrion = new Anfitrion(nombre, email, direccion, fechaNacimiento, contrasenia, biografia, nametag);
		}else {
			anfitrion = new Anfitrion(nombre, email, uRLFoto, direccion, fechaNacimiento, contrasenia, biografia, nametag);
		}
		anfitriones.put(nametag, anfitrion);
		
	}
	
	/**
	 * Metodo que permite agregar un huesped a la lista
	 * @param nombre
	 * @param email
	 * @param uRLFoto
	 * @param direccion
	 * @param fechaNacimiento
	 * @param contrasenia
	 * @param biografia
	 * @param nametag
	 */
	public void agregarHuesped(String nombre, String email, String uRLFoto, String direccion, Date fechaNacimiento,
			String contrasenia, String biografia, String nametag) {
		Huesped huesped;
		if(uRLFoto == null || uRLFoto.equals("")) {
			huesped = new Huesped(nombre, email, direccion, fechaNacimiento, contrasenia, biografia, nametag);
		}else {
			huesped = new Huesped(nombre, email, uRLFoto, direccion, fechaNacimiento, contrasenia, biografia, nametag);
		}
		huespedes.put(nametag, huesped);
		
	}
	
	
	/**
	 * Metodo que permite obtener todos los hospedajes que pasan por el primer filtro
	 * @param fecha
	 * @param ciudadDestino
	 * @param cantidadHuespedes
	 * @return
	 */
	public ArrayList<Hospedaje> obtenerHospedajes(ArrayList<Date> fecha, String ciudadDestino, int cantidadHuespedes )
	{
		ArrayList<Hospedaje> resultado= new ArrayList<Hospedaje>();
		
		Iterator<String> keys = hospedajes.keySet().iterator();
		while(keys.hasNext())
		{
			String key = keys.next();
			Hospedaje h = hospedajes.get(key);
			
			if(h.getCiudad().equalsIgnoreCase(ciudadDestino))
			{
				if(h.getPrestaciones().getNumHuesped() >= cantidadHuespedes)
				{
					if(h.disponibleEnFecha(fecha))
					{
						resultado.add(h);
					}
				}
			}
		}
		
		
		return resultado;
	}
	
	
	/**
	 * Metodo que permite filtrar hopedajes dependiendo de una serie de especificaciones
	 * @param hospedajesF
	 * @param tipoH
	 * @param valorMin
	 * @param valorMax
	 * @return
	 */
	public ArrayList<Hospedaje> filtarHospedajes(ArrayList<Hospedaje> hospedajesF, TipoHospedaje tipoH, double valorMin, double valorMax)
	{
		ArrayList<Hospedaje> resultado= new ArrayList<Hospedaje>();
	
		for(int i=0;i<hospedajesF.size();i++)
		{
			Hospedaje hAux = hospedajesF.get(i);
			if(hAux.getTipoHospedaje() == tipoH)
			{
				if(hAux.getPrecio() > valorMin && hAux.getPrecio() < valorMax) {
					
					resultado.add(hAux);
				}
			}
		}
		return resultado;
	}
	
}
