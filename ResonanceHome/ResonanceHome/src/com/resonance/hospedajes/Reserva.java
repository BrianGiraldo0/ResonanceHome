package com.resonance.hospedajes;


import java.util.ArrayList;
import java.util.Date;


public class Reserva {

	public Hospedaje hospedaje;
	public String nameTagHuesped="";
	public ArrayList<Date> fechaReservada;
	
	
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
	
	
	
	
	public boolean verificarDiaReserva (Date fecha) {
		
		
		for (int i=0; i<fechaReservada.size();i++) {
			
			if (fechaReservada.get(i).compareTo(fecha)==0) {
				return true;
			}
			
		}
		return false;
	}
	
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
	
	
}
