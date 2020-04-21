package com.resonance.view.controller;

import com.resonance.model.util.Util;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ControladorHospedaje {

	@FXML
	private ImageView imageFotos;

	@FXML
	private ImageView btnAnterior;

	@FXML
	private ImageView btnSiguiente;

	@FXML
	private AnchorPane lHospedaje;

	@FXML
	private Label lblTipoHospedaje;

	@FXML
	private Label lblTitulo;

	@FXML
	private Button btnFavorito;

	@FXML
	private Label lblDescripcion;

	public void inicializar() {

		btnAnterior.setVisible(false);
		btnSiguiente.setVisible(false);
		lHospedaje.setStyle("-fx-background-color: #FFFFFF");
		Image image = new Image(getClass().getResourceAsStream(Util.ICON_CORAZON_BLANCO));
		btnFavorito.setGraphic(new ImageView(image));

		// Botón Favorito
		btnFavorito.setOnMouseEntered((e) -> {

			btnFavorito.setStyle("-fx-background-color: #EBE8EE; -fx-background-radius:50; -fx-border-radius: 30");
		});
		btnFavorito.setOnMouseExited((e) -> {
			btnFavorito.setStyle("-fx-background-color: #FFFFFF");
		});
		lHospedaje.setOnMouseEntered((e) -> {
			btnAnterior.setVisible(true);
			btnSiguiente.setVisible(true);
		});
		lHospedaje.setOnMouseExited((e) -> {
			btnAnterior.setVisible(false);
			btnSiguiente.setVisible(false);
		});

	}

}
