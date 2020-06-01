package com.resonance.model.excepciones;

/**
 * Proyecto de programación - Analisis de algoritmos
 * 
 * @author Cesar Marquez, Brian Giraldo, Esteban Sanchez
 *
 */
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
