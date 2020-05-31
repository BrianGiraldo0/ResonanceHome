package com.resonance.view.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import com.resonance.model.hospedajes.Hospedaje;
import com.resonance.model.principal.ResonanceHome;
import com.resonance.model.util.Util;
import com.resonance.view.interfaz.StageR;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ControladorGestionCalificacion {

	private StageR stage;
	private int numeroHuspedes;

	private ArrayList<Date> date;
	private ResonanceHome resonance;
	
	private Hospedaje hospedaje;
	
    @FXML
    private ScrollPane scrollReservas;

    @FXML
    private VBox vBoxReservas;

    @FXML
    private Text btnAtras;
    
    public void inicializar()
    {
		btnAtras.setOnMouseClicked((e) -> {
			abrirVentanaAnterior();
		});
    	crearGraficas();
    }

	public void abrirVentanaAnterior() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_HOSPEDAJE_COMPLETO));
		try {
			Parent root = loader.load();

			ControladorHospedajeCompleto control = loader.getController();
			control.setResonance(resonance);
			control.setHospedaje(hospedaje);
			control.setNumeroHuspedes(numeroHuspedes);
			control.setStage(stage);
			control.setDate(date);
			control.inicializar();
			stage.getScene().setRoot(root);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
    public void crearGraficas() {
		vBoxReservas.getChildren().clear();
		for (int i = 0; i < 4; i++) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_GRAFICA));
			Parent root = null;
			try {
				root = loader.load();
			} catch (IOException a) {
				// TODO Auto-generated catch block
				a.printStackTrace();
			}
			vBoxReservas.getChildren().add(root);

			ControladorGrafica control = loader.getController();
			control.setResonance(resonance);
			control.setHospedaje(hospedaje);
			control.setTipo(i);
			control.setStage(stage);
			control.inicializar();

		}
	}

	public Hospedaje getHospedaje() {
		return hospedaje;
	}

	public void setHospedaje(Hospedaje hospedaje) {
		this.hospedaje = hospedaje;
	}

	public StageR getStage() {
		return stage;
	}

	public void setStage(StageR stage) {
		this.stage = stage;
	}

	public ResonanceHome getResonance() {
		return resonance;
	}

	public void setResonance(ResonanceHome resonance) {
		this.resonance = resonance;
	}

	/**
	 * @return the numeroHuspedes
	 */
	public int getNumeroHuspedes() {
		return numeroHuspedes;
	}

	/**
	 * @param numeroHuspedes the numeroHuspedes to set
	 */
	public void setNumeroHuspedes(int numeroHuspedes) {
		this.numeroHuspedes = numeroHuspedes;
	}

	/**
	 * @return the date
	 */
	public ArrayList<Date> getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(ArrayList<Date> date) {
		this.date = date;
	}

}
