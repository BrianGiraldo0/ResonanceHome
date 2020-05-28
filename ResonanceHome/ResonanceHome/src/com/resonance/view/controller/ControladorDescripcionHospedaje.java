package com.resonance.view.controller;

import java.io.IOException;

import com.resonance.model.principal.ResonanceHome;
import com.resonance.model.util.Util;
import com.resonance.view.interfaz.StageR;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;



public class ControladorDescripcionHospedaje {
    	private ResonanceHome resonance;
    	private StageR stage;	
	
		@FXML
	    private Label labelNombreAnfitrion;

	    @FXML
	    private Label labelNumeroHabitaciones;

	    @FXML
	    private Label labelCatDesc3;

	    @FXML
	    private Label labelTituloAlojamiento;

	    @FXML
	    private Label labelNumeroHuespedes;

	    @FXML
	    private TextArea textDescripcionAnfitrion;

	    @FXML
	    private Label labelCat2;

	    @FXML
	    private Label labelNumeroCamas;

	    @FXML
	    private Label labelCat3;

	    @FXML
	    private Label labelCat1;

	    @FXML
	    private Rectangle fotoPerfilAnfitrion;

	    @FXML
	    private Label labelCatDesc1;

	    @FXML
	    private Label labelCatDesc2;

	    @FXML
	    private Label lablBanos;

	    @FXML
	    private TextArea textDescripcionAlojamiento;

	    @FXML
	    private Label labelDireccionAlojamiento;
	    
	    @FXML
	    private Button btnVerPerfilAnfitrion;
	    
	    
	    
	    public void inicializar() {
	    	
	    }
	    

	    @FXML
	    void verPerfil(ActionEvent event) {
	    	
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_PERFIL_ANFITRION));
			Parent root = null;
			try {
				root = loader.load();
			} catch (IOException a) {
				// TODO Auto-generated catch block
				a.printStackTrace();
			}
			

			ControladorPerfilAnfitrion control = loader.getController();
			control.setResonance(resonance);
			control.setStage(stage);
			
			Scene scene = new Scene(root);

			stage.setResizable(false);
			stage.setTitle("Resonance Home");
			stage.getIcons().add(new Image(Util.LOGO_RESONANCE));
			stage.setScene(scene);
			stage.show();
		
			control.inicializar();
	    	
	    	
	    	
	    	
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

		public void setStage(StageR stage) {
			this.stage = stage;
		}
		

}
