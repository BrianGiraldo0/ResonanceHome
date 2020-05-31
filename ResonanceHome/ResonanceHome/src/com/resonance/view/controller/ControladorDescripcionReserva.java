package com.resonance.view.controller;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import com.resonance.model.excepciones.NoExistException;
import com.resonance.model.hospedajes.Reserva;
import com.resonance.model.principal.ResonanceHome;
import com.resonance.model.usuarios.Anfitrion;
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
import javafx.stage.Stage;
import javafx.stage.StageStyle;





public class ControladorDescripcionReserva {

		private Reserva reserva;
		
		@FXML
		private Label lblCalificacion;
		
		@FXML
	    private Label lblFechasReserva;

	    @FXML
	    private Label lblDireccionHospedaje;

	    @FXML
	    private Label lbllNombreAnfitrionReserva;

	    @FXML
	    private Label lblNombreHospedaje;

	    @FXML
	    private Button btnEstado;

	    @FXML
	    private Label lblNumeroHuespedesReserva;

	    @FXML
	    private Label lblPrecioReserva;
	    
	    @FXML
	    private Label lblFutura;
	    @FXML
	    private ImageView imgViewHospedajeReserva;

	    @FXML
	    private Label lblTipoHospedajeReserva;

	    @FXML
	    private Button btnInformacion;
	    
	    private ResonanceHome resonance;
	    
	    private StageR stage;
	    
	    
	    public void inicializar() throws NoExistException {
	    	
	    	
	    	if (reserva!=null) {
	    	
	    	Date fechaInicial = reserva.getFechaInicial();
	    	Date fechaFinal = reserva.getFechaFinal();
	    	lblFechasReserva.setText(fechaInicial + " - " + fechaFinal);
	    	lblNombreHospedaje.setText(reserva.getHospedaje().getTitulo());
			Anfitrion anfitrion;
			anfitrion = resonance.obtenerAnfitrion(reserva.getHospedaje().getNameTagPropietario());
	    	lbllNombreAnfitrionReserva.setText(anfitrion.getNombre());
	    	lblNumeroHuespedesReserva.setText(reserva.getNumeroHuespedes()+"");
	    	lblTipoHospedajeReserva.setText(reserva.getHospedaje().getTipoHospedaje().name().toLowerCase());
	    	lblPrecioReserva.setText(reserva.getValor()+"");
	    	lblCalificacion.setText(reserva.getHospedaje().obtenerPromedioCalificaciones() +"");
	    	lblDireccionHospedaje.setText("Ciudad: " + reserva.getHospedaje().getDireccion().getCiudad()  + " " + reserva.getHospedaje().getDireccion().getDireccion());
	    	
			if (reserva.getHospedaje().getUrlsFotos().size() > 0)
	    	imgViewHospedajeReserva.setImage(new Image (reserva.getHospedaje().getUrlsFotos().get(0)));
	    	
	    	}
	    	
	    	btnInformacion.setOnMouseClicked((e)->{
			String persona = reserva.getNombre() + " Estrato: "
					+ resonance.obtenerHuesped(reserva.getNameTagHuesped()).getEstrato().toString()
					+ " Nivel estudios: "
					+ resonance.obtenerHuesped(reserva.getNameTagHuesped()).getNivelEstudio().toString();
			showConfirmation("Información del huesped", persona);
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
			control.setHospedaje(reserva.getHospedaje());
			control.inicializar();

			stage.setResizable(false);
			stage.getScene().setRoot(root);

		}
	    
	    public String convertirFecha (Date date) {
	    	Locale loc = new Locale("en", "US");
	     	DateFormat formato  = DateFormat.getDateInstance(DateFormat.DEFAULT, loc);
	    	String fecha = formato.format(date);
	    	
	    	return fecha;
	    	
	    	
	    }
	    
	    
	    public void setFutura() {
	    	
	    	lblFutura.setVisible(true);
	    	
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


		public Reserva getReserva() {
			return reserva;
		}


		public void setReserva(Reserva reserva) {
			this.reserva = reserva;
		}
		
		
		
}
