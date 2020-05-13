package com.resonance.model.hospedajes;


import java.util.ArrayList;
import java.util.Date;

import com.resonance.model.usuarios.EstadoCivil;
import com.resonance.model.usuarios.Estrato;
import com.resonance.model.usuarios.Genero;
import com.resonance.model.usuarios.NivelEstudio;
import com.resonance.model.util.Fecha;


public class Reserva {

	private Hospedaje hospedaje;
	private String nameTagHuesped="";
	private ArrayList<Date> fechaReservada;
	private boolean vencido=false;
	private String identificacion;
	private Genero genero;
	private NivelEstudio estudio;
	private Estrato estrato;
	private EstadoCivil estado;
	private String nombre;
	private String direccion;
	private String correo;
	
	
	
	/**
	 * Metodo constructor
	 * @param hospedaje
	 * @param nameTagHuesped
	 * @param fechaReservada
	 */
	public Reserva(Hospedaje hospedaje, String nameTagHuesped) {
		super();
		this.hospedaje = hospedaje;
		this.nameTagHuesped = nameTagHuesped;
	}
	
	/**
	 *	Metodo constructor
	 * 
	 * @param hospedaje 
	 * @param nameTagHuesped
	 * @param identificacion
	 * @param genero
	 * @param estudio
	 * @param estrato
	 * @param nombre
	 * @param direccion
	 * @param correo
	 */
	
	
	public Reserva(Hospedaje hospedaje, String nameTagHuesped, String identificacion, Genero genero,
			NivelEstudio estudio, Estrato estrato, String nombre, String direccion, String correo, EstadoCivil estado) {
		super();
		this.hospedaje = hospedaje;
		this.nameTagHuesped = nameTagHuesped;
		this.identificacion = identificacion;
		this.genero = genero;
		this.estudio = estudio;
		this.estrato = estrato;
		this.nombre = nombre;
		this.direccion = direccion;
		this.correo = correo;
		this.estado = estado;
	}


	public void update(Fecha fecha)
	{
		if(fecha.isMayor(getFechaFinal()))
		{
			hospedaje.update(fecha);
			vencido=true;
			//Invocar aquí para enviar el correo
	
		}
		
	}


	public boolean verificarDiaReserva (Date fecha) {
		
		
		for (int i=0; i<fechaReservada.size();i++) {
			
			if (fechaReservada.get(i).compareTo(fecha)==0) {
				return true;
			}
			
		}
		return false;
	}
	
	
	
	/*
	 * Inicio de Getters y Setters
	 */
	
	
	
	
	/**
	 * Metodo que retorna el hospedaje
	 * @return
	 */
	public Hospedaje getIdHospedaje() {
		return hospedaje;
	}
	
	/**
	 * Metodo que retorna el nametag el huesped que reservo
	 * @return
	 */
	public String getNameTagHuesped() {
		return nameTagHuesped;
	}

	/**
	 * Metodo que retorna las fechas reservadas
	 * @return
	 */
	public ArrayList<Date> getFechaReservada() {
		return fechaReservada;
	}

	/**
	 * Metodo que selecciona la fechas reservadas
	 * @param fechaReservada
	 */
	public void setFechaReservada(ArrayList<Date> fechaReservada) {
		this.fechaReservada = fechaReservada;
	}



	public Hospedaje getHospedaje() {
		return hospedaje;
	}



	public void setHospedaje(Hospedaje hospedaje) {
		this.hospedaje = hospedaje;
	}




	public String getIdentificacion() {
		return identificacion;
	}



	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}




	public Genero getGenero() {
		return genero;
	}




	public void setGenero(Genero genero) {
		this.genero = genero;
	}



	public NivelEstudio getEstudio() {
		return estudio;
	}


	public void setEstudio(NivelEstudio estudio) {
		this.estudio = estudio;
	}


	public Estrato getEstrato() {
		return estrato;
	}

	public void setEstrato(Estrato estrato) {
		this.estrato = estrato;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public EstadoCivil getEstado() {
		return estado;
	}

	public void setEstado(EstadoCivil estado) {
		this.estado = estado;
	}

	public boolean isVencido() {
		return vencido;
	}
	
	public Date getFechaInicial()
	{
		return fechaReservada.get(0);
	}
	
	public Date getFechaFinal()
	{
		return fechaReservada.get(fechaReservada.size()-1);
	}
	
	
	
	
	
	
	/*
	 * Fin de Getters y Setters
	 */
	
	
	
}
