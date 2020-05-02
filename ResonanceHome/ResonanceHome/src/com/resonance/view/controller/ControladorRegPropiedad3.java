package com.resonance.view.controller;

import java.io.IOException;

import com.resonance.model.principal.ResonanceHome;
import com.resonance.model.util.Util;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControladorRegPropiedad3 {
	private Stage stage;

	private ResonanceHome resonance;
	@FXML
	private AnchorPane idPaso1;
	@FXML
	private Button btnAtras;

	@FXML
	private Button btnSiguiente;

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
	private CheckBox checkKitBanio;

	@FXML
	private CheckBox checkWifi;

	@FXML
	private CheckBox checkAire;

	@FXML
	private CheckBox checkCocina;

	@FXML
	private CheckBox checkUten;

	@FXML
	void onClic(MouseEvent event) {
		if (event.getSource() == btnSiguiente) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_REGPROPIEDAD_4));
			Parent root = null;
			try {
				root = loader.load();
			} catch (IOException a) {
				// TODO Auto-generated catch block
				a.printStackTrace();
			}

			ControladorRegPropiedad4 control = loader.getController();
			control.setResonance(resonance);
			control.setStage(stage);
//			control.inicializar();
			stage.setResizable(false);
			stage.getScene().setRoot(root);

		}
	}

	public void setResonance(ResonanceHome resonance) {
		this.resonance = resonance;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
}