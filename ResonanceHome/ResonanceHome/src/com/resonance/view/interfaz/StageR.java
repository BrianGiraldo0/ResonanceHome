package com.resonance.view.interfaz;

import com.resonance.model.usuarios.Anfitrion;
import com.resonance.model.usuarios.Huesped;
import com.resonance.model.usuarios.Usuario;

import javafx.stage.Stage;

public class StageR extends Stage {
	private String ventanaAnterior;
	private Huesped usuarioLogeado;
	private Anfitrion anfitrionLogin;
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


}
