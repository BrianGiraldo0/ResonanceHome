package com.resonance.model.hospedajes;

public class Direccion {

	private String pais;
	private String estado;
	private String ciudad;
	private String direccion;
	
	/**
	 * Metodo constructor 
	 * @param ciudad
	 * @param direccion
	 */
	public Direccion(String ciudad,String estado, String pais ,String direccion) {
		super();
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.estado = estado;
		this.pais = pais;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String toString() {
		
		
		return ciudad + ", " + estado + ", " + pais;
		
	}
	
}