package com.resonance.view.controller;

import com.resonance.model.principal.ResonanceHome;
import com.resonance.view.interfaz.StageR;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ControladorAdministrador {

	private StageR stage;

	private ResonanceHome resonance;
	
    @FXML
    private AnchorPane lFecha;

    @FXML
    private Label lblDiaActual;

    @FXML
    private AnchorPane lBoton;

    @FXML
    private Button btnSiguienteDia;

    @FXML
    private Button btnCerrar;

    @FXML
    private ScrollPane scrollReservas;

    @FXML
    private VBox vBoxReservas;

    @FXML
    private TextField txtCiudad;

    @FXML
    private ComboBox<String> comboFiltrado;

    @FXML
    private Slider sliderInferior;

    @FXML
    private Slider sliderSuperior;
    
    @FXML
    private Label lblInferior;

    @FXML
    private Label lblSuperior;

    @FXML
    void onClick(MouseEvent event) {

    }
    
    public void inicializar() {
		comboFiltrado.getItems().addAll("Precio (Mayor a menor)", "Calificación (Mayor a menor)", "Sin filtro");
		
		//Tener en cuenta que cada que el usuario cambie el slider se debe actualizar estas etiquetas (labels)
		lblInferior.setText(sliderInferior.getValue() + "");
		lblSuperior.setText(sliderSuperior.getValue() + "");
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
}