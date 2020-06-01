package com.resonance.view.controller;

import com.resonance.model.principal.ResonanceHome;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Proyecto de programación - Analisis de algoritmos
 * 
 * @author Cesar Marquez, Brian Giraldo, Esteban Sanchez
 *
 */
public class ControladorFavoritos {

    @FXML
    private ScrollPane scrollReservas;

    @FXML
    private VBox vBoxReservas;

    @FXML
    private Text btnAtras;

    private ResonanceHome resonance;
    private Stage stage;
    
    public ResonanceHome getResonance() {
		return resonance;
	}

	public void setResonance(ResonanceHome resonance) {
		this.resonance = resonance;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
}
