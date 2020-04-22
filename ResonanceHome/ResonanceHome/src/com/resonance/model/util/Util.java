package com.resonance.model.util;

import java.util.ArrayList;
import java.util.Random;

import com.resonance.model.archivos.FileManager;

public class Util {

	public static final String LOGO_RESONANCE = "/com/resonance/view/imagenes/logo_resonance.png";
	public static final String ICON_CORAZON_BLANCO = "/com/resonance/view/imagenes/icon_corazon.png";
	public static final String VENTANA_PRINCIPAL = "/com/resonance/view/interfaz/ventanaPrincipal.fxml";
	public static final String PANEL_LISTADO_HOSPEDAJES = "/com/resonance/view/interfaz/panelListadoHospedajes.fxml";
	public static final String PANEL_HOSPEDAJE = "/com/resonance/view/interfaz/panelHospedaje.fxml";
	public static final String PANEL_INICIAR_SESION = "/com/resonance/view/interfaz/panellogIn.fxml";
	public static final String PANEL_REGISTRO = "/com/resonance/view/interfaz/panelRegistro.fxml";
	public static final String PANEL_HOSPEDAJE_COMPLETO = "/com/resonance/view/interfaz/panelHospedajeCompleto.fxml";
	public static final String PANEL_FOTOS_HOSPEDAJE = "/com/resonance/view/interfaz/panelFotosHospedaje.fxml";
	public static final String PANEL_DESCRIPCION_HOSPEDAJE = "/com/resonance/view/interfaz/panelDescripcionHospedaje.fxml";
	public static final String PANEL_COMENTARIO= "/com/resonance/view/interfaz/panelComentario.fxml";

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
