package com.resonance.model.util;

import java.util.ArrayList;
import java.util.Random;

import com.resonance.model.archivos.FileManager;

public class Util {

	public static final String LOGO_RESONANCE = "/com/resonance/view/imagenes/logo_resonance.png";
	public static final String VENTANA_PRINCIPAL = "/com/resonance/view/interfaz/ventanaPrincipal.fxml";
	public static final String PANEL_LISTADO_HOSPEDAJES = "/com/resonance/view/interfaz/panelListadoHospedajes.fxml";

	public static ArrayList<String> listadoSugerencias = new ArrayList<>();

	/**
	 * Metodo que agrega una nueva localizacion en la aplicacion
	 * 
	 * @param sugerencia
	 */
	public static void agregarSugerencia(String sugerencia) {

		if (listadoSugerencias.size() != 0) {

			if (!listadoSugerencias.contains(sugerencia)) {

				listadoSugerencias.add(sugerencia);
			}

		}

	}

	public static String generarIDHospedaje() {
		String id = "";
		boolean is = true;
		Random r = new Random();
		while (is) {

			int i = r.nextInt(3000000 + 1) + 9999999;

			id = i + "";
			if (!FileManager.idHospAlreadyExist(id)) {
				is = false;
			}
		}

		return id;
	}
}
