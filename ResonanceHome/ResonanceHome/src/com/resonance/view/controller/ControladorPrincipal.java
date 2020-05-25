package com.resonance.view.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;

import com.resonance.model.hospedajes.Hospedaje;
import com.resonance.model.principal.ResonanceHome;
import com.resonance.model.util.Util;
import com.resonance.view.interfaz.AutoCompleteTextField;
import com.resonance.view.interfaz.MultiDatePicker;
import com.resonance.view.interfaz.StageR;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ControladorPrincipal {

	@FXML
	private ImageView btnBuscar;

	private StageR stage;

	private ResonanceHome resonance;

	@FXML
	private Button btnCrearPropiedad;

	@FXML
	private Button btnAyuda;

	@FXML
	private Button btniniciarSesion;

	@FXML
	private Button btnRegistro;

	@FXML
	private AnchorPane lUbicacion;

	private AutoCompleteTextField<String> tfUbicacion;

	@FXML
	private TextField tfHuespedes;

	@FXML
	private AnchorPane lHuespedes;

	@FXML
	private AnchorPane lFecha;

	@FXML
	private AnchorPane layout;

	public void inicializar() {
		MultiDatePicker multiDatePicker = new MultiDatePicker().withRangeSelectionMode();

		DatePicker rangePicker = multiDatePicker.getDatePicker();
		rangePicker.setMinWidth(200);
		layout.getChildren().add(rangePicker);
		colorearBotones();
		btnBuscar.setOnMouseClicked((e) -> {
			String ubicacion = tfUbicacion.getText();
			String huespedes = tfHuespedes.getText();
			ArrayList<Date> date = new ArrayList<Date>();
			ArrayList<Hospedaje> ltsHospedajes = resonance.buscarHospedajes(ubicacion, date, huespedes);

 			FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_LISTADO_HOSPEDAJES));
			Parent root = null;
			try {
				root = loader.load();
			} catch (IOException a) {
				// TODO Auto-generated catch block
				a.printStackTrace();
			}

			ControladorListadoHospedajes control = loader.getController();
			control.setHospedajes(ltsHospedajes);

			control.setResonance(resonance);
			control.setStage(stage);
			control.inicializar();
			stage.setResizable(false);
			stage.getScene().setRoot(root);
		});
		
		SortedSet<String> entries = new TreeSet<>((String o1, String o2) -> o1.toString().compareTo(o2.toString()));

    	for(int i=0;i<Util.listadoSugerencias.size();i++)
    	{
    		entries.add(Util.listadoSugerencias.get(i));
    	}

    	 tfUbicacion = new AutoCompleteTextField<String>(entries);

    	tfUbicacion.getEntryMenu().setOnAction(e ->
    	{
    	    ((MenuItem) e.getTarget()).addEventHandler(Event.ANY, event ->
    	    {
    	         if (tfUbicacion.getLastSelectedObject() != null)
    	         {
    	            tfUbicacion.setText(tfUbicacion.getLastSelectedObject().toString());
    	         }
    	    });
    	});
    	
    	tfUbicacion.setPrefWidth(252);
    	tfUbicacion.setPrefHeight(25);
    	tfUbicacion.setPromptText("Ingrese la ciudad de referencia.");
    	lUbicacion.getChildren().add(tfUbicacion);
    	tfUbicacion.setLayoutX(16);
    	tfUbicacion.setLayoutY(22);

	}

	@FXML
	void onClick(MouseEvent event) {
		if (event.getSource() == btnAyuda) {
			lUbicacion.setStyle("-fx-border-color: black; -fx-border-radius: 15");
			lFecha.setStyle("-fx-border-color: black; -fx-border-radius: 15");
			lHuespedes.setStyle("-fx-border-color: black; -fx-border-radius: 15");

		} else if (event.getSource() == btniniciarSesion) {

			FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_INICIAR_SESION));
			Parent root = null;
			try {
				root = loader.load();
			} catch (IOException a) {
				// TODO Auto-generated catch block
				a.printStackTrace();
			}

			stage.setVentanaAnterior(Util.VENTANA_PRINCIPAL);
			ControladorLogIn control = loader.getController();
			control.setStage(stage);
			control.setResonance(resonance);

			stage.setResizable(false);
			stage.getScene().setRoot(root);

		} else if (event.getSource() == btnRegistro) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_REGISTRO));
			Parent root = null;
			try {
				root = loader.load();
			} catch (IOException a) {
				// TODO Auto-generated catch block
				a.printStackTrace();
			}

			ControladorRegistro control = loader.getController();
			control.setResonance(resonance);
			control.setStage(stage);

			stage.setResizable(false);
			stage.getScene().setRoot(root);

		} else if (event.getSource() == btnCrearPropiedad) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_REGPROPIEDAD_1));
			Parent root = null;
			try {
				root = loader.load();
			} catch (IOException a) {
				// TODO Auto-generated catch block
				a.printStackTrace();
			}

			ControladorRegPropiedad1 control = loader.getController();
			control.setResonance(resonance);
			control.setStage(stage);
			control.inicializar();
			stage.setResizable(false);
			stage.getScene().setRoot(root);
		}
	}

	public void colorearBotones() {
		// Botón ayuda
		btnAyuda.setOnMouseEntered((e) -> {

			btnAyuda.setStyle("-fx-background-color: #EBE8EE");
		});
		btnAyuda.setOnMouseExited((e) -> {
			btnAyuda.setStyle("-fx-background-color: #FFFFFF");
		});

		// Boton crear propiedad
		btnCrearPropiedad.setOnMouseEntered((e) -> {

			btnCrearPropiedad.setStyle("-fx-background-color: #EBE8EE");
		});
		btnCrearPropiedad.setOnMouseExited((e) -> {
			btnCrearPropiedad.setStyle("-fx-background-color: #FFFFFF");
		});

		// Botón iniciar sesión
		btniniciarSesion.setOnMouseEntered((e) -> {

			btniniciarSesion.setStyle("-fx-background-color: #EBE8EE");
		});
		btniniciarSesion.setOnMouseExited((e) -> {
			btniniciarSesion.setStyle("-fx-background-color: #FFFFFF");
		});
	}

	public void update() {
		/*
		 * Aquí va para actualizar cuando inicie sesión
		 */
	}
	public void setResonance(ResonanceHome resonance) {
		this.resonance = resonance;
	}

	public void setStage(StageR stage) {
		this.stage = stage;
	}
}
