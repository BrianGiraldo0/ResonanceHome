package com.resonance.view.controller;

import java.io.IOException;

import com.resonance.model.hospedajes.Hospedaje;
import com.resonance.model.principal.ResonanceHome;
import com.resonance.model.util.Util;
import com.resonance.view.interfaz.StageR;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ControladorHospedaje {

	private StageR stage;

	private boolean favorito = false;

	private Hospedaje hospedaje;

	private ResonanceHome resonance;

	@FXML
	private Label lblPrecio;

	@FXML
	private Label lblPlus;

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
		lblTipoHospedaje.setText(Util.getTipoHospedaje(hospedaje.getTipoHospedaje()));
		lblTitulo.setText(hospedaje.getTitulo());
		lblDescripcion.setText(hospedaje.getPrestaciones().toString());
		lblPlus.setText(hospedaje.getServicios().toString());
		lblPrecio.setText(hospedaje.getPrecio() + " COP por noche");

//		AnchorPane pane = new AnchorPane();
		btnAnterior.setVisible(false);
		btnSiguiente.setVisible(false);
		lHospedaje.setStyle("-fx-background-color: #FFFFFF");

		// Bot�n Favorito
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

		if (isFavorito()) {
			Image image = new Image(getClass().getResourceAsStream(Util.ICON_CORAZON_ROJO));
			btnFavorito.setGraphic(new ImageView(image));
		} else {
			Image image = new Image(getClass().getResourceAsStream(Util.ICON_CORAZON_BLANCO));
			btnFavorito.setGraphic(new ImageView(image));
		}

		btnFavorito.setOnMouseClicked((e) -> {
			if (isFavorito()) {
				Image image = new Image(getClass().getResourceAsStream(Util.ICON_CORAZON_BLANCO));
				btnFavorito.setGraphic(new ImageView(image));
				favorito = false;
				// Se pone no favorito
			} else {
				Image image = new Image(getClass().getResourceAsStream(Util.ICON_CORAZON_ROJO));
				btnFavorito.setGraphic(new ImageView(image));
				favorito = true;
				// Se pone favorito
			}
		});

	}

	public void tocarHospedaje() {

		FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_HOSPEDAJE_COMPLETO));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException a) {
			// TODO Auto-generated catch block
			a.printStackTrace();
		}

		ControladorHospedajeCompleto control = loader.getController();
		control.setResonance(resonance);
		control.setStage(stage);
		control.inicializar();

		stage.setResizable(false);
		stage.getScene().setRoot(root);

	}

	public StageR getStage() {
		return stage;
	}

	public void setStage(StageR stage) {
		this.stage = stage;
	}

	public ResonanceHome getResonance() {
		return resonance;
	}

	public void setResonance(ResonanceHome resonance) {

		this.resonance = resonance;
	}

	/**
	 * @return the hospedaje
	 */
	public Hospedaje getHospedaje() {
		return hospedaje;
	}

	/**
	 * @param hospedaje the hospedaje to set
	 */
	public void setHospedaje(Hospedaje hospedaje) {
		this.hospedaje = hospedaje;
	}

	public boolean isFavorito() {
		return favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

}
