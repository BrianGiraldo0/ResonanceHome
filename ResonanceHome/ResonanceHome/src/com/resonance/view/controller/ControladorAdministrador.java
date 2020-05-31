package com.resonance.view.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import com.resonance.model.excepciones.NoExistException;
import com.resonance.model.hospedajes.Hospedaje;
import com.resonance.model.hospedajes.Reserva;
import com.resonance.model.principal.ResonanceHome;
import com.resonance.model.util.Fecha;
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
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ControladorAdministrador {

	private StageR stage;

	private ResonanceHome resonance;
	
	
    @FXML
    private TextField txtPrecioInferior;
	
    @FXML
    private TextField txtPrecioSuperior;
    
    @FXML
    private AnchorPane lFecha;

    @FXML
    private Label lblDiaActual;

    @FXML
    private AnchorPane lBoton;

    @FXML
    private Button btnSiguienteDia;

    @FXML
    private Button btnCerrar;

    @FXML
    private ScrollPane scrollReservas;

    @FXML
    private VBox vBoxReservas;

    @FXML
    private TextField txtCiudad;

    @FXML
    private ComboBox<String> comboFiltrado;

    @FXML
    private Slider sliderInferior;

    @FXML
    private Slider sliderSuperior;
    
    @FXML
    private Label lblInferior;

    @FXML
    private Label lblSuperior;

    
    public void inicializar() throws NoExistException {

		comboFiltrado.getItems().addAll("Precio (Mayor a menor)", "Calificación (Mayor a menor)", "Sin filtro",
				"Reservas (Mayor a menor)");
		lblDiaActual.setText(resonance.getFecha().toString());
		
		

		btnSiguienteDia.setOnMouseClicked((e) -> {
			Util.loadCalificaciones();
			resonance.anadirDia();
			lblDiaActual.setText(resonance.getFecha().toString());
		});
		
		cargarReservas(null);
	
	}

	@FXML
	void onClick(MouseEvent event) {
		if (event.getSource() == btnCerrar) {
			abrirVentanaPrincipal();
		}

	}

	
	
	public void crearEjemplo () throws NoExistException {
		
		for (int i=0; i<5;i++) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/resonance/view/interfaz/panelDescripcionReserva.fxml"));
			Parent root = null;
			try {
				root = loader.load();
			} catch (IOException a) {
				// TODO Auto-generated catch block
				a.printStackTrace();
			}
			
			vBoxReservas.getChildren().add(root);

			ControladorDescripcionReserva control = loader.getController();
			control.inicializar();
		}
		
		
		
	}
	
	public void cargarHospedajes(ArrayList<Hospedaje> res) {
		vBoxReservas.getChildren().clear();
		for (int i = 0; i < res.size(); i++) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_HOSPEDAJE));
			Parent root = null;
			try {
				root = loader.load();
			} catch (IOException a) {
				// TODO Auto-generated catch block
				a.printStackTrace();
			}

			vBoxReservas.getChildren().add(root);

			ControladorHospedaje control = loader.getController();
			control.setStage(stage);
			control.setResonance(resonance);
			control.setHospedaje(res.get(i));
			control.inicializar();

		}
	}
	
	public void cargarReservas(ArrayList<Reserva> res) throws NoExistException {
		
		vBoxReservas.getChildren().clear();
		
		ArrayList<Reserva> reservas = null;
		if (res==null) {
		 reservas = resonance.obtenerReservas();
		} else {
			reservas = res;
		}
		
		for (int i=0; i<reservas.size();i++) {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_DESCRIPCION_RESERVA));
			Parent root = null;
			try {
				root = loader.load();
			} catch (IOException a) {
				// TODO Auto-generated catch block
				a.printStackTrace();
			}
			
			vBoxReservas.getChildren().add(root);

			ControladorDescripcionReserva control = loader.getController();
			control.setStage(stage);
			control.setResonance(resonance);
			control.setReserva(reservas.get(i));
			control.inicializar();	
			
			
			
			
			
		}
		
		
		
	}
	
	@FXML
	public void cargarPorFiltros (ActionEvent event) throws NoExistException {
		
		double precioInferior =  Double.parseDouble(txtPrecioInferior.getText());
		double precioSuperior =  Double.parseDouble(txtPrecioSuperior.getText());
		String ciudad = txtCiudad.getText();
		Date fecha = Fecha.convertirFecha(resonance.getFecha());
		
		
		
		ArrayList<Reserva> res = new ArrayList<>();
	
		
	if (comboFiltrado.getSelectionModel().getSelectedItem() !=null)	
	{
		
		
		if (comboFiltrado.getSelectionModel().getSelectedItem().equals("Sin filtro")) {
			
			
			for (int i=0; i<resonance.obtenerReservas().size();i++) {
				
				
				Reserva r = resonance.obtenerReservas().get(i);
				
		
				
				if (r.getHospedaje().getDireccion().getCiudad().equals(ciudad) ) {
					
					
					res.add(r);
				}

			}
			 cargarReservas(res);
		
		}
		
		else {
			 if (comboFiltrado.getSelectionModel().getSelectedItem().equals("Precio (Mayor a menor)")) {
				 
				 ArrayList<Reserva> copia = copiarReservasFiltroPrecio(precioInferior, precioSuperior);
				 
				 Collections.sort(copia, new Comparator<Reserva>() {
						
					 
					 public int  compare(Reserva  p1, Reserva p2) {
							
							return new Double(p2.getValor()).compareTo(new Double(p1.getValor()));
						}
					});
				 
				 cargarReservas(copia);
				 
			 } else if (comboFiltrado.getSelectionModel().getSelectedItem().equals("Calificación (Mayor a menor)")) {
				 
				 ArrayList<Reserva> copia = copiarReservasFiltroPrecio(precioInferior, precioSuperior);
				 
				 Collections.sort(copia, new Comparator<Reserva>() {
						
					 
					 public int  compare(Reserva  p1, Reserva p2) {
							
							return new Double(p2.getHospedaje().obtenerPromedioCalificaciones())
									.compareTo(new Double(p1.getHospedaje().obtenerPromedioCalificaciones()));
						}
					});
				 
				 cargarReservas(copia);
				} else if (comboFiltrado.getSelectionModel().getSelectedItem().equals("Reservas (Mayor a menor)")) {
					ArrayList<Hospedaje> copia = resonance.getReservasPorCiudadDeMayorAMenor(ciudad);
					cargarHospedajes(copia);
				} else {
				 cargarReservas(resonance.obtenerReservas());
			 }
	
		}  
	} else 
	{
		 cargarReservas(resonance.obtenerReservas());
	}
		
	}
	
	
	
	public ArrayList<Reserva> copiarReservas(){
		
		ArrayList <Reserva> copia = new ArrayList<>();
		
		for (int i=0; i<resonance.obtenerReservas().size();i++) {
			
			
			copia.add(resonance.obtenerReservas().get(i));
			
			
			
		}
		
		
		return copia;
	}
	
	public ArrayList<Reserva> copiarReservasFiltroPrecio(double precioInferior, double precioSuperior){
	
		ArrayList <Reserva> copia = new ArrayList<>();
		
		for (int i=0; i<resonance.obtenerReservas().size();i++) {
			
			
			if (resonance.obtenerReservas().get(i).getValor() >= precioInferior && 
					resonance.obtenerReservas().get(i).getValor()  <=precioSuperior)
			{
			copia.add(resonance.obtenerReservas().get(i));
			}
			
			
		}
		
		
		return copia;
	}

	
	
	public void abrirVentanaPrincipal() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.VENTANA_PRINCIPAL));
		try {
			Parent root = loader.load();
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
}