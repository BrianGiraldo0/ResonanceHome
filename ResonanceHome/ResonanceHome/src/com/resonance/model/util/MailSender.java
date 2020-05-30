package com.resonance.model.util;

import java.io.Serializable;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

@SuppressWarnings("serial")
public class MailSender implements Serializable
{
	
	private String usuario;
	private String contraseña;
    private String mensaje;
    private String remitente;
    private String asunto;
    
	public MailSender() 
	{
		super();
		this.usuario  = "";
		this.contraseña = "";
	}

	public String getUsuario() 
	{
		return usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public String getMensaje() {
		return mensaje;
	}

	public String getRemitente() {
		return remitente;
	}

	public String getAsunto() {
		return asunto;
	}


	/* 
	String remitente -> correo electronico al cual se quiere mandar el correo
	String datos -> Datos que se anexan al mensaje del correo
	*/
    public void enviarCorreo(String remitente, String datos) 
    {
    	mensaje = "";
        asunto = "";
        
    	Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", 587);

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(usuario, contraseña);
                        
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(usuario));
            message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(remitente));
            message.setSubject(asunto);
            message.setText(mensaje);
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
	/* 
	String remitente -> correo electronico al cual se quiere mandar el correo
	String ruta -> Ruta del documento el cual se quiere enviar (PDF)
	String nombreFile -> Nombre con el cual el documento aparecerá en el mensaje
	*/
    public void enviarCorreoDocumento(String remitente, String ruta, String nombreFile) 
    {
    	mensaje = "";
        asunto = "";
        
        
    	Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", 587);

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(usuario, contraseña);
                        
                    }
                });

        try {

        	BodyPart adjunto = new MimeBodyPart();
        	BodyPart texto = new MimeBodyPart();
        	adjunto.setDataHandler(new DataHandler(new FileDataSource(ruta)));
        	adjunto.setFileName(nombreFile);
        	texto.setText(mensaje);
        	MimeMultipart multiParte = new MimeMultipart();
        	multiParte.addBodyPart(texto);
        	multiParte.addBodyPart(adjunto);
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(usuario));
            message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(remitente));
            message.setSubject(asunto);
            message.setContent(multiParte);
         

            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
