package com.resonance.model.usuarios;

public enum NivelEstudio {

	NINGUNO, BACHILLER, TECNICO, TECNOLOGO, PREGRADO, MAESTRIA, DOCTORADO;

	public static NivelEstudio getValue(String value) {
		if (value.equalsIgnoreCase("ninguno")) {
			return NivelEstudio.NINGUNO;
		} else if (value.equalsIgnoreCase("bachiller")) {
			return NivelEstudio.BACHILLER;
		} else if (value.equalsIgnoreCase("tecnico")) {
			return NivelEstudio.TECNICO;
		} else if (value.equalsIgnoreCase("tecnologo")) {
			return NivelEstudio.TECNOLOGO;
		} else if (value.equalsIgnoreCase("pregrado")) {
			return NivelEstudio.PREGRADO;
		} else if (value.equalsIgnoreCase("mestria")) {
			return NivelEstudio.MAESTRIA;
		} else {
			return NivelEstudio.DOCTORADO;
		}
	}
	
}
