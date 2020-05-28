package com.resonance.view.controller;
import java.io.IOException;

import com.resonance.model.principal.ResonanceHome;
import com.resonance.model.util.Util;
import com.resonance.view.interfaz.StageR;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControladorPerfilAnfitrion {
	
	private ResonanceHome resonance;
	
	private StageR stage;
	
	@FXML
    private Text btnAtras;

    @FXML
    private Button btnGuardar;

    @FXML
    private Label labelEditar;

    @FXML
    private Rectangle rectanguloFoto;

    @FXML
    private Label labelAnfitrionNombre;

    @FXML
    private Button btnCancelar;

    @FXML
    private ScrollPane scrollHospedajes;

    @FXML
    private ImageView picPerfil;

    @FXML
    private VBox vBoxListadoHospedajes;

    @FXML
    private TextArea textDescripcion;
   
    	
    	
public void inicializar () {
			
		
			
			crearEjemplo();

		
			
			
			
    	
    }





	public void crearEjemplo () {
		
		for (int i = 0; i < 5; i++) {

			FXMLLoader loader3 = new FXMLLoader(getClass().getResource(Util.PANEL_HOSPEDAJE_PERFIL));
			Parent root3 = null;
			try {
				root3 = loader3.load();
			} catch (IOException a) {
				// TODO Auto-generated catch block
				a.printStackTrace();
			}
			vBoxListadoHospedajes.getChildren().add(root3);

			ControladorHospedajePerfil control = loader3.getController();
			
			control.setResonance(resonance);
			control.setStage(stage);
			
			control.inicializar();
			
			

		}
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
