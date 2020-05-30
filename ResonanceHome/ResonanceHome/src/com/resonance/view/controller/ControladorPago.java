package com.resonance.view.controller;

import com.resonance.model.hospedajes.Hospedaje;
import com.resonance.model.principal.ResonanceHome;
import com.resonance.view.interfaz.StageR;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class ControladorPago {
	
	private ResonanceHome resonance;
	
	private StageR stage;
	
	private Hospedaje hospedaje;

    @FXML
    private Label labelPrecioDia;

    @FXML
    private Label labelPrecioAlojamiento;

    @FXML
    private Label labelPrecioLimpieza;

    @FXML
    private Label labelComision;

    @FXML
    private Label labelTotal;

    @FXML
    private Label lblNumeroHuespedes;

    @FXML
    private Label lblFechas;

    @FXML
    private Text btnAtras;

    @FXML
    private Button btnReservar;

    @FXML
    private TextArea txtMensaje;

    @FXML
    private TextField txtNumeroTarjeta;

    @FXML
    private TextField txtNombreApellido;

    @FXML
    private TextField txtFechaExpedicion;

    @FXML
    private TextField txtCodigoSeguridad;

    @FXML
    private TextField txtCedula;

    @FXML
    private Label lblNumeroTarjeta;

    @FXML
    private Label lblNombreApellido;

    @FXML
    private Label lblFechaExpiración;

    @FXML
    void reservar(MouseEvent event) {

    }

	public ResonanceHome getResonance() {
		return resonance;
	}

	public void setResonance(ResonanceHome resonance) {
		this.resonance = resonance;
	}

	public StageR getStage() {
		return stage;
	}

	public void setStage(StageR stage) {
		this.stage = stage;
	}

	public Hospedaje getHospedaje() {
		return hospedaje;
	}

	public void setHospedaje(Hospedaje hospedaje) {
		this.hospedaje = hospedaje;
	}
}
