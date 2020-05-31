package com.resonance.view.interfaz;

import com.resonance.model.hospedajes.Hospedaje;
import com.resonance.model.usuarios.Anfitrion;
import com.resonance.model.usuarios.Huesped;
import com.resonance.model.usuarios.Usuario;

import javafx.stage.Stage;

public class StageR extends Stage {
	private String ventanaAnterior;
	private Huesped usuarioLogeado;
	private Anfitrion anfitrionLogin;
	private Hospedaje hospedaje;
	/**
	 * @param usuarioLogeado
	 */
	public StageR() {
		super();
	}

	/**
	 * @return the usuarioLogeado
	 */
	public Usuario getUsuarioLogeado() {
		if (anfitrionLogin != null)
			return anfitrionLogin;

		return usuarioLogeado;
	}


	/**
	 * @param usuarioLogeado the usuarioLogeado to set
	 */
	public void setHuespedLogeado(Huesped usuarioLogeado) {
		this.usuarioLogeado = usuarioLogeado;
	}

	/**
	 * @param anfitrionLogin the anfitrionLogin to set
	 */
	public void setAnfitrionLogin(Anfitrion anfitrionLogin) {
		this.anfitrionLogin = anfitrionLogin;
	}

	/**
	 * @return the ventanaAnterior
	 */
	public String getVentanaAnterior() {
		return ventanaAnterior;
	}

	/**
	 * @param ventanaAnterior the ventanaAnterior to set
	 */
	public void setVentanaAnterior(String ventanaAnterior) {
		this.ventanaAnterior = ventanaAnterior;
	}

	/**
	 * @return the hospedaje
	 */
	public Hospedaje getHospedaje() {
		return hospedaje;
	}

	/**
	 * @param hospedaje the hospedaje to set
	 */
	public void setHospedaje(Hospedaje hospedaje) {
		this.hospedaje = hospedaje;
	}

}
