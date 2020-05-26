package com.resonance.view.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

import com.resonance.model.hospedajes.Hospedaje;
import com.resonance.model.principal.ResonanceHome;
import com.resonance.model.util.Util;
import com.resonance.view.interfaz.AutoCompleteTextField;
import com.resonance.view.interfaz.StageR;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ControladorListadoHospedajes {
	private StageR stage;

	private ResonanceHome resonance;
	private String estadia;
	@FXML
	private Button btnAyuda;

	@FXML
	private Button btniniciarSesion;
	
    @FXML
    private Text btnAtras;
    
	@FXML
	private Button btnRegistro;

	@FXML
	private ImageView btnBuscar;

	@FXML
	private AnchorPane lUbicacion;

	private AutoCompleteTextField<String> tfUbicacion;

	@FXML
	private AnchorPane lFecha;

	@FXML
	private AnchorPane layout;

	@FXML
	private AnchorPane lHuespedes;

	@FXML
	private TextField tfHuespedes;

	@FXML
	private Label lblNumEstadias;

	@FXML
	private Label lblEstadias;

	@FXML
	private VBox lBox;

	private ArrayList<Hospedaje> hospedajes;

	@FXML
	void onClick(MouseEvent event) {

	}

	public void inicializar() {
		SortedSet<String> entries = new TreeSet<>((String o1, String o2) -> o1.toString().compareTo(o2.toString()));

		for (int i = 0; i < Util.listadoSugerencias.size(); i++) {
			entries.add(Util.listadoSugerencias.get(i));
		}

		tfUbicacion = new AutoCompleteTextField<String>(entries);

		tfUbicacion.getEntryMenu().setOnAction(e -> {
			((MenuItem) e.getTarget()).addEventHandler(Event.ANY, event -> {
				if (tfUbicacion.getLastSelectedObject() != null) {
					tfUbicacion.setText(tfUbicacion.getLastSelectedObject().toString());
				}
			});
		});
		tfUbicacion.setPrefWidth(180);
		tfUbicacion.setPrefHeight(25);
		tfUbicacion.setPromptText("Ingrese la ciudad de referencia.");
		lUbicacion.getChildren().add(tfUbicacion);
		tfUbicacion.setLayoutX(16);
		tfUbicacion.setLayoutY(22);

		lBox.setStyle("-fx-background-color: #FFFFFF");
		colorearBotones();
		crearHospedajes();

	}

	public void crearHospedajes() {
		lblNumEstadias.setText(hospedajes.size() + " estadias");
		lblEstadias.setText("Estadias en " + estadia);

		System.out.println(hospedajes.size());
		for (int i = 0; i < hospedajes.size(); i++) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_HOSPEDAJE));
			Parent root = null;
			try {
				root = loader.load();
			} catch (IOException a) {
				// TODO Auto-generated catch block
				a.printStackTrace();
			}
			lBox.getChildren().add(root);

			ControladorHospedaje control = loader.getController();
			control.setResonance(resonance);
			control.setStage(stage);
			control.setHospedaje(hospedajes.get(i));
			control.inicializar();

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

		// Botón iniciar sesión
		btniniciarSesion.setOnMouseEntered((e) -> {

			btniniciarSesion.setStyle("-fx-background-color: #EBE8EE");
		});

		btniniciarSesion.setOnMouseExited((e) -> {
			btniniciarSesion.setStyle("-fx-background-color: #FFFFFF");
		});
	}

	public void setResonance(ResonanceHome resonance) {
		this.resonance = resonance;
	}

	public void setStage(StageR stage) {
		this.stage = stage;
	}

	/**
	 * @return the hospedajes
	 */
	public ArrayList<Hospedaje> getHospedajes() {
		return hospedajes;
	}

	/**
	 * @param hospedajes the hospedajes to set
	 */
	public void setHospedajes(ArrayList<Hospedaje> hospedajes) {
		this.hospedajes = hospedajes;
	}

	public String getEstadia() {
		return estadia;
	}

	public void setEstadia(String estadia) {
		this.estadia = estadia;
	}

}