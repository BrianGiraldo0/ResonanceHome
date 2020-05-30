package com.resonance.model.hospedajes;

public enum TipoHospedaje {
	HABITACION(0), APARTAMENTO(1);

	private int tipo;

	private TipoHospedaje(int tipo) {
		this.tipo = tipo;
	}

	public String toString() {
		if (tipo == 0) {
			return "Habitación";
		} else {
			return "Apartamento";
		}
	}


}
