package com.resonance.view.controller;

import com.resonance.model.principal.ResonanceHome;
import com.resonance.view.interfaz.MultiDatePicker;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControladorPrincipal {

	@FXML
	private ImageView btnBuscar;

	private Stage stage;
	private ResonanceHome resonance;

	@FXML
	private Button btnCrearPropiedad;

	@FXML
	private Button btnAyuda;

	@FXML
	private Button btniniciarSesion;

	@FXML
	private Button btnRegistro;

	@FXML
	private AnchorPane lUbicacion;

	@FXML
	private TextField tfUbicacion;

	@FXML
	private TextField tfHuespedes;

	@FXML
	private AnchorPane lHuespedes;

	@FXML
	private AnchorPane lFecha;

	@FXML
	private AnchorPane layout;

	public void inicializar() {
		MultiDatePicker multiDatePicker = new MultiDatePicker().withRangeSelectionMode();

		DatePicker rangePicker = multiDatePicker.getDatePicker();
		rangePicker.setMinWidth(200);
		layout.getChildren().add(rangePicker);
		colorearBotones();

	}

	@FXML
	void onClick(MouseEvent event) {
		if (event.getSource() == btnAyuda) {
			lUbicacion.setStyle("-fx-border-color: black; -fx-border-radius: 15");
			lFecha.setStyle("-fx-border-color: black; -fx-border-radius: 15");
			lHuespedes.setStyle("-fx-border-color: black; -fx-border-radius: 15");

		}

	}

	public void colorearBotones() {
		// Bot�n ayuda
		btnAyuda.setOnMouseEntered((e) -> {

			btnAyuda.setStyle("-fx-background-color: #EBE8EE");
		});
		btnAyuda.setOnMouseExited((e) -> {
			btnAyuda.setStyle("-fx-background-color: #FFFFFF");
		});

		// Boton crear propiedad
		btnCrearPropiedad.setOnMouseEntered((e) -> {

			btnCrearPropiedad.setStyle("-fx-background-color: #EBE8EE");
		});
		btnCrearPropiedad.setOnMouseExited((e) -> {
			btnCrearPropiedad.setStyle("-fx-background-color: #FFFFFF");
		});

		// Bot�n iniciar sesi�n
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
