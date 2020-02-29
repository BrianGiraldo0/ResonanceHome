package com.resonance.util;

import java.util.ArrayList;
import java.util.Random;

import com.resonance.archivos.FileManager;

public class Util {

	
	public static ArrayList<String> listadoSugerencias  = new ArrayList<>();
	
	/**
	 *  Metodo que agrega una nueva localizacion en la aplicacion
	 * @param sugerencia 
	 */
	public static void agregarSugerencia(String sugerencia) {
		
		if (listadoSugerencias.size()!=0) {
			
			if(!listadoSugerencias.contains(sugerencia)) {
			
				listadoSugerencias.add(sugerencia);
			}
			
		}
		
		
	}
	
	public static String generarIDHospedaje() {
		String id ="";
		boolean is =true;
		Random r = new Random();
		while(is) {
			
			int i= r.nextInt(3000000 +1) + 9999999;

			id= i+"";
			if(!FileManager.idHospAlreadyExist(id))
			{
				is = false;
			}
		}
		
		
		return id;
	}
}
