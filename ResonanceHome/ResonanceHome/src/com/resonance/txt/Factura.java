package com.resonance.txt;

import com.resonance.hospedajes.Reserva;

public class Factura {

	private String anfitrion;
	private String huesped;
	private Reserva reserva;
	private Tarjeta tarjeta;
	
	/**
	 * Metodo constructor
	 * @param anfitrion
	 * @param huesped
	 * @param reserva
	 * @param tarjeta
	 */
	public Factura(String anfitrion, String huesped, Reserva reserva, Tarjeta tarjeta) {
		super();
		this.anfitrion = anfitrion;
		this.huesped = huesped;
		this.reserva = reserva;
		this.tarjeta = tarjeta;
	}

	/*
	 * incio de getters and setters
	 */
	
	public String getAnfitrion() {
		return anfitrion;
	}

	public void setAnfitrion(String anfitrion) {
		this.anfitrion = anfitrion;
	}

	public String getHuesped() {
		return huesped;
	}

	public void setHuesped(String huesped) {
		this.huesped = huesped;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
	
	/*
	 * fin de getters and setters
	 */
	
	
}
