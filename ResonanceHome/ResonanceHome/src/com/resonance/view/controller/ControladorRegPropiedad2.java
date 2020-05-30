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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ControladorRegPropiedad2 {
	private StageR stage;
	
	private ResonanceHome resonance;
	
	private Hospedaje hospedaje;
	@FXML
	private Button btnAtras;

	@FXML

	private Button btnSiguiente;
	@FXML
	private AnchorPane idPaso1;

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
	private TextField txtDireccion;

	@FXML
	private TextField txtInfo;

	@FXML
	private ComboBox<String> comboPaises;

	@FXML
	private TextField txtCiudad;

	@FXML
	private TextField txtDepartamento;

	@FXML
	private TextField txtCodigoPostal;

	@FXML
	void onClic(MouseEvent event) {
		if (event.getSource() == btnSiguiente) {
			
			hospedaje.getDireccion().setPais(comboPaises.getSelectionModel().getSelectedItem());
			hospedaje.getDireccion().setDireccion(txtDireccion.getText());
			hospedaje.getDireccion().setEstado(txtDepartamento.getText());
			
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_REGPROPIEDAD_3));
			Parent root = null;
			try {
				root = loader.load();
			} catch (IOException a) {
				// TODO Auto-generated catch block
				a.printStackTrace();
			}

			ControladorRegPropiedad3 control = loader.getController();
			control.setResonance(resonance);
			control.setStageR(stage);
			control.setHospedaje(hospedaje);
			control.inicializar();
			stage.setResizable(false);
			stage.getScene().setRoot(root);

		}
	}

	public void inicializar() {
		if (hospedaje.getDireccion().getDireccion() != null) {
			llenarDatos();
		}
		btnAtras.setOnMouseClicked((e) -> {
			abrirVentanaAnterior();
		});

		comboPaises.getItems().addAll("Afganistán", "Albania", "Alemania", "Andorra", "Angola", "Antigua y Barbuda",
				"Arabia Saudita", "Argelia", "Argentina", "Armenia", "Australia", "Austria", "Azerbaiyán", "Bahamas",
				"Bangladés", "Barbados", "Baréin", "Bélgica", "Belice", "Benín", "Bielorrusia", "Birmania", "Bolivia",
				"Bosnia y Herzegovina", "Botsuana", "Brasil", "Brunéi", "Bulgaria", "Burkina Faso", "Burundi", "Bután",
				"Cabo Verde", "Camboya", "Camerún", "Canadá", "Catar", "Chad", "Chile", "China", "Chipre",
				"Ciudad del Vaticano", "Colombia", "Comoras", "Corea del Norte", "Corea del Sur", "Costa de Marfil",
				"Costa Rica", "Croacia", "Cuba", "Dinamarca", "Dominica", "Ecuador", "Egipto", "El Salvador",
				"Emiratos Árabes Unidos", "Eritrea", "Eslovaquia", "Eslovenia", "España", "Estados Unidos", "Estonia",
				"Etiopía", "Filipinas", "Finlandia", "Fiyi", "Francia", "Gabón");
	}

	public void llenarDatos() {
		comboPaises.setValue(hospedaje.getDireccion().getPais());
		txtDireccion.setText(hospedaje.getDireccion().getDireccion());
		txtCiudad.setText(hospedaje.getDireccion().getCiudad());
		txtDepartamento.setText(hospedaje.getDireccion().getEstado());
	}
	public void abrirVentanaAnterior() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_REGPROPIEDAD_1));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ControladorRegPropiedad1 control = loader.getController();
		control.setResonance(resonance);
		control.setHospedaje(hospedaje);
		control.setStage(stage);
		control.inicializar();

		stage.getScene().setRoot(root);

	}
	public void setResonance(ResonanceHome resonance) {
		this.resonance = resonance;
	}

	public void setStageR(StageR stage) {
		this.stage = stage;
	}

	public Hospedaje getHospedaje() {
		return hospedaje;
	}

	public void setHospedaje(Hospedaje hospedaje) {
		this.hospedaje = hospedaje;
	}
	
	
}
