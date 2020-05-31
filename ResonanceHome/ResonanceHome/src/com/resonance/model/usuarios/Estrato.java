package com.resonance.model.usuarios;

public enum Estrato {

	ESTRATO_1, ESTRATO_2, ESTRATO_3, ESTRATO_4, ESTRATO_5, ESTRATO_6;

	public static Estrato getValue(String value) {
		if (value.equalsIgnoreCase("estrato 1")) {
			return Estrato.ESTRATO_1;
		} else if (value.equalsIgnoreCase("estrato 2")) {
			return Estrato.ESTRATO_2;
		} else if (value.equalsIgnoreCase("estrato 3")) {
			return Estrato.ESTRATO_3;
		} else if (value.equalsIgnoreCase("estrato 4")) {
			return Estrato.ESTRATO_4;
		} else if (value.equalsIgnoreCase("estrato 5")) {
			return Estrato.ESTRATO_5;
		} else {
			return Estrato.ESTRATO_6;
		}
	}
}
