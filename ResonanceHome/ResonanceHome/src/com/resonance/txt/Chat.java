package com.resonance.txt;

import java.util.ArrayList;


public class Chat {

	private String emisor;
	private String receptor;
	private ArrayList<Mensaje> mensaje;
	
	/**
	 * Metodo constructor de la clase
	 * @param emisor
	 * @param receptor
	 * @param mensaje
	 */
	public Chat(String emisor, String receptor, ArrayList<Mensaje> mensaje) {
		super();
		this.emisor = emisor;
		this.receptor = receptor;
		this.mensaje = mensaje;
	}

	
	/*
	 * Inicio de setters y getters
	 */
	
	public String getEmisor() {
		return emisor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	public String getReceptor() {
		return receptor;
	}

	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}

	public ArrayList<Mensaje> getMensaje() {
		return mensaje;
	}

	public void setMensaje(ArrayList<Mensaje> mensaje) {
		this.mensaje = mensaje;
	}
	
	/*
	 * Fin de setters y getters
	 */
	
	
	
	
}