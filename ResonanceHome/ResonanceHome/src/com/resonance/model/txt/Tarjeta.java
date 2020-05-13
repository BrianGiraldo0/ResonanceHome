package com.resonance.model.txt;

public class Tarjeta {

	private int numeroT;
	private double saldo;
	private String duenio;
	
	/**
	 * Metodo constructor
	 * @param numeroT
	 * @param saldo
	 * @param duenio
	 */
	public Tarjeta(int numeroT, double saldo, String duenio) {
		super();
		this.numeroT = numeroT;
		this.saldo = saldo;
		this.duenio = duenio;
	}
	
	/*
	 * Inicio de getters y setters
	 */
	
	public int getNumeroT() {
		return numeroT;
	}
	public void setNumeroT(int numeroT) {
		this.numeroT = numeroT;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getDuenio() {
		return duenio;
	}
	public void setDuenio(String duenio) {
		this.duenio = duenio;
	}
	
	/*
	 * Fin de getters y setters
	 */
	
}
