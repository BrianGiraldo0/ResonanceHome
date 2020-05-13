package com.resonance.model.hospedajes;

import java.util.ArrayList;
import java.util.Date;

import com.resonance.model.util.Fecha;

public class Hospedaje {

	private Prestacion prestaciones;
	public String id = "";
	public Direccion direccion;
	public double precio = 0;
	public ArrayList<Date> fechasReservadas = new ArrayList<Date>();
	public String nameTagPropietario = "";
	public ArrayList<String> urlsFotos = new ArrayList<String>();
	public String descripcion = "";
	public Plus servicios;
	private TipoHospedaje tipoHospedaje;

	/**
	 * Metodo constructor de la clase
	 * 
	 * @param direccion
	 * @param precio
	 * @param nameTagPropietario
	 * @param urlsFotos
	 * @param descripcion
	 */
	public Hospedaje(String id, Direccion direccion, double precio, String nameTagPropietario, ArrayList<String> urlsFotos,
			String descripcion, Plus servicios, TipoHospedaje tipoH, Prestacion prestaciones) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.precio = precio;
		this.nameTagPropietario = nameTagPropietario;
		this.urlsFotos = urlsFotos;
		this.descripcion = descripcion;
		this.servicios = servicios;
		this.tipoHospedaje = tipoH;
		this.setPrestaciones(prestaciones);
	}

	/**
	 * Metodo que verifica que un hospedaje esta disponible en unas fechas ingresadas
	 * @param fecha
	 * @return
	 */
	public boolean disponibleEnFecha(ArrayList<Date> fecha)
	{
		for(int i=0;i<fechasReservadas.size();i++) {
			for(int j=0;j<fecha.size();j++) {
				if(fechasReservadas.get(i).compareTo(fecha.get(j)) == 0)
				{
					return false;	
				}
			}
		}
		
		return true;
	}
	public void update(Fecha fecha)
	{
		for (int i = 0; i < fechasReservadas.size(); i++) {
			if(fecha.isMayor(fechasReservadas.get(i)))
			{
				fechasReservadas.remove(i);
			}
		}
	}
	/**
	 * Metodo que obtiene el id
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * Metodo que cambia el id
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Metodo que cambia la direccion
	 * 
	 * @param direccion
	 */
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	/**
	 * Metodo que cambia la descripcion
	 * 
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Metodo que retorna el precio del hospedaje por dia
	 * 
	 * @return
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Metodo que cambia el precio del hospedaje
	 * 
	 * @param precio
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Metodo que retorna la direccion del hospedaje
	 * 
	 * @return
	 */
	public Direccion getDireccion() {
		return direccion;
	}

	/**
	 * Metodo que retorna las fechas reservadas del hospedaje
	 * 
	 * @return
	 */
	public ArrayList<Date> getFechasReservadas() {
		return fechasReservadas;
	}

	/**
	 * Metodo que retorna el nombre de usuario del propietario
	 * 
	 * @return
	 */
	public String getNameTagPropietario() {
		return nameTagPropietario;
	}

	/**
	 * Metodo que retorna las direcciones de las fotos
	 * 
	 * @return
	 */
	public ArrayList<String> getUrlsFotos() {
		return urlsFotos;
	}

	/**
	 * Metodo que retorna una breve descripcion del hospedaje
	 * 
	 * @return
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Metodo que anade una fecha reservada
	 * 
	 * @param fecha
	 */
	public void anadirFechaReservada(Date fecha) {
		fechasReservadas.add(fecha);
	}

	/**
	 * Metodo que anade las fotos del hospedaje
	 * 
	 * @param urlsFotos
	 */
	public void setUrlsFotos(ArrayList<String> urlsFotos) {
		this.urlsFotos = urlsFotos;
	}

	/**
	 * Metodo que retorna el tipo de hospedaje
	 * 
	 * @return
	 */
	public TipoHospedaje getTipoHospedaje() {
		return tipoHospedaje;
	}
	
	public String getCiudad()
	{
		return direccion.getCiudad();
	}

	public Prestacion getPrestaciones() {
		return prestaciones;
	}

	public void setPrestaciones(Prestacion prestaciones) {
		this.prestaciones = prestaciones;
	}

}
