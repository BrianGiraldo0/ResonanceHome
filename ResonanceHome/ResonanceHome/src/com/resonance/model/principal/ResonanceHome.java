package com.resonance.model.principal;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import com.resonance.model.archivos.FileManager;
import com.resonance.model.excepciones.NoExistException;
import com.resonance.model.hospedajes.Direccion;
import com.resonance.model.hospedajes.Hospedaje;
import com.resonance.model.hospedajes.Plus;
import com.resonance.model.hospedajes.Prestacion;
import com.resonance.model.hospedajes.TipoHospedaje;
import com.resonance.model.usuarios.Anfitrion;
import com.resonance.model.usuarios.Huesped;
import com.resonance.model.util.Fecha;
import com.resonance.model.util.Util;

public class ResonanceHome {

	private HashMap<String, Huesped> huespedes = new HashMap<String, Huesped>();
	private HashMap<String, Anfitrion> anfitriones = new HashMap<String, Anfitrion>();
	private HashMap<String, Hospedaje> hospedajes = new HashMap<String, Hospedaje>();
	private Fecha fecha;

	/**
	 * Metodo constructor de la clase principal
	 * @throws NoExistException Excepcion necesaria para el metodo llenarPruebas
	 */
	public ResonanceHome() throws NoExistException {
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int month = localDate.getMonthValue();
		int year = localDate.getYear();
		int day = localDate.getDayOfMonth();
		fecha = new Fecha(day, month, year);
		llenarPruebas();
		FileManager.inicializar();
	}

	/**
	 * Método rellena datos de prueba
	 * @throws NoExistException Excepcion en caso de no existir un anfitrion para el hospedaje.}
	 */
	public void llenarPruebas() throws NoExistException {
		
		//las contraseñas de los usuarios son el primer nombre. Ejemplo: "Oscar Gomez" contraseña = "oscar".
		fillHuespedes();
		fillAnfitriones();
		fillHospedajes();
		}

	/**
	 * Método que rellena huespedes de prueba
	 */
	public void fillHuespedes() {
		Date fecha1 = new Date(2000, 11, 29);
		Date fecha2 = new Date(1997, 4, 9);
		Date fecha3 = new Date(1990, 10, 27);

		agregarHuesped("Cesar Marquez", "cesar@gmail.com", "", "Calle 12 # 4", fecha1, "cesar", "Hola, soy cesar",
				"cemarquez");
		agregarHuesped("Antonio Sepulveda", "antoniel9704@gmail.com", "", "Calle 51B # 12 - 04", fecha2, "antonio",
				"Soy estudiante de literatura, me gusta disfrutar de un buen lugar", "sepultonio");
		agregarHuesped("Estela Aguilar", "ester.aguila@gmail.com", "", "Carre 16N # 13 - 42", fecha3, "estela",
				"Me gusta viajar por el mundo, disfrutar de la vida, soy buena inquilina", "esterguila");

	}

	/**
	 * Método que rellena hospedajes de prueba
	 * 
	 * @throws NoExistException Excepcion en caso de no existir el anfitrion.
	 */
	public void fillHospedajes() throws NoExistException {
		Plus plus1 = new Plus(false, true, false, true, true);
		Plus plus2 = new Plus(true, true, true, true, true);
		Plus plus3 = new Plus(true, true, false, false, true);

		Prestacion pres1 = new Prestacion(2, 1, false);
		Prestacion pres2 = new Prestacion(4, 2, true);
		Prestacion pres3 = new Prestacion(1, 1, true);

		Direccion direc1 = new Direccion("Armenia", "Quindio", "Colombia", "Calle 57 # 13 - 14");
		Direccion direc2 = new Direccion("Cartagena", "Bolivar", "Colombia", "Carrera 43 # 22 - 21");
		Direccion direc3 = new Direccion("Medellin", "Antioquia", "Colombia", "Calle 13 # 07 - 22");

		ArrayList<String> fotos1 = new ArrayList<String>();
//		fotos1.add("/com/resonance/view/imagenes/hospedajes/hospedaje01/1b.jpg");
//		fotos1.add("src/view/imagenes/hospedajes/hospedaje01/2b.jpg");
		
		ArrayList<String> fotos2 = new ArrayList<String>();
//		fotos2.add("src/view/imagenes/hospedajes/hospedaje02/1a.jpg");
//		fotos2.add("src/view/imagenes/hospedajes/hospedaje02/2a.jpg");
//		fotos2.add("src/view/imagenes/hospedajes/hospedaje02/3a.jpg");
		
		ArrayList<String> fotos3 = new ArrayList<String>();
//		fotos3.add("src/view/imagenes/hospedajes/hospedaje03/1c.jpg");
//		fotos3.add("src/view/imagenes/hospedajes/hospedaje03/2c.jpg");

		agregarHospedaje(direc1, 87000.0, "gustavomene", fotos1,
				"Habitacion con gran espacio perfecto para parejas, buena iluminación natural y buena convivencia",
				plus1, TipoHospedaje.HABITACION, pres1, "Habitación con baño propio");
		agregarHospedaje(direc2, 320000.0, "oscarlop", fotos2,
				"Apartamento comodo, amplio y agradables vistas para pasar una estadia agradable en familia, amigos o pareja",
				plus2, TipoHospedaje.APARTAMENTO, pres2, "Apartamento con vista al mar");
		agregarHospedaje(direc3, 95000.0, "patyherrera", fotos3,
				"Habitacion pequeña pero bien amoblada, fresca y se realiza aseo semanal; el resto de la casa en la mayor parte del dia esta disponible para el huesped",
				plus3, TipoHospedaje.HABITACION, pres3, "Apartamento bonito");
	}

	/**
	 * Método que rellena anfitriones de prueba
	 */
	public void fillAnfitriones() {
		Date fecha1 = new Date(1968, 1, 12);
		Date fecha2 = new Date(1995, 8, 26);
		Date fecha3 = new Date(1982, 12, 8);
		// agregarAnfitrion(nombre, email, uRLFoto, direccion, fechaNacimiento,
		// contrasenia, biografia, nametag);
		agregarAnfitrion("Gustavo Meneses", "sergio.meneses95", "", "Calle 57 # 13 - 14", fecha1, "gustavo",
				"Me considero una persona simpatica, ordenada y mantengo todo de la mejor manera", "gustavomene");
		agregarAnfitrion("Oscar Lopez", "oscarin.lop@gmail.com", "", "Carrera 24 # 20 - 47", fecha2, "oscar",
				"Me gusta la buena musica, intento mantener siempre un ambiente agradable", "oscarlop");
		agregarAnfitrion("Patricia Herrera", "patyherrera@gmail.com", "", "Calle 13 # 07 - 22", fecha3, "patricia",
				"Soy economista, experta en negocios internacionale, viajo mucho y me considero una persona social y carismatica",
				"patyherrera");
	}

	/**
	 * Metodo que obtiene un huesped mediante su nombre de usuario
	 * 
	 * @param nametag
	 * @return
	 * @throws NoExistException
	 */
	public Huesped obtenerHuesped(String nametag) throws NoExistException {
		if (huespedes.get(nametag) == null) {
			throw new NoExistException();
		} else {
			return huespedes.get(nametag);
		}

	}

	/**
	 * Metodo que obtiene un anfitrion mediante su nombre de usuario
	 * 
	 * @param nametag
	 * @return
	 * @throws NoExistException
	 */
	public Anfitrion obtenerAnfitrion(String nametag) throws NoExistException {
		if (anfitriones.get(nametag) == null) {
			throw new NoExistException();
		} else {
			return anfitriones.get(nametag);
		}

	}

	/**
	 * Metodo que obtiene un hospedaje mediante su nombre
	 * 
	 * @param name
	 * @return
	 * @throws NoExistException
	 */
	public Hospedaje obtenerHospedaje(String name) throws NoExistException {
		if (hospedajes.get(name) == null) {
			throw new NoExistException();
		} else {
			return hospedajes.get(name);
		}

	}

	/**
	 * Metodo que permite agregar un hospedaje a la lista global de hospedajes
	 * 
	 * @param direccion
	 * @param precio
	 * @param nameTagPropietario
	 * @param urlsFotos
	 * @param descripcion
	 * @param servicios
	 * @param tipoH
	 */
	public void agregarHospedaje(Direccion direccion, double precio, String nameTagPropietario,
			ArrayList<String> urlsFotos, String descripcion, Plus servicios, TipoHospedaje tipoH,
			Prestacion prestaciones, String titulo) throws NoExistException {

		if (anfitriones.get(nameTagPropietario) != null) {
			String id = Util.generarIDHospedaje();
			Hospedaje hosp = new Hospedaje(id, direccion, precio, nameTagPropietario, urlsFotos, descripcion, servicios,
					tipoH, prestaciones);
			hosp.setTitulo(titulo);
			anfitriones.get(nameTagPropietario).agregarHospedaje(id);
			Util.agregarSugerencia(direccion.toString());
			FileManager.agregarHospedaje(id, nameTagPropietario, urlsFotos);
			hospedajes.put(id, hosp);
		} else {
			throw new NoExistException();
		}
	}

	/**
	 * Metodo que agrega un anfitrion a la lista
	 * 
	 * @param nombre
	 * @param email
	 * @param uRLFoto
	 * @param direccion
	 * @param fechaNacimiento
	 * @param contrasenia
	 * @param biografia
	 * @param nametag
	 */
	public void agregarAnfitrion(String nombre, String email, String uRLFoto, String direccion, Date fechaNacimiento,
			String contrasenia, String biografia, String nametag) {
		Anfitrion anfitrion;
		if (uRLFoto == null || uRLFoto.equals("")) {
			anfitrion = new Anfitrion(nombre, email, direccion, fechaNacimiento, contrasenia, biografia, nametag);
		} else {
			anfitrion = new Anfitrion(nombre, email, uRLFoto, direccion, fechaNacimiento, contrasenia, biografia,
					nametag);
		}
		FileManager.crearCarpetaAnfitrion(nametag);
		anfitriones.put(nametag, anfitrion);

	}

	/**
	 * Metodo que permite agregar un huesped a la lista
	 * 
	 * @param nombre
	 * @param email
	 * @param uRLFoto
	 * @param direccion
	 * @param fechaNacimiento
	 * @param contrasenia
	 * @param biografia
	 * @param nametag
	 */
	public void agregarHuesped(String nombre, String email, String uRLFoto, String direccion, Date fechaNacimiento,
			String contrasenia, String biografia, String nametag) {
		Huesped huesped;
		if (uRLFoto == null || uRLFoto.equals("")) {
			huesped = new Huesped(nombre, email, direccion, fechaNacimiento, contrasenia, biografia, nametag);
		} else {
			huesped = new Huesped(nombre, email, uRLFoto, direccion, fechaNacimiento, contrasenia, biografia, nametag);
		}
		FileManager.crearCarpetaHuesped(nametag);
		huespedes.put(nametag, huesped);

	}



	/**
	 * Metodo que permite filtrar hopedajes dependiendo de una serie de
	 * especificaciones
	 * 
	 * @param hospedajesF
	 * @param tipoH
	 * @param valorMin
	 * @param valorMax
	 * @return
	 */
	public ArrayList<Hospedaje> filtarHospedajes(ArrayList<Hospedaje> hospedajesF, TipoHospedaje tipoH, double valorMin,
			double valorMax) {
		ArrayList<Hospedaje> resultado = new ArrayList<Hospedaje>();

		for (int i = 0; i < hospedajesF.size(); i++) {
			Hospedaje hAux = hospedajesF.get(i);
			if (hAux.getTipoHospedaje() == tipoH) {
				if (hAux.getPrecio() > valorMin && hAux.getPrecio() < valorMax) {

					resultado.add(hAux);
				}
			}
		}
		return resultado;
	}

	public ArrayList<Hospedaje> buscarHospedajes(String ubicacion, ArrayList<Date> date, String huespedes) {
		ArrayList<Hospedaje> ltsHospedajes = new ArrayList<Hospedaje>();
		Iterator<String> keys = hospedajes.keySet().iterator();

		while (keys.hasNext()) {
			String key = keys.next();
			Hospedaje hosp = hospedajes.get(key);
			if (hosp.getDireccion().toString().equals(ubicacion)) {
				if (date.size() != 0) {
					if (hosp.disponibleEnFecha(date)) {
						int h = Integer.parseInt(huespedes);
						if (hosp.getPrestaciones().getNumHuesped() >= h) {
							ltsHospedajes.add(hosp);
						}
					}
				} else {
					if (hosp.disponibleEnFecha(date)) {
						int h = Integer.parseInt(huespedes);
						if (hosp.getPrestaciones().getNumHuesped() >= h) {
							ltsHospedajes.add(hosp);
						}
					}
				}

			}
		}

		return ltsHospedajes;
	}

	/**
	 * Metodo que añade un dia a una fecha y ademas actualiza las reservas y
	 * hospedajes
	 */
	public void anadirDia() {
		fecha.anadirDia();
		Iterator<String> keys = huespedes.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			huespedes.get(key).update(fecha);
		}
	}

	/**
	 * @return the huespedes
	 */
	public HashMap<String, Huesped> getHuespedes() {
		return huespedes;
	}

	/**
	 * @return the anfitriones
	 */
	public HashMap<String, Anfitrion> getAnfitriones() {
		return anfitriones;
	}

	/**
	 * @return the hospedajes
	 */
	public HashMap<String, Hospedaje> getHospedajes() {
		return hospedajes;
	}

}
