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
		comboPaises.getItems().addAll("Afganistán", "Albania", "Alemania", "Andorra", "Angola", "Antigua y Barbuda",
				"Arabia Saudita", "Argelia", "Argentina", "Armenia", "Australia", "Austria", "Azerbaiyán", "Bahamas",
				"Bangladés", "Barbados", "Baréin", "Bélgica", "Belice", "Benín", "Bielorrusia", "Birmania", "Bolivia",
				"Bosnia y Herzegovina", "Botsuana", "Brasil", "Brunéi", "Bulgaria", "Burkina Faso", "Burundi", "Bután",
				"Cabo Verde", "Camboya", "Camerún", "Canadá", "Catar", "Chad", "Chile", "China", "Chipre",
				"Ciudad del Vaticano", "Colombia", "Comoras", "Corea del Norte", "Corea del Sur", "Costa de Marfil",
				"Costa Rica", "Croacia", "Cuba", "Dinamarca", "Dominica", "Ecuador", "Egipto", "El Salvador",
				"Emiratos Árabes Unidos", "Eritrea", "Eslovaquia", "Eslovenia", "España", "Estados Unidos", "Estonia",
				"Etiopía", "Filipinas", "Finlandia", "Fiyi", "Francia", "Gabón");
//		Gambia: Banjul.
//		Georgia: Tiflis.
//		Ghana: Acra.
//		Granada: Saint George.
//		Grecia: Atenas.
//		Guatemala: Ciudad de Guatemala.
//		Guyana: Georgetown.
//		Guinea: Conakri.
//		Guinea-Bisáu: Bisáu.
//		Guinea Ecuatorial: Malabo.
//		Haití: Puerto Príncipe.
//		Honduras: Tegucigalpa.
//		Hungría: Budapest.
//		India: Nueva Delhi.
//		Indonesia: Yakarta.
//		Irak: Bagdad.
//		Irán: Teherán.
//		Irlanda: Dublín.
//		Islandia: Reikiavik.
//		Islas Marshall: Majuro.
//		Islas Salomón: Honiara.
//		Israel: Jerusalén.
//		Italia: Roma.
//		Jamaica: Kingston.
//		Japón: Tokio.
//		Jordania: Amán.
//		Kazajistán: Astaná.
//		Kenia: Nairobi.
//		Kirguistán: Biskek.
//		Kiribati: Tarawa.
//		Kuwait: Kuwait.
//		Laos: Vientián.
//		Lesoto: Maseru.
//		Letonia: Riga.
//		Líbano: Beirut.
//		Liberia: Monrovia.
//		Libia: Trípoli.
//		Liechtenstein: Vaduz.
//		Lituania: Vilna.
//		Luxemburgo: Luxemburgo.
//		Macedonia del Norte: Skopie.
//		Madagascar: Antananarivo.
//		Malasia: Kuala Lumpur.
//		Malaui: Lilongüe.
//		Maldivas: Malé.
//		Malí: Bamako.
//		Malta: La Valeta.
//		Marruecos: Rabat.
//		Mauricio: Port-Louis.
//		Mauritania: Nuakchot.
//		México: Ciudad de México. (*)
//		Micronesia: Palikir.
//		Moldavia: Chisináu.
//		Mónaco: Mónaco.
//		Mongolia: Ulán Bator.
//		Montenegro: Podgorica.
//		Mozambique: Maputo.
//		Namibia: Windhoek.
//		Nauru: Yaren.
//		Nepal: Katmandú.
//		Nicaragua: Managua.
//		Níger: Niamey.
//		Nigeria: Abuya.
//		Noruega: Oslo.
//		Nueva Zelanda: Wellington.
//		Omán: Mascate.
//		Países Bajos: Ámsterdam. (*)
//		Pakistán: Islamabad.
//		Palaos: Melekeok.
//		Panamá: Panamá.
//		Papúa Nueva Guinea: Port Moresby.
//		Paraguay: Asunción.
//		Perú: Lima.
//		Polonia: Varsovia.
//		Portugal: Lisboa.
//		Reino Unido de Gran Bretaña e Irlanda del Norte: Londres. (*)
//		República Centroafricana: Bangui.
//		República Checa: Praga.
//		República del Congo: Brazzaville.
//		República Democrática del Congo: Kinsasa.
//		República Dominicana: Santo Domingo.
//		República Sudafricana: Bloemfontein, Ciudad Del Cabo y Pretoria. (*)
//		Ruanda: Kigali.
//		Rumanía: Bucarest.
//		Rusia: Moscú.
//		Samoa: Apia.
//		San Cristóbal y Nieves: Basseterre.
//		San Marino: San Marino.
//		San Vicente y las Granadinas: Kingstown.
//		Santa Lucía: Castries.
//		Santo Tomé y Príncipe: Santo Tomé.
//		Senegal: Dakar.
//		Serbia: Belgrado.
//		Seychelles: Victoria.
//		Sierra Leona: Freetown.
//		Singapur: Singapur.
//		Siria: Damasco.
//		Somalia: Mogadiscio.
//		Sri Lanka: Sri Jayewardenepura (capital administrativa) y Colombo (capital comercial). (*)
//		Suazilandia: Babane y Lobamba.
//		Sudán: Jartum.
//		Sudán del Sur: Yuba.
//		Suecia: Estocolmo.
//		Suiza: Berna.
//		Surinam: Paramaribo.
//		Tailandia: Bangkok.
//		Tanzania: Dodoma.
//		Tayikistán: Dusambé.
//		Timor Oriental: Dili.
//		Togo: Lomé.
//		Tonga: Nukualofa.
//		Trinidad y Tobago: Puerto España.
//		Túnez: Túnez.
//		Turkmenistán: Asjabad.
//		Turquía: Ankara.
//		Tuvalu: Fongafale.
//		Ucrania: Kiev.
//		Uganda: Kampala.
//		Uruguay
//		Uzbekistán
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
