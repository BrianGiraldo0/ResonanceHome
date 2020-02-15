package com.resonance.hospedajes;

import java.sql.Date;
import java.util.ArrayList;


public class Reserva {

	public String idHospedaje="";
	public String nameTagHuesped="";
	public ArrayList<Date> fechaReservada;
	
	/**
	 * Metodo constructor
	 * @param idHospedaje
	 * @param nameTagHuesped
	 * @param fechaReservada
	 */
	public Reserva(String idHospedaje, String nameTagHuesped) {
		super();
		this.idHospedaje = idHospedaje;
		this.nameTagHuesped = nameTagHuesped;
	}

	/**
	 * Metodo que retorna la id del hospedaje
	 * @return
	 */
	public String getIdHospedaje() {
		return idHospedaje;
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
	
	
}
