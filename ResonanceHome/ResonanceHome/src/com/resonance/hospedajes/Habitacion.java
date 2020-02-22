package com.resonance.hospedajes;

import java.util.ArrayList;

public class Habitacion extends Hospedaje
{

	private int banios;
	private int camas;
	public Habitacion(String id, String direccion, double precio, String nameTagPropietario,
			ArrayList<String> urlsFotos, String descripcion, int banios, int camas, Servicios servicios) 
	{
		super(id, direccion, precio, nameTagPropietario, urlsFotos, descripcion, servicios);
		this.camas = camas;
		this.banios = banios;
	}

}
