package com.resonance.view.controller;

import java.io.IOException;

import com.resonance.model.hospedajes.Hospedaje;
import com.resonance.model.principal.ResonanceHome;
import com.resonance.model.util.Util;
import com.resonance.view.interfaz.StageR;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;



public class ControladorDescripcionHospedaje {
	
    	private ResonanceHome resonance;
    	
    	private StageR stage;
    	
    	private Hospedaje hospedaje;

        @FXML
        private Label labelTituloAlojamiento;

        @FXML
        private Label labelDireccionAlojamiento;

        @FXML
        private Label labelNumeroHuespedes;

        @FXML
        private Label labelNumeroHabitaciones;

        @FXML
        private Label labelNumeroCamas;

        @FXML
        private Label labelNumeroBanios;

        @FXML
        private TextArea textDescripcionAlojamiento;

        @FXML
        private TextArea textDescripcionAnfitrion;

        @FXML
        private Label labelNombreAnfitrion;

        @FXML
        private Label lblServ1;

        @FXML
        private Label lblServ2;

        @FXML
        private Label lblServ3;
        
        @FXML
        private Label lblServ4;

        @FXML
        private Button btnVerPerfilAnfitrion;

        @FXML
        private ImageView imafenAnfitrion;
        
        @FXML
        private ImageView star1;

        @FXML
        private ImageView star2;

        @FXML
        private ImageView star3;

        @FXML
        private ImageView star4;

        @FXML
        private ImageView star5;

        @FXML
        private Button btnInfo;
	    
	    public void inicializar() {
	    	labelTituloAlojamiento.setText(hospedaje.getTitulo());
	    	labelDireccionAlojamiento.setText(hospedaje.getDireccion().getDireccion()+ ", " + hospedaje.getDireccion().toString());
	    	labelNumeroCamas.setText("Camas: " + hospedaje.getPrestaciones().getNumBanios()+"");
	    	
	    	if(hospedaje.getPrestaciones().getNumHabitaciones() > 0)
	    	{
	    		labelNumeroHabitaciones.setText("Habitaciones: " + hospedaje.getPrestaciones().getNumHabitaciones() + "");
	    	}
	    	else
	    	{
	    		labelNumeroHabitaciones.setText("");
	    	}
	    	
	    	labelNumeroHuespedes.setText("Huespedes: " + hospedaje.getPrestaciones().getNumHuesped() + "");
	    	labelNumeroBanios.setText("Banios: " + hospedaje.getPrestaciones().getNumBanios() + "");
	    	
	    	textDescripcionAlojamiento.setText(hospedaje.getDescripcion());
	    	
	    	if(hospedaje.getServicios().isWifi())
	    	{
	    		lblServ1.setText("Wifi: Incluido");
	    	}else
	    	{
	    		lblServ1.setText("Wifi: No Incluido");
	    	}
	    	
	    	if(hospedaje.getServicios().isCocina())
	    	{
	    		lblServ2.setText("Cocina: Incluido");
	    	}else
	    	{
	    		lblServ2.setText("Cocina: No Incluido");
	    	}
	    	
	    	if(hospedaje.getServicios().isAireAc())
	    	{
	    		lblServ3.setText("Aire Acondicionado: Incluido");
	    	}else
	    	{
	    		lblServ3.setText("Aire Acondicionado: No Incluido");
	    	}
	    	
	    	if(hospedaje.getServicios().isUtencilios())
	    	{
	    		lblServ4.setText("Utencilios: Incluidos");
	    	}else
	    	{
	    		lblServ4.setText("Utencilios: No Incluido");
	    	}
	    	
				labelNombreAnfitrion.setText(resonance.obtenerAnfitrion(hospedaje.getNameTagPropietario()).getNombre());
				textDescripcionAnfitrion.setText(resonance.obtenerAnfitrion(hospedaje.getNameTagPropietario()).getBiografia());

//				Image perfil = new Image(resonance.obtenerAnfitrion(hospedaje.getNameTagPropietario()).getURLFoto());
//				imafenAnfitrion.setImage(perfil);

	    	
	    	rellenarCalificacion();
	    }
	    
	    public void rellenarCalificacion()
	    {
	    	if(hospedaje.obtenerPromedioCalificaciones() > 4.6) 
	    	{
	    		star1.setImage(new Image(Util.ICON_STAR_LLENA));
	    		star2.setImage(new Image(Util.ICON_STAR_LLENA));
	    		star3.setImage(new Image(Util.ICON_STAR_LLENA));
	    		star4.setImage(new Image(Util.ICON_STAR_LLENA));
	    		star5.setImage(new Image(Util.ICON_STAR_LLENA));
	    	}
	    	else if(hospedaje.obtenerPromedioCalificaciones() > 4.0) 
	    	{
	    		star1.setImage(new Image(Util.ICON_STAR_LLENA));
	    		star2.setImage(new Image(Util.ICON_STAR_LLENA));
	    		star3.setImage(new Image(Util.ICON_STAR_LLENA));
	    		star4.setImage(new Image(Util.ICON_STAR_LLENA));
	    		star5.setImage(new Image(Util.ICON_STAR_MEDIO_LLENA));
	    	}
	    	else if(hospedaje.obtenerPromedioCalificaciones() > 3.6) 
	    	{
	    		star1.setImage(new Image(Util.ICON_STAR_LLENA));
	    		star2.setImage(new Image(Util.ICON_STAR_LLENA));
	    		star3.setImage(new Image(Util.ICON_STAR_LLENA));
	    		star4.setImage(new Image(Util.ICON_STAR_LLENA));
	    		star5.setImage(new Image(Util.ICON_STAR_VACIA));
	    	}
	    	else if(hospedaje.obtenerPromedioCalificaciones() > 3.0) 
	    	{
	    		star1.setImage(new Image(Util.ICON_STAR_LLENA));
	    		star2.setImage(new Image(Util.ICON_STAR_LLENA));
	    		star3.setImage(new Image(Util.ICON_STAR_LLENA));
	    		star4.setImage(new Image(Util.ICON_STAR_MEDIO_LLENA));
	    		star5.setImage(new Image(Util.ICON_STAR_VACIA));
	    	}
	    	else if(hospedaje.obtenerPromedioCalificaciones() > 2.6) 
	    	{
	    		star1.setImage(new Image(Util.ICON_STAR_LLENA));
	    		star2.setImage(new Image(Util.ICON_STAR_LLENA));
	    		star3.setImage(new Image(Util.ICON_STAR_LLENA));
	    		star4.setImage(new Image(Util.ICON_STAR_VACIA));
	    		star5.setImage(new Image(Util.ICON_STAR_VACIA));
	    	}
	    	else if(hospedaje.obtenerPromedioCalificaciones() > 2.0) 
	    	{
	    		star1.setImage(new Image(Util.ICON_STAR_LLENA));
	    		star2.setImage(new Image(Util.ICON_STAR_LLENA));
	    		star3.setImage(new Image(Util.ICON_STAR_MEDIO_LLENA));
	    		star4.setImage(new Image(Util.ICON_STAR_VACIA));
	    		star5.setImage(new Image(Util.ICON_STAR_VACIA));
	    	}
	    	else if(hospedaje.obtenerPromedioCalificaciones() > 1.6) 
	    	{
	    		star1.setImage(new Image(Util.ICON_STAR_LLENA));
	    		star2.setImage(new Image(Util.ICON_STAR_LLENA));
	    		star3.setImage(new Image(Util.ICON_STAR_VACIA));
	    		star4.setImage(new Image(Util.ICON_STAR_VACIA));
	    		star5.setImage(new Image(Util.ICON_STAR_VACIA));
	    	}
	    	else if(hospedaje.obtenerPromedioCalificaciones() > 1.0) 
	    	{
	    		star1.setImage(new Image(Util.ICON_STAR_LLENA));
	    		star2.setImage(new Image(Util.ICON_STAR_MEDIO_LLENA));
	    		star3.setImage(new Image(Util.ICON_STAR_VACIA));
	    		star4.setImage(new Image(Util.ICON_STAR_VACIA));
	    		star5.setImage(new Image(Util.ICON_STAR_VACIA));
	    	}
	    	else if(hospedaje.obtenerPromedioCalificaciones() > 0.6) 
	    	{
	    		star1.setImage(new Image(Util.ICON_STAR_LLENA));
	    		star2.setImage(new Image(Util.ICON_STAR_VACIA));
	    		star3.setImage(new Image(Util.ICON_STAR_VACIA));
	    		star4.setImage(new Image(Util.ICON_STAR_VACIA));
	    		star5.setImage(new Image(Util.ICON_STAR_VACIA));
	    	}
	    	else if(hospedaje.obtenerPromedioCalificaciones() > 0.0) 
	    	{
	    		star1.setImage(new Image(Util.ICON_STAR_MEDIO_LLENA));
	    		star2.setImage(new Image(Util.ICON_STAR_VACIA));
	    		star3.setImage(new Image(Util.ICON_STAR_VACIA));
	    		star4.setImage(new Image(Util.ICON_STAR_VACIA));
	    		star5.setImage(new Image(Util.ICON_STAR_VACIA));
	    	}
	    	else 
	    	{
	    		star1.setImage(new Image(Util.ICON_STAR_VACIA));
	    		star2.setImage(new Image(Util.ICON_STAR_VACIA));
	    		star3.setImage(new Image(Util.ICON_STAR_VACIA));
	    		star4.setImage(new Image(Util.ICON_STAR_VACIA));
	    		star5.setImage(new Image(Util.ICON_STAR_VACIA));
	    	}
	    }

	    @FXML
	    void verPerfil(ActionEvent event) {
	    	
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_PERFIL_ANFITRION));
			Parent root = null;
			try {
				root = loader.load();
			} catch (IOException a) {
				// TODO Auto-generated catch block
				a.printStackTrace();
			}
			

			ControladorPerfilAnfitrion control = loader.getController();
			control.setResonance(resonance);
			control.setStage(stage);
			
			Scene scene = new Scene(root);

			stage.setResizable(false);
			stage.setTitle("Resonance Home");
			stage.getIcons().add(new Image(Util.LOGO_RESONANCE));
			stage.setScene(scene);
			stage.show();
			
			control.inicializar();
	    	
	    }
	    
	    public Hospedaje getHospedaje() {
			return hospedaje;
		}


		public void setHospedaje(Hospedaje hospedaje) {
			this.hospedaje = hospedaje;
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
		

}
