package com.resonance.hospedajes;

import java.util.ArrayList;

public class Apartamento extends Hospedaje
{
	private int numeroHabitaciones;
	private int banios;
	private int camas;
	private int numeroHuespedes;
	
	public Apartamento(String id, String direccion, double precio, String nameTagPropietario,
			ArrayList<String> urlsFotos, String descripcion, int numeroHabitaciones, int banios, int camas, int numeroHuespedes, Servicios servicios) 
	{
		super(id, direccion, precio, nameTagPropietario, urlsFotos, descripcion, servicios);
		
		this.banios = banios;
		this.camas = camas;
		this.numeroHabitaciones = numeroHabitaciones;
		this.numeroHuespedes = numeroHuespedes;
		
	}
	
}
