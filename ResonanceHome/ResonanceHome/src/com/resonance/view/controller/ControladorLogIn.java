package com.resonance.view.controller;

import java.io.IOException;
import java.util.HashMap;

import com.resonance.model.excepciones.NoExistException;
import com.resonance.model.principal.ResonanceHome;
import com.resonance.model.usuarios.Anfitrion;
import com.resonance.model.usuarios.Huesped;
import com.resonance.model.util.Util;
import com.resonance.view.interfaz.StageR;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
public class ControladorLogIn {

    @FXML
    private Label tituloInicioSesion;

    @FXML
    private PasswordField textPassword;

    @FXML
    private TextField textUsuario;
    
    
    private String url;
	private StageR stage;
	private ResonanceHome resonance;

    @FXML
    private Label btnCreaCuenta;

    @FXML
    private Button btnInicioSesion;

   
	@FXML
	private Text btnAtras;
    
    
    public void setResonance(ResonanceHome resonance) {
		this.resonance = resonance;
	}

	public void setStage(StageR stage) {
		this.stage = stage;
		inicializar();
	}

	public void inicializar() {
		atras();
		iniciarSesion();
	}

	private void atras() {
		btnAtras.setOnMouseClicked((e) -> {
			abrirVentanaAnterior();

		});
	}

	private void iniciarSesion() {
		btnInicioSesion.setOnMouseClicked((e) -> {
			if (!Util.isEmpty(textPassword) && !Util.isEmpty(textUsuario)) {
				try {
					if (resonance.obtenerAnfitrion(textUsuario.getText()) != null) {
						Anfitrion anfitrion = resonance.obtenerAnfitrion(textUsuario.getText());
						if (anfitrion.getContrasenia().equals(textPassword.getText())) {
							stage.setAnfitrionLogin(anfitrion);
							abrirVentanaPrincipal();
						}
					} else if (resonance.obtenerHuesped(textUsuario.getText()) != null) {
						Huesped huesped = resonance.obtenerHuesped(textUsuario.getText());
						if (huesped.getContrasenia().equals(textPassword.getText())) {
							stage.setHuespedLogeado(huesped);
							abrirVentanaPrincipal();
						}
					}
				} catch (NoExistException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				HashMap<String, Anfitrion> anfitriones = resonance.getAnfitriones();

			}
		});
	}
    
	public void limpiarCampos() {
		textPassword.setText("");
		textUsuario.setText("");
	}

	public void abrirVentanaAnterior() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(stage.getVentanaAnterior()));
		try {
			Parent root = loader.load();
			limpiarCampos();
			stage.getScene().setRoot(root);
			Util.updateController(loader, stage, resonance);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void abrirVentanaPrincipal() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(stage.getVentanaAnterior()));
		try {
			Parent root = loader.load();
			limpiarCampos();
			ControladorPrincipal control = loader.getController();
			control.setStage(stage);
			control.update();
			stage.getScene().setRoot(root);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
    
}
