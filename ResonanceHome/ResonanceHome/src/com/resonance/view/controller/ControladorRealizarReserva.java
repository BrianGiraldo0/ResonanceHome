package com.resonance.view.controller;

import java.util.Optional;

import com.resonance.model.principal.ResonanceHome;
import com.resonance.view.interfaz.StageR;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.text.Text;
import javafx.stage.StageStyle;





public class ControladorRealizarReserva {
	
	private ResonanceHome resonance;
	private StageR stage;
	
	
	
    @FXML
    private Button btnEliminarTarjeta;
	
    @FXML
    private Label labelEliminarTarjeta;
    
	@FXML
    private Label labelTotal;

    @FXML
    private TextField textCantidadHuespedes;

    @FXML
    private Label labelTarifaLimpieza;

    @FXML
    private Label labelMesLlegada;

    @FXML
    private Button btnContinuar;

    @FXML
    private Label labelPrecioAlojamiento;

    @FXML
    private Button quitarFoto;

    @FXML
    private DatePicker dateFechas;

    @FXML
    private Label labelComision;

    @FXML
    private Label labelTipo;

    @FXML
    private Text btnAtras;

    @FXML
    private Label labelPrecioDia;

    @FXML
    private Label lblDiaNumeroLlegada;

    @FXML
    private ComboBox<String> comboTarjetas ;
    
    private ObservableList<String> items = FXCollections.observableArrayList();
    
    
    private String tarjeta;

    @FXML
    private Label lblAgregarTarjeta;

    @FXML
    private Label labelMesSalida;

    @FXML
    private Label labelDiaNumeroSalida;
    @FXML
    private Button btnIngresarPago;
    
    
    
    public void inicializar() {
    	
    	
    	
    
 
    	
    	
    }
    
    
    
    
    @FXML
    void eliminarTarjeta (ActionEvent event) {
    	
    	String tarjetaBorrar = comboTarjetas.getSelectionModel().getSelectedItem().toString();
    	
    	items.remove(tarjetaBorrar);
    	comboTarjetas.getItems().clear();
    	comboTarjetas.getItems().addAll(items);
    	labelEliminarTarjeta.setVisible(false);
		btnEliminarTarjeta.setVisible(false);
    	
    }
    
    
    
   
    
    @FXML
    void mostrarEliminar(ActionEvent event) {
    	
    
    	
    	if (items.size()!=0) {
        	
        	
        	if (!comboTarjetas.getSelectionModel().getSelectedItem().toString().equals("tarjetas")) {
        		
        		labelEliminarTarjeta.setVisible(true);
        		btnEliminarTarjeta.setVisible(true);
        		
        	} else {
        		labelEliminarTarjeta.setVisible(false);
        		btnEliminarTarjeta.setVisible(false);
        	}
        	}
    }
    
    
    
    
    
    @FXML
    void ingresarPago(ActionEvent event) {

    	boolean centinela = false;
	
    	
    	tarjeta = showTextInput("INGRESAR TARJETA", "Por favor ingrese un número de tarjeta", "");
    	
  
    	
    	
    	if ((!tarjeta.equals("")) && items.size()!=0) {
    		
    	
    		
    		for (int i=0; i<items.size() && centinela ==false;i++) {
    			
    			if (items.get(i).trim().contentEquals(tarjeta.trim())) {
    					
    				
    				
    				showWarning("TARJETA YA REGISTRADA", "La tarjeta que intenta ingresar ya fue registrada");
    				centinela = true;
    			} 
    			
    			
    		}
    		
    		
    	}
    	
    	
    	if (centinela==false) {
    		comboTarjetas.getItems().clear();
    		items.add(tarjeta.trim());
			comboTarjetas.getItems().addAll(items);
			
			//inicializar();
		}

    	
    	
    }
    
    
    public static String showTextInput(String title, String message, String defaultValue) {
        TextInputDialog dialog = new TextInputDialog(defaultValue);
        dialog.initStyle(StageStyle.UTILITY);
        dialog.setTitle("Input");
        dialog.setHeaderText(title);
        dialog.setContentText(message);

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }

    }
    public static void showWarning(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Warning");
        alert.setHeaderText(title);
        alert.setContentText(message);

        alert.showAndWait();
    }
    
    
    public void setResonance(ResonanceHome resonance) {
		this.resonance = resonance;
	}

	public void setStage(StageR stage) {
		this.stage = stage;
	}
    
}
