package com.resonance.view.controller;

import java.io.IOException;

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
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
public class ControladorLogIn {

	@FXML
	private AnchorPane panelLogin;

    @FXML
    private Label tituloInicioSesion;

    @FXML
    private PasswordField textPassword;

    @FXML
    private TextField textUsuario;
    

	private StageR stage;
	private ResonanceHome resonance;
    @FXML
	private Label lblError;

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
		registrarse();
	}

	private void atras() {
		btnAtras.setOnMouseClicked((e) -> {
			abrirVentanaAnterior();

		});
	}

	private void registrarse() {
		btnCreaCuenta.setOnMouseClicked((e) -> {
			abrirVentanaRegistro();
		});
	}
	
	private void iniciarSesion() {

		btnInicioSesion.setOnMouseClicked((e) -> {
			String error = "";
			if (!Util.isEmpty(textPassword) && !Util.isEmpty(textUsuario)) {

				try {
					if (resonance.obtenerAnfitrion(textUsuario.getText()) != null) {
						Anfitrion anfitrion = resonance.obtenerAnfitrion(textUsuario.getText());
						if (anfitrion.getContrasenia().equals(textPassword.getText())) {
							stage.setAnfitrionLogin(anfitrion);
							abrirVentanaAnfitrion(anfitrion);
						} else {
							error = "Usuario o contraseña incorrectos";
							getWidth(error.length());
							lblError.setText(error);
						}
					}
				} catch (NoExistException e1) {
					error = "Usuario";
					getWidth(error.length());
					lblError.setText(error);
				}
				try {
					if (resonance.obtenerHuesped(textUsuario.getText()) != null) {
						Huesped huesped = resonance.obtenerHuesped(textUsuario.getText());
						if (huesped.getContrasenia().equals(textPassword.getText())) {
							stage.setHuespedLogeado(huesped);
							abrirVentanaPrincipal();
						} else {
							error = "Usuario o contraseña incorrectos";
							getWidth(error.length());
							lblError.setText(error);
						}
						}
				} catch (NoExistException e1) {
					error = "Usuario";
					getWidth(error.length());
					lblError.setText(error);
				}


			} else {
				error = "Se deben llenar todos los campos";
				getWidth(error.length());
				lblError.setText(error);
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
		FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.VENTANA_PRINCIPAL));
		try {
			Parent root = loader.load();
			limpiarCampos();
			ControladorPrincipal control = loader.getController();
			control.setStage(stage);
			control.setResonance(resonance);
			control.inicializar();
			control.update();
			stage.getScene().setRoot(root);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void abrirVentanaRegistro() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_REGISTRO));
		try {
			Parent root = loader.load();
			ControladorRegistro control = loader.getController();
			control.setResonance(resonance);
			stage.setVentanaAnterior(Util.PANEL_INICIAR_SESION);
			control.setStage(stage);
			control.inicializar();
			stage.getScene().setRoot(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void abrirVentanaAnfitrion(Anfitrion anfitrion) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_PERFIL_ANFITRION));
		try {
			Parent root = loader.load();
			limpiarCampos();
			ControladorPerfilAnfitrion control = loader.getController();
			control.setStage(stage);
			control.setResonance(resonance);
			control.setAnfitrion(anfitrion);
			control.inicializar();
			stage.getScene().setRoot(root);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private double getWidth(int tam) {
		double a = 0;
		a = tam * 9;
		lblError.setMinWidth(a);
		lblError.setPrefWidth(a);
		lblError.setLayoutX(panelLogin.getPrefWidth() / 2 - lblError.getMinWidth() / 2);

		return a;
	}
    
}
