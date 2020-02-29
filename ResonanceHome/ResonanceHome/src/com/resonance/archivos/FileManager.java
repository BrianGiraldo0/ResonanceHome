package com.resonance.archivos;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class FileManager {
	public static String urlMain = disco() + "/ResonanceHome";
	private static String urlHospedajes = urlMain + "/Hospedajes";

	/**
	 * Metodo que incializa las carpetas
	 */
	public static void inicializar() {
		File file = new File(urlMain + "/Usuarios/Anfitriones");
		if (!file.exists()) {
			file.mkdirs();
		}

		File file1 = new File(urlMain + "/Usuarios/Huespedes/Facturas");
		if (!file1.exists()) {
			file1.mkdirs();
		}

		File file2 = new File(urlMain + "/Datos");
		if (!file2.exists()) {
			file2.mkdirs();
		}
	}

	/**
	 * Método para serializar el objeto que entra como párametro del mismo.
	 * 
	 * @param pPasajero Objeto a serializar.
	 */
//	public static void serializarGrafo(RedDeUsuarios red) {
//		try {
//
//			FileOutputStream fos = new FileOutputStream(disco() + "Resonance/Datos/Data.dat");
//			ObjectOutputStream oos = new ObjectOutputStream(fos);
//			oos.writeObject(red);
//			oos.close();
//			fos.close();
//		}
//
//		catch (IOException ioe) {
//			ioe.printStackTrace();
//		}
//
//	}

	
	/**
	 * Metodo que crea una carpeta para un huesped nuevo
	 * 
	 * @param name
	 */
	public static void crearCarpetaHuesped(String name) {
		File file = new File(urlMain + "/Usuarios/Huespedes" + name);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	/**
	 * Metodo que crea una carpeta para un anfitrion nuevo
	 * 
	 * @param name
	 */
	public static void crearCarpetaAnfitrion(String name) {
		File file = new File(urlMain + "/Usuarios/Anfitriones/" + name);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	/**
	 * Metodo que verifica que exista un anfitrion con el nombre ingresado dentro de
	 * los archivos
	 * 
	 * @param name
	 * @return
	 */
	public static boolean existAnfitrion(String name) {
		File file = new File(urlMain + "/Usuarios/Anfitriones" + name + "/" + name + ".dat");
		if (file.exists()) {
			return true;
		}

		return false;
	}

	/**
	 * Metodo que verifica que exista un huesped con el nombre ingresado dentro de
	 * los archivos
	 * 
	 * @param name
	 * @return
	 */
	public static boolean existHuesped(String name) {
		File file = new File(urlMain + "/Usuarios/Huespedes" + name + "/" + name + ".dat");
		if (file.exists()) {
			return true;
		}

		return false;
	}

	/**
	 * Metodo que verifica que existan datos para la aplicacion
	 * 
	 * @return
	 */
	public static boolean existData() {
		File file = new File(disco() + "ResonanceHome/Datos/Data.dat");
		if (file.exists()) {
			return true;
		}

		return false;
	}

	/**
	 * Metodo que permite agregar un nuevo hospedaje
	 * 
	 * @param idHos
	 * @param nameTagOwner
	 * @param urlsFotos
	 */
	public static void agregarHospedaje(String idHos, String nameTagOwner, ArrayList<String> urlsFotos) {
		File nuHosp = new File(urlHospedajes + "/idHos");
		if (!nuHosp.exists()) {
			nuHosp.mkdirs();
		}

		for (int i = 0; i < urlsFotos.size(); i++) {
			File fileDestino = new File(urlsFotos.get(i));
			try {
				Files.copy(Paths.get(nuHosp.getAbsolutePath()), Paths.get(fileDestino.getAbsolutePath()),
						StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static boolean idHospAlreadyExist(String id) {
		File file = new File(urlHospedajes);
		File[] files = file.listFiles();
		for (int i = 0; i < file.listFiles().length; i++) {
			if (files[i].getName().equals(id)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * metodo que obtiene el id de un usuario de una direccion url
	 * 
	 * @param fileName
	 * @return
	 */
	public static String obtenerIdUser(String fileName) {

		return fileName.substring(0, fileName.length() - 4);
	}

//	public static RedDeUsuarios deserializarGrafo() {
//
//		RedDeUsuarios grafo = null;
//
//		try {
//			FileInputStream fis = new FileInputStream(disco() + "Resonance/Datos/Data.dat");
//			ObjectInputStream ois = new ObjectInputStream(fis);
//			grafo = (RedDeUsuarios) ois.readObject();
//			ois.close();
//			fis.close();
//		}
//
//		catch (IOException ioe) {
//			ioe.printStackTrace();
//		}
//
//		catch (ClassNotFoundException cnfe) {
//			cnfe.printStackTrace();
//		}
//		return grafo;
//	}

	/**
	 * Metodo que permite cambiar la foto de perfil de un usuario
	 * 
	 * @param file
	 * @param username
	 */
	public static void cambiarFotoPerfil(File file, String username) {
		if (existAnfitrion(username)) {
			File fileDestino = new File(urlMain + "/Usuarios/Anfitriones" + username + "/FotoPerfil.png");
			try {
				Files.copy(Paths.get(file.getAbsolutePath()), Paths.get(fileDestino.getAbsolutePath()),
						StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			File fileDestino = new File(urlMain + "/Usuarios/Huespedes" + username + "/FotoPerfil.png");
			try {
				Files.copy(Paths.get(file.getAbsolutePath()), Paths.get(fileDestino.getAbsolutePath()),
						StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * Metodo que retorna el formato de una foto
	 * 
	 * @param file
	 * @return
	 */
	public static String getFormatoFoto(File file) {
		String name = file.getName();
		return name.substring(name.length() - 3, name.length());
	}

	/**
	 * metodo que retorna la direccion url de la foto de perfil de un usuario
	 * 
	 * @param user
	 * @return
	 */
	public static File getFotoPerfil(String user) {
		File foto = null;

		if (existAnfitrion(user)) {
			File carpetaUsuario = new File(urlMain + "/Usuarios/Anfitriones" + user);

			for (File v : carpetaUsuario.listFiles()) {
				if (v.getName().contains("FotoPerfil")) {
					return v;
				}
			}
		} else {
			File carpetaUsuario = new File(urlMain + "/Usuarios/Huespedes" + user);

			for (File v : carpetaUsuario.listFiles()) {
				if (v.getName().contains("FotoPerfil")) {
					return v;
				}
			}
		}

		return foto;
	}

//	public static RedDeUsuarios deserializarUser(String id) {
//
//		RedDeUsuarios user = null;
//
//		try {
//			FileInputStream fis = new FileInputStream(disco() + "Resonance/Usuarios/" + id + "/" + id + ".dat");
//			ObjectInputStream ois = new ObjectInputStream(fis);
//			user = (RedDeUsuarios) ois.readObject();
//			ois.close();
//			fis.close();
//		}
//
//		catch (IOException ioe) {
//			ioe.printStackTrace();
//		}
//
//		catch (ClassNotFoundException cnfe) {
//			cnfe.printStackTrace();
//		}
//		return user;
//	}

	/**
	 * Metodo que retorna la direccion url de la carpeta principal de un dispositivo
	 * 
	 * @return
	 */
	public static String disco() {
		String dp = System.getProperty("user.home");
		dp = dp.substring(0, 1);
		dp = dp + ":" + '/';
		return dp;
	}
}
