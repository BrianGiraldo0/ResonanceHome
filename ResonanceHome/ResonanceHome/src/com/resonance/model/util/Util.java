package com.resonance.model.util;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Random;

import com.resonance.model.archivos.FileManager;
import com.resonance.model.hospedajes.Calificacion;
import com.resonance.model.hospedajes.TipoHospedaje;
import com.resonance.model.principal.ResonanceHome;
import com.resonance.view.controller.ControladorComentario;
import com.resonance.view.controller.ControladorDescripcionHospedaje;
import com.resonance.view.controller.ControladorFotosHospedaje;
import com.resonance.view.controller.ControladorHospedaje;
import com.resonance.view.controller.ControladorHospedajeCompleto;
import com.resonance.view.controller.ControladorListadoHospedajes;
import com.resonance.view.controller.ControladorPerfilAnfitrion;
import com.resonance.view.controller.ControladorPerfilUsuario;
import com.resonance.view.controller.ControladorPrincipal;
import com.resonance.view.controller.ControladorRegistro;
import com.resonance.view.interfaz.StageR;

import RStatistics.RStatistics;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;

/**
 * Proyecto de programación - Analisis de algoritmos
 * 
 * @author Cesar Marquez, Brian Giraldo, Esteban Sanchez
 *
 */
public class Util {
	public static final String LOGO_RESONANCE = "/com/resonance/view/imagenes/logo_resonance.png";
	public static final String ICON_CORAZON_BLANCO = "/com/resonance/view/imagenes/icon_corazon.png";
	public static final String ICON_CORAZON_ROJO = "/com/resonance/view/imagenes/icon_corazonRojo.png";
	public static final String ICON_STAR_LLENA = "/com/resonance/view/imagenes/EstrellaLlena.png";
	public static final String ICON_STAR_MEDIO_LLENA = "/com/resonance/view/imagenes/EstrellaMedioLlena.png";
	public static final String ICON_STAR_VACIA = "/com/resonance/view/imagenes/EstrellaVacia.png";
	public static final String ICON_MENSAJES = "/com/resonance/view/imagenes/icon_mensajes.png";

	/*
	 * Direccion de las ventanas usadas en la UI
	 */
	public static final String PANEL_ADMINISTRADOR = "/com/resonance/view/interfaz/panelAdministrador.fxml";
	public static final String PANEL_COMENTARIO = "/com/resonance/view/interfaz/panelComentario.fxml";
	public static final String PANEL_DESCRIPCION_HOSPEDAJE = "/com/resonance/view/interfaz/panelDescripcionHospedaje.fxml";
	public static final String PANEL_DESCRIPCION_RESERVA = "/com/resonance/view/interfaz/panelDescripcionReserva.fxml";
	public static final String PANEL_FAVORITOS = "/com/resonance/view/interfaz/panelFavoritos.fxml";
	public static final String PANEL_FOTOS_HOSPEDAJE = "/com/resonance/view/interfaz/panelFotosHospedaje.fxml";
	public static final String PANEL_GESTION_RESERVAS = "/com/resonance/view/interfaz/panelGestionReservas.fxml";
	public static final String PANEL_HOSPEDAJE = "/com/resonance/view/interfaz/panelHospedaje.fxml";
	public static final String PANEL_HOSPEDAJE_COMPLETO = "/com/resonance/view/interfaz/panelHospedajeCompleto.fxml";
	public static final String PANEL_HOSPEDAJE_PERFIL = "/com/resonance/view/interfaz/panelHospedajeEnPerfil.fxml";
	public static final String PANEL_GESTION_CALIFICACIONES = "/com/resonance/view/interfaz/panelGestionCalificacion.fxml";
	public static final String PANEL_LISTADO_HOSPEDAJES = "/com/resonance/view/interfaz/panelListadoHospedajes.fxml";
	public static final String PANEL_INICIAR_SESION = "/com/resonance/view/interfaz/panellogIn.fxml";
	public static final String PANEL_PERFIL_USUARIO   = "/com/resonance/view/interfaz/panelPerfilUsuario.fxml";
	public static final String PANEL_PERFIL_ANFITRION = "/com/resonance/view/interfaz/panelPerfilAnfitrion.fxml";
	public static final String PANEL_PAGO = "/com/resonance/view/interfaz/panelPago.fxml";
	public static final String PANEL_REGISTRO = "/com/resonance/view/interfaz/panelRegistro.fxml";
	public static final String PANEL_REGPROPIEDAD_1 = "/com/resonance/view/interfaz/panelRegPropiedad1.fxml";
	public static final String PANEL_REGPROPIEDAD_2 = "/com/resonance/view/interfaz/panelRegPropiedad2.fxml";
	public static final String PANEL_REGPROPIEDAD_3 = "/com/resonance/view/interfaz/panelRegPropiedad3.fxml";
	public static final String PANEL_REGPROPIEDAD_4 = "/com/resonance/view/interfaz/panelRegPropiedad4.fxml";
	public static final String VENTANA_PRINCIPAL = "/com/resonance/view/interfaz/ventanaPrincipal.fxml";
	public static final String PANEL_GRAFICA = "/com/resonance/view/interfaz/panelGrafica.fxml";
	public static final String PANEL_MENSAJES = "/com/resonance/view/interfaz/panelMensajes.fxml";
	public static ArrayList<String> listadoSugerencias = new ArrayList<>();

	public static String[][] calificaciones;
	/**
	 * Metodo que agrega una nueva localizacion en la aplicacion
	 * 
	 * @param sugerencia
	 */
	public static void agregarSugerencia(String sugerencia) {

			if (!listadoSugerencias.contains(sugerencia)) {

				listadoSugerencias.add(sugerencia);
			}

	}

	public static void updateController(FXMLLoader loader, StageR stage, ResonanceHome resonance) {
		if (loader.getController() instanceof ControladorPrincipal) {
			ControladorPrincipal control = loader.getController();
			control.setStage(stage);
			control.setResonance(resonance);
			control.inicializar();
		} else if (loader.getController() instanceof ControladorComentario) {
			ControladorComentario control = loader.getController();
//			control.setStage(stage);
//			control.setResonance(resonance);
			control.inicializar();
		} else if (loader.getController() instanceof ControladorHospedaje) {
			ControladorHospedaje control = loader.getController();
			control.setStage(stage);
			control.setResonance(resonance);
			control.inicializar();
		} else if (loader.getController() instanceof ControladorDescripcionHospedaje) {
			ControladorDescripcionHospedaje control = loader.getController();
			control.setStage(stage);
			control.setResonance(resonance);
			control.inicializar();
		} else if (loader.getController() instanceof ControladorFotosHospedaje) {
			ControladorFotosHospedaje control = loader.getController();
//			control.setStage(stage);
//			control.setResonance(resonance);
			control.inicializar();
		} else if (loader.getController() instanceof ControladorListadoHospedajes) {
			ControladorListadoHospedajes control = loader.getController();
			control.setStage(stage);
			control.setResonance(resonance);
			control.inicializar();
		} else if (loader.getController() instanceof ControladorHospedajeCompleto) {
			ControladorHospedajeCompleto control = loader.getController();
			control.setStage(stage);
			control.setResonance(resonance);
			control.inicializar();
		} else if (loader.getController() instanceof ControladorRegistro) {
			ControladorRegistro control = loader.getController();
			control.setStage(stage);
			control.setResonance(resonance);
			control.inicializar();
		} else if (loader.getController() instanceof ControladorPerfilAnfitrion) {
			ControladorPerfilAnfitrion control = loader.getController();
			control.setStage(stage);
			control.setResonance(resonance);
			control.inicializar();
		} else if (loader.getController() instanceof ControladorPerfilUsuario) {
			ControladorPerfilUsuario control = loader.getController();
			control.setStage(stage);
			control.setResonance(resonance);
			control.inicializar();
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

	public static boolean isEmpty(TextField text) {
		if (text.getText().equals(""))
			return true;

		return false;
	}

	public static String getTipoHospedaje(TipoHospedaje tipo) {
		if (tipo == TipoHospedaje.APARTAMENTO) {
			return "Apartamento";
		} else {
			return "Habitación";
		}
	}

	public static void loadCalificaciones() {
		try {
			calificaciones = RStatistics.obtenerRespuestas();
		} catch (IOException | GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static ArrayList<Calificacion> obtenerCalificaciones(String id){
		ArrayList<Calificacion> c = new ArrayList<Calificacion>();
		int limpieza = 0;
		int profesionalismo = 0;
		int atencion = 0;
		int ubicacion = 0;
		for (int i = 0; i < calificaciones.length; i++) {
			if (calificaciones[i][3].equals(id)) {
				limpieza = Integer.parseInt(calificaciones[i][4]);
				profesionalismo = Integer.parseInt(calificaciones[i][5]);
				atencion = Integer.parseInt(calificaciones[i][6]);
				ubicacion = Integer.parseInt(calificaciones[i][7]);
				Calificacion ca = new Calificacion(limpieza, profesionalismo, atencion, ubicacion);
				c.add(ca);
			}

		}
		return c;
	}

	
}
