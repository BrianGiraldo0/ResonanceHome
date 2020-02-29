package com.resonance.txt;

import java.util.ArrayList;

import com.resonance.excepciones.NoExistException;


public class Chat {

	private String emisor;
	private String receptor;
	private ArrayList<Mensaje> mensajes;
	
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
		this.mensajes = mensaje;
	}

	/**
	 * Metodo que permite agregar un mensaje al chat
	 * @param mensaje
	 * @throws NoExistException
	 */
	public void agregarMensaje(Mensaje mensaje) throws NoExistException
	{
		if(mensaje !=null)
		{
			mensajes.add(mensaje);
		}else {
			throw new NoExistException();
		}
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
		return mensajes;
	}

	public void setMensaje(ArrayList<Mensaje> mensaje) {
		this.mensajes = mensaje;
	}
	
	/*
	 * Fin de setters y getters
	 */
	
	
	
	
}
