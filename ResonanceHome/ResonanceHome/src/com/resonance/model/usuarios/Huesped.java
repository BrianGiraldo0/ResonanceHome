package com.resonance.model.usuarios;

import java.util.ArrayList;
import java.util.Date;

import com.resonance.model.hospedajes.Reserva;
import com.resonance.model.txt.Tarjeta;
import com.resonance.model.util.Fecha;

public class Huesped extends Usuario{
	
	private ArrayList <Reserva> reservas = new ArrayList<Reserva>();	
	private ArrayList <Reserva> favoritos = new ArrayList<Reserva>();
	private Tarjeta tarjeta;
	

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
		
		reservas.add(reserva);
	}
	
	
	
	/**
	 * Agrega reserva a favoritos  de un hospedaje
	 * @param reserva Reserva reserva en favoritos
	 */
	public void agregarReservaFavorito(Reserva reserva) {
		
		favoritos.add(reserva);
	}
	
	
	/**
	 * 
	 * Elimina reserva de un hospedaje
	 * @param reserva reserva a eliminar
	 */
	public void eliminarReserva (Reserva reserva) {
		
		if (reservas.size()!=0) {
		reservas.remove(reserva);
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
		
		if (reservas.size()!=0) {

			for (int i=0; i<reservas.size();i++) {
				
				Reserva miR = reservas.get(i);
				
				if (miR.verificarDiaReserva(fecha)) {
					
					reservasPorDia.add(miR);
					
				}	
			}
		}

		return reservasPorDia;

	}

	/* Inicio de Getters y Setters 
	
	*/
	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
	
	
	public void update(Fecha fecha)
	{
		for (int i = 0; i < reservas.size(); i++) {
			reservas.get(i).update(fecha);
		}
	}

	public ArrayList<Reserva> getReservas() {
		return reservas;
	}
	
	public ArrayList<Reserva> getFavoritos() {
		return favoritos;
	}
	
	
	
	/* Fin de Getters y Setters
	*/

}
