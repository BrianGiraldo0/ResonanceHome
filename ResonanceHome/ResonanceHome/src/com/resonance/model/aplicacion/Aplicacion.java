package com.resonance.model.aplicacion;

import com.resonance.model.excepciones.NoExistException;
import com.resonance.model.principal.ResonanceHome;
import com.resonance.model.util.Util;
import com.resonance.view.controller.ControladorPrincipal;
import com.resonance.view.interfaz.StageR;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Proyecto de programación - Analisis de algoritmos
 * 
 * @author Cesar Marquez, Brian Giraldo, Esteban Sanchez
 *
 */
public class Aplicacion extends Application {
	private ResonanceHome resonance;
	private StageR stage;

	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		StageR stage = new StageR();
		this.stage = stage;

		inicializarResonance();
//		stage.setHuespedLogeado(resonance.obtenerHuesped("cemarquez"));
		FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.VENTANA_PRINCIPAL));
		Parent root = loader.load();
		ControladorPrincipal control = loader.getController();
		
		control.setResonance(resonance);

		control.setStage(stage);
		Scene scene = new Scene(root);
		stage.setWidth(1280);
		stage.setResizable(false);
		stage.setTitle("Resonance Home");
		stage.getIcons().add(new Image(Util.LOGO_RESONANCE));
		stage.setScene(scene);
		stage.show();
		control.inicializar();

	}
	
	/**
	 * Método donde se inicializa la clase principal
	 */
	public void inicializarResonance()
	{
		//Invocar aqui la serialización
		try {
			resonance = new ResonanceHome();
		} catch (NoExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
