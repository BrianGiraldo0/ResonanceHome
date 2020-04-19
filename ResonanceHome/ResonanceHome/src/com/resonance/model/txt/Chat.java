package com.resonance.model.txt;

import java.util.ArrayList;

import com.resonance.model.excepciones.NoExistException;


public class Chat {

	private String huesped;
	private String anfitrion;
	private ArrayList<Mensaje> mensajes;
	
	/**
	 * Metodo constructor de la clase
	 * @param emisor
	 * @param receptor
	 * @param mensaje
	 */
	public Chat(String emisor, String receptor, ArrayList<Mensaje> mensaje) {
		super();
		this.huesped = emisor;
		this.anfitrion = receptor;
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
		return huesped;
	}

	public void setEmisor(String emisor) {
		this.huesped = emisor;
	}

	public String getReceptor() {
		return anfitrion;
	}

	public void setReceptor(String receptor) {
		this.anfitrion = receptor;
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
	
	public boolean esta(String name)
	{
		if(name.equals(anfitrion))
		{
			return true;
		}else if(name.equals(huesped))
		{
			return true;
		}
		
		
		return false;
	}
	
	
}
