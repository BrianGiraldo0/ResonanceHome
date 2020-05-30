package com.resonance.model.hospedajes;

public class Calificacion {

	private int limpieza;
	private int profesionalismoAnfitrion;
	private int atencion;
	private int ubicacion;

	/**
	 * @param limpieza
	 * @param profesionalismoAnfitrion
	 * @param atencion
	 * @param ubicacion
	 */
	public Calificacion(int limpieza, int profesionalismoAnfitrion, int atencion, int ubicacion) {
		this.limpieza = limpieza;
		this.profesionalismoAnfitrion = profesionalismoAnfitrion;
		this.atencion = atencion;
		this.ubicacion = ubicacion;
	}


	/**
	 * @return the limpieza
	 */
	public int getLimpieza() {
		return limpieza;
	}

	/**
	 * @param limpieza the limpieza to set
	 */
	public void setLimpieza(int limpieza) {
		this.limpieza = limpieza;
	}

	/**
	 * @return the profesionalismoAnfitrion
	 */
	public int getProfesionalismoAnfitrion() {
		return profesionalismoAnfitrion;
	}

	/**
	 * @param profesionalismoAnfitrion the profesionalismoAnfitrion to set
	 */
	public void setProfesionalismoAnfitrion(int profesionalismoAnfitrion) {
		this.profesionalismoAnfitrion = profesionalismoAnfitrion;
	}

	/**
	 * @return the atencion
	 */
	public int getAtencion() {
		return atencion;
	}

	/**
	 * @param atencion the atencion to set
	 */
	public void setAtencion(int atencion) {
		this.atencion = atencion;
	}

	/**
	 * @return the ubicacion
	 */
	public int getUbicacion() {
		return ubicacion;
	}

	/**
	 * @param ubicacion the ubicacion to set
	 */
	public void setUbicacion(int ubicacion) {
		this.ubicacion = ubicacion;
	}

}
