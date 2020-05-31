package com.resonance.model.txt;

public class Tarjeta {

	private int numeroT;
	private String duenio;
	private String codigoSeguridad;
	private String fechaExpiracion;
	private String cedulaDuenio;
	
	/**
	 * Metodo constructor
	 * @param numeroT
	 * @param saldo
	 * @param duenio
	 */
	public Tarjeta(int numeroT, String duenio, String codigoSeguridad, String fechaExpiracion, String cedulaDuenio) {
		super();
		this.numeroT = numeroT;
		this.duenio = duenio;
		this.cedulaDuenio = cedulaDuenio;
		this.codigoSeguridad = codigoSeguridad;
		this.fechaExpiracion = fechaExpiracion;
	}
	
	/*
	 * Inicio de getters y setters
	 */
	
	public int getNumeroT() {
		return numeroT;
	}
	public void setNumeroT(int numeroT) {
		this.numeroT = numeroT;
	}
	
	public String getDuenio() {
		return duenio;
	}
	public void setDuenio(String duenio) {
		this.duenio = duenio;
	}

	public String getCodigoSeguridad() {
		return codigoSeguridad;
	}

	public void setCodigoSeguridad(String codigoSeguridad) {
		this.codigoSeguridad = codigoSeguridad;
	}

	public String getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(String fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public String getCedulaDuenio() {
		return cedulaDuenio;
	}

	public void setCedulaDuenio(String cedulaDuenio) {
		this.cedulaDuenio = cedulaDuenio;
	}
	
	/*
	 * Fin de getters y setters
	 */
	
}
