package com.resonance.hospedajes;

public class Prestacion {

	private int numHuesped;
	private int numBanios;
	
	private boolean cocina;

	public int getNumHuesped() {
		return numHuesped;
	}

	public void setNumHuesped(int numHuesped) {
		this.numHuesped = numHuesped;
	}

	public int getNumBanios() {
		return numBanios;
	}

	public void setNumBanios(int numBanios) {
		this.numBanios = numBanios;
	}

	public boolean isCocina() {
		return cocina;
	}

	public void setCocina(boolean cocina) {
		this.cocina = cocina;
	}

	public Prestacion(int numHuesped, int numBanios, boolean cocina) {
		super();
		this.numHuesped = numHuesped;
		this.numBanios = numBanios;
		this.cocina = cocina;
	}
	
	
	
}
