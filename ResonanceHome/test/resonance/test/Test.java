package resonance.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.GeneralSecurityException;
import java.util.TreeSet;

import com.resonance.model.archivos.FileManager;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class Test extends Application {

	public static void main(String[] args) throws IOException, GeneralSecurityException {

		ObservableSet<String> obserble = FXCollections.observableSet(new TreeSet<>());
		obserble.add("hola");
		obserble.add("add");

		for (String a : obserble) {
			System.out.println(a);
		}

//		launch(args);

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
