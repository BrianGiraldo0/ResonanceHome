package com.resonance.view.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.resonance.model.excepciones.NoExistException;
import com.resonance.model.principal.ResonanceHome;
import com.resonance.model.txt.Chat;
import com.resonance.model.txt.Mensaje;
import com.resonance.model.usuarios.Anfitrion;
import com.resonance.model.usuarios.Huesped;
import com.resonance.model.usuarios.Usuario;
import com.resonance.model.util.Util;
import com.resonance.view.interfaz.StageR;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ControladorMensajes {
	private StageR stage;
	private ResonanceHome resonance;
	@FXML
	private TextField tfBuscar;

	@FXML
	private VBox panelChats;

	@FXML
	private Text btnAtras;

	@FXML
	private VBox panelMensajes;
	private Usuario usuario;
	@FXML
	private TextField tfMensaje;

	@FXML
	private AnchorPane panelEnviar;
	private String receptor;

	@FXML
	private ImageView btnEnviar;
	private Chat chatActual;

	public void inicializar() {
		colorearBotones();
		usuario = stage.getUsuarioLogeado();
		btnAtras.setOnMouseClicked((e) -> {
			abrirVentanaAnterior();
		});
		ArrayList<Chat> chats = usuario.getChats();
		System.out.println(chats.size());

			llenarChats(chats);
		panelEnviar.setVisible(false);
		btnEnviar.setOnMouseClicked((e) -> {
			String texto = tfMensaje.getText();
			if (chatActual.getEmisor().equals(usuario.getNametag())) {
				try {
					resonance.enviarMensajeChat(stage.getUsuarioLogeado().getNametag(), receptor, texto);
					tfMensaje.setText("");
				} catch (NoExistException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				try {
					resonance.enviarMensajeChat(stage.getUsuarioLogeado().getNametag(), receptor,
							texto);
					tfMensaje.setText("");

				} catch (NoExistException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			llenarMensajes(chatActual);
		});
	}

	public void abrirVentanaAnterior() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(stage.getVentanaAnterior()));
		try {
			Parent root = loader.load();
			Util.updateController(loader, stage, resonance);
			stage.getScene().setRoot(root);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void colorearBotones() {
		// Botón ayuda
		btnEnviar.setOnMouseEntered((e) -> {

			btnEnviar.setStyle("-fx-background-color: #EBE8EE");
		});
		btnEnviar.setOnMouseExited((e) -> {
			btnEnviar.setStyle("-fx-background-color: #FFFFFF");
		});

	}

	public void llenarMensajes(Chat chat) {
		panelMensajes.getChildren().clear();
		for (int i = 0; i < chat.getMensaje().size(); i++) {
			Mensaje m = chat.getMensaje().get(i);
			AnchorPane pane = new AnchorPane();
			pane.setPrefWidth(837);
			pane.setPrefHeight(50);

			Label label = new Label();
			label.setText("   " + m.getMensaje());
			label.setPrefWidth(368);
			label.setPrefHeight(30);
			label.setLayoutX(14);
			label.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 15");
			if (stage.getUsuarioLogeado().getNametag().equals(m.getEmisor())) {
				label.setLayoutX(400);
				label.setStyle("-fx-background-color: #85F085; -fx-background-radius: 15");
			}

			label.setLayoutY(9);
			pane.getChildren().add(label);

			panelMensajes.getChildren().add(pane);
		}
	}

	public void llenarChats(ArrayList<Chat> chats) {
		panelChats.getChildren().clear();
		for (int i = 0; i < chats.size(); i++) {
			Huesped huesped = null;
			Anfitrion anfitron = null;
			Chat c = chats.get(i);
			String receptor = chats.get(i).getReceptor();
				if (resonance.obtenerAnfitrion(chats.get(i).getReceptor()) != null) {
					anfitron = resonance.obtenerAnfitrion(chats.get(i).getReceptor());
				}

				if (resonance.obtenerHuesped(chats.get(i).getReceptor()) != null) {
					huesped = resonance.obtenerHuesped(chats.get(i).getReceptor());
				}


			AnchorPane pane = new AnchorPane();
			pane.setPrefWidth(387);
			pane.setPrefHeight(70);
			ImageView image = new ImageView();
			Label label = new Label();
			label.setFont(new Font("Arial", 24));
			if (huesped != null) {
				if (!huesped.getURLFoto().equals(""))
					image.setImage(new Image("file:///" + huesped.getURLFoto()));
				label.setText(huesped.getNametag());
			} else if (anfitron != null) {
				if (!anfitron.getURLFoto().equals(""))
					image.setImage(new Image("file:///" + anfitron.getURLFoto()));
				label.setText(anfitron.getNametag());
			}
			pane.getChildren().add(image);
			image.setFitHeight(46);
			image.setFitWidth(58);
			image.setLayoutX(14);
			image.setLayoutY(12);

			pane.getChildren().add(label);
			label.setLayoutX(14);
			label.setLayoutY(12);
			pane.setOnMouseClicked((e) -> {
				llenarMensajes(c);
				chatActual = c;
				panelEnviar.setVisible(true);
				this.receptor = receptor;
			});
			panelChats.getChildren().add(pane);

		}

	}


	/**
	 * @return the stage
	 */
	public StageR getStage() {
		return stage;
	}

	/**
	 * @param stage the stage to set
	 */
	public void setStage(StageR stage) {
		this.stage = stage;
	}

	/**
	 * @return the resonance
	 */
	public ResonanceHome getResonance() {
		return resonance;
	}

	/**
	 * @param resonance the resonance to set
	 */
	public void setResonance(ResonanceHome resonance) {
		this.resonance = resonance;
	}

}
