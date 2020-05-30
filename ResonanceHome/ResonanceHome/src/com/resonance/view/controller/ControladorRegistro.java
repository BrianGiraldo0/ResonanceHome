package com.resonance.view.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import com.resonance.model.excepciones.NoExistException;
import com.resonance.model.principal.ResonanceHome;
import com.resonance.model.util.Util;
import com.resonance.view.interfaz.StageR;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.StageStyle;

public class ControladorRegistro {

	private StageR stage;
	private ResonanceHome resonance;
	private File fileFoto;
	@FXML
	private Text btnAtras;
	
	
	@FXML
	private ComboBox<String> comboTipoCuenta;
	
	 private ObservableList<String> items = FXCollections.observableArrayList();
	
	@FXML
	private ImageView picPerfil;
	@FXML
	private Button btnSubirFoto;

	@FXML
	private TextField textNombreUsuario;

	@FXML
	private Button quitarFoto;

	@FXML
	private PasswordField textPasswordUsuario;

	@FXML

	private ImageView fotoPerfil;

	@FXML
	private Rectangle rectanguloFoto;

	@FXML
	private Label interrogacionFoto;

	@FXML
	private Button btnContinuar;

	@FXML
	private DatePicker dateFechaNacimiento;

	@FXML
	private TextArea textBiografia;

	@FXML
	private TextField textEmail;

	@FXML
	private TextField textDireccion;

	@FXML
	private TextField textNombreCompleto;

	public void inicializar() {
		inicializarCombo();
		continuar();
		atras();
	}
	public void subirFoto() {

		FileChooser fileChooser = new FileChooser();

		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Archivos de imagen", "*.jpg", "*.png")

		);

		File selectedFile = fileChooser.showOpenDialog(stage);
		fileFoto = selectedFile;

		if (selectedFile != null) {
			rectanguloFoto.setVisible(false);
			interrogacionFoto.setVisible(false);
			quitarFoto.setVisible(true);

			Image image = new Image(selectedFile.toURI().toString());
			picPerfil.setImage(image);

		} else {
			rectanguloFoto.setVisible(true);
			interrogacionFoto.setVisible(true);
		}

	}

	public void quitarFoto() {

		quitarFoto.setVisible(false);
		picPerfil.setImage(null);

		rectanguloFoto.setVisible(true);
		interrogacionFoto.setVisible(true);

	}
	
	public void inicializarCombo() {
		
		items.add("Huesped");
		items.add("Anfitrion");
		
    	comboTipoCuenta.getItems().addAll(items);
    	
		
	}
	

	public void setResonance(ResonanceHome resonance) {
		this.resonance = resonance;
	}

	public void setStage(StageR stage) {
		this.stage = stage;
	}

	private void continuar() {
		btnContinuar.setOnMouseClicked((e) -> {
			String nombre = textNombreCompleto.getText();
			LocalDate fecha = dateFechaNacimiento.getValue();
			String email = textEmail.getText();
			String direccion = textDireccion.getText();
			String nametag = textNombreUsuario.getText();
			String clave = textPasswordUsuario.getText();
			String biografia = textBiografia.getText();
			String urlFoto = "";
			Date date = Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
			if (fileFoto != null)
				urlFoto = fileFoto.getAbsolutePath();
			if (comboTipoCuenta.getValue().equals("Anfitrion")) {
				resonance.agregarAnfitrion(nombre, email, urlFoto, direccion, date, clave, biografia, nametag);
				try {
					stage.setAnfitrionLogin(resonance.obtenerAnfitrion(nametag));
				} catch (NoExistException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				resonance.agregarHuesped(nombre, email, urlFoto, direccion, date, clave, biografia, nametag);
				try {
					stage.setHuespedLogeado(resonance.obtenerHuesped(nametag));
				} catch (NoExistException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			String datos = nombre + "\n" + "Correo: " + email + "\n" + "Nametag: " + nametag + "\n" + "Contraseña: "
					+ clave;
			resonance.enviarCorreoBienvenida(datos, stage.getUsuarioLogeado().getEmail());
			showConfirmation("Hospedaje creado", "Señor/a su cuenta ha sido creada con exito!");
			abrirVentanaPrincipal();

		});
	}

	public static void showConfirmation(String title, String message) {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.initStyle(StageStyle.UTILITY);
		alert.setTitle("Warning");
		alert.setHeaderText(title);
		alert.setContentText(message);

		alert.showAndWait();
	}

	private void atras() {
		btnAtras.setOnMouseClicked((e) -> {
			abrirVentanaAnterior();

		});
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
			stage.getScene().setRoot(root);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void abrirVentanaAnterior() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.VENTANA_PRINCIPAL));
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

	public void limpiarCampos() {
		textNombreCompleto.setText("");
		textEmail.setText("");
		textDireccion.setText("");
		textDireccion.setText("");
		textNombreUsuario.setText("");
		textPasswordUsuario.setText("");
		textBiografia.setText("");
	}

}
