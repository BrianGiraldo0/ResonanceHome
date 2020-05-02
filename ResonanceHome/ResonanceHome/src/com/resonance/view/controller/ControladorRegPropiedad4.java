package com.resonance.view.controller;

import com.resonance.model.principal.ResonanceHome;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControladorRegPropiedad4 {
	private Stage stage;

	private ResonanceHome resonance;
	@FXML
	private AnchorPane idPaso1;
	@FXML
	private Button btnAtras;

	@FXML

	private Button btnPublicar;

	@FXML
	private AnchorPane lUbicacion;

	@FXML
	private AnchorPane lFecha;

	@FXML
	private AnchorPane lHuespedes;

	@FXML
	private AnchorPane lHuespedes1;

	@FXML
	private AnchorPane idImage;

	@FXML
	private ImageView idImagen;

	@FXML
	private TextField txtTitulo;

	@FXML
	private TextArea txtDescripcion;

	@FXML
	private ImageView image1;

	@FXML
	private Label interrogacionFoto;

	@FXML
	private ImageView image2;

	@FXML
	private Label interrogacionFoto1;

	@FXML
	private ImageView image3;

	@FXML
	private Label interrogacionFoto11;

	@FXML
	private ImageView image4;

	@FXML
	private Label interrogacionFoto111;

	@FXML
	void onClic(MouseEvent event) {

	}

	public void setResonance(ResonanceHome resonance) {
		this.resonance = resonance;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
}