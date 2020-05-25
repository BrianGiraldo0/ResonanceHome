package com.resonance.view.controller;
import com.resonance.model.principal.ResonanceHome;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;





public class ControladorDescripcionReserva {

	 @FXML
	    private Label lblFechasReserva;

	    @FXML
	    private Label lblDireccionHospedaje;

	    @FXML
	    private Label lbllNombreAnfitrionReserva;

	    @FXML
	    private Label lblNombreHospedaje;

	    @FXML
	    private Button btnEstado;

	    @FXML
	    private Label lblNumeroHuespedesReserva;

	    @FXML
	    private Label lblPrecioReserva;
	    
	    @FXML
	    private Label lblFutura;
	    @FXML
	    private ImageView imgViewHospedajeReserva;

	    @FXML
	    private Label lblTipoHospedajeReserva;
	    
	    private ResonanceHome resonance;
	    private Stage stage;
	    
	    
	    public void inicializar() {
	    	
	    }
	    
	    
	    public void setFutura() {
	    	
	    	lblFutura.setVisible(true);
	    	
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
