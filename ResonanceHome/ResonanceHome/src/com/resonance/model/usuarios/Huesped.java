package com.resonance.model.usuarios;

import java.util.ArrayList;
import java.util.Date;

import com.resonance.model.hospedajes.Hospedaje;
import com.resonance.model.hospedajes.Reserva;
import com.resonance.model.txt.Mensaje;
import com.resonance.model.txt.Tarjeta;
import com.resonance.model.util.Fecha;

public class Huesped extends Usuario{
	
	private ArrayList <Reserva> reservas = new ArrayList<Reserva>();	
	private ArrayList <Hospedaje> favoritos = new ArrayList<>();
	private Tarjeta tarjeta;
	private ArrayList<Mensaje> comentarios = new ArrayList<Mensaje>();
	private Estrato estrato;
	private NivelEstudio nivelEstudio;
	

	public Huesped(String nombre, String email, String uRLFoto, String direccion, Date fechaNacimiento,
			String contrasenia, String biografia, String nametag, Estrato estrato, NivelEstudio nivelEstudio) {
		super(nombre, email, uRLFoto, direccion, fechaNacimiento, contrasenia, biografia, nametag);
		
		this.setEstrato(estrato);
		this.setNivelEstudio(nivelEstudio);
		
	}
	
	public Huesped(String nombre, String email, String direccion, Date fechaNacimiento,
			String contrasenia, String biografia, String nametag, Estrato estrato, NivelEstudio nivelEstudio) {
		super(nombre, email, direccion, fechaNacimiento, contrasenia, biografia, nametag);
		
		this.setEstrato(estrato);
		this.setNivelEstudio(nivelEstudio);
	}
	
	/**
	 * Agrega reserva de un hospedaje
	 * @param reserva Reserva realizada
	 */
	public void agregarReserva(Reserva reserva) {
		
		reservas.add(reserva);
	}
	
	public int getCantidadHospedajeReservado(String idHosp) {
		int can = 0;
		for (int i = 0; i < reservas.size(); i++) {
			if (reservas.get(i).getHospedaje().getId().equals(idHosp)) {
				can++;
			}
		}
		return can;
	}
	
	/**
	 * Agrega reserva a favoritos  de un hospedaje
	 * @param reserva Reserva reserva en favoritos
	 */
	public void agregarHospedajeFavorito(Hospedaje hospedaje) {
		
		boolean cen = false;
		
		for (int i=0; i<favoritos.size() && cen ==false;i++ ) {
			
			if (hospedaje.getId().equals(hospedaje.getId())) {
					
				cen = true;
				
			}
			
			
		}
		if (cen==false) {
			favoritos.add(hospedaje);
		}
		
		
		
		
		
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
	
	public ArrayList<Hospedaje> getFavoritos() {
		return favoritos;
	}

	public ArrayList<Mensaje> getComentarios() {
		return comentarios;
	}

	public void setComentarios(ArrayList<Mensaje> comentarios) {
		this.comentarios = comentarios;
	}

	public NivelEstudio getNivelEstudio() {
		return nivelEstudio;
	}

	public void setNivelEstudio(NivelEstudio nivelEstudio) {
		this.nivelEstudio = nivelEstudio;
	}

	public Estrato getEstrato() {
		return estrato;
	}

	public void setEstrato(Estrato estrato) {
		this.estrato = estrato;
	}
	
	
	
	/* Fin de Getters y Setters
	*/

}
