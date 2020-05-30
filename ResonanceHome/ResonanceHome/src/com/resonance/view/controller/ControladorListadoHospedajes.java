package com.resonance.view.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.resonance.model.hospedajes.Hospedaje;
import com.resonance.model.principal.ResonanceHome;
import com.resonance.model.usuarios.Huesped;
import com.resonance.model.util.Util;
import com.resonance.view.interfaz.StageR;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ControladorListadoHospedajes {
	private StageR stage;

	private ResonanceHome resonance;
	private String estadia;
	@FXML
	private Button btnAyuda;

	@FXML
	private Button btniniciarSesion;

	@FXML
	private Button btnRegistro;

	@FXML
	private Label lblNumEstadias;

	@FXML
	private Label lblEstadias;

	@FXML
	private Text btnAtras;

	@FXML
	private VBox lBox;

	private ArrayList<Hospedaje> hospedajes;



	public void inicializar() {

		lBox.setStyle("-fx-background-color: #FFFFFF");
		if (stage.getUsuarioLogeado() != null)
			if (stage.getUsuarioLogeado() instanceof Huesped) {

				btnAyuda.setVisible(false);
				btniniciarSesion.setVisible(false);
				btnRegistro.setText("Ver perfil");

			}
		colorearBotones();
		crearHospedajes();
		atras();
		iniciarSesion();
		registro();
		atras();

	}

	public void crearHospedajes() {
		lblNumEstadias.setText(hospedajes.size() + " estadias");
		lblEstadias.setText("Estadias en " + estadia);
		lBox.getChildren().clear();
		for (int i = 0; i < hospedajes.size(); i++) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_HOSPEDAJE));
			Parent root = null;
			try {
				root = loader.load();
			} catch (IOException a) {
				// TODO Auto-generated catch block
				a.printStackTrace();
			}
			lBox.getChildren().add(root);

			ControladorHospedaje control = loader.getController();
			control.setResonance(resonance);
			control.setStage(stage);
			control.setHospedaje(hospedajes.get(i));
			control.inicializar();

		}
	}

	public void colorearBotones() {
		// Botón ayuda
		btnAyuda.setOnMouseEntered((e) -> {

			btnAyuda.setStyle("-fx-background-color: #EBE8EE");
		});
		btnAyuda.setOnMouseExited((e) -> {
			btnAyuda.setStyle("-fx-background-color: #FFFFFF");
		});

		// Botón iniciar sesión
		btniniciarSesion.setOnMouseEntered((e) -> {

			btniniciarSesion.setStyle("-fx-background-color: #EBE8EE");
		});

		btniniciarSesion.setOnMouseExited((e) -> {
			btniniciarSesion.setStyle("-fx-background-color: #FFFFFF");
		});
	}

	public void setResonance(ResonanceHome resonance) {
		this.resonance = resonance;
	}

	public void setStage(StageR stage) {
		this.stage = stage;
	}

	/**
	 * @return the hospedajes
	 */
	public ArrayList<Hospedaje> getHospedajes() {
		return hospedajes;
	}

	public void iniciarSesion() {
		btniniciarSesion.setOnMouseClicked((e) -> {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_INICIAR_SESION));
			Parent root = null;
			try {
				root = loader.load();
			} catch (IOException a) {
				// TODO Auto-generated catch block
				a.printStackTrace();
			}

			stage.setVentanaAnterior(Util.VENTANA_PRINCIPAL);
			ControladorLogIn control = loader.getController();
			control.setStage(stage);
			control.setResonance(resonance);

			stage.setResizable(false);
			stage.getScene().setRoot(root);
		});
	}

	public void ayuda() {
		btnAyuda.setOnMouseClicked((e) -> {

		});
	}

	public void registro() {
		btnRegistro.setOnMouseClicked((e) -> {
			if (!btnRegistro.getText().equals("Ver perfil"))

			{
				FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_REGISTRO));
				Parent root = null;
				try {
					root = loader.load();
				} catch (IOException a) {
					// TODO Auto-generated catch block
					a.printStackTrace();
				}

				ControladorRegistro control = loader.getController();
				control.inicializar();
				control.setResonance(resonance);
				control.setStage(stage);

				stage.setResizable(false);
				stage.getScene().setRoot(root);

			} else {

				FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_PERFIL_USUARIO));
				Parent root = null;
				try {
					root = loader.load();
				} catch (IOException a) {
					// TODO Auto-generated catch block
					a.printStackTrace();
				}

				ControladorPerfilUsuario control = loader.getController();
				control.inicializar();
				control.setResonance(resonance);
				control.setStage(stage);

				stage.setResizable(false);
				stage.getScene().setRoot(root);

			}
		});
	}

	public void atras() {
		btnAtras.setOnMouseClicked((e) -> {
			abrirVentanaAnterior();

		});
	}

	public void abrirVentanaAnterior() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.VENTANA_PRINCIPAL));
		try {
			Parent root = loader.load();
			stage.getScene().setRoot(root);
			Util.updateController(loader, stage, resonance);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * @param hospedajes the hospedajes to set
	 */
	public void setHospedajes(ArrayList<Hospedaje> hospedajes) {
		this.hospedajes = hospedajes;
	}

	public String getEstadia() {
		return estadia;
	}

	public void setEstadia(String estadia) {
		this.estadia = estadia;
	}

}