package com.resonance.usuarios;

import java.util.ArrayList;
import java.util.Date;

import com.resonance.txt.Chat;

public class Usuario {

	private String nombre = "";
	private String email = "";
	private String URLFoto = "";
	private String direccion = "";
	private Date fechaNacimiento;
	private String contrasenia = "";
	private String biografia = "";
	private String nametag = "";
	private String id = "";
	private ArrayList<Chat> chats;

	/**
	 * Método constructor de la clase en caso de que se seleccione alguna foto
	 * 
	 * @param nombre          nombre del usuario en cuestion
	 * @param email           email del usuario en cuestion
	 * @param uRLFoto         direccion url del equipo donde se encuentra la foto
	 *                        que el usuario ha seleccionado
	 * @param direccion       direccion del lugar de domicilio de la persona
	 * @param fechaNacimiento fecha de nacimiento del usuario en cuestion
	 * @param contrasenia     contrasenia seleccionada para inicio de sesion del
	 *                        usuario
	 * @param biografia       breve descripcion del usuario
	 */
	public Usuario(String nombre, String email, String uRLFoto, String direccion, Date fechaNacimiento,
			String contrasenia, String biografia, String nameTag) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.URLFoto = uRLFoto;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.contrasenia = contrasenia;
		this.biografia = biografia;
		this.nametag = nameTag;
		chats = new ArrayList<>();
	}

	/**
	 * Método constructor de la clase en caso que no haya alguna foto seleccionada
	 * 
	 * @param nombre          nombre del usuario en cuestion
	 * @param email           email del usuario en cuestion
	 * @param uRLFoto         direccion url del equipo donde se encuentra la foto
	 *                        que el usuario ha seleccionado
	 * @param direccion       direccion del lugar de domicilio de la persona
	 * @param fechaNacimiento fecha de nacimiento del usuario en cuestion
	 * @param contrasenia     contrasenia seleccionada para inicio de sesion del
	 *                        usuario
	 * @param biografia       breve descripcion del usuario
	 */
	public Usuario(String nombre, String email, String direccion, Date fechaNacimiento, String contrasenia,
			String biografia, String nametag) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.contrasenia = contrasenia;
		this.biografia = biografia;
		this.nametag = nametag;
		chats = new ArrayList<>();
		// llenar con foto por defecto
	}

	/**
	 * Metodo que retorna el nombre del usuario
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo que permite cambiar el nombre del usuario
	 * 
	 * @param nombre nuevo nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * metodo que retorna el email del usuario
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Metodo que permite cambiar el email del usuario
	 * 
	 * @param email nuevo email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Metodo que retorna la direccion URL del equipo donde se encuentra la foto del
	 * usuario
	 * 
	 * @return
	 */
	public String getURLFoto() {
		return URLFoto;
	}

	/**
	 * Metodo que permite cambiar la foto de un usuario
	 * 
	 * @param uRLFoto nueva URL de la imagen
	 */
	public void setURLFoto(String uRLFoto) {
		URLFoto = uRLFoto;
	}

	/**
	 * Metodo que retorna la direccion de domicilio del usuario
	 * 
	 * @return
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Metodo que permite cambiar la direccion de domicilio del usuario
	 * 
	 * @param direccion nueva direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Metodo que retorna la fecha de nacimiento del usuario
	 * 
	 * @return
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Metodo que permite cambiar la fecha de nacimiento de un usuario
	 * 
	 * @param fechaNacimiento nueva fecha
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * Metodo que retorna la contrasenia del usuario
	 * 
	 * @return
	 */
	public String getContrasenia() {
		return contrasenia;
	}

	/**
	 * Metodo que permite cambiar la contrasenia de un usuario
	 * 
	 * @param contrasenia nueva contrasenia
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	/**
	 * Metodo que retorna una breve descripcion del usuario
	 * 
	 * @return
	 */
	public String getBiografia() {
		return biografia;
	}

	/**
	 * Metodo que permite cambiar la descripcion del usuario
	 * 
	 * @param biografia nueva descripcion
	 */
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	/**
	 * Metodo que retorna el nombre de usuario del usuario
	 * 
	 * @return
	 */
	public String getNametag() {
		return nametag;
	}

	/**
	 * Metodo que permite cambiar el nombre de usuario
	 * 
	 * @param nametag nuevo nombre de usuario
	 */
	public void setNametag(String nametag) {
		this.nametag = nametag;
	}

	/**
	 * Metodo que retorna el numero de identificacion del usuario
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * Metodo que permite cambiar el numero de identificacion del usuario
	 * 
	 * @param id nuevo id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Metodo que permite obtener el listado de chats del usuario
	 * 
	 * @return
	 */
	public ArrayList<Chat> getChats() {
		return chats;
	}

	/**
	 * Metodo que crea un nuevo chat
	 * 
	 * @param chat
	 */
	public void crearChat(Chat chat) {

		chats.add(chat);
	}
	
	/**
	 * Metodo que busca un chat segun usuario en especifico 
	 * @param nombre
	 * @return
	 */

	public Chat buscarChat(String nombre) {

		if (!nombre.equals(nombre)) {

			for (int i = 0; i < chats.size(); i++) {

				if (chats.get(i).esta(nombre)) {

					return chats.get(i);
				}

			}
		}
		return null;
	}

}
