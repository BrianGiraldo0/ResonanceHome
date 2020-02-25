package com.resonance.util;

import java.util.Random;

import com.resonance.archivos.FileManager;

public class Util {

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
