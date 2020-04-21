package com.resonance.view.controller;
import com.resonance.model.principal.ResonanceHome;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class ControladorLogIn {

    @FXML
    private Label tituloInicioSesion;

    @FXML
    private PasswordField textPassword;

    @FXML
    private TextField textUsuario;
    
    
    private String url;
    private Stage stage;
	private ResonanceHome resonance;

    @FXML
    private Label btnCreaCuenta;

    @FXML
    private Button btnInicioSesion;

   
    
    
    
    
    public void setResonance(ResonanceHome resonance) {
		this.resonance = resonance;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
    
    
}
