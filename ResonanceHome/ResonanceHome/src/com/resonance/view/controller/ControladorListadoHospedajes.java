package com.resonance.view.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.resonance.model.hospedajes.Hospedaje;
import com.resonance.model.principal.ResonanceHome;
import com.resonance.model.util.Util;
import com.resonance.view.interfaz.StageR;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ControladorListadoHospedajes {
	private StageR stage;

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

	private ArrayList<Hospedaje> hospedajes;

	@FXML
	void onClick(MouseEvent event) {

	}

	public void inicializar() {

		lBox.setStyle("-fx-background-color: #FFFFFF");
		colorearBotones();
		crearHospedajes();

	}

	public void crearHospedajes() {

		System.out.println(hospedajes.size());
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

	/**
	 * @param hospedajes the hospedajes to set
	 */
	public void setHospedajes(ArrayList<Hospedaje> hospedajes) {
		this.hospedajes = hospedajes;
	}

}