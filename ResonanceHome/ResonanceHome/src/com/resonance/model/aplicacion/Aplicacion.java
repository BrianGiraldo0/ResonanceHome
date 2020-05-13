package com.resonance.model.aplicacion;

import com.resonance.model.excepciones.NoExistException;
import com.resonance.model.principal.ResonanceHome;
import com.resonance.model.util.Util;
import com.resonance.view.controller.ControladorPrincipal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Aplicacion extends Application {
	private ResonanceHome resonance;
	private Stage stage;

	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.stage = primaryStage;
		inicializarResonance();
		FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.VENTANA_PRINCIPAL));
		Parent root = loader.load();
		ControladorPrincipal control = loader.getController();
		
		control.setResonance(resonance);

		control.setStage(stage);
		Scene scene = new Scene(root);

		primaryStage.setResizable(false);
		primaryStage.setTitle("Resonance Home");
		primaryStage.getIcons().add(new Image(Util.LOGO_RESONANCE));
//		primaryStage.setMaximized(true);
		primaryStage.setScene(scene);
		primaryStage.show();
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
