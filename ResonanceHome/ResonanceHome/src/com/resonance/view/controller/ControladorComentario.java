package com.resonance.view.controller;
import com.resonance.model.principal.ResonanceHome;
import com.resonance.model.txt.Mensaje;
import com.resonance.model.usuarios.Huesped;
import com.resonance.view.interfaz.StageR;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ControladorComentario {
	
	private ResonanceHome resonance;
	



	private StageR stage;
	
	private Mensaje mensaje;
	
    @FXML
    private Label fecha;

    @FXML
    private AnchorPane lComentario;

    @FXML
    private TextArea textComentario;

    @FXML
    private Label nombreUsuario;
    
    @FXML
    private ImageView imageComentario;
    
    
    public void inicializar() {
    	
		fecha.setText(mensaje.getFecha().toString());
    	Huesped huesped = resonance.obtenerHuesped(mensaje.getEmisor());
    	
		if (!huesped.getURLFoto().equals("")) {
			imageComentario.setImage(new Image("file:///" + huesped.getURLFoto()));
    	}
    	
    	textComentario.setText(mensaje.getMensaje());
    	
    	nombreUsuario.setText(huesped.getNombre());
    	
    	
    	
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

	public Mensaje getMensaje() {
		return mensaje;
	}

	public void setMensaje(Mensaje mensaje) {
		this.mensaje = mensaje;
	}
	
	
    
}
