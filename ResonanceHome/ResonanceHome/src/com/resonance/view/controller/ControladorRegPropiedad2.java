package com.resonance.view.controller;

import java.io.IOException;

import com.resonance.model.hospedajes.Hospedaje;
import com.resonance.model.principal.ResonanceHome;
import com.resonance.model.util.Util;
import com.resonance.view.interfaz.StageR;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ControladorRegPropiedad2 {
	private StageR stage;
	
	private ResonanceHome resonance;
	
	private Hospedaje hospedaje;
	@FXML
	private Button btnAtras;

	@FXML

	private Button btnSiguiente;
	@FXML
	private AnchorPane idPaso1;

	@FXML
	private AnchorPane lUbicacion;

	@FXML
	private AnchorPane lFecha;

	@FXML
	private AnchorPane lHuespedes;

	@FXML
	private AnchorPane lHuespedes1;

	@FXML
	private AnchorPane idImage;

	@FXML
	private ImageView idImagen;

	@FXML
	private TextField txtDireccion;

	@FXML
	private TextField txtInfo;

	@FXML
	private ComboBox<String> comboPaises;

	@FXML
	private TextField txtCiudad;

	@FXML
	private TextField txtDepartamento;

	@FXML
	private TextField txtCodigoPostal;

	@FXML
	void onClic(MouseEvent event) {
		if (event.getSource() == btnSiguiente) {
			
			
			
			hospedaje.getDireccion().setPais(comboPaises.getSelectionModel().getSelectedItem());
			hospedaje.getDireccion().setDireccion(txtDireccion.getText());
			hospedaje.getDireccion().setEstado(txtDepartamento.getText());
			
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource(Util.PANEL_REGPROPIEDAD_3));
			Parent root = null;
			try {
				root = loader.load();
			} catch (IOException a) {
				// TODO Auto-generated catch block
				a.printStackTrace();
			}

			ControladorRegPropiedad3 control = loader.getController();
			control.setResonance(resonance);
			control.setStageR(stage);
			control.setHospedaje(hospedaje);
//			control.inicializar();
			stage.setResizable(false);
			stage.getScene().setRoot(root);

		}
	}

	public void inicializar() {
		comboPaises.getItems().addAll("Afganist�n", "Albania", "Alemania", "Andorra", "Angola", "Antigua y Barbuda",
				"Arabia Saudita", "Argelia", "Argentina", "Armenia", "Australia", "Austria", "Azerbaiy�n", "Bahamas",
				"Banglad�s", "Barbados", "Bar�in", "B�lgica", "Belice", "Ben�n", "Bielorrusia", "Birmania", "Bolivia",
				"Bosnia y Herzegovina", "Botsuana", "Brasil", "Brun�i", "Bulgaria", "Burkina Faso", "Burundi", "But�n",
				"Cabo Verde", "Camboya", "Camer�n", "Canad�", "Catar", "Chad", "Chile", "China", "Chipre",
				"Ciudad del Vaticano", "Colombia", "Comoras", "Corea del Norte", "Corea del Sur", "Costa de Marfil",
				"Costa Rica", "Croacia", "Cuba", "Dinamarca", "Dominica", "Ecuador", "Egipto", "El Salvador",
				"Emiratos �rabes Unidos", "Eritrea", "Eslovaquia", "Eslovenia", "Espa�a", "Estados Unidos", "Estonia",
				"Etiop�a", "Filipinas", "Finlandia", "Fiyi", "Francia", "Gab�n");
//		Gambia: Banjul.
//		Georgia: Tiflis.
//		Ghana: Acra.
//		Granada: Saint George.
//		Grecia: Atenas.
//		Guatemala: Ciudad de Guatemala.
//		Guyana: Georgetown.
//		Guinea: Conakri.
//		Guinea-Bis�u: Bis�u.
//		Guinea Ecuatorial: Malabo.
//		Hait�: Puerto Pr�ncipe.
//		Honduras: Tegucigalpa.
//		Hungr�a: Budapest.
//		India: Nueva Delhi.
//		Indonesia: Yakarta.
//		Irak: Bagdad.
//		Ir�n: Teher�n.
//		Irlanda: Dubl�n.
//		Islandia: Reikiavik.
//		Islas Marshall: Majuro.
//		Islas Salom�n: Honiara.
//		Israel: Jerusal�n.
//		Italia: Roma.
//		Jamaica: Kingston.
//		Jap�n: Tokio.
//		Jordania: Am�n.
//		Kazajist�n: Astan�.
//		Kenia: Nairobi.
//		Kirguist�n: Biskek.
//		Kiribati: Tarawa.
//		Kuwait: Kuwait.
//		Laos: Vienti�n.
//		Lesoto: Maseru.
//		Letonia: Riga.
//		L�bano: Beirut.
//		Liberia: Monrovia.
//		Libia: Tr�poli.
//		Liechtenstein: Vaduz.
//		Lituania: Vilna.
//		Luxemburgo: Luxemburgo.
//		Macedonia del Norte: Skopie.
//		Madagascar: Antananarivo.
//		Malasia: Kuala Lumpur.
//		Malaui: Lilong�e.
//		Maldivas: Mal�.
//		Mal�: Bamako.
//		Malta: La Valeta.
//		Marruecos: Rabat.
//		Mauricio: Port-Louis.
//		Mauritania: Nuakchot.
//		M�xico: Ciudad de M�xico. (*)
//		Micronesia: Palikir.
//		Moldavia: Chisin�u.
//		M�naco: M�naco.
//		Mongolia: Ul�n Bator.
//		Montenegro: Podgorica.
//		Mozambique: Maputo.
//		Namibia: Windhoek.
//		Nauru: Yaren.
//		Nepal: Katmand�.
//		Nicaragua: Managua.
//		N�ger: Niamey.
//		Nigeria: Abuya.
//		Noruega: Oslo.
//		Nueva Zelanda: Wellington.
//		Om�n: Mascate.
//		Pa�ses Bajos: �msterdam. (*)
//		Pakist�n: Islamabad.
//		Palaos: Melekeok.
//		Panam�: Panam�.
//		Pap�a Nueva Guinea: Port Moresby.
//		Paraguay: Asunci�n.
//		Per�: Lima.
//		Polonia: Varsovia.
//		Portugal: Lisboa.
//		Reino Unido de Gran Breta�a e Irlanda del Norte: Londres. (*)
//		Rep�blica Centroafricana: Bangui.
//		Rep�blica Checa: Praga.
//		Rep�blica del Congo: Brazzaville.
//		Rep�blica Democr�tica del Congo: Kinsasa.
//		Rep�blica Dominicana: Santo Domingo.
//		Rep�blica Sudafricana: Bloemfontein, Ciudad Del Cabo y Pretoria. (*)
//		Ruanda: Kigali.
//		Ruman�a: Bucarest.
//		Rusia: Mosc�.
//		Samoa: Apia.
//		San Crist�bal y Nieves: Basseterre.
//		San Marino: San Marino.
//		San Vicente y las Granadinas: Kingstown.
//		Santa Luc�a: Castries.
//		Santo Tom� y Pr�ncipe: Santo Tom�.
//		Senegal: Dakar.
//		Serbia: Belgrado.
//		Seychelles: Victoria.
//		Sierra Leona: Freetown.
//		Singapur: Singapur.
//		Siria: Damasco.
//		Somalia: Mogadiscio.
//		Sri Lanka: Sri Jayewardenepura (capital administrativa) y Colombo (capital comercial). (*)
//		Suazilandia: Babane y Lobamba.
//		Sud�n: Jartum.
//		Sud�n del Sur: Yuba.
//		Suecia: Estocolmo.
//		Suiza: Berna.
//		Surinam: Paramaribo.
//		Tailandia: Bangkok.
//		Tanzania: Dodoma.
//		Tayikist�n: Dusamb�.
//		Timor Oriental: Dili.
//		Togo: Lom�.
//		Tonga: Nukualofa.
//		Trinidad y Tobago: Puerto Espa�a.
//		T�nez: T�nez.
//		Turkmenist�n: Asjabad.
//		Turqu�a: Ankara.
//		Tuvalu: Fongafale.
//		Ucrania: Kiev.
//		Uganda: Kampala.
//		Uruguay
//		Uzbekist�n
//		Vanuatu
//		Venezuela
//		Vietnam
//		Yemen
//		Yibuti
//		Zambia
//		Zimbabue
	}

	public void setResonance(ResonanceHome resonance) {
		this.resonance = resonance;
	}

	public void setStageR(StageR stage) {
		this.stage = stage;
	}

	public Hospedaje getHospedaje() {
		return hospedaje;
	}

	public void setHospedaje(Hospedaje hospedaje) {
		this.hospedaje = hospedaje;
	}
	
	
}
