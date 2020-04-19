package com.resonance.model.txt;

import java.io.File;

import com.resonance.model.archivos.FileManager;
import com.resonance.model.hospedajes.Reserva;

public class Factura {

	private String anfitrion;
	private String huesped;
	private Reserva reserva;
	private Tarjeta tarjeta;
	private File facturaURL;
	
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
		this.facturaURL = new File(FileManager.urlMain + "/Usuarios/Huespedes/Facturas" + huesped+".pdf");
	}
	
	
	public double calcularPrecioReserva() {
		
		double precioNocheHospedaje = reserva.getIdHospedaje().getPrecio();
		int diasReserva = reserva.getFechaReservada().size();
		double precioSinImpuestos = precioNocheHospedaje * diasReserva;
		double impuestoLimpieza = precioSinImpuestos * 0.05;
		double impuestoPlataforma = precioSinImpuestos * 0.15;
		
		
		return precioSinImpuestos + impuestoLimpieza + impuestoPlataforma;
		
		
		
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
	
	public File getFacturaURL()
	{
		return facturaURL;
	}
	/*
	 * fin de getters and setters
	 */
	
	
}
