package com.resonance.model.util;

import java.io.Serializable;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
public class MailSender implements Serializable {

	private static String usuario;
	private static String contraseña;
	private static String mensaje;
	private static String remitente;
	private static String asunto;

	public String getUsuario() {
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

	public static void enviarEncuestaSatisfacion(String remitente, String datos) {
		String urlEncuesta = "https://forms.gle/FCRAEnuKYgMEgbiq6";
		usuario = "resonance.snc@gmail.com";
		contraseña = "bceresonance.2629";
		asunto = "Encuesta de satisfación!";
		mensaje = "!Hola!\n Nos coplace que hayas culminado tu estancia, te invitamos a calificar tu estadía y la atención brindada.\n"
				+ datos + "\n Encuesta: " + urlEncuesta;

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", 587);

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(usuario, contraseña);

			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(usuario));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(remitente));
			message.setSubject(asunto);
			message.setText(mensaje);
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	public static void enviarCorreoBienvenida(String remitente, String datos) {
		usuario = "resonance.snc@gmail.com";
		contraseña = "bceresonance.2629";
		mensaje = "¡Te has registrado exitosamente!" + "\n\n" + datos + "\n\n"
				+ "Dirigete a al ménu principal para encontrar los hospedajes que más te gusten." + "\n\n"
				+ "Gracias por preferirnos.";
		asunto = "Bienvenido a ResonanceHome!";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", 587);

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(usuario, contraseña);

			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(usuario));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(remitente));
			message.setSubject(asunto);
			message.setText(mensaje);
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Metodo para enviar correo al huesped que realizó la reserva
	 * @param remitente correo electronico a donde se envia
	 * @param ruta ruta del documento
	 * @param nombreFile nombre del documento
	 */
	public static void enviarCorreoCompra(String remitente, String ruta, String nombreFile) {
		usuario = "resonance.snc@gmail.com";
		contraseña = "bceresonance.2629";
		mensaje = "¡Reserva Exitosa!" + "\n\n"
				+ "Te deseamos una feliz estadia, sigue disfrutando de nuestros servicios en nuestra página, también podrás observar todas tus facturas de las reservas y estadias realizadas"
				+ "\n\n" + "Gracias por preferirnos. Factura adjunta.";
		asunto = "Resonance Home ¡Disfruta tu estadia!";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", 587);

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(usuario, contraseña);

			}
		});

		try {

			BodyPart adjunto = new MimeBodyPart();
			BodyPart texto = new MimeBodyPart();
			adjunto.setDataHandler(new DataHandler(new FileDataSource(ruta)));
			adjunto.setFileName(nombreFile + ".pdf");
			texto.setText(mensaje);
			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(texto);
			multiParte.addBodyPart(adjunto);
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(usuario));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(remitente));
			message.setSubject(asunto);
			message.setContent(multiParte);

			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}


	public static boolean isValido(String correo) {
		// Patrón para validar el email
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		Matcher mather = pattern.matcher(correo);
		if (mather.find())
			return true;

		return false;
	}

}
