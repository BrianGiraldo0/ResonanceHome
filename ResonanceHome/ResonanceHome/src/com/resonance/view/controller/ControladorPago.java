package com.resonance.view.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.resonance.model.hospedajes.Hospedaje;
import com.resonance.model.hospedajes.Reserva;
import com.resonance.model.principal.ResonanceHome;
import com.resonance.model.txt.Tarjeta;
import com.resonance.model.usuarios.Huesped;
import com.resonance.model.util.Util;
import com.resonance.view.interfaz.StageR;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class ControladorPago {

	private ResonanceHome resonance;

	private StageR stage;

	private Hospedaje hospedaje;

	private int numeroHuspedes;

	private ArrayList<Date> date;

	@FXML
	private Label labelPrecioDia;

	@FXML
	private Label labelPrecioAlojamiento;

	@FXML
	private Label labelPrecioLimpieza;

	@FXML
	private Label labelComision;

	@FXML
	private Label labelTotal;

	@FXML
	private Label lblNumeroHuespedes;

	@FXML
	private Label lblFechas;

	@FXML
	private Text btnAtras;

	@FXML
	private Button btnReservar;

	@FXML
	private Label lblInfoMensaje;

	@FXML
	private TextArea txtMensaje;

	@FXML
	private TextField txtNumeroTarjeta;

	@FXML
	private TextField txtNombreApellido;

	@FXML
	private TextField txtFechaExpedicion;

	@FXML
	private TextField txtCodigoSeguridad;

	@FXML
	private TextField txtCedula;

	@FXML
	private Label lblNumeroTarjeta;

	@FXML
	private Label lblNombreApellido;

	@FXML
	private Label lblFechaExpiración;

	@FXML
	void reservar(MouseEvent event) {

	}

	public void abrirVentanaAnterior() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_HOSPEDAJE_COMPLETO));
		try {
			Parent root = loader.load();

			ControladorHospedajeCompleto control = loader.getController();
			control.setResonance(resonance);
			control.setHospedaje(hospedaje);
			control.setNumeroHuspedes(numeroHuspedes);
			control.setStage(stage);
			control.setDate(date);
			control.inicializar();
			stage.getScene().setRoot(root);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	public void inicializar() {
		double precio = hospedaje.getPrecio();
		double precioCompleto = precio * date.size();
		double precioLimpieza = (hospedaje.getPrecio() * 0.05) * numeroHuspedes;
		double comision = hospedaje.getPrecio() * 0.15;
		double total = comision + precioLimpieza + precioCompleto;
		btnAtras.setOnMouseClicked((e) -> {
			abrirVentanaAnterior();
		});
		lblNumeroHuespedes.setText(numeroHuspedes + "");
		labelPrecioDia.setText("$ " + precio);
		labelPrecioAlojamiento.setText("$ " + precioCompleto);
		labelPrecioLimpieza.setText("$ " + precioLimpieza);
		labelComision.setText("$ " + comision);
		labelTotal.setText("$ " + total);

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY");
		lblFechas.setText(formato.format(date.get(0)) + " hasta " + formato.format(date.get(date.size() - 1)));

			lblInfoMensaje
					.setText("Cuéntale a " + resonance.obtenerAnfitrion(hospedaje.getNameTagPropietario()).getNombre()
							+ " un poco sobre ti y sobre el motivo de tu viaje.");
			txtMensaje.setPromptText("Hola " + resonance.obtenerAnfitrion(hospedaje.getNameTagPropietario()).getNombre()
					+ ", No veo la hora de pasar mis dias de viaje en tu hospedaje. ");


		txtNombreApellido.setOnMouseClicked((e) -> {
			if (txtNumeroTarjeta.getText().length() % 4 == 0) {
				int separacion = txtNumeroTarjeta.getText().length() / 4;
				int aux = 0;
				String cadena = "";

				for (int i = 0; i < separacion; i++) {
					cadena += txtNumeroTarjeta.getText().substring(aux, aux + 4);
					aux = aux + 4;

					if (i != separacion - 1) {
						cadena += "     ";
					}
				}

				lblNumeroTarjeta.setText(cadena);
			} else {
				txtNumeroTarjeta.setText("Introduzca un numero de tarjeta valido (16 digitos)");
			}
		});

		txtFechaExpedicion.setOnMouseClicked((e) -> {
			lblNombreApellido.setText(txtNombreApellido.getText().toUpperCase());
		});

		txtCodigoSeguridad.setOnMouseClicked((e) -> {
			lblFechaExpiración.setText(txtFechaExpedicion.getText());
		});

		btnReservar.setOnMouseClicked((e) -> {

			if (stage.getUsuarioLogeado() instanceof Huesped) {
				Huesped huesped = (Huesped) stage.getUsuarioLogeado();

				Tarjeta tarjeta = new Tarjeta((int) Double.parseDouble(txtNumeroTarjeta.getText()),
						txtNombreApellido.getText(),
						txtCodigoSeguridad.getText(), txtFechaExpedicion.getText(), txtCedula.getText());
				Reserva reserva = new Reserva(hospedaje, huesped.getNametag(), huesped.getId(), huesped.getNombre(),
						hospedaje.getDireccion().getDireccion() + " " + hospedaje.getDireccion().toString(),
						huesped.getEmail(), tarjeta, date, total, numeroHuspedes);

				huesped.setTarjeta(tarjeta);
				huesped.agregarReserva(reserva);
				abrirVentanaPrincipal();
			}
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
	public ResonanceHome getResonance() {
		return resonance;
	}

	public void setResonance(ResonanceHome resonance) {
		this.resonance = resonance;
	}

	public StageR getStage() {
		return stage;
	}

	public void setStage(StageR stage) {
		this.stage = stage;
	}

	public Hospedaje getHospedaje() {
		return hospedaje;
	}

	public void setHospedaje(Hospedaje hospedaje) {
		this.hospedaje = hospedaje;
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
