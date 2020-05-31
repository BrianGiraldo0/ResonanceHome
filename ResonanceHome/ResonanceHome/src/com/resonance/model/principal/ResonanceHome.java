package com.resonance.model.principal;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import com.resonance.model.archivos.FileManager;
import com.resonance.model.excepciones.NoExistException;
import com.resonance.model.hospedajes.Calificacion;
import com.resonance.model.hospedajes.Direccion;
import com.resonance.model.hospedajes.Hospedaje;
import com.resonance.model.hospedajes.Plus;
import com.resonance.model.hospedajes.Prestacion;
import com.resonance.model.hospedajes.Reserva;
import com.resonance.model.hospedajes.TipoHospedaje;
import com.resonance.model.txt.Chat;
import com.resonance.model.txt.Mensaje;
import com.resonance.model.usuarios.Anfitrion;
import com.resonance.model.usuarios.Estrato;
import com.resonance.model.usuarios.Huesped;
import com.resonance.model.usuarios.NivelEstudio;
import com.resonance.model.util.ClienteEstadistica;
import com.resonance.model.util.Fecha;
import com.resonance.model.util.MailSender;
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
		fillAnfitriones();
		fillHuespedes();

		fillHospedajes();
		}

	/**
	 * Método que rellena huespedes de prueba
	 */
	public void fillHuespedes() {
		Date fecha1 = new Date(2000, 11, 29);
		Date fecha2 = new Date(1997, 4, 9);
		Date fecha3 = new Date(1990, 10, 27);

		agregarHuesped("Cesar Marquez", "cemarquezz29@gmail.com", "", "Calle 12 # 4", fecha1, "cesar",
				"Hola, soy cesar",
				"cemarquez", Estrato.ESTRATO_1, NivelEstudio.BACHILLER);
		agregarHuesped("Antonio Sepulveda", "antoniel9704@gmail.com", "", "Calle 51B # 12 - 04", fecha2, "antonio",
				"Soy estudiante de literatura, me gusta disfrutar de un buen lugar", "sepultonio", Estrato.ESTRATO_2,
				NivelEstudio.BACHILLER);
		agregarHuesped("Estela Aguilar", "ester.aguila@gmail.com", "", "Carre 16N # 13 - 42", fecha3, "estela",
				"Me gusta viajar por el mundo, disfrutar de la vida, soy buena inquilina", "esterguila",
				Estrato.ESTRATO_3, NivelEstudio.BACHILLER);
		
		Plus plus3 = new Plus(true, true, false, false, true);
		Prestacion pres3 = new Prestacion(1, 1, 3, 2, true);
		ArrayList<String> fotos3 = new ArrayList<String>();
		fotos3.add(FileManager.urlMain + "/Test/hospedaje03/1c.jpg");
		fotos3.add(FileManager.urlMain + "/Test/hospedaje03/2c.jpg");
		Direccion direc3 = new Direccion("Medellin", "Antioquia", "Colombia", "Calle 13 # 07 - 22");
		Hospedaje hosp = new Hospedaje("01", direc3, 95000.0, "patyherrera", fotos3,
				"Habitacion pequeña pero bien amoblada, fresca y se realiza aseo semanal; el resto de la casa en la mayor parte del dia esta disponible para el huesped",
				plus3, TipoHospedaje.HABITACION, pres3);
		hosp.setTitulo("Apartamento bonito");
		hospedajes.put(hosp.getId(), hosp);
		Huesped h = obtenerHuesped("cemarquez");
		ArrayList<Date> fechaReservada = new ArrayList<Date>();
		Reserva reserva = new Reserva(hosp, hosp.getNameTagPropietario(), null, h.getNombre(),
				hosp.getDireccion().toString(), h.getEmail(), h.getTarjeta(), fechaReservada, 10000, 2, fecha);
		h.agregarReserva(reserva);
			crearChat("cemarquez", "gustavomene");
		try {
			enviarMensajeChat("cemarquez", "gustavomene", "Hola bo");

			enviarMensajeChat("gustavomene", "cemarquez", "bien o que bo");
		} catch (NoExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	/**
	 * Método que rellena hospedajes de prueba
	 * 
	 * @throws NoExistException Excepcion en caso de no existir el anfitrion.
	 */
	public void fillHospedajes() throws NoExistException {
		Plus plus1 = new Plus(false, true, false, true, true);
		Plus plus2 = new Plus(true, true, true, true, true);


		Prestacion pres1 = new Prestacion(2, 1, 3, 1, false);
		Prestacion pres2 = new Prestacion(4, 2, 3, 3, true);


		Direccion direc1 = new Direccion("Armenia", "Quindio", "Colombia", "Calle 57 # 13 - 14");
		Direccion direc2 = new Direccion("Cartagena", "Bolivar", "Colombia", "Carrera 43 # 22 - 21");


		ArrayList<String> fotos1 = new ArrayList<String>();
		fotos1.add(FileManager.urlMain + "/Test/hospedaje01/1b.jpg");
		fotos1.add(FileManager.urlMain + "/Test/hospedaje01/2b.jpg");
		
		ArrayList<String> fotos2 = new ArrayList<String>();
		fotos2.add(FileManager.urlMain + "/Test/hospedaje02/1a.jpg");
		fotos2.add(FileManager.urlMain + "/Test/hospedaje02/2a.jpg");
		fotos2.add(FileManager.urlMain + "/Test/hospedaje02/3a.jpg");
		


		agregarHospedaje(direc1, 87000.0, "gustavomene", fotos1,
				"Habitacion con gran espacio perfecto para parejas, buena iluminación natural y buena convivencia",
				plus1, TipoHospedaje.HABITACION, pres1, "Habitación con baño propio");
		agregarHospedaje(direc2, 320000.0, "oscarlop", fotos2,
				"Apartamento comodo, amplio y agradables vistas para pasar una estadia agradable en familia, amigos o pareja",
				plus2, TipoHospedaje.APARTAMENTO, pres2, "Apartamento con vista al mar");


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
	public Huesped obtenerHuesped(String nametag) {
		if (huespedes.get(nametag) != null) {
			return huespedes.get(nametag);
		}

		return null;

	}

	public void crearChat(String emisor, String receptor) {
		if (obtenerAnfitrion(emisor) != null) {
			Anfitrion e = obtenerAnfitrion(emisor);
			Huesped r = obtenerHuesped(receptor);
			Chat chatE = new Chat(emisor, receptor);
			Chat chatR = new Chat(receptor, emisor);
			e.crearChat(chatE);
			r.crearChat(chatR);
		} else {
			Anfitrion r = obtenerAnfitrion(receptor);
			Huesped e = obtenerHuesped(emisor);
			Chat chatE = new Chat(e.getNametag(), r.getNametag());
			Chat chatR = new Chat(r.getNametag(), e.getNametag());
			e.crearChat(chatE);
			r.crearChat(chatR);
		}

	}

	public void enviarMensajeChat(String emisor, String receptor, String mensaje) throws NoExistException {
		if (obtenerAnfitrion(emisor) != null) {
			Anfitrion e = obtenerAnfitrion(emisor);
			Huesped r = obtenerHuesped(receptor);
			if (e.buscarChat(receptor) != null) {
				e.buscarChat(receptor).agregarMensaje(new Mensaje(mensaje, null, emisor));
				r.buscarChat(emisor).agregarMensaje(new Mensaje(mensaje, null, emisor));
			} else {
				crearChat(emisor, receptor);
			}

		} else {
			Huesped e = obtenerHuesped(emisor);
			Anfitrion r = obtenerAnfitrion(receptor);
			if (e.buscarChat(receptor) != null) {
				e.buscarChat(receptor).agregarMensaje(new Mensaje(mensaje, null, emisor));
				r.buscarChat(emisor).agregarMensaje(new Mensaje(mensaje, null, emisor));
			} else {
				crearChat(emisor, receptor);
			}

		}
	}

	/**
	 * Metodo que obtiene un anfitrion mediante su nombre de usuario
	 * 
	 * @param nametag
	 * @return
	 * @throws NoExistException
	 */
	public Anfitrion obtenerAnfitrion(String nametag) {
		if (anfitriones.get(nametag) != null) {
			return anfitriones.get(nametag);
		}

		return null;

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
			hosp.agregarCalificacion(new Calificacion(2, 3, 2, 5));
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
	 * Metodo que permite agregar un hospedaje a la lista global de hospedajes
	 * 
	 * @param hospedaje
	 * @throws NoExistException
	 */
	public void agregarHospedaje(Hospedaje hospedaje) throws NoExistException {
		if (anfitriones.get(hospedaje.getNameTagPropietario()) != null) {
			String id = Util.generarIDHospedaje();
			anfitriones.get(hospedaje.getNameTagPropietario()).agregarHospedaje(id);
			Util.agregarSugerencia(hospedaje.getDireccion().toString());
			FileManager.agregarHospedaje(id, hospedaje.getNameTagPropietario(), hospedaje.getUrlsFotos());
			hospedajes.put(id, hospedaje);

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
			anfitrion.setURLFoto(FileManager.urlMain + "/Usuarios/Anfitriones/" + nametag + "/imagenPerfil.png");
		}
		FileManager.crearCarpetaAnfitrion(nametag, uRLFoto);
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
			String contrasenia, String biografia, String nametag, Estrato estrato, NivelEstudio nivel) {
		Huesped huesped;
		if (uRLFoto == null || uRLFoto.equals("")) {
			huesped = new Huesped(nombre, email, direccion, fechaNacimiento, contrasenia, biografia, nametag, estrato,
					nivel);
		} else {
			huesped = new Huesped(nombre, email, uRLFoto, direccion, fechaNacimiento, contrasenia, biografia, nametag,
					estrato, nivel);
			huesped.setURLFoto(FileManager.urlMain + "/Usuarios/Huespedes/" + nametag + "/imagenPerfil.png");
		}
		FileManager.crearCarpetaHuesped(nametag, uRLFoto);
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

	/**
	 * Método que retorna los hospedajes que pasan por un determinado filtro
	 * 
	 * @param ubicacion
	 * @param date
	 * @param huespedes
	 * @return
	 */
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
	 * Método que retorna la lista de reservas hecha por todos los huespedes de
	 * resonancehome
	 * 
	 * @return
	 */
	public ArrayList<Reserva> obtenerReservas() {
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();

		Iterator<String> keys = huespedes.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			reservas.addAll(huespedes.get(key).getReservas());
		}

		return reservas;
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

		Iterator<String> keysH = hospedajes.keySet().iterator();
		while (keysH.hasNext()) {
			String key = keysH.next();
			hospedajes.get(key).actualizarCalificaciones();
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

	public Fecha getFecha() {
		return fecha;
	}

	public int getCantidadReservas(String ciudad, String id) throws NoExistException {
		int can = 0;
		if (obtenerHospedaje(id).getDireccion().getCiudad().equalsIgnoreCase(ciudad)) {
			Iterator<String> keys = huespedes.keySet().iterator();
			while (keys.hasNext()) {
				String key = keys.next();
				can += huespedes.get(key).getCantidadHospedajeReservado(id);
			}
		}

		return can;
	}

	public ArrayList<Hospedaje> getReservasPorCiudadDeMayorAMenor(String ciudad) throws NoExistException {
		ArrayList<Hospedaje> reservasEncontradas = new ArrayList<Hospedaje>();
		Iterator<String> keys = hospedajes.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			int can = getCantidadReservas(ciudad, key);
			if (can > 0)
				reservasEncontradas.add(hospedajes.get(key));

		}

		return ordenarArraylistMayorAMenor(reservasEncontradas, ciudad);
	}

	private ArrayList<Hospedaje> ordenarArraylistMayorAMenor(ArrayList<Hospedaje> reservasEncontradas, String ciudad)
			throws NoExistException {

		Hospedaje aux = null;

		for (int i = 0; i < reservasEncontradas.size(); i++) {
			for (int j = 0; j < reservasEncontradas.size() - 1; j++) {
				int can = getCantidadReservas(ciudad, reservasEncontradas.get(j).getId());
				int can1 = getCantidadReservas(ciudad, reservasEncontradas.get(j + 1).getId());
				if (can < can1) {
					aux = reservasEncontradas.get(j);
					reservasEncontradas.set(j, reservasEncontradas.get(j));
					reservasEncontradas.set(j + 1, aux);
				}
			}
		}

		return reservasEncontradas;
	}

	/**
	 * Método que envia un correo de bienvenidad
	 * @param datos
	 * @param user
	 */
	public void enviarCorreoBienvenida(String datos, String destino) {
		MailSender.enviarCorreoBienvenida(destino, datos);
	}

	public ClienteEstadistica clienteMayorCantidadReservas() {
		ClienteEstadistica c = null;
		int mayor = 0;
		Iterator<String> keys = huespedes.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			Huesped h = huespedes.get(key);
			if (h.getReservas().size() >= mayor) {
				c = new ClienteEstadistica(h, new ArrayList<String>());
				mayor = h.getReservas().size();
			}

		}

		for (int i = 0; i < c.getHuesped().getReservas().size(); i++) {
			String ciudad = c.getHuesped().getReservas().get(i).getHospedaje().getDireccion().getCiudad();
			if (!c.getCiudades().contains(ciudad)) {
				c.agregarCiudad(ciudad);
			}
		}

		return c;
	}

	/**
	 * Método que obtiene estrato y nivel estudio de clientes que reservaron en
	 * ciudad
	 */

	public ArrayList<String> obtenerEstratoEstudioPorCiudad(String ciudad) {

		ArrayList<String> lista = new ArrayList<String>();

		ArrayList<Reserva> reservas = obtenerReservas();

		for (int i = 0; i < reservas.size(); i++) {

			if (reservas.get(i).getHospedaje().getDireccion().getCiudad().equals(ciudad)) {

				if (verificarEstratoCiudadRepetido(lista.get(i), lista) == false) {

					Huesped huesped = obtenerHuesped(reservas.get(i).getNameTagHuesped());

					String persona = reservas.get(i).getNombre() + " Estrato: " + huesped.getEstrato().toString()
							+ " Nivel estudios: " + huesped.getNivelEstudio().toString();

					lista.add(persona);
				}
			}
		}

		return lista;
	}

	/**
	 * Verifica que no se repita persona en el listado de reservas con estrato y
	 * nivel de estudios por ciudada
	 * 
	 * @param persona
	 * @param lista
	 * @return
	 */
	public boolean verificarEstratoCiudadRepetido(String persona, ArrayList<String> lista) {

		for (int i = 0; i < lista.size(); i++) {

			if (persona.equals(lista.get(i))) {

				return true;

			}

		}

		return false;

	}

}
