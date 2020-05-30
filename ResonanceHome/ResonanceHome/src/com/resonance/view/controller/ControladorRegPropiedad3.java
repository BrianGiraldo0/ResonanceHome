package com.resonance.view.controller;

import java.io.IOException;

import com.resonance.model.hospedajes.Hospedaje;
import com.resonance.model.hospedajes.Plus;
import com.resonance.model.principal.ResonanceHome;
import com.resonance.model.util.Util;
import com.resonance.view.interfaz.StageR;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ControladorRegPropiedad3 {
	
	private Hospedaje hospedaje;
	private StageR stage;
	
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

			
			
			
			hospedaje.getPrestaciones().setCocina(checkCocina.isSelected());;
			hospedaje.setServicios(new Plus(checkCocina.isSelected(),checkWifi.isSelected(),checkUten.isSelected(),checkAire.isSelected(),checkKitBanio.isSelected()));
			
			
			
			ControladorRegPropiedad4 control = loader.getController();
			control.setResonance(resonance);
			control.setStageR(stage);
			control.setHospedaje(hospedaje);
			control.inicializar();
			stage.setResizable(false);
			stage.getScene().setRoot(root);

		}
	}

	public void abrirVentanaAnterior() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_REGPROPIEDAD_2));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ControladorRegPropiedad2 control = loader.getController();
		control.setResonance(resonance);
		control.setStageR(stage);
		control.setHospedaje(hospedaje);
		control.inicializar();

		stage.getScene().setRoot(root);

	}

	public void inicializar() {
		if (hospedaje.getServicios() != null) {
			llenarDatos();
		}
		btnAtras.setOnMouseClicked((e) -> {
			abrirVentanaAnterior();
		});
	}

	public void llenarDatos() {
		if(hospedaje.getServicios().isAireAc())
			checkAire.setSelected(true);
		if(hospedaje.getServicios().isCocina())
			checkCocina.setSelected(true);
		if(hospedaje.getServicios().isKitBanio())
			checkKitBanio.setSelected(true);
		if(hospedaje.getServicios().isUtencilios())
			checkUten.setSelected(true);
		if(hospedaje.getServicios().isWifi())
			checkWifi.setSelected(true);
	}
	public void setResonance(ResonanceHome resonance) {
		this.resonance = resonance;
	}

	public void setStageR(StageR stage) {
		this.stage = stage;
	}

	public void setHospedaje(Hospedaje hospedaje) {
		this.hospedaje = hospedaje;
	}
	
	
}