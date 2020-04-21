package com.resonance.view.controller;

import java.io.IOException;

import com.resonance.model.principal.ResonanceHome;
import com.resonance.model.util.Util;
import com.resonance.view.interfaz.MultiDatePicker;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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

		btnBuscar.setOnMouseClicked((e) -> {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_LISTADO_HOSPEDAJES));
			Parent root = null;
			try {
				root = loader.load();
			} catch (IOException a) {
				// TODO Auto-generated catch block
				a.printStackTrace();
			}

			ControladorListadoHospedajes control = loader.getController();
			control.inicializar();
			control.setResonance(resonance);
			control.setStage(stage);

			stage.setResizable(false);
			stage.getScene().setRoot(root);
		});

	}

	@FXML
	void onClick(MouseEvent event) {
		if (event.getSource() == btnAyuda) {
			lUbicacion.setStyle("-fx-border-color: black; -fx-border-radius: 15");
			lFecha.setStyle("-fx-border-color: black; -fx-border-radius: 15");
			lHuespedes.setStyle("-fx-border-color: black; -fx-border-radius: 15");

		} else if (event.getSource() == btniniciarSesion) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_INICIAR_SESION));
			Parent root = null;
			try {
				root = loader.load();
			} catch (IOException a) {
				// TODO Auto-generated catch block
				a.printStackTrace();
			}

			ControladorLogIn control = loader.getController();
			control.setResonance(resonance);
			control.setStage(stage);

			stage.setResizable(false);
			stage.getScene().setRoot(root);
		} else if (event.getSource() == btnRegistro) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_REGISTRO));
			Parent root = null;
			try {
				root = loader.load();
			} catch (IOException a) {
				// TODO Auto-generated catch block
				a.printStackTrace();
			}

			ControladorRegistro control = loader.getController();
			control.setResonance(resonance);
			control.setStage(stage);

			stage.setResizable(false);
			stage.getScene().setRoot(root);
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

		// Boton crear propiedad
		btnCrearPropiedad.setOnMouseEntered((e) -> {

			btnCrearPropiedad.setStyle("-fx-background-color: #EBE8EE");
		});
		btnCrearPropiedad.setOnMouseExited((e) -> {
			btnCrearPropiedad.setStyle("-fx-background-color: #FFFFFF");
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
