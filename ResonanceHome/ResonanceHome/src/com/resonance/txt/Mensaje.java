package com.resonance.txt;

import java.sql.Date;

public class Mensaje {

	private String mensaje;
	private Date fecha;
	private String emisor;
	
	/**
	 * Metodo constructor de la clase
	 * @param mensaje
	 * @param fecha
	 * @param emisor
	 */
	public Mensaje(String mensaje, Date fecha, String emisor) {

		this.mensaje = mensaje;
		this.fecha = fecha;
		this.emisor = emisor;
	}

	
	
	/*
	 * Inicio de setters y getters
	 */
	
	public String getMensaje() {
		return mensaje;
	}

	public Date getFecha() {
		return fecha;
	}

	public String getEmisor() {
		return emisor;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	/*
	 * Fin de setters y getters
	 */
	
	
	
	
	
	
}
