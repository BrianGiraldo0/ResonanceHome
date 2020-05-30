package com.resonance.view.controller;
import java.io.IOException;
import java.util.ArrayList;

import com.resonance.model.excepciones.NoExistException;
import com.resonance.model.principal.ResonanceHome;
import com.resonance.model.usuarios.Anfitrion;
import com.resonance.model.util.Util;
import com.resonance.view.interfaz.StageR;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControladorPerfilAnfitrion {
	
	private ResonanceHome resonance;
	
	private StageR stage;
	
	private Anfitrion anfitrion;
	@FXML
    private Text btnAtras;

	@FXML
	private Button btnLogout;

    @FXML
    private Button btnGuardar;

    @FXML
    private Label labelEditar;

    @FXML
    private Rectangle rectanguloFoto;

    @FXML
    private Label labelAnfitrionNombre;

    @FXML
    private Button btnCancelar;

    @FXML
    private ScrollPane scrollHospedajes;

    @FXML
    private ImageView picPerfil;

    @FXML
    private VBox vBoxListadoHospedajes;

    @FXML
    private TextArea textDescripcion;

	@FXML
	private Button btnCrearHospedaje;
    	
    	
public void inicializar () {
		if (stage.getUsuarioLogeado() != null)
			llenarDatos();
		if (!stage.getUsuarioLogeado().getURLFoto().equals("")) {

			System.out.println(stage.getUsuarioLogeado().getURLFoto());
			picPerfil.setImage(new Image("file:///" + stage.getUsuarioLogeado().getURLFoto()));
		}
		btnCrearHospedaje.setOnMouseClicked((e) -> {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_REGPROPIEDAD_1));
			Parent root = null;
			try {
				root = loader.load();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			stage.setVentanaAnterior(Util.PANEL_PERFIL_ANFITRION);
			ControladorRegPropiedad1 control = loader.getController();
			control.setStage(stage);
			control.setResonance(resonance);
			control.inicializar();
			stage.getScene().setRoot(root);
		
		});

		btnLogout.setOnMouseClicked((e) -> {
			stage.setAnfitrionLogin(null);
			stage.setHuespedLogeado(null);
			abrirVentanaPrincipal();
		});
    }

	public void abrirVentanaPrincipal() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.VENTANA_PRINCIPAL));
		try {
			Parent root = loader.load();
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


	public void llenarDatos() {
		anfitrion = (Anfitrion) stage.getUsuarioLogeado();
		labelAnfitrionNombre.setText(anfitrion.getNombre());
		textDescripcion.setText(anfitrion.getBiografia());
		crearHospedajes();

	}

	public void crearHospedajes() {

		ArrayList<String> hospedajes = anfitrion.getHospedajes();
		vBoxListadoHospedajes.getChildren().clear();
		for (int i = 0; i < hospedajes.size(); i++) {

			FXMLLoader loader3 = new FXMLLoader(getClass().getResource(Util.PANEL_HOSPEDAJE_PERFIL));
			Parent root3 = null;
			try {
				root3 = loader3.load();
			} catch (IOException a) {
				// TODO Auto-generated catch block
				a.printStackTrace();
			}
			vBoxListadoHospedajes.getChildren().add(root3);

			ControladorHospedajePerfil control = loader3.getController();
			
			control.setResonance(resonance);
			control.setStage(stage);
			try {
				control.setHospedaje(resonance.obtenerHospedaje(hospedajes.get(i)));
			} catch (NoExistException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			control.inicializar();
			
			

		}
	}

	


	public ResonanceHome getResonance() {
		return resonance;
	}

	public void setResonance(ResonanceHome resonance) {
		this.resonance = resonance;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(StageR stage) {
		this.stage = stage;
	}

	/**
	 * @return the anfitrion
	 */
	public Anfitrion getAnfitrion() {
		return anfitrion;
	}

	/**
	 * @param anfitrion the anfitrion to set
	 */
	public void setAnfitrion(Anfitrion anfitrion) {
		this.anfitrion = anfitrion;
	}
	
	
	
	
}
