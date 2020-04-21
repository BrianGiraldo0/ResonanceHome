package com.resonance.view.controller;

import com.resonance.model.principal.ResonanceHome;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ControladorListadoHospedajes {
	private Stage stage;

	private ResonanceHome resonance;

	@FXML
	private Button btnAyuda;

	@FXML
	private Button btniniciarSesion;

	@FXML
	private Button btnRegistro;

	@FXML
	private ImageView btnBuscar;

	@FXML
	private AnchorPane lUbicacion;

	@FXML
	private TextField tfUbicacion;

	@FXML
	private AnchorPane lFecha;

	@FXML
	private AnchorPane layout;

	@FXML
	private AnchorPane lHuespedes;

	@FXML
	private TextField tfHuespedes;

	@FXML
	private Label lblNumEstadias;

	@FXML
	private Label lblEstadias;

	@FXML
	private VBox lBox;

	@FXML
	void onClick(MouseEvent event) {

	}

	public void inicializar() {
		colorearBotones();
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

	public void setStage(Stage stage) {
		this.stage = stage;
	}

}