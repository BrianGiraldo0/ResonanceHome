package com.resonance.model.hospedajes;

import java.util.ArrayList;
import java.util.Date;

import com.resonance.model.util.Fecha;

public class Hospedaje {

	private Prestacion prestaciones;
	public String id = "";
	public Direccion direccion;
	private String titulo;
	public double precio = 0;
	public ArrayList<Date> fechasReservadas = new ArrayList<Date>();
	public String nameTagPropietario = "";
	public ArrayList<String> urlsFotos = new ArrayList<String>();
	public String descripcion = "";
	public Plus servicios;
	private TipoHospedaje tipoHospedaje;
	private ArrayList<Calificacion> calificaciones = new ArrayList<Calificacion>();

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

	/**
	 * Método que hace las operaciones necesarias al cambiar de día
	 * 
	 * @param fecha
	 */
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
	 * Método que obtiene el promedio de calificaciones con respecto a la limpieza
	 * 
	 * @return
	 */
	public double obtenerPromedioLimpieza() {
		double promedio = 0;
		for (int i = 0; i < calificaciones.size(); i++) {
			promedio += calificaciones.get(i).getLimpieza();
		}

		return promedio / calificaciones.size();
	}

	/**
	 * Método que obtiene el promedio de calificaciones con respecto a la atención
	 * del anfitrion
	 * 
	 * @return
	 */
	public double obtenerPromedioAtencion() {
		double promedio = 0;
		for (int i = 0; i < calificaciones.size(); i++) {
			promedio += calificaciones.get(i).getAtencion();
		}

		return promedio / calificaciones.size();
	}

	/**
	 * Método que obtiene el promedio de calificaciones con respecto al
	 * profesionalismo del anfitrion
	 * 
	 * @return
	 */
	public double obtenerPromedioProfesionalismo() {
		double promedio = 0;
		for (int i = 0; i < calificaciones.size(); i++) {
			promedio += calificaciones.get(i).getProfesionalismoAnfitrion();
		}

		return promedio / calificaciones.size();
	}

	/**
	 * Método que obtiene el promedio de calificaciones con respecto a la ubicacion
	 * 
	 * @return
	 */
	public double obtenerPromedioUbicacion() {
		double promedio = 0;
		for (int i = 0; i < calificaciones.size(); i++) {
			promedio += calificaciones.get(i).getUbicacion();
		}

		return promedio / calificaciones.size();
	}

	/**
	 * Método que obtiene el promedio de calificaciones del hospedaje
	 * 
	 * @return
	 */
	public double obtenerPromedioCalificaciones() {
		double promedio = 0;
		promedio = obtenerPromedioAtencion() + obtenerPromedioUbicacion() + obtenerPromedioLimpieza()
				+ obtenerPromedioProfesionalismo();

		return promedio / 4;
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

	/**
	 * @return the prestaciones
	 */
	public Prestacion getPrestaciones() {
		return prestaciones;
	}

	/**
	 * @param prestaciones the prestaciones to set
	 */
	public void setPrestaciones(Prestacion prestaciones) {
		this.prestaciones = prestaciones;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the servicios
	 */
	public Plus getServicios() {
		return servicios;
	}

	/**
	 * @param servicios the servicios to set
	 */
	public void setServicios(Plus servicios) {
		this.servicios = servicios;
	}

	/**
	 * @param fechasReservadas the fechasReservadas to set
	 */
	public void setFechasReservadas(ArrayList<Date> fechasReservadas) {
		this.fechasReservadas = fechasReservadas;
	}

	/**
	 * @param tipoHospedaje the tipoHospedaje to set
	 */
	public void setTipoHospedaje(TipoHospedaje tipoHospedaje) {
		this.tipoHospedaje = tipoHospedaje;
	}

}
