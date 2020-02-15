package com.resonance.hospedajes;

import java.util.ArrayList;
import java.util.Date;

public class Hospedaje {

	public String id="";
	public String direccion="";
	public double precio=0;
	public ArrayList<Date> fechasReservadas=new ArrayList<Date>();
	public String nameTagPropietario="";
	public ArrayList<String> urlsFotos= new ArrayList<String>();
	public TipoHospejade tipoHospedaje;
	public int maxPersonas=0;
	public int banios=0;
    public String descripcion="";
    
    /**
     * Metodo constructor de la clase
     * @param id
     * @param direccion
     * @param precio
     * @param nameTagPropietario
     * @param urlsFotos
     * @param tipoHospedaje
     * @param maxPersonas
     * @param banios
     * @param descripcion
     */
	public Hospedaje(String id, String direccion, double precio, String nameTagPropietario, ArrayList<String> urlsFotos,
			TipoHospejade tipoHospedaje, int maxPersonas, int banios, String descripcion) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.precio = precio;
		this.nameTagPropietario = nameTagPropietario;
		this.urlsFotos = urlsFotos;
		this.tipoHospedaje = tipoHospedaje;
		this.maxPersonas = maxPersonas;
		this.banios = banios;
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
	 * Metodo que retorna el numero de identificacion del hospedaje
	 * @return
	 */
	public String getId() {
		return id;
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
	 * Metodo que retorna el tipo de hospedaje
	 * @return
	 */
	public TipoHospejade getTipoHospedaje() {
		return tipoHospedaje;
	}

	public int getMaxPersonas() {
		return maxPersonas;
	}

	/**
	 * Metodo que retorna el numero de baños que tiene el hospedaje
	 * @return
	 */
	public int getBanios() {
		return banios;
	}

	/**
	 * Metodo que retorna una breve descripcion del hospedaje
	 * @return
	 */
	public String getDescripcion() {
		return descripcion;
	}
    
	
    
	
	
}
