package com.resonance.view.controller;
import java.io.IOException;

import com.resonance.model.hospedajes.Hospedaje;
import com.resonance.model.principal.ResonanceHome;
import com.resonance.model.usuarios.Huesped;
import com.resonance.model.util.Util;
import com.resonance.view.interfaz.StageR;

import javafx.event.ActionEvent;
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

public class ControladorPerfilUsuario {
	
	private Huesped huesped;
    private ResonanceHome resonance;
    private StageR stage;

	

    @FXML
    private Text btnAtras;
 
    
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
    	
    	
public void inicializar () {
			
	
	System.out.println(stage.getUsuarioLogeado().getNombre());
	
	labelNombreUsuario.setText(stage.getUsuarioLogeado().getNombre());
	
	if (!stage.getUsuarioLogeado().getURLFoto().equals("")) {
	
	picPerfil.setImage(new Image(stage.getUsuarioLogeado().getURLFoto()));
	}
	
	
	inicializarHospedajesVisitados();
			
		
			
			
			
    	
    }




	public void inicializarHospedajesVisitados() {
		vBoxListadoHospedajes.getChildren().clear();
		Huesped huesped =  (Huesped) stage.getUsuarioLogeado();
		
		
		for (int i=0; i<huesped.getReservas().size();i++) {
			
			
		Hospedaje hospedaje = 	resonance.getHospedajes().get(huesped.getReservas().get(i).getIdentificacion());
		
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
	
	
	public void inicializarHospedajesFavoritos() {
		
		vBoxListadoHospedajes.getChildren().clear();
		Huesped huesped =  (Huesped) stage.getUsuarioLogeado();
		
		
		for (int i=0; i<huesped.getFavoritos().size();i++) {
			
			
		Hospedaje hospedaje = 	resonance.getHospedajes().get(huesped.getFavoritos().get(i).getIdentificacion());
		
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

	public void crearEjemplo() {
		for (int i = 0; i < 5; i++) {

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
