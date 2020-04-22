package com.resonance.view.controller;
import java.io.IOException;

import com.resonance.model.principal.ResonanceHome;
import com.resonance.model.util.Util;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ControladorHospedajeCompleto {
	
	
	private ResonanceHome resonance;
	private Stage stage;
	
	
		@FXML
	    private VBox layoutScroll;
	
		
		
		public void inicializar () {
			
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_FOTOS_HOSPEDAJE));
			Parent root = null;
			try {
				root = loader.load();
			} catch (IOException a) {
				// TODO Auto-generated catch block
				a.printStackTrace();
			}
			layoutScroll.getChildren().add(root);

			ControladorFotosHospedaje control = loader.getController();
			control.inicializar();
			
			
			

			FXMLLoader loader2 = new FXMLLoader(getClass().getResource(Util.PANEL_DESCRIPCION_HOSPEDAJE));
			Parent root2 = null;
			try {
				root2 = loader2.load();
			} catch (IOException a) {
				// TODO Auto-generated catch block
				a.printStackTrace();
			}
			layoutScroll.getChildren().add(root2);
			
			ControladorDescripcionHospedaje con = loader2.getController();
			con.inicializar();
			
			
			for (int i=0;i<5;i++) {
				
				FXMLLoader loader3 = new FXMLLoader(getClass().getResource(Util.PANEL_COMENTARIO));
				Parent root3 = null;
				try {
					root3 = loader3.load();
				} catch (IOException a) {
					// TODO Auto-generated catch block
					a.printStackTrace();
				}
				layoutScroll.getChildren().add(root3);
				
				ControladorComentario con3 = loader3.getController();
				con3.inicializar();
				
				
			}
		
			
		}
	
	
	
		public void setResonance(ResonanceHome resonance) {
			this.resonance = resonance;
		}

		public void setStage(Stage stage) {
			this.stage = stage;
		}
	
	
}
