package com.resonance.view.controller;

import java.io.File;

import com.resonance.model.excepciones.NoExistException;
import com.resonance.model.hospedajes.Hospedaje;
import com.resonance.model.principal.ResonanceHome;
import com.resonance.view.interfaz.StageR;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.StageStyle;

public class ControladorRegPropiedad4 {
	private StageR stage;

	
	private Hospedaje hospedaje;
	
	private ResonanceHome resonance;
	@FXML
	private AnchorPane idPaso1;
	@FXML
	private Button btnAtras;

	@FXML

	private Button btnPublicar;

	@FXML
	private AnchorPane lUbicacion;

	@FXML
	private AnchorPane lFecha;

	@FXML
	private AnchorPane lHuespedes;

	@FXML
	private AnchorPane lHuespedes1;

	@FXML
	private AnchorPane idImage;

	@FXML
	private ImageView idImagen;

	@FXML
	private TextField txtTitulo;

	@FXML
	private TextArea txtDescripcion;

	@FXML
	private ImageView image1;

	@FXML
	private Label interrogacionFoto;

	@FXML
	private ImageView image2;

	@FXML
	private Label interrogacionFoto1;

	@FXML
	private ImageView image3;

	@FXML
	private Label interrogacionFoto11;

	@FXML
	private ImageView image4;

	@FXML
	private Label interrogacionFoto111;

	@FXML
	void onClic(MouseEvent event) {
		
		if (event.getSource() == btnPublicar) {
			
			
			hospedaje.setDescripcion(txtDescripcion.getText());
			hospedaje.setTitulo(txtTitulo.getText());
		
			
			
			
			try {
				hospedaje.setNameTagPropietario(stage.getUsuarioLogeado().getNametag());
				resonance.agregarHospedaje(hospedaje);
			} catch (NoExistException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}

		if (event.getSource() == interrogacionFoto) {
			
			
			FileChooser fileChooser = new FileChooser();

			fileChooser.getExtensionFilters()
					.addAll(new FileChooser.ExtensionFilter("Archivos de imagen", "*.jpg", "*.png")

			);

			File selectedFile = fileChooser.showOpenDialog(stage);
			

			if (selectedFile != null) {
				
				interrogacionFoto.setVisible(false);
				

				Image image = new Image(selectedFile.toURI().toString());
				image1.setImage(image);
				
				hospedaje.urlsFotos.add(selectedFile.getAbsolutePath());
				

			} else {
				
				interrogacionFoto.setVisible(true);
			}
		}

		if (event.getSource() == interrogacionFoto1) {
			
			
			FileChooser fileChooser = new FileChooser();

			fileChooser.getExtensionFilters()
					.addAll(new FileChooser.ExtensionFilter("Archivos de imagen", "*.jpg", "*.png")

			);

			File selectedFile = fileChooser.showOpenDialog(stage);
			

			if (selectedFile != null) {
				
				interrogacionFoto1.setVisible(false);
				

				Image image = new Image(selectedFile.toURI().toString());
				image2.setImage(image);
				
				hospedaje.urlsFotos.add(selectedFile.getAbsolutePath());
				

			} else {
				
				interrogacionFoto1.setVisible(true);
			}
		}

		if (event.getSource() == interrogacionFoto11) {
			
			
			FileChooser fileChooser = new FileChooser();

			fileChooser.getExtensionFilters()
					.addAll(new FileChooser.ExtensionFilter("Archivos de imagen", "*.jpg", "*.png")

			);

			File selectedFile = fileChooser.showOpenDialog(stage);
			

			if (selectedFile != null) {
				
				interrogacionFoto11.setVisible(false);
				

				Image image = new Image(selectedFile.toURI().toString());
				image3.setImage(image);
				
				hospedaje.urlsFotos.add(selectedFile.getAbsolutePath());
				

			} else {
				
				interrogacionFoto11.setVisible(true);
			}
		}

		if (event.getSource() == interrogacionFoto111) {
			
			
			FileChooser fileChooser = new FileChooser();

			fileChooser.getExtensionFilters()
					.addAll(new FileChooser.ExtensionFilter("Archivos de imagen", "*.jpg", "*.png")

			);

			File selectedFile = fileChooser.showOpenDialog(stage);
			

			if (selectedFile != null) {
				
				interrogacionFoto111.setVisible(false);
				

				Image image = new Image(selectedFile.toURI().toString());
				image4.setImage(image);
				
				hospedaje.urlsFotos.add(selectedFile.getAbsolutePath());
				

			} else {
				
				interrogacionFoto111.setVisible(true);
			}
		}
	}
	
	public void setHospedaje(Hospedaje hospedaje) {
		this.hospedaje = hospedaje;
	}
	
	public Hospedaje  getHospedaje() {
		return hospedaje;
	}

	public void setResonance(ResonanceHome resonance) {
		this.resonance = resonance;
	}

	public void setStageR(StageR stage) {
		this.stage = stage;
	}

	public static void showConfirmation(String title, String message) {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.initStyle(StageStyle.UTILITY);
		alert.setTitle("Warning");
		alert.setHeaderText(title);
		alert.setContentText(message);

		alert.showAndWait();
	}
}