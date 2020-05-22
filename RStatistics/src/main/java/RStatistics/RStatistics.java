package RStatistics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;


public class RStatistics {
	 private static final String APPLICATION_NAME = "Resonance Statistics";
	    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	    private static final String TOKENS_DIRECTORY_PATH = "tokens";
	    private static final String SPREAD_ID = "1JvjImsSHhlerzZrvGypqUP4vwXfnh1jzuYDxoq-TUNs";
	    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS_READONLY);
	    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

	    
	    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
	        // Load client secrets.
	        InputStream in = RStatistics.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
	        if (in == null) {
	            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
	        }
	        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

	        // Build flow and trigger user authorization request.
	        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
	                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
	                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
	                .setAccessType("offline")
	                .build();
	        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
	        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
	    }
	    
	    
	    public static String[][] obtenerRespuestas() throws IOException, GeneralSecurityException
	    {
	    	String[][] respuestas;
	    	  // Build a new authorized API client service.
	        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
	        final String range = "respuestas!A2:G";
	        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
	                .setApplicationName(APPLICATION_NAME)
	                .build();
	        ValueRange response = service.spreadsheets().values()
	                .get(SPREAD_ID, range)
	                .execute();
	        List<List<Object>> values = response.getValues();
	        respuestas = new String[values.size()][values.get(0).size()];
	        if (values == null || values.isEmpty()) {
	            System.out.println("No se encontraron datos en la encuesta.");
	        } else {
	        	for(int i=0;i<values.size();i++){
	        		for(int j=0;j<values.get(i).size();j++) {
	        			respuestas[i][j] = (String) values.get(i).get(j);
	        		}
	   
	        	}
	        }
	        
	        return respuestas;
	    }
}
