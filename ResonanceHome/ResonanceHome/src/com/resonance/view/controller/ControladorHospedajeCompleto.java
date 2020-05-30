package com.resonance.view.controller;

import java.io.IOException;

import com.resonance.model.hospedajes.Hospedaje;
import com.resonance.model.principal.ResonanceHome;
import com.resonance.model.util.Util;
import com.resonance.view.interfaz.StageR;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ControladorHospedajeCompleto {

	private ResonanceHome resonance;
	
	private StageR stage;
	  
	private Hospedaje hospedaje;
	
	@FXML
	private Label labelTotal;

	@FXML
	private TextField textCantidadHuespedes;


	@FXML
	private Label labelPrecioAlojamiento;

	@FXML
	private Label labelPrecioDia;

	@FXML
	private Button btnReservar;

	@FXML
	private Label labelPrecioLimpieza;

	@FXML
	private DatePicker dateFechas;

	@FXML
	private Label labelComision;

	@FXML
	private Label labelTipo;

	@FXML
	private VBox layoutScroll;

	@FXML
	private Text btnAtras;
	

	public void inicializar() {

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
		con.setResonance(resonance);
		con.setStage(stage);
		con.setHospedaje(hospedaje);
		con.inicializar();

		for (int i = 0; i < 5; i++) {

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
	
	
	public void reservar() {
		
	
		FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_PAGO));
		Parent root = null;
		
		try {
			root = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ControladorPago con = loader.getController();
		con.setStage(stage);
		con.setResonance(resonance);
		stage.getScene().setRoot(root);
//		con.inicializar();
		
		
	}

	public Hospedaje getHospedaje() {
		return hospedaje;
	}

	public void setHospedaje(Hospedaje hospedaje) {
		this.hospedaje = hospedaje;
	}

	public void setResonance(ResonanceHome resonance) {
		this.resonance = resonance;
	}

	public void setStage(StageR stage) {
		this.stage = stage;
	}

}
