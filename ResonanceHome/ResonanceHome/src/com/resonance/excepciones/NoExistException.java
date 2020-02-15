package com.resonance.excepciones;

public class NoExistException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoExistException()
	{
		super("No existe ningún resultado con el nombre ingresado.");
	}
}
