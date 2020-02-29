package com.resonance.usuarios;

import java.util.ArrayList;
import java.util.Date;

import com.resonance.hospedajes.Reserva;

public class Huesped extends Usuario{
	
	ArrayList <Reserva> misReservas = new ArrayList<Reserva>();	

	public Huesped(String nombre, String email, String uRLFoto, String direccion, Date fechaNacimiento,
			String contrasenia, String biografia, String nametag) {
		super(nombre, email, uRLFoto, direccion, fechaNacimiento, contrasenia, biografia, nametag);
		
		
		
	}
	
	public Huesped(String nombre, String email, String direccion, Date fechaNacimiento,
			String contrasenia, String biografia, String nametag) {
		super(nombre, email, direccion, fechaNacimiento, contrasenia, biografia, nametag);
		
	}
	
	/**
	 * Agrega reserva de un hospedaje
	 * @param reserva Reserva realizada
	 */
	public void agregarReserva(Reserva reserva) {
		
		misReservas.add(reserva);
	}
	
	/**
	 * 
	 * Elimina reserva de un hospedaje
	 * @param reserva reserva a eliminar
	 */
	public void eliminarReserva (Reserva reserva) {
		
		if (misReservas.size()!=0) {
		misReservas.remove(reserva);
		}
		
	}
	
	/**
	 * 
	 * Metodo que obtiene todas las reservas realizadas segun dia seleccionado
	 * @param fecha Fecha a buscar reservas
	 * @return listado de reservas que incluyen el dia seleccionado
	 */
	public ArrayList<Reserva> buscarReservasPorDia (Date fecha) {
		
		ArrayList<Reserva> reservasPorDia = new ArrayList<>();
		
		if (misReservas.size()!=0) {

			for (int i=0; i<misReservas.size();i++) {
				
				Reserva miR = misReservas.get(i);
				
				if (miR.verificarDiaReserva(fecha)) {
					
					reservasPorDia.add(miR);
					
				}	
			}
		}

		return reservasPorDia;
		
		
		
	}
	
	

}
