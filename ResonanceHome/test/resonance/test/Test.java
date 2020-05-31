package resonance.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.GeneralSecurityException;
import java.util.ArrayList;

import com.resonance.model.archivos.FileManager;
import com.resonance.model.hospedajes.Calificacion;

import RStatistics.RStatistics;
import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class Test extends Application {

	public static void main(String[] args) throws IOException, GeneralSecurityException {

		String[][] cali = RStatistics.obtenerRespuestas();
		ArrayList<Calificacion> sta = new ArrayList<Calificacion>();

		int limpieza = 0;
		int profesionalismo = 0;
		int atencion = 0;
		int ubicacion = 0;
		for (int i = 0; i < cali.length; i++) {
			limpieza = Integer.parseInt(cali[i][4]);
			profesionalismo = Integer.parseInt(cali[i][5]);
			atencion = Integer.parseInt(cali[i][6]);
			ubicacion = Integer.parseInt(cali[i][7]);
			Calificacion c = new Calificacion(limpieza, profesionalismo, atencion, ubicacion);
			sta.add(c);
		}

		for (int i = 0; i < sta.size(); i++) {
			System.out.println(sta.get(i));
		}

	}
	
	public static void copy(String orgen, String destino) {
		destino += "hola.png";
		File fileDestino = new File(destino);
		try {
			Files.copy(Paths.get(orgen), Paths.get(fileDestino.getAbsolutePath()), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FileChooser fileChooser = new FileChooser();

		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Archivos de imagen", "*.jpg", "*.png")

		);

		File selectedFile = fileChooser.showOpenDialog(primaryStage);

		copy(selectedFile.getAbsolutePath(), FileManager.disco() + "ResonanceHome/");

	}

}
