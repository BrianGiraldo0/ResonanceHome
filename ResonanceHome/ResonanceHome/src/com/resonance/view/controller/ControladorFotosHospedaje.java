package com.resonance.view.controller;

import java.util.ArrayList;

import com.resonance.model.hospedajes.Hospedaje;
import com.resonance.model.principal.ResonanceHome;
import com.resonance.view.interfaz.StageR;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Proyecto de programación - Analisis de algoritmos
 * 
 * @author Cesar Marquez, Brian Giraldo, Esteban Sanchez
 *
 */
public class ControladorFotosHospedaje {
	
	
	private ResonanceHome resonance;
	
	private StageR stage;
	
	private Hospedaje hospedaje;

	@FXML
	private ImageView vImage;

    @FXML
	private ImageView vAtras;
	private int numeroFoto = 0;
    @FXML
	private ImageView vSiguiente;
    
	
	public void inicializar() {
		
		ArrayList<String> urls = hospedaje.getUrlsFotos();
		
		if (urls.size() > 0) {
			vImage.setImage(new Image("file:///" + urls.get(numeroFoto)));
		}
		
		vAtras.setOnMouseClicked((e) -> {
			if (numeroFoto - 1 < 0)
				numeroFoto = urls.size() - 1;
			else
				numeroFoto--;
			vImage.setImage(new Image("file:///" + urls.get(numeroFoto)));
		});
		vSiguiente.setOnMouseClicked((e) -> {
			if (numeroFoto + 1 == urls.size())
				numeroFoto = 0;
			else
				numeroFoto++;
			vImage.setImage(new Image("file:///" + urls.get(numeroFoto)));
		});
		
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
