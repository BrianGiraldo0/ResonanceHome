package com.resonance.view.controller;
import java.io.IOException;

import com.resonance.model.principal.ResonanceHome;
import com.resonance.model.util.Util;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ControladorGestionReservas {

	
    @FXML
    private Button btnProxima;

    @FXML
    private Button btnAnterior;
	
    @FXML
    private ScrollPane scrollReservas;

    @FXML
    private VBox vBoxReservas;

    private ResonanceHome resonance;
    private Stage stage;
 
    	
    	
public void inicializar () {
			
			crearEjemplo();
			colorearBotones();
			
			
			

		
			
			
			
    	
    }

	public void crearEjemplo() {
		
		for (int i=0; i<5;i++) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/resonance/view/interfaz/panelDescripcionReserva.fxml"));
			Parent root = null;
			try {
				root = loader.load();
			} catch (IOException a) {
				// TODO Auto-generated catch block
				a.printStackTrace();
			}
			
			vBoxReservas.getChildren().add(root);

			ControladorDescripcionReserva control = loader.getController();
			control.inicializar();
		}
	}
	
public void crearEjemploProximas() {
		
		for (int i=0; i<5;i++) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/resonance/view/interfaz/panelDescripcionReserva.fxml"));
			Parent root = null;
			try {
				root = loader.load();
			} catch (IOException a) {
				// TODO Auto-generated catch block
				a.printStackTrace();
			}
			
			ControladorDescripcionReserva control = loader.getController();
			control.inicializar();
			control.setFutura();
			vBoxReservas.getChildren().add(root);

			
		}
	}
	
	public void cargarAnteriores() {
		
		vBoxReservas.getChildren().clear();
		crearEjemplo();
		
		
	}
	
	public void cargarProximas() {
		
		vBoxReservas.getChildren().clear();
		crearEjemploProximas();
	}
	
	public void colorearBotones() {
	
		btnProxima.setOnMouseEntered((e) -> {

			btnProxima.setStyle("-fx-background-color: #EBE8EE");
		});
		btnProxima.setOnMouseExited((e) -> {
			btnProxima.setStyle("-fx-background-color: #FFFFFF");
		});
		
		btnAnterior.setOnMouseEntered((e) -> {

			btnAnterior.setStyle("-fx-background-color: #EBE8EE");
		});
		btnAnterior.setOnMouseExited((e) -> {
			btnAnterior.setStyle("-fx-background-color: #FFFFFF");
		});
		
	}

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