package com.resonance.view.controller;

import java.io.File;

import com.resonance.model.principal.ResonanceHome;
import com.resonance.view.interfaz.StageR;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

public class ControladorRegistro {

	private StageR stage;
	private ResonanceHome resonance;

	@FXML
	private Text btnAtras;

	@FXML
	private ImageView picPerfil;
	@FXML
	private Button btnSubirFoto;

	@FXML
	private TextField textNombreUsuario;

	@FXML
	private Button quitarFoto;

	@FXML
	private PasswordField textPasswordUsuario;

	@FXML

	private ImageView fotoPerfil;

	@FXML
	private Rectangle rectanguloFoto;

	@FXML
	private Label interrogacionFoto;

	@FXML
	private Button btnContinuar;

	@FXML
	private DatePicker dateFechaNacimiento;

	@FXML
	private TextArea textBiografia;

	@FXML
	private TextField textEmail;

	@FXML
	private TextField textDireccion;

	@FXML
	private TextField textNombreCompleto;

	public void subirFoto() {

		FileChooser fileChooser = new FileChooser();

		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Archivos de imagen", "*.jpg", "*.png")

		);

		File selectedFile = fileChooser.showOpenDialog(stage);

		if (selectedFile != null) {
			rectanguloFoto.setVisible(false);
			interrogacionFoto.setVisible(false);
			quitarFoto.setVisible(true);

			Image image = new Image(selectedFile.toURI().toString());
			picPerfil.setImage(image);

		} else {
			rectanguloFoto.setVisible(true);
			interrogacionFoto.setVisible(true);
		}

	}

	public void quitarFoto() {

		quitarFoto.setVisible(false);
		picPerfil.setImage(null);

		rectanguloFoto.setVisible(true);
		interrogacionFoto.setVisible(true);

	}

	public void setResonance(ResonanceHome resonance) {
		this.resonance = resonance;
	}

	public void setStage(StageR stage) {
		this.stage = stage;
	}

}
