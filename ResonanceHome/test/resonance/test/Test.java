package resonance.test;

import java.io.IOException;
import java.security.GeneralSecurityException;

import RStatistics.RStatistics;


public class Test {

	public static void main(String[] args) throws IOException, GeneralSecurityException {

	String[][] matriz = RStatistics.obtenerRespuestas();
	
	
	for (int x=0; x < matriz.length; x++) {
		  System.out.print("|");
		  for (int y=0; y < matriz[x].length; y++) {
		    System.out.print (matriz[x][y]);
		    if (y!=matriz[x].length-1) System.out.print("\t");
		  }
		  System.out.println("|");
		}
	}

}
