package com.resonance.hospedajes;

import java.util.ArrayList;
import java.util.Date;

public class Hospedaje {

	public String id ="";
	public String direccion="";
	public double precio=0;
	public ArrayList<Date> fechasReservadas=new ArrayList<Date>();
	public String nameTagPropietario="";
	public ArrayList<String> urlsFotos= new ArrayList<String>();
    public String descripcion="";
    public Servicios servicios;
    
    /**
     * Metodo constructor de la clase
     * @param direccion
     * @param precio
     * @param nameTagPropietario
     * @param urlsFotos
     * @param descripcion
     */
	public Hospedaje(String id, String direccion, double precio, String nameTagPropietario, ArrayList<String> urlsFotos,
			String descripcion, Servicios servicios) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.precio = precio;
		this.nameTagPropietario = nameTagPropietario;
		this.urlsFotos = urlsFotos;
		this.descripcion = descripcion;
		this.servicios = servicios;
	}
	
	/**
	 * Metodo que obtiene el id
	 * @return
	 */
	public String getId() {
		return id;
	}


	/**
	 * Metodo que cambia el id
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * Metodo que cambia la direccion
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Metodo que cambia la descripcion
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Metodo que retorna el precio del hospedaje por dia
	 * @return
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Metodo que cambia el precio del hospedaje
	 * @param precio
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Metodo que retorna la direccion del hospedaje
	 * @return
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Metodo que retorna las fechas reservadas del hospedaje
	 * @return
	 */
	public ArrayList<Date> getFechasReservadas() {
		return fechasReservadas;
	}

	/**
	 * Metodo que retorna el nombre de usuario del propietario
	 * @return
	 */
	public String getNameTagPropietario() {
		return nameTagPropietario;
	}
    
	/**
	 * Metodo que retorna las direcciones de las fotos
	 * @return
	 */
	public ArrayList<String> getUrlsFotos() {
		return urlsFotos;
	}

	/**
	 * Metodo que retorna una breve descripcion del hospedaje
	 * @return
	 */
	public String getDescripcion() {
		return descripcion;
	}
    
	/**
	 * Metodo que anade una fecha reservada
	 * @param fecha
	 */
	public void anadirFechaReservada(Date fecha)
	{
		fechasReservadas.add(fecha);
	}

	/**
	 * Metodo que anade las fotos del hospedaje
	 * @param urlsFotos
	 */
	public void setUrlsFotos(ArrayList<String> urlsFotos) {
		this.urlsFotos = urlsFotos;
	}
	
}
