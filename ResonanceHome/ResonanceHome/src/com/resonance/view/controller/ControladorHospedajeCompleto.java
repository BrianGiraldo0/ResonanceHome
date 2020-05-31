package com.resonance.view.controller;

import java.awt.Robot;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.resonance.model.hospedajes.Hospedaje;
import com.resonance.model.principal.ResonanceHome;
import com.resonance.model.util.Util;
import com.resonance.view.interfaz.StageR;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.StageStyle;

public class ControladorHospedajeCompleto {

	private ResonanceHome resonance;

	private StageR stage;

	private Hospedaje hospedaje;

	private int numeroHuspedes;
	
	private ArrayList<Date> date;
	
	public static final String CANCEL = "Cancel";

    @FXML
    private Label lblFechas;
	
	@FXML
	private Label labelTotal;

	@FXML
	private TextField textCantidadHuespedes;

	@FXML
	private Label labelPrecioAlojamiento;

	@FXML
	private Label labelPrecioDia;

	@FXML
	private Button btnReservar;

	@FXML
	private Label labelPrecioLimpieza;

	@FXML
	private DatePicker dateFechas;

	@FXML
	private Label labelComision;

	@FXML
	private Label labelTipo;

	@FXML
	private VBox layoutScroll;

	@FXML
	private Text btnAtras;

	public void inicializar() {
		if (stage.getHospedaje() != null) {
			llenarDatos();
		}
		btnAtras.setOnMouseClicked((e) -> {
			abrirVentanaPrincipal();
		});
		FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_FOTOS_HOSPEDAJE));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException a) {
			// TODO Auto-generated catch block
			a.printStackTrace();
		}
		layoutScroll.getChildren().add(root);

		ControladorFotosHospedaje control = loader.getController();
		control.inicializar();

		FXMLLoader loader2 = new FXMLLoader(getClass().getResource(Util.PANEL_DESCRIPCION_HOSPEDAJE));
		Parent root2 = null;
		try {
			root2 = loader2.load();
		} catch (IOException a) {
			// TODO Auto-generated catch block
			a.printStackTrace();
		}
		layoutScroll.getChildren().add(root2);

		ControladorDescripcionHospedaje con = loader2.getController();
		con.setResonance(resonance);
		con.setDate(date);
		con.setNumeroHuspedes(numeroHuspedes);
		con.setStage(stage);
		con.setHospedaje(hospedaje);
		con.inicializar();

		for (int i = 0; i < 5; i++) {

			FXMLLoader loader3 = new FXMLLoader(getClass().getResource(Util.PANEL_COMENTARIO));
			Parent root3 = null;
			try {
				root3 = loader3.load();
			} catch (IOException a) {
				// TODO Auto-generated catch block
				a.printStackTrace();
			}
			layoutScroll.getChildren().add(root3);

			ControladorComentario con3 = loader3.getController();
			con3.inicializar();

		}

		textCantidadHuespedes.setText(numeroHuspedes + "");
		int cantidadHuspedes = Integer.parseInt(textCantidadHuespedes.getText());
		double precio = hospedaje.getPrecio();
		double precioCompleto = precio * date.size();
		double precioLimpieza = (hospedaje.getPrecio() * 0.05) * cantidadHuspedes;
		double comision = hospedaje.getPrecio() * 0.15;
		double total = comision + precioLimpieza + precioCompleto;

		labelPrecioDia.setText("$ " + precio);
		labelPrecioAlojamiento.setText("$ " + precioCompleto);
		labelPrecioLimpieza.setText("$ " + precioLimpieza);
		labelComision.setText("$ " + comision);
		labelTotal.setText("$ " + total);
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY");
		lblFechas.setText(formato.format(date.get(0)) + " hasta " + formato.format(date.get(date.size()-1)));

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
		textCantidadHuespedes.setText(numeroHuspedes + "");
		int cantidadHuspedes = Integer.parseInt(textCantidadHuespedes.getText());
		double precio = hospedaje.getPrecio();
		double precioCompleto = precio * date.size();
		double precioLimpieza = (hospedaje.getPrecio() * 0.05) * cantidadHuspedes;
		double comision = hospedaje.getPrecio() * 0.15;
		double total = comision + precioLimpieza + precioCompleto;

		labelPrecioDia.setText("$ " + precio);
		labelPrecioAlojamiento.setText("$ " + precioCompleto);
		labelPrecioLimpieza.setText("$ " + precioLimpieza);
		labelComision.setText("$ " + comision);
		labelTotal.setText("$ " + total);

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY");
		lblFechas.setText(formato.format(date.get(0)) + " hasta " + formato.format(date.get(date.size() - 1)));
	}

	public void reservar() {

		if (stage.getUsuarioLogeado() != null) {

			FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_PAGO));
			Parent root = null;

			try {
				root = loader.load();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			ControladorPago con = loader.getController();
			con.setStage(stage);
			con.setDate(date);
			con.setHospedaje(hospedaje);
			con.setNumeroHuspedes(Integer.parseInt(textCantidadHuespedes.getText()));
			con.setResonance(resonance);
			con.inicializar();
			stage.getScene().setRoot(root);
		} else {

			String[] opciones = { "Iniciar sesion", "Registrarse", "Cancelar" };
			String respuesta = showConfirm("Opciones", "Por favor escoja una opcion", opciones);

			if (respuesta.equals("Registrarse")) {
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
				control.inicializar();
				stage.getScene().setRoot(root);

			}

			if (respuesta.equals("Iniciar sesion")) {
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
			}

		}

	}

	public static String showConfirm(String title, String message, String[] options) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Por favor escoja una opcion");
        alert.setHeaderText(title);
        alert.setContentText(message);

        //To make enter key press the actual focused button, not the first one. Just like pressing "space".
        alert.getDialogPane().addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                event.consume();
                try {
                    Robot r = new Robot();
                    r.keyPress(java.awt.event.KeyEvent.VK_SPACE);
                    r.keyRelease(java.awt.event.KeyEvent.VK_SPACE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        if (options == null || options.length == 0) {
            options = new String[]{CANCEL};
        } 

        List<ButtonType> buttons = new ArrayList<>();
        for (String option : options) {
            buttons.add(new ButtonType(option));
        }

        alert.getButtonTypes().setAll(buttons);

        Optional<ButtonType> result = alert.showAndWait();
        if (!result.isPresent()) {
            return CANCEL;
        } else {
            return result.get().getText();
        }
    }
	
	public Hospedaje getHospedaje() {
		return hospedaje;
	}

	public void setHospedaje(Hospedaje hospedaje) {
		this.hospedaje = hospedaje;
	}

	public void setResonance(ResonanceHome resonance) {
		this.resonance = resonance;
	}

	public void setStage(StageR stage) {
		this.stage = stage;
	}

	public int getNumeroHuspedes() {
		return numeroHuspedes;
	}

	public void setNumeroHuspedes(int numeroHuspedes) {
		this.numeroHuspedes = numeroHuspedes;
	}

	public ArrayList<Date> getDate() {
		return date;
	}

	public void setDate(ArrayList<Date> date) {
		this.date = date;
	}
	
}
