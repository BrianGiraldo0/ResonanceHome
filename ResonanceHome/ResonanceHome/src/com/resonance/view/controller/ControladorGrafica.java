package com.resonance.view.controller;

import com.resonance.model.principal.ResonanceHome;
import com.resonance.view.interfaz.StageR;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class ControladorGrafica {

	private StageR stage;

	private ResonanceHome resonance;
	
    @FXML
    private AnchorPane lComentario;

    @FXML
    private Label lblNombreGrafica;

    @FXML
    private Label lblCalifiación;

    @FXML
    private BarChart<?, ?> Grafica;

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
