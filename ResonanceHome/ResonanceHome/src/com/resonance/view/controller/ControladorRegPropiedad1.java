package com.resonance.view.controller;

import java.io.IOException;

import com.resonance.model.hospedajes.Direccion;
import com.resonance.model.hospedajes.Hospedaje;
import com.resonance.model.hospedajes.Prestacion;
import com.resonance.model.hospedajes.TipoHospedaje;
import com.resonance.model.principal.ResonanceHome;
import com.resonance.model.util.Util;
import com.resonance.view.interfaz.StageR;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class ControladorRegPropiedad1 {

	private StageR stage;

	private ResonanceHome resonance;
	
	private Hospedaje hospedaje;
	
    @FXML
    private Text btnAtras;

	@FXML
	private Button btnSiguiente;
	
	@FXML
	private AnchorPane idPaso1;

	@FXML
	private ComboBox<String> comboTipo;

	@FXML
	private ComboBox<String> comboCapacidad;

	@FXML
	private TextField tfUbicacion1;

	@FXML
	private AnchorPane lUbicacion;

	@FXML
	private AnchorPane lFecha;
	
	@FXML
	
	private Label lblCuantasHabitaciones;
	
	@FXML
	private Label lblHabitaciones;
	
	@FXML
	private AnchorPane lHuespedes;

	@FXML
	private AnchorPane lHuespedes1;

	@FXML
	private AnchorPane idImage;

	@FXML
	private ImageView idImagen;

	@FXML
	private Button btnAddH;

	@FXML
	private Button btnAddC;

	@FXML
	private Button btnAddB;

	@FXML
	private Button btnResH;

	@FXML
	private Button btnResC;

	@FXML
	private Button btnResB;

	@FXML
	private Label lblCantH;

	@FXML
	private Label lblCantC;

	@FXML
	private Label lblCantB;

	@FXML
	void onClic(MouseEvent event) {
		if (event.getSource() == btnAddH) {
			int i = Integer.parseInt(lblCantH.getText());
			String aux = "" + (i + 1);
			lblCantH.setText(aux);
		}
		if (event.getSource() == btnAddC) {
			int i = Integer.parseInt(lblCantC.getText());
			String aux = "" + (i + 1);
			lblCantC.setText(aux);
		}
		if (event.getSource() == btnAddB) {
			int i = Integer.parseInt(lblCantB.getText());
			String aux = "" + (i + 1);
			lblCantB.setText(aux);
		}
		if (event.getSource() == btnResH) {
			int i = Integer.parseInt(lblCantH.getText());
			String aux = "" + (i - 1);
			lblCantH.setText(aux);
		}
		if (event.getSource() == btnResC) {
			int i = Integer.parseInt(lblCantC.getText());
			String aux = "" + (i - 1);
			lblCantC.setText(aux);
		}
		if (event.getSource() == btnResB) {
			int i = Integer.parseInt(lblCantB.getText());
			String aux = "" + (i - 1);
			lblCantB.setText(aux);
		} else if (event.getSource() == btnSiguiente) {
			
			
			
			hospedaje = new Hospedaje ();
			
				
			String tipo = comboTipo.getSelectionModel().getSelectedItem();
	
			int can = comboCapacidad.getSelectionModel().getSelectedIndex() +1;
			int banios = Integer.parseInt(lblCantB.getText());
			int camas = Integer.parseInt(lblCantC.getText());
			int hab = Integer.parseInt(lblCantH.getText());
			
			
			if (tipo.equals("Habitacion")) {
			
			hospedaje.setTipoHospedaje(TipoHospedaje.HABITACION);
			} else {
				hospedaje.setTipoHospedaje(TipoHospedaje.APARTAMENTO);
			}
			
			hospedaje.setDireccion(new Direccion(tfUbicacion1.getText(), "", "", ""));
			
			hospedaje.setPrestaciones(new Prestacion(can,banios,camas,hab,false));
			
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_REGPROPIEDAD_2));
			Parent root = null;
			try {
				root = loader.load();
			} catch (IOException a) {
				// TODO Auto-generated catch block
				a.printStackTrace();
			}

			ControladorRegPropiedad2 control = loader.getController();
			control.setResonance(resonance);
			control.setStageR(stage);
			control.setHospedaje(hospedaje);
			control.inicializar();
			stage.setResizable(false);
			stage.getScene().setRoot(root);

		} else if (event.getSource() == btnAtras) {

		}
	}

	public void llenarDatos() {
		comboTipo.setValue(hospedaje.getTipoHospedaje().toString());
		comboCapacidad.setValue(hospedaje.getPrestaciones().getNumHuesped() + "");
		tfUbicacion1.setText(hospedaje.getDireccion().getCiudad());
		lblCantH.setText(hospedaje.getPrestaciones().getNumHabitaciones() + "");
		lblCantC.setText(hospedaje.getPrestaciones().getNumCamas() + "");
		lblCantB.setText(hospedaje.getPrestaciones().getNumBanios() + "");

	}
	private void atras() {
		btnAtras.setOnMouseClicked((e) -> {
			abrirVentanaAnterior();

		});
	}
	
	
	@FXML
    void controlarTipo(ActionEvent event) {
		
		
		if (!comboTipo.getSelectionModel().getSelectedItem().equals("Habitacion")) {
			
			lblCuantasHabitaciones.setVisible(false);
			btnResH.setVisible(false);
			lblCantH.setVisible(false);
			lblHabitaciones.setVisible(false);
			btnAddH.setVisible(false);
			
			
			
			
			
		} else {
			
			
			lblCuantasHabitaciones.setVisible(true);
			btnResH.setVisible(true);
			lblCantH.setVisible(true);
			lblHabitaciones.setVisible(true);
			btnAddH.setVisible(true);		}
		
    }
	
	

	public void abrirVentanaAnterior() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(stage.getVentanaAnterior()));
		try {
			Parent root = loader.load();
			stage.getScene().setRoot(root);
			Util.updateController(loader, stage, resonance);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void inicializar() {
		if (hospedaje != null) {
			llenarDatos();
		}
		comboTipo.setValue("Tipo");
		comboTipo.getItems().addAll("Apartamento", "Habitacion");

		comboCapacidad.setValue("Capacidad");
		for (int i = 0; i < 50; i++) {
			comboCapacidad.getItems().add(i, (i + 1) + " Huespedes");
		}

		atras();
	}

	public void setResonance(ResonanceHome resonance) {
		this.resonance = resonance;
	}

	public void setHospedaje(Hospedaje hospedaje) {
		this.hospedaje = hospedaje;
	}

	public void setStage(StageR stage) {
		this.stage = stage;
	}
}
