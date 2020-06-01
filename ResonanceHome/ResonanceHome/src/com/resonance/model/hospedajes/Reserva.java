package com.resonance.model.hospedajes;

import java.util.ArrayList;
import java.util.Date;

import com.resonance.model.txt.Tarjeta;
import com.resonance.model.util.Fecha;
import com.resonance.model.util.MailSender;

/**
 * Proyecto de programación - Analisis de algoritmos
 * 
 * @author Cesar Marquez, Brian Giraldo, Esteban Sanchez
 *
 */
public class Reserva {

	private Hospedaje hospedaje;
	private String nameTagHuesped = "";
	private Fecha fecha;
	private ArrayList<Date> fechaReservada;
	private boolean vencido = false;
	private String identificacion;
	private String nombre;
	private String direccion;
	private String correo;
	private int numeroHuespedes;
	private double valor;
	private Tarjeta tarjeta;
	private String emailCliente;

	/**
	 * Metodo Constructor
	 * @param hospedaje
	 * @param nameTagHuesped
	 * @param identificacion
	 * @param nombre
	 * @param direccion
	 * @param correo
	 * @param tarjeta
	 * @param fechaReservada
	 * @param valor
	 * @param numeroHuespedes
	 */
	public Reserva(Hospedaje hospedaje, String nameTagHuesped, String identificacion, String nombre, String direccion,
			String correo, Tarjeta tarjeta,ArrayList<Date> fechaReservada, double valor, int numeroHuespedes, Fecha fecha) {
		super();
		this.hospedaje = hospedaje;
		this.nameTagHuesped = nameTagHuesped;
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.direccion = direccion;
		this.correo = correo;
		this.tarjeta = tarjeta;
		this.valor = valor;
		this.numeroHuespedes = numeroHuespedes;
		this.fecha = fecha;
		this.fechaReservada = fechaReservada;
		
	}

	/**
	 * Metodo Contructor
	 * @param hospedaje
	 * @param nameTagHuesped
	 * @param identificacion
	 * @param nombre
	 * @param direccion
	 * @param correo
	 */

	public Reserva(Hospedaje hospedaje, String nameTagHuesped, String identificacion, String nombre, String direccion,
			String correo) {
		super();
		this.hospedaje = hospedaje;
		this.nameTagHuesped = nameTagHuesped;
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.direccion = direccion;
		this.correo = correo;
	}

	public void update(Fecha fecha) {
		if (fecha.isMayor(getFechaFinal())) {
			hospedaje.update(fecha);
			vencido = true;
			String datos = "ID del hospedaje: " + hospedaje.getId() + "\n Anfitrion: "
					+ hospedaje.getNameTagPropietario();
			MailSender.enviarEncuestaSatisfacion(emailCliente, datos);

		}

	}



	public boolean verificarDiaReserva(Date fecha) {

		for (int i = 0; i < fechaReservada.size(); i++) {

			if (fechaReservada.get(i).compareTo(fecha) == 0) {
				return true;
			}

		}
		return false;
	}

	/*
	 * Inicio de Getters y Setters
	 */

	/**
	 * Metodo que retorna el hospedaje
	 * 
	 * @return
	 */
	public Hospedaje getIdHospedaje() {
		return hospedaje;
	}

	/**
	 * Metodo que retorna el nametag el huesped que reservo
	 * 
	 * @return
	 */
	public String getNameTagHuesped() {
		return nameTagHuesped;
	}

	/**
	 * Metodo que retorna las fechas reservadas
	 * 
	 * @return
	 */
	public ArrayList<Date> getFechaReservada() {
		return fechaReservada;
	}

	/**
	 * Metodo que selecciona la fechas reservadas
	 * 
	 * @param fechaReservada
	 */
	public void setFechaReservada(ArrayList<Date> fechaReservada) {
		this.fechaReservada = fechaReservada;
	}

	public Hospedaje getHospedaje() {
		return hospedaje;
	}

	public void setHospedaje(Hospedaje hospedaje) {
		this.hospedaje = hospedaje;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public boolean isVencido() {
		return vencido;
	}

	public Date getFechaInicial() {
		return fechaReservada.get(0);
	}

	public Date getFechaFinal() {
		return fechaReservada.get(fechaReservada.size() - 1);
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getNumeroHuespedes() {
		return numeroHuespedes;
	}

	public void setNumeroHuespedes(int numeroHuespedes) {
		this.numeroHuespedes = numeroHuespedes;
	}

	public Fecha getFecha() {
		return fecha;
	}

	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the emailCliente
	 */
	public String getEmailCliente() {
		return emailCliente;
	}

	/**
	 * @param emailCliente the emailCliente to set
	 */
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	/*
	 * Fin de Getters y Setters
	 */

}
