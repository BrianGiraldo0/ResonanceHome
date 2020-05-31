package com.resonance.view.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import com.resonance.model.hospedajes.Hospedaje;
import com.resonance.model.principal.ResonanceHome;
import com.resonance.model.usuarios.Huesped;
import com.resonance.model.util.Util;
import com.resonance.view.interfaz.StageR;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.StageStyle;

public class ControladorHospedaje {

	private StageR stage;

	private boolean favorito = false;

	private Hospedaje hospedaje;

	private ResonanceHome resonance;

	private int numeroHuspedes;

	private ArrayList<Date> date;
	
	@FXML
	private Label lblPrecio;

	@FXML
	private Label lblPlus;

	@FXML
	private ImageView imageFotos;

	@FXML
	private ImageView btnAnterior;

	@FXML
	private ImageView btnSiguiente;

	@FXML
	private AnchorPane lHospedaje;

	@FXML
	private Label lblTipoHospedaje;

	@FXML
	private Label lblTitulo;

	@FXML
	private Button btnFavorito;
	@FXML
	private AnchorPane lTocar;
	@FXML
	private Label lblDescripcion;
	
	private int numeroFoto;
	
	

	public void inicializar() {
		
		ArrayList<String> urls = hospedaje.getUrlsFotos();
		lblTipoHospedaje.setText(Util.getTipoHospedaje(hospedaje.getTipoHospedaje()));
		lblTitulo.setText(hospedaje.getTitulo());
		lblDescripcion.setText(hospedaje.getPrestaciones().toString());
		lblPlus.setText(hospedaje.getServicios().toString());
		lblPrecio.setText(hospedaje.getPrecio() + " COP por noche");
		
		if (urls.size()>0) {
			imageFotos.setImage(new Image("file:///" + urls.get(numeroFoto)));
		}
		
		
		lTocar.setOnMouseClicked((e) -> {
			tocarHospedaje();
		});

		btnAnterior.setVisible(false);
		btnSiguiente.setVisible(false);
		btnAnterior.setOnMouseClicked((e) -> {
			if (numeroFoto - 1 < 0)
				numeroFoto = 0;
			else
				numeroFoto--;
			imageFotos.setImage(new Image("file:///" + urls.get(numeroFoto)));
		});
		btnSiguiente.setOnMouseClicked((e) -> {
			if (numeroFoto + 1 == urls.size())
				numeroFoto = urls.size() - 1;
			else
				numeroFoto++;
			imageFotos.setImage(new Image("file:///" + urls.get(numeroFoto)));
		});

		lHospedaje.setStyle("-fx-background-color: #FFFFFF");

		// Botón Favorito
		btnFavorito.setOnMouseEntered((e) -> {

			btnFavorito.setStyle("-fx-background-color: #EBE8EE; -fx-background-radius:50; -fx-border-radius: 30");
		});
		btnFavorito.setOnMouseExited((e) -> {
			btnFavorito.setStyle("-fx-background-color: #FFFFFF");
		});
		lHospedaje.setOnMouseEntered((e) -> {
			btnAnterior.setVisible(true);
			btnSiguiente.setVisible(true);
		});

		lHospedaje.setOnMouseExited((e) -> {
			btnAnterior.setVisible(false);
			btnSiguiente.setVisible(false);
		});

		if (isFavorito()) {
			Image image = new Image(getClass().getResourceAsStream(Util.ICON_CORAZON_ROJO));
			btnFavorito.setGraphic(new ImageView(image));
		} else {
			Image image = new Image(getClass().getResourceAsStream(Util.ICON_CORAZON_BLANCO));
			btnFavorito.setGraphic(new ImageView(image));
		}

		btnFavorito.setOnMouseClicked((e) -> {

			if (isFavorito()) {

				if (stage.getUsuarioLogeado() != null) {

					if (stage.getUsuarioLogeado() instanceof Huesped) {

						Huesped huesped = (Huesped) stage.getUsuarioLogeado();

						huesped.getFavoritos().remove(hospedaje);

						// Se pone no favorito
						Image image = new Image(getClass().getResourceAsStream(Util.ICON_CORAZON_BLANCO));
						btnFavorito.setGraphic(new ImageView(image));
						favorito = false;

					} 

				}
				else {
					showWarning("ATENCION", "Necesita iniciar sesion para realizar esta accion");
				}
			} else {

				if (stage.getUsuarioLogeado() != null) {

					if (stage.getUsuarioLogeado() instanceof Huesped) {

						Huesped huesped = (Huesped) stage.getUsuarioLogeado();

						huesped.agregarHospedajeFavorito(hospedaje);
						// Se pone favorito
						Image image = new Image(getClass().getResourceAsStream(Util.ICON_CORAZON_ROJO));
						btnFavorito.setGraphic(new ImageView(image));
						favorito = true;

					}

					
				}
				else {

					showWarning("ATENCION", "Necesita iniciar sesion para realizar esta accion");

				}
			}
		});

	}
	
	
	
	  

	  
	
	public static void showWarning(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Warning");
        alert.setHeaderText(title);
        alert.setContentText(message);

        alert.showAndWait();
    }

	public void tocarHospedaje() {

		FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_HOSPEDAJE_COMPLETO));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException a) {
			// TODO Auto-generated catch block
			a.printStackTrace();
		}

		ControladorHospedajeCompleto control = loader.getController();
		control.setResonance(resonance);
		control.setStage(stage);
		control.setNumeroHuspedes(numeroHuspedes);
		control.setDate(date);
		control.setHospedaje(hospedaje);
		control.inicializar();

		stage.setResizable(false);
		stage.getScene().setRoot(root);

	}
	
	public int getNumeroHuspedes() {
		return numeroHuspedes;
	}

	public void setNumeroHuspedes(int numeroHuspedes) {
		this.numeroHuspedes = numeroHuspedes;
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
	 * @return the hospedaje
	 */
	public Hospedaje getHospedaje() {
		return hospedaje;
	}

	/**
	 * @param hospedaje the hospedaje to set
	 */
	public void setHospedaje(Hospedaje hospedaje) {
		this.hospedaje = hospedaje;
	}

	public boolean isFavorito() {
		return favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

	public ArrayList<Date> getDate() {
		return date;
	}

	public void setDate(ArrayList<Date> date) {
		this.date = date;
	}
	
}
