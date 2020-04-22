package com.resonance.view.controller;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
public class ControladorFotosHospedaje {

	private ImageView pic;

    @FXML
    private GridPane gridFotos;
    @FXML
    private GridPane gridFotos2;
	
	public void inicializar() {
		
		Image image = new Image ("com/resonance/view/imagenes/boton_buscar.png");
		
		pic = new ImageView();
		
		pic.setImage(image);
		
		
		gridFotos.getChildren().add(new Label("Foto1"));
		
		
		gridFotos2.add(pic, 0, 0);
		gridFotos2.add(new Label("Otra foto"), 0, 1);
		
		
	}
	
	
	
}
