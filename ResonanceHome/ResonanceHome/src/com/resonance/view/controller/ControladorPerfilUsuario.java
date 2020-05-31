package com.resonance.view.controller;

import java.io.IOException;

import com.resonance.model.hospedajes.Hospedaje;
import com.resonance.model.hospedajes.TipoHospedaje;
import com.resonance.model.principal.ResonanceHome;
import com.resonance.model.usuarios.Huesped;
import com.resonance.model.util.Util;
import com.resonance.view.interfaz.StageR;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControladorPerfilUsuario {

	private Huesped huesped;
	private ResonanceHome resonance;
	private StageR stage;

	@FXML
	private ComboBox<String> comboTipo;

	@FXML
	private Button btnMensajes;

	@FXML
	private Text btnAtras;

	@FXML
	private Button btnLogout;

	@FXML
	private Label labelNombreUsuario;

	@FXML

	private Label labelHospedajesTitulo;

	@FXML
	private Button btnVerVisitados;

	@FXML
	private Button btnVerFavoritos;

	@FXML
	private Button btnGuardar;

	@FXML
	private Label labelEditar;

	@FXML
	private Rectangle rectanguloFoto;

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
	private Label labelAnfitrionNombre;

	public void inicializar() {

		comboTipo.getItems().addAll("Habitacion", "Apartamento");

		colorearBotones();
		btnMensajes.setOnMouseClicked((e) -> {
			abrirVentanaMensajes();
		});

		labelNombreUsuario.setText(stage.getUsuarioLogeado().getNombre());

		if (!stage.getUsuarioLogeado().getURLFoto().equals("")) {

			System.out.println(stage.getUsuarioLogeado().getURLFoto());
			picPerfil.setImage(new Image("file:///" + stage.getUsuarioLogeado().getURLFoto()));
		}

		inicializarHospedajesVisitados();
		btnLogout.setOnMouseClicked((e) -> {
			stage.setAnfitrionLogin(null);
			stage.setHuespedLogeado(null);
			abrirVentanaPrincipal();
		});
	}

	public void abrirVentanaMensajes() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_MENSAJES));
		try {
			Parent root = loader.load();
			ControladorMensajes control = loader.getController();
			stage.setVentanaAnterior(Util.PANEL_PERFIL_USUARIO);
			control.setStage(stage);
			control.setResonance(resonance);
			control.inicializar();
			stage.getScene().setRoot(root);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void colorearBotones() {
		Image image = new Image(getClass().getResourceAsStream(Util.ICON_MENSAJES));
		btnMensajes.setGraphic(new ImageView(image));
		btnMensajes.setOnMouseEntered((e) -> {

			btnMensajes.setStyle("-fx-background-color: #EBE8EE; -fx-background-radius: 15");
		});
		btnMensajes.setOnMouseExited((e) -> {
			btnMensajes.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 15");
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

	public void inicializarHospedajesVisitados() {
		vBoxListadoHospedajes.getChildren().clear();
		Huesped huesped = (Huesped) stage.getUsuarioLogeado();

		String tipo = comboTipo.getSelectionModel().getSelectedItem();

		if (tipo != null) {

			for (int i = 0; i < huesped.getReservas().size(); i++) {

				Hospedaje hospedaje = huesped.getReservas().get(i).getHospedaje();

				if (tipo.equals("Habitacion")
						&& huesped.getReservas().get(i).getHospedaje().getTipoHospedaje() == TipoHospedaje.HABITACION)

				{

					if (huesped.getReservas().get(i).isVencido() == false) {

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
						control.setHospedaje(hospedaje);
						control.inicializar();
					}

				} else if (tipo.equals("Apartamento") && huesped.getReservas().get(i).getHospedaje()
						.getTipoHospedaje() == TipoHospedaje.APARTAMENTO) {
					if (huesped.getReservas().get(i).isVencido() == false) {

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
						control.setHospedaje(hospedaje);
						control.inicializar();
					}

				}
			}
		}

	}

	public void inicializarHospedajesFavoritos() {

		vBoxListadoHospedajes.getChildren().clear();
		Huesped huesped = (Huesped) stage.getUsuarioLogeado();

		for (int i = 0; i < huesped.getFavoritos().size(); i++) {

			Hospedaje hospedaje = huesped.getFavoritos().get(i);
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
			control.setHospedaje(hospedaje);
			control.inicializar();

		}

	}

	public void inicializarComentarios() {

		vBoxListadoHospedajes.getChildren().clear();
		Huesped huesped = (Huesped) stage.getUsuarioLogeado();

		for (int i = 0; i < huesped.getComentarios().size(); i++) {

			FXMLLoader loader3 = new FXMLLoader(getClass().getResource(Util.PANEL_COMENTARIO));
			Parent root3 = null;
			try {
				root3 = loader3.load();
			} catch (IOException a) {
				// TODO Auto-generated catch block
				a.printStackTrace();
			}
			vBoxListadoHospedajes.getChildren().add(root3);

			ControladorComentario control = loader3.getController();

			control.setResonance(resonance);
			control.setStage(stage);
			control.setMensaje(huesped.getComentarios().get(i));
			control.inicializar();

		}
	}

	@FXML
	void verFavoritos(ActionEvent event) {

		labelHospedajesTitulo.setText("Hospedajes favoritos");
		inicializarHospedajesFavoritos();
	}

	@FXML
	void verVisitados(ActionEvent event) {
		labelHospedajesTitulo.setText("Hospedajes visitados");
		inicializarHospedajesVisitados();
	}

	@FXML
	void verComentarios(ActionEvent event) {
		labelHospedajesTitulo.setText("Comentarios");
		inicializarComentarios();

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
	 * @return the huesped
	 */
	public Huesped getHuesped() {
		return huesped;
	}

	/**
	 * @param huesped the huesped to set
	 */
	public void setHuesped(Huesped huesped) {
		this.huesped = huesped;
	}

}
